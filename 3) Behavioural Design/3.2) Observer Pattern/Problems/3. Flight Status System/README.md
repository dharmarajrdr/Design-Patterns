**Problem Statement: Flight Status System**

You are building a **Flight Status Tracking System** at an airport.

- When a **flight status changes** (Delayed, Boarding, Cancelled, On Time), all registered listeners should be **automatically notified**.
- Different listeners react differently:
  - **PassengerNotifier** — prints "Dear passenger, flight status changed to: X"
  - **AirportDisplayBoard** — prints "Display board updated: X"
  - **AirlineStaff** — prints "Staff alerted, flight status: X"
