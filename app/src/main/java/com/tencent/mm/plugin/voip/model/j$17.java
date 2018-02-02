package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$17 extends PhoneStateListener {
    final /* synthetic */ j smu;

    j$17(j jVar) {
        this.smu = jVar;
    }

    public final void onCallStateChanged(int i, String str) {
        int i2 = true;
        super.onCallStateChanged(i, str);
        x.d("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b", Integer.valueOf(i), Boolean.valueOf(j.n(this.smu)));
        if (!j.n(this.smu)) {
            return;
        }
        if (i == 1) {
            j.d(this.smu, true);
            d.bGj().yJ(1);
        } else if (i == 2) {
            String string;
            j.d(this.smu, false);
            x.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if (j.b(this.smu) && !b.yS(j.a(this.smu).mState)) {
                n nVar = d.bGj().smS;
                x.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + nVar.siL.ske.nDx);
                if (nVar.siL.ske.nDx != 0) {
                    nVar.siL.ske.spH.skR = 102;
                    nVar.siL.ske.spH.sld = 6;
                    g.pQN.a(11521, true, true, Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                    nVar.bHD();
                }
            }
            if (b.yS(j.a(this.smu).mState)) {
                string = ac.getContext().getString(R.l.eUl, new Object[]{j.fd(bh.by(j.o(this.smu)))});
            } else {
                string = ac.getContext().getString(R.l.eUi);
            }
            n nVar2 = d.bGj().smS;
            x.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
            if (nVar2.siL.ske.nDx == 0) {
                nVar2.siL.skg.bGE();
                nVar2.reset();
            } else {
                nVar2.siL.ske.spH.skR = 109;
                nVar2.siL.ske.spH.slj = 4;
                nVar2.bHF();
            }
            String str2 = j.p(this.smu).field_username;
            String str3 = j.e(this.smu) ? au.xzd : au.xzc;
            if (!j.b(this.smu)) {
                i2 = 0;
            }
            l.a(str2, str3, i2, 6, string);
            j.c(this.smu, 4107);
            j.q(this.smu);
            au auVar = new au();
            auVar.setType(10000);
            auVar.aq(System.currentTimeMillis());
            auVar.eQ(6);
            auVar.setContent(ac.getContext().getString(R.l.eUk) + ", <a href=\"weixin://voip/callagain/?username=" + j.d(this.smu) + "&isvideocall=" + j.e(this.smu) + "\">" + ac.getContext().getString(R.l.eUf) + "</a>");
            if (!(j.d(this.smu) == null || j.d(this.smu).equals(""))) {
                auVar.dS(j.d(this.smu));
                ar.Hg();
                c.Fa().Q(auVar);
            }
            d.bGj().yJ(2);
        } else if (i == 0) {
            d.bGj().yJ(2);
            if (1 == j.f(this.smu) && b.yS(j.a(this.smu).mState) && j.r(this.smu)) {
                j.b(this.smu, true);
            }
            j.d(this.smu, false);
        }
    }
}
