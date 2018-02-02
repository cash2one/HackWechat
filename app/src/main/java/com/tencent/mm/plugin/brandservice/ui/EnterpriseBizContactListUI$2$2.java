package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.2;
import com.tencent.mm.ui.base.p$d;

class EnterpriseBizContactListUI$2$2 implements p$d {
    final /* synthetic */ 2 kGj;

    EnterpriseBizContactListUI$2$2(2 2) {
        this.kGj = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 2:
                intent = new Intent();
                intent.putExtra("Select_Talker_Name", this.kGj.kGi.kGd);
                intent.putExtra("Select_block_List", this.kGj.kGi.kGd);
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("Select_Conv_Type", 3);
                d.a(this.kGj.kGi, ".ui.transmit.SelectConversationUI", intent, 1);
                return;
            case 3:
                intent = new Intent(this.kGj.kGi, EnterpriseBizContactPlainListUI.class);
                intent.putExtra("enterprise_biz_name", this.kGj.kGi.kGd);
                intent.putExtra("enterprise_scene", 2);
                this.kGj.kGi.startActivity(intent);
                return;
            case 4:
                intent = new Intent();
                intent.putExtra("Contact_User", this.kGj.kGi.kGd);
                a.ifs.d(intent, this.kGj.kGi);
                return;
            default:
                return;
        }
    }
}
