package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.ui.b.b;

class SnsCommentDetailUI$3 extends b {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$3(SnsCommentDetailUI snsCommentDetailUI, Activity activity, ad adVar) {
        this.rAr = snsCommentDetailUI;
        super(1, activity, adVar);
    }

    public final void b(View view, int i, int i2, int i3) {
    }

    public final void bL(Object obj) {
        SnsCommentDetailUI.f(this.rAr);
        SnsCommentDetailUI.p(this.rAr).a((View) obj, 2, null);
    }

    public final void bzg() {
    }

    public final void cE(View view) {
    }

    public final void cD(View view) {
    }

    public final void cB(View view) {
    }

    public final void cC(View view) {
    }

    public final void cF(View view) {
        SnsCommentDetailUI.q(this.rAr).cA(view);
    }

    public final void bzh() {
        SnsCommentDetailUI.q(this.rAr).byS();
    }

    public final void cG(View view) {
        SnsCommentDetailUI.q(this.rAr).bwm();
        Intent intent = new Intent();
        intent.putExtra("result_finish", true);
        this.rAr.setResult(-1, intent);
        this.rAr.finish();
    }
}
