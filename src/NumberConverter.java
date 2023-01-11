public class NumberConverter {
    int[] digits;
    int base;
    int number;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        this.number = number;
    }
    public boolean NumberChecker(int base)
    {
        if (base == 2)
        {
            for (int i = 0; i < digits.length; i++)
            {
                if (!(digits[i] == 0 || digits[i] == 1))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        String numStr = Integer.toString(number);
        int tempNum = 0;
        int tempBase = 1;
        for (int i = numStr.length()-1;i >= 0;i--)
        {
            tempNum += Integer.parseInt(numStr.substring(i,i+1))*tempBase;
            tempBase*= base;
        }
        numStr = Integer.toString(tempNum);
        int[] tempArray = new int[numStr.length()];
        for (int i = 0;i < numStr.length();i++)
        {
            tempArray[i] = Integer.parseInt(numStr.substring(i,i+1));
        }
        return tempArray;
    }

    public int[] convertToBinary()
    {
        int temp = number;
        int counter = 0;
        int remainder = 0;
        if (base== 10)
        {
            while (temp > 0)
            {
                remainder = temp%2;
                counter++;
                temp = temp/2;
            }
            int[] tempArray = new int[counter];
            temp = number;
            counter--;
            while (temp > 0)
            {
                remainder = temp%2;
                tempArray[counter] = remainder;
                temp = temp/2;
                counter--;
            }
            return tempArray;
        }
        return null;
    }

    public int[] convertToOctal()
    {
        int temp = number;
        int counter = 0;
        int remainder = 0;
        if (base== 10)
        {
            while (temp > 0)
            {
                remainder = temp%8;
                counter++;
                temp = temp/8;
            }
            int[] tempArray = new int[counter];
            temp = number;
            counter--;
            while (temp > 0)
            {
                remainder = temp%8;
                tempArray[counter] = remainder;
                temp = temp/8;
                counter--;
            }
            return tempArray;
        }
        return null;
    }
}

