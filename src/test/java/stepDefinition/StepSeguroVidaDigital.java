package stepDefinition;

import co.com.segVidaDigital.screenplay.helpers.Constant;
import co.com.segVidaDigital.screenplay.interaction.Interacciones;
import co.com.segVidaDigital.screenplay.question.TextValidCompra;
import co.com.segVidaDigital.screenplay.question.TextValidDatos;
import co.com.segVidaDigital.screenplay.question.TextValidHome;
import co.com.segVidaDigital.screenplay.task.Abrir;
import co.com.segVidaDigital.screenplay.task.DatosPersonalesFrmTask;
import co.com.segVidaDigital.screenplay.task.PreguntasSaludTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepSeguroVidaDigital {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("el usuario ingresa a la pagina web para la compra del seguro de vida digital")
    public void elUsuarioIngresaALaPaginaWebParaLaCompraDelSeguroDeVidaDigital() {
        theActorCalled(Constant.MR_ROBOT).attemptsTo(Abrir.navegadorWebURL());
        theActorInTheSpotlight().should(seeThat(TextValidHome.paginaDeSegurosVidaDigital()));
        theActorCalled(Constant.MR_ROBOT).attemptsTo(Interacciones.clicBotonComprar());
    }
    @Cuando("llena completamente el formulario de datos personales y responde unas preguntas obligatorias detalles de tu salud, inluyendo TyC")
    public void llenaCompletamenteElFormularioDeDatosPersonalesYRespondeUnasPreguntasObligatoriasDetallesDeTuSaludInluyendoTyC() {
        theActorInTheSpotlight().should(seeThat(TextValidDatos.estoyEnElFrmDatos()));
        theActorCalled(Constant.MR_ROBOT).attemptsTo(DatosPersonalesFrmTask.llenaPorCompletolosDatosSolicitados());
        theActorCalled(Constant.MR_ROBOT).attemptsTo(PreguntasSaludTask.respondePreguntas());
        theActorCalled(Constant.MR_ROBOT).attemptsTo(Interacciones.clicAceptaTyC());
        theActorCalled(Constant.MR_ROBOT).attemptsTo(Interacciones.clicBotonComprarSeguroVidaDigital());
    }
    @Entonces("realiza la compra del producto de manera exito")
    public void realizaLaCompraDelProductoDeManeraExito() {
        theActorInTheSpotlight().should(seeThat(TextValidCompra.compraExitosa()));
    }
}
