package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.protocal.c.xn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    LinkedList<String> kEI;

    public f() {
        a aVar = new a();
        aVar.hmj = new xm();
        aVar.hmk = new xn();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        aVar.hmi = 387;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.kEI = new LinkedList();
        xm xmVar = (xm) this.gJQ.hmg.hmo;
        ar.Hg();
        Object obj = c.CU().get(196610, null);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        objArr[1] = obj == null ? "null" : obj.toString();
        x.i(str, str2, objArr);
        xmVar.wif = bh.a((Integer) obj, 0);
        x.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[]{Integer.valueOf(xmVar.wif)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            xn xnVar = (xn) this.gJQ.hmh.hmo;
            x.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[]{Integer.valueOf(xnVar.wif), Integer.valueOf(xnVar.ksO)});
            x.i("MicroMsg.BrandService.NetSceneGetAppList", "result list is %s", new Object[]{xnVar.ksP.toString()});
            com.tencent.mm.plugin.brandservice.a.f(196610, Integer.valueOf(xnVar.wif));
            Iterator it = xnVar.ksP.iterator();
            while (it.hasNext()) {
                this.kEI.add(((ah) it.next()).ksU);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 387;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
