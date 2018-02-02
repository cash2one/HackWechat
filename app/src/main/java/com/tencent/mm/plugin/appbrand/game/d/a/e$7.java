package com.tencent.mm.plugin.appbrand.game.d.a;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.j;

class e$7 implements OnEditorActionListener {
    final /* synthetic */ boolean iZI;
    final /* synthetic */ e iZK;
    final /* synthetic */ WAGamePanelInputEditText iZL;
    final /* synthetic */ j iZy;

    e$7(e eVar, boolean z, WAGamePanelInputEditText wAGamePanelInputEditText, j jVar) {
        this.iZK = eVar;
        this.iZI = z;
        this.iZL = wAGamePanelInputEditText;
        this.iZy = jVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (!this.iZI) {
            return false;
        }
        this.iZK.iZE.a(this.iZL.getEditableText().toString(), this.iZy);
        return true;
    }
}
