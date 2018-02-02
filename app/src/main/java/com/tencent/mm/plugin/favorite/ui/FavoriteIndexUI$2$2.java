package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI.2;
import com.tencent.mm.plugin.report.service.g;

class FavoriteIndexUI$2$2 implements OnClickListener {
    final /* synthetic */ 2 mtT;

    FavoriteIndexUI$2$2(2 2) {
        this.mtT = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FavoriteIndexUI.a(this.mtT.mtS, FavoriteIndexUI.a(this.mtT.mtS).fc(true));
        g.pQN.h(11125, new Object[]{Integer.valueOf(r0.size()), Integer.valueOf(3)});
        if (FavoriteIndexUI.a(this.mtT.mtS).mup) {
            FavoriteIndexUI.b(this.mtT.mtS);
        }
    }
}
