package Level_2;

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
