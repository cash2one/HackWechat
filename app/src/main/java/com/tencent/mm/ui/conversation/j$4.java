package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class j$4 implements c {
    final /* synthetic */ j yZL;

    j$4(j jVar) {
        this.yZL = jVar;
    }

    public final int ci(View view) {
        return j.d(this.yZL).getPositionForView(view);
    }
}
