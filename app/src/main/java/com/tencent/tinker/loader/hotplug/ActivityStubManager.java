package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager {
    private static Map<String, String> AjK = new HashMap();
    private static final int[] AjL = new int[]{10, 3};
    private static final int[] AjM = new int[]{10, 3};
    private static final int[] AjN = new int[]{10, 3};
    private static final int[] AjO = new int[]{10, 3};
    private static final int[] AjP = new int[]{0, 0};
    private static final int[] AjQ = new int[]{0, 0};
    private static final int[] AjR = new int[]{0, 0};
    private static final int[] AjS = new int[]{0, 0};

    public static String s(String str, int i, boolean z) {
        String str2 = (String) AjK.get(str);
        if (str2 != null) {
            return str2;
        }
        int[] iArr;
        int[] iArr2;
        String str3;
        int i2;
        String str4;
        int[] iArr3;
        switch (i) {
            case 1:
                str4 = ActivityStubs.AjV;
                iArr3 = AjQ;
                iArr = AjM;
                iArr2 = iArr3;
                str2 = str4;
                break;
            case 2:
                str4 = ActivityStubs.AjW;
                iArr3 = AjR;
                iArr = AjN;
                iArr2 = iArr3;
                str2 = str4;
                break;
            case 3:
                str4 = ActivityStubs.AjX;
                iArr3 = AjS;
                iArr = AjO;
                iArr2 = iArr3;
                str2 = str4;
                break;
            default:
                str4 = ActivityStubs.AjU;
                iArr3 = AjP;
                iArr = AjL;
                iArr2 = iArr3;
                str2 = str4;
                break;
        }
        if (z) {
            str3 = str2 + "_T";
            i2 = 1;
        } else {
            str3 = str2;
            i2 = 0;
        }
        int i3 = iArr2[i2];
        iArr2[i2] = i3 + 1;
        if (i3 >= iArr[i2]) {
            iArr2[i2] = 0;
            i2 = 0;
        } else {
            i2 = i3;
        }
        str2 = String.format(str3, new Object[]{Integer.valueOf(i2)});
        AjK.put(str, str2);
        return str2;
    }

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }
}
