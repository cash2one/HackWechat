package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sandbox.monitor.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ExceptionMonitorService extends Service {
    public static long hhB = 0;
    public static int xbT = 0;
    private static ExceptionMonitorService xbX = null;
    private long xbU = 300000;
    private af xbV = new af();
    private Runnable xbW = new 1(this);
    private long xbY;

    public void onCreate() {
        super.onCreate();
        xbX = this;
        c.h(hashCode(), this);
        this.xbV.postDelayed(this.xbW, this.xbU);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        k(intent);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        xbX = null;
        c.i(hashCode(), this);
        this.xbV.removeCallbacks(this.xbW);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.xbV.removeCallbacks(this.xbW);
            this.xbV.postDelayed(this.xbW, this.xbU);
            String action = intent.getAction();
            x.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + action);
            try {
                String stringExtra = intent.getStringExtra("tag");
                if (stringExtra == null) {
                    stringExtra = "exception";
                }
                int intExtra = intent.getIntExtra("exceptionPid", 0);
                stringExtra.equals("exception");
                xbT = intExtra;
                hhB = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
                String stringExtra2 = intent.getStringExtra("exceptionMsg");
                String stringExtra3 = intent.getStringExtra("userName");
                boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
                x.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
                if (!bh.ov(stringExtra2)) {
                    if (a.a(stringExtra3, stringExtra, new a(stringExtra3, stringExtra, bh.Wo(), stringExtra2, booleanExtra)) == 0) {
                        eD(this);
                    }
                    if (System.currentTimeMillis() - this.xbY > 600000) {
                        this.xbY = System.currentTimeMillis();
                        e.post(new 2(this), "RecoveryWriteLogThread");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CrashMonitorService", e, "", new Object[0]);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void eD(Context context) {
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, bh.Wp() + 1800000, broadcast);
            x.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[]{Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2)});
        }
    }
}
