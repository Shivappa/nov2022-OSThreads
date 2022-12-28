package callables.mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        List<Integer> arr = Arrays.asList(5,8,7,3,4,1,2,6);

        MergeSort mergeSort = new MergeSort(arr, executorService);
        Future<List<Integer>> sortedArrFuture = executorService.submit(mergeSort);

        System.out.println("Waiting for array to be sorted");

        List<Integer> sortedArr = sortedArrFuture.get();

        System.out.println(sortedArr);

        executorService.shutdown();
    }
}
