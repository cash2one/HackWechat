package com.tencent.pb.common.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.e.a.a;
import com.tencent.e.f;
import com.tencent.pb.common.b.g;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.c;

public class ConnectReceiver extends BroadcastReceiver {
    private static g zQg = null;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (zQg == null) {
                        zQg = new g();
                    }
                    boolean isNetworkConnected = h.isNetworkConnected();
                    a aVar = (a) f.abQ("EventCenter");
                    if (zQg.wE() && aVar != null) {
                        if (isNetworkConnected) {
                            aVar.c("GLOBAL_TOPIC_NETWORK_CHANGE", 21, null);
                        } else {
                            aVar.c("GLOBAL_TOPIC_NETWORK_CHANGE", 33, null);
                        }
                    }
                }
            } catch (Throwable th) {
                c.m("ConnectReceiver", "onReceive", th);
            }
        }
    }
}
