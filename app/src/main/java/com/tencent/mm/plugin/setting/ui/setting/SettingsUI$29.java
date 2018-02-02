package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.ui.e.h;

class SettingsUI$29 implements Runnable {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$29(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        this.qlF.sendBroadcast(intent);
    }
}
