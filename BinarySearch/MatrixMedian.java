//https://www.interviewbit.com/problems/matrix-median/

public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0 || A.get(0) == null || A.get(0).size() == 0) {
            return 0;
        }
        ArrayList<Integer> firstRow = A.get(0);
        
        int rowCount = A.size();
        int colCount = firstRow.size();
        
        int medianIndex = rowCount * colCount / 2;

        // First, find the biggest and the smallest numbers in the matrix.  This is the boundary
        int min = firstRow.get(0);
        int max = firstRow.get(colCount - 1);
        for (int i = 1; i < rowCount; i++) {
            ArrayList<Integer> row = A.get(i);
            int first = row.get(0);
            if (first < min) {
                min = first;
            }
            int last = row.get(colCount - 1);
            if (last > max) {
                max = last;
            }
        }
        
        // Then do the binary search based on min/max boundary.
        // The smallest index that has the same item count as the median index is the answer.
        int l = min;
        int h = max;
        int smallest = max;
        int targetCount = medianIndex + 1;
        while (l <= h) {
            int mid = l + (h-l) / 2;
            int count = 0;
            for (int i = 0; i < rowCount; i++) {
                count += getSmallerOrEqualCount(A.get(i), mid);
            }
            if (count >= targetCount) {
                smallest = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return smallest;
    }
    
    public int getSmallerOrEqualCount(ArrayList<Integer> A, int b) {
        int l = 0;
        int h = A.size() - 1;
        int foundIndex = -1;
        while (l <= h) {
            int mid = l + (h-l)/2;
            int num = A.get(mid);
            if (num <= b) {
                foundIndex = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return foundIndex + 1;
    }
    
}


/**
Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
**/
