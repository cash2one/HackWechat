package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class g {
    private NetworkInfo gyh = null;
    private WifiInfo gyi = null;
    private int zMz = 1;

    public final synchronized boolean wE() {
        boolean z;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) d.ssG.getSystemService("connectivity");
                if (connectivityManager == null) {
                    c.m("NetworkChangeMgr", new Object[]{"can't get ConnectivityManager"});
                    this.zMz = 1;
                    this.gyi = null;
                    this.gyh = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.zMz = 1;
                        this.gyi = null;
                        this.gyh = null;
                        z = true;
                    } else {
                        int i;
                        c.d("NetworkChangeMgr", new Object[]{"NetworkChangeMgr ", activeNetworkInfo});
                        if (!activeNetworkInfo.isConnected()) {
                            i = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            wifiInfo = ((WifiManager) d.ssG.getSystemService("wifi")).getConnectionInfo();
                            i = 2;
                        } else {
                            i = 3;
                        }
                        if (i == this.zMz) {
                            if (i == 1) {
                                z = false;
                            } else if (i == 2) {
                                if (wifiInfo != null && this.gyi != null && this.gyi.getBSSID().equals(wifiInfo.getBSSID()) && this.gyi.getSSID().equals(wifiInfo.getSSID()) && this.gyi.getNetworkId() == wifiInfo.getNetworkId()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (this.gyh != null && this.gyh.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.gyh.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.gyh.getSubtype() == activeNetworkInfo.getSubtype() && this.gyh.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.gyh != null && this.gyh.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.gyh.getSubtype() == activeNetworkInfo.getSubtype() && this.gyh.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.zMz = i;
                            this.gyi = wifiInfo;
                            this.gyh = activeNetworkInfo;
                        }
                        z = true;
                        this.zMz = i;
                        this.gyi = wifiInfo;
                        this.gyh = activeNetworkInfo;
                    }
                }
            } catch (Exception e) {
                c.m("NetworkChangeMgr", new Object[]{e});
                this.zMz = 1;
                this.gyi = null;
                this.gyh = null;
                z = true;
            }
        }
        return z;
    }
}
