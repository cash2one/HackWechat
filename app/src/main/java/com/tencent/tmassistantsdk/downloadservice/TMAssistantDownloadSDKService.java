package com.tencent.tmassistantsdk.downloadservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;

public class TMAssistantDownloadSDKService extends Service implements IServiceDownloadTaskManagerListener {
    protected static final String TAG = "TMAssistantDownloadSDKService";
    protected final TMAssistantDownloadSDKServiceImpl downloadSDKServiceImpl = new TMAssistantDownloadSDKServiceImpl(this);
    protected final HashMap<ITMAssistantDownloadSDKServiceCallback, String> mCallbackHashMap = new HashMap();
    protected final RemoteCallbackList<ITMAssistantDownloadSDKServiceCallback> mCallbacks = new RemoteCallbackList();
    ServiceDownloadTaskManager mServiceDownloadTaskManager = null;

    public void onCreate() {
        super.onCreate();
        GlobalUtil.getInstance().setContext(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        this.mServiceDownloadTaskManager = new ServiceDownloadTaskManager(DBManager.getInstance().queryWaitingAndDownloadingTaskList());
        this.mServiceDownloadTaskManager.setListener(this);
        this.mServiceDownloadTaskManager.registerApkDownloadManagerListener();
        ApkDownloadManager.getInstance().init();
        TMLog.i(TAG, "onCreate");
    }

    public IBinder onBind(Intent intent) {
        TMLog.i(TAG, "onBind ,intent:" + intent);
        return this.downloadSDKServiceImpl;
    }

    public boolean onUnbind(Intent intent) {
        TMLog.i(TAG, "onUnbind ,intent:" + intent);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        TMLog.i(TAG, "onDestroy");
        super.onDestroy();
        ApkDownloadManager.getInstance().uninit();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        this.mServiceDownloadTaskManager.unRegisterApkDownloadManagerListener();
        this.mServiceDownloadTaskManager.setListener(null);
        this.mServiceDownloadTaskManager = null;
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GlobalUtil.getInstance().destroy();
        SystemClock.sleep(300);
        Process.killProcess(Process.myPid());
    }

    public void OnDownloadStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2) {
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback) this.mCallbacks.getBroadcastItem(i3);
                    String str4 = (String) this.mCallbackHashMap.get(iTMAssistantDownloadSDKServiceCallback);
                    if (str4 != null && str4.equals(str)) {
                        TMLog.i(TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ",url:" + str2);
                        iTMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskStateChanged(str, str2, i, i2, str3, z, z2);
                        break;
                    }
                } catch (RemoteException e) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Throwable th) {
        }
    }

    public void OnDownloadProgressChanged(String str, String str2, long j, long j2) {
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback) this.mCallbacks.getBroadcastItem(i);
                    String str3 = (String) this.mCallbackHashMap.get(iTMAssistantDownloadSDKServiceCallback);
                    if (str3 != null && str3.equals(str)) {
                        TMLog.i(TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",url:" + str2);
                        iTMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskProgressChanged(str, str2, j, j2);
                        break;
                    }
                } catch (RemoteException e) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Throwable th) {
        }
    }
}
