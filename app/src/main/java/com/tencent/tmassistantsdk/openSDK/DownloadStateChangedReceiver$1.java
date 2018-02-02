package com.tencent.tmassistantsdk.openSDK;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;

class DownloadStateChangedReceiver$1 implements Runnable {
    final /* synthetic */ DownloadStateChangedReceiver this$0;
    final /* synthetic */ Intent val$intent;

    DownloadStateChangedReceiver$1(DownloadStateChangedReceiver downloadStateChangedReceiver, Intent intent) {
        this.this$0 = downloadStateChangedReceiver;
        this.val$intent = intent;
    }

    public void run() {
        TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
        tMQQDownloaderStateChangeParam.hostPackageName = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_PAGECKAGENAME);
        tMQQDownloaderStateChangeParam.hostVersion = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_VERSION);
        tMQQDownloaderStateChangeParam.taskId = this.val$intent.getStringExtra("taskId");
        tMQQDownloaderStateChangeParam.errorCode = bh.getInt(this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE), 0);
        tMQQDownloaderStateChangeParam.errorMsg = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
        tMQQDownloaderStateChangeParam.state = bh.getInt(this.val$intent.getStringExtra("state"), 0);
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
        tMQQDownloaderOpenSDKParam.SNGAppId = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_SNGAPPID);
        tMQQDownloaderOpenSDKParam.taskAppId = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
        tMQQDownloaderOpenSDKParam.taskApkId = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
        tMQQDownloaderOpenSDKParam.taskPackageName = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
        tMQQDownloaderOpenSDKParam.taskVersion = bh.getInt(this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_VERSION), 0);
        tMQQDownloaderOpenSDKParam.via = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_VIA);
        tMQQDownloaderOpenSDKParam.uin = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UIN);
        tMQQDownloaderOpenSDKParam.uinType = this.val$intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UINTYPE);
        tMQQDownloaderStateChangeParam.param = tMQQDownloaderOpenSDKParam;
        Iterator it = this.this$0.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadStateChangedListener) it.next()).onDownloadStateChanged(tMQQDownloaderStateChangeParam);
        }
    }
}
