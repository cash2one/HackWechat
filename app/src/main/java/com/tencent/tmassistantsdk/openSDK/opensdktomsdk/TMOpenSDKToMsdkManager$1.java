package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;

class TMOpenSDKToMsdkManager$1 implements a {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;

    TMOpenSDKToMsdkManager$1(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager) {
        this.this$0 = tMOpenSDKToMsdkManager;
    }

    public boolean handleMessage(Message message) {
        Bundle data;
        switch (message.what) {
            case 0:
                int i = message.arg1;
                this.this$0.handleInstall(message.obj.toString(), i);
                break;
            case 1:
                data = message.getData();
                if (data != null) {
                    this.this$0.handleDownloading(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                    break;
                }
                break;
            case 3:
                this.this$0.handleDownloadFailed();
                break;
            case 4:
                AuthorizedResult authorizedResult = (AuthorizedResult) message.obj;
                if (authorizedResult != null) {
                    this.this$0.onNetworkFinishedSuccess(authorizedResult);
                    break;
                }
                break;
            case 5:
                this.this$0.onNetworkFinishedFailed(((Integer) message.obj).intValue());
                break;
            case 6:
                data = message.getData();
                if (data != null) {
                    this.this$0.handleDownloadContinue(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                    break;
                }
                break;
        }
        return false;
    }
}
