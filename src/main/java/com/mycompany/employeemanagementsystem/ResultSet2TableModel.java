package com.mycompany.employeemanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/*This exact same functionality can be achieved by rs2xml.jar lib but here i
added this code bcz the maven pom.xml file was giving error and was unable to
load rs2xml.jar lib*/
public class ResultSet2TableModel extends AbstractTableModel {

    private ResultSet rs;
    private Vector<Vector<Object>> data = new Vector<>();
    private Vector<String> columnNames = new Vector<>();

    public ResultSet2TableModel(ResultSet rs) throws SQLException {
        this.rs = rs;
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(rs.getMetaData().getColumnName(i));
        }
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
}
