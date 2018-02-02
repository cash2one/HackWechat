package com.tencent.mm.plugin.appbrand.game.d.a;

import android.text.Editable;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.ui.widget.j;

class e$3 extends j {
    final /* synthetic */ e iZK;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.j iZy;

    e$3(e eVar, com.tencent.mm.plugin.appbrand.j jVar) {
        this.iZK = eVar;
        this.iZy = jVar;
    }

    public final void afterTextChanged(Editable editable) {
        if (!af.t(editable)) {
            this.iZK.iZC.a(editable.toString(), this.iZy);
        }
    }
}
