package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.g.b;
import com.tencent.mm.plugin.sns.ui.g.b.a;

class g$b$2 implements OnClickListener {
    final /* synthetic */ b rqB;

    g$b$2(b bVar) {
        this.rqB = bVar;
    }

    public final void onClick(View view) {
        this.rqB.rqA = (a) view.getTag();
        this.rqB.xq(this.rqB.rqA.position);
    }
}
