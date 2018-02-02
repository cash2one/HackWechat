package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase.a;

class u$4 implements a {
    final /* synthetic */ u jYI;

    u$4(u uVar) {
        this.jYI = uVar;
    }

    public final void append(String str) {
        if (u.c(this.jYI) != null) {
            u.c(this.jYI).uX(str);
        }
    }

    public final void amZ() {
        if (u.c(this.jYI) != null) {
            u.c(this.jYI).uX("[DELETE_EMOTION]");
        }
    }
}
