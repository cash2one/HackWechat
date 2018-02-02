package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.mm.g.a.do;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class ExdeviceWCLanSDKUtil$LanStateChangeReceiver extends BroadcastReceiver {
    final /* synthetic */ ExdeviceWCLanSDKUtil lML;

    public ExdeviceWCLanSDKUtil$LanStateChangeReceiver(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.lML = exdeviceWCLanSDKUtil;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =" + z);
                if (this.lML.lMI || this.lML.lMH != z) {
                    b doVar = new do();
                    doVar.fsk.fsl = z;
                    a.xef.m(doVar);
                    this.lML.lMI = false;
                    this.lML.lMH = z;
                }
            }
        }
    }
}
