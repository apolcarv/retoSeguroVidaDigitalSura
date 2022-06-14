package co.com.segVidaDigital.screenplay.helpers;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.io.File;
import java.util.*;
import static co.com.segVidaDigital.screenplay.helpers.Constant.*;
import static co.com.segVidaDigital.screenplay.helpers.WebActions.click;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.getlocalizadorListDía;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.getlocalizadorListMes;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Utils {

    private Utils() {
    }

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());
    private static final String MENSAJE_FALLO_GENERAL = "No se reconoce el numero para tomar alguna de las dos opciones ";
    private static final List<String> datosDirecciones = new ArrayList<>();
    private static final List<String> datosCiudades = new ArrayList<>();
    private static final String LOG_CLASE = "Utils -> ";
    private static int numeroRandomMes;
    private static int numRandomDia;

    public static int obtenerNumeroRandomParaTipoDocGeneroYPreguntas() {
        return faker.number().numberBetween(UNO, DOS);
    }

    public static String obtenerTipoDocumento(int documentoNum) {
        String tipoDocumento;
        switch (documentoNum) {
            case 1:
                tipoDocumento = Constant.CEDULA_EXTRANGERIA;
                return tipoDocumento;
            case 2:
                tipoDocumento = Constant.CEDULA_CIUDADANIA;
                return tipoDocumento;
            default:
                ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL);
                return null;
        }
    }

    public static String obtenerTipoGenero(int generoNum) {
        String tipoGenero;
        switch (generoNum) {
            case 1:
                tipoGenero = Constant.HOMBRE;
                return tipoGenero;
            case 2:
                tipoGenero = Constant.MUJER;
                return tipoGenero;
            default:
                ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL);
                return null;
        }
    }

    public static List<String> generarCiudades() {
        datosCiudades.add(faker.options().option("BOGOTA", "MEDELLIN", "CALI", "BUCARAMANGA", "PASTO", "VALLEDUPAR", "SANTAMARTA", "BARRANQUILLA", "SOLEDAD"));
        ManagerLog.imprimirExito(LOG_CLASE + "la generacion de la direccion  se genero exitosamente");
        return datosCiudades;
    }

    public static List<String> generarTipoDeDirecciones() {
        datosDirecciones.add(faker.options().option("CALLE", "CARRERA", "AVENIDA", "CIRCULAR", "DIAGONALES", "TRANVERSAL"));
        ManagerLog.imprimirExito(LOG_CLASE + "la generacion de la direccion  se genero exitosamente");
        return datosDirecciones;
    }

    public static int numRandomlocalizadorListMes() {
        numeroRandomMes = faker.number().numberBetween(1, getlocalizadorListMes().size());
        return  numeroRandomMes;
    }

    public static void obtenerNumeroRandonParaSeleccionarUnMesHabilitado() {
        click(getlocalizadorListMes().get(numRandomlocalizadorListMes()));
    }

    public static int numRandomlocalizadorListDía() {
         numRandomDia = faker.number().numberBetween(DATO_DIA_INICIAL, getlocalizadorListDía().size());
        return numRandomDia;
    }

    public static void obtenerNumeroRandonParaSeleccionarUnDiaHabilitado_Expedicion_nacimiento() {
       click(getlocalizadorListDía().get(numRandomlocalizadorListDía()));
    }


    public static void obtenerNumeroRandonParaSeleccionarMesNacimiento() {
        int numRandom = faker.number().numberBetween(UNO, DOS);
        int sumaMesRandom = numeroRandomMes + numRandom;
        if (sumaMesRandom > Constant.N_MESES) {
            int numRestado = sumaMesRandom - numRandom;
            String xpathRandomMes = Constant.LOCALIZADOR_DATEPICKER_MES + "[" + numRestado + "]";
            BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElement(By.xpath(xpathRandomMes)).click();
        } else {
            String xpathRandomMes = Constant.LOCALIZADOR_DATEPICKER_MES + "[" + sumaMesRandom + "]";
            BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElement(By.xpath(xpathRandomMes)).click();
        }
    }


}
