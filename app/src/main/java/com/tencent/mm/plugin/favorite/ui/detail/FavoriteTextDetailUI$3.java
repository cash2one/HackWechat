package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class FavoriteTextDetailUI$3 implements d {
    final /* synthetic */ FavoriteTextDetailUI mxo;

    FavoriteTextDetailUI$3(FavoriteTextDetailUI favoriteTextDetailUI) {
        this.mxo = favoriteTextDetailUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (FavoriteTextDetailUI.g(this.mxo) != null && FavoriteTextDetailUI.a(this.mxo) != null && FavoriteTextDetailUI.a(this.mxo).field_favProto != null) {
                    FavoriteTextDetailUI.g(this.mxo).setText(FavoriteTextDetailUI.a(this.mxo).field_favProto.desc);
                    h.bu(this.mxo.mController.xIM, this.mxo.mController.xIM.getString(R.l.dEt));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
