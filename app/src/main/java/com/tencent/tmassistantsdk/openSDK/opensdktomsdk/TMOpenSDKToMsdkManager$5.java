package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;

class TMOpenSDKToMsdkManager$5 implements OnClickListener {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;

    TMOpenSDKToMsdkManager$5(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager) {
        this.this$0 = tMOpenSDKToMsdkManager;
    }

    public void onClick(View view) {
        if (this.this$0.dialog.isShowing()) {
            this.this$0.dialog.dismiss();
            this.this$0.mHttpRequest = null;
        }
        JceStruct createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
        createTipsInfoLog.cancelBtnClickCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        try {
            if (this.this$0.mClient != null) {
                this.this$0.pauseDownloadTask(this.this$0.mDownloadUrl);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("OpensdkToMsdkManager", e, "", new Object[0]);
        }
        if (this.this$0.authorizedState == 2) {
            this.this$0.notifyAuthorizedFinished(true, this.this$0.mAuthorizedInfo);
        } else {
            this.this$0.notifyAuthorizedFinished(false, this.this$0.mAuthorizedInfo);
        }
    }
}
