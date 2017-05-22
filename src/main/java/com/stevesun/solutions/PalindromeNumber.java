package com.stevesun.solutions;

/**Determine whether an integer is a palindrome. Do this without extra space.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.*/
public class PalindromeNumber {
    
    /**Purely my original solution: just reverse the entire number and compare with itself, return if they two are equal or not.*/
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0) return false;
        int rev = 0, tmp = x;
        while(tmp != 0){
            rev *= 10;
            rev += tmp%10;
            tmp /= 10;
        }
        return rev == x;
    }
    
    /**Then I turned to Discuss and found a more efficient way: reversing only half and then compare if they're equal.*/

}
