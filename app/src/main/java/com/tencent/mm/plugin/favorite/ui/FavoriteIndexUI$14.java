package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FavoriteIndexUI$14 implements Runnable {
    final /* synthetic */ FavoriteIndexUI mtS;

    FavoriteIndexUI$14(FavoriteIndexUI favoriteIndexUI) {
        this.mtS = favoriteIndexUI;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        List aIf = h.getFavItemInfoStorage().aIf();
        if (aIf != null) {
            x.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[]{Integer.valueOf(aIf.size()), Long.valueOf(currentTimeMillis)});
            if (aIf.size() != 0) {
                int size = aIf.size();
                for (int i = 0; i < size; i++) {
                    h.getFavItemInfoStorage().g((f) aIf.get(i));
                }
                x.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }
}
