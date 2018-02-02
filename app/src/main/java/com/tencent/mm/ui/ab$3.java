package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;

class ab$3 implements Runnable {
    final /* synthetic */ ab xMg;

    ab$3(ab abVar) {
        this.xMg = abVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ab.c(this.xMg).sendBroadcast(intent);
    }
}
