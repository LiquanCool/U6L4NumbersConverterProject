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
        if (base == 10)
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
        if (base == 8)
        {
            String numAsStr = Integer.toString(number);
            String numStr = "";
            String ans = "";
            for (int i =0;i<numAsStr.length();i++)
            {
                numStr = "";
                int oneNum = Integer.parseInt(numAsStr.substring(i,i+1));
                System.out.println(oneNum);
                while (oneNum > 0)
                {
                    remainder = oneNum%2;
                    numStr = remainder+numStr;
                    oneNum = oneNum/2;
                }
                if (numStr.length()==1)
                {
                    numStr="00"+numStr;
                }
                if (numStr.length()==2)
                {
                    numStr="0"+numStr;
                }
                System.out.println(numStr);
                ans+=numStr;
            }
            while(ans.substring(0,1).equals("0"))
            {
                ans = ans.substring(1);
            }
            int[] tempArray = new int[ans.length()];
            for (int i = 0;i<tempArray.length;i++)
            {
                tempArray[i]=Integer.parseInt(ans.substring(i,i+1));
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
        if (base== 2)
        {
            String numString = Integer.toString(number);
            if (numString.length()%3==0)
            {
                counter = numString.length()/3;
            }
            else
            {
                counter = numString.length()/3+1;
            }
            int[] tempArray = new int[counter];
            counter = 0;
            int counter2 = 0;
            int temp2 = 0;
            String ans = "";
            for (int i = numString.length()-1;i>=0;i--)
            {
                if (counter ==0)
                {
                    temp2 += Integer.parseInt(numString.substring(i,i+1));
                    counter++;
                    counter2++;
                }
                else if (counter ==1)
                {
                    temp2 += Integer.parseInt(numString.substring(i,i+1))*2;
                    counter++;
                    counter2++;
                }
                else if (counter ==2)
                {
                    temp2 += Integer.parseInt(numString.substring(i,i+1))*4;
                    counter=0;
                    counter2++;
                }
                if (counter2==3)
                {
                    ans = temp2 + ans;
                    temp2 =0;
                    counter2 = 0;
                }
            }
            for (int i = 0;i<tempArray.length;i++)
            {
                tempArray[i]=Integer.parseInt(ans.substring(i,i+1));
            }
            return tempArray;
        }
        return null;
    }
}

