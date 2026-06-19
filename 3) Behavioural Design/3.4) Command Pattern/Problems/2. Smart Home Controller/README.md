**Problem Statement: Smart Home Controller**

Build a **Smart Home Controller** that can control multiple devices — a **Light** and a **Fan**.

The controller should support:
- Turn **on/off** the Light
- Turn **on/off** the Fan
- **Undo** the last action
- **Redo** the last undone action
- **Undo clears redo** when a new action is performed

---

**Your task:**

Model this using the **Command Pattern** with these classes:

- `Command` — interface
- `Light`, `Fan` — receivers
- `LightOnCommand`, `LightOffCommand`, `FanOnCommand`, `FanOffCommand` — concrete commands
- `SmartHomeController` — invoker with undo/redo support

---

**Expected output:**

```
Light is ON
Fan is ON
Light is OFF
Undo -> Light is ON
Redo -> Light is OFF
```
