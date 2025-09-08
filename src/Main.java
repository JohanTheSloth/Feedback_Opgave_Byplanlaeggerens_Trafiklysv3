import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String RED   = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW= "\u001B[33m";
    public static final String BLACK = "\u001B[30m";
    public static void main(String[] args) {

        System.out.println("Indskriv alt med stort forbogstav");

        Scanner scanner = new Scanner(System.in);
        String dayTime = "";
        String trafficAmount ="";
        String areaType ="";

        System.out.print("Indskriv tidspunkt på dagen. mellem 06:00-16:59 skrives Dag, mellem 17:00-18:59 skrives Aften og mellem 19:00-5:59 Skrives Nat: ");
        dayTime = scanner.nextLine();

        System.out.print("indskriv trafik mængde. Lav eller Høj: ");
        trafficAmount = scanner.nextLine();

        System.out.print("Indskriv område type. Bolig, Ervhev eller Blandet: ");
        areaType = scanner.nextLine();

        System.out.print("Indksriv om det er en nødsiuation. True eller False: ");
        boolean emergancy  = scanner.nextBoolean();

        //Lys check
        String colorOflight ="";

        if (dayTime.equals("Dag") && trafficAmount.equals("Lav") || emergancy == true) {
            colorOflight = "[" + GREEN   + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]";
        }
        if (dayTime.equals("Aften") && emergancy == false || trafficAmount.equals("Lav") && dayTime.equals("Nat") &&  emergancy == false) {
            colorOflight ="[" + YELLOW   + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]";
        }
        if (dayTime.equals("Nat") && trafficAmount.equals("Høj") && emergancy == false || areaType.equals("Bolig") && trafficAmount.equals("Høj") && emergancy == false) {
            colorOflight = "[" + RED   + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]";
        }
        //Denne er her da der er huller i logikken, fra opgave side
        if (colorOflight.equals("")){
            colorOflight="Ukendt";
        }

        //Område check
        String allowedArea ="";

        if (areaType.equals("Ervhev") || areaType.equals("Blandet") && trafficAmount.equals("Lav") ) {
            allowedArea = "Tilladt";
        }
        if (areaType.equals("Bolig") && dayTime.equals("Nat") && emergancy == false) {
            allowedArea = "Forbudt";
        } else if (areaType.equals("Bolig") && dayTime.equals("Nat") && emergancy == true) {
            allowedArea = "Forbudt, men fuck reglerne når der er en nødsituation";
        }
        if (allowedArea.equals("")){
            allowedArea = "Ukendt";
        }

        System.out.println("-----Rapport-----");
        System.out.println("Traffiklyssets status er " + colorOflight);
        System.out.println("Adgang status er " + allowedArea);

    }
}
