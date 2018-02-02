package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI.1;

class FavoriteFileDetailUI$1$1 implements Runnable {
    final /* synthetic */ 1 mwp;
    final /* synthetic */ Intent val$intent;

    FavoriteFileDetailUI$1$1(1 1, Intent intent) {
        this.mwp = 1;
        this.val$intent = intent;
    }

    public final void run() {
        WorkerProfile.uu().fgx.j(this.val$intent, this.mwp.mwo);
        this.mwp.mwo.finish();
    }
}
