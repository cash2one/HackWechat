package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;

class TMOpenSDKToMsdkManager$6 implements OnClickListener {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;

    TMOpenSDKToMsdkManager$6(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager) {
        this.this$0 = tMOpenSDKToMsdkManager;
    }

    public void onClick(View view) {
        if (this.this$0.mContext != null) {
            ActionButton actionButton = (ActionButton) view.getTag();
            try {
                switch (this.this$0.mOpenSDK.checkQQDownloaderInstalled(this.this$0.mSupportVersionCode)) {
                    case 0:
                        try {
                            this.this$0.startToQQDownloaderAuthorized(actionButton.jumpUrl);
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("OpensdkToMsdkManager", e, "", new Object[0]);
                            return;
                        }
                    case 1:
                        this.this$0.startDownloadTask(this.this$0.mDownloadUrl, actionButton.jumpUrl);
                        return;
                    case 2:
                        this.this$0.startDownloadTask(this.this$0.mDownloadUrl, actionButton.jumpUrl);
                        return;
                    default:
                        return;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("OpensdkToMsdkManager", e2, "", new Object[0]);
            }
            x.printErrStackTrace("OpensdkToMsdkManager", e2, "", new Object[0]);
        }
    }
}
