package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCRTMPDownloader$1 extends Handler {
    final /* synthetic */ TXCRTMPDownloader a;

    TXCRTMPDownloader$1(TXCRTMPDownloader tXCRTMPDownloader, Looper looper) {
        this.a = tXCRTMPDownloader;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 101) {
            TXCRTMPDownloader.access$500(this.a);
        }
    }
}
