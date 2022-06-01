package co.com.segVidaDigital.screenplay.question;

import co.com.segVidaDigital.screenplay.helpers.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.segVidaDigital.screenplay.ui.HomeCotizacion.TXT_VALID_SEGURO_VIDA_DIGITAL;

public class TextValidHome implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(TXT_VALID_SEGURO_VIDA_DIGITAL, WebElementStateMatchers.containsText(Constant.TEXTO_PAG_CARGADA_HOME))
                .forNoMoreThan(Constant.INTERMEDIATE).seconds());
        return true;
    }

    public static TextValidHome paginaDeSegurosVidaDigital(){
        return new TextValidHome();
    }
}
