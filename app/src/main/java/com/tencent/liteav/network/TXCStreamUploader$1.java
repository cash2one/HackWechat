package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCStreamUploader$1 extends Handler {
    final /* synthetic */ TXCStreamUploader a;

    TXCStreamUploader$1(TXCStreamUploader tXCStreamUploader, Looper looper) {
        this.a = tXCStreamUploader;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 101:
                TXCStreamUploader.access$000(this.a, (String) message.obj, message.arg1 == 2, 0);
                return;
            case 103:
                TXCStreamUploader.access$100(this.a);
                return;
            default:
                return;
        }
    }
}
