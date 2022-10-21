import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Translate {
    TreeMap<Integer, String> intToRomanMap = new TreeMap<>();

    {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");
    }

    public String intToRoman(int input){
        String roman = "";
        int arabic;
        do{
            arabic = intToRomanMap.floorKey(input);
            roman += intToRomanMap.get(arabic);
            input -= arabic;
        } while(input != 0);
        return roman;
    }

    TreeMap<Character, Integer> romanToIntMap = new TreeMap<>();
    {
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
    }

    public int translateToArabic(String input){

        int arabic = 0;
        int previous = 0;
        for(int i = input.length() - 1; i >= 0; i--){
            int current = romanToIntMap.get(input.charAt(i));
            if(current < previous){
                arabic -= current;
            } else {
                arabic += current;
            }
            previous = current;
        }
        return arabic;
    }
}
