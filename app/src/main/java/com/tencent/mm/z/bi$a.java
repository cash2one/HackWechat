package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.bh;

class bi$a {
    public static boolean U(String str, String str2) {
        if (bh.ov(str)) {
            return true;
        }
        String decode = decode(encode(str));
        if (bh.ov(decode) || !decode.equals(str2)) {
            return true;
        }
        return false;
    }

    private static String encode(String str) {
        char[] toCharArray = str.toCharArray();
        String str2 = "";
        try {
            int length = toCharArray.length;
            String str3 = str2;
            int i = 0;
            while (i < length) {
                char c = toCharArray[i];
                i++;
                str3 = str3 + String.format("%02x", new Object[]{Integer.valueOf(c)});
            }
            return str3;
        } catch (Exception e) {
            return "";
        }
    }

    private static String decode(String str) {
        String str2 = "";
        if (bh.ov(str) || str.length() % 2 != 0) {
            return "";
        }
        String str3 = str2;
        int i = 0;
        while (i < str.length()) {
            try {
                String str4 = str3 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                i += 2;
                str3 = str4;
            } catch (Exception e) {
                return "";
            }
        }
        return str3;
    }
}
