package com.tencent.mm.app;

import java.util.HashSet;
import java.util.Set;

public final class l {
    private static final Set<String> ffF;

    static {
        Set hashSet = new HashSet();
        ffF = hashSet;
        hashSet.add(":nospace");
        ffF.add(":cuploader");
        ffF.add(":dexopt");
        ffF.add(":recovery");
        ffF.add(":fallback");
    }

    public static boolean ct(String str) {
        int indexOf = str.indexOf(58);
        return ffF.contains(indexOf != -1 ? str.substring(indexOf) : "");
    }

    public static boolean tY() {
        return false;
    }
}
