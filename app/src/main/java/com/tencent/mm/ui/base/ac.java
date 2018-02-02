package com.tencent.mm.ui.base;

import android.content.Intent;
import android.os.Process;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;

public final class ac {
    public static void a(boolean z, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setAction(z ? "com.tencent.mm.ui.ACTION_ACTIVE" : "com.tencent.mm.ui.ACTION_DEACTIVE");
        intent.putExtra("_application_context_process_", com.tencent.mm.sdk.platformtools.ac.Br());
        intent.putExtra("process_id", Process.myPid());
        intent.putExtra("process_is_mm", com.tencent.mm.sdk.platformtools.ac.cfw());
        com.tencent.mm.sdk.platformtools.ac.getContext().sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}
