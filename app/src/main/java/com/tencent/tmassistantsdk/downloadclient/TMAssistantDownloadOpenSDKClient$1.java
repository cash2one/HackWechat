package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.a.a.a.b.a;
import com.tencent.tmassistantsdk.util.TMLog;

class TMAssistantDownloadOpenSDKClient$1 extends a {
    final /* synthetic */ TMAssistantDownloadOpenSDKClient this$0;

    TMAssistantDownloadOpenSDKClient$1(TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient) {
        this.this$0 = tMAssistantDownloadOpenSDKClient;
    }

    public void onActionResult(byte[] bArr) {
        TMLog.i("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + bArr + "  mListeners.size:" + this.this$0.mListeners.size());
        TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(bArr, this.this$0.mListeners);
    }
}
