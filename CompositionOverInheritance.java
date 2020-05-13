public class CompositionOverInheritance {
    public static void main(String[] args) {

    }
}

interface IEmployee {

}

interface IPrinterCommand {
    String emailCommand = "E";
    String faxCommand = "F";
    String scanlCommand = "S";
    String printCommand = "P";

    void initialize();

}

abstract class userBase {

}

class Manager extends userBase {

}

class Leader {

}

class Coder {

}