package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.o.a;

class SwitchRealnameVerifyModeUI$3 implements a {
    final /* synthetic */ View jLA;
    final /* synthetic */ SwitchRealnameVerifyModeUI sJB;

    SwitchRealnameVerifyModeUI$3(SwitchRealnameVerifyModeUI switchRealnameVerifyModeUI, View view) {
        this.sJB = switchRealnameVerifyModeUI;
        this.jLA = view;
    }

    public final void aYr() {
        this.sJB.bJ(this.jLA);
        SwitchRealnameVerifyModeUI.b(this.sJB);
    }

    public final void cancel() {
        SwitchRealnameVerifyModeUI.c(this.sJB).fpa = false;
    }

    public final void aYs() {
        this.sJB.bJ(this.jLA);
    }
}
