package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

public class CrashUploadAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
        if (a.cef() == 0) {
            ExceptionMonitorService.eD(context);
        }
    }
}
