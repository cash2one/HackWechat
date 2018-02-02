package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Bundle;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.h$a;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class d$1$1 implements Runnable {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ 1 mWA;
    final /* synthetic */ String mWy;
    final /* synthetic */ String mWz;

    d$1$1(1 1, LinkedList linkedList, String str, String str2) {
        this.mWA = 1;
        this.iVD = linkedList;
        this.mWy = str;
        this.mWz = str2;
    }

    public final void run() {
        h hVar = new h(this.mWA.val$context);
        h$a anonymousClass1 = new h$a(this) {
            final /* synthetic */ d$1$1 mWB;

            {
                this.mWB = r1;
            }

            public final void d(int i, Bundle bundle) {
                x.i("MicroMsg.GameJsApiAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                d dVar;
                a aVar;
                switch (i) {
                    case 1:
                    case 2:
                        dVar = this.mWB.mWA.mWx;
                        String str = this.mWB.mWA.fgU;
                        a aVar2 = this.mWB.mWA.mWw;
                        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                        LinkedList linkedList = new LinkedList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            linkedList.add((String) it.next());
                        }
                        b.a aVar3 = new b.a();
                        com.tencent.mm.bq.a com_tencent_mm_protocal_c_amg = new amg();
                        aVar3.hmj = com_tencent_mm_protocal_c_amg;
                        aVar3.hmk = new amh();
                        aVar3.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                        aVar3.hmi = 1158;
                        aVar3.hml = 0;
                        aVar3.hmm = 0;
                        com_tencent_mm_protocal_c_amg.ngo = str;
                        com_tencent_mm_protocal_c_amg.wta = linkedList;
                        com_tencent_mm_protocal_c_amg.wtc = 0;
                        com_tencent_mm_protocal_c_amg.wtb = i;
                        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar3.JZ(), new d$2(dVar, aVar2, i));
                        if (i == 2) {
                            aVar = this.mWB.mWA.mWw;
                            dVar = this.mWB.mWA.mWx;
                            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:fail_auth_deny", null));
                            return;
                        }
                        return;
                    default:
                        x.d("MicroMsg.GameJsApiAuthorize", "press back button!");
                        aVar = this.mWB.mWA.mWw;
                        dVar = this.mWB.mWA.mWx;
                        aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:fail_auth_cancel", null));
                        return;
                }
            }
        };
        a aVar;
        d dVar;
        if (this.iVD == null || this.iVD.size() <= 0) {
            x.e("MicroMsg.GameJsApiAuthorize", "scopeInfoList is empty!");
            aVar = this.mWA.mWw;
            dVar = this.mWA.mWx;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:fail", null));
        } else if (!hVar.a(this.iVD, this.mWy, this.mWz, anonymousClass1)) {
            aVar = this.mWA.mWw;
            dVar = this.mWA.mWx;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:fail", null));
        }
    }
}
