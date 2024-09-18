package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testData\\Opencart_LoginData.xlsx";
        ExcelUtility ex = new ExcelUtility(path);

        int rc = ex.getRowCount("sheet1");
        int cc = ex.getCellCount("sheet1",1);

        String logindata[][] = new String[rc][cc];

        for(int i=1; i<=rc; i++){
            for(int j=0; j<cc; j++){
                logindata[i-1][j] = ex.getCellData("sheet1", i, j);
            }
        }
        return logindata;
    }
}
