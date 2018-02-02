package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class FavCapacityPanel$1 implements OnClickListener {
    final /* synthetic */ FavCapacityPanel muN;

    FavCapacityPanel$1(FavCapacityPanel favCapacityPanel) {
        this.muN = favCapacityPanel;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        if (this.muN.muL == 0) {
            intent.putExtra("key_enter_fav_cleanui_from", 1);
        } else {
            intent.putExtra("key_enter_fav_cleanui_from", 2);
        }
        d.b(this.muN.getContext(), "favorite", ".ui.FavCleanUI", intent);
    }
}
