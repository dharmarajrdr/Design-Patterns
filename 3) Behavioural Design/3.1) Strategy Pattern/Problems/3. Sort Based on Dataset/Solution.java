interface SortingAlgorithm<T> {
    void sort(T t);
}

class BubbleSortAlgorithmStrategy<T> implements SortingAlgorithm<T> {

    public void sort(T t) {
        // Some implementation will go here.
    }
}

class MergeSortAlgorithmStrategy<T> implements SortingAlgorithm<T> {

    public void sort(T t) {
        // Some implementation will go here.
    }
}

class QuickSortAlgorithmStrategy<T> implements SortingAlgorithm<T> {

    public void sort(T t) {
        // Some implementation will go here.
    }
}

class SortingService<T> {
    private SortingAlgorithm<T> strategy;

    public SortingService(SortingAlgorithm<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(T t) {
        strategy.sort(t);
    }
}

public class Solution {
    public static void main(String[] args) {
        
        int[] arr = {20, 3, 4};
        int N = arr.length;

        SortingAlgorithm<int[]> strategy = null;
        if(N < 10) {
            strategy = new BubbleSortAlgorithmStrategy<>();
        } else if(N < 100) {
            strategy = new MergeSortAlgorithmStrategy<>();
        } else {
            strategy = new QuickSortAlgorithmStrategy<>();
        }

        SortingService<int[]> sortingService = new SortingService<>(strategy);
        sortingService.sort(arr);
    }
}
