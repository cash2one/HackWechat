package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t$a;

class PluginBigBallOfMud$10 implements t$a {
    final /* synthetic */ PluginBigBallOfMud kvG;

    PluginBigBallOfMud$10(PluginBigBallOfMud pluginBigBallOfMud) {
        this.kvG = pluginBigBallOfMud;
    }

    public final boolean a(String str, String str2, PInt pInt) {
        if (!s.gF(str)) {
            return false;
        }
        if (f.eE(str)) {
            if (e.kn(str2)) {
                pInt.value = 5;
            } else {
                pInt.value = 4;
            }
        } else if (f.jW(str)) {
            pInt.value = 3;
        } else if (f.jX(str)) {
            pInt.value = 0;
        } else if (f.jT(str)) {
            pInt.value = 6;
        } else {
            pInt.value = 7;
        }
        return true;
    }
}
