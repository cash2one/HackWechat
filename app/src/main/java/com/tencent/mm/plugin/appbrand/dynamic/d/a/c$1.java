package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.u.b.b;
import com.tencent.mm.u.b.b$a;
import com.tencent.mm.u.c.a;
import org.json.JSONObject;

class c$1 implements Runnable {
    final /* synthetic */ String iTD;
    final /* synthetic */ boolean iTE;
    final /* synthetic */ String iTF;
    final /* synthetic */ String iTG;
    final /* synthetic */ b iTH;
    final /* synthetic */ a iTI;
    final /* synthetic */ c iTJ;
    final /* synthetic */ b$a iTn;

    c$1(c cVar, String str, boolean z, String str2, b$a com_tencent_mm_u_b_b_a, String str3, b bVar, a aVar) {
        this.iTJ = cVar;
        this.iTD = str;
        this.iTE = z;
        this.iTF = str2;
        this.iTn = com_tencent_mm_u_b_b_a;
        this.iTG = str3;
        this.iTH = bVar;
        this.iTI = aVar;
    }

    public final void run() {
        c.c(this.iTD, "parse_json_start", this.iTE);
        JSONObject ru = c.ru(this.iTF);
        if (ru == null) {
            this.iTn.aw(this.iTJ.G(this.iTG, "fail:invalid data"));
            return;
        }
        c.c(this.iTD, "parse_json_end", this.iTE);
        d.a(this.iTD, this.iTF, ru);
        this.iTH.a(this.iTI, ru, this.iTn);
    }
}
