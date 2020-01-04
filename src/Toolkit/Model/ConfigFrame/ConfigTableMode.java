package Toolkit.Model.ConfigFrame;

import Toolkit.Controller.FormatConfigDao;
import Toolkit.Controller.Logger;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.util.List;

public class ConfigTableMode extends AbstractTableModel {
    private int rowCount;
    private int columnCount;
    private final String[] columns = {"名称", "修改日期"};
    private List<FormatConfig> formatConfigs;
    private static final Logger log = Logger.getInstance();

    public ConfigTableMode() {
        formatConfigs = FormatConfigDao.getInstance().getFormatConfigs();
    }

    @Override
    public int getRowCount() {
        return formatConfigs.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return formatConfigs.get(rowIndex).getName();
            case 1:
                return DateFormat.getDateTimeInstance().format(formatConfigs.get(rowIndex).getTime());
            default:
                return "";
        }
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
        log.info("Table data changed");
    }
}
