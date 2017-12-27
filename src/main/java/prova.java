import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.util.ServerRunner;

import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Colombo Luca
 */

public class prova extends NanoHTTPD {

    boolean isOn = false;

    testmain silleninni;

    Thread t1;

    /**
     * logger to log to.
     */
    private static final Logger LOG = Logger.getLogger(prova.class.getName());

    public static void main(String[] args) {
        ServerRunner.run(prova.class);
    }

    public prova() {
        super(8080);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        String uri = session.getUri();
        prova.LOG.info(method + " '" + uri + "' ");

        String msg = "<html><body><h1>Hello server</h1>";
        Map<String, String> parms = session.getParms();
        System.out.println(parms.keySet());
        System.out.println(parms.get("choice"));



        if (uri.equals("/") && !isOn) {

            msg += "<form action='acceso' method='get'>" + "<input type='submit' name='choice' value='acceso'>" +
                    "</form>";



        } else if (uri.equals("/") && isOn) {
            msg += "<form action='off' method='get'>" + "<input type='submit' name='choice' value='spegni'>" +
                    "</form>";
        } else if (parms.get("choice").equals("acceso")){

            silleninni = new testmain();
            t1 = new Thread(silleninni);
            t1.start();
            isOn = true;

            System.out.println("funziona!!");
            //msg += "<p> PER ora funziona </p>";



            msg += "<a class='clickMe' href='..//'>Click me</a>" +
                    "<style>" +
                    ".clickMe {" +
                    "border-bottom: 1px solid #777777;"+
                "border-left: 1px solid #000000;"+
                "border-right: 1px solid #333333;"+
                "border-top: 1px solid #000000;"+
                "color: #000000;"+
                "display: block;"+
                "height: 2.5em;"+
                "padding: 0 1em;"+
                "width: 5em;"+
                "text-decoration: none;"+
                    "}" +
                    "</style>";

            msg += "<form action='off' method='get'>" + "<input type='submit' name='choice' value='spegni'>" +
                    "</form>";

        } else if (parms.get("choice").equals("spegni")){
            silleninni.stopRunning();
            isOn = false;

            msg += "<form action='acceso' method='get'>" + "<input type='submit' name='choice' value='acceso'>" +
                    "</form>";


        } else {
            msg += "<p>Qualcosa non va!</p>";
        }

        msg += "</body></html>\n";


        return newFixedLengthResponse(msg);
    }


}

