package co.com.segVidaDigital.screenplay.question;

import co.com.segVidaDigital.screenplay.helpers.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.TXT_VALID_FRM_DATOS;


public class TextValidDatos implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(TXT_VALID_FRM_DATOS, WebElementStateMatchers.containsText(Constant.TEXTO_PAG_CARGADA_FRM_DATOS))
                .forNoMoreThan(Constant.INTERMEDIATE).seconds());
        return true;
    }
    public static TextValidHome estoyEnElFrmDatos(){
        return new TextValidHome();
    }
}
