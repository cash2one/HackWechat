package com.tencent.mm.c;

public final class j {
    public static int ck(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                }
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }
}
