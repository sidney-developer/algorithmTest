import java.util.*;

public class question6 {

    public static int findMaximumMaximaCount(String categories) {

        HashMap<Character, Integer> frequency= new HashMap<>();
        HashMap<Character, Integer> maxCountMap= new HashMap<>();

        int maxFrequency=0;
        int maxCount=0;
        Set<Character> maxCountChars= new HashSet<>();
        char[] chars = categories.toCharArray();

        for (Character ch: chars) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) +1);
            if (frequency.get(ch) > maxFrequency) {
                maxFrequency= frequency.get(ch);
                maxCountChars.clear();
                maxCountChars.add(ch);
                maxCountMap.put(ch, maxCountMap.getOrDefault(ch,0)+1);
                maxCount= Math.max(maxCount, maxCountMap.get(ch));
            }else if (frequency.get(ch)== maxFrequency) {
                maxCountChars.add(ch);
                for (char cc: maxCountChars) {
                    maxCountMap.put(cc, maxCountMap.getOrDefault(cc, 0)+1);
                    maxCount= Math.max(maxCount, maxCountMap.get(cc));
                }
            }else {
                for (char cc: maxCountChars) {
                    maxCountMap.put(cc, maxCountMap.getOrDefault(cc, 0)+1);
                    maxCount= Math.max(maxCount, maxCountMap.get(cc));
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String categories = "adbcbcbcc";
        int result = findMaximumMaximaCount(categories);
        System.out.println("The maximum MaximaCount is: " + result);
    }
}
