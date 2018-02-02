package com.tencent.tmassistantsdk.aidl;

import android.os.IInterface;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.Map;

public interface ITMAssistantDownloadSDKServiceInterface extends IInterface {
    void cancelDownloadTask(String str, String str2);

    TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2);

    int getServiceVersion();

    boolean isAllDownloadFinished();

    void pauseDownloadTask(String str, String str2);

    void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback);

    void setServiceSetingIsDownloadWifiOnly(boolean z);

    void setServiceSetingIsTaskAutoResume(boolean z);

    void setServiceSetingMaxTaskNum(int i);

    int startDownloadTask(String str, String str2, String str3, long j, int i, String str4, String str5, Map map);

    void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback);
}
