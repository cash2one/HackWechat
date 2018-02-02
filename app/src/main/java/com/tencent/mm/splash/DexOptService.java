package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.tencent.mm.f.a;
import java.io.File;

public class DexOptService extends Service {
    private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");
    private Handler xlq;
    private volatile boolean xlr = false;
    private Handler xls = new Handler(this) {
        final /* synthetic */ DexOptService xlu;

        {
            this.xlu = r1;
        }

        public final void handleMessage(Message message) {
            e.a("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
            this.xlu.stopSelf();
        }
    };
    private volatile Throwable xlt;

    static /* synthetic */ void aOF() {
        File file = new File(a.chh());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.getName().startsWith("DexOpt_Request")) {
                    e.a("WxSplash.DexOptService", "remove temp file %s result %s", file2, Boolean.valueOf(file2.delete()));
                    if (!file2.delete()) {
                        throw new RuntimeException("remove temp file failed");
                    }
                }
            }
            e.a("WxSplash.DexOptService", "removeDexOptTempFiles", new Object[0]);
        }
    }

    static /* synthetic */ void akq() {
        File file = new File(a.chh() + "/DexOpt_Failed");
        if (file.exists()) {
            boolean delete = file.delete();
            e.a("WxSplash.DexOptService", "remove failed file %s result %s", file, Boolean.valueOf(delete));
        }
        e.a("WxSplash.DexOptService", "removeFailedFile", new Object[0]);
    }

    static /* synthetic */ void c(DexOptService dexOptService) {
        if (dexOptService.xlt != null) {
            throw new RuntimeException(dexOptService.xlt);
        }
    }

    static /* synthetic */ void uj() {
        String chh = a.chh();
        File file = new File(chh);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(chh + "/DexOpt_Failed");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            e.a("WxSplash.DexOptService", "addFailedFile", new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void onCreate() {
        e.a("WxSplash.DexOptService", "onCreate", new Object[0]);
        super.onCreate();
        this.mHandlerThread.start();
        this.xlq = new Handler(this, this.mHandlerThread.getLooper()) {
            final /* synthetic */ DexOptService xlu;

            public final void handleMessage(Message message) {
                if (this.xlu.xlr) {
                    e.a("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
                    return;
                }
                this.xlu.xlr = true;
                if (this.xlu.chn()) {
                    DexOptService.akq();
                } else {
                    DexOptService.uj();
                    DexOptService.c(this.xlu);
                }
                DexOptService.aOF();
                this.xlu.xlr = false;
            }
        };
    }

    private boolean chn() {
        boolean ay;
        e.a("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
        try {
            ay = a.ay(getApplicationContext());
        } catch (Throwable th) {
            this.xlt = th;
            ay = false;
        }
        e.a("WxSplash.DexOptService", "schedule to quit", new Object[0]);
        this.xls.removeCallbacksAndMessages(null);
        this.xls.sendEmptyMessageDelayed(0, 120000);
        e.a("WxSplash.DexOptService", "doDexOpt done, result %s", Boolean.valueOf(ay));
        return ay;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.xlq.sendEmptyMessage(0);
        e.a("WxSplash.DexOptService", "onStartCommand", new Object[0]);
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        e.a("WxSplash.DexOptService", "onBind", new Object[0]);
        return null;
    }

    public void onDestroy() {
        e.a("WxSplash.DexOptService", "onDestroy", new Object[0]);
        super.onDestroy();
    }
}
