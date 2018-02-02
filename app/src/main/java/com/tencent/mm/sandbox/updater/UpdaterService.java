package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class UpdaterService extends Service {
    private static UpdaterService xdM = null;
    static final long xdO = 1800000;
    private boolean hHG = false;
    Map<Integer, a> xdN = new HashMap();
    private ak xdP = new ak(new 1(this), true);
    private a xdQ = null;

    public static void cl() {
        x.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (xdM != null) {
            xdM.ceH();
        }
    }

    public static UpdaterService ceG() {
        return xdM;
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.UpdaterService", "onCreate");
        c.h(hashCode(), this);
        xdM = this;
        this.xdN.put(Integer.valueOf(0), a.xdL);
        this.xdN.put(Integer.valueOf(1), d.cep());
        this.xdN.put(Integer.valueOf(2), d.cep());
        this.xdN.put(Integer.valueOf(3), k.a.xdT);
        MMActivity.initLanguage(this);
        ak akVar = this.xdP;
        long j = xdO;
        akVar.J(j, j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.xdQ = new a();
        registerReceiver(this.xdQ, intentFilter);
    }

    public void onStart(Intent intent, int i) {
        x.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[]{intent});
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[]{intent});
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                x.i("MicroMsg.UpdaterService", "runServiceInForground");
                startForeground(0, new Builder(this).setTicker("updater service running forground").setWhen(System.currentTimeMillis()).setContentTitle("Updater Service").setContentText("updater service running forground").setContentIntent(PendingIntent.getService(this, 0, new Intent(), 0)).getNotification());
                this.hHG = true;
            } else if (VERSION.SDK_INT < 18 && !this.hHG) {
                startForeground(-1314, new Notification());
                this.hHG = true;
            }
        }
        k(intent);
        return 2;
    }

    public void onDestroy() {
        x.i("MicroMsg.UpdaterService", "onDestroy");
        this.xdP.TG();
        if (this.xdQ != null) {
            unregisterReceiver(this.xdQ);
        }
        if (this.hHG) {
            stopForeground(true);
        }
        for (a onDestroy : this.xdN.values()) {
            onDestroy.onDestroy();
        }
        this.xdN.clear();
        xdM = null;
        c.i(hashCode(), this);
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void k(Intent intent) {
        if (intent != null) {
            x.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[]{Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0))});
            a aVar = (a) this.xdN.get(Integer.valueOf(r0));
            if (aVar != null) {
                x.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[]{Boolean.valueOf(aVar.af(intent))});
                if (!aVar.af(intent)) {
                    ceH();
                }
            }
        }
    }

    private boolean ceH() {
        if (this.xdN.size() > 0) {
            for (a isBusy : this.xdN.values()) {
                if (isBusy.isBusy()) {
                    x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    return false;
                }
            }
        }
        x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        ag.h(new 2(this), 10000);
        return true;
    }
}
