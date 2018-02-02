package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.n$b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

class GameDownloadView$4 implements n$b {
    final /* synthetic */ GameDownloadView npP;

    GameDownloadView$4(GameDownloadView gameDownloadView) {
        this.npP = gameDownloadView;
    }

    public final void h(int i, String str, boolean z) {
        if (z && !bh.ov(str) && GameDownloadView.b(this.npP) != null && GameDownloadView.b(this.npP).nbT != null && GameDownloadView.b(this.npP).nbT.field_appId.equals(str)) {
            GameDownloadView.b(this.npP).cP(ac.getContext());
            GameDownloadView.b(this.npP).aQj();
            GameDownloadView.a(this.npP);
        }
    }
}
