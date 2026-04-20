package com.framework.tests;

import com.framework.base.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.utils.ConfigReader;
import com.framework.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass {
    private LoginPage loginPage;

    @BeforeMethod
    public void init(){
        getDriver().get(ConfigReader.get("url"));
        loginPage = new LoginPage(getDriver());
    }
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        ExcelUtils excel = new ExcelUtils
                ("src/test/resources/Testdata.xlsx","Sheet1");
        int rows = excel.getRowCount();
        int cols = excel.getColCount();
        Object[][] data = new Object[rows][cols];

        for(int i = 0;i < rows;i++){
           for(int j = 0 ;j<cols;j++){
               data[i][j] = excel.getCellData(i,j);
           }
        }

        excel.closeFile();
        return data;

    }


    @Test(dataProvider = "LoginData")
    public void validLoginTest(String username,String password) {

        loginPage.login(username, password);
        Assert.assertEquals(getDriver().getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
    }
}
