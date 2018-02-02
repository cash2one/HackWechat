package com.tencent.liteav.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;

class a$1 extends Handler {
    final /* synthetic */ a a;

    a$1(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (a.a(this.a) != null) {
            switch (message.what) {
                case 1:
                    a.a(this.a).a(((Long) message.obj).longValue());
                    return;
                case 2:
                    TXCLog.d("TXCStreamRecord", "record complete. errcode = " + message.arg1 + ", errmsg = " + ((String) message.obj) + ", outputPath = " + a.b(this.a).f + ", coverImage = " + a.b(this.a).g);
                    if (!(message.arg1 != 0 || a.b(this.a).g == null || a.b(this.a).g.isEmpty() || a.a(a.b(this.a).f, a.b(this.a).g))) {
                        TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.b(this.a).f + ", coverImagePath = " + a.b(this.a).g);
                    }
                    if (message.arg1 != 0) {
                        File file = new File(a.b(this.a).f);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    a.a(this.a).a(message.arg1, (String) message.obj, a.b(this.a).f, a.b(this.a).g);
                    return;
                default:
                    return;
            }
        }
    }
}
