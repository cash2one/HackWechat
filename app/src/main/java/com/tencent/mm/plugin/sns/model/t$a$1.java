package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.t.a;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.bkn;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.R$styleable;

class t$a$1 extends af {
    final /* synthetic */ a qUw;

    t$a$1(a aVar) {
        this.qUw = aVar;
    }

    public final void handleMessage(Message message) {
        if (this.qUw.mqJ == null || this.qUw.mqJ.isEmpty()) {
            k kVar = this.qUw.qUt;
            bko com_tencent_mm_protocal_c_bko = (bko) kVar.gJQ.hmh.hmo;
            bkn com_tencent_mm_protocal_c_bkn = (bkn) kVar.gJQ.hmg.hmo;
            byte[] g = ad.g(com_tencent_mm_protocal_c_bkn.vRA.wJD.toByteArray(), com_tencent_mm_protocal_c_bko.vRA.wJD.toByteArray());
            if (g != null && g.length > 0) {
                g.Dk();
                g.Dj().CU().set(8195, bh.by(g));
            }
            com_tencent_mm_protocal_c_bkn.vRA.bj(g);
            if ((com_tencent_mm_protocal_c_bko.vPq & com_tencent_mm_protocal_c_bkn.vRz) == 0) {
                kVar.gJT.a(0, 0, "", kVar);
                return;
            } else {
                kVar.a(kVar.hmA, kVar.gJT);
                return;
            }
        }
        final ol olVar = (ol) this.qUw.mqJ.getFirst();
        x.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + olVar.vXp);
        this.qUw.mqJ.removeFirst();
        switch (olVar.vXp) {
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                ae.bvf().post(new Runnable(this) {
                    final /* synthetic */ t$a$1 qUy;

                    public final void run() {
                        if (!this.qUy.qUw.qUt.a(olVar, this.qUy.qUw.mqK)) {
                            this.qUy.qUw.mqK.sendEmptyMessage(0);
                        }
                    }
                });
                return;
            case 46:
                ae.bvf().post(new 2(this, olVar));
                return;
            default:
                return;
        }
    }
}
