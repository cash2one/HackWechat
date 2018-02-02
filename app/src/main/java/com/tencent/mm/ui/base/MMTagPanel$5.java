package com.tencent.mm.ui.base;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.x;

class MMTagPanel$5 implements OnEditorActionListener {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$5(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        x.d("MicroMsg.MMTagPanel", "on action %d, %s", new Object[]{Integer.valueOf(i), keyEvent});
        return false;
    }
}
