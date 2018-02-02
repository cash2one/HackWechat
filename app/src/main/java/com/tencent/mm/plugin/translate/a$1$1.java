package com.tencent.mm.plugin.translate;

import com.tencent.mm.g.a.rp;
import com.tencent.mm.plugin.translate.a.1;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class a$1$1 implements a {
    final /* synthetic */ int fmb;
    final /* synthetic */ c sfX;
    final /* synthetic */ 1 sfY;

    a$1$1(1 1, int i, c cVar) {
        this.sfY = 1;
        this.fmb = i;
        this.sfX = cVar;
    }

    public final boolean JC() {
        int i = this.fmb != 0 ? this.fmb : this.sfX.ret;
        b rpVar = new rp();
        rpVar.fJv.ret = i;
        rpVar.fJv.fJq = this.sfX.fJq;
        rpVar.fJv.id = this.sfX.id;
        rpVar.fJv.fJw = this.sfX.fJw;
        rpVar.fJv.type = this.sfX.type;
        rpVar.fJv.bhd = this.sfX.bhd;
        rpVar.fJv.fHV = this.sfX.fHV;
        com.tencent.mm.sdk.b.a.xef.m(rpVar);
        return false;
    }

    public final boolean JB() {
        x.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[]{this.sfX.id});
        if (this.fmb != 0) {
            x.e("MicroMsg.SubCoreTranslate", "translate error");
        } else if (this.sfX.ret != 0) {
            x.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[]{Integer.valueOf(this.sfX.ret)});
        } else if (bh.ov(this.sfX.fJw)) {
            x.e("MicroMsg.SubCoreTranslate", "translate return null");
        } else if (this.sfX.type == 0 || this.sfX.type == 1) {
            x.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
            String str = this.sfX.id;
            String str2 = this.sfX.bhd;
            String str3 = this.sfX.fJw;
            String str4 = this.sfX.fHV;
            ar.Hg();
            com.tencent.mm.z.c.Fa().a(bh.VJ(str), str2, str3, str4);
        }
        return true;
    }
}
