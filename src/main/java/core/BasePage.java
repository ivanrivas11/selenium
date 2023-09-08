package core;

import java.io.*;
import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BasePage {
	
	//Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Driver
	protected WebDriver driver;
	
	/**
     * Retreives value selected
     * @return value
     */
    public String getValueJSON(String path, String param){

        JSONParser parser = new JSONParser();
        String value ="";
        System.out.println("Trying to get value of "+param+"...");
        try {

            Object obj = parser.parse(new FileReader(path));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            value = (String) jsonObject.get(param);

        } catch (Exception e) {
            System.out.println("Entró al catch");
            e.printStackTrace();
        }
        System.out.println("Value obtanied: "+ value);
        return value;
    }

    /**
     * Get value from excel method
     * @param filename - File name
     * @param value - Value to look for
     * @return value to use
     */
    public String getValueFromExcel(String filename, String value){
        try{
            //Getting excel file
            FileInputStream file = new FileInputStream(filename);

            //Getting WorkBook
            //Workbook wb = new HSSFWorkbook(file); - old excel format .xls
            Workbook wb = new XSSFWorkbook(file); //.xlsx

            //Getting sheet
            Sheet sheet = wb.getSheet("Sheet1");

            //Getting row
            Row row = sheet.getRow(0);

            //Column
            int colNum = 0;
            String valueFromExcel = null;

            //Getting cell
            for(int i = 0; i < row.getLastCellNum(); i++){
                if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(value)){
                    colNum = i;
                    System.out.println("Value found!");
                    break;
                }
            }

            row = sheet.getRow(1);
            valueFromExcel = row.getCell(colNum).getStringCellValue();
            if(!valueFromExcel.isEmpty())
                System.out.println("Value from excel: "+valueFromExcel);
            else
                System.out.println("Value NOT found.");
            return valueFromExcel;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Take screenshot of the page
     * @param name - Name of the file
     * @throws IOException - Exception
     */
    public void takeScreenShot(String path, String name) throws IOException {

        System.out.println("Capturing the snapshot of the page...");
        File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       
        
        try {
            FileHandler.copy(srcFiler, new File(path+name));
            System.out.println("Captura de pantalla guardada en: " + path+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
