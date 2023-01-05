public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
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
        return null;
    }

    public int[] convertToBinary() {
        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}

