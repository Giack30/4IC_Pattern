public abstract class Button {
    public abstract void paint();
}

class WinButton extends Button {
    public void paint() {
        System.out.println("Sono un WinButton!");
    }
}

class OSXButton extends Button {
    public void paint() {
        System.out.println("Sono un OSXButton!");
    }
}
