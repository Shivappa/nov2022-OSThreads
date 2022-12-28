package callables.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSort implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public MergeSort(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }


    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if(arrayToSort.size() <=1 ){
            return arrayToSort;
        }
        System.out.println("Thread name: " + Thread.currentThread().getName());
        int mid = arrayToSort.size()/2;

        List<Integer> leftArrayToSort = new ArrayList<>();
        List<Integer> rightArrayToSort = new ArrayList<>();

        for(int i=0; i<mid; i++){
            leftArrayToSort.add(arrayToSort.get(i));
        }

        for(int i=mid; i<arrayToSort.size(); i++){
            rightArrayToSort.add(arrayToSort.get(i));
        }
        MergeSort leftArrMergeSort = new MergeSort(leftArrayToSort, executorService);
        MergeSort righArrMergeSort = new MergeSort(rightArrayToSort, executorService);
        Future<List<Integer>> leftSortedArrFuture = executorService.submit(leftArrMergeSort);
        Future<List<Integer>> rightSortedArrFuture = executorService.submit(righArrMergeSort);

        System.out.println("Doing some other task");
        List<Integer> leftSortedArr = leftSortedArrFuture.get();
        List<Integer> rightSortedArr = rightSortedArrFuture.get();

        int i=0, j=0;
        List<Integer> sortedArr = new ArrayList<>();
        while (i<leftSortedArr.size() && j<rightSortedArr.size()){
            if(leftSortedArr.get(i) < rightSortedArr.get(j)){
                sortedArr.add(leftSortedArr.get(i));
                i++;
            } else {
                sortedArr.add(rightSortedArr.get(j));
                j++;
            }
        }

        while(i<leftSortedArr.size()){
            sortedArr.add(leftSortedArr.get(i));
            i++;
        }

        while(j<rightSortedArr.size()){
            sortedArr.add(rightSortedArr.get(j));
            j++;
        }

        return sortedArr;
    }
}
