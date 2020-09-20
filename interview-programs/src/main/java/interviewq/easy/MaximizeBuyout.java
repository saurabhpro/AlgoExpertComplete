package interviewq.easy;

public class MaximizeBuyout {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
        int maxValueUtilized = -1;

        for (int k : keyboards) {
            for (int d : drives) {
                int currentSum = k + d;
                if (currentSum > maxValueUtilized && currentSum <= budget) {
                    maxValueUtilized = currentSum;
                }
            }
        }


        return maxValueUtilized;
    }

    public static void main(String[] args) {

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int[] keyboards = {3, 1};
        int[] drives = {5, 3, 8};
        int budget = 10;
        int moneySpent = getMoneySpent(keyboards, drives, budget);

        System.out.println(moneySpent);
    }
}
