### **Problem Statement: Sorting Service**

You are building a **Data Processing Service** that sorts large datasets. Based on the dataset size, you need to switch sorting algorithms at runtime:

- If dataset is **small** → use **Bubble Sort**
- If dataset is **medium** → use **Merge Sort**
- If dataset is **large** → use **Quick Sort**

The client should be able to **switch sorting algorithm at runtime** without changing the `SortingService` class.
