### Problem Statement : Patient Record Management

**Requirement**:

A healthcare organization is building a web-based portal to manage patient records for millions of users. Each patient has the following attributes:

1. **Patient ID** (Unique to each patient)
2. **Name**
3. **Age**
4. **Address**
5. **Date of Birth** (Commonly referenced but immutable)
6. **Blood Group** (Shared across many patients)
7. **Hospital Name** (Where the patient is registered, common for multiple patients)
8. **Treatment Details** (Unique to each patient and changes over time)

The system needs to perform efficient memory management while providing real-time access to patient data. Without optimization, creating millions of patient objects with full data would consume excessive memory and impact performance.

**Requirement Goals**:

1. Reduce memory usage by reusing data that is shared across multiple patients (e.g., `Date of Birth`, `Blood Group`, and `Hospital Name`).
2. Allow extrinsic data like `Patient ID`, `Name`, `Age`, `Address`, and `Treatment Details` to vary independently.
3. Ensure that the system remains scalable and performant, even with a large number of patients.
