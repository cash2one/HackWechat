package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FavoriteIndexUI$10 implements OnClickListener {
    final /* synthetic */ FavoriteIndexUI mtS;

    FavoriteIndexUI$10(FavoriteIndexUI favoriteIndexUI) {
        this.mtS = favoriteIndexUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.mtS.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
