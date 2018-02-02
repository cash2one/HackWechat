package com.tencent.mm.ui;

import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class Sort3rdAppUI$a$1 implements a {
    final /* synthetic */ f xMJ;
    final /* synthetic */ Sort3rdAppUI.a xMK;

    Sort3rdAppUI$a$1(Sort3rdAppUI.a aVar, f fVar) {
        this.xMK = aVar;
        this.xMJ = fVar;
    }

    public final void cw(boolean z) {
        f fVar;
        if (z) {
            fVar = this.xMJ;
            fVar.field_appInfoFlag &= -16385;
        } else {
            fVar = this.xMJ;
            fVar.field_appInfoFlag |= 16384;
        }
        an.bin().a(this.xMJ, new String[0]);
    }
}
