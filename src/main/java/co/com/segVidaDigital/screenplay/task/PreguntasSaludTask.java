package co.com.segVidaDigital.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.*;

public class PreguntasSaludTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(RADIOBTN_PREGUNTA_UNO));
        actor.attemptsTo(Click.on(RADIOBTN_PREGUNTA_DOS));
        actor.attemptsTo(Click.on(RADIOBTN_PREGUNTA_TRES));
    }
    public static Performable respondePreguntas(){
        return Tasks.instrumented(PreguntasSaludTask.class);
    }
}
