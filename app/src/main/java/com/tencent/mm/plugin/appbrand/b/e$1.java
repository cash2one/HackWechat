package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

class e$1 extends BroadcastReceiver {
    final /* synthetic */ e iHq;

    e$1(e eVar) {
        this.iHq = eVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            c.Dm().F(new Runnable(this) {
                final /* synthetic */ e$1 iHr;

                {
                    this.iHr = r1;
                }

                public final void run() {
                    e eVar = this.iHr.iHq;
                    Activity activity = (Activity) eVar.iHl.get();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                        RunningTaskInfo ah = bh.ah(activity, activity.getTaskId());
                        if (ah != null) {
                            try {
                                ComponentName componentName = ah.topActivity;
                                if (componentName != null && activityManager != null && packageManager != null) {
                                    ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
                                    if (activityInfo != null) {
                                        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                            if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 150) && ((componentName.equals(runningAppProcessInfo.importanceReasonComponent) || runningAppProcessInfo.importanceReasonCode == 0) && runningAppProcessInfo.processName.equals(activityInfo.processName))) {
                                                eVar.aax();
                                                return;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = " + e);
                            }
                        }
                    }
                }
            });
        }
    }
}
