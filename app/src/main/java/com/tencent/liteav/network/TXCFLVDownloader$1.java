package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCFLVDownloader$1 extends Handler {
    final /* synthetic */ TXCFLVDownloader a;

    TXCFLVDownloader$1(TXCFLVDownloader tXCFLVDownloader, Looper looper) {
        this.a = tXCFLVDownloader;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                TXCFLVDownloader.access$000(this.a);
                return;
            case 101:
                TXCFLVDownloader.access$100(this.a);
                return;
            case 102:
                TXCFLVDownloader.access$200(this.a);
                return;
            case 103:
                TXCFLVDownloader.access$300(this.a);
                return;
            case 106:
                try {
                    Looper.myLooper().quit();
                    return;
                } catch (Exception e) {
                    return;
                }
            default:
                return;
        }
    }
}
