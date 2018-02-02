package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI.a;
import com.tencent.mm.z.u;

class GameDetailUI2$17 implements OnClickListener {
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$17(GameDetailUI2 gameDetailUI2) {
        this.npz = gameDetailUI2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            c.a(view, this.npz);
            ap.a(this.npz.mController.xIM, 12, 1203, 999, 7, GameDetailUI2.f(this.npz), GameDetailUI2.g(this.npz), null);
            return;
        }
        a aVar = new a();
        aVar.noA = GameDetailUI2.n(this.npz);
        aVar.noB = GameDetailUI2.o(this.npz);
        aVar.noC = GameDetailUI2.l(this.npz);
        String hz = u.hz("rankData");
        u.GK().t(hz, true).o(GameDetailRankUI.noy, aVar);
        Intent intent = new Intent(this.npz.mController.xIM, GameDetailRankUI.class);
        intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, hz);
        this.npz.startActivity(intent);
        ap.a(this.npz.mController.xIM, 12, 1203, 999, 6, GameDetailUI2.f(this.npz), GameDetailUI2.g(this.npz), null);
    }
}
