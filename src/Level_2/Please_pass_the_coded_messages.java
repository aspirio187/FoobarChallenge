package Level_2;

/*¨
You need to pass a message to the bunny prisoners, but to avoid detection, the code you 
agreed to use is … obscure, to say the least. The bunnies are given food on standard-issue
prison plates that are stamped with the numbers 0-9 for easier sorting, and you need to 
combine sets of plates to create the numbers in the code. The signal that a number is part
of the code is that it is divisible by 3. You can do smaller numbers like 15 and 45 easily,
but bigger numbers like 144 and 414 are a little trickier. Write a program to help yourself
quickly create large numbers for use in the code, given a limited number of plates to work with.
 
You have L, a list containing some digits (0 to 9). Write a function answer(L) which finds 
the largest number that can be made from some or all of these digits and is divisible by 3.
If it is not possible to make such a number, return 0 as the answer. L will contain anywhere
from 1 to 9 digits. The same digit may appear multiple times in the list, but each element in
the list may only be used once.
*/

public class Please_pass_the_coded_messages {
    public static int solution(int[] l) {

        if (l.length == 0) {
            return 0;
        }

        int n = l.length;
        int finalNumber = arrayToInt(l) % 3 == 0 ? arrayToInt(l) : 0;
        int[] c = new int[n];
        int i = 0;

        while (i < n) {
            if (c[i] < i) {

                if (i % 2 == 0) {
                    swapElements(l, 0, i);
                } else {
                    swapElements(l, c[i], i);
                }

                int number = arrayToInt(l);

                if (number % 3 == 0 && number > finalNumber) {
                    finalNumber = number;
                } else {
                    int pBase = 10;
                    int power = l.length;
                    while (power != 0) {
                        number = number / pBase;
                        if (number % 3 == 0 && number > finalNumber) {
                            finalNumber = number;
                        }

                        power--;
                    }
                }

                c[i] += 1;
                i = 0;
            } else {
                c[i] = 0;
                i += 1;
            }
        }

        return finalNumber;
    }

    public static void swapElements(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int arrayToInt(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }
}
