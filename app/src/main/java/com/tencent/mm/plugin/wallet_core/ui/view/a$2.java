package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import com.tencent.mm.ui.MMActivity;

class a$2 implements Runnable {
    final /* synthetic */ Context val$context;

    a$2(Context context) {
        this.val$context = context;
    }

    public final void run() {
        ((MMActivity) this.val$context).showVKB();
    }
}
