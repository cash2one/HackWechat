package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;

class u$2 implements OnClickListener {
    final /* synthetic */ u jYI;

    u$2(u uVar) {
        this.jYI = uVar;
    }

    public final void onClick(View view) {
        if (view.isSelected()) {
            u.amY().m(this.jYI);
            view.setSelected(false);
            return;
        }
        u.amY().n(this.jYI);
        view.setSelected(true);
    }
}
