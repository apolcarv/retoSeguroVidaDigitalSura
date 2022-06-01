package co.com.segVidaDigital.screenplay.ui;

import co.com.segVidaDigital.screenplay.helpers.Constant;
import co.com.segVidaDigital.screenplay.helpers.Date;
import co.com.segVidaDigital.screenplay.helpers.Utils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DatosPersonales extends PageObject {
    public static final String LOCALIZADOR_GENERAL_PREGUNTAS = "/label/span";

    public static final Target TXT_VALID_FRM_DATOS = Target.the("Valida que este dentro de la pagina para llenar el formulario de datos personales").located(By.xpath("//h3[contains(text(),'Queremos conocerte')]"));
    public static final Target INPUT_NOMBRES = Target.the("ingresa sus nombre completos").located(By.xpath("//input[@id='nombres']"));
    public static final Target INPUT_APELLIDOS = Target.the("ingresa sus apellidos completos").located(By.xpath("//input[@id='apellidos']"));
    public static final Target DROWNLIST_TIPO_DOCUMENTO = Target.the("despliega la lista de tipos de documentos").located(By.xpath("//select[@id='tipo-documento']"));
    public static final Target SELECT_TIPO_DOCUMENTO = Target.the("selecciona un tipo de documento").located(By.xpath("//*[@id='tipo-documento']//option[@value='" + Utils.obtenerTipoDocumento(Utils.obtenerNumeroRandomParaTipoDocGeneroYPreguntas()) + "']"));
    public static final Target INPUT_NUMERO_DOCUMENTO = Target.the("ingresa su numero de documento").located(By.xpath("//input[@id='numero-documento']"));
    public static final Target DATEPICKER_FECHA_EXPEDICION = Target.the("despliega el datepicker para seleccionar las fechas de expedicion").located(By.xpath("//input[@id='fecha-expedicion-numero-identificacion']"));
    public static final Target DROWNLIST_YEAR = Target.the("despliegue el campo año de expedicion").located(By.xpath("//select[@aria-label='Select year']"));
    public static final Target SELECT_YEAR = Target.the("selecciona el año de expedicion").located(By.xpath("//select[@aria-label='Select year']//option[@value='" + Date.obtenerYearAleatorio() + "']"));
    public static final Target DROWNLIST_MES = Target.the("despliegue el drownlist mes de expedicion").located(By.xpath("//select[@aria-label='Select month']"));
    public static final Target INPUT_PAIS_NACIMIENTO = Target.the("ingresa el pais de nacimiento").located(By.xpath("//input[@id='tomador-nacionalidad']"));
    public static final Target ITEM_PAIS_NACIMIENTO = Target.the("selecciona el pais de nacimiento").located(By.xpath("//span[@class='ngb-highlight ng-star-inserted']"));
    public static final Target DATEPICKER_FECHA_NACIMIENTO = Target.the("despliega el datepicker para seleccionar las fechas de nacimiento").located(By.xpath("//input[@id='fecha-nacimiento']"));
    public static final Target DROWNLIST_YEAR_NACIMIENTO = Target.the("despliegue el campo año de nacimiento").located(By.xpath("//select[@aria-label='Select year']"));
    public static final Target SELECT_YEAR_NACIMIENTO = Target.the("selecciona el año de nacimiento").located(By.xpath("//select[@aria-label='Select year']//option[@value='" + Date.obtenerYearPersonaAdulta() + "']"));
    public static final Target DROWNLIST_MES_NACIMIENTO = Target.the("despliegue el drownlist mes de nacimiento").located(By.xpath("//select[@aria-label='Select month']"));
    public static final Target DROWNLIST_GENERO = Target.the("despliega la lista de generos").located(By.xpath("//select[@id='genero']"));
    public static final Target SELECT_GENERO = Target.the("selecciona su genero").located(By.xpath("//*[@id='genero']//option[@value='" + Utils.obtenerTipoGenero(Utils.obtenerNumeroRandomParaTipoDocGeneroYPreguntas()) + "']"));
    public static final Target INPUT_CIUDAD_RESIDENCIA = Target.the("ingresa la ciudad de residencia").located(By.xpath("//input[@id='ciudad']"));
    public static final Target ITEM_CIUDAD_RESIDENCIA = Target.the("selecciona la ciudad de residencia").located(By.xpath("//span[@class='ngb-highlight ng-star-inserted']"));
    public static final Target INPUT_DIRECCION_RESIDENCIA = Target.the("ingresa la direccion de su residencia").located(By.xpath("//input[@id='direccion']"));
    public static final Target INPUT_NUMERO_CELULAR = Target.the("ingresa su numero de telefono movil").located(By.xpath("//input[@id='celular']"));
    public static final Target INPUT_CORREO_ELECTRONICO = Target.the("ingresa su correo electronico").located(By.xpath("//input[@id='correo']"));
    public static final Target RADIOBTN_PREGUNTA_UNO = Target.the("Selecciona si o no de acuerdo a la pregunta una realizada").located(By.xpath("//div[1]/div/div/app-input-check[" + Utils.obtenerNumeroRandomParaTipoDocGeneroYPreguntas() + "]" + LOCALIZADOR_GENERAL_PREGUNTAS + ""));
    public static final Target RADIOBTN_PREGUNTA_DOS = Target.the("Selecciona si o no de acuerdo a la pregunta dos realizada").located(By.xpath("//div[2]/div/div/app-input-check[" + Utils.obtenerNumeroRandomParaTipoDocGeneroYPreguntas() + "]" + LOCALIZADOR_GENERAL_PREGUNTAS + ""));
    public static final Target RADIOBTN_PREGUNTA_TRES = Target.the("Selecciona si o no de acuerdo a la pregunta tres realizada").located(By.xpath("//div[3]/div/div/app-input-check[" + Utils.obtenerNumeroRandomParaTipoDocGeneroYPreguntas() + "]" + LOCALIZADOR_GENERAL_PREGUNTAS + ""));
    public static final Target CHECKBOX_TYC = Target.the("acepta terminos y condiciones del seguro de vida digital").located(By.xpath("//div/div/div[2]/div/div[1]/app-input-check/label/span"));
    public static final Target BTN_COMPRAR_SEGURO = Target.the("pulsa el boton comprar").located(By.xpath("//button[@id='pagar-datos']"));

    private static List<WebElement> localizadorListMes() {
        String xpath = "//select[@aria-label='Select month']//option";
        return BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElements(By.xpath(xpath));
    }

    private static List<WebElement> localizadorListDía() {
        String xpath = "//div[@class='btn-light ng-star-inserted']";
        return BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElements(By.xpath(xpath));
    }

    public static List<WebElement> getlocalizadorListMes() {
        return localizadorListMes();
    }

    public static List<WebElement> getlocalizadorListDía() {
        return localizadorListDía();
    }


}
