package com.tencent.mm.plugin.game.gamewebview.e;

import com.tencent.mm.protocal.c.alr;
import java.util.HashMap;

public final class a {
    private static final HashMap<String, alr> nav = new HashMap();

    public static boolean bx(String str, String str2) {
        alr com_tencent_mm_protocal_c_alr = (alr) nav.get(str + "#" + str2);
        if (com_tencent_mm_protocal_c_alr == null || com_tencent_mm_protocal_c_alr.vJs != 1) {
            return false;
        }
        return true;
    }
}
