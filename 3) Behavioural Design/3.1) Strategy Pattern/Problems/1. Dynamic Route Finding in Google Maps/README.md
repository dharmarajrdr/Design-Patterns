**Problem Statement: Dynamic Route Finding in Google Maps**

**Context:**  
Google Maps provides route suggestions based on different travel modes, such as driving, walking, cycling, and public transport. Each mode requires distinct algorithms to calculate the optimal path, considering factors like speed limits, terrain, traffic, and transport schedules.

**Current Challenge:**  
The existing implementation of the `findPath(String from, String to, Mode mode)` function has tightly coupled mode-specific logic, making the system rigid and difficult to extend. Introducing a new travel mode requires modifying the core logic, violating the Open/Closed Principle (OCP) and increasing the risk of introducing bugs.

**Objective:**  
Design a maintainable and flexible solution using the Strategy Design Pattern. Each travel mode’s pathfinding logic should be encapsulated in separate strategies, enabling dynamic selection of a mode at runtime and easy integration of new modes without altering existing code.

**Sample Inputs and Expected Outputs:**

1. **Driving Mode**

   - **Input:**  
     `findPath("New York", "Boston", Mode.DRIVING)`
   - **Expected Output:**  
     `"Recommended route: Take I-95 N for 216 miles. Estimated time: 3 hours 45 minutes."`

2. **Walking Mode**

   - **Input:**  
     `findPath("Central Park", "Empire State Building", Mode.WALKING)`
   - **Expected Output:**  
     `"Recommended route: Walk along 5th Ave for 2.3 miles. Estimated time: 45 minutes."`

3. **Cycling Mode**

   - **Input:**  
     `findPath("Golden Gate Park", "Fisherman's Wharf", Mode.CYCLING)`
   - **Expected Output:**  
     `"Recommended route: Use the bike lane along Marina Blvd for 5.6 miles. Estimated time: 25 minutes."`

4. **Public Transport Mode**

   - **Input:**  
     `findPath("Harvard University", "MIT", Mode.PUBLIC_TRANSPORT)`
   - **Expected Output:**  
     `"Recommended route: Take the Red Line towards Alewife. Estimated time: 15 minutes, including 5 minutes walking."`

5. **Future Mode Example (Flying)**
   - **Input:**  
     `findPath("Los Angeles", "San Francisco", Mode.FLYING)`
   - **Expected Output:**  
     `"Recommended route: Flight from LAX to SFO. Estimated time: 1 hour 30 minutes, including boarding time."`

---

This problem statement highlights the necessity of a strategy-based approach to decouple travel mode-specific logic, ensuring scalability, maintainability, and adherence to design principles.
