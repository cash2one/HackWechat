package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.m.6;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

class m$6$1 implements i$b {
    final /* synthetic */ 6 sVZ;

    m$6$1(6 6) {
        this.sVZ = 6;
    }

    public final void a(FavorPayInfo favorPayInfo) {
        boolean z;
        List list;
        String u;
        String string;
        String str;
        String str2;
        String str3;
        String str4 = null;
        this.sVZ.sVV.sEQ = favorPayInfo;
        t.d(this.sVZ.sVV.pCn == null ? 0 : this.sVZ.sVV.pCn.fCV, this.sVZ.sVV.pCn == null ? "" : this.sVZ.sVV.pCn.fuH, 15, this.sVZ.sVV.sEQ.sMT);
        this.sVZ.sVV.sVG = false;
        int i = this.sVZ.sVV.sEQ.sMU;
        String str5 = this.sVZ.sVV.sEQ.sMV;
        ArrayList jB = o.bLq().jB(true);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < jB.size(); i2++) {
                if (bh.ov(str5)) {
                    if (!((Bankcard) jB.get(i2)).field_bankcardType.equals("CFT")) {
                        z = true;
                    }
                    z = false;
                } else {
                    if (((Bankcard) jB.get(i2)).field_bankcardType.equals(str5)) {
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    arrayList.add((Bankcard) jB.get(i2));
                }
            }
            list = arrayList;
        } else {
            list = jB;
        }
        this.sVZ.sVV.sEQ.sMX = "";
        if (a.a(this.sVZ.sVV.sEQ, this.sVZ.sVV.sVI)) {
            this.sVZ.sVV.sVG = true;
            if (list.size() == 0) {
                this.sVZ.sVV.sEQ.sMX = this.sVZ.val$context.getString(i.uRC);
            } else {
                this.sVZ.sVV.sEQ.sMX = this.sVZ.val$context.getString(i.uRD);
            }
            this.sVZ.sVV.dismiss();
            if (this.sVZ.sVV.sVv != null) {
                this.sVZ.sVV.sVv.a(this.sVZ.sVV.sVu.getText(), this.sVZ.sVV.sEQ, this.sVZ.sVV.sVG);
                return;
            }
        }
        if (this.sVZ.sVV.sVx != null) {
            this.sVZ.sVV.sVx.setTag(this.sVZ.sVV.sEQ);
        }
        h Ni = this.sVZ.sVV.sFy.Ni(this.sVZ.sVV.sEQ.sMT);
        if (Ni == null || Ni.sDx <= 0.0d) {
            u = e.u(this.sVZ.sVY.sNX.sDn);
            string = this.sVZ.val$context.getString(i.uVr);
            str = null;
            str2 = null;
            str3 = u;
        } else {
            str = e.u(Ni.sDw);
            str2 = e.u(this.sVZ.sVY.sNX.sDn);
            str3 = str;
            string = null;
            str = Ni.sDz;
        }
        if (Ni == null || Ni.sDy == 0) {
            u = null;
        } else {
            u = Ni.sDA;
            if (!bh.ov(str)) {
                u = "," + u;
            }
        }
        if (bh.ov(str) && bh.ov(u)) {
            str4 = string;
        } else if (!bh.ov(string)) {
            str4 = "," + string;
        }
        this.sVZ.sVV.Nq(str3);
        this.sVZ.sVV.Ns(str2);
        this.sVZ.sVV.eC(str, str4);
        m mVar = this.sVZ.sVV;
        str = this.sVZ.sVY.paz;
        mVar.Nt(u);
    }
}
