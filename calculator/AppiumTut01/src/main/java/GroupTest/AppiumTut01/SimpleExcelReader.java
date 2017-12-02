package GroupTest.AppiumTut01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SimpleExcelReader {
	public static void main(String[] args) throws IOException {
        String excelFilePath = "F:/appium/data.xlsx";
        SimpleExcelReader reader = new SimpleExcelReader();
        List<data> listBooks = reader.readBooksFromExcelFile(excelFilePath);
        System.out.println(listBooks.size());
        for (int i=0; i<listBooks.size();i++)
        {
        System.out.print(listBooks.get(i).getKetqua()+ " ");
        System.out.println(listBooks.get(i).getPheptinh());
        }
    }
	 private Object getCellValue(Cell cell) {
	        switch (cell.getCellType()) {
	        case Cell.CELL_TYPE_STRING:
	            return cell.getStringCellValue();
	     
	        case Cell.CELL_TYPE_BOOLEAN:
	        {	
	            Boolean i = cell.getBooleanCellValue();
	            return i.toString(); // chuyển data đọc sang string vì mình sẽ chuyền kiểu string vào thiết bị.
	        }
	        case Cell.CELL_TYPE_NUMERIC:
	            int i= (int)cell.getNumericCellValue();
	            String s = String.valueOf(i);
	            return s;
	        }
	     
	        return null;
	    }
	    
	    public List<data> readBooksFromExcelFile(String excelFilePath) throws IOException {
	        List<data> listAccounts = new ArrayList<data>();
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	        // khai báo một file cần đọc và đường dẫn file
	        Workbook workbook = getWorkbook(inputStream, excelFilePath);
	        Sheet firstSheet = (Sheet) workbook.getSheetAt(0);// sử dụng sheet 0
	        Iterator<Row> iterator = firstSheet.iterator();
	     
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();// đọc theo row và từng cell
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	            data adata = new data();
	     
	            while (cellIterator.hasNext()) {
	                Cell nextCell = cellIterator.next();
	                int columnIndex = nextCell.getColumnIndex();
	     
	                switch (columnIndex) {
	  	                case 1:
	  	                	adata.setPheptinh((String) getCellValue(nextCell));
	                    break;
	                case 2:
	                	adata.setKetqua((String) getCellValue(nextCell));
	                	break;
	               
	                }
	     
	     
	            }
	            listAccounts.add(adata);
	        }
	     
	        workbook.close();
	        inputStream.close();
	     
	        return listAccounts;
	    }
	    
	    //Được sử dụng để có thể đọc được cả định dạng .xls và xlsx
	    private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
	            throws IOException {
	        Workbook workbook = null;
	     
	        if (excelFilePath.endsWith("xlsx")) {
	            workbook = new XSSFWorkbook(inputStream);// có 2 loại file excel cần đọc nên ta xét điều kiện để get book
	        } else if (excelFilePath.endsWith("xls")) {
	            workbook = new HSSFWorkbook(inputStream);
	        } else {
	            throw new IllegalArgumentException("The specified file is not Excel file");
	        }
	     
	        return workbook;
	    }

}
