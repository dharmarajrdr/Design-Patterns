enum OS { WINDOWS, MAC, LINUX }

interface Button {

    void click();
    void hover();
}

interface Checkbox {

    void check();
    void uncheck();
}

// Concrete classes for Windows
class WindowsButton implements Button {

    @Override
    public void click() {
        System.out.println("Windows Button Clicked");
    }

    @Override
    public void hover() {
        System.out.println("Hovering over Windows Button");
    }
}
class WindowsCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("Windows Checkbox Checked");
    }

    @Override
    public void uncheck() {
        System.out.println("Windows Checkbox Unchecked");
    }
}

// Abstract Factory Interface
interface UIFactory {

    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories of Windows
class WindowsFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class FactoryProvider {
    public static UIFactory getFactory(OS os) {
        switch (os) {
            case WINDOWS : {
                return new WindowsFactory();
            }
            default: {
                throw new IllegalArgumentException("Unsupported OS");
            }
        }
    }
}

// Create new concrete classes and concrete Factories for Mac and Linux

class Solution{

    public static void main(String[] args) {

        UIFactory factory = FactoryProvider.getFactory(OS.WINDOWS); // This could be determined at runtime based on OS
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.hover();
        button.click();
        checkbox.check();
        checkbox.uncheck();
    }
}
