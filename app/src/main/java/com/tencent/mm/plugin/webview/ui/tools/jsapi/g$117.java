package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.116;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.c;
import com.tencent.mm.u.a.c.a;
import com.tencent.mm.u.a.d;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class g$117 implements a<c> {
    final /* synthetic */ String fgU;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ g.a tIk;

    g$117(g gVar, i iVar, g.a aVar, String str) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.tIk = aVar;
        this.fgU = str;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        c cVar = (c) kVar;
        x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.tIj, this.tIg, "login:fail", null);
            this.tIk.afC();
        } else if (cVar instanceof c) {
            final amn BX = cVar.BX();
            int i3 = BX.wte.fts;
            String str2 = BX.wte.ftt;
            final String str3 = BX.wtg;
            x.i("MicroMsg.MsgHandler", "NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                ag.y(new Runnable(this) {
                    final /* synthetic */ g$117 tJA;

                    public final void run() {
                        LinkedList linkedList = BX.whQ;
                        x.d("MicroMsg.MsgHandler", "appName %s, appIconUrl %s", new Object[]{BX.niZ, BX.vFW});
                        h hVar = new h(g.i(this.tJA.tIj));
                        h.a anonymousClass1 = new h.a(this) {
                            final /* synthetic */ AnonymousClass1 tJB;

                            {
                                this.tJB = r1;
                            }

                            public final void d(int i, Bundle bundle) {
                                x.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                switch (i) {
                                    case 1:
                                    case 2:
                                        g gVar = this.tJB.tJA.tIj;
                                        String str = this.tJB.tJA.fgU;
                                        String str2 = str3;
                                        i iVar = this.tJB.tJA.tIg;
                                        g.a aVar = this.tJB.tJA.tIk;
                                        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                        LinkedList linkedList = new LinkedList();
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            linkedList.add((String) it.next());
                                        }
                                        ar.CG().a(new d(str, linkedList, 0, str2, 0, i, new 116(gVar, iVar, aVar, i)), 0);
                                        if (i == 2) {
                                            x.e("MicroMsg.MsgHandler", "fail auth deny!");
                                            g.a(this.tJB.tJA.tIj, this.tJB.tJA.tIg, "login:fail auth deny", null);
                                            this.tJB.tJA.tIk.afC();
                                            return;
                                        }
                                        return;
                                    default:
                                        x.i("MicroMsg.MsgHandler", "press back button!");
                                        g.a(this.tJB.tJA.tIj, this.tJB.tJA.tIg, "login:fail auth cancel", null);
                                        this.tJB.tJA.tIk.afC();
                                        return;
                                }
                            }
                        };
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                            g.a(this.tJA.tIj, this.tJA.tIg, "login:fail", null);
                            this.tJA.tIk.afC();
                        } else if (!hVar.a(linkedList, r1, r2, anonymousClass1)) {
                            this.tJA.tIk.afC();
                        }
                    }
                });
            } else if (i3 == 0) {
                String str4 = BX.wth;
                Map hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str4);
                g.a(this.tIj, this.tIg, "login:ok", hashMap);
                x.d("MicroMsg.MsgHandler", "resp data code [%s]", new Object[]{str4});
                this.tIk.afC();
            } else {
                g.a(this.tIj, this.tIg, "login:fail", null);
                x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                this.tIk.afC();
            }
        }
    }
}
