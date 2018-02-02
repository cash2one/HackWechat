package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.k.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class a {
    public static boolean az(int i, String str) {
        if (i != 22 || bh.ov(str)) {
            return false;
        }
        Set boy;
        if (ac.cfw() || (Looper.myLooper() == Looper.getMainLooper() && !g.fk("com.tencent.mm"))) {
            boy = boy();
        } else {
            Set hashSet = new HashSet();
            Bundle a = f.a("com.tencent.mm", null, a.class);
            String str2 = "";
            if (a != null) {
                str2 = a.getString("wxCodePrefix", "");
            }
            String[] split = str2.split("|");
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!bh.ov(split[i2])) {
                    hashSet.add(split[i2]);
                }
            }
            boy = hashSet;
        }
        for (String str22 : r0) {
            if (str.startsWith(str22)) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> boy() {
        Set<String> hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (ac.cfw()) {
            String F;
            String str = "";
            c zZ = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zZ();
            if (zZ != null) {
                F = zZ.F("ScanCode", "weAppCodePrefix");
            } else {
                F = str;
            }
            x.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[]{F});
            if (!bh.ov(F)) {
                String[] split = F.split("|");
                for (int i = 0; i < split.length; i++) {
                    if (!bh.ov(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        return hashSet;
    }
}
