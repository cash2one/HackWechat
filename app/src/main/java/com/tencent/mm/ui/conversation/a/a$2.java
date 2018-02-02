package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ a zaq;

    a$2(a aVar) {
        this.zaq = aVar;
    }

    public final void onClick(View view) {
        if (this.zaq.zan != null && this.zaq.zap != null) {
            c Gu = this.zaq.zan.Gu(this.zaq.abP);
            this.zaq.zap.fO(Gu.zas.id, Gu.zas.url);
        }
    }
}
