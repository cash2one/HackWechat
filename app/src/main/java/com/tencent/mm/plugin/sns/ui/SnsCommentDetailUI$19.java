package com.tencent.mm.plugin.sns.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ak.b.a;

class SnsCommentDetailUI$19 implements a {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$19(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void v(String str, boolean z) {
        new af(Looper.getMainLooper()).postDelayed(new 1(this, z), 500);
    }
}
