package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FavTipsUI$1 implements OnClickListener {
    final /* synthetic */ FavTipsUI mtJ;

    FavTipsUI$1(FavTipsUI favTipsUI) {
        this.mtJ = favTipsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mtJ.finish();
    }
}
