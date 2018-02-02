package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.util.TMLog;

class TMOpenSDKToMsdkManager$8 implements Runnable {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;
    final /* synthetic */ String val$downloadUrl;

    TMOpenSDKToMsdkManager$8(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager, String str) {
        this.this$0 = tMOpenSDKToMsdkManager;
        this.val$downloadUrl = str;
    }

    public void run() {
        TMAssistantDownloadSDKClient client = this.this$0.getClient();
        try {
            if (client.getDownloadTaskState(this.val$downloadUrl) != null) {
                client.pauseDownloadTask(this.val$downloadUrl);
            } else {
                TMLog.i("OpensdkToMsdkManager", "getDownloadTaskState taskinfo is null!");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("OpensdkToMsdkManager", e, "", new Object[0]);
        }
    }
}
