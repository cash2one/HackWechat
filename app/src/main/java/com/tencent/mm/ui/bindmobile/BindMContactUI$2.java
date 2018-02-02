package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.modelsimple.c;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bh;

class BindMContactUI$2 implements a {
    String lbT;
    final /* synthetic */ BindMContactUI ylT;

    BindMContactUI$2(BindMContactUI bindMContactUI) {
        this.ylT = bindMContactUI;
    }

    public final boolean JC() {
        if (bh.ov((BindMContactUI.b(this.ylT).getText()).trim())) {
            if (bh.ov(this.lbT)) {
                BindMContactUI.b(this.ylT).setText("");
            } else {
                BindMContactUI.b(this.ylT).setText(this.lbT);
                BindMContactUI.b(this.ylT).setSelection(this.lbT.length());
            }
        }
        return true;
    }

    public final boolean JB() {
        this.lbT = c.z(this.ylT, BindMContactUI.c(this.ylT));
        return true;
    }

    public final String toString() {
        return super.toString() + "|initView";
    }
}
