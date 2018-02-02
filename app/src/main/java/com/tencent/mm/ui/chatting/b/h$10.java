package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.chatting.ChattingUI;

class h$10 implements OnClickListener {
    final /* synthetic */ ChattingUI yzI;

    public h$10(ChattingUI chattingUI) {
        this.yzI = chattingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yzI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
