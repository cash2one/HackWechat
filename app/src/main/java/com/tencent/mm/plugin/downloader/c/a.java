package com.tencent.mm.plugin.downloader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.b$b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements b$b {
    private static a lrd = null;
    private ag gQF = new ag();
    Queue<String> hss = new LinkedList();
    public Map<String, i> hst = new ConcurrentHashMap();
    public Map<String, i> hsu = new ConcurrentHashMap();
    public Map<String, Integer> hsv = new ConcurrentHashMap();
    private String hsw = "";
    private long hsx = 0;
    public HashSet<String> hsy = new HashSet();
    b lre = new b(ac.getContext().getFilesDir() + "/NativeCDNInfo", this);

    static /* synthetic */ boolean a(keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo) {
        return com_tencent_mm_modelcdntran_keep_ProgressInfo == null || com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
    }

    public static synchronized a azT() {
        a aVar;
        synchronized (a.class) {
            if (lrd == null) {
                lrd = new a();
            }
            aVar = lrd;
        }
        return aVar;
    }

    public final int d(i iVar) {
        if (bh.ov(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
            return -1;
        }
        if (iVar.field_fileId == null) {
            iVar.field_fileId = "";
        }
        if (iVar.field_aesKey == null) {
            iVar.field_aesKey = "";
        }
        if (this.hss.contains(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
            return -2;
        } else if (this.hst.containsKey(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
            return -2;
        } else if (this.hsu.containsKey(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
            return -2;
        } else {
            iVar.fLH = false;
            this.gQF.F(new 1(this, -1, iVar));
            return 0;
        }
    }

    public static boolean xD(String str) {
        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[]{str, Integer.valueOf(CdnLogic.pauseHttpMultiSocketDownloadTask(str))});
        if (CdnLogic.pauseHttpMultiSocketDownloadTask(str) == 0) {
            return true;
        }
        return false;
    }

    public final int a(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
            return -2;
        } else {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                x.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify)});
            }
            this.hsx = bh.Wp();
            this.hsw = str;
            this.gQF.F(new 2(this, str, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult));
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        i iVar = (i) this.hsu.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[]{str});
        } else if (iVar.htt != null) {
            iVar.htt.a(str, byteArrayOutputStream);
        } else {
            x.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] h(String str, byte[] bArr) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        i iVar = (i) this.hsu.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[]{str});
            return null;
        } else if (iVar.htt != null) {
            return iVar.htt.h(str, bArr);
        } else {
            x.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void b(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (!bh.ov(str)) {
            this.gQF.F(new 3(this, str, com_tencent_mm_modelcdntran_keep_SceneResult));
        }
    }
}
