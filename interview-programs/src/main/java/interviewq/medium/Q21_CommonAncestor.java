package interviewq.medium;

public class Q21_CommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor,
                                                          AncestralTree descendantOne,
                                                          AncestralTree descendantTwo) {

        while (descendantOne.ancestor != descendantTwo.ancestor) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        if (descendantOne.ancestor.name == topAncestor.name) {
            return descendantOne;
        }

        return null;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
