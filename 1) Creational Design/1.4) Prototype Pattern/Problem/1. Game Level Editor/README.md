### **Problem Statement: Game Level Editor**:

You are developing a **game level editor** for a 2D platformer game. In the editor, the user can place various game objects (e.g., enemies, power-ups, platforms, and obstacles) onto the game map. Each game object has a set of attributes, such as position, size, color, and behavior (e.g., patrol for enemies or bounce for platforms).

The following requirements must be met:

---

### **Requirements**:

1. **Efficient Object Creation**:

   - Creating and configuring game objects from scratch is repetitive and time-consuming.
   - You need a mechanism to quickly duplicate existing game objects with the same attributes.

2. **Customizable Duplicates**:

   - After cloning a game object, users should be able to tweak its attributes (e.g., change its position, size, or color).

3. **Prototype Repository**:

   - Maintain a **repository of pre-configured prototypes** (e.g., a "Red Enemy" or "Wooden Platform") to simplify the user's workflow.
   - Users should be able to select and clone prototypes from this repository.

4. **Scalability**:
   - The system should allow adding new types of game objects (e.g., checkpoints or collectibles) without requiring significant changes to the cloning mechanism.

---

### **Objective**:

Design a system using the **Prototype Design Pattern** that enables:

- Quick cloning of game objects.
- A central registry of reusable prototypes.
- The ability to modify cloned objects without affecting the original prototype.
