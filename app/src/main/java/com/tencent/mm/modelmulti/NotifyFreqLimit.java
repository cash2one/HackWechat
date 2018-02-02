package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class NotifyFreqLimit extends BroadcastReceiver {
    private static long beginTime = 0;
    private static byte[] gSF = new byte[0];
    private static a hGa = null;
    private static n hGb = null;
    private static int hGc = 0;
    private static long[] hGd = null;
    private static LinkedList<Object> hGe = new LinkedList();
    private static int hGf = 0;
    private static Boolean hGg = null;
    private static Boolean hGh = null;
    private static long hGi = 0;
    private static PendingIntent hGj = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(Context context, Intent intent) {
        try {
            synchronized (gSF) {
                String ou;
                if (intent != null) {
                    if ("com.tencent.mm.NotifyFreqLimit.AlarmReceiver".equals(intent.getAction())) {
                        long Wp = bh.Wp() - intent.getLongExtra("hashCode", 0);
                        int intExtra = intent.getIntExtra("pid", 0);
                        long longExtra = intent.getLongExtra("delaySecond", 0) * 1000;
                        int myPid = Process.myPid();
                        long id = Thread.currentThread().getId();
                        x.i("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[]{Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(Wp), Long.valueOf(longExtra), hGj, hGa});
                        if (hGj == null) {
                            g.pQN.a(99, 156, 1, false);
                            x.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: SENDER NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[]{Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(Wp), Long.valueOf(longExtra), hGj, hGa});
                            return;
                        }
                        hGj = null;
                        if (myPid != intExtra) {
                            g.pQN.a(99, 159, 1, false);
                            x.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: DIFF PID alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[]{Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(Wp), Long.valueOf(longExtra), hGj, hGa});
                            return;
                        }
                        if (5 * longExtra < Wp || 180000 + longExtra < Wp) {
                            x.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: ALARM DELAY TOO MUCH alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[]{Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(Wp), Long.valueOf(longExtra), hGj, hGa});
                            hGh = Boolean.valueOf(false);
                            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("NOTIFY_FREQ_LIMIT_INFO", 0);
                            ou = bh.ou(sharedPreferences.getString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", ""));
                            Editor edit = sharedPreferences.edit();
                            edit.putString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", bh.Wp() + "," + ou);
                            edit.commit();
                            if (bh.ov(ou)) {
                                g.pQN.h(11098, new Object[]{Integer.valueOf(3103)});
                            }
                            x.i("MicroMsg.NotifyFreqLimit", "setAlarmFailed end isAlarmCanUse:%s shared_pref:%s", new Object[]{hGh, ou});
                        }
                        if (hGa == null) {
                            g.pQN.a(99, 157, 1, false);
                            x.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: FUNC NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[]{Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(Wp), Long.valueOf(longExtra), hGj, hGa});
                        }
                    }
                }
                String str = "MicroMsg.NotifyFreqLimit";
                ou = "AlarmReceiver onReceive intent:%s";
                Object[] objArr = new Object[1];
                objArr[0] = intent == null ? "intent is null" : intent.getAction();
                x.e(str, ou, objArr);
            }
        } catch (Throwable th) {
            hGj = null;
            g.pQN.a(99, 151, 1, false);
            x.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive e:%s", new Object[]{bh.i(th)});
        }
    }
}
