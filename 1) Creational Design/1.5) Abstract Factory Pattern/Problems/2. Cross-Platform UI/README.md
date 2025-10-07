# Cross-Platform UI Toolkit

### Problem Statement:

You need to design a **UI Component Factory** that can create **buttons** and **checkboxes** for different **operating systems** (Windows, Mac, and Linux).
Each OS has its own style and implementation for these components — but the client code should be able to create them **without knowing** which OS it’s dealing with.


### Requirements:

1. **Abstract Factory Interface**

   * Defines methods for creating UI elements:

     ```java
     public interface UIFactory {
         Button createButton();
         Checkbox createCheckbox();
     }
     ```

2. **Concrete Factories**

   * Implementations for different OSes:

     * `WindowsFactory`
     * `MacFactory`
     * `LinuxFactory`

3. **Abstract Products**

   * `Button` (interface)
   * `Checkbox` (interface)

4. **Concrete Products**

   * `WindowsButton`, `MacButton`, `LinuxButton`
   * `WindowsCheckbox`, `MacCheckbox`, `LinuxCheckbox`

5. **Client Code**

   * Should work only with interfaces (`UIFactory`, `Button`, `Checkbox`).
   * Should **not** depend on concrete classes.
   * The correct factory is selected at runtime based on the detected OS.


### Example Scenario:

```text
User starts the application on macOS.

👉 The app detects OS = Mac.
👉 It uses MacFactory to create UI components.
👉 It creates MacButton and MacCheckbox.
👉 Calls render() on both.

Output:
Rendering a button in Mac style
Rendering a checkbox in Mac style
```

If you switch to Windows, same client code should print:

```
Rendering a button in Windows style
Rendering a checkbox in Windows style
```

### Extension Ideas (for deeper practice):

* Add new product families like `TextField` or `Dropdown`.
* Add a **DarkThemeFactory** and **LightThemeFactory** (to practice multiple product variations).
* Combine Abstract Factory with Singleton (one factory per OS).
