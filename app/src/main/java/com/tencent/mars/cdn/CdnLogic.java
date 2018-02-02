package com.tencent.mars.cdn;

import com.tencent.mars.Mars;
import java.util.ArrayList;

public class CdnLogic {
    public static final int HIT_FILEID = 1;
    public static final int HIT_UPLOADCHECKMD5 = 2;
    public static final int HIT_UPLOADWITHMD5 = 3;
    public static final int MediaTypeAppImage = 20301;
    public static final int MediaTypeFriendsADImageThumb = 20204;
    public static final int MediaTypeFriendsImageThumb = 20205;
    public static final int MediaTypeFriendsVideoThumbImage = 20250;
    public static final int MediaType_FAVORITE_FILE = 10001;
    public static final int MediaType_FAVORITE_VIDEO = 10002;
    public static final int MediaType_FILE = 5;
    public static final int MediaType_FRIENDS = 20201;
    public static final int MediaType_FRIENDS_Video = 20202;
    public static final int MediaType_FULLSIZEIMAGE = 1;
    public static final int MediaType_GlanceVideo = 90;
    public static final int MediaType_IMAGE = 2;
    public static final int MediaType_THUMBIMAGE = 3;
    public static final int MediaType_TinyVideo = 6;
    public static final int MediaType_VIDEO = 4;
    public static final int NO_ERROR = 0;
    public static final int NO_HITCACHE = 0;
    public static final int PreloadMode = 2;
    public static final int StorageMode = 0;
    private static final String TAG = "mars.CdnLogic";
    public static final int VideoFormat_Unknown = 0;
    public static final int VideoFormat_X264 = 1;
    public static final int VideoFormat_X265 = 2;
    public static final int VideoPlayMode = 1;
    private static ICallback callBack = null;
    public static final String defaultApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
    public static final int kAppTypeAdImage = 109;
    public static final int kAppTypeAdVideo = 105;
    public static final int kAppTypeAny = 0;
    public static final int kAppTypeC2C = 1;
    public static final int kAppTypeC2CGroupChat = 2;
    public static final int kAppTypeFavorite = 10;
    public static final int kAppTypeHwPage = 200;
    public static final int kAppTypeMultiJpeg = 101;
    public static final int kAppTypeMultiVCodec = 108;
    public static final int kAppTypeMultiWebp = 104;
    public static final int kAppTypeNearEvent = 201;
    public static final int kAppTypeShop = 200;
    public static final int kAppTypeSingleJpeg = 100;
    public static final int kAppTypeSingleVCodec = 107;
    public static final int kAppTypeSingleWebp = 103;
    public static final int kAppTypeUnknown = -1;
    public static final int kAppTypeVideo = 102;
    public static final int kAppTypeVideoThumb = 150;
    public static final int kAppTypeYunStorage = 202;
    public static final int kBizAny = 0;
    public static final int kBizApp = 4;
    public static final int kBizC2C = 1;
    public static final int kBizFavorite = 2;
    public static final int kBizSns = 3;
    public static final int kBizUnknown = -1;
    public static final int kIpSource_NewDNS = 1;
    public static final int kIpSource_None = 0;
    public static final int kIpSource_SysDNS = 2;
    public static final int kMediaGamePacket = 30002;
    public static final int kMediaLittleAppPacket = 30001;
    public static final int kMediaTypeAdImage = 20204;
    public static final int kMediaTypeAdVideo = 20210;
    public static final int kMediaTypeAny = 0;
    public static final int kMediaTypeAppFile = 20303;
    public static final int kMediaTypeAppVideo = 20302;
    public static final int kMediaTypeBackupFile = 20001;
    public static final int kMediaTypeBeatificFile = 10011;
    public static final int kMediaTypeBigFile = 7;
    public static final int kMediaTypeExposeImage = 11000;
    public static final int kMediaTypeFavoriteBigFile = 10007;
    public static final int kMediaTypeFavoriteFile = 10001;
    public static final int kMediaTypeFavoriteVideo = 10002;
    public static final int kMediaTypeFile = 5;
    public static final int kMediaTypeFriends = 20201;
    public static final int kMediaTypeFriendsVideo = 20202;
    public static final int kMediaTypeFriendsVideoThumbImage = 20250;
    public static final int kMediaTypeFullSizeImage = 1;
    public static final int kMediaTypeHWDevice = 20322;
    public static final int kMediaTypeHWDeviceFile = 20303;
    public static final int kMediaTypeImage = 2;
    public static final int kMediaTypeNearEvent = 20310;
    public static final int kMediaTypeShop = 20301;
    public static final int kMediaTypeSmartHwPage = 20321;
    public static final int kMediaTypeThumbImage = 3;
    public static final int kMediaTypeTinyVideo = 6;
    public static final int kMediaTypeVideo = 4;

