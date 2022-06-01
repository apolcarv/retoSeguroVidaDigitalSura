package co.com.segVidaDigital.screenplay.helpers;


import org.openqa.selenium.WebElement;


public class WebActions {


    private WebActions() {
    }

    public static void click(WebElement element) {
        final String ACTION = "click";
        try {
            element.click();
        } catch (Exception e) {
            ManagerLog.imprimirFallo(ACTION + AssertExceptions.getErrorStackTrace(e));
        }
    }

}
