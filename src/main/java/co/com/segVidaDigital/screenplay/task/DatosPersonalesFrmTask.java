package co.com.segVidaDigital.screenplay.task;

import co.com.segVidaDigital.screenplay.helpers.Constant;
import co.com.segVidaDigital.screenplay.helpers.Utils;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.util.Locale;
import java.util.Random;
import static co.com.segVidaDigital.screenplay.helpers.Utils.*;
import static co.com.segVidaDigital.screenplay.ui.DatosPersonales.*;


public class DatosPersonalesFrmTask implements Task {

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(faker.name().firstName()).into(INPUT_NOMBRES));
        actor.attemptsTo(Enter.theValue(faker.name().lastName()).into(INPUT_APELLIDOS));
        actor.attemptsTo(Click.on(DROWNLIST_TIPO_DOCUMENTO));
        actor.attemptsTo(Click.on(SELECT_TIPO_DOCUMENTO));
        actor.attemptsTo(Enter.theValue(Constant.PRIMER_DIGITO+faker.number().digits(Constant.DIGITO_NUEVE)).into(INPUT_NUMERO_DOCUMENTO));
        actor.attemptsTo(Click.on(DATEPICKER_FECHA_EXPEDICION));
        actor.attemptsTo(Click.on(DROWNLIST_YEAR));
        actor.attemptsTo(Click.on(SELECT_YEAR));
        actor.attemptsTo(Click.on(DROWNLIST_MES));
        obtenerNumeroRandonParaSeleccionarUnMesHabilitado();
        obtenerNumeroRandonParaSeleccionarUnDiaHabilitado_Expedicion_nacimiento();
        actor.attemptsTo(Enter.theValue(Constant.PAIS).into(INPUT_PAIS_NACIMIENTO));
        actor.attemptsTo(Click.on(ITEM_PAIS_NACIMIENTO));
        actor.attemptsTo(Click.on(DATEPICKER_FECHA_NACIMIENTO));
        actor.attemptsTo(Click.on(DROWNLIST_YEAR_NACIMIENTO));
        actor.attemptsTo(Click.on(SELECT_YEAR_NACIMIENTO));
        actor.attemptsTo(Click.on(DROWNLIST_MES_NACIMIENTO));
        obtenerNumeroRandonParaSeleccionarMesNacimiento();
        obtenerNumeroRandonParaSeleccionarUnDiaHabilitado_Expedicion_nacimiento();
        actor.attemptsTo(Click.on(DROWNLIST_GENERO));
        actor.attemptsTo(Click.on(SELECT_GENERO));
        actor.attemptsTo(Enter.theValue(Utils.generarCiudades().get(Constant.DIGITO_0)).into(INPUT_CIUDAD_RESIDENCIA));
        actor.attemptsTo(Click.on(ITEM_CIUDAD_RESIDENCIA));
        String direccion = ""+Utils.generarTipoDeDirecciones().get(Constant.DIGITO_0)+" "+faker.number().numberBetween(Constant.DIGITO_1,Constant.DIGITO_NUEVE_NUEVE)+" "+"#"+" "+faker.number().numberBetween(Constant.DIGITO_1,Constant.DIGITO_NUEVE_NUEVE)+" - "+faker.number().numberBetween(Constant.DIGITO_1,Constant.DIGITO_NUEVE_NUEVE)+"";
        actor.attemptsTo(Enter.theValue(direccion).into(INPUT_DIRECCION_RESIDENCIA));
        actor.attemptsTo(Enter.theValue(Constant.TRES_PRIMEROS_DIGITOS+faker.number().digits(Constant.DIGITO_SIETE)).into(INPUT_NUMERO_CELULAR));
        String correo = faker.internet().emailAddress().replace(" ", "_");
        actor.attemptsTo(Enter.theValue(correo).into(INPUT_CORREO_ELECTRONICO));
    }
    public static Performable llenaPorCompletolosDatosSolicitados(){
        return Tasks.instrumented(DatosPersonalesFrmTask.class);
    }
}
