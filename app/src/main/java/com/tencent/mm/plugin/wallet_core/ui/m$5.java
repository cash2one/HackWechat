package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.lf.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.t;

class m$5 implements Runnable {
    final /* synthetic */ lf sTv;
    final /* synthetic */ m sVV;

    m$5(m mVar, lf lfVar) {
        this.sVV = mVar;
        this.sTv = lfVar;
    }

    public final void run() {
        x.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        b bVar = this.sTv.fCx;
        if (bVar == null) {
            this.sVV.pCn.vzy = 0;
            x.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
            return;
        }
        int i = bVar.errCode;
        x.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), bVar.fnL});
        int i2;
        String str;
        if (i == 0) {
            x.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[]{bVar.fCB});
            if (this.sVV.pCn == null) {
                i2 = 0;
            } else {
                i2 = this.sVV.pCn.fCV;
            }
            if (this.sVV.pCn == null) {
                str = "";
            } else {
                str = this.sVV.pCn.fuH;
            }
            t.d(i2, str, 22, "");
            this.sVV.pCn.vzy = 1;
            this.sVV.pCn.fwZ = bVar.fwZ;
            this.sVV.pCn.fxa = bVar.fxa;
            this.sVV.pCn.fCB = bVar.fCB;
            this.sVV.pCn.fwX = bVar.fwX;
            PayInfo payInfo = this.sVV.pCn;
            payInfo.vzz++;
            this.sVV.sVL.setText("");
            this.sVV.bMO();
            g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
            a.ya(0);
            return;
        }
        boolean z;
        x.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        if (this.sVV.pCn == null) {
            i2 = 0;
        } else {
            i2 = this.sVV.pCn.fCV;
        }
        if (this.sVV.pCn == null) {
            str = "";
        } else {
            str = this.sVV.pCn.fuH;
        }
        t.d(i2, str, 23, "");
        this.sVV.pCn.vzy = 0;
        this.sVV.sVK.setVisibility(0);
        this.sVV.sVL.setTextColor(this.sVV.getContext().getResources().getColor(c.btB));
        this.sVV.sVL.setText(i.uRF);
        i2 = (int) (System.currentTimeMillis() / 1000);
        int e = i2 - m.e(this.sVV);
        if (e > 1) {
            m.a(this.sVV, i2);
            m.f(this.sVV);
            payInfo = this.sVV.pCn;
            payInfo.vzz++;
        }
        g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
        boolean z2 = i == 2 || i == 10308;
        if (bVar.fCC == 2) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[]{Boolean.valueOf(z2), Integer.valueOf(m.g(this.sVV)), Integer.valueOf(i), Boolean.valueOf(z)});
        if ((z || (m.g(this.sVV) < 3 && e > 1)) && !z2) {
            x.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
            if (m.h(this.sVV) == null) {
                m.a(this.sVV, com.tencent.mm.ui.c.a.fA(this.sVV.getContext()));
            }
            this.sVV.sVM.setVisibility(8);
            this.sVV.sVL.setVisibility(4);
            m.h(this.sVV).reset();
            m.h(this.sVV).setAnimationListener(new 1(this));
            this.sVV.sVL.startAnimation(m.h(this.sVV));
            a.ya(1);
        } else if (m.g(this.sVV) >= 3 || z2) {
            x.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
            m.bMQ();
            this.sVV.sVN = 0;
            m.i(this.sVV);
            this.sVV.sVJ.setVisibility(8);
            this.sVV.sVK.setVisibility(8);
            this.sVV.sVL.setVisibility(0);
            this.sVV.sVL.setText(i.uRG);
            this.sVV.sVL.setTextColor(this.sVV.getContext().getResources().getColor(c.ubG));
            this.sVV.sVp.setText(i.uVu);
            this.sVV.sVu.setVisibility(0);
            if (!this.sVV.ofs.isShown()) {
                this.sVV.ofs.setVisibility(0);
            }
            a.ya(2);
            m.jR(true);
        }
    }
}
