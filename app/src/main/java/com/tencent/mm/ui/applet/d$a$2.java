package com.tencent.mm.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ca.d;
import com.tencent.mm.ui.applet.d.a;

class d$a$2 implements OnClickListener {
    final /* synthetic */ a xWC;

    d$a$2(a aVar) {
        this.xWC = aVar;
    }

    public final void onClick(View view) {
        if (this.xWC.xWx && this.xWC.fyi.getVisibility() != 0) {
            d.clq().b(this.xWC.xWz);
        }
        a aVar = this.xWC;
        try {
            if (aVar.xWe != null) {
                if (aVar.xWd != null) {
                    aVar.xWe.removeView(aVar.xWd);
                }
                aVar.xWe = null;
            }
            if (aVar.xWd != null) {
                aVar.xWd.removeAllViews();
                aVar.xWd = null;
            }
            aVar.mView = null;
        } catch (Exception e) {
        }
        d.coG();
    }
}
