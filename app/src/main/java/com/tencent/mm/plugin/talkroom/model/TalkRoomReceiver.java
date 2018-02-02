package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class TalkRoomReceiver extends BroadcastReceiver {
    protected static void init() {
        aa.a(new 1());
    }

    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:" + intent.getBooleanExtra("MMBoot_Bump", false));
        aB(context);
    }

    public static void aB(Context context) {
        long cfn = aa.cfn();
        x.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=" + cfn);
        if (cfn <= 600000) {
            if (cfn < 30000) {
                cfn = 30000;
            }
            x.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[]{Long.valueOf(cfn), Long.valueOf(SystemClock.elapsedRealtime())});
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
                return;
            }
            alarmManager.set(2, cfn + r4, PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    public static void aC(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
