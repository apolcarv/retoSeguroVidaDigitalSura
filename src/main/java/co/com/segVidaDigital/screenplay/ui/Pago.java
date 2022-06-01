package co.com.segVidaDigital.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Pago extends PageObject {
    public static final Target TXT_VALID_POUP_COMPRA_EXITOSA = Target.the("Valida que salga el poUp exitoso") .located(By.xpath("//h4[@class='modal-error-detalle-salud__title']"));


}
