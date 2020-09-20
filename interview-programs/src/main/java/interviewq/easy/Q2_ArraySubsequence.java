package interviewq.easy;

import java.util.List;

public class Q2_ArraySubsequence {

    //O(n) time & O(1) space solution
    public static boolean isValidSubsequenceForLoop(List<Integer> array, List<Integer> sequence) {
        boolean rv = false;
        if (array.size() >= sequence.size()) {
            // see notes for my original O(nm) solution

            int seqIdx = 0;

            for (Integer ar : array) {
                if (seqIdx == sequence.size()) {
                    break;
                }

                if (sequence.get(seqIdx).equals(ar)) {
                    seqIdx += 1;
                }
            }

            rv = seqIdx == sequence.size();
        }

        return rv;
    }

    //O(n) time & O(1) space solution
    public static boolean isValidSubsequenceWhileLoop(List<Integer> array, List<Integer> sequence) {
        boolean rv = false;
        if (array.size() >= sequence.size()) {

            int arrIdx = 0;
            int seqIdx = 0;

            while (seqIdx < sequence.size() && arrIdx < array.size()) {
                if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                    seqIdx += 1;
                }

                arrIdx += 1;
            }

            rv = seqIdx == sequence.size();
        }

        return rv;
    }
}


//   My first solution =>  O(n m) time and O(1) space
//            rv = true;
//            int cnt = 0;
//            for (int i = 0; i < sequence.size() && rv; i++) {
//                rv = false;
//                for (int j = cnt; j < array.size(); j++) {
//                    if (array.get(j).equals(sequence.get(i))) {
//                        rv = true;
//                        cnt = j + 1;
//                        break;
//                    }
//                }
//            }