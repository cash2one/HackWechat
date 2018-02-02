package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e {
    private Activity activity;
    private WifiManager bni = ((WifiManager) ac.getContext().getSystemService("wifi"));
    Condition fcE = this.mBP.newCondition();
    Lock mBP = new ReentrantLock();
    private BroadcastReceiver mBS;
    private int mCc = 10;

    public e(Activity activity) {
        this.activity = activity;
    }

    public final int aKU() {
        if (3 == this.bni.getWifiState()) {
            return 0;
        }
        this.mBS = new 1(this);
        try {
            this.mBP.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.activity.registerReceiver(this.mBS, intentFilter);
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
            this.activity.unregisterReceiver(this.mBS);
        } catch (IllegalArgumentException e) {
        }
    }
}
