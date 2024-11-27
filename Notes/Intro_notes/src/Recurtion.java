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


    public static void main(String[] args) {
        System.out.println(fact(5)); // 120
        System.out.println(fib(10)); // 55 (fib sequence = 1, 1, 2, 3, 5, 8, 13, 21, 34, 55) 55 is the 10th number in the sequence
        System.out.println(isPalindrome("racecar")); // true
    }

}
