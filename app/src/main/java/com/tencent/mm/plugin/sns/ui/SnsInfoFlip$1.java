package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

class SnsInfoFlip$1 implements f {
    final /* synthetic */ SnsInfoFlip rCB;
    final /* synthetic */ Context val$context;

    SnsInfoFlip$1(SnsInfoFlip snsInfoFlip, Context context) {
        this.rCB = snsInfoFlip;
        this.val$context = context;
    }

    public final void avW() {
        if (this.val$context instanceof SnsBrowseUI) {
            ((SnsBrowseUI) this.val$context).avV();
        } else if (SnsInfoFlip.a(this.rCB)) {
            ((MMActivity) this.val$context).finish();
        } else {
            SnsInfoFlip.c(this.rCB).post(new 1(this));
        }
    }
}
