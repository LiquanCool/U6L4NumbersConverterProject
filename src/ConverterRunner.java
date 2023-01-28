import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 , 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        boolean acceptable = false;
        int n = 0;
        String m = "";
        String number = "";
        while (!acceptable)
        {
            System.out.print("Enter your number: ");
            number = s.nextLine();
            acceptable = NumberConverter.numberChecker(base, number);
            if (!acceptable)
            {
                System.out.println("That is not a acceptable number! Try again.");
                System.out.print("Enter the base of your number (2, 8 , 10, or 16): ");
                base = Integer.parseInt(s.nextLine());
            }
        }
        if (base == 16)
        {
            m = number;
            s.close();
            NumberConverter nc = new NumberConverter(m, base);
            String[] digits = nc.getDigits();
            System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());
            System.out.println("Binary Number: " + Arrays.toString(nc.convertToBinary()));
            System.out.println("Octal Number: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Decimal Number: " + Arrays.toString(nc.convertToDecimal()));
        }
        else
        {
            n = Integer.parseInt(number);
            NumberConverter nc = new NumberConverter(n, base);
            if (base == 2)
            {
                System.out.println("Octal Number: " + Arrays.toString(nc.convertToOctal()));
                System.out.println("Decimal Number: " + Arrays.toString(nc.convertToDecimal()));
                System.out.println("Hexadecimal Number: " + Arrays.toString(nc.convertToHex()));
            }
            if (base == 8)
            {
                System.out.println("Binary Number: " + Arrays.toString(nc.convertToBinary()));
                System.out.println("Decimal Number: " + Arrays.toString(nc.convertToDecimal()));
                System.out.println("Hexadecimal Number: " + Arrays.toString(nc.convertToHex()));
            }
            if (base == 10)
            {
                System.out.print("To convert to a specific base (1-64), enter i\nTo convert normally enter n or anything else:");
                String ans = s.nextLine();
                if (ans.equals("i"))
                {
                    //add check here with 64 base
                    System.out.print("What base do you want to convert to:");
                    ans = s.nextLine();
                    System.out.println("Converted Number: " + Arrays.toString(nc.convertToMC(Integer.parseInt(ans))));
                }
                else
                {
                    System.out.println("Binary Number: " + Arrays.toString(nc.convertToBinary()));
                    System.out.println("Octal Number: " + Arrays.toString(nc.convertToOctal()));
                    System.out.println("Hexadecimal Number: " + Arrays.toString(nc.convertToHex()));
                }
            }
        }


    }
}

