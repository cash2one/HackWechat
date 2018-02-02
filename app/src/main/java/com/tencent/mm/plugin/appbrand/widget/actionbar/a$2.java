package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ a jVO;

    a$2(a aVar) {
        this.jVO = aVar;
    }

    public final void onClick(View view) {
        if (a.c(this.jVO) != null) {
            a.c(this.jVO).onClick(a.d(this.jVO));
        } else if (a.a(this.jVO) != null) {
            a.a(this.jVO).onClick(a.d(this.jVO));
        }
    }
}
