package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.i$e;

class SnsCommentFooter$4 implements OnTouchListener {
    final /* synthetic */ SnsCommentFooter rBl;

    SnsCommentFooter$4(SnsCommentFooter snsCommentFooter) {
        this.rBl = snsCommentFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SnsCommentFooter.g(this.rBl);
        SnsCommentFooter.j(this.rBl).setVisibility(8);
        SnsCommentFooter.j(this.rBl).onPause();
        SnsCommentFooter.f(this.rBl).setImageResource(i$e.bBn);
        if (SnsCommentFooter.k(this.rBl) != null) {
            SnsCommentFooter.k(this.rBl).bAH();
        }
        SnsCommentFooter.a(this.rBl, 0);
        return false;
    }
}
