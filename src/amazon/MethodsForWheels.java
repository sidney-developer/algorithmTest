package amazon;

public class MethodsForWheels {

    public static int getNumforWheels(int wheels) {
        if (wheels % 2 ==1) {
            return 0;
        }
        int nums= wheels/2;
        int count=1;
        while (nums>0) {
            count++;
            nums-= 2;
        }
        if (nums<0) {
            count--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getNumforWheels(4));
        System.out.println(getNumforWheels(5));
        System.out.println(getNumforWheels(6));
    }

}
