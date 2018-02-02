package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    Activity activity;
    private WifiManager bni;
    Condition fcE;
    private long hnk;
    Lock mBP;
    boolean mBQ = false;
    boolean mBR = false;
    private BroadcastReceiver mBS;
    String ssid;

    public a(String str, Activity activity) {
        this.activity = activity;
        this.hnk = 15000;
        this.ssid = str;
        this.mBP = new ReentrantLock();
        this.fcE = this.mBP.newCondition();
        this.bni = (WifiManager) ac.getContext().getSystemService("wifi");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a aVar) {
        a 1 = new 1(this, aVar);
        if (((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.aLG())) {
            1.onSuccess();
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        } else {
            this.mBS = new 2(this);
            try {
                int aKU;
                this.mBP.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.activity.registerReceiver(this.mBS, intentFilter);
                if (!this.bni.isWifiEnabled()) {
                    aKU = new e(this.activity).aKU();
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + aKU);
                    if (aKU != 0) {
                        1.pQ(aKU);
                        aKS();
                        this.mBP.unlock();
                        return;
                    }
                }
                aKU = d.AK(this.ssid);
                if (aKU != 0) {
                    aKS();
                    1.pQ(aKU);
                    aKS();
                    this.mBP.unlock();
                    return;
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
                if (z) {
                    1.onSuccess();
                } else {
                    1.pQ(-16);
                }
                aKS();
                this.mBP.unlock();
            } catch (InterruptedException e) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{m.D(this.activity.getIntent()), Integer.valueOf(m.E(this.activity.getIntent())), e.getMessage()});
                1.pQ(-17);
            } catch (Throwable th) {
                aKS();
                this.mBP.unlock();
            }
        }
    }

    private void aKS() {
        try {
            this.activity.unregisterReceiver(this.mBS);
        } catch (IllegalArgumentException e) {
        }
    }
}
