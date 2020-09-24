package interviewq.easy;

public class Q15_CaesarCypherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {

        final StringBuilder sb = new StringBuilder();

        // if key is super big
        final int newKey = key % 26;

        for (char c : str.toCharArray()) {
            char encryptedCharacter = (char) (c + newKey);

            if (encryptedCharacter > 'z') {
                int newCharIdx = encryptedCharacter - 'z' - 1;// 0 based indexing so that we can add it to 'a'
                encryptedCharacter = (char) ('a' + newCharIdx);
            }

            sb.append(encryptedCharacter);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final String cypherEncryptor = caesarCypherEncryptor("xyz", 2);
        System.out.println(cypherEncryptor);
    }
}
