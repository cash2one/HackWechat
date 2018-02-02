package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.sdk.platformtools.ag;

class GameCategoryUI$5 implements Runnable {
    final /* synthetic */ GameCategoryUI nmk;
    final /* synthetic */ a nml;

    GameCategoryUI$5(GameCategoryUI gameCategoryUI, a aVar) {
        this.nmk = gameCategoryUI;
        this.nml = aVar;
    }

    public final void run() {
        final ae aeVar = new ae(this.nml, GameCategoryUI.a(this.nmk), GameCategoryUI.h(this.nmk));
        ag.y(new Runnable(this) {
            final /* synthetic */ GameCategoryUI$5 nmn;

            public final void run() {
                GameCategoryUI.a(this.nmn.nmk, aeVar, GameCategoryUI.h(this.nmn.nmk) != 0);
                GameCategoryUI.i(this.nmn.nmk);
                GameCategoryUI.f(this.nmn.nmk).setVisibility(8);
                GameCategoryUI.a(this.nmn.nmk, GameCategoryUI.h(this.nmn.nmk) + 15);
                if (GameCategoryUI.j(this.nmn.nmk) != null) {
                    GameCategoryUI.j(this.nmn.nmk).dismiss();
                }
            }
        });
    }
}
