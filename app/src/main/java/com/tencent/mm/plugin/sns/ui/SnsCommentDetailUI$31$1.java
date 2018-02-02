package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.31;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$31$1 implements OnClickListener {
    final /* synthetic */ 31 rAE;

    SnsCommentDetailUI$31$1(31 31) {
        this.rAE = 31;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.j(this.rAE.rAr));
        m Lm = h.Lm(SnsCommentDetailUI.j(this.rAE.rAr));
        if (Lm == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[]{SnsCommentDetailUI.j(this.rAE.rAr)});
        } else if (!Lm.xl(32)) {
            if (Lm.field_snsId == 0) {
                ae.bvv().xp(Lm.roJ);
            } else {
                ae.bvu().eD(Lm.field_snsId);
                g.Dk();
                g.Di().gPJ.a(new q(Lm.field_snsId, 1), 0);
                ae.bvv().delete(Lm.field_snsId);
                ae.bvA().eM(Lm.field_snsId);
            }
            Intent intent = new Intent();
            intent.putExtra("sns_gallery_op_id", u.LG(SnsCommentDetailUI.j(this.rAE.rAr)));
            this.rAE.rAr.setResult(-1, intent);
            if (SnsCommentDetailUI.r(this.rAE.rAr) && !Lm.isValid()) {
                intent.putExtra("sns_gallery_force_finish", true);
            }
            bnp bxV = Lm.bxV();
            if (bxV != null) {
                String str = bxV.wQn == null ? null : bxV.wQn.nGJ;
                if (!bh.ov(str) && a.ift.cA(str)) {
                    String cy = a.ift.cy(str);
                    b nfVar = new nf();
                    nfVar.fFg.appId = str;
                    nfVar.fFg.fFh = bxV.ksU;
                    nfVar.fFg.ffw = cy;
                    com.tencent.mm.sdk.b.a.xef.m(nfVar);
                }
            }
            this.rAE.rAr.finish();
        }
    }
}
