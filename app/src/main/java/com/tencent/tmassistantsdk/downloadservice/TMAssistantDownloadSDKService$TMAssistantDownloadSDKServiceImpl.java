package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.Map;

protected class TMAssistantDownloadSDKService$TMAssistantDownloadSDKServiceImpl extends Stub {
    final /* synthetic */ TMAssistantDownloadSDKService this$0;

    protected TMAssistantDownloadSDKService$TMAssistantDownloadSDKServiceImpl(TMAssistantDownloadSDKService tMAssistantDownloadSDKService) {
        this.this$0 = tMAssistantDownloadSDKService;
    }

    public int getServiceVersion() {
        return 1;
    }

    public void setServiceSetingIsTaskAutoResume(boolean z) {
        DownloadSetting.getInstance().setIsTaskAutoResume(z);
    }

    public void setServiceSetingIsDownloadWifiOnly(boolean z) {
        DownloadSetting.getInstance().setIsDownloadWifiOnly(z);
    }

    public void setServiceSetingMaxTaskNum(int i) {
        DownloadSetting.getInstance().setMaxTaskNum(i);
    }

    public boolean isAllDownloadFinished() {
        return ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
        TMLog.i("TMAssistantDownloadSDKService", "getDownloadTaskInfo");
        if (this.this$0.mServiceDownloadTaskManager != null) {
            return this.this$0.mServiceDownloadTaskManager.getDownloadTaskInfo(str, str2);
        }
        return null;
    }

    public int startDownloadTask(String str, String str2, String str3, long j, int i, String str4, String str5, Map map) {
        TMLog.i("TMAssistantDownloadSDKService", "startDownloadTask，clientkey:" + str + ",url:" + str2 + ",manager:" + this.this$0.mServiceDownloadTaskManager + ",fileName:" + str5);
        if (this.this$0.mServiceDownloadTaskManager == null) {
            return 3;
        }
        DBManager.getInstance().saveClientInfo(str, str2);
        return this.this$0.mServiceDownloadTaskManager.startDownload(str, str2, str3, j, i, str4, str5, map);
    }

    public void pauseDownloadTask(String str, String str2) {
        TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask");
        try {
            if (this.this$0.mServiceDownloadTaskManager != null) {
                this.this$0.mServiceDownloadTaskManager.pauseDownload(str, str2);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("TMAssistantDownloadSDKService", e, "", new Object[0]);
        }
        TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask end");
    }

    public void cancelDownloadTask(String str, String str2) {
        if (this.this$0.mServiceDownloadTaskManager != null) {
            this.this$0.mServiceDownloadTaskManager.cancelDownload(str, str2);
        }
    }

    public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
        TMLog.i("TMAssistantDownloadSDKService", "registerDownloadTaskCallback,clientKey:" + str);
        if (str != null && iTMAssistantDownloadSDKServiceCallback != null) {
            this.this$0.mCallbacks.register(iTMAssistantDownloadSDKServiceCallback);
            synchronized (this) {
                this.this$0.mCallbackHashMap.put(iTMAssistantDownloadSDKServiceCallback, str);
            }
        }
    }

    public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
        TMLog.i("TMAssistantDownloadSDKService", "unregisterDownloadTaskCallback,clientKey:" + str);
        if (str != null && iTMAssistantDownloadSDKServiceCallback != null) {
            this.this$0.mCallbacks.unregister(iTMAssistantDownloadSDKServiceCallback);
            synchronized (this) {
                this.this$0.mCallbackHashMap.remove(iTMAssistantDownloadSDKServiceCallback);
            }
        }
    }
}
