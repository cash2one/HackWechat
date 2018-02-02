package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.widget.g;

class SnsOnlineVideoActivity$7 implements OnLongClickListener {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$7(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    public final boolean onLongClick(View view) {
        SnsOnlineVideoActivity.a(this.rEF, new g(this.rEF.mController.xIM, g.ztp, false));
        SnsOnlineVideoActivity.l(this.rEF).rKC = this.rEF.rEE;
        SnsOnlineVideoActivity.l(this.rEF).rKD = this.rEF.onK;
        SnsOnlineVideoActivity.l(this.rEF).ztB = new 1(this);
        SnsOnlineVideoActivity.l(this.rEF).bUk();
        return true;
    }
}
