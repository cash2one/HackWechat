package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;

class h$6 implements Runnable {
    final /* synthetic */ h xFs;

    h$6(h hVar) {
        this.xFs = hVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        this.xFs.sendBroadcast(intent);
    }
}
