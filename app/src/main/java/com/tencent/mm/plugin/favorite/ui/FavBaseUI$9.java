package com.tencent.mm.plugin.favorite.ui;

import android.os.SystemClock;
import com.tencent.mm.plugin.favorite.ui.a.a;
import com.tencent.mm.sdk.platformtools.x;

class FavBaseUI$9 implements Runnable {
    final /* synthetic */ FavBaseUI mrW;

    FavBaseUI$9(FavBaseUI favBaseUI) {
        this.mrW = favBaseUI;
    }

    public final void run() {
        a aJb = this.mrW.aJb();
        if (aJb.isEmpty() || SystemClock.elapsedRealtime() - FavBaseUI.e(this.mrW) >= 400) {
            FavBaseUI.f(this.mrW);
            FavBaseUI.a(this.mrW, SystemClock.elapsedRealtime());
            x.v("MicroMsg.FavoriteBaseUI", "do refresh job");
            aJb.notifyDataSetChanged();
            this.mrW.a(aJb);
            if (this.mrW.mrF) {
                x.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                this.mrW.mrI.setSelection(0);
                this.mrW.mrF = false;
                return;
            }
            return;
        }
        x.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(this.mrW)), Integer.valueOf(400)});
        this.mrW.hae.postDelayed(this, 200);
    }
}
