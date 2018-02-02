package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g.a;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;

class FavoriteImgDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteImgDetailUI mwK;

    FavoriteImgDetailUI$2(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.mwK = favoriteImgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.mwK.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new d(this) {
            final /* synthetic */ FavoriteImgDetailUI$2 mwL;

            {
                this.mwL = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Intent intent;
                a c;
                switch (menuItem.getItemId()) {
                    case 0:
                        intent = new Intent(this.mwL.mwK.mController.xIM, FavTagEditUI.class);
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavoriteImgDetailUI.b(this.mwL.mwK).field_localId);
                        this.mwL.mwK.mController.xIM.startActivity(intent);
                        c = FavoriteImgDetailUI.c(this.mwL.mwK);
                        c.mog++;
                        return;
                    case 1:
                        h.a(this.mwL.mwK.mController.xIM, this.mwL.mwK.getString(R.l.dEx), "", new 1(this), null);
                        return;
                    case 2:
                        intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("scene_from", 1);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("select_fav_local_id", FavoriteImgDetailUI.b(this.mwL.mwK).field_localId);
                        com.tencent.mm.bm.d.a(this.mwL.mwK, ".ui.transmit.SelectConversationUI", intent, 1);
                        com.tencent.mm.plugin.report.service.g.pQN.h(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
                        c = FavoriteImgDetailUI.e(this.mwL.mwK);
                        c.mod++;
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUk();
        return true;
    }
}
