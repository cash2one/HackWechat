package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MMTagPanel$4 implements OnClickListener {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$4(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.MMTagPanel", "on edittext click");
        this.ydR.cpJ();
        if (MMTagPanel.e(this.ydR) != null) {
            MMTagPanel.e(this.ydR).aDz();
        }
    }
}
