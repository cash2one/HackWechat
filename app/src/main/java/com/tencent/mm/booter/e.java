package com.tencent.mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    NetworkInfo gyh = null;
    WifiInfo gyi = null;

    final boolean wE() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                x.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.gyh = null;
                this.gyi = null;
                return false;
            }
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                x.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                x.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.gyh = null;
                this.gyi = null;
                return false;
            }
            WifiInfo connectionInfo;
            int i = activeNetworkInfo.getType() == 1 ? 1 : 0;
            if (i != 0) {
                connectionInfo = ((WifiManager) aa.getContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && this.gyi != null && this.gyi.getBSSID().equals(connectionInfo.getBSSID()) && this.gyi.getSSID().equals(connectionInfo.getSSID()) && this.gyi.getNetworkId() == connectionInfo.getNetworkId()) {
                    x.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                    return false;
                }
                x.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s", connectionInfo);
                x.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s", this.gyi);
            } else if (this.gyh != null && this.gyh.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.gyh.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.gyh.getSubtype() == activeNetworkInfo.getSubtype() && this.gyh.getType() == activeNetworkInfo.getType()) {
                x.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else if (this.gyh != null && this.gyh.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.gyh.getSubtype() == activeNetworkInfo.getSubtype() && this.gyh.getType() == activeNetworkInfo.getType()) {
                x.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else {
                connectionInfo = null;
            }
            if (i == 0) {
                x.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", activeNetworkInfo);
                if (this.gyh != null) {
                    x.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.gyh);
                }
            }
            this.gyh = activeNetworkInfo;
            this.gyi = connectionInfo;
            return true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NetworkChangeMgr", e2, "", new Object[0]);
        }
    }
}
