package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;

class h$1 implements OnClickListener {
    final /* synthetic */ j yDe;
    final /* synthetic */ h yEK;

    h$1(h hVar, j jVar) {
        this.yEK = hVar;
        this.yDe = jVar;
    }

    public final void onClick(View view) {
        this.yDe.cvk().yGd.k(this.yEK.yCR.yCS.mController.xIM, true);
    }
}
