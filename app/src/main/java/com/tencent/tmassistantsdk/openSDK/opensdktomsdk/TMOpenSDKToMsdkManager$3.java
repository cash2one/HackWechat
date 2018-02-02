package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Bundle;
import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;

class TMOpenSDKToMsdkManager$3 implements Runnable {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;

    TMOpenSDKToMsdkManager$3(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager) {
        this.this$0 = tMOpenSDKToMsdkManager;
    }

    public void run() {
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = this.this$0.getClient().getDownloadTaskState(this.this$0.mDownloadUrl);
            if (downloadTaskState != null) {
                Message message;
                if (downloadTaskState.mState == 3) {
                    message = new Message();
                    message.what = 6;
                    Bundle bundle = new Bundle();
                    bundle.putLong("receiveDataLen", downloadTaskState.mReceiveDataLen);
                    bundle.putLong("totalDataLen", downloadTaskState.mTotalDataLen);
                    message.setData(bundle);
                    this.this$0.mMainMessageHandler.sendMessage(message);
                } else if (downloadTaskState.mState == 4) {
                    message = new Message();
                    message.what = 0;
                    message.arg1 = 1;
                    message.obj = downloadTaskState.mSavePath;
                    this.this$0.mMainMessageHandler.sendMessage(message);
                }
            }
            JceStruct createTipsInfoLog;
            if (downloadTaskState == null || downloadTaskState.mState != 4) {
                createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
                createTipsInfoLog.downloadTipsCount++;
                TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                return;
            }
            createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
            createTipsInfoLog.installTipsCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        } catch (Throwable e) {
            x.printErrStackTrace("OpensdkToMsdkManager", e, "", new Object[0]);
        }
    }
}
