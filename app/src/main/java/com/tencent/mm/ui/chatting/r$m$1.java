package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ay.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.b.d;
import com.tencent.mm.ui.chatting.r.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

class r$m$1 implements OnClickListener {
    final /* synthetic */ au heR;
    final /* synthetic */ m ytN;

    r$m$1(m mVar, au auVar) {
        this.ytN = mVar;
        this.heR = auVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        if (this.heR.aNc()) {
            l.aa(this.heR);
            ba.aK(this.heR.field_msgId);
            this.ytN.yqa.mM(true);
            return;
        }
        this.heR.cju();
        ar.Hg();
        c.Fa().a(this.heR.field_msgId, this.heR);
        if (!this.ytN.yqa.yqp.aP(this.heR) && !this.ytN.yqa.yvT.aP(this.heR) && !this.ytN.yqa.yvQ.aN(this.heR)) {
            if (this.heR.cjg()) {
                this.ytN.yqa.ywb.aH(this.heR);
            } else if (!this.ytN.yqa.yvX.aP(this.heR)) {
                d dVar = this.ytN.yqa.yvW;
                cf cfVar = this.heR;
                if (cfVar.cjf()) {
                    if (!dVar.fhr.csi().field_username.equals("medianote")) {
                        ar.Hg();
                        c.EX().b(new e(cfVar.field_talker, cfVar.field_msgSvrId));
                    }
                    af.aJ(cfVar);
                    dVar.fhr.mM(true);
                } else {
                    z = false;
                }
                if (!z) {
                    x.e("MicroMsg.DesignerClickListener", "uknown msg type");
                }
            }
        }
    }
}
