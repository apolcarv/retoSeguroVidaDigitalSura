package co.com.segVidaDigital.screenplay.question;

import co.com.segVidaDigital.screenplay.helpers.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.segVidaDigital.screenplay.ui.Pago.TXT_VALID_POUP_COMPRA_EXITOSA;

public class TextValidCompra implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(TXT_VALID_POUP_COMPRA_EXITOSA, WebElementStateMatchers.containsText(Constant.TEXTO_PAG_CARGADA_PAGOS))
                .forNoMoreThan(Constant.INTERMEDIATE).seconds());
        return true;
    }
    public static TextValidCompra compraExitosa(){
        return new TextValidCompra();
    }
}
