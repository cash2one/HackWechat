package com.tencent.mm.ui.account;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;

class RegByMobileSendSmsUI$7 implements a {
    final /* synthetic */ RegByMobileSendSmsUI xQV;

    RegByMobileSendSmsUI$7(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        this.xQV = regByMobileSendSmsUI;
    }

    public final boolean uF() {
        if (RegByMobileSendSmsUI.m(this.xQV) > 0) {
            RegByMobileSendSmsUI.n(this.xQV).setText(this.xQV.getString(R.l.eDN, new Object[]{Integer.valueOf(RegByMobileSendSmsUI.m(this.xQV))}));
            RegByMobileSendSmsUI.o(this.xQV);
            if (RegByMobileSendSmsUI.m(this.xQV) % 4 != 0) {
                return true;
            }
            RegByMobileSendSmsUI.p(this.xQV);
            return true;
        }
        RegByMobileSendSmsUI.n(this.xQV).setText(R.l.eDG);
        RegByMobileSendSmsUI.n(this.xQV).setEnabled(true);
        return false;
    }
}
