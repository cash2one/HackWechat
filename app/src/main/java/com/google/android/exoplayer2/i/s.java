package com.google.android.exoplayer2.i;

import android.net.Uri;
import android.text.TextUtils;

public final class s {
    public static Uri j(String str, String str2) {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] af = af(str2);
        if (af[0] != -1) {
            stringBuilder2.append(str2);
            a(stringBuilder2, af[1], af[2]);
            stringBuilder = stringBuilder2.toString();
        } else {
            int[] af2 = af(str);
            if (af[3] == 0) {
                stringBuilder = stringBuilder2.append(str, 0, af2[3]).append(str2).toString();
            } else if (af[2] == 0) {
                stringBuilder = stringBuilder2.append(str, 0, af2[2]).append(str2).toString();
            } else if (af[1] != 0) {
                r0 = af2[0] + 1;
                stringBuilder2.append(str, 0, r0).append(str2);
                stringBuilder = a(stringBuilder2, af[1] + r0, r0 + af[2]);
            } else if (str2.charAt(af[1]) == '/') {
                stringBuilder2.append(str, 0, af2[1]).append(str2);
                stringBuilder = a(stringBuilder2, af2[1], af[2] + af2[1]);
            } else if (af2[0] + 2 >= af2[1] || af2[1] != af2[2]) {
                r0 = str.lastIndexOf(47, af2[2] - 1);
                r0 = r0 == -1 ? af2[1] : r0 + 1;
                stringBuilder2.append(str, 0, r0).append(str2);
                stringBuilder = a(stringBuilder2, af2[1], r0 + af[2]);
            } else {
                stringBuilder2.append(str, 0, af2[1]).append('/').append(str2);
                stringBuilder = a(stringBuilder2, af2[1], (af[2] + af2[1]) + 1);
            }
        }
        return Uri.parse(stringBuilder);
    }

    private static String a(StringBuilder stringBuilder, int i, int i2) {
        if (i >= i2) {
            return stringBuilder.toString();
        }
        if (stringBuilder.charAt(i) == '/') {
            i++;
        }
        int i3 = i;
        int i4 = i;
        while (i3 <= i2) {
            int i5;
            if (i3 == i2) {
                i5 = i3;
            } else if (stringBuilder.charAt(i3) == '/') {
                i5 = i3 + 1;
            } else {
                i3++;
            }
            if (i3 == i4 + 1 && stringBuilder.charAt(i4) == '.') {
                stringBuilder.delete(i4, i5);
                i2 -= i5 - i4;
                i3 = i4;
            } else if (i3 == i4 + 2 && stringBuilder.charAt(i4) == '.' && stringBuilder.charAt(i4 + 1) == '.') {
                int lastIndexOf = stringBuilder.lastIndexOf("/", i4 - 2) + 1;
                if (lastIndexOf > i) {
                    i3 = lastIndexOf;
                } else {
                    i3 = i;
                }
                stringBuilder.delete(i3, i5);
                i2 -= i5 - i3;
                i3 = lastIndexOf;
                i4 = lastIndexOf;
            } else {
                i3++;
                i4 = i3;
            }
        }
        return stringBuilder.toString();
    }

    private static int[] af(String str) {
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        indexOf = str.indexOf(63);
        if (indexOf == -1 || indexOf > length) {
            indexOf = length;
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 == -1 || indexOf2 > indexOf) {
            indexOf2 = indexOf;
        }
        int indexOf3 = str.indexOf(58);
        if (indexOf3 > indexOf2) {
            indexOf3 = -1;
        }
        indexOf2 = (indexOf3 + 2 < indexOf && str.charAt(indexOf3 + 1) == '/' && str.charAt(indexOf3 + 2) == '/') ? 1 : 0;
        if (indexOf2 != 0) {
            indexOf2 = str.indexOf(47, indexOf3 + 3);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                indexOf2 = indexOf;
            }
        } else {
            indexOf2 = indexOf3 + 1;
        }
        iArr[0] = indexOf3;
        iArr[1] = indexOf2;
        iArr[2] = indexOf;
        iArr[3] = length;
        return iArr;
    }
}
