import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String RED   = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW= "\u001B[33m";
    public static final String BLACK = "\u001B[30m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indskriv tidspunkt på dagen. mellem 06:00-16:59 skrives Dag, mellem 17:00-18:59 skrives Aften og mellem 19:00-5:59 Skrives Nat: ");
        String dayTime = scanner.nextLine();
        dayTime = dayTime.toLowerCase().trim();

        System.out.print("indskriv trafik mængde. Lav eller Høj: ");
        String trafficAmount = scanner.nextLine();
        trafficAmount = trafficAmount.toLowerCase().trim();

        System.out.print("Indskriv område type. Bolig, Ervhev eller Blandet: ");
        String areaType = scanner.nextLine();
        areaType = areaType.toLowerCase().trim();

        System.out.print("Indksriv om det er en nødsiuation. Ja eller Nej: ");
        String emergancy  = scanner.nextLine();
        emergancy = emergancy.toLowerCase().trim();


        //Lys check
        String colorOflight ="";

        if (dayTime.equals("dag") && trafficAmount.equals("lav") || emergancy.equals("ja")) {
            colorOflight = "[" + GREEN   + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]";
        }
        if (dayTime.equals("aften") && emergancy.equals("nej") || trafficAmount.equals("lav") && dayTime.equals("nat") &&  emergancy.equals("nej")) {
            colorOflight ="[" + YELLOW   + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]";
        }
        if (dayTime.equals("nat") && trafficAmount.equals("høj") && emergancy.equals("nej") || areaType.equals("bolig") && trafficAmount.equals("høj") && emergancy.equals("nej")) {
            colorOflight = "[" + RED   + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]"
                    + "[" + BLACK + "■" + RESET + "]";
        }
        //Denne er her da der er huller i logikken, fra opgavens side
        if (colorOflight.isEmpty()){
            colorOflight="Ukendt";
        }

        //Område check
        String allowedArea ="";

        if ((areaType.equals("ervhev") || areaType.equals("blandet")) && trafficAmount.equals("lav") ) {
            allowedArea = "Tilladt";
        }
        if (areaType.equals("bolig") && dayTime.equals("nat") && emergancy.equals("nej")) {
            allowedArea = "Forbudt";
        } else if (areaType.equals("bolig") && dayTime.equals("nat") && emergancy.equals("ja")) {
            allowedArea = "Forbudt, men fuck reglerne når der er en nødsituation";
        }
        //Denne er her da der er huller i logikken, fra opgavens side
        if (allowedArea.isEmpty()){
            allowedArea = "Ukendt";
        }

        System.out.println("-----Rapport-----");
        System.out.println("Traffiklyssets status er " + colorOflight);
        System.out.println("Adgangs status er " + allowedArea);

    }
}
