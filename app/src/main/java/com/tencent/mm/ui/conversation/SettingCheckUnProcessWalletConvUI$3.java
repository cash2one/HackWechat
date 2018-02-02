package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.aj;

class SettingCheckUnProcessWalletConvUI$3 implements OnItemClickListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI zaj;

    SettingCheckUnProcessWalletConvUI$3(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.zaj = settingCheckUnProcessWalletConvUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        aj Gt = SettingCheckUnProcessWalletConvUI.b(this.zaj).Gt(i);
        if (Gt != null) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", Gt.field_username);
            intent.putExtra("chat_from_scene", 4);
            d.a(this.zaj, ".ui.chatting.ChattingUI", intent);
        }
    }
}
