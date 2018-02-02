package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.ui.MallEditText.a.a;
import com.tencent.mm.sdk.platformtools.bh;

class MallEditText$a$a$3 implements Runnable {
    final /* synthetic */ a pCF;
    final /* synthetic */ com.tencent.mm.plugin.recharge.model.a pCG;

    MallEditText$a$a$3(a aVar, com.tencent.mm.plugin.recharge.model.a aVar2) {
        this.pCF = aVar;
        this.pCG = aVar2;
    }

    public final void run() {
        MallEditText.a(this.pCF.pCE.pCy, this.pCG);
        if (bh.ov(MallEditText.e(this.pCF.pCE.pCy).name)) {
            MallEditText.g(this.pCF.pCE.pCy).setText("");
            MallEditText.g(this.pCF.pCE.pCy).setVisibility(8);
        } else {
            MallEditText.g(this.pCF.pCE.pCy).setText(MallEditText.e(this.pCF.pCE.pCy).name);
            MallEditText.g(this.pCF.pCE.pCy).setVisibility(0);
        }
        MallEditText.a(this.pCF.pCE.pCy).dismissDropDown();
    }
}
