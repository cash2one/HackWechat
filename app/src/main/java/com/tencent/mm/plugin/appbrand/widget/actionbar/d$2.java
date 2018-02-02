package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class d$2 implements OnKeyListener {
    final /* synthetic */ d jWe;

    d$2(d dVar) {
        this.jWe = dVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.jWe.dismiss();
        return true;
    }
}
