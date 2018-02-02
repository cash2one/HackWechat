package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback$Stub;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class TMAssistantDownloadSDKClient$1 extends ITMAssistantDownloadSDKServiceCallback$Stub {
    final /* synthetic */ TMAssistantDownloadSDKClient this$0;

    TMAssistantDownloadSDKClient$1(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
        this.this$0 = tMAssistantDownloadSDKClient;
    }

    public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2) {
        TMLog.i("TMAssistantDownloadSDKClient", "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ", errorcode" + i2 + ",url:" + str2);
        Iterator it = this.this$0.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
            if (iTMAssistantDownloadSDKClientListener == null) {
                TMLog.i("TMAssistantDownloadSDKClient", " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
            }
            TMAssistantDownloadSDKMessageThread.getInstance().postTaskStateChangedMessage(this.this$0, iTMAssistantDownloadSDKClientListener, str2, i, i2, str3, z, z2);
        }
    }

    public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j, long j2) {
        TMLog.i("TMAssistantDownloadSDKClient", "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",totalLen:" + j2 + ",url:" + str2);
        Iterator it = this.this$0.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
            if (iTMAssistantDownloadSDKClientListener == null) {
                TMLog.i("TMAssistantDownloadSDKClient", " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
            }
            TMAssistantDownloadSDKMessageThread.getInstance().postTaskProgressChangedMessage(this.this$0, iTMAssistantDownloadSDKClientListener, str2, j, j2);
        }
    }
}
