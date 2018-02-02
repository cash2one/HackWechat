package com.tencent.mm.plugin.search.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bc.g;
import com.tencent.mm.sdk.platformtools.bh;

class FTSAddFriendUI$3 implements OnClickListener {
    final /* synthetic */ FTSAddFriendUI qbQ;

    FTSAddFriendUI$3(FTSAddFriendUI fTSAddFriendUI) {
        this.qbQ = fTSAddFriendUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.qbQ.fDj)) {
            this.qbQ.qbK = true;
            g.d(this.qbQ.fDj, FTSAddFriendUI.b(this.qbQ), 1, 16);
        }
        FTSAddFriendUI.c(this.qbQ);
    }
}
