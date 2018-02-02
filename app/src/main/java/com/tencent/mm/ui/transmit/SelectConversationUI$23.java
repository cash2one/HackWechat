package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SelectConversationUI$23 implements a {
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$23(SelectConversationUI selectConversationUI, Intent intent) {
        this.zpv = selectConversationUI;
        this.val$intent = intent;
    }

    public final void a(boolean z, String str, int i) {
        this.zpv.aWs();
        boolean booleanExtra = this.val$intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
        if (booleanExtra) {
            int i2 = z ? 1 : 0;
            x.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[]{Integer.valueOf(13943), Integer.valueOf(i2)});
            g.pQN.h(13943, new Object[]{Integer.valueOf(i2)});
        }
        if (z) {
            this.val$intent.putExtra("custom_send_text", str);
            SelectConversationUI.a(this.zpv, this.val$intent);
            this.zpv.finish();
        } else if (booleanExtra) {
            String stringExtra = this.val$intent.getStringExtra("Select_Contact");
            ar.Hg();
            c.Fd().WX(stringExtra);
        }
    }
}
