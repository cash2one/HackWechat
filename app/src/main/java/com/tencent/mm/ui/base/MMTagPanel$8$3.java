package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.MMTagPanel.8;

class MMTagPanel$8$3 implements Runnable {
    final /* synthetic */ View jLA;
    final /* synthetic */ 8 ydT;

    MMTagPanel$8$3(8 8, View view) {
        this.ydT = 8;
        this.jLA = view;
    }

    public final void run() {
        this.ydT.ydR.ydL.yI(((TextView) this.jLA).getText().toString());
    }
}
