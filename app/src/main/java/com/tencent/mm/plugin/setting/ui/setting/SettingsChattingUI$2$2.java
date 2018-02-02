package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2;
import java.util.ArrayList;

class SettingsChattingUI$2$2 implements OnClickListener {
    final /* synthetic */ 2 qjj;
    final /* synthetic */ ArrayList qjk;

    SettingsChattingUI$2$2(2 2, ArrayList arrayList) {
        this.qjj = 2;
        this.qjk = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, Integer.valueOf(5), Integer.valueOf(4), "");
        SettingsChattingUI.a(this.qjj.qji, true);
        if (this.qjk.size() <= 1) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", (String) this.qjk.get(0));
            intent.addFlags(67108864);
            d.a(this.qjj.qji, ".ui.chatting.ChattingUI", intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putStringArrayListExtra("key_conversation_list", this.qjk);
        d.a(this.qjj.qji, ".ui.conversation.SettingCheckUnProcessWalletConvUI", intent2);
    }
}
