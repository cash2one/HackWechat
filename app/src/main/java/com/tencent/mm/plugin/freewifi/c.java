package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public Activity activity;
    public WifiManager bni;
    public boolean connected = false;
    public Condition fcE;
    public long hnk;
    public Lock mBP;
    public BroadcastReceiver mBS;
    public boolean mBW = false;
    public String mBX;
    public String ssid;

    public c(String str, Activity activity, String str2) {
        this.activity = activity;
        this.hnk = 30000;
        this.ssid = str;
        this.mBX = str2;
        this.mBP = new ReentrantLock();
        this.fcE = this.mBP.newCondition();
        this.bni = (WifiManager) ac.getContext().getSystemService("wifi");
    }

    public final void aKS() {
        try {
            this.activity.unregisterReceiver(this.mBS);
        } catch (IllegalArgumentException e) {
        }
    }
}
