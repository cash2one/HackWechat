package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.FavCleanUI.5.1;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

class FavCleanUI$5$1$1 implements Runnable {
    final /* synthetic */ List msj;
    final /* synthetic */ Dialog msk;
    final /* synthetic */ 1 msl;

    FavCleanUI$5$1$1(1 1, List list, Dialog dialog) {
        this.msl = 1;
        this.msj = list;
        this.msk = dialog;
    }

    public final void run() {
        j.aK(this.msj);
        ag.y(new 1(this));
    }
}
