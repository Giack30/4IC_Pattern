public abstract class GUIFactory {
    public static GUIFactory getFactory(int os_type) {
        int sys = os_type;
        if (sys == 0) {
            return new WinFactory();
        } else {
            return new OSXFactory();
        }
    }


    public abstract Button createButton();
}

class WinFactory extends GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
}

class OSXFactory extends GUIFactory {
    public Button createButton() {
        return new OSXButton();
    }
}
