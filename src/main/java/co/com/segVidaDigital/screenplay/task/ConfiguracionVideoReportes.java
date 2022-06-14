package co.com.segVidaDigital.screenplay.task;

import co.com.segVidaDigital.screenplay.helpers.Date;
import co.com.segVidaDigital.screenplay.helpers.ManagerLog;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import java.io.File;


public class ConfiguracionVideoReportes implements Task {

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            File theDir = new File("reporteGrabacionesdePruebas");
            if (!theDir.exists()) {
                theDir.mkdirs();
                ManagerLog.imprimirExito("El metodo CREO correctamente la carpeta para video reportes");
            }
            String fecha = Date.obtenerFechaActualConHorasMinutosSegudosFormateada();
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "ffmpeg -y -rtbufsize 100M -f gdigrab -t 00:00:30 -framerate 30 -probesize 10M -draw_mouse 1 -i desktop -c:v libx264 -r 30 -preset ultrafast -tune zerolatency -crf 25 -pix_fmt yuv420p reporteGrabacionesdePruebas\\"+"Feature"+fecha+".mp4");
            builder.redirectErrorStream(true);
            builder.start();
        } catch (Exception e) {
            ManagerLog.imprimirFallo("El metodo  NO creo la carpeta correctamente ");
        }
    }

    public static Performable grabandoPrueba() {
        return Tasks.instrumented(ConfiguracionVideoReportes.class);
    }
}

/** DATOS MUY IMPORTANTES PARA REALIZAR GRABACION DE LAS PRUEBAS
 **************************
 * 1- Descargar de la pagina oficial el ffmpeg.exe esta es la herramienta que nos permitira realizar las grabaciones y
 * 2- Debes dejar la herramienta  el ffmpeg.exe en la raiz de la ruta del proyecto que desea grabar las pruebas
 * 3- Una vez dejado en la ruta deberas crear una carpeta no importa el nombre lo que importa es que sea entendible y preferiblemente
 de la siguiente forma, Ej; Video1 - videoTest - testVideo_pruebas -reporteGrabacionesdePruebas
 --- IMPORTANTE el .exe no debe estar metida dentro de alguna carpeta debe estar simplemente en la raiz de la ruta del proyecto.
 * 4- Una vez creada la carpeta nos paramos en la ruta del proyecto abriendo el cmd o consola de comandd y tener presente que al momento
 de abrirlo debemos fijarnos que estemos en la ruta si no lo esta deberas llegar hasta ella  en mi caso esto es lo que debe mostrarme
 una vez que ejecute el CMD en la raiz de la ruta del proyectoEj: c:\Users\NombreDelaMaquina\Destopk\AutomationScreenplay>
 * 5- Despues de abierto el cmd de forma correcta debemos pegar la siguiente ruta, MUY IMPORTANTE::: >>>>> esta linea de comando sirve para que la herramienta
 ffmpeg se instale de forma correcta y poder que esta grabe sin problemas <<<<<< se deja como Ejemplo:
 --- IMPORTANTE la ruta al final termine en xxxx.mp4 el nombre que llevara el video debe llamarse igual al nombre de la carpeta que se creo manualmente en el paso 3
 * ->  ffmpeg -y -rtbufsize 100M -f gdigrab -t 00:00:30 -framerate 30 -probesize 10M -draw_mouse 1 -i desktop -c:v libx264 -r 30 -preset ultrafast -tune zerolatency -crf 25 -pix_fmt yuv420p reporteGrabacionesdePruebas.mp4
 * 6- una vez ya puesto la ruta damos enter para que la consola ejecute esto tomara unos segundos depende de la velocidad de la carpeta y al finalizar la ejeucion sin
 algun error ya podremos configurar en nuestra clase atravez de codigo para que el proceso se vuelva automatico,
 --- IMPORTANTE Es importante que la maquina no este conectada a una segunda o tercera pantalla porque nos saldra un error por el acho y largo
 *  7- El ultimo paso es crear la clase y los metodos donde el robot ejecutara y activira la grabacion y por ultimo esta quedara en una carpeta
 de preferencia que nosotros mismos programemos
 *************************
 * */