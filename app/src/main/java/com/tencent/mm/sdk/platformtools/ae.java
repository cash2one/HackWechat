package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class ae {
    private static Set<String> xfw = new HashSet();

    public static boolean Vc(String str) {
        if (Ve(str)) {
            x.d("MicroMsg.MMEntryLock", "locked-" + str);
            return false;
        }
        x.d("MicroMsg.MMEntryLock", "lock-" + str);
        return xfw.add(str);
    }

    public static void Vd(String str) {
        xfw.remove(str);
        x.d("MicroMsg.MMEntryLock", "unlock-" + str);
    }

    public static boolean Ve(String str) {
        return xfw.contains(str);
    }
}
