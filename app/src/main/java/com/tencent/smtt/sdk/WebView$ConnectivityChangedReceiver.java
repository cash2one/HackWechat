package com.tencent.smtt.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;

class WebView$ConnectivityChangedReceiver extends BroadcastReceiver {
    private WebView$ConnectivityChangedReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    int hL = b.hL(context);
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (QbSdk.zVT) {
                        if (QbSdk.zVR) {
                            QbSdk.sWifiConnectedTime += currentTimeMillis - QbSdk.zVS;
                        }
                        QbSdk.zVS = currentTimeMillis;
                    }
                    TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + hL);
                    QbSdk.zVR = hL == 3;
                }
            } catch (Throwable th) {
            }
        }
    }
}
