package com.tencent.liteav.screencapture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class b$4 extends BroadcastReceiver {
    final /* synthetic */ b a;

    b$4(b bVar) {
        this.a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equalsIgnoreCase("TXScreenCapture.OnAssistantActivityResult")) {
            b.a(this.a, intent.getIntExtra("TXScreenCapture.RequestCode", 0), intent.getIntExtra("TXScreenCapture.ResultCode", 0), (Intent) intent.getParcelableExtra("TXScreenCapture.ResultData"));
        }
    }
}
