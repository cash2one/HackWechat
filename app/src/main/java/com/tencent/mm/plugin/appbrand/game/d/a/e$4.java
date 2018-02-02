package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;

class e$4 implements b {
    final /* synthetic */ e iZK;
    final /* synthetic */ WAGamePanelInputEditText iZL;
    final /* synthetic */ j iZy;

    e$4(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, j jVar) {
        this.iZK = eVar;
        this.iZL = wAGamePanelInputEditText;
        this.iZy = jVar;
    }

    public final void aen() {
        this.iZK.iZC.a(this.iZL.getEditableText().toString(), this.iZy);
    }
}
