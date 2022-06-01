package co.com.segVidaDigital.screenplay.helpers;

public class Constant {
    private Constant() {
    }
    /** SCREENPLAY */
    public static final String MR_ROBOT = "apolcarv";
    public static final String PAGINA_WEB_URL = "environments.default.webdriver.base.url";

    /** TIEMPOS DE ESPERAS */
    public static final int LONG = 60;
    public static final int MIDDLE = 20;
    public static final int INTERMEDIATE = 10;
    public static final int SHORT = 5;

    /** TEXTO ESPERADOS A VALIDAR */
    public static final String TEXTO_PAG_CARGADA_HOME = "Seguro de Vida Digital";
    public static final String TEXTO_PAG_CARGADA_FRM_DATOS = "Queremos conocerte";
    public static final String TEXTO_PAG_CARGADA_PAGOS = "Lo sentimos";

    /** TIPO DE DOCUMENTOS */
    public static final String CEDULA_EXTRANGERIA = "CE";
    public static final String CEDULA_CIUDADANIA = "CC";

    /** TIPO DE GENERO */
    public static final String HOMBRE = "Masculino";
    public static final String MUJER = "Femenino";

    /** FRM DATOS PERSONALES */
    public static final String PRIMER_DIGITO = "1";
    public static final int DIGITO_1 = 1;
    public static final int DIGITO_0 = 0;
    public static final int DIGITO_NUEVE = 9;
    public static final int DIGITO_SIETE = 7;
    public static final int DIGITO_NUEVE_NUEVE = 99;
    public static final String PAIS = "Colombia";
    public static final String TRES_PRIMEROS_DIGITOS = "322";

    /** DATE AÑOS  */
    public static final int YEAR_INICIAL = 1960;
    public static final int YEAR_A_RESTAR = 19;

    /** DATE MESES */
    public static final int N_MESES = 12;

    /** DATE DIAS */
    public static final int DATO_DIA_INICIAL = 1;
    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int DATO_DIA_FINAL = 31;

    /** LOCALIZADORES */
    public static final String LOCALIZADOR_DATEPICKER_MES = "//select[@aria-label='Select month']//option";



}
