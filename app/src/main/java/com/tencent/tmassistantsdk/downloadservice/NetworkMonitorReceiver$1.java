package com.tencent.tmassistantsdk.downloadservice;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class NetworkMonitorReceiver$1 extends af {
    final /* synthetic */ NetworkMonitorReceiver this$0;

    NetworkMonitorReceiver$1(NetworkMonitorReceiver networkMonitorReceiver) {
        this.this$0 = networkMonitorReceiver;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 67:
                this.this$0.notifyNetworkChanged();
                return;
            default:
                return;
        }
    }
}
