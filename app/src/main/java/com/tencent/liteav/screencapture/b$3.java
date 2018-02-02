package com.tencent.liteav.screencapture;

import android.os.Bundle;
import com.tencent.liteav.basic.c.a;
import com.tencent.rtmp.TXLiveConstants;

class b$3 implements Runnable {
    final /* synthetic */ b a;

    b$3(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (b.d(this.a) != null) {
            a aVar = (a) b.d(this.a).get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "录屏启动成功");
                aVar.onNotifyEvent(1004, bundle);
            }
        }
    }
}
