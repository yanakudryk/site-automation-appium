package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ActionWithWebElements {
    AppiumDriver driver;
    Logger logger;
    WebDriverWait wait;

    public ActionWithWebElements(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
        logger = Logger.getLogger(getClass());
    }

    public void inputText(WebElement element, String text){
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            element.clear();
            element.sendKeys(text);
            logger.info("Successful inputting " + text);
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during inputting " + text);
        }

    }
    public void clickButton(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            String getText = element.getText();
            element.click();
            logger.info("Successful clicking on " + getText);
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during clicking");
        }

    }
    public boolean isDisplayedElement(WebElement element){
        boolean result = false;
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            String getText = element.getText();
            result = element.isDisplayed();
            logger.info("Successful displaying checking displaying element " + getText);
            return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking displaying element");
            return result;
        }
    }
    public void selectElementFromDropDown(WebElement element, String value){
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            Select dropDownValue = new Select(element);
            dropDownValue.selectByVisibleText(value);
            logger.info("Successful selecting from drop down value " + value);
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during selecting from drop down");
        }

    }

    public void setCheckBox(WebElement element, Boolean state){
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            String getText = element.getText();
            if(state){
                if(!element.isSelected()){
                    element.click();
                }
            }
            if(!state){
                if(element.isSelected()){
                    element.click();
                }
            }
            logger.info("Successful setting check-box " + getText + " to state " + state);
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking check-box.");
        }
    }

    public String getText(WebElement element){
        String result = null;
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            result = element.getText();
            logger.info("Successful getting text " + result);
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during getting text.");
        }
        return result;
    }

    public boolean isElementSelected(WebElement element){
        boolean result = false;
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            String getText = element.getText();
            if (element.isSelected()){
                result = true;
            }
            logger.info("Successful checking if element " + getText + "is selected");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking if element is selected");
        }
        return result;
    }

    public boolean isElementEnabled(WebElement element){
        boolean result = false;
        try{
            if (element.isEnabled()){
                result = true;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking if element is enabled");
        }
        return result;
    }
    public void selectRadioButton(List<WebElement> elements, String text){
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            List<WebElement> radioButtons = elements;
            int numberOfRadioButtons = radioButtons.size();
            for (int i = 0; i < numberOfRadioButtons; i++) {
                if (radioButtons.get(i).getAttribute("value").equals(text)) {
                    if (!radioButtons.get(i).isSelected()) {
                        radioButtons.get(i).click();
                    }
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during selection Radio Button");
        }

    }
}