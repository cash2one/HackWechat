package com.tencent.mm.ui.chatting;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.e.h;

class ChattingUI$a$25 implements Runnable {
    final /* synthetic */ a ywR;

    ChattingUI$a$25(a aVar) {
        this.ywR = aVar;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI", "now try to activity the tools process");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        this.ywR.sendBroadcast(intent);
    }
}
