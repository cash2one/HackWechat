package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import com.tencent.mm.pluginsdk.cmd.a;

class o$a implements a {
    o$a() {
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        boolean z = true;
        switch (str.hashCode()) {
            case -1912590262:
                if (str.equals("//cleanpaycn")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                com.tencent.mm.wallet_core.c.a.cBn();
                com.tencent.mm.wallet_core.c.a.clean();
                return true;
            default:
                return false;
        }
    }
}