    public static class C2CDownloadResult {
        public String argInfo = "";
        public int averageConnectCost = 0;
        public int averageSpeed = 0;
        public int cSeqCheck = 0;
        public String clientIP = "";
        public int connectCostTime = 0;
        public boolean crossNet = false;
        public int delayTime = 0;
        public int dnsCostTime = 0;
        public long enQueueTime = 0;
        public long endTime = 0;
        public int errorCode = 0;
        public int fileSize = 0;
        public String fileid = "";
        public int firstConnectCost = 0;
        public boolean firstRequestCompleted = false;
        public int firstRequestCost = 0;
        public int firstRequestDownloadSize = 0;
        public int firstRequestSize = 0;
        public String httpResponseHeader = "";
        public int httpStatusCode = 0;
        public boolean isResume = false;
        public boolean moovCompleted = false;
        public int moovCost = 0;
        public int moovFailReason = 0;
        public int moovRequestTimes = 0;
        public int moovSize = 0;
        public int netConnectTimes = 0;
        public int receiveCostTime = 0;
        public int recvedBytes = 0;
        public String serverIP = "";
        public long startTime = 0;
        public String transforMsg = "";
        public boolean usePrivateProtocol = false;
        public String[] usedSvrIps;
        public int videoFormat = 0;
        public int waitResponseCostTime = 0;
        public String xErrorNo = "";
    }

    public static class C2CUploadRequest {
        public int apptype = 0;
        public String bigfileSignature = "";
        public int bizscene = 0;
        public int chatType = 0;
        public boolean checkExistOnly = false;
        public boolean enableHitCheck = true;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public String fileKey = "";
        public String filePath = "";
        public int fileSize = 0;
        public int fileType = 0;
        public boolean forceNoSafeCdn = false;
        public String forwardAeskey = "";
        public String forwardFileid = "";
        public boolean isLargeSVideo = false;
        public boolean isSmallVideo = false;
        public boolean isSnsAdVideo = false;
        public boolean isStorageMode = false;
        public boolean isStreamMedia = false;
        public int midfileSize = 0;
        public String midimgPath = "";
        public boolean needCompressImage = false;
        public boolean onlyCheckExist = false;
        public int queueTimeoutSeconds = 1800;
        public boolean sendmsgFromCDN = false;
        public String statePath = "";
        public String thumbfilePath = "";
        public String toUser = "";
        public int transforTimeoutSeconds = 600;
        public boolean trySafeCdn = false;
    }

    public static class Config {
        public int AckSlice = 8192;
        public String ApprovedVideoHosts = CdnLogic.defaultApprovedVideoHosts;
        public int C2COverloadDelaySeconds = 10;
        public int EnableCDNVerifyConnect = 1;
        public int EnableCDNVideoRedirectOC = 1;
        public int EnableSafeCDN = 0;
        public int EnableSnsImageDownload = 0;
        public int EnableSnsStreamDownload = 0;
        public int EnableStreamUploadVideo = 1;
        public int MobileEtl = 70;
        public int Ptl = 35;
        public int SNSOverloadDelaySeconds = 60;
        public int UseDynamicETL = 0;
        public int UseStreamCDN = 1;
        public int WifiEtl = 90;
        public boolean onlyrecvPtl = false;
        public boolean onlysendETL = false;

        public String toString() {
            return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d, snsimage:%d", new Object[]{Integer.valueOf(this.WifiEtl), Integer.valueOf(this.MobileEtl), Integer.valueOf(this.Ptl), Integer.valueOf(this.UseStreamCDN), Boolean.valueOf(this.onlysendETL), Boolean.valueOf(this.onlyrecvPtl), Integer.valueOf(this.AckSlice), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.UseDynamicETL), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload), Integer.valueOf(this.EnableSnsImageDownload)});
        }
    }

    public static native int cancelDownloadTaskWithResult(String str, C2CDownloadResult c2CDownloadResult);

    public static native void cancelTask(String str);

    public static native int cancelUploadTaskWithResult(String str, C2CUploadResult c2CUploadResult);

    public static native String createAeskey();

    public static native int getFileCrc32(String str);

