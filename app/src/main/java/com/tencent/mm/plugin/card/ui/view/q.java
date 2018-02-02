package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;

public final class q extends g {
    public String kVg = "";

    public final boolean h(b bVar) {
        if (this.kIK == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else {
            String str = this.kIK.atC().code;
            String str2 = bVar.atC().code;
            if (g.AA(str) || g.AA(str2) || str.equals(str2)) {
                oq oqVar = this.kIK.atB().vSm;
                oq oqVar2 = bVar.atB().vSm;
                if ((oqVar == null && oqVar2 != null) || (oqVar != null && oqVar2 == null)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (oqVar != null && oqVar2 != null && oqVar.title != null && oqVar2.title != null && !oqVar.title.equals(oqVar2.title)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (oqVar != null && oqVar2 != null && oqVar.kJR != null && oqVar2.kJR != null && !oqVar.kJR.equals(oqVar2.kJR)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                } else if (!this.kIK.atv() || g.isNullOrEmpty(this.kVg)) {
                    return false;
                } else {
                    x.i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    return true;
                }
            }
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        if (!g.isNullOrEmpty(this.kIK.atC().vRr)) {
            return this.kIK.atC().vRr;
        }
        if (!this.kIK.atv() || g.isNullOrEmpty(this.kVg)) {
            return this.kIK.atC().code;
        }
        return this.kVg;
    }

    public final ab axb() {
        return new s(this, this.kaY);
    }

    public final ab axc() {
        return new p(this, this.kaY);
    }

    public final ab axd() {
        return new r(this, this.kaY);
    }
}
