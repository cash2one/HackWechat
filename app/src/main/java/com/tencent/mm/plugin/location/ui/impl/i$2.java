package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class i$2 implements d {
    final /* synthetic */ i nYD;

    i$2(i iVar) {
        this.nYD = iVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                this.nYD.aWM();
                return;
            case 1:
                if (this.nYD.type == 2) {
                    g.pQN.h(10651, Integer.valueOf(6), Integer.valueOf(1), Integer.valueOf(0));
                }
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", e.a(this.nYD.nVS));
                intent.putExtra("Retr_Msg_Type", 9);
                com.tencent.mm.bm.d.a(this.nYD.activity, ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 2:
                this.nYD.fuA = 0;
                this.nYD.aWO();
                return;
            case 3:
                this.nYD.aWN();
                return;
            case 4:
                h.a(this.nYD.activity, this.nYD.activity.getString(R.l.dEx), "", new 1(this), null);
                return;
            case 5:
                long longExtra = this.nYD.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                Intent intent2 = new Intent();
                intent2.putExtra("key_fav_item_id", longExtra);
                intent2.putExtra("key_fav_scene", 2);
                com.tencent.mm.bm.d.b(this.nYD.activity, "favorite", ".ui.FavTagEditUI", intent2);
                return;
            case 6:
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", e.a(this.nYD.nVS));
                intent.putExtra("Retr_Msg_Id", this.nYD.fqm);
                com.tencent.mm.bm.d.a(this.nYD.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                return;
            default:
                return;
        }
    }
}
