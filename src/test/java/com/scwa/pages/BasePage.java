package com.scwa.pages;

import com.scwa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void chooseScwaMenu(String menu){
        Driver.get().findElement(By.xpath("(//ul[@id='menu-1-27085893'])[1]//a[text()='"+menu+"']")).click();
    }
}
