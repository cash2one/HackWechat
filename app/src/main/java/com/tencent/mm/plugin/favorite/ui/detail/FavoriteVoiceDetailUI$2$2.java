package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g.a;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVoiceDetailUI.2;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;

class FavoriteVoiceDetailUI$2$2 implements p$d {
    final /* synthetic */ 2 mxH;

    FavoriteVoiceDetailUI$2$2(2 2) {
        this.mxH = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                Intent intent = new Intent(this.mxH.mxG.mController.xIM, FavTagEditUI.class);
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.a(this.mxH.mxG).field_localId);
                this.mxH.mxG.mController.xIM.startActivity(intent);
                a b = FavoriteVoiceDetailUI.b(this.mxH.mxG);
                b.mog++;
                return;
            case 1:
                h.a(this.mxH.mxG.mController.xIM, this.mxH.mxG.getString(R.l.dEx), "", new 1(this), null);
                return;
            default:
                return;
        }
    }
}
