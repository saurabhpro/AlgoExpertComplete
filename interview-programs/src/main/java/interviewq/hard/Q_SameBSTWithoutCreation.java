package interviewq.hard;

import java.util.List;

public class Q_SameBSTWithoutCreation {
    public static boolean sameBSTs(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        // both are empty
        if (arrayOne.isEmpty()) {
            return true;
        }

        if (!arrayOne.get(0).equals(arrayTwo.get(0))) {
            return false;
        }

        

        return false;
    }
}
