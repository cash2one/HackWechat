package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.c;

class SnsCommentFooter$6 implements OnClickListener {
    final /* synthetic */ SnsCommentFooter rBl;
    final /* synthetic */ c rBn;

    SnsCommentFooter$6(SnsCommentFooter snsCommentFooter, c cVar) {
        this.rBl = snsCommentFooter;
        this.rBn = cVar;
    }

    public final void onClick(View view) {
        com.tencent.mm.ui.tools.a.c GN = com.tencent.mm.ui.tools.a.c.d(SnsCommentFooter.a(this.rBl)).GN(b.zB());
        GN.znM = true;
        GN.a(new 1(this));
    }
}
