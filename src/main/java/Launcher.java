/**
 *
 * @author Colombo Luca
 */
public class Launcher {

    public static void main(String[] args) {
        FactoryXmas xmas;

        switch (args[2].toLowerCase()) {
            case "manual":
                xmas = new XmasManual();
                xmas.start(args);
                break;
            case "vixen":
                xmas = new XmasVixen();
                xmas.start(args);
                break;
            default:
                System.out.println("You have to inser 'Manual' or 'Vixen'");

        }

    }

}
