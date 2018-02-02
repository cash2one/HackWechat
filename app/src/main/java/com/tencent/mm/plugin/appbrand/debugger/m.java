package com.tencent.mm.plugin.appbrand.debugger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.i.3;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class m extends j {
    i iQX;
    g iQx = new g(this);

    protected final b YM() {
        this.iQX = new i();
        return this.iQX;
    }

    public final void h(String str, String str2, int i) {
        if (bh.ov(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.RemoteDebugService", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(i)});
        this.iQX.iQy = str;
        i iVar = this.iQX;
        String str3 = "typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\" , %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = Cc();
        iVar.evaluateJavascript(String.format(str3, objArr), null);
    }

    public final void E(int i, String str) {
        if (bh.ov(str)) {
            str = "{}";
        }
        this.iQX.iQB.D(i, str);
        this.jbH.H(i, str);
    }

    public final int a(b bVar, int i) {
        return i;
    }

    protected final void YS() {
    }

    protected final void pn(String str) {
    }

    public final void f(e eVar) {
        super.f(eVar);
        g gVar = this.iQx;
        gVar.iPZ = o.rj(this.irP.iqw.extInfo);
        AppBrandSysConfig appBrandSysConfig = gVar.iPT.irP.iqx;
        if (appBrandSysConfig != null) {
            appBrandSysConfig.iOl = gVar.iPZ.iOl;
            appBrandSysConfig.iNV = true;
        }
        i iVar = this.iQX;
        iVar.iQx = this.iQx;
        iVar.iqB = iVar.iQx.iPT;
        iVar.iQz = iVar.iqB.getContext();
        iVar.iQC = new p(iVar.iQz, iVar.iQx, new i$1(iVar));
        View view = iVar.iQC;
        view.iRd = (ViewGroup) iVar.iqB.irP.iqD.getParent();
        view.iRd.addView(view);
        view.iRd.bringChildToFront(view);
        view.iRe = (RemoteDebugMoveView) LayoutInflater.from(view.getContext()).inflate(h.ixj, null);
        view.iRh = (TextView) view.iRe.findViewById(q$g.iuJ);
        view.iRg = (TextView) view.iRe.findViewById(q$g.iuQ);
        view.iRi = (TextView) view.iRe.findViewById(q$g.iuN);
        view.iRj = (TextView) view.iRe.findViewById(q$g.iuO);
        view.iRk = (TextView) view.iRe.findViewById(q$g.iuM);
        view.iRl = (TextView) view.iRe.findViewById(q$g.iuH);
        view.iRm = (TextView) view.iRe.findViewById(q$g.iuL);
        view.iRo = (ImageView) view.iRe.findViewById(q$g.iuI);
        view.iRn = (ImageView) view.iRe.findViewById(q$g.iuP);
        view.iRp = view.iRe.findViewById(q$g.iuK);
        view.show();
        view.iRk.setOnClickListener(view.mOnClickListener);
        view.iRl.setOnClickListener(view.mOnClickListener);
        view.iRj.setOnClickListener(view.mOnClickListener);
        view.postDelayed(new p$1(view), 100);
        iVar.connect();
        x.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
        a com_tencent_mm_protocal_c_afl = new afl();
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = com_tencent_mm_protocal_c_afl;
        aVar.hmk = new afm();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket";
        aVar.hmi = 1862;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), new 3(iVar));
    }

    public final void init() {
    }

    public final void onResume() {
        this.iQX.iQC.bringToFront();
    }

    public final String acw() {
        JSONObject YT = YT();
        String str = this.irP.iqy.iMF;
        return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{YT.toString(), str});
    }
}
