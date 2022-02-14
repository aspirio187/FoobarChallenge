package Level_1;

/*
Commander Lambda has had an incredibly successful week: she completed the first test run of her 
LAMBCHOP doomsday device, she captured six key members of the Bunny Rebellion, and she beat her 
personal high score in Tetris. To celebrate, she's ordered cake for everyone - even the lowliest 
of minions! But competition among minions is fierce, and if you don't cut exactly equal slices 
of cake for everyone, you'll get in big trouble.

The cake is round, and decorated with M&Ms in a circle around the edge.But while the rest of the 
cake is uniform, the M&Ms are not: there are multiple colors, and every minion must get exactly 
the same sequence of M&Ms.Commander Lambda hates waste and will not tolerate any leftovers, so 
you also want to make sure you can serve the entire cake.
 
To help you best cut the cake, you have turned the sequence of colors of the M&Ms on the cake 
into a string: each possible letter (between a and z) corresponds to a unique color, and the 
sequence of M&Ms is given clockwise(the decorations form a circle around the outer edge of the cake).
Write a function called answer(s) that, given a non-empty string less than 200 characters in length
describing the sequence of M&Ms, returns the maximum number of equal parts that can be cut from the
cake without leaving any leftovers.
*/
public class The_cake_is_not_a_lie {

    // This code was first written and tested in C#
    public static int solution(String x){
        if (x.length() == 0 || x == null) return 0;

            char firstChar = x.charAt(0);
            char lastChar = x.charAt(x.length() - 1);

            if (firstChar == lastChar && !StringContainsDifferentCharThan(x, firstChar))
            {
                return x.length();
            }

            for (int i = 1; i < x.length(); i++)
            {
                if (x.charAt(i) == lastChar)
                {
                    String temp = x.substring(0, i + 1);
                    if (temp.equals(x.substring(x.length() - 1 - i, i + 1)) && x.length() % temp.length() == 0)
                    {
                        int c = 0;
                        boolean isCorrect = true;
                        String copy = x;
                        while (copy.length() > 0 && isCorrect)
                        {
                            String tmp = copy.substring(copy.length() - temp.length(), temp.length());
                            if(!tmp.equals(temp))
                            {
                                isCorrect = false;
                                break;
                            }
                            copy = copy.substring(0, copy.length() - temp.length());
                            c++;
                        }
                        if (isCorrect) return c;
                    }
                }
            }

            return 0;
    }

    public static boolean StringContainsDifferentCharThan(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                return true;
            }
        }
        return false;
    }
}