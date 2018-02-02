package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class MMTagPanel$3 implements OnFocusChangeListener {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$3(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final void onFocusChange(View view, boolean z) {
        x.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
        if (z && MMTagPanel.e(this.ydR) != null) {
            MMTagPanel.e(this.ydR).aDz();
        }
    }
}
