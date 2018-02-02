package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.d;
import java.util.UnknownFormatConversionException;

public final class g {
    static int zVA = 5;
    static int zVB = 16;
    static char[] zVC = new char[16];
    static String zVD = "dex2oat-cmdline";
    static long zVE = 4096;

    public static String abb(String str) {
        d dVar = new d(str);
        dVar.a(zVC);
        dVar.Aan = zVC[zVA] == '\u0001';
        dVar.Aal.seek(zVE);
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        dVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            dVar.a(cArr2);
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            if (cArr2[1] <= '4') {
                dVar.readInt();
                dVar.readInt();
                dVar.readInt();
            }
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            dVar.readInt();
            cArr = new char[dVar.readInt()];
            dVar.a(cArr);
            return abc(new String(cArr));
        }
        throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[]{Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])}));
    }

    private static String abc(String str) {
        String[] split = str.split(new String("\u0000"));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            i = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(zVD)) {
                return str3;
            }
        }
        return "";
    }
}
