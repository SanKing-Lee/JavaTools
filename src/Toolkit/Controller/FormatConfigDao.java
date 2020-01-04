package Toolkit.Controller;

import Toolkit.Model.ConfigFrame.FormatConfig;
import Toolkit.Model.ConfigFrame.FormatConfigSchema;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FormatConfigDao {
    private static final Logger LOG = Logger.getInstance();

    private static final String FORMAT_CONFIG_FILE_NAME = "FormatConfig.json";
    private static FormatConfigDao mInstance;
    private List<FormatConfig> formatConfigs;

    private FormatConfigDao() {
        formatConfigs = new ArrayList<>();
        loadFormatConfig();
    }

    public static FormatConfigDao getInstance() {
        if(mInstance == null) {
            mInstance = new FormatConfigDao();
        }
        return mInstance;
    }

    private void loadFormatConfig() {
        File formatConfigFile = new File(FORMAT_CONFIG_FILE_NAME);
        if(!formatConfigFile.exists())
        {
            try {
                if(!formatConfigFile.createNewFile()){
                    LOG.error("Create File Failed!");
                    return;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(formatConfigFile));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = fileReader.readLine()) != null) {
                sb.append(line);
            }
            JSONArray jsnArrayFormatConfig = JSON.parseArray(sb.toString());
            LOG.info("Loading format config from file: ");
            for (Object config : jsnArrayFormatConfig) {
                JSONObject obj = (JSONObject)config;
                FormatConfig fc = new FormatConfig(obj);
                LOG.info(fc.toString());
                formatConfigs.add(fc);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<FormatConfig> getFormatConfigs() {
        return formatConfigs;
    }

    public void addFormatConfig(FormatConfig fc) {
        if(existFormatConfig(fc.getName())) {
            return;
        }
        LOG.info("Adding new format config: " + fc.toString());
        formatConfigs.add(fc);
        saveFormatConfig();
    }

    public void deleteFormatConfig(String name) {
        if(!existFormatConfig(name)) {
            return;
        }
        FormatConfig delFc = findFormatConfig(name);
        LOG.info("Removing format config: " + delFc.toString());
        formatConfigs.remove(delFc);
        saveFormatConfig();
    }

    public void updateFormatConfig(FormatConfig fc, String oldName) {
        LOG.info("Updating format config: ");
        FormatConfig toUpdate = findFormatConfig(oldName);
        LOG.info("To update: " + toUpdate);
        formatConfigs.set(formatConfigs.indexOf(toUpdate), fc);
        LOG.info("After update: " + fc);
        saveFormatConfig();
    }

    public boolean existFormatConfig(String name) {
        return findFormatConfig(name) != null;
    }

    public FormatConfig findFormatConfig(String name) {
        for(FormatConfig fc: formatConfigs) {
            if(fc.getName().equals(name)) {
                return fc;
            }
        }
        return null;
    }

    public void saveFormatConfig() {
        File formatConfigFile = new File(FORMAT_CONFIG_FILE_NAME);
        if(!formatConfigFile.exists())
        {
            try {
                if(!formatConfigFile.createNewFile()){
                    LOG.error("Create File Failed!");
                    return;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        try {
            LOG.info("Saving format config to file: ");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(formatConfigFile, false));
            String str = JSON.toJSONString(formatConfigs);
            LOG.info(str);
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
