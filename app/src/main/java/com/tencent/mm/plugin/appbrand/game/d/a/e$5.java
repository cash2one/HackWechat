package com.tencent.mm.plugin.appbrand.game.d.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.j;

class e$5 implements OnClickListener {
    final /* synthetic */ e iZK;
    final /* synthetic */ WAGamePanelInputEditText iZL;
    final /* synthetic */ a iZM;
    final /* synthetic */ j iZy;

    e$5(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, j jVar, a aVar) {
        this.iZK = eVar;
        this.iZL = wAGamePanelInputEditText;
        this.iZy = jVar;
        this.iZM = aVar;
    }

    public final void onClick(View view) {
        this.iZK.iZE.a(this.iZL.getEditableText().toString(), this.iZy);
        this.iZK.iZC.a(this.iZL.getEditableText().toString(), this.iZy);
        this.iZM.hide();
    }
}
