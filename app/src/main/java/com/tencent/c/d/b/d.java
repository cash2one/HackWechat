package com.tencent.c.d.b;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {
    public static List<a> cDu() {
        List arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0') {
                            a HP = HP(Integer.parseInt(str));
                            if (HP != null) {
                                arrayList.add(HP);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return arrayList;
    }

    private static String HO(int i) {
        try {
            String str = "";
            byte[] dG = a.dG(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)}), 100);
            if (dG != null) {
                str = new String(dG, 0, a(dG, 0, '\u0000'));
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            dG = a.dG(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
            if (dG == null) {
                return str;
            }
            int a = a(dG, 7, '\n');
            if (a == 0) {
                return "";
            }
            return new String(dG, 6, a - 6);
        } catch (Throwable th) {
            return "";
        }
    }

    private static int a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    private static a HP(int i) {
        String HO;
        String trim;
        int a;
        int i2;
        try {
            HO = HO(i);
            try {
                int parseInt;
                byte[] dG = a.dG(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (dG != null) {
                    a = a(dG, 7, '\n');
                    if (a != 0) {
                        a = a(dG, a(dG, a(dG, a + 1, '\n') + 1, '\n') + 1, '\n');
                        if (a != 0) {
                            i2 = a + 7;
                            int a2 = a(dG, a + 1, '\n');
                            if (a2 != 0) {
                                a = Integer.parseInt(new String(dG, i2, a2 - i2));
                                try {
                                    i2 = a(dG, a2 + 1, '\n');
                                    if (i2 != 0) {
                                        i2 += 6;
                                        parseInt = Integer.parseInt(new String(dG, i2, a(dG, i2 + 1, '\t') - i2));
                                    } else {
                                        parseInt = -1;
                                    }
                                    i2 = parseInt;
                                } catch (Exception e) {
                                    i2 = -1;
                                    trim = new String(a.aaS(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                    if (HO != null) {
                                    }
                                    return null;
                                }
                                trim = new String(a.aaS(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                if (HO != null || a == -1 || i2 == -1) {
                                    return null;
                                }
                                return new a(i, a, HO, i2, trim);
                            }
                        }
                    }
                }
                parseInt = -1;
                a = -1;
                i2 = parseInt;
            } catch (Exception e2) {
                a = -1;
                i2 = -1;
                trim = new String(a.aaS(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                if (HO != null) {
                }
                return null;
            }
        } catch (Exception e3) {
            a = -1;
            HO = null;
            i2 = -1;
            trim = new String(a.aaS(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
            if (HO != null) {
            }
            return null;
        }
        try {
            trim = new String(a.aaS(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
        } catch (Exception e4) {
            trim = null;
        }
        if (HO != null) {
        }
        return null;
    }
}
