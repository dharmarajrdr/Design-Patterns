### Problem Statement: **Smart Home Device Control System**

**Requirement:**

You are tasked with designing a system to control various smart home devices (e.g., Lights, Thermostat, Smart TV) from different manufacturers (e.g., Philips, Samsung, LG).

The system should meet the following criteria:

1. **Abstraction Layer**:

   - Users interact with a high-level control system that provides standard operations for all devices, such as `turnOn()`, `turnOff()`, `adjustSettings()`.

2. **Implementation Layer**:

    - Each device manufacturer may have its own specific implementation for these operations. For example:
    - Philips Light might require a different way to turn on/off than Samsung Light.
    - LG Smart TV might require special handling to adjust volume or brightness.

3. **Extensibility**:
   - Adding support for a new type of device (e.g., Smart Lock) or a new manufacturer should require minimal changes to the existing system.

**Deliverables**:  
Design and implement this system using the Bridge Design Pattern. Include:

1. UML class diagram explaining the relationships between abstractions and implementations.
2. Code implementation in your preferred programming language.
3. Explanation of how your design adheres to the Bridge Pattern and the benefits it offers.
