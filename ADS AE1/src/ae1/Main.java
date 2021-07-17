package ae1;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int k = 15;
		TimeSortingAlgorithms(k);
	}
	
	
	public static boolean TestSortingAlgorithms(int[] a) {
		
		int n = a.length;
		//loop through array
		for(int i = 0; i < n - 1; i++) {
			//if an element is larger than its successor, return false
			if(a[i] > a[i+1]) {
				return false;
			}
		}	
		//if all elements checked, return true
		return true;
	}
	
	
	public static void TimeSortingAlgorithms(int k){
		
		try {
			//Get file folder
			Path testdir = Paths.get("src/TestFiles");
			DirectoryStream<Path> stream = Files.newDirectoryStream(testdir);
			
			//loop through all files in folder
			for(Path file : stream) {
				
				//parse lines into list of integers
				List<Integer> alist = new ArrayList<Integer>();
				try (Scanner s = new Scanner(new FileReader(file.toString()))) {
				    while (s.hasNext()) {
				        alist.add(s.nextInt());
				    }
				}
				
				System.out.println("------------------------------------------------------");
				System.out.println("Time taken to sort " + file.getFileName() + " (Size " + alist.size() + "):\n");
				
				
				//Time and test Insertion Sort
				int[] a = new int[alist.size()];
				for(int i = 0; i < alist.size(); i++) a[i] = alist.get(i);
				
				Long time = System.currentTimeMillis();
				Sorts.InsertionSort(a, 0, a.length - 1);
				System.out.println("Insertion Sort: " + (System.currentTimeMillis() - time) + "ms");
				if(!(TestSortingAlgorithms(a))) {
					System.out.println("Insertion Sort failed to sort " + file.getFileName());
				}
				
				
				//Time and test Merge Sort
				a = new int[alist.size()];
				for(int i = 0; i < alist.size(); i++) a[i] = alist.get(i);
				
				time = System.currentTimeMillis();
				Sorts.MergeSort(a, 0, a.length - 1);
				System.out.println("Merge Sort: " + (System.currentTimeMillis() - time) + "ms");
				if(!(TestSortingAlgorithms(a))) {
					System.out.println("Merge Sort failed to sort " + file.getFileName());
				}
				
				System.out.println("");	//Add newline
				
				
				//Time and test Quick Sort (Part 1A)
				a = new int[alist.size()];
				for(int i = 0; i < alist.size(); i++) a[i] = alist.get(i);
				
				time = System.currentTimeMillis();
				Sorts.QuickSort(a, 0, a.length - 1);
				System.out.println("(1A) Quicksort: " + (System.currentTimeMillis() - time) + "ms");
				if(!(TestSortingAlgorithms(a))) {
					System.out.println("Quicksort failed to sort " + file.getFileName());
				}
				
				
				//Time and test Hybrid Quick Sort (Part 1B)
				a = new int[alist.size()];
				for(int i = 0; i < alist.size(); i++) a[i] = alist.get(i);
				
				time = System.currentTimeMillis();
				Sorts.HybridQuickSort(a, 0, a.length - 1, k);
				System.out.println("(1B) Hybrid Quicksort (k=" + k + "): " + (System.currentTimeMillis() - time) + "ms");
				if(!(TestSortingAlgorithms(a))) {
					System.out.println("Hybrid Quicksort failed to sort " + file.getFileName());
				}
				
				
				//Time and test Median of 3 Quick Sort (Part 1C)
				a = new int[alist.size()];
				for(int i = 0; i < alist.size(); i++) a[i] = alist.get(i);
				
				time = System.currentTimeMillis();
				Sorts.QuickSortMO3(a, 0, a.length - 1);
				System.out.println("(1C) Median of 3 Quicksort: " + (System.currentTimeMillis() - time) + "ms");
				if(!(TestSortingAlgorithms(a))) {
					System.out.println("Median of 3 failed to sort " + file.getFileName());
				}
				
				
				//Time and test 3 Way Quicksort (Part 1D)
				a = new int[alist.size()];
				for(int i = 0; i < alist.size(); i++) a[i] = alist.get(i);
				
				time = System.currentTimeMillis();
				Sorts.QuickSort3Way(a, 0, a.length - 1);
				System.out.println("(1D) 3-Way Quicksort: " + (System.currentTimeMillis() - time) + "ms");
				if(!(TestSortingAlgorithms(a))) {
					System.out.println("3-Way Quicksort failed to sort " + file.getFileName());
				}
				
			}
		} catch(IOException e){
			//Print error if folder not found
			System.out.println("Couldn't locate test file directory.");
		}
	
	}
	
}
