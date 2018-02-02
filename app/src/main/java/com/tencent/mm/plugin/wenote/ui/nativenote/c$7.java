package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.b.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

class c$7 implements OnClickListener {
    final /* synthetic */ a tXK;
    final /* synthetic */ c tXL;
    final /* synthetic */ Context val$context;

    c$7(c cVar, a aVar, Context context) {
        this.tXL = cVar;
        this.tXK = aVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (c.a(this.tXL) == 3) {
            this.tXK.f(true, 50);
            this.tXK.P(1, 0);
        }
        c.bWp().W(-1, false);
        x.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)), bh.cgy()});
        if (com.tencent.mm.pluginsdk.g.a.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)) {
            if (!this.tXL.tXE) {
                if (!f.ze()) {
                    u.fI(this.val$context);
                    return;
                } else if (com.tencent.mm.p.a.aW(this.val$context) || com.tencent.mm.p.a.aU(this.val$context)) {
                    return;
                }
            }
            if (this.tXL.tXE) {
                this.tXL.a(this.tXK);
                return;
            }
            g.pQN.h(14547, new Object[]{Integer.valueOf(3)});
            if (c.bWp().eq(0, 1)) {
                this.tXK.bVZ();
                return;
            }
            this.tXL.tXy.setImageResource(R.g.bCc);
            if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bXQ().aIA()) {
                com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bXQ().stopPlay();
            }
            this.tXL.tXE = true;
            b kVar = new k();
            kVar.type = 4;
            kVar.tRQ = false;
            kVar.tRH = Boolean.valueOf(true);
            kVar.tSg = this.val$context.getString(R.l.eha);
            this.tXL.tRm = "speex";
            kVar.fvx = 1;
            kVar.tRP = c.bWp().bWv();
            kVar.tRF = this.tXL.tRm;
            kVar.mvG = com.tencent.mm.plugin.wenote.model.f.QI(kVar.toString());
            uq uqVar = new uq();
            uqVar.TD(kVar.mvG);
            uqVar.TA(kVar.tRF);
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k bWZ = com.tencent.mm.plugin.wenote.model.nativenote.manager.k.bWZ();
            if (bWZ != null) {
                c.bWp().a(kVar, bWZ.bXc(), false, false, false);
            } else {
                c.bWp().a(kVar, null, false, false, false);
            }
            com.tencent.mm.plugin.wenote.model.k bVQ = com.tencent.mm.plugin.wenote.model.k.bVQ();
            com.tencent.mm.plugin.wenote.model.b.a aVar = this.tXL.tXF;
            String o = com.tencent.mm.plugin.wenote.model.f.o(uqVar);
            bVQ.tRq = kVar;
            int i = bh.getInt(kVar.tRP.substring(7), 0);
            String str = kVar.tRF;
            if (!bVQ.kEo) {
                String Vl;
                bVQ.kEo = true;
                bVQ.mvP = null;
                bVQ.tRo = i;
                bVQ.tRp = aVar;
                bVQ.tRm = str;
                bVQ.path = o;
                if (bVQ.hXN != null) {
                    bVQ.hXN.requestFocus();
                }
                bVQ.kEp = false;
                if (bh.ov(bVQ.path)) {
                    Vl = com.tencent.mm.bi.a.Vl();
                    File file = new File(Vl);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    do {
                        o = Vl + "/" + System.currentTimeMillis();
                    } while (new File(o).exists());
                    bVQ.path = o;
                }
                if (bh.ov(str)) {
                    Vl = "amr";
                } else {
                    Vl = str;
                }
                if (Vl.equals("speex")) {
                    bVQ.tRl = new com.tencent.mm.modelvoice.k();
                    1 1 = new 1(bVQ);
                } else {
                    com.tencent.mm.compatible.b.b.a aVar2 = com.tencent.mm.compatible.b.b.a.gBX;
                    bVQ.myL = new j();
                    bVQ.myL.fmg = new 2(bVQ);
                }
                bVQ.kEb = -1;
                Boolean.valueOf(false);
                if ((str.equals("speex") ? Boolean.valueOf(bVQ.tRl.cI(bVQ.path)) : Boolean.valueOf(bVQ.myL.cK(bVQ.path))).booleanValue()) {
                    bVQ.myE = bh.Wq();
                    bVQ.kEv.J(200, 200);
                } else {
                    bVQ.myE = 0;
                }
                if (bVQ.myE == 0) {
                    z = true;
                } else {
                    bVQ.tRr.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
                }
            }
            if (z >= false) {
                this.tXK.bWa();
                this.tXL.a(this.tXK);
            }
        }
    }
}
