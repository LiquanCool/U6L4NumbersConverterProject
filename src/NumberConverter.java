import java.util.Arrays;

public class NumberConverter {
    String[] digits;
    int base;
    int number;
    String numberStr;
    static String[] hexaArray = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    static String[] minecraftBaseArray = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = Integer.toString(d);
        }
        this.base = base;
        this.number = number;
    }

    public NumberConverter(String numberStr, int base) {
        digits = new String[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            String single = numberStr.substring(i, i + 1);
            digits[i] = single;
        }
        this.base = base;
        this.numberStr = numberStr;
    }

    public static boolean numberChecker(String base, String numStr) {
        if (numStr.length() > 10) {
            return false;
        }
        if (base.equals("2")) {
            for (int i = 0; i < numStr.length(); i++) {
                String currentNum = numStr.substring(i, i + 1);
                if (!(currentNum.equals("0") || currentNum.equals("1"))) {
                    return false;
                }
            }
            return true;
        }
        if (base.equals("8")) {
            for (int i = 0; i < numStr.length(); i++) {
                String currentNum = numStr.substring(i, i + 1);
                boolean acceptable = false;
                for (int j = 0; j < 8; j++) {
                    if (currentNum.equals(Integer.toString(j))) {
                        acceptable = true;
                    }
                }
                if (!acceptable) {
                    return false;
                }
            }
            return true;
        }
        if (base.equals("10")) {
            for (int i = 0; i < numStr.length(); i++) {
                String currentNum = numStr.substring(i, i + 1);
                boolean acceptable = false;
                for (int j = 0; j < 10; j++) {
                    if (currentNum.equals(Integer.toString(j))) {
                        acceptable = true;
                    }
                }
                if (!acceptable) {
                    return false;
                }
            }
            return true;
        }
        if (base.equals("16")) {
            for (int i = 0; i < numStr.length(); i++) {
                String currentNum = numStr.substring(i, i + 1);
                boolean acceptable = false;
                for (int j = 0; j < hexaArray.length; j++) {
                    if (currentNum.equals(hexaArray[j])) {
                        acceptable = true;
                    }
                }
                if (!acceptable) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static boolean mcChecker(String base)
    {
        for (int k = 1;k<=64;k++)
        {
            if (base.equals(Integer.toString(k)))
            {

                return true;
            }
        }
        return false;
    }


    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal()
    {
        if (base == 16)
        {

            String numStr = numberStr;
            int tempNum = 0;
            int tempBase = 1;
            for (int i = numStr.length() - 1; i >= 0; i--) {
                String current = numStr.substring(i, i + 1);
                tempNum += Arrays.toString(hexaArray).indexOf(current)/3 * tempBase;
                tempBase *= base;
            }
            numStr = Integer.toString(tempNum);
            int[] tempArray = new int[numStr.length()];
            for (int i = 0; i < numStr.length(); i++) {
                tempArray[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            return tempArray;
        }
        else
        {
           String numStr = Integer.toString(number);
           int tempNum = 0;
           int tempBase = 1;
           for (int i = numStr.length() - 1; i >= 0; i--) {
               tempNum += Integer.parseInt(numStr.substring(i, i + 1)) * tempBase;
               tempBase *= base;
           }
           numStr = Integer.toString(tempNum);
           int[] tempArray = new int[numStr.length()];
           for (int i = 0; i < numStr.length(); i++) {
               tempArray[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            return tempArray;
        }
    }

    public int[] convertToBinary() {
        int temp = number;
        int counter = 0;
        int remainder = 0;
        if (base == 10) {
            while (temp > 0) {
                remainder = temp % 2;
                counter++;
                temp = temp / 2;
            }
            int[] tempArray = new int[counter];
            temp = number;
            counter--;
            while (temp > 0) {
                remainder = temp % 2;
                tempArray[counter] = remainder;
                temp = temp / 2;
                counter--;
            }
            return tempArray;
        }
        if (base ==16)
        {
            String numStr = numberStr;
            int tempNum = 0;
            int tempBase = 1;
            for (int i = numStr.length() - 1; i >= 0; i--) {
                String current = numStr.substring(i, i + 1);
                tempNum += Arrays.toString(hexaArray).indexOf(current)/3 * tempBase;
                tempBase *= base;
            }
            numStr = Integer.toString(tempNum);
            int[] tempArrayStr = new int[numStr.length()];
            for (int i = 0; i < numStr.length(); i++) {
                tempArrayStr[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            String newNumStr = "";
            for (int i = 0;i<tempArrayStr.length;i++)
            {
                newNumStr = newNumStr + tempArrayStr[i];
            }
            int newNum = Integer.parseInt(newNumStr);
            temp = newNum;
            counter = 0;
            remainder = 0;
            while (temp > 0) {
                remainder = temp % 2;
                counter++;
                temp = temp / 2;
            }
            int[] tempArray = new int[counter];
            temp = newNum;
            counter--;
            while (temp > 0) {
                remainder = temp % 2;
                tempArray[counter] = remainder;
                temp = temp / 2;
                counter--;
            }
            return tempArray;
        }
        if (base == 8) {
            String numStr = Integer.toString(number);
            int tempNum = 0;
            int tempBase = 1;
            for (int i = numStr.length() - 1; i >= 0; i--) {
                tempNum += Integer.parseInt(numStr.substring(i, i + 1)) * tempBase;
                tempBase *= base;
            }
            numStr = Integer.toString(tempNum);
            int[] decArray = new int[numStr.length()];
            for (int i = 0; i < numStr.length(); i++) {
                decArray[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            String decNum = "";
            for (int i = 0; i < decArray.length; i++) {
                decNum = decNum + decArray[i];
            }
            temp = Integer.parseInt(decNum);
            while (temp > 0)
            {
                remainder = temp % 2;
                counter++;
                temp = temp / 2;
            }
            int[] tempArray = new int[counter];
            temp = Integer.parseInt(decNum);
            counter--;
            while (temp > 0)
            {
                remainder = temp % 2;
                tempArray[counter] = remainder;
                temp = temp / 2;
                counter--;
            }
            return tempArray;
        }
        return null;
    }

    public int[] convertToOctal() {
        int temp = number;
        int counter = 0;
        int remainder = 0;
        if (base == 10) {
            while (temp > 0) {
                remainder = temp % 8;
                counter++;
                temp = temp / 8;
            }
            int[] tempArray = new int[counter];
            temp = number;
            counter--;
            while (temp > 0) {
                remainder = temp % 8;
                tempArray[counter] = remainder;
                temp = temp / 8;
                counter--;
            }
            return tempArray;
        }
        if (base ==16)
        {
            String numStr = numberStr;
            int tempNum = 0;
            int tempBase = 1;
            for (int i = numStr.length() - 1; i >= 0; i--) {
                String current = numStr.substring(i, i + 1);
                tempNum += Arrays.toString(hexaArray).indexOf(current)/3 * tempBase;
                tempBase *= base;
            }
            numStr = Integer.toString(tempNum);
            int[] tempArrayStr = new int[numStr.length()];
            for (int i = 0; i < numStr.length(); i++) {
                tempArrayStr[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            String newNumStr = "";
            for (int i = 0;i<tempArrayStr.length;i++)
            {
                newNumStr = newNumStr + tempArrayStr[i];
            }
            int newNum = Integer.parseInt(newNumStr);
            temp = newNum;
            counter = 0;
            remainder = 0;
            while (temp > 0) {
                remainder = temp % 8;
                counter++;
                temp = temp / 8;
            }
            int[] tempArray = new int[counter];
            temp = newNum;
            counter--;
            while (temp > 0) {
                remainder = temp % 8;
                tempArray[counter] = remainder;
                temp = temp / 8;
                counter--;
            }
            return tempArray;
        }
        if (base == 2) {
            String numString = Integer.toString(number);
            if (numString.length() % 3 == 0) {
                counter = numString.length() / 3;
            } else {
                counter = numString.length() / 3 + 1;
            }
            int[] tempArray = new int[counter];
            counter = 0;
            int counter2 = 0;
            int temp2 = 0;
            String ans = "";
            for (int i = numString.length() - 1; i >= 0; i--) {
                if (counter == 0) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1));
                    counter++;
                    counter2++;
                } else if (counter == 1) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1)) * 2;
                    counter++;
                    counter2++;
                } else if (counter == 2) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1)) * 4;
                    counter = 0;
                    counter2++;
                }
                if (counter2 == 3) {
                    ans = temp2 + ans;
                    temp2 = 0;
                    counter2 = 0;
                }
            }
            if(!(numString.length()%3==0)){
                ans = temp2 + ans;
            }
            for (int i = 0; i < tempArray.length; i++) {
                if (ans.length() > 0) {
                    tempArray[i] = Integer.parseInt(ans.substring(i, i + 1));
                }
            }
            return tempArray;
        }
        return null;
    }

    public String[] convertToHex()
    {
        int temp = number;
        int counter = 0;
        int remainder = 0;
        if (base == 10)
        {
            while (temp > 0)
            {
                remainder = temp % 16;
                counter++;
                temp = temp / 16;
            }
            String[] tempArray = new String[counter];
            temp = number;
            counter--;
            while (temp > 0)
            {
                remainder = temp % 16;
                tempArray[counter] = hexaArray[remainder];
                temp = temp / 16;
                counter--;
            }
            return tempArray;
        }
        if (base == 2)
        {
            String numString = Integer.toString(number);
            if (numString.length() % 4 == 0)
            {
                counter = numString.length() / 4;
            } else {
                counter = numString.length() / 4 + 1;
            }
            String[] tempArray = new String[counter];
            counter = 0;
            int counter2 = 0;
            int counter3 = tempArray.length - 1; //counts the array index to place the hex number
            int temp2 = 0;
            for (int i = numString.length() - 1; i >= 0; i--) {
                if (counter == 0) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1));
                    counter++;
                    counter2++;
                } else if (counter == 1) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1)) * 2;
                    counter++;
                    counter2++;
                } else if (counter == 2) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1)) * 4;
                    counter++;
                    counter2++;
                } else if (counter == 3) {
                    temp2 += Integer.parseInt(numString.substring(i, i + 1)) * 8;
                    counter = 0;
                    counter2++;
                }
                if (counter2 == 4) {
                    tempArray[counter3] = hexaArray[temp2];
                    counter3--;
                    temp2 = 0;
                    counter2 = 0;
                }
            }
            if (!(counter3 ==-1))
            {
                tempArray[counter3] = hexaArray[temp2];
            }
            return tempArray;
        }
        if (base == 8) {
            int[] decimal = convertToDecimal();
            String numStr = "";
            for (int i =0;i<decimal.length;i++)
            {
                numStr = numStr+decimal[i];
            }
            temp = Integer.parseInt(numStr);
            counter = 0;
            remainder = 0;
            while (temp > 0) {
                remainder = temp % 16;
                counter++;
                temp = temp / 16;
            }
            String[] tempArray = new String[counter];
            temp = Integer.parseInt(numStr);
            counter--;
            while (temp > 0) {
                remainder = temp % 16;
                tempArray[counter] = hexaArray[remainder];
                temp = temp / 16;
                counter--;
            }
            return tempArray;
        }
        return null;
    }
    public String[] convertToMC(int targetBase)
    {
        int temp = number;
        int counter = 0;
        int remainder = 0;
        while (temp > 0)
        {
            remainder = temp % targetBase;
            counter++;
            temp = temp / targetBase;
        }
        String[] tempArray = new String[counter];
        temp = number;
        counter--;
        while (temp > 0)
        {
            remainder = temp % targetBase;
            tempArray[counter] = minecraftBaseArray[remainder];
            temp = temp / targetBase;
            counter--;
        }
        return tempArray;
    }

}
