package com.tencent.mm.plugin.fts.a;

import android.database.DatabaseUtils;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static final HashMap<String, String> mKF = new HashMap();
    private static String[] mKG = new String[]{"wxid_", "wx_", "gh_"};

    public static String Bb(String str) {
        if (s.eV(str)) {
            return str;
        }
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO == null) {
            return str;
        }
        if (!bh.ov(WO.field_conRemarkPYFull)) {
            return WO.field_conRemarkPYFull;
        }
        if (!bh.ov(WO.vR())) {
            return WO.vR();
        }
        if (bh.ov(WO.vN())) {
            return str;
        }
        return WO.vN();
    }

    public static final HashMap<String, String> aMV() {
        HashMap<String, String> hashMap = new HashMap();
        for (Entry entry : mKF.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public static final void aS(List<j> list) {
        mKF.clear();
        for (j jVar : list) {
            if (jVar.userData instanceof String) {
                mKF.put(jVar.mLs, (String) jVar.userData);
            } else {
                mKF.put(jVar.mLs, "");
            }
        }
    }

    public static String i(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static final String u(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str : strArr) {
            Object obj;
            stringBuilder.append("\"");
            stringBuilder.append(str);
            char charAt = str.charAt(str.length() - 1);
            if (charAt >= '0' && charAt <= '9') {
                obj = 1;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                r0 = 1;
            } else if (charAt < 'a' || charAt > 'z') {
                obj = null;
            } else {
                r0 = 1;
            }
            if (obj != null) {
                stringBuilder.append("\"* ");
            } else {
                stringBuilder.append("\" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static int c(int[] iArr, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        int i4 = i >= iArr.length ? Integer.MAX_VALUE : iArr[i];
        if (i2 < iArr.length) {
            i3 = iArr[i2];
        }
        return i4 - i3;
    }

    public static int a(Map<Integer, Integer> map, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        Integer num = (Integer) map.get(Integer.valueOf(i));
        int intValue = num == null ? Integer.MAX_VALUE : num.intValue();
        num = (Integer) map.get(Integer.valueOf(i2));
        if (num != null) {
            i3 = num.intValue();
        }
        return intValue - i3;
    }

    public static List<j> a(List<j> list, Map<Integer, Integer> map) {
        int i;
        int i2;
        Comparator 1 = new 1(map);
        j jVar = new j();
        jVar.type = 131073;
        int binarySearch = Collections.binarySearch(list, jVar, 1);
        jVar.type = 131074;
        int binarySearch2 = Collections.binarySearch(list, jVar, 1);
        if (binarySearch < 0) {
            i = (-binarySearch) - 1;
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((j) list.get(i2)).type != 131073) {
                    i = i2 + 1;
                } else {
                    binarySearch = i2;
                }
            }
            i = i2 + 1;
        }
        if (binarySearch2 < 0) {
            binarySearch = (-binarySearch2) - 1;
        } else {
            int size = list.size();
            i2 = binarySearch2 + 1;
            while (i2 < size && ((j) list.get(i2)).type == 131074) {
                i2++;
            }
            binarySearch = i2;
        }
        return list.subList(i, binarySearch);
    }

    public static final String Bc(String str) {
        if (str == null) {
            return null;
        }
        return f.Bf(((a) g.h(a.class)).ce(str.trim(), " "));
    }

    public static final String Bd(String str) {
        return f.Bf(str.toLowerCase());
    }

    public static final String Be(String str) {
        if (str != null) {
            return str.replace('*', ' ').trim();
        }
        return null;
    }

    public static String cE(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String startsWith : mKG) {
            if (str.startsWith(startsWith)) {
                return null;
            }
        }
        if (str.indexOf(64) >= 0) {
            return null;
        }
        return str;
    }

    public static String am(String str, boolean z) {
        if (str == null) {
            return null;
        }
        String toLowerCase = Bc(str).toLowerCase();
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < toLowerCase.length(); i2++) {
            char charAt = toLowerCase.charAt(i2);
            if (f.i(charAt)) {
                String[] strArr = (String[]) f.mLj.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 1) {
                    arrayList.add(" ");
                } else {
                    List arrayList2 = new ArrayList();
                    for (i = 0; i < strArr.length; i++) {
                        Object substring;
                        if (z) {
                            substring = strArr[i].substring(0, 1);
                        } else {
                            substring = strArr[i];
                        }
                        if (!arrayList2.contains(substring)) {
                            arrayList2.add(substring);
                        }
                    }
                    arrayList.add(bh.d(arrayList2, "‏"));
                    i = 1;
                }
            } else {
                arrayList.add(" ");
            }
        }
        return i != 0 ? bh.d(arrayList, "‍") : null;
    }

    public static String v(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('(');
        for (String sqlEscapeString : strArr) {
            stringBuilder.append(DatabaseUtils.sqlEscapeString(sqlEscapeString) + ',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static boolean f(int[] iArr, int i) {
        return Arrays.binarySearch(iArr, i) >= 0;
    }

    public static boolean b(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean u(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.setTimeInMillis(j2);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        if (timeInMillis == instance.getTimeInMillis()) {
            return true;
        }
        return false;
    }
}
