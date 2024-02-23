package amazon;

public class _15_MaximizeAZ {

    public static void main(String[] args) {
        String s1= "AKZ";
        String s2="A";
        System.out.println(getMaximumAZ(s1));
        System.out.println(getMaximumAZ(s2));
    }

    // 先遍历一遍，碰到一个z就看他前面的a的数量，然后总数加上当前a的数量。遍历结束后看a多还是z多， 总数再加上两者较大的就得到答案了。
    public static int getMaximumAZ (String str) {

        char[] chs = str.toCharArray();
        int numA=0;
        int numZ=0;
        int count=0;
        for (int i=0; i<chs.length; i++) {
            if (chs[i]=='A') {
                numA++;
            }
            if (chs[i]=='Z') {
                count += numA;
                numZ++;
            }
        }
        return count + (numA> numZ ? numA: numZ);
    }

}
