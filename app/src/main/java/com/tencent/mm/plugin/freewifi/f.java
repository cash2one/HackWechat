package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    private WifiManager bni = ((WifiManager) ac.getContext().getSystemService("wifi"));
    private Context context;
    Condition fcE = this.mBP.newCondition();
    Lock mBP = new ReentrantLock();
    private BroadcastReceiver mBS;
    private int mCc = 10;

    public f(Context context) {
        this.context = context;
    }

    public final int aKU() {
        if (3 == this.bni.getWifiState()) {
            return 0;
        }
        this.mBS = new BroadcastReceiver(this) {
            final /* synthetic */ f mCe;

            {
                this.mCe = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    x.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
                    if (intExtra == 3) {
                        try {
                            this.mCe.mBP.lock();
                            this.mCe.fcE.signalAll();
                        } finally {
                            this.mCe.aKS();
                            this.mCe.mBP.unlock();
                        }
                    }
                }
            }
        };
        try {
            this.mBP.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.mBS, intentFilter);
            this.bni.setWifiEnabled(true);
            if (this.fcE.await((long) this.mCc, TimeUnit.SECONDS)) {
                return 0;
            }
            aKS();
            this.mBP.unlock();
            return 1;
        } catch (InterruptedException e) {
            return 2;
        } finally {
            aKS();
            this.mBP.unlock();
        }
    }

    public final void aKS() {
        try {
            this.context.unregisterReceiver(this.mBS);
        } catch (IllegalArgumentException e) {
        }
    }
}
