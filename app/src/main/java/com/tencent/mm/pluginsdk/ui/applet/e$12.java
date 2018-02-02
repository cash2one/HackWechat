package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.q;

class e$12 implements OnClickListener {
    final /* synthetic */ a vnl;
    final /* synthetic */ q vnm;
    final /* synthetic */ View zS;

    e$12(a aVar, View view, q qVar) {
        this.vnl = aVar;
        this.zS = view;
        this.vnm = qVar;
    }

    public final void onClick(View view) {
        if (this.vnl != null) {
            this.vnl.a(true, e.cY(this.zS), e.cZ(this.zS));
        }
        this.vnm.dismiss();
        this.vnm.setFocusable(false);
        this.vnm.setTouchable(false);
    }
}
