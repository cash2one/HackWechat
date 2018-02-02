package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c {
    public static final int[] mKa = new int[]{65536};
    public static final int[] mKb = new int[]{196608};
    public static final int[] mKc = new int[]{262144};
    public static final int[] mKd = new int[]{327680};
    public static final int[] mKe = new int[]{393216};
    public static final int[] mKf = new int[]{458752};
    public static final int[] mKg = new int[]{131073, 131074};
    public static final int[] mKh = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131076};
    public static final int[] mKi = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131076};
    public static final int[] mKj = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    public static final int[] mKk = new int[]{131073, 131074};
    public static final int[] mKl = new int[]{131077, 131078};
    public static final int[] mKm = new int[]{131079, 131080};
    public static final int[] mKn = new int[]{5, 6, 7, 1, 2, 3};
    public static final Map<Integer, Integer> mKo;
    public static final int[] mKp = new int[]{2, 3, 6, 7};
    public static final int[] mKq = new int[]{29, 30, 31, 34, 35, 36, 33, 32, 37};
    public static final int[] mKr;
    public static final int[] mKs;
    public static final int[] mKt = new int[43];
    public static final int[] mKu = new int[27];
    public static final String mKv = (com.tencent.mm.loader.stub.a.bnF + "fts/");

    public static final class a {
        public static final Pattern mKA;
        public static final Pattern mKB;
        public static final Pattern mKC = Pattern.compile("\\s+");
        public static final Pattern mKD = Pattern.compile(",");
        public static final Pattern mKE = Pattern.compile("[A-Za-z]+");
        public static final Pattern mKw = Pattern.compile(";");
        public static final Pattern mKx = Pattern.compile(" ");
        public static final Pattern mKy = Pattern.compile("​");
        public static final Pattern mKz = Pattern.compile("‌");

        static {
            Pattern compile = Pattern.compile("‍");
            mKA = compile;
            mKB = compile;
        }
    }

    static {
        int i;
        int i2 = 0;
        int[] iArr = new int[]{8, 9, 10};
        mKr = iArr;
        mKs = iArr;
        int[] iArr2 = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080};
        int[] iArr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0};
        int[] iArr4 = new int[]{1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0};
        Map hashMap = new HashMap();
        for (i = 0; i < 9; i++) {
            hashMap.put(Integer.valueOf(iArr2[i]), Integer.valueOf(i));
        }
        mKo = Collections.unmodifiableMap(hashMap);
        for (i = 0; i < 43; i++) {
            mKt[iArr3[i]] = i;
        }
        while (i2 < 27) {
            mKu[iArr4[i2]] = i2;
            i2++;
        }
    }
}
