package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Map;

class ReadMailUI$2 implements Runnable {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ ReadMailUI puG;
    final /* synthetic */ b puH;

    ReadMailUI$2(ReadMailUI readMailUI, b bVar, Runnable runnable) {
        this.puG = readMailUI;
        this.puH = bVar;
        this.fgd = runnable;
    }

    public final void run() {
        Map map = null;
        if (!this.puG.isFinishing()) {
            try {
                map = (Map) new ReadMailProxy(ReadMailUI.l(this.puG), null).REMOTE_CALL("getCookie", new Object[0]);
            } catch (Exception e) {
                x.w("MicroMsg.ReadMailUI", "getCookie, ex = %s", new Object[]{e.getMessage()});
            }
            if (map != null) {
                this.puH.setCookie(p.bkn(), "skey=" + ((String) map.get("skey")));
                this.puH.setCookie(p.bkn(), "uin=" + ((String) map.get(OpenSDKTool4Assistant.EXTRA_UIN)));
                this.puH.setCookie(p.bkn(), "svrid=" + ((String) map.get("svrid")));
                c.cIl();
                c.sync();
            }
            if (!this.puG.isFinishing() && ReadMailUI.g(this.puG) != null) {
                this.fgd.run();
            }
        }
    }
}
