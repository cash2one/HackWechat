package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;

public class DownloadStateChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "DownloadStateChangedReceiver";
    protected static DownloadStateChangedReceiver mInstance = null;
    protected af handler = null;
    protected HandlerThread handlerThread = new HandlerThread("downloadStateChangedThread");
    protected boolean isRegisted = false;
    ArrayList<IDownloadStateChangedListener> mListeners = new ArrayList();

    public DownloadStateChangedReceiver() {
        this.handlerThread.start();
        this.handler = new af(this.handlerThread.getLooper());
    }

    public static synchronized DownloadStateChangedReceiver getInstance() {
        DownloadStateChangedReceiver downloadStateChangedReceiver;
        synchronized (DownloadStateChangedReceiver.class) {
            if (mInstance == null) {
                mInstance = new DownloadStateChangedReceiver();
            }
            downloadStateChangedReceiver = mInstance;
        }
        return downloadStateChangedReceiver;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.handler != null) {
            this.handler.post(new 1(this, intent));
        }
    }

    public void registeReceiver(Context context) {
        if (!this.isRegisted) {
            TMLog.i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                TMLog.i(TAG, String.valueOf(context.registerReceiver(this, new IntentFilter(OpenSDKTool4Assistant.OPENSDK_ACTION_NAME))));
                this.isRegisted = true;
            } catch (Throwable th) {
                TMLog.i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                x.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
    }

    public void unRegisteReceiver(Context context) {
        if (context != null && mInstance != null && this.isRegisted) {
            TMLog.i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                context.unregisterReceiver(this);
                this.isRegisted = false;
            } catch (Throwable th) {
                TMLog.i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                x.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
    }

    public void addDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        if (iDownloadStateChangedListener != null && !this.mListeners.contains(iDownloadStateChangedListener)) {
            this.mListeners.add(iDownloadStateChangedListener);
        }
    }

    public void removeDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        if (iDownloadStateChangedListener != null) {
            this.mListeners.remove(iDownloadStateChangedListener);
        }
    }
}
