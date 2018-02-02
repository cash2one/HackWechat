package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g$a;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI.4;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class FavoriteSightDetailUI$4$2 implements d {
    final /* synthetic */ 4 mxg;

    FavoriteSightDetailUI$4$2(4 4) {
        this.mxg = 4;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        g$a k;
        switch (menuItem.getItemId()) {
            case 0:
                g.pQN.h(10651, new Object[]{Integer.valueOf(FavoriteSightDetailUI.a(this.mxg.mxe).field_type), Integer.valueOf(1), Integer.valueOf(0)});
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 1);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(this.mxg.mxe).field_localId);
                com.tencent.mm.bm.d.a(this.mxg.mxe.mController.xIM, ".ui.transmit.SelectConversationUI", intent, 1);
                k = FavoriteSightDetailUI.k(this.mxg.mxe);
                k.mod++;
                return;
            case 2:
                h.a(this.mxg.mxe.mController.xIM, this.mxg.mxe.getString(R.l.dEx), "", new OnClickListener(this) {
                    final /* synthetic */ FavoriteSightDetailUI$4$2 mxh;

                    {
                        this.mxh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.a(FavoriteSightDetailUI.a(this.mxh.mxg.mxe).field_localId, new 1(this, h.a(this.mxh.mxg.mxe.mController.xIM, this.mxh.mxg.mxe.getString(R.l.dEx), false, null)));
                    }
                }, null);
                return;
            case 3:
                k = FavoriteSightDetailUI.m(this.mxg.mxe);
                k.mog++;
                intent = new Intent(this.mxg.mxe.mController.xIM, FavTagEditUI.class);
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(this.mxg.mxe).field_localId);
                this.mxg.mxe.mController.xIM.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
