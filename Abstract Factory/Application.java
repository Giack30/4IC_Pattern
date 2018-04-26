import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        GUIFactory factory = GUIFactory.getFactory(input.nextInt());
        Button button = factory.createButton();
        button.paint();
    }
}
