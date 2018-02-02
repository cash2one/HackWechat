package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.q;

class e$4 implements OnClickListener {
    final /* synthetic */ o$a vnl;
    final /* synthetic */ q vnm;

    e$4(o$a com_tencent_mm_pluginsdk_ui_applet_o_a, q qVar) {
        this.vnl = com_tencent_mm_pluginsdk_ui_applet_o_a;
        this.vnm = qVar;
    }

    public final void onClick(View view) {
        if (this.vnl != null) {
            this.vnl.a(false, null, 0);
        }
        this.vnm.dismiss();
        this.vnm.setFocusable(false);
        this.vnm.setTouchable(false);
    }
}
