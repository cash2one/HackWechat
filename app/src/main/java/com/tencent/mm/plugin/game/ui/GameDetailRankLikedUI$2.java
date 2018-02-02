package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.game.c.bz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;

class GameDetailRankLikedUI$2 implements a {
    final /* synthetic */ GameDetailRankLikedUI nos;

    GameDetailRankLikedUI$2(GameDetailRankLikedUI gameDetailRankLikedUI) {
        this.nos = gameDetailRankLikedUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0) {
            bz bzVar = (bz) bVar.hmh.hmo;
            GameDetailRankLikedUI$a a = GameDetailRankLikedUI.a(this.nos);
            Collection collection = bzVar.niO;
            if (collection != null) {
                a.not.clear();
                a.not.addAll(collection);
                a.notifyDataSetChanged();
            }
            GameDetailRankLikedUI.b(this.nos).dismiss();
        } else {
            x.e(GameDetailRankLikedUI.by(), "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.nos.finish();
        }
        return 0;
    }
}
