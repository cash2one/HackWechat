package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Bundle;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.1.1;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.2;
import com.tencent.mm.plugin.webview.ui.tools.widget.h.a;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class aa$1$1$1 implements a {
    final /* synthetic */ 1 mWW;

    aa$1$1$1(1 1) {
        this.mWW = 1;
    }

    public final void d(int i, Bundle bundle) {
        x.i("MicroMsg.GameJsApiLogin", "onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        aa aaVar;
        com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar;
        switch (i) {
            case 1:
            case 2:
                aaVar = this.mWW.mWV.mWT;
                String str = this.mWW.mWV.fgU;
                String str2 = this.mWW.mWU;
                com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar2 = this.mWW.mWV.mWw;
                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                LinkedList linkedList = new LinkedList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedList.add((String) it.next());
                }
                b.a aVar3 = new b.a();
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_amk = new amk();
                aVar3.hmj = com_tencent_mm_protocal_c_amk;
                aVar3.hmk = new aml();
                aVar3.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
                aVar3.hmi = 1117;
                aVar3.hml = 0;
                aVar3.hmm = 0;
                com_tencent_mm_protocal_c_amk.ngo = str;
                com_tencent_mm_protocal_c_amk.wta = linkedList;
                com_tencent_mm_protocal_c_amk.wtf = 0;
                com_tencent_mm_protocal_c_amk.wtg = str2;
                com_tencent_mm_protocal_c_amk.wtc = 0;
                com_tencent_mm_protocal_c_amk.wtb = i;
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar3.JZ(), new 2(aaVar, aVar2, i));
                if (i == 2) {
                    x.e("MicroMsg.GameJsApiLogin", "fail auth deny!");
                    aVar = this.mWW.mWV.mWw;
                    aaVar = this.mWW.mWV.mWT;
                    aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail_auth_deny", null));
                    return;
                }
                return;
            default:
                x.i("MicroMsg.GameJsApiLogin", "press back button!");
                aVar = this.mWW.mWV.mWw;
                aaVar = this.mWW.mWV.mWT;
                aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail_auth_cancel", null));
                return;
        }
    }
}
