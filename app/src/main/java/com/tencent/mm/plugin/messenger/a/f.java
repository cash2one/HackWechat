package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static d ooo;

    public static d aZh() {
        if (ooo == null) {
            ooo = new b();
        }
        if (ooo instanceof b) {
            x.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
        }
        return ooo;
    }
}
