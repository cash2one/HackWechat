package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.15;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.transmit.SelectConversationUI;

class EnterpriseConversationUI$a$15$2 implements p$d {
    final /* synthetic */ 15 yZj;

    EnterpriseConversationUI$a$15$2(15 15) {
        this.yZj = 15;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 0;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 2:
                g.n(this.yZj.yZh.getContext(), a.c(this.yZj.yZh), 5);
                break;
            case 3:
                intent = new Intent(this.yZj.yZh.thisActivity(), SelectConversationUI.class);
                intent.putExtra("Select_Talker_Name", a.c(this.yZj.yZh));
                intent.putExtra("Select_block_List", a.c(this.yZj.yZh));
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("Select_Conv_Type", 3);
                this.yZj.yZh.startActivityForResult(intent, 1);
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                Intent intent2 = new Intent();
                intent2.putExtra("enterprise_biz_name", a.c(this.yZj.yZh));
                intent2.putExtra("enterprise_scene", 2);
                d.b(this.yZj.yZh.thisActivity(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2);
                break;
            case 5:
                intent = new Intent();
                intent.putExtra("Contact_User", a.c(this.yZj.yZh));
                d.b(this.yZj.yZh.thisActivity(), "profile", ".ui.ContactInfoUI", intent);
                i2 = 5;
                break;
        }
        g.df(a.c(this.yZj.yZh), i2);
    }
}
