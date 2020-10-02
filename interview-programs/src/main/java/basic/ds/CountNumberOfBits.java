package basic.ds;

class CountNumberOfBits {
    static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n >>>= 1;
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args) {
        int i = 7;
        System.out.println(countBits(i));
    }
} 