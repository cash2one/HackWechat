package com.tencent.mm.plugin.wallet_ecard;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class a$1 extends c<cl> {
    final /* synthetic */ a sYN;

    a$1(a aVar) {
        this.sYN = aVar;
        this.xen = cl.class.getName().hashCode();
    }

    private boolean a(cl clVar) {
        a aVar = clVar.fqB;
        HashMap hashMap = new HashMap();
        if (!bh.ov(aVar.packageExt)) {
            String[] split = aVar.packageExt.split("&");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!bh.ov(split[i])) {
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2 && !bh.ov(split2[0])) {
                            hashMap.put(split2[0], split2[1]);
                        }
                    }
                }
            }
        }
        x.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[]{(String) hashMap.get("extradata"), hashMap});
        k aVar2 = new com.tencent.mm.plugin.wallet_core.c.a(aVar.appId, aVar.fqD, aVar.nonceStr, aVar.packageExt, aVar.signType, aVar.signature, aVar.fqE, 15, "openECard", aVar.fqJ);
        g.Dk();
        g.Di().gPJ.a(580, new 1(this, aVar, clVar, r11));
        g.Dk();
        g.Di().gPJ.a(aVar2, 0);
        return false;
    }
}
