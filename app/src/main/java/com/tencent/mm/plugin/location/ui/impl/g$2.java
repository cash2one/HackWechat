package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.8;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class g$2 implements b {
    final /* synthetic */ g nYb;

    g$2(g gVar) {
        this.nYb = gVar;
    }

    public final void aVH() {
        x.i("MicroMsg.ShareMapUI", "onJoinSucess");
        o oVar = this.nYb.nXP;
        oVar.nRO = true;
        oVar.aVD();
        oVar.aVE();
        this.nYb.nXO.gq(true);
        if (this.nYb.nXR != null) {
            this.nYb.nXR.aVX();
        }
    }

    public final void a(bbr com_tencent_mm_protocal_c_bbr) {
        g.a(this.nYb, com_tencent_mm_protocal_c_bbr);
    }

    public final void onError(int i, String str) {
        x.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[]{Integer.valueOf(i), str});
        g.pQN.h(10997, new Object[]{"7", "", Integer.valueOf(0), Integer.valueOf(0)});
        l lVar = this.nYb.nXQ;
        x.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[]{str});
        Context context = ac.getContext();
        String str2 = null;
        if (!bh.ov(str)) {
            str2 = str;
        } else if (i == 0) {
            str2 = context.getString(R.l.etb);
        } else if (i == 1) {
            str2 = context.getString(R.l.etc);
        } else if (i == 2) {
            str2 = context.getString(R.l.etd);
        }
        h.a(lVar.mContext, str2, "", lVar.mResources.getString(R.l.dFU), false, new 8(lVar, i));
    }

    public final void aVI() {
        this.nYb.nXO.gq(false);
        this.nYb.nXP.stop();
        this.nYb.nXP.rM(3);
        k.aWa();
        this.nYb.activity.finish();
        this.nYb.activity.overridePendingTransition(R.a.bqn, R.a.bqp);
    }
}
