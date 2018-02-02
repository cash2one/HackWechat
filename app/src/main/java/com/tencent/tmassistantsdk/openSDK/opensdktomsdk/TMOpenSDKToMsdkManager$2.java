package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Message;
import com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;

class TMOpenSDKToMsdkManager$2 implements IGetAuthorizedHttpRequestListenner {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;

    TMOpenSDKToMsdkManager$2(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager) {
        this.this$0 = tMOpenSDKToMsdkManager;
    }

    public void onGetAuthorizedRequestFinished(AuthorizedResult authorizedResult, int i) {
        Message message = new Message();
        if (i != 0) {
            message.what = 5;
            message.obj = Integer.valueOf(i);
        } else if (authorizedResult != null) {
            message.what = 4;
            message.obj = authorizedResult;
        } else {
            return;
        }
        this.this$0.mMainMessageHandler.sendMessage(message);
    }
}
