package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.p.d;

class RecordMsgDetailUI$3$2 implements d {
    final /* synthetic */ 3 pGm;

    RecordMsgDetailUI$3$2(3 3) {
        this.pGm = 3;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Retr_Msg_Type", 10);
                intent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(this.pGm.pGl));
                com.tencent.mm.bm.d.a(this.pGm.pGl, ".ui.transmit.SelectConversationUI", intent, 1001);
                return;
            case 2:
                b cfVar = new cf();
                f.a(cfVar, RecordMsgDetailUI.c(this.pGm.pGl));
                cfVar.fqp.fqw = 9;
                cfVar.fqp.activity = this.pGm.pGl;
                a.xef.m(cfVar);
                return;
            default:
                return;
        }
    }
}
