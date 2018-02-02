package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.protocal.c.bxr;
import com.tencent.mm.sdk.platformtools.x;

class a$b$1 implements Runnable {
    final /* synthetic */ c gMB;
    final /* synthetic */ c iRB;
    final /* synthetic */ b iRD;
    final /* synthetic */ String uR;

    a$b$1(b bVar, c cVar, String str, c cVar2) {
        this.iRD = bVar;
        this.iRB = cVar;
        this.uR = str;
        this.gMB = cVar2;
    }

    public final void run() {
        c cVar = this.iRB;
        x.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", new Object[]{cVar.gOP});
        cVar.Vx = false;
        cVar.cleanup();
        cVar.gOM = null;
        cVar.iRM = null;
        cVar.gOP = null;
        cVar.iKB = null;
        i.rp(this.uR);
        this.gMB.i(null);
        f acG = f.acG();
        String str = this.uR;
        if (acG.iSb.containsKey(str)) {
            f.b bVar = (f.b) acG.iSb.get(str);
            x.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[]{bVar.iSf.toString()});
            if (bVar.iSf.size() > 0) {
                a aVar = new a();
                aVar.hmi = 2653;
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_bxq = new bxq();
                com_tencent_mm_protocal_c_bxq.fFm = bVar.appId;
                com_tencent_mm_protocal_c_bxq.id = bVar.hoL;
                com_tencent_mm_protocal_c_bxq.wYq = bVar.iSf;
                aVar.hmj = com_tencent_mm_protocal_c_bxq;
                aVar.hmk = new bxr();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), acG.iSc);
                return;
            }
            return;
        }
        x.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[]{str});
    }
}
