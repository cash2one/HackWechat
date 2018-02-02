package com.tencent.mm.plugin.appbrand.game.e;

public final class g {
    private static String[][] jat;

    static {
        r0 = new String[8][];
        r0[0] = new String[]{"\\", "\\\\"};
        r0[1] = new String[]{"'", "\\'"};
        r0[2] = new String[]{"\"", "\\\""};
        r0[3] = new String[]{"\n", "\\n"};
        r0[4] = new String[]{"\t", "\\t"};
        r0[5] = new String[]{"\b", "\\b"};
        r0[6] = new String[]{"\f", "\\f"};
        r0[7] = new String[]{"\r", "\\r"};
        jat = r0;
    }

    public static String rV(String str) {
        int i = (str == null || str.length() == 0) ? 1 : 0;
        if (i == 0) {
            for (CharSequence[] charSequenceArr : jat) {
                str = str.replace(charSequenceArr[0], charSequenceArr[1]);
            }
        }
        return str;
    }
}
