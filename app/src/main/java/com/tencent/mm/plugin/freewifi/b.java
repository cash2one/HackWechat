package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    private WifiManager bni;
    private Context context;
    Condition fcE;
    private long hnk = 15000;
    Lock mBP;
    boolean mBQ = false;
    boolean mBR = false;
    private BroadcastReceiver mBS;
    String ssid;

    public b(String str, Context context) {
        this.ssid = str;
        this.mBP = new ReentrantLock();
        this.fcE = this.mBP.newCondition();
        this.bni = (WifiManager) context.getSystemService("wifi");
        this.context = context;
    }

    public final int aKT() {
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.aLG())) {
            return 0;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        }
        this.mBS = new 1(this);
        try {
            int aKU;
            this.mBP.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.context.registerReceiver(this.mBS, intentFilter);
            if (!this.bni.isWifiEnabled()) {
                aKU = new f(this.context).aKU();
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + aKU);
                if (aKU != 0) {
                    return aKU;
                }
            }
            aKU = d.AK(this.ssid);
            if (aKU != 0) {
                aKS();
                aKS();
                this.mBP.unlock();
                return aKU;
            }
            boolean z = false;
            while (true) {
                if (!this.mBQ || !this.mBR) {
                    long currentTimeMillis = System.currentTimeMillis();
                    z = this.fcE.await(this.hnk, TimeUnit.MILLISECONDS);
                    if (!z) {
                        break;
                    }
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    this.hnk -= currentTimeMillis;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.hnk);
                    this.hnk = this.hnk > 0 ? this.hnk : 3000;
                } else {
                    break;
                }
            }
            if (!z) {
                return -16;
            }
            aKS();
            this.mBP.unlock();
            return 0;
        } catch (InterruptedException e) {
            x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{e.getMessage()});
            return -17;
        } finally {
            aKS();
            this.mBP.unlock();
        }
    }

    private void aKS() {
        try {
            this.context.unregisterReceiver(this.mBS);
        } catch (IllegalArgumentException e) {
        }
    }
}
