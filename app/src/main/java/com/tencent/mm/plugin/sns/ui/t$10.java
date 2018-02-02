package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$10 extends c<mr> {
    final /* synthetic */ t rtq;

    t$10(t tVar) {
        this.rtq = tVar;
        this.xen = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        if (this.rtq.rtk == null || this.rtq.rsC == null) {
            x.e("MicroMsg.GalleryTitleManager", "not in recoging");
        } else if (mrVar == null || !(mrVar instanceof mr)) {
            x.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
        } else if (mrVar.fED.filePath.equals(this.rtq.rsC)) {
            x.i("MicroMsg.GalleryTitleManager", "recog result: " + mrVar.fED.result);
            if (!bh.ov(mrVar.fED.result)) {
                this.rtq.rsF = mrVar.fED.result;
                this.rtq.fqb = mrVar.fED.fqb;
                this.rtq.fqc = mrVar.fED.fqc;
                if (!(this.rtq.rsF == null || this.rtq.rtk == null)) {
                    this.rtq.rsG = true;
                }
                this.rtq.a(this.rtq.rtl, this.rtq.qyg, this.rtq.rtm, false, 0);
            }
            this.rtq.rsC = null;
        } else {
            x.e("MicroMsg.GalleryTitleManager", "not same filepath");
        }
        return false;
    }
}
