package lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class Wyniki extends AbstractTableModel {
	
	//List list;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	
	///////
	private static final int COLUMN_NO      = 0;
    private static final int COLUMN_NAME    = 1;
    private static final int COLUMN_WYNIK   = 2;
    
     
    private String[] columnNames = {"#no", "Imie", "Wynik"};
    private List<Wynik> listWyniki;
     
    public Wyniki(List<Wynik> listWyniki) {
        this.listWyniki = listWyniki;
         
        int indexCount = 1;
        for (Wynik w : listWyniki) {
            w.setIndex(indexCount++);
        }
    }
 
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount() {
        return listWyniki.size();
    }
     
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
     
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listWyniki.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Wynik wynik = listWyniki.get(rowIndex);
        Object returnValue = null;
         
        switch (columnIndex) {
        case COLUMN_NO:
            returnValue = wynik.getIndex();
            break;
        case COLUMN_NAME:
            returnValue = wynik.getImie();
            break;
        case COLUMN_WYNIK:
            returnValue = wynik.getWynik();
            break;
        
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
         
        return returnValue;
    }
     
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Wynik employee = listWyniki.get(rowIndex);
        if (columnIndex == COLUMN_NO) {
            employee.setIndex((int) value);
        }      
    }

}
