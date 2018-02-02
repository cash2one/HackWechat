package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class MMReceivers$AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
            x.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:" + booleanExtra);
            if (booleanExtra) {
                aB(context);
            } else if (!b.q(context, "alarm")) {
                aE(context);
                x.cfk();
            }
        }
    }

    public static void aB(Context context) {
        long cfn = aa.cfn();
        x.d("MicroMsg.AlarmReceiver", "bumper comes, next=" + cfn);
        if (cfn <= 1860000) {
            if (cfn < 30000) {
                cfn = 30000;
            }
            x.w("MicroMsg.AlarmReceiver", "reset bumper, interval=" + cfn);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                return;
            }
            alarmManager.set(0, cfn + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 1, new Intent(context, MMReceivers$AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    public static void aC(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, MMReceivers$AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }

    public static void aD(Context context) {
        x.w("MicroMsg.AlarmReceiver", "keep awaker");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
            return;
        }
        int i = com.tencent.mm.network.aa.VL() ? 300000 : 900000;
        alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, MMReceivers$AlarmReceiver.class), SQLiteDatabase.CREATE_IF_NECESSARY));
    }

    public static void aE(Context context) {
        x.w("MicroMsg.AlarmReceiver", "stop awaker");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, MMReceivers$AlarmReceiver.class), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
