package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.bindmobile.b.a;

class b$a$1 implements OnClickListener {
    final /* synthetic */ b ymv;
    final /* synthetic */ a ymw;

    b$a$1(a aVar, b bVar) {
        this.ymw = aVar;
        this.ymv = bVar;
    }

    public final void onClick(View view) {
        if (this.ymw.ymq.ymp != null) {
            this.ymw.ymq.ymp.h(this.ymw.wXW, this.ymw.fqR, this.ymw.status);
        }
    }
}
