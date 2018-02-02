package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import com.tencent.mm.av.a;
import com.tencent.mm.av.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.d;

class d$b implements Runnable {
    a fAA;
    final /* synthetic */ d oJx;

    public d$b(d dVar, a aVar) {
        this.oJx = dVar;
        this.fAA = aVar;
    }

    public final void run() {
        aqr com_tencent_mm_protocal_c_aqr = new aqr();
        com_tencent_mm_protocal_c_aqr.nGJ = this.fAA.field_songMediaId;
        com_tencent_mm_protocal_c_aqr.wxE = this.fAA.field_songAlbumUrl;
        com_tencent_mm_protocal_c_aqr.wxF = this.fAA.field_songAlbumType;
        com_tencent_mm_protocal_c_aqr.nfX = com_tencent_mm_protocal_c_aqr.wxE;
        Bitmap b = n.qQy.b(com_tencent_mm_protocal_c_aqr);
        if (b != null) {
            b = d.c(b, 10);
            this.oJx.a(this.fAA, b);
            int[] o = c.o(b);
            if (!this.fAA.e(o)) {
                this.fAA = h.bdA().M(this.fAA.field_musicId, o[0], o[1]);
            }
            if (this.oJx.oJu != null && this.fAA != null) {
                this.oJx.oJu.a(this.fAA, o);
            }
        }
    }
}
