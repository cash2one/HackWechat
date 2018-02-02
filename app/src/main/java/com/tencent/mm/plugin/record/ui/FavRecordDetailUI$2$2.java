package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class FavRecordDetailUI$2$2 implements d {
    final /* synthetic */ 2 pFS;

    FavRecordDetailUI$2$2(2 2) {
        this.pFS = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 1);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("select_fav_local_id", FavRecordDetailUI.b(this.pFS.pFP).field_localId);
                com.tencent.mm.bm.d.a(this.pFS.pFP, ".ui.transmit.SelectConversationUI", intent, 4097);
                g.pQN.h(10651, Integer.valueOf(14), Integer.valueOf(1), Integer.valueOf(0));
                return;
            case 2:
                h.a(this.pFS.pFP.mController.xIM, this.pFS.pFP.getString(R.l.dEx), "", new 1(this), null);
                return;
            case 3:
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavRecordDetailUI.a(this.pFS.pFP));
                com.tencent.mm.bm.d.b(this.pFS.pFP.mController.xIM, "favorite", ".ui.FavTagEditUI", intent);
                return;
            case 4:
                intent = new Intent();
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", FavRecordDetailUI.b(this.pFS.pFP).field_localId);
                com.tencent.mm.bm.d.b(this.pFS.pFP.mController.xIM, "favorite", ".ui.FavTagEditUI", intent);
                return;
            default:
                return;
        }
    }
}
