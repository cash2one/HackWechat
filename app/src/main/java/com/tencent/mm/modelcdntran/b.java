package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.CheckFileIDResult;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.ICallback;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.protocal.c.jq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements ICallback {
    public static int MediaType_FAVORITE_FILE = 10001;
    public static int MediaType_FAVORITE_VIDEO = 10002;
    public static int MediaType_FILE = 5;
    public static int MediaType_FRIENDS = 20201;
    public static int MediaType_FULLSIZEIMAGE = 1;
    public static int MediaType_IMAGE = 2;
    public static int MediaType_THUMBIMAGE = 3;
    public static int MediaType_TinyVideo = 6;
    public static int MediaType_VIDEO = 4;
    public static int hrJ = 1;
    public static int hrK = 2;
    public static int hrL = 3;
    public static int hrM = 7;
    public static int hrN = CdnLogic.kMediaTypeBeatificFile;
    public static int hrO = 20202;
    public static int hrP = 20301;
    public static int hrQ = CdnLogic.kMediaTypeAppVideo;
    public static int hrR = 20304;
    public static int hrS = 20303;
    public static int hrT = CdnLogic.kMediaTypeSmartHwPage;
    public static int hrU = CdnLogic.kMediaTypeHWDevice;
    public static int hrV = CdnLogic.kMediaLittleAppPacket;
    public static int hrW = CdnLogic.kMediaGamePacket;
    public static int hrX = 30003;
    public static int hrY = 30004;
    public static int hrZ = 30005;
    public static int hsa = 30006;
    public static int hsb = 100;
    public static int hsc = 101;
    public static int hsd = 102;
    public static int hse = 103;
    public static int hsf = WXMediaMessage.THUMB_LENGTH_LIMIT;
    public static int hsg = 7340033;
    private jp hsh = null;
    b hsi = null;
    private int hsj = 0;
    private int hsk = 0;
    private String hsl = "";
    private ak hsm = null;
    public a hsn;

    public b(String str, b bVar) {
        if (ac.cfw()) {
            this.hsm = new ak(g.Dm().oAt.getLooper(), new 1(this), true);
        }
        this.hsi = bVar;
        CdnLogic.setCallBack(this);
        CdnLogic.onCreate(str);
        CdnLogic.setRSAPublicKeyParams("1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001");
        CdnLogic.setToUserCiper("cdnwx2013usrname");
        x.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", new Object[]{Integer.valueOf(hashCode()), str, bh.cgy()});
    }

    public static int keep_callFromJni(int i, int i2, byte[] bArr) {
        if (i == hsb) {
            d.b(bArr, "MicroMsg.CdnEngine", i2);
        }
        return 0;
    }

    public static C2CDownloadRequest a(i iVar) {
        boolean z = true;
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileid = iVar.field_fileId;
        c2CDownloadRequest.aeskey = iVar.field_aesKey;
        c2CDownloadRequest.fileType = iVar.field_fileType;
        c2CDownloadRequest.fileKey = iVar.field_mediaId;
        c2CDownloadRequest.fileSize = iVar.field_totalLen;
        c2CDownloadRequest.savePath = iVar.field_fullpath;
        c2CDownloadRequest.isStorageMode = iVar.field_needStorage;
        if (iVar.field_smallVideoFlag != 1) {
            z = false;
        }
        c2CDownloadRequest.isSmallVideo = z;
        c2CDownloadRequest.isLargeSVideo = iVar.field_largesvideo;
        c2CDownloadRequest.limitRate = iVar.field_limitrate;
        c2CDownloadRequest.isAutoStart = iVar.field_autostart;
        c2CDownloadRequest.chatType = iVar.field_chattype;
        c2CDownloadRequest.isSilentTask = iVar.field_isSilentTask;
        c2CDownloadRequest.requestVideoFormat = iVar.field_requestVideoFormat;
        c2CDownloadRequest.isColdSnsData = iVar.field_isColdSnsData;
        c2CDownloadRequest.signalQuality = iVar.field_signalQuality;
        c2CDownloadRequest.snsScene = iVar.field_snsScene;
        c2CDownloadRequest.requestVideoFormat = iVar.field_requestVideoFormat;
        c2CDownloadRequest.videofileid = iVar.field_videoFileId;
        c2CDownloadRequest.bigfileSignature = iVar.field_svr_signature;
        if (bh.ov(c2CDownloadRequest.bigfileSignature)) {
            c2CDownloadRequest.bigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignature = iVar.field_fake_bigfile_signature;
        if (bh.ov(c2CDownloadRequest.fakeBigfileSignature)) {
            c2CDownloadRequest.fakeBigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignatureAeskey = iVar.field_fake_bigfile_signature_aeskey;
        if (bh.ov(c2CDownloadRequest.fakeBigfileSignatureAeskey)) {
            c2CDownloadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CDownloadRequest.msgExtra = iVar.field_wxmsgparam;
        if (bh.ov(c2CDownloadRequest.msgExtra)) {
            c2CDownloadRequest.msgExtra = "";
        }
        c2CDownloadRequest.queueTimeoutSeconds = 0;
        c2CDownloadRequest.transforTimeoutSeconds = 0;
        c2CDownloadRequest.initialDownloadLength = iVar.initialDownloadLength;
        c2CDownloadRequest.initialDownloadOffset = iVar.initialDownloadOffset;
        c2CDownloadRequest.preloadRatio = iVar.field_preloadRatio;
        return c2CDownloadRequest;
    }

    public static int b(i iVar) {
        boolean z = true;
        C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
        c2CUploadRequest.fileKey = iVar.field_mediaId;
        c2CUploadRequest.filePath = iVar.field_fullpath;
        c2CUploadRequest.thumbfilePath = iVar.field_thumbpath;
        c2CUploadRequest.fileSize = iVar.field_totalLen;
        c2CUploadRequest.fileType = iVar.field_fileType;
        c2CUploadRequest.forwardAeskey = iVar.field_aesKey;
        c2CUploadRequest.forwardFileid = iVar.field_fileId;
        c2CUploadRequest.midfileSize = iVar.field_midFileLength;
        c2CUploadRequest.queueTimeoutSeconds = 0;
        c2CUploadRequest.transforTimeoutSeconds = 0;
        c2CUploadRequest.toUser = iVar.field_talker;
        c2CUploadRequest.sendmsgFromCDN = iVar.field_sendmsg_viacdn;
        c2CUploadRequest.needCompressImage = iVar.field_needCompressImage;
        c2CUploadRequest.chatType = iVar.field_chattype;
        c2CUploadRequest.apptype = iVar.field_appType;
        c2CUploadRequest.bizscene = iVar.field_bzScene;
        c2CUploadRequest.checkExistOnly = iVar.field_onlycheckexist;
        c2CUploadRequest.isSmallVideo = iVar.field_smallVideoFlag == 1;
        c2CUploadRequest.isLargeSVideo = iVar.field_largesvideo;
        if (iVar.field_advideoflag != 1) {
            z = false;
        }
        c2CUploadRequest.isSnsAdVideo = z;
        c2CUploadRequest.isStorageMode = iVar.field_needStorage;
        c2CUploadRequest.isStreamMedia = iVar.field_isStreamMedia;
        c2CUploadRequest.enableHitCheck = iVar.field_enable_hitcheck;
        c2CUploadRequest.forceNoSafeCdn = iVar.field_force_aeskeycdn;
        c2CUploadRequest.trySafeCdn = iVar.field_trysafecdn;
        c2CUploadRequest.midimgPath = iVar.field_midimgpath;
        c2CUploadRequest.bigfileSignature = iVar.field_svr_signature;
        if (bh.ov(c2CUploadRequest.bigfileSignature)) {
            c2CUploadRequest.bigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignature = iVar.field_fake_bigfile_signature;
        if (bh.ov(c2CUploadRequest.fakeBigfileSignature)) {
            c2CUploadRequest.fakeBigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignatureAeskey = iVar.field_fake_bigfile_signature_aeskey;
        if (bh.ov(c2CUploadRequest.fakeBigfileSignatureAeskey)) {
            c2CUploadRequest.fakeBigfileSignatureAeskey = "";
        }
        return CdnLogic.startC2CUpload(c2CUploadRequest);
    }

    public static int kz(String str) {
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int kA(String str) {
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static String kB(String str) {
        return CdnLogic.getFileMD5(str);
    }

    public static String MC() {
        return CdnLogic.createAeskey();
    }

    public static int kC(String str) {
        return CdnLogic.getFileCrc32(str);
    }

    public static String kD(String str) {
        return CdnLogic.getMP4IdentifyMD5(str);
    }

    public static int a(String str, String str2, String str3, int i, int i2, int i3, String[] strArr, boolean z) {
        int i4 = 0;
        String str4 = "MicroMsg.CdnTransportEngine";
        String str5 = "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = str3;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        if (strArr != null) {
            i4 = strArr.length;
        }
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = Boolean.valueOf(z);
        x.i(str4, str5, objArr);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.queueTimeoutSeconds = i2;
        c2CDownloadRequest.transforTimeoutSeconds = i3;
        c2CDownloadRequest.ocIpList = strArr;
        if (!z) {
            c2CDownloadRequest.customHttpHeader = "Accept-Encoding:  ";
        }
        c2CDownloadRequest.fileType = i;
        if (hrV == c2CDownloadRequest.fileType) {
            return CdnLogic.startHttpsDownload(c2CDownloadRequest);
        }
        return CdnLogic.startURLDownload(c2CDownloadRequest);
    }

    public static int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2, int i3, boolean z, String str5, String str6, int i4) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20202;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.initialDownloadOffset = i2;
        c2CDownloadRequest.initialDownloadLength = i3;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.preloadRatio = i4;
        return CdnLogic.startSNSDownload(c2CDownloadRequest, i);
    }

    public static int a(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, int i, int i2, boolean z, String str5, String str6, String str7, int i3, int i4, int i5) {
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str4)) {
            x.e("MicroMsg.CdnTransportEngine", "invalid param.");
            return -1;
        }
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.ocIpList = strArr != null ? (String[]) strArr.clone() : null;
        c2CDownloadRequest.ocIpListSource = i;
        c2CDownloadRequest.dcIpList = strArr2 != null ? (String[]) strArr2.clone() : null;
        c2CDownloadRequest.dcIpListSource = i2;
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.snsCipherKey = str7;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = i3;
        c2CDownloadRequest.marscdnAppType = i4;
        c2CDownloadRequest.fileType = i5;
        return CdnLogic.startSNSDownload(c2CDownloadRequest, 0);
    }

    public static int kE(String str) {
        x.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:" + str);
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int a(String str, String str2, String str3, String str4, Map<String, String> map, boolean z, int i, int i2, boolean z2, String[] strArr) {
        x.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:" + str);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.bakup_url = str4;
        c2CDownloadRequest.savePath = str2;
        c2CDownloadRequest.queueTimeoutSeconds = i;
        c2CDownloadRequest.transforTimeoutSeconds = i2;
        c2CDownloadRequest.ocIpList = strArr;
        c2CDownloadRequest.is_resume_task = z2;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getKey());
                c2CDownloadRequest.serialized_verify_headers += ":";
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getValue());
                c2CDownloadRequest.serialized_verify_headers += ";";
            }
        }
        c2CDownloadRequest.allow_mobile_net_download = z;
        return CdnLogic.startHttpMultiSocketDownloadTask(c2CDownloadRequest);
    }

    public static int kF(String str) {
        x.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:" + str);
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int a(i iVar, int i) {
        return CdnLogic.startVideoStreamingDownload(a(iVar), i);
    }

    public static int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2, int i3, int i4) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.initialDownloadOffset = i2;
        c2CDownloadRequest.initialDownloadLength = i3;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.preloadRatio = i4;
        return CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, i);
    }

    public static int a(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.fileType = 90;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.preloadRatio = i2;
        c2CDownloadRequest.concurrentCount = i3;
        c2CDownloadRequest.maxHttpRedirectCount = 100;
        return CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, i);
    }

    public final int a(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        C2CDownloadResult c2CDownloadResult = new C2CDownloadResult();
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, c2CDownloadResult);
        a(c2CDownloadResult, com_tencent_mm_modelcdntran_keep_SceneResult);
        return cancelDownloadTaskWithResult;
    }

    public static int requestVideoData(String str, int i, int i2, int i3) {
        return CdnLogic.requestVideoData(str, i, i2, 0);
    }

    public static boolean isVideoDataAvailable(String str, int i, int i2) {
        return CdnLogic.isVideoDataAvailable(str, i, i2);
    }

    public final boolean MD() {
        return this.hsh == null;
    }

    private static CdnInfo a(jp jpVar) {
        CdnInfo cdnInfo = new CdnInfo();
        if (jpVar == null) {
            return cdnInfo;
        }
        int i;
        cdnInfo.ver = jpVar.vPZ;
        cdnInfo.uin = jpVar.lOd;
        cdnInfo.frontid = jpVar.vQb;
        cdnInfo.zoneid = jpVar.vQg;
        cdnInfo.nettype = d.bh(ac.getContext());
        cdnInfo.authkey = n.a(jpVar.vQf);
        if (jpVar.vQc >= 2) {
            cdnInfo.frontip1 = n.a((bdo) jpVar.vQd.get(0));
            cdnInfo.frontip2 = n.a((bdo) jpVar.vQd.get(1));
            x.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[]{cdnInfo.frontip1, cdnInfo.frontip2});
        }
        if (jpVar.vQh >= 2) {
            cdnInfo.zoneip1 = n.a((bdo) jpVar.vQi.get(0));
            cdnInfo.zoneip2 = n.a((bdo) jpVar.vQi.get(1));
            x.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[]{cdnInfo.frontip1, cdnInfo.frontip2});
        }
        if (jpVar.vQl > 0) {
            int i2;
            i2 = ((jq) jpVar.vQj.get(0)).vQn;
            cdnInfo.frontports = new int[i2];
            for (i = 0; i < i2; i++) {
                cdnInfo.frontports[i] = ((Integer) ((jq) jpVar.vQj.get(0)).vQo.get(i)).intValue();
            }
        }
        if (jpVar.vQm > 0) {
            i2 = ((jq) jpVar.vQk.get(0)).vQn;
            cdnInfo.zoneports = new int[i2];
            for (i = 0; i < i2; i++) {
                cdnInfo.zoneports[i] = ((Integer) ((jq) jpVar.vQk.get(0)).vQo.get(i)).intValue();
            }
        }
        return cdnInfo;
    }

    public final boolean a(jp jpVar, jp jpVar2, jp jpVar3, byte[] bArr, byte[] bArr2, jp jpVar4) {
        x.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[]{this.hsh, jpVar, jpVar4, bh.cgy()});
        if (jpVar == null && bArr == null) {
            return false;
        }
        this.hsh = jpVar;
        try {
            CdnLogic.setLegacyCdnInfo(a(jpVar), a(jpVar2), a(jpVar3), a(jpVar4), bArr, bArr2);
            CdnLogic.setDebugIP("");
            if (r.idM && r.idD != null && r.idD.length() >= 7) {
                x.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", new Object[]{r.idD});
                CdnLogic.setDebugIP(r.idD);
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + e.getLocalizedMessage());
            return false;
        }
    }

    public static void a(c cVar) {
        x.i("MicroMsg.CdnTransportEngine", "set WXConfig:" + cVar);
        Config config = new Config();
        config.AckSlice = cVar.field_AckSlice;
        config.UseDynamicETL = cVar.field_UseDynamicETL;
        config.UseStreamCDN = cVar.field_UseStreamCDN;
        config.C2COverloadDelaySeconds = cVar.field_C2COverloadDelaySeconds;
        config.SNSOverloadDelaySeconds = cVar.field_SNSOverloadDelaySeconds;
        config.EnableCDNVerifyConnect = cVar.field_EnableCDNVerifyConnect;
        config.EnableCDNVideoRedirectOC = cVar.field_EnableCDNVideoRedirectOC;
        config.EnableStreamUploadVideo = cVar.field_EnableStreamUploadVideo;
        config.EnableSafeCDN = cVar.field_EnableSafeCDN;
        config.EnableSnsStreamDownload = cVar.field_EnableSnsStreamDownload;
        config.EnableSnsImageDownload = cVar.field_EnableSnsImageDownload;
        if (!bh.ov(cVar.field_ApprovedVideoHosts)) {
            config.ApprovedVideoHosts = cVar.field_ApprovedVideoHosts;
        }
        config.WifiEtl = cVar.field_WifiEtl;
        config.MobileEtl = cVar.field_noWifiEtl;
        config.onlyrecvPtl = cVar.field_onlyrecvPtl;
        config.onlysendETL = cVar.field_onlysendETL;
        config.Ptl = cVar.field_Ptl;
        CdnLogic.setConfig(config);
    }

    public final int keep_onUploadProgress(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo) {
        if (this.hsi != null) {
            x.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
            this.hsi.a(str, com_tencent_mm_modelcdntran_keep_ProgressInfo, null);
        }
        return 0;
    }

    public final int keep_onUploadError(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.hsi != null) {
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hsi.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        return 0;
    }

    public final int keep_onUploadSuccessed(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.hsi != null) {
            x.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[]{str});
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hsi.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        return 0;
    }

    public final int keep_onDownloadProgress(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo) {
        int a;
        if (this.hsn != null) {
            a = this.hsn.a(str, com_tencent_mm_modelcdntran_keep_ProgressInfo, null);
        } else {
            a = 0;
        }
        if (a == 0 && this.hsi != null) {
            this.hsi.a(str, com_tencent_mm_modelcdntran_keep_ProgressInfo, null);
        }
        return 0;
    }

    public final int keep_onDownloadError(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        int a;
        if (this.hsn != null) {
            a = this.hsn.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            a = 0;
        }
        if (a != 0) {
            x.e("MicroMsg.CdnTransportEngine", "keep_onDownloadError ret:%d, media%s", new Object[]{Integer.valueOf(a), str});
        } else if (this.hsi != null) {
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hsi.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            x.e("MicroMsg.CdnTransportEngine", "keep_onDownloadError cdnTransCallback is null, media%s", new Object[]{str});
        }
        return 0;
    }

    public final int keep_onDownloadSuccessed(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        int a;
        if (this.hsn != null) {
            a = this.hsn.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            a = 0;
        }
        if (a != 0) {
            x.e("MicroMsg.CdnTransportEngine", "keep_onDownloadSuccessed ret:%d, media%s", new Object[]{Integer.valueOf(a), str});
        } else if (this.hsi != null) {
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hsi.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            x.e("MicroMsg.CdnTransportEngine", "keep_onDownloadSuccessed cdnTransCallback is null, media%s", new Object[]{str});
        }
        return 0;
    }

    public final void keep_cdnGetSkeyBuf(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (this.hsi != null) {
            this.hsi.a(str, byteArrayOutputStream);
        }
    }

    public final byte[] keep_cdnDecodePrepareResponse(String str, byte[] bArr) {
        if (this.hsi != null) {
            return this.hsi.h(str, bArr);
        }
        return null;
    }

    public final void keep_onMoovReady(String str, int i, int i2) {
        x.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.hsn != null) {
            this.hsn.onMoovReady(str, i, i2);
        }
    }

    public final void keep_onDataAvailable(String str, int i, int i2) {
        x.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.hsn != null) {
            this.hsn.onDataAvailable(str, i, i2);
        }
    }

    public final void keep_onDownloadToEnd(String str, int i, int i2) {
        x.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.hsn != null) {
            this.hsn.onDownloadToEnd(str, i, i2);
        }
    }

    private static void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && !bh.ov(com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo)) {
            int indexOf = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo.indexOf("@,");
            if (indexOf > 0) {
                com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo.substring(indexOf + 2);
                com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo.substring(0, indexOf);
            }
            x.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
        }
    }

    public final void keep_cdnSendAndRecvData(String str, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            this.hsj += i;
            this.hsk += i2;
            if (!bh.ov(str)) {
                this.hsl = str;
            }
            if (this.hsj + this.hsk > 51200 && this.hsm != null) {
                this.hsm.J(500, 500);
            }
        }
    }

    public final void keep_OnRequestDoGetCdnDnsInfo(int i) {
        g.Dh();
        if (a.Cx()) {
            g.MG().hv(i + 1000);
        }
    }

    public final void onProgressChanged(String str, int i, int i2, boolean z) {
        keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo = new keep_ProgressInfo();
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength = i;
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength = i2;
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_status = 0;
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify = z;
        keep_onDownloadProgress(str, com_tencent_mm_modelcdntran_keep_ProgressInfo);
        keep_onUploadProgress(str, com_tencent_mm_modelcdntran_keep_ProgressInfo);
    }

    public final void onRecvedData(String str, int i, byte[] bArr) {
    }

    public final void RequestGetCDN(int i) {
        x.i("MicroMsg.CdnTransportEngine", "requestgetcdn %d", new Object[]{Integer.valueOf(i)});
        keep_OnRequestDoGetCdnDnsInfo(i);
    }

    public final void ReportFlow(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3)});
        keep_cdnSendAndRecvData("dummy clientmsgid", i2 + i4, i + i3);
    }

    private static int kG(String str) {
        int i = 0;
        x.i("MicroMsg.CdnTransportEngine", "ipFromString %s", new Object[]{str});
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            int i2 = 0;
            while (i2 < address.length) {
                i2++;
                i = (address[i2] & 255) | (i << 8);
            }
        } catch (UnknownHostException e) {
        }
        return i;
    }

    private static keep_SceneResult a(C2CDownloadResult c2CDownloadResult, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode = c2CDownloadResult.errorCode;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_argInfo = c2CDownloadResult.argInfo;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength = c2CDownloadResult.fileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId = c2CDownloadResult.fileid;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo = c2CDownloadResult.transforMsg;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline = false;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes = c2CDownloadResult.recvedBytes;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat = c2CDownloadResult.videoFormat;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_enQueueTime = c2CDownloadResult.enQueueTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime = c2CDownloadResult.startTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime = c2CDownloadResult.endTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCost = c2CDownloadResult.firstRequestCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestSize = c2CDownloadResult.firstRequestSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestDownloadSize = c2CDownloadResult.firstRequestDownloadSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCompleted = c2CDownloadResult.firstRequestCompleted;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_averageSpeed = c2CDownloadResult.averageSpeed;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_averageConnectCost = c2CDownloadResult.averageConnectCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstConnectCost = c2CDownloadResult.firstConnectCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_netConnectTimes = c2CDownloadResult.netConnectTimes;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovRequestTimes = c2CDownloadResult.moovRequestTimes;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCost = c2CDownloadResult.moovCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovSize = c2CDownloadResult.moovSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCompleted = c2CDownloadResult.moovCompleted;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovFailReason = c2CDownloadResult.moovFailReason;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode = c2CDownloadResult.httpStatusCode;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_httpResponseHeader = c2CDownloadResult.httpResponseHeader;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_delayTime = c2CDownloadResult.delayTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_dnsCostTime = c2CDownloadResult.dnsCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_connectCostTime = c2CDownloadResult.connectCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_waitResponseCostTime = c2CDownloadResult.waitResponseCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_receiveCostTime = c2CDownloadResult.receiveCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_clientIP = c2CDownloadResult.clientIP;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_serverIP = c2CDownloadResult.serverIP;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_clientHostIP = kG(c2CDownloadResult.clientIP);
        com_tencent_mm_modelcdntran_keep_SceneResult.field_serverHostIP = kG(c2CDownloadResult.serverIP);
        com_tencent_mm_modelcdntran_keep_SceneResult.field_xErrorNo = c2CDownloadResult.xErrorNo;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_cSeqCheck = c2CDownloadResult.cSeqCheck;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_usePrivateProtocol = c2CDownloadResult.usePrivateProtocol;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_isCrossNet = c2CDownloadResult.crossNet;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_clientIP = c2CDownloadResult.clientIP;
        if (c2CDownloadResult.usedSvrIps != null) {
            com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps = (String[]) c2CDownloadResult.usedSvrIps.clone();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_isResume = c2CDownloadResult.isResume;
        return com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
        com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode = c2CUploadResult.errorCode;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_toUser = c2CUploadResult.touser;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType = c2CUploadResult.hitCache;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId = c2CUploadResult.fileid;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey = c2CUploadResult.aeskey;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5 = c2CUploadResult.filemd5;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5 = c2CUploadResult.thumbfilemd5;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5 = c2CUploadResult.mp4identifymd5;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo = c2CUploadResult.transforMsg;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength = c2CUploadResult.fileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength = c2CUploadResult.midfileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength = c2CUploadResult.thumbfileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField = !c2CUploadResult.sendmsgFromCDN;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck = c2CUploadResult.existOnSvr;
        if (c2CUploadResult.skeyrespbuf != null) {
            com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf = (byte[]) c2CUploadResult.skeyrespbuf.clone();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId = c2CUploadResult.videofileid;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc = c2CUploadResult.fileCrc32;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn = c2CUploadResult.uploadBySafecdn;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_isVideoReduced = c2CUploadResult.isVideoReduced;
        if (c2CUploadResult.usedSvrIps != null) {
            com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps = (String[]) c2CUploadResult.usedSvrIps.clone();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl = c2CUploadResult.fileUrl;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl = c2CUploadResult.thumbfileUrl;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_isResume = c2CUploadResult.isResume;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_delayTime = c2CUploadResult.delayTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_connectCostTime = c2CUploadResult.connectCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_waitResponseCostTime = c2CUploadResult.waitResponseCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_receiveCostTime = c2CUploadResult.receiveCostTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_clientIP = c2CUploadResult.clientIP;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_serverIP = c2CUploadResult.serverIP;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_clientHostIP = kG(c2CUploadResult.clientIP);
        com_tencent_mm_modelcdntran_keep_SceneResult.field_serverHostIP = kG(c2CUploadResult.serverIP);
        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
            keep_onUploadError(str, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            keep_onUploadSuccessed(str, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
    }

    public final void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult) {
        keep_SceneResult a = a(c2CDownloadResult, null);
        if (a.field_retCode != 0) {
            keep_onDownloadError(str, a);
        } else {
            keep_onDownloadSuccessed(str, a);
        }
    }

    public final void onCheckFileidCompleted(String str, CheckFileIDResult checkFileIDResult) {
    }

    public final byte[] getSessionRequestBuf(String str, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        keep_cdnGetSkeyBuf(str, byteArrayOutputStream);
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public final byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        return keep_cdnDecodePrepareResponse(str, bArr);
    }

    public final void onMoovReady(String str, int i, int i2) {
        keep_onMoovReady(str, i, i2);
    }

    public final void onDataAvailable(String str, int i, int i2) {
        keep_onDataAvailable(str, i, i2);
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        keep_onDownloadToEnd(str, i, i2);
    }

    public final void onPreloadCompleted(String str, int i, int i2) {
    }

    public final void onPreloadCompletedWithResult(String str, int i, int i2, C2CDownloadResult c2CDownloadResult) {
        if (this.hsi != null) {
            this.hsi.b(str, a(c2CDownloadResult, null));
        }
    }
}
