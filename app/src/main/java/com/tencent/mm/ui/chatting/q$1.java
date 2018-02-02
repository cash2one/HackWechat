package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.z.ar;
import org.xwalk.core.R$styleable;

class q$1 implements f {
    final /* synthetic */ String gIx;
    final /* synthetic */ a ytC;
    final /* synthetic */ q ytD;

    q$1(q qVar, a aVar, String str) {
        this.ytD = qVar;
        this.ytC = aVar;
        this.gIx = str;
    }

    public final Object a(k kVar) {
        i.CB(6);
        switch (kVar.type) {
            case 1:
                return q.a(this.ytD);
            case 2:
            case 6:
            case 7:
            case 9:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
                this.ytC.finish();
                break;
            case 4:
                q.a(this.ytD, kVar);
                break;
            case 25:
            case 30:
            case 31:
                return q.a(this.ytD);
        }
        return null;
    }

    public final Object b(k kVar) {
        switch (kVar.type) {
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                if (!(ar.Hj() && (com.tencent.mm.ag.f.eE(this.gIx) || com.tencent.mm.ag.f.jX(this.gIx) || com.tencent.mm.ag.f.jW(this.gIx)))) {
                    x.i("MicroMsg.ChattingListAdapter", "appId:%s,path:%s", new Object[]{new String(Base64.decode(kVar.url, 0)), new String(Base64.decode(bh.az((String) kVar.A(String.class), ""), 0))});
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1082;
                    appBrandStatObject.fnp = this.gIx;
                    ((c) g.h(c.class)).a(this.ytC.getContext(), null, r3, 0, 0, r6, appBrandStatObject);
                    break;
                }
        }
        return null;
    }
}
