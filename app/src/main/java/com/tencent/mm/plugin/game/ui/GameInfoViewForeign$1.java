package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;

class GameInfoViewForeign$1 implements OnClickListener {
    final /* synthetic */ GameInfoViewForeign nrM;

    GameInfoViewForeign$1(GameInfoViewForeign gameInfoViewForeign) {
        this.nrM = gameInfoViewForeign;
    }

    public final void onClick(View view) {
        int p;
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            a aPR = b.aPR();
            if (aPR.fDt == 2) {
                p = c.p(GameInfoViewForeign.a(this.nrM), aPR.url, "game_center_msgcenter");
            } else {
                Intent intent = new Intent(GameInfoViewForeign.a(this.nrM), GameMessageUI.class);
                intent.putExtra("game_report_from_scene", 1001);
                GameInfoViewForeign.a(this.nrM).startActivity(intent);
                p = 6;
            }
        } else {
            p = c.p(GameInfoViewForeign.a(this.nrM), (String) view.getTag(), "game_center_msgcenter");
        }
        ap.a(GameInfoViewForeign.a(this.nrM), 10, 1001, GameInfoViewForeign.b(this.nrM), p, 0, null, GameInfoViewForeign.c(this.nrM), 0, null, null, ap.cL("resource", "5"));
    }
}
