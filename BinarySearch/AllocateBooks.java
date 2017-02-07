//https://www.interviewbit.com/problems/allocate-books/


public class Solution {
	public int books(ArrayList<Integer> a, int b) {
	    int totalPages = 0;
	    int size = a.size();
	    if (size < b) {
	        return -1;
	    }
	    for (int i = 0; i < size; i++) {
	        totalPages += a.get(i);
	    }
	    int l = 0;
	    int h = totalPages;
	    int pages = h;
	    while (l <= h) {
	        int mid = l + (h-l)/2;
	        if (isPossible(a, b, mid)) {
	            pages = mid;
	            h = mid - 1;
	        } else {
	            l = mid + 1;
	        }
	    }
	    return pages;
	}
	
	boolean isPossible(ArrayList<Integer> a, int b, int maxPages) {
	    //System.out.println("maxPages " + maxPages);
	    int size = a.size();
	    int students = 1;
	    int totalPages = 0;
	    for (int i = 0; i < size; i++) {
	        int pages = a.get(i);
	        if (pages > maxPages) {
	            return false;
	        }
	        totalPages += pages;
	        if (totalPages > maxPages) {
	            students++;
	            if (students > b) {
	                return false;
	            }
	            totalPages = pages;
	        }
	    }
	    //System.out.println("returning true " + students);
	    return true;
	}
}

/**
N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:
 List of Books M number of students 

Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113. 

**/
