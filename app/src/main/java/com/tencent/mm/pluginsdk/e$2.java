package com.tencent.mm.pluginsdk;

import android.view.View;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;

class e$2 implements Runnable {
    final /* synthetic */ MMFragmentActivity vck;
    final /* synthetic */ View vcl;

    e$2(MMFragmentActivity mMFragmentActivity, View view) {
        this.vck = mMFragmentActivity;
        this.vcl = view;
    }

    public final void run() {
        this.vck.getWindow().getDecorView().setSystemUiVisibility(this.vck.getWindow().getDecorView().getSystemUiVisibility() | 256);
        x.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[]{Integer.valueOf(a.g(this.vck))});
        if (this.vcl != null) {
            this.vcl.setPadding(0, r0, 0, 0);
        }
    }
}
