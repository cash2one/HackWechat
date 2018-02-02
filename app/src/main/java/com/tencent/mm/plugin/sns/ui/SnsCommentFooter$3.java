package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentFooter$3 implements OnClickListener {
    final /* synthetic */ SnsCommentFooter rBl;

    SnsCommentFooter$3(SnsCommentFooter snsCommentFooter) {
        this.rBl = snsCommentFooter;
    }

    public final void onClick(View view) {
        this.rBl.oky = true;
        x.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.c(this.rBl));
        if (SnsCommentFooter.c(this.rBl) == 0) {
            SnsCommentFooter.d(this.rBl);
            SnsCommentFooter.a(this.rBl).requestFocus();
            SnsCommentFooter.a(this.rBl, 1);
            SnsCommentFooter.e(this.rBl);
            SnsCommentFooter.f(this.rBl).setImageResource(e.bBo);
            SnsCommentFooter.g(this.rBl);
            return;
        }
        SnsCommentFooter.h(this.rBl);
        SnsCommentFooter.g(this.rBl);
        SnsCommentFooter.a(this.rBl).requestFocus();
        SnsCommentFooter.i(this.rBl);
        SnsCommentFooter.f(this.rBl).setImageResource(e.bBn);
        SnsCommentFooter.a(this.rBl, 0);
    }
}
