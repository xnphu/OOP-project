package main;

public class LCS {

    private float score = 0;

    public float LCSubStr(String X, String Y) {
        //thay ki tu dac biet -> " "
        for (int i = 0; i < X.length(); i++) {
            if (Character.isAlphabetic(X.codePointAt(i))) {
                continue;
            } else {
                X = X.replace(X.charAt(i), ' ');
            }
        }
        for (int i = 0; i < Y.length(); i++) {
            if (Character.isAlphabetic(Y.codePointAt(i))) {
                continue;
            } else {
                Y = Y.replace(Y.charAt(i), ' ');
            }
        }

        X = X.trim().toLowerCase();
        Y = Y.trim().toLowerCase();

        int m = X.length();
        int n = Y.length();

        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    LCStuff[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCStuff[i][j]);
                } else {
                    LCStuff[i][j] = 0;
                }
            }
        }
        score = (float) result / Y.length() * 10;

        return score;
    }
}
