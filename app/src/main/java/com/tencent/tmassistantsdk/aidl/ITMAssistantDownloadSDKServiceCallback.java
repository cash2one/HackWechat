package com.tencent.tmassistantsdk.aidl;

import android.os.IInterface;

public interface ITMAssistantDownloadSDKServiceCallback extends IInterface {
    void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j, long j2);

    void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2);
}
