package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class a$3 implements OnClickListener {
    final /* synthetic */ a jVO;
    final /* synthetic */ OnClickListener jVP;

    a$3(a aVar, OnClickListener onClickListener) {
        this.jVO = aVar;
        this.jVP = onClickListener;
    }

    public final void onClick(View view) {
        if (System.currentTimeMillis() - a.e(this.jVO) < 250) {
            this.jVP.onClick(view);
            a.a(this.jVO, 0);
        }
        a.a(this.jVO, System.currentTimeMillis());
    }
}
