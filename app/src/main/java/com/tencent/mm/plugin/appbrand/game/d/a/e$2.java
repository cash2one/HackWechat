package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.widget.input.n.a;

class e$2 extends a {
    final /* synthetic */ e iZK;
    final /* synthetic */ WAGamePanelInputEditText iZL;
    final /* synthetic */ j iZy;

    e$2(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, j jVar) {
        this.iZK = eVar;
        this.iZL = wAGamePanelInputEditText;
        this.iZy = jVar;
    }

    public final void aem() {
        this.iZK.iZC.a(this.iZL.getEditableText().toString(), this.iZy);
    }
}
