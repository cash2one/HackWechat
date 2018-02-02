package com.tencent.mm.plugin.appbrand.collector;

import java.util.HashSet;
import java.util.Set;

public final class c {
    private static b iLK = new h();
    private static boolean iLL;
    private static final Set<String> iLM = new HashSet();

    public static void qp(String str) {
        if (str.length() != 0) {
            iLM.add(str);
        }
    }

    public static void qq(String str) {
        if (str.length() != 0) {
            iLM.remove(str);
        }
    }

    public static boolean qr(String str) {
        if (str.length() == 0) {
            return false;
        }
        return iLM.contains(str);
    }

    public static void cs(boolean z) {
        iLL = z;
    }

    public static boolean abq() {
        return iLL;
    }

    private static boolean qs(String str) {
        return iLL && iLM.contains(str);
    }

    private static boolean qt(String str) {
        if (!iLL) {
            return false;
        }
        CollectSession qm = iLK.qm(str);
        if (qm == null || !iLM.contains(qm.groupId)) {
            return false;
        }
        return true;
    }

    public static void clear() {
        if (iLL) {
            iLK.clear();
        }
    }

    public static void b(String str, String str2, String str3, boolean z) {
        if (qs(str)) {
            iLK.b(str, str2, str3, z);
        }
    }

    public static void aS(String str, String str2) {
        if (qt(str)) {
            iLK.aS(str, str2);
        }
    }

    public static void a(CollectSession collectSession) {
        if (collectSession != null && qs(collectSession.groupId)) {
            iLK.a(collectSession);
        }
    }

    public static CollectSession aR(String str, String str2) {
        if (qt(str)) {
            return iLK.aR(str, str2);
        }
        return null;
    }

    public static void c(String str, String str2, boolean z) {
        if (qt(str)) {
            iLK.c(str, str2, z);
        }
    }

    public static CollectSession qm(String str) {
        if (qt(str)) {
            return iLK.qm(str);
        }
        return null;
    }

    public static CollectSession qn(String str) {
        if (iLL) {
            return iLK.qn(str);
        }
        return null;
    }

    public static void print(String str) {
        if (qt(str)) {
            iLK.print(str);
        }
    }

    public static int aT(String str, String str2) {
        if (qs(str)) {
            return iLK.aT(str, str2);
        }
        return 0;
    }

    public static StringBuilder qo(String str) {
        if (qs(str)) {
            return iLK.qo(str);
        }
        return new StringBuilder();
    }
}
