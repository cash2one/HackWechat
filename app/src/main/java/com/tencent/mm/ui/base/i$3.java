package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.i.a.a;

class i$3 implements OnClickListener {
    final /* synthetic */ i xZn;
    final /* synthetic */ a xZp;

    i$3(i iVar, a aVar) {
        this.xZn = iVar;
        this.xZp = aVar;
    }

    public final void onClick(View view) {
        if (this.xZp != null) {
            this.xZp.aJL();
        }
    }
}
