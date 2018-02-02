package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public final class m {
    private static BroadcastReceiver mBS = null;
    private static int xeG = 0;
    private static int xeH = -1;

    public static boolean eJ(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Throwable e) {
            x.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", bh.i(e));
            return false;
        }
    }

    public static synchronized boolean eK(Context context) {
        boolean z = false;
        synchronized (m.class) {
            if (mBS == null) {
                mBS = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            try {
                                m.xeH = intent.getIntExtra(DownloadInfo.STATUS, -1);
                                m.xeG = intent.getIntExtra("plugged", 0);
                            } catch (Throwable th) {
                            }
                            x.i("MicroMsg.GreenManUtil", "isCharging BroadcastReceiver thread:%d status:%d plugged:%d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(m.xeH), Integer.valueOf(m.xeG));
                        }
                    }
                };
                try {
                    Intent registerReceiver = context.registerReceiver(mBS, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    xeH = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                    xeG = registerReceiver.getIntExtra("plugged", 0);
                } catch (Throwable th) {
                }
            }
            if (xeH == 2 || xeG == 1 || xeG == 2 || (VERSION.SDK_INT >= 17 && xeG == 4)) {
                z = true;
            }
        }
        return z;
    }

    public static boolean df(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                return true;
            }
        }
        return false;
    }

    public static String by(Context context) {
        if (!df(context)) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT < 23) {
                return ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            }
            List appTasks = activityManager.getAppTasks();
            if (appTasks == null || appTasks.size() <= 0) {
                return "";
            }
            Iterator it = appTasks.iterator();
            if (it.hasNext()) {
                ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                if (componentName == null) {
                    return null;
                }
                return componentName.getClassName();
            }
            return "";
        } catch (Throwable e) {
            x.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bh.i(e));
        }
    }
}
