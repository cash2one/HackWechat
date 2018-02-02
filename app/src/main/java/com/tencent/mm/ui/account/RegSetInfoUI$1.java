package com.tencent.mm.ui.account;

import com.tencent.mm.modelfriend.x;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;

class RegSetInfoUI$1 implements a {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$1(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final boolean uF() {
        String str;
        String trim = RegSetInfoUI.a(this.xSg).getText().toString().trim();
        String trim2 = RegSetInfoUI.b(this.xSg).getText().toString().trim();
        if (bh.ov(trim) && !bh.ov(trim2)) {
            trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
        }
        if (bh.ov(trim) || !bh.ov(trim2)) {
            str = trim2;
        } else {
            str = trim;
        }
        if (!bh.ov(trim) && RegSetInfoUI.c(this.xSg) && RegSetInfoUI.d(this.xSg)) {
            int e = RegSetInfoUI.e(this.xSg);
            String f = RegSetInfoUI.f(this.xSg);
            ar.CG().a(429, this.xSg);
            ar.CG().a(new x(f, RegSetInfoUI.g(this.xSg), e, str, trim, "", ""), 0);
            RegSetInfoUI.h(this.xSg).setVisibility(0);
        }
        return false;
    }
}
