
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class AccountTableModel extends AbstractTableModel {
    String[] header;
    int[] indexes;
    Vector<AccountDTO> data = new Vector<>();

    public AccountTableModel(String[] header, int[] indexes) {
        this.header = header;
        this.indexes = indexes;
    }

    public Vector<AccountDTO> getData() {
        return data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex<0 || rowIndex>=getRowCount() || columnIndex<0 || columnIndex>=getColumnCount()) return null;
        AccountDTO dto = data.get(rowIndex);
        switch (indexes[columnIndex]) {
            case 0: return dto.id;
            case 1: return dto.name;
            case 2: return dto.address;
            case 3: return dto.isMale;
            case 4: return dto.salary;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int c) {
        if (c<0 || c>=getColumnCount()) return "";
        return header[c];
    }
}
