package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am.6;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class am$6$1 implements Runnable {
    final /* synthetic */ a heQ;
    final /* synthetic */ String iGf;
    final /* synthetic */ 6 kMS;

    am$6$1(6 6, String str, a aVar) {
        this.kMS = 6;
        this.iGf = str;
        this.heQ = aVar;
    }

    public final void run() {
        c auK = am.auK();
        Object obj = this.iGf;
        x.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is " + (this.heQ.hmq.vHe));
        if (!TextUtils.isEmpty(obj)) {
            c.a aVar;
            Map y = bi.y(obj, "sysmsg");
            if (y == null) {
                aVar = null;
            } else {
                c.a aVar2 = new c.a(auK);
                String str = (String) y.get(".sysmsg.notifysharecard.state_flag");
                if (TextUtils.isEmpty(str) || !l.wP(str)) {
                    aVar2.kNd = 0;
                } else {
                    aVar2.kNd = Integer.valueOf(str).intValue();
                }
                aVar2.username = (String) y.get(".sysmsg.notifysharecard.username");
                aVar2.fGU = (String) y.get(".sysmsg.notifysharecard.card_id");
                aVar = aVar2;
            }
            if (aVar == null) {
                x.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                return;
            }
            if (TextUtils.isEmpty(aVar.fGU)) {
                x.e("MicroMsg.ShareCardMsgMgr", "card id == null");
            }
            x.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.fGU);
            am.auH().auR();
            l.axg();
        }
    }
}
