public class Recurtion {
    // function static so it can be called in static method main

    // * factorial (given int n n factorial is n * (n-1) * (n-2) * ... * 1)
    static int fact(int n){
        // base case
        if (n == 0 || n == 1){
            return n;
        }
        // recursive case
        return n * fact(n-1);
    }

    // * Fibonacci (given int n n fibonacci is F(n) = F(n-1) + F(n-2) where F(0) = 0 and F(1) = 1) n is the nth number in the sequence
    static int fib(int n){
        // base case
        if (n == 0 || n == 1){
            return n;
        }
        // recursive case
        return fib(n-1) + fib(n-2); // finish the left side (fib(n-1) before we can do the right side (fib(n-2)) as the function fib(n-1) is called before fib(n-2) in every recursive call
    }

    static boolean isPalindrome(String s){
        // base case
        if (s.length() == 0 || s.length() == 1){
            return true;
        }
        // recursive case
        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1)); // check is first and lats letters of the curretn string are equal and then do the same for the string minus the first and last letters we just checked
    }
    // all positve
    /* 
    to check if all elements in an array are positive we can use recurtion
    but insted of passing in a smaller and smaller copy array we inted use pointers to point at the start and finish of the array
    using this we can make the pointers shorter and shorter to pass in a smaller and smaller version of the array
    we make the array smaller by changing the range we are evaluating

    in this function the idea is make the array shorter by changing the range we are evaluating until the range start and end is the same
    at that point we can evaluate the current element for being positive and compare it with the start pointer for the array from the last call
    this start pointer from the last call is one less the current start pointer so we would be checking is the element before the one that was positive
    is also positive we keep doing this for the element before untill we reach the start pointer of the array passed in at the first call
    */
    static boolean allPositive(int[] a) {
        return allPositiveHelper (a, 0, a.length - 1); // start at the beginning and end of the array
    }
    static boolean allPositiveHelper (int[] a, int from, int to) {
        if (from > to) { /* base case 1: empty range */
            return true; // since no elements its true as is equivalent to all positive
        }
        else if(from == to) { /* base case 2: range of one element */ 
            return a[from] > 0; // since there is only one element we can check if it is positive (one element as start and end are the same)
        }
        else { /* recursive case */
            // check if the current starting element is positive and if the rest of the array is positive
            // once we reach the base case of only comparing one element the recurtion call will return true
            // and we compare with a[from] but since this would be the caller of the function that caused base case 
            // 'from' would give the element before the one that was positive (from = end - 1)
            // short circuiting ensurees if the first element is not positive we do not need to check the rest of the array
            return a[from] > 0 && allPositiveHelper (a, from + 1, to); 
        }
    }

    static boolean isSorted(int[] a) { // for non-decreasing array
        return isSortedHelper (a, 0, a.length - 1);
    }
    static boolean isSortedHelper (int[] a, int from, int to) { 
        if (from > to) { /* base case 1: empty range */
            return true; 
        }
        else if(from == to) { /* base case 2: range of one element = reached the last element */ 
            return true;
        }
        else {  
            // check if current element is less than the next element and if the rest of the array is sorted
            // at base case we reaach one element return true them comapre to the previous element and so on for the rest of the array
            return a[from] <= a[from + 1] && isSortedHelper (a, from + 1, to);
        }
    }


    public static void main(String[] args) {
        System.out.println(fact(5)); // 120
        System.out.println(fib(10)); // 55 (fib sequence = 1, 1, 2, 3, 5, 8, 13, 21, 34, 55) 55 is the 10th number in the sequence
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(allPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); // true
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); // true
    }

}
