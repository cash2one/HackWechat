package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bg.update();
        if (this.mLastTime >= 0) {
            long j = elapsedRealtime - this.mLastTime;
            long cgk = bg.cgk() + bg.cgj();
            long cgi = bg.cgi() + bg.cgh();
            long cgo = bg.cgo() + bg.cgn();
            long cgo2 = bg.cgo() + bg.cgn();
            x.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", new Object[]{Long.valueOf(j), Long.valueOf(cgk), Long.valueOf(cgi), Double.valueOf(((double) (cgk + cgi)) / ((double) (j / 1000))), Long.valueOf(cgo), Long.valueOf(cgo2), Double.valueOf(((double) (cgo + cgo2)) / ((double) (j / 1000)))});
        }
        this.mLastTime = elapsedRealtime;
    }

    public static void aF(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
        x.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", new Object[]{Long.valueOf(300000)});
    }

    public static void aG(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
    }
}
