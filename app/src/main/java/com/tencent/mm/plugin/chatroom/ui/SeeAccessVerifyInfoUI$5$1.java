package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.chatroom.ui.SeeAccessVerifyInfoUI.5;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SeeAccessVerifyInfoUI$5$1 implements a<Void, com.tencent.mm.ae.a.a<do>> {
    final /* synthetic */ 5 lcR;

    SeeAccessVerifyInfoUI$5$1(5 5) {
        this.lcR = 5;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        if (SeeAccessVerifyInfoUI.g(this.lcR.lcQ) != null && SeeAccessVerifyInfoUI.g(this.lcR.lcQ).isShowing()) {
            SeeAccessVerifyInfoUI.g(this.lcR.lcQ).dismiss();
        }
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(aVar.fnL);
        if (eA != null) {
            eA.a(this.lcR.lcQ, null, null);
        } else if (aVar.errType == 0 && aVar.errCode == 0) {
            if (aVar.frb.getType() == 774) {
                ar.Hg();
                cf dH = c.Fa().dH(SeeAccessVerifyInfoUI.h(this.lcR.lcQ));
                dH.cjy();
                ar.Hg();
                c.Fa().b(dH.field_msgSvrId, dH);
                SeeAccessVerifyInfoUI.i(this.lcR.lcQ).setBackgroundResource(R.g.bAc);
                SeeAccessVerifyInfoUI.i(this.lcR.lcQ).setTextColor(this.lcR.lcQ.getResources().getColor(R.e.bsH));
                SeeAccessVerifyInfoUI.i(this.lcR.lcQ).setText(this.lcR.lcQ.getString(R.l.eoZ));
                SeeAccessVerifyInfoUI.i(this.lcR.lcQ).setEnabled(false);
                g.pQN.a(219, 23, 1, true);
            }
        } else if (aVar.frb.getType() == 774) {
            x.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bh.ou(aVar.fnL)});
            h.b(this.lcR.lcQ.mController.xIM, this.lcR.lcQ.getString(R.l.dCe), this.lcR.lcQ.getString(R.l.dGO), true);
        }
        return zBS;
    }
}
