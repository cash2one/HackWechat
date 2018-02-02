package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.QbSdk.a;
import com.tencent.smtt.utils.TbsLog;

class QbSdk$2 extends Handler {
    final /* synthetic */ Context val$context;
    final /* synthetic */ a zWj;

    QbSdk$2(Looper looper, a aVar, Context context) {
        this.zWj = aVar;
        this.val$context = context;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ag cFi = af.cFg().cFi();
                if (cFi != null) {
                    cFi.hD(this.val$context);
                }
                if (this.zWj != null) {
                    this.zWj.kQ(true);
                }
                TbsLog.writeLogToDisk();
                return;
            case 2:
                if (this.zWj != null) {
                    this.zWj.kQ(false);
                }
                TbsLog.writeLogToDisk();
                return;
            case 3:
                if (this.zWj != null) {
                    this.zWj.tH();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
