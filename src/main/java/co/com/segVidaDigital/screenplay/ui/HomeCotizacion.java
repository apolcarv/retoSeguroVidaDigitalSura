package co.com.segVidaDigital.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeCotizacion extends PageObject {

    public static final Target TXT_VALID_SEGURO_VIDA_DIGITAL = Target.the("Valida el texto de la pagina seguro de vida digital")
            .located(By.xpath("//h4[contains(text(),'Seguro de Vida Digital')]"));

    public static final Target BTN_COMPRAR = Target.the("pulda el boton comprar")
            .located(By.xpath("//li//button[contains(text(),'COMPRAR')]"));
}
