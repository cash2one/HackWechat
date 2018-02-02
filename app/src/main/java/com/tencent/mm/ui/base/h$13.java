package com.tencent.mm.ui.base;

import android.content.Context;
import com.tencent.mm.ui.MMActivity;

class h$13 implements Runnable {
    final /* synthetic */ Context val$context;

    h$13(Context context) {
        this.val$context = context;
    }

    public final void run() {
        ((MMActivity) this.val$context).showVKB();
    }
}
