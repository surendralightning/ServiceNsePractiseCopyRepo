package wrappers;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	
	//@DataProvider(name="Data5")

@DataProvider(name="fetchData")
	
	public static String[][] retreiveData(String getSheetName) throws IOException{
		
		String[][] testdata;
		FileInputStream fis=new FileInputStream("./Resource/"+getSheetName+".xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		int columncount =sheet.getRow(0).getLastCellNum();
		testdata=new String[rowcount][columncount];
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columncount;j++)
			{
				String cellValue=row.getCell(j).getStringCellValue();
				testdata[i-1][j]=cellValue;
				
			}

		}
		
		return testdata;
	

	
	}
	
		
	}