    public static native String getFileMD5(String str);

    private static native ArrayList<String> getLoadLibraries();

    public static native String getMP4IdentifyMD5(String str);

    public static native CdnTaskStateInfo httpMultiSocketDownloadTaskState(String str);

    public static native boolean isVideoDataAvailable(String str, int i, int i2);

    public static native void onCreate(String str);

    public static native int pauseHttpMultiSocketDownloadTask(String str);

    public static native int requestVideoData(String str, int i, int i2, int i3);

    public static native int resumeHttpMultiSocketDownloadTask(String str);

    public static native void setCdnInfo(byte[] bArr, byte[] bArr2);

    public static native void setCdnInfoParams(CdnInfoParams cdnInfoParams, CdnInfoParams cdnInfoParams2, int i);

    public static native void setConfig(Config config);

    public static native void setDebugIP(String str);

    public static native void setFlowLimitPerHour(int i);

    public static native void setLegacyCdnInfo(CdnInfo cdnInfo, CdnInfo cdnInfo2, CdnInfo cdnInfo3, CdnInfo cdnInfo4, byte[] bArr, byte[] bArr2);

    public static native void setRSAPublicKeyParams(String str, String str2, String str3);

    public static native void setToUserCiper(String str);

    public static native int startC2CDownload(C2CDownloadRequest c2CDownloadRequest);

    public static native int startC2CUpload(C2CUploadRequest c2CUploadRequest);

    public static native int startCheckFileId(CheckFileIdRequest checkFileIdRequest);

    public static native int startHttpMultiSocketDownloadTask(C2CDownloadRequest c2CDownloadRequest);

    public static native int startHttpVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, int i);

    public static native int startHttpsDownload(C2CDownloadRequest c2CDownloadRequest);

    public static native int startSNSDownload(C2CDownloadRequest c2CDownloadRequest, int i);

    public static native int startURLDownload(C2CDownloadRequest c2CDownloadRequest);

    public static native int startVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, int i);

    public static native void triggerPreConnect(String str, String[] strArr, boolean z);

    static {
        ArrayList loadLibraries;
        try {
            loadLibraries = getLoadLibraries();
        } catch (UnsatisfiedLinkError e) {
            loadLibraries = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(loadLibraries, TAG);
    }

    public static void setCallBack(ICallback iCallback) {
        callBack = iCallback;
    }

    private static void onProgressChanged(String str, int i, int i2, boolean z) {
        if (callBack != null) {
            callBack.onProgressChanged(str, i, i2, z);
        }
    }

    private static void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        if (callBack != null) {
            callBack.onC2CUploadCompleted(str, c2CUploadResult);
        }
    }

    private static void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult) {
        if (callBack != null) {
            callBack.onC2CDownloadCompleted(str, c2CDownloadResult);
        }
    }

    private static void onCheckFileIDCompleted(String str, CheckFileIDResult checkFileIDResult) {
        if (callBack != null) {
            callBack.onCheckFileidCompleted(str, checkFileIDResult);
        }
    }

    private static void onRecvedData(String str, int i, byte[] bArr) {
        if (callBack != null) {
            callBack.onRecvedData(str, i, bArr);
        }
    }

    private static byte[] getSessionRequestBuf(String str, byte[] bArr) {
        if (callBack == null) {
            return null;
        }
        return callBack.getSessionRequestBuf(str, bArr);
    }

    private static byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        if (callBack == null) {
            return null;
        }
        return callBack.decodeSessionResponseBuf(str, bArr);
    }

    public static void onMoovReady(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onMoovReady(str, i, i2);
        }
    }

    public static void onDataAvailable(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onDataAvailable(str, i, i2);
        }
    }

    public static void onDownloadToEnd(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onDownloadToEnd(str, i, i2);
        }
    }

    public static void onPreloadCompleted(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onPreloadCompleted(str, i, i2);
        }
    }

    public static void onPreloadCompletedWithResult(String str, int i, int i2, C2CDownloadResult c2CDownloadResult) {
        if (callBack != null) {
            callBack.onPreloadCompletedWithResult(str, i, i2, c2CDownloadResult);
        }
    }

    public static void RequestGetCDN(int i) {
        if (callBack != null) {
            callBack.RequestGetCDN(i);
        }
    }

    public static void ReportFlow(int i, int i2, int i3, int i4) {
        if (callBack != null) {
            callBack.ReportFlow(i, i2, i3, i4);
        }
    }
}
