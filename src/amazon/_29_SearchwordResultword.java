package amazon;

public class _29_SearchwordResultword {

    public static void main(String[] args) {
        String searchWord= "armaze";
        String resultWord= "amazon";
        System.out.println(getResultWordNum(searchWord, resultWord));
    }

    public static int getResultWordNum (String searchWord, String resultWord) {

        int point_searchWord=0;
        int point_resultWord=0;
        int searchLength= searchWord.length();
        int resultLength= resultWord.length();
        char[] searchChs= searchWord.toCharArray();
        char[] resultChs= resultWord.toCharArray();
        while (point_searchWord< searchLength && point_resultWord < resultLength) {
            if (searchChs[point_searchWord]== resultChs[point_resultWord]) {
                point_searchWord++;
                point_resultWord++;
            }else {
                point_searchWord++;
            }
        }
        return resultLength- point_resultWord;
    }
}
