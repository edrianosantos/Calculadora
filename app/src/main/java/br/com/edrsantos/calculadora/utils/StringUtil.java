package br.com.edrsantos.calculadora.utils;

/**
 * Created by slimv on 4/4/2018.
 */

public class StringUtil {
    public StringUtil() {
    }

    public static String removeCharacters(String x, char... cs) {
        char[] var5 = cs;
        int var4 = cs.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            char c = var5[var3];
            x = x.replaceAll("[" + String.valueOf(c) + "]", "");
        }

        return x;
    }
}
