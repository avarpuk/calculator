import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Translate {
    TreeMap<Integer, String> map = new TreeMap<>();

    {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String intToRoman(int input){
        String roman = "";
        int arabic;
        do{
            arabic = map.floorKey(input);
            roman += map.get(arabic);
            input -= arabic;
        } while(input != 0);
        return roman;
    }

    TreeMap<Character, Integer> treeMap = new TreeMap<>();
    {
        treeMap.put('I', 1);
        treeMap.put('V', 5);
        treeMap.put('X', 10);
    }

    public int translateToArabic(String input){

        int arabic = 0;
        int previous = 0;
        for(int i = input.length() - 1; i >= 0; i--){
            int current = treeMap.get(input.charAt(i));
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
