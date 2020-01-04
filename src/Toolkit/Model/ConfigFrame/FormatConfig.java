package Toolkit.Model.ConfigFrame;

import com.alibaba.fastjson.JSONObject;

public class FormatConfig {
    private String name;
    private Long time;
    private String format;

    public FormatConfig() {
        name = "";
        time = System.currentTimeMillis();
        format = "";
    }

    public FormatConfig(String name, Long time, String format) {
        this.name = name;
        this.time = time;
        this.format = format;
    }

    public FormatConfig(JSONObject jsnFormCnf) {
        this.name = jsnFormCnf.getString(FormatConfigSchema.FORMAT_CONFIG_NAME);
        this.time = jsnFormCnf.getLong(FormatConfigSchema.FORMAT_CONFIG_TIME);
        this.format = jsnFormCnf.getString(FormatConfigSchema.FORMAT_CONFIG_FORMAT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "FormatConfig{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", format='" + format + '\'' +
                '}';
    }
}
