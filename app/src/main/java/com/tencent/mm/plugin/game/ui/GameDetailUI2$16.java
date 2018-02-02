package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class GameDetailUI2$16 implements OnClickListener {
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$16(GameDetailUI2 gameDetailUI2) {
        this.npz = gameDetailUI2;
    }

    public final void onClick(View view) {
        if (GameDetailUI2.l(this.npz) == null) {
            x.e("MicroMsg.GameDetailUI2", "Null appInfo");
        } else if (GameDetailUI2.i(this.npz) == null) {
            x.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
        } else {
            GameDetailUI2.i(this.npz).cP(this.npz.mController.xIM);
            GameDetailUI2.m(this.npz).a(GameDetailUI2.l(this.npz), GameDetailUI2.i(this.npz));
        }
    }
}
