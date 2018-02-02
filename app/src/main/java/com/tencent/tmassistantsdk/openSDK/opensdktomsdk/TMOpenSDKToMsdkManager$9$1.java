package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.9;

class TMOpenSDKToMsdkManager$9$1 implements Runnable {
    final /* synthetic */ 9 this$1;
    final /* synthetic */ TMAssistantDownloadSDKClient val$client;
    final /* synthetic */ String val$url;

    TMOpenSDKToMsdkManager$9$1(9 9, TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str) {
        this.this$1 = 9;
        this.val$client = tMAssistantDownloadSDKClient;
        this.val$url = str;
    }

    public void run() {
        try {
            CharSequence charSequence = this.val$client.getDownloadTaskState(this.val$url).mSavePath;
            if (!TextUtils.isEmpty(charSequence)) {
                Message message = new Message();
                message.what = 0;
                message.obj = charSequence;
                this.this$1.this$0.mMainMessageHandler.sendMessage(message);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("OpensdkToMsdkManager", e, "", new Object[0]);
        }
    }
}
