package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.network.GetAuthorizedHttpRequest;
import com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TMOpenSDKToMsdkManager {
    protected static final String CLIENT_NAME = "downloadSDKClient";
    protected static final String TAG = "OpensdkToMsdkManager";
    protected static TMOpenSDKToMsdkManager mInstance = null;
    protected int authorizedState = 0;
    protected PopDialog dialog = null;
    protected boolean hasNotify = false;
    protected long insertActionId = -1;
    protected boolean isInstallFinished = false;
    protected TMOpenSDKAuthorizedInfo mAuthorizedInfo = null;
    protected TMAssistantDownloadSDKClient mClient = null;
    protected Context mContext = null;
    protected ITMAssistantDownloadSDKClientListener mDownloadSDKListener = new ITMAssistantDownloadSDKClientListener() {
        public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
        }

        public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2) {
            TMLog.i(TMOpenSDKToMsdkManager.TAG, "OnDownloadSDKTaskStateChanged client:" + tMAssistantDownloadSDKClient + " | state:" + i + " | errorcode:" + i2 + " | errorMsg:" + str2);
            if (tMAssistantDownloadSDKClient != null && !TextUtils.isEmpty(str)) {
                if (4 == i) {
                    TMOpenSDKToMsdkManager.this.mSubMessageHandler.post(new 1(this, tMAssistantDownloadSDKClient, str));
                } else if (5 == i) {
                    Message message = new Message();
                    message.what = 3;
                    TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                }
            }
        }

        public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            Message message = new Message();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putLong("receiveDataLen", j);
            bundle.putLong("totalDataLen", j2);
            message.setData(bundle);
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
        }
    };
    protected String mDownloadUrl = null;
    protected GetAuthorizedHttpRequest mHttpRequest = null;
    protected af mMainMessageHandler = null;
    protected TMQQDownloaderOpenSDK mOpenSDK = null;
    protected IGetAuthorizedHttpRequestListenner mRequestListener = new 2(this);
    protected af mSubMessageHandler = null;
    protected HandlerThread mSubMessagehandlerThread = null;
    protected int mSupportVersionCode = 0;
    protected ITMOpenSDKToMsdkListener mToMsdkListener = null;
    protected OnClickListener negativeBtnListenner = new 5(this);
    protected OnClickListener positiveBtnListener = new 6(this);
    protected OnClickListener retryBtnListener = new 4(this);
    protected TMAssistantSDKChannel sdkChannel = null;

    private TMOpenSDKToMsdkManager(Context context) {
        this.mContext = context;
    }

    public static synchronized TMOpenSDKToMsdkManager getInstance(Context context) {
        TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager;
        synchronized (TMOpenSDKToMsdkManager.class) {
            if (mInstance == null) {
                mInstance = new TMOpenSDKToMsdkManager(context);
            }
            tMOpenSDKToMsdkManager = mInstance;
        }
        return tMOpenSDKToMsdkManager;
    }

    public void initOpenSDK(ITMOpenSDKToMsdkListener iTMOpenSDKToMsdkListener) {
        this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
        this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
        this.mToMsdkListener = iTMOpenSDKToMsdkListener;
        this.sdkChannel = new TMAssistantSDKChannel();
        this.mSubMessagehandlerThread = new HandlerThread("OpenSDKToMsdkManager");
        this.mSubMessagehandlerThread.start();
        this.mSubMessageHandler = new af(this.mSubMessagehandlerThread.getLooper());
        this.mMainMessageHandler = new af(Looper.getMainLooper(), new 1(this));
    }

    public void onDestroy() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (this.mOpenSDK != null) {
            this.mOpenSDK.destroyQQDownloaderOpenSDK();
        }
        this.mToMsdkListener = null;
        this.hasNotify = false;
        this.isInstallFinished = false;
        this.authorizedState = 0;
        this.mHttpRequest = null;
        this.mAuthorizedInfo = null;
        this.sdkChannel = null;
        this.insertActionId = -1;
        if (this.mContext != null) {
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
        }
        this.mClient = null;
    }

    public void onResume() {
        tryToCloseDialog();
        if (!this.hasNotify && this.authorizedState != 2) {
            if ((this.authorizedState == 3 || this.authorizedState == 0) && this.mContext != null) {
                getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
            }
        }
    }

    public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo, Context context) {
        if (context != null) {
            this.mContext = context;
        }
        TMLog.i(TAG, "getUserAuthorizedInfo method called!");
        this.hasNotify = false;
        if (this.mHttpRequest != null) {
            TMLog.i(TAG, "mHttpRequest != null, request didn't finish!");
        } else if (tMOpenSDKAuthorizedInfo != null) {
            this.mAuthorizedInfo = tMOpenSDKAuthorizedInfo;
            if (this.mHttpRequest == null) {
                this.authorizedState = 1;
                this.mHttpRequest = new GetAuthorizedHttpRequest();
                this.mHttpRequest.setListenner(this.mRequestListener);
                this.mHttpRequest.sendRequest(tMOpenSDKAuthorizedInfo);
            }
        } else {
            TMLog.i(TAG, "AuthorizedInfo object is null!");
        }
    }

    protected void onNetworkFinishedSuccess(AuthorizedResult authorizedResult) {
        this.mDownloadUrl = authorizedResult.downloadUrl;
        this.mSupportVersionCode = authorizedResult.versionCode;
        this.mHttpRequest = null;
        TMLog.i(TAG, "onNetworkFinishedSuccess! authorizedResult.hasAuthoried=" + authorizedResult.hasAuthoried + "  listenner:" + this.mToMsdkListener + "  authroizedinfo:" + this.mAuthorizedInfo);
        if (authorizedResult.hasAuthoried == 1) {
            this.authorizedState = 2;
            if (authorizedResult.tipsInfo != null) {
                showDialog(authorizedResult.tipsInfo);
                return;
            } else {
                notifyAuthorizedFinished(true, this.mAuthorizedInfo);
                return;
            }
        }
        this.authorizedState = 3;
        if (authorizedResult.tipsInfo != null) {
            showDialog(authorizedResult.tipsInfo);
            return;
        }
        onServerException(authorizedResult.errorCode);
        TMLog.i(TAG, "not in white list and no tips!");
    }

    protected void onNetworkFinishedFailed(int i) {
        if (i == 606 || i == 602 || i == 601 || i == 704) {
            onServerException(i);
        } else {
            onNetworkException(i);
        }
    }

    protected void onServerException(int i) {
        if (this.mContext != null) {
            Res res = new Res(this.mContext);
            TipsInfo tipsInfo = new TipsInfo();
            tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
            if (i == 602 || i == 601) {
                tipsInfo.content = this.mContext.getString(res.string("white_list_network_error"));
            } else {
                tipsInfo.content = this.mContext.getString(res.string("white_list_server_error"));
            }
            ArrayList arrayList = new ArrayList();
            ActionButton actionButton = new ActionButton();
            actionButton.jumpType = 4;
            String string = this.mContext.getString(res.string("white_list_positive_retry_again"));
            actionButton.textInstalled = string;
            actionButton.textUninstalled = string;
            ActionButton actionButton2 = new ActionButton();
            actionButton2.jumpType = 3;
            String string2 = this.mContext.getString(res.string("white_list_negtive"));
            actionButton2.textInstalled = string2;
            actionButton2.textUninstalled = string2;
            arrayList.add(actionButton);
            arrayList.add(actionButton2);
            tipsInfo.actionButton = arrayList;
            showDialog(tipsInfo);
            this.mHttpRequest = null;
            this.mDownloadUrl = "";
            this.authorizedState = 3;
            JceStruct createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            createTipsInfoLog.networkErrorTipsCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        }
    }

    protected void onNetworkException(int i) {
        if (this.mContext != null) {
            String string;
            Res res = new Res(this.mContext);
            if (1 == i) {
                string = this.mContext.getString(res.string("white_list_network_not_connected"));
            } else {
                string = this.mContext.getString(res.string("white_list_network_error"));
            }
            TipsInfo tipsInfo = new TipsInfo();
            tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
            tipsInfo.content = string;
            ArrayList arrayList = new ArrayList();
            ActionButton actionButton = new ActionButton();
            actionButton.jumpType = 3;
            arrayList.add(actionButton);
            String string2 = this.mContext.getString(res.string("white_list_negtive_known"));
            actionButton.textInstalled = string2;
            actionButton.textUninstalled = string2;
            tipsInfo.actionButton = arrayList;
            showDialog(tipsInfo);
            this.mHttpRequest = null;
            this.mDownloadUrl = "";
            this.authorizedState = 3;
            TMLog.i(TAG, "network error happened!");
            JceStruct createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            createTipsInfoLog.networkErrorTipsCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        }
    }

    protected void notifyAuthorizedFinished(boolean z, TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        TMLog.i(TAG, "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
        if (this.mToMsdkListener == null) {
            TMLog.i(TAG, "before notifyAuthorizedFinished: mToMsdkListener = null !");
        }
        if (this.mToMsdkListener != null && this.mAuthorizedInfo != null) {
            TMLog.i(TAG, "notifyAuthorizedFinished: result:" + z);
            this.mToMsdkListener.onAuthorizedFinished(z, this.mAuthorizedInfo);
            this.mHttpRequest = null;
            this.hasNotify = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void showDialog(TipsInfo tipsInfo) {
        if (this.mContext != null) {
            if (this.dialog != null && this.dialog.isShowing()) {
                return;
            }
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isFinishing()) {
                TMLog.i(TAG, "context is finishing!  context" + this.mContext);
                return;
            }
            Res res = new Res(this.mContext);
            if (tipsInfo != null) {
                ArrayList arrayList = tipsInfo.actionButton;
                if (arrayList != null && arrayList.size() > 0) {
                    this.dialog = new PopDialog(this.mContext, res.style("while_list_dialog"), arrayList.size());
                    this.dialog.show();
                    this.dialog.setTitle(tipsInfo.title);
                    this.dialog.setContent(tipsInfo.content);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ActionButton actionButton = (ActionButton) arrayList.get(i);
                        if (actionButton.jumpType == 3) {
                            this.dialog.setNegativeBtnText(actionButton.textInstalled);
                            this.dialog.setNegativeBtnClickListener(this.negativeBtnListenner);
                        } else if (actionButton.jumpType == 4) {
                            this.dialog.setPositiveBtnText(actionButton.textUninstalled);
                            this.dialog.setPositiveBtnClickListener(this.retryBtnListener);
                        } else {
                            try {
                                switch (this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode)) {
                                    case 0:
                                        this.dialog.setPositiveBtnText(actionButton.textInstalled);
                                        JceStruct createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
                                        createTipsInfoLog.authorizedTipsCount++;
                                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                                        break;
                                    case 1:
                                        this.dialog.setPositiveBtnText(actionButton.textUninstalled);
                                        continueDownload();
                                        break;
                                    case 2:
                                        this.dialog.setPositiveBtnText(this.mContext.getString(res.string("white_list_positive_update")));
                                        continueDownload();
                                        break;
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace(TAG, e, "", new Object[0]);
                            }
                            this.dialog.setPositiveBtnTag(actionButton);
                            this.dialog.setPositiveBtnClickListener(this.positiveBtnListener);
                        }
                    }
                }
            }
        }
    }

    protected void continueDownload() {
        this.mSubMessageHandler.post(new 3(this));
    }

    protected void tryToCloseDialog() {
        if (this.mOpenSDK != null && this.mContext != null) {
            try {
                int checkQQDownloaderInstalled = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
                if (this.isInstallFinished && checkQQDownloaderInstalled == 0) {
                    this.mHttpRequest = null;
                    this.isInstallFinished = false;
                    this.mDownloadUrl = null;
                    if (this.dialog.isShowing()) {
                        this.dialog.dismiss();
                    }
                    TMAssistantDownloadSDKManager.closeAllService(this.mContext);
                    this.mClient = null;
                    if (isExitsAction(this.insertActionId)) {
                        this.mOpenSDK.startQQDownloader(this.mContext);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
    }

    protected boolean isExitsAction(long j) {
        if (j < 0) {
            return false;
        }
        if (this.sdkChannel == null) {
            return false;
        }
        Iterator it = this.sdkChannel.getChannelDataItemList().iterator();
        while (it.hasNext()) {
            TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem) it.next();
            if (((long) tMAssistantSDKChannelDataItem.mDBIdentity) == j && tMAssistantSDKChannelDataItem.mDataItemEndTime - tMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000) {
                return true;
            }
        }
        return false;
    }

    protected void handleInstall(String str, int i) {
        if (this.mContext != null) {
            Res res = new Res(this.mContext);
            this.dialog.setPositiveBtnEnable(true);
            this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_install")));
            if (this.mContext == null) {
                TMLog.i(TAG, "handleDownloading context = null!");
                return;
            }
            this.isInstallFinished = true;
            if (i != 1) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                this.mContext.startActivity(intent);
            }
        }
    }

    protected void handleDownloadFailed() {
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        Res res = new Res(this.mContext);
        this.dialog.setPositiveBtnEnable(true);
        this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_retry")));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
    }

    protected void handleDownloading(long j, long j2) {
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        String string = this.mContext.getString(new Res(this.mContext).string("white_list_positive_downloading"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j)) + 0.0f) / ((float) j2))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j) + 0.0f) / ((float) j2)) * ((float) this.dialog.downloadProgressBar.getMax())));
        TMLog.i(TAG, "handleDownloading : receivedlen:" + j + " | totalLen:" + j2);
    }

    protected void handleDownloadContinue(long j, long j2) {
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        Res res = new Res(this.mContext);
        String string = this.mContext.getString(res.string("white_list_positive_continue"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j)) + 0.0f) / ((float) j2))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j) + 0.0f) / ((float) j2)) * ((float) this.dialog.downloadProgressBar.getMax())));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
    }

    protected void startToQQDownloaderAuthorized(String str) {
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.mHttpRequest = null;
        this.isInstallFinished = false;
        if (!TextUtils.isEmpty(str)) {
            JceStruct createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            createTipsInfoLog.authorizedBtnClickCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
            if (this.mContext != null && this.mOpenSDK != null) {
                this.mOpenSDK.startToAuthorized(this.mContext, str);
            }
        }
    }

    protected void startDownloadTask(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.dialog.setPositiveBtnEnable(false);
            this.mSubMessageHandler.post(new 7(this, str2, str));
        }
    }

    protected void pauseDownloadTask(String str) {
        if (!TextUtils.isEmpty(str) && this.mAuthorizedInfo != null) {
            this.mSubMessageHandler.post(new 8(this, str));
        }
    }

    protected TMAssistantDownloadSDKClient getClient() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mClient != null) {
            return this.mClient;
        }
        TMAssistantDownloadSDKClient downloadSDKClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient(CLIENT_NAME);
        downloadSDKClient.registerDownloadTaskListener(this.mDownloadSDKListener);
        this.mClient = downloadSDKClient;
        return downloadSDKClient;
    }

    public static String about() {
        return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
    }
}
