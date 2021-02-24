package hackerrank;

public class CatsAndAMouse {

    public static void main(String[] args) {
        System.out.println(catAndMouse(1, 3, 3));
    }

    public static String catAndMouse(int catA, int catB, int mouse) {
        int difA = Math.abs(mouse - catA);
        int difB = Math.abs(mouse - catB);
        return difA == difB ? "Mouse C" : (difA > difB ? "Cat B" : "Cat A");
    }
}
