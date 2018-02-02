package com.tencent.mm.plugin.card.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;

public final class p extends c<pd> {
    public p() {
        this.xen = pd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pd pdVar = (pd) bVar;
        if (pdVar instanceof pd) {
            Object obj = pdVar.fGY.fys;
            long j = pdVar.fGY.fpG;
            String str = pdVar.fGY.fyt;
            d wJ = g.wJ(obj);
            if (wJ == null) {
                x.e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(obj)) {
                x.e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                ar.Hg();
                a fT = a.fT(com.tencent.mm.z.c.Fa().dH(j).field_content);
                if (fT != null) {
                    fT.hcj = g.a(wJ);
                    fT.fys = obj;
                    fT.hck = wJ.kLa;
                    fT.hcl = wJ.fGW;
                    fT.hcm = wJ.kJO;
                    Bitmap a = j.a(new m(fT.thumburl));
                    l.a(fT, fT.appId, wJ.kLa, str, null, a != null ? com.tencent.mm.sdk.platformtools.d.Q(a) : null);
                    return true;
                }
            }
        }
        return false;
    }
}
