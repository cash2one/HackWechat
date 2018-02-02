package com.tencent.liteav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.a.b;
import com.tencent.liteav.basic.log.TXCLog;

class a$a extends Handler {
    final /* synthetic */ a a;
    private int b = 300;
    private long c = 0;

    public a$a(a aVar, Looper looper, int i, long j) {
        this.a = aVar;
        super(looper);
        this.b = i;
        this.c = j;
    }

    public void handleMessage(Message message) {
        if (message.what == 1001) {
            try {
                a.a(this.a);
                if (System.currentTimeMillis() < this.c) {
                    sendEmptyMessageDelayed(1001, (long) this.b);
                    return;
                }
                TXCLog.w(a.c(), "bkgpush:stop background publish when timeout");
                if (a.b(this.a) != null && a.c(this.a)) {
                    b bVar = (b) a.b(this.a).get();
                    if (bVar != null) {
                        bVar.a();
                    }
                    a.a(this.a, false);
                }
            } catch (Exception e) {
            }
        }
    }
}
