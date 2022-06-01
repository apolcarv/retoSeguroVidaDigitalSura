package co.com.segVidaDigital.screenplay.interaction;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickInteraction;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.BTN_COMPRAR_SEGURO;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.CHECKBOX_TYC;
import static co.com.segVidaDigital.screenplay.ui.HomeCotizacion.BTN_COMPRAR;


public class Interacciones {

    private Interacciones() {
    }

    public static ClickInteraction clicBotonComprar(){
        return Click.on(BTN_COMPRAR);
    }

    public static ClickInteraction clicAceptaTyC(){
        return Click.on(CHECKBOX_TYC);
    }

    public static ClickInteraction clicBotonComprarSeguroVidaDigital(){
        return Click.on(BTN_COMPRAR_SEGURO);
    }

}
