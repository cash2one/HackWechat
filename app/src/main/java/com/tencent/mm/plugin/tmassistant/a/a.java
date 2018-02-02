package com.tencent.mm.plugin.tmassistant.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.support.v4.app.z;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader.model.j;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends j {
    private byte[] gSF = new byte[0];
    private TMAssistantDownloadSDKClient mClient = null;
    Context mContext = ac.getContext();
    ak nlz = new ak(Looper.getMainLooper(), new 4(this), false);
    private HashMap<String, Long> sdI = new HashMap();
    HashMap<String, Long> sdJ = new HashMap();
    private ConcurrentHashMap<String, Integer> sdK = new ConcurrentHashMap();
    HashSet<Long> sdL = new HashSet();
    Map<String, String> sdM = null;
    private ITMAssistantDownloadSDKClientListener sdN = new ITMAssistantDownloadSDKClientListener(this) {
        final /* synthetic */ a sdR;

        {
            this.sdR = r1;
        }

        public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
            Iterator it = this.sdR.sdL.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.e.a ce = e.ce(((Long) it.next()).longValue());
                if (ce != null) {
                    ce.field_status = 4;
                    ce.field_errCode = d.lrQ;
                    e.c(ce);
                    a.a(4, ce.field_downloadId, "", d.lrQ, false);
                    a.a(this.sdR, ce.field_downloadUrl, 5, 0, false);
                }
            }
            this.sdR.sdL.clear();
            a.a(101, 0, "");
        }

        public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i + " | ErrorCode: " + i2 + " | ErrorMsg: " + str2);
            com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
            if (xH == null) {
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                return;
            }
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", new Object[]{Integer.valueOf(i), Long.valueOf(xH.field_downloadId), xH.field_filePath, Boolean.valueOf(new File(xH.field_filePath).exists()), str});
            switch (i) {
                case 1:
                    return;
                case 2:
                    e.j(xH.field_downloadId, 1);
                    return;
                case 3:
                    e.j(xH.field_downloadId, 2);
                    this.sdR.cancelNotification(str);
                    this.sdR.sdL.remove(Long.valueOf(xH.field_downloadId));
                    return;
                case 4:
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                    if (z2) {
                        b gtVar = new gt();
                        gtVar.fwS.appId = xH.field_appId;
                        gtVar.fwS.opType = 6;
                        com.tencent.mm.sdk.b.a.xef.m(gtVar);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.lsG, 1);
                    intent.setClass(this.sdR.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, xH.field_downloadId);
                    intent.putExtra(FileDownloadService.lsJ, z);
                    try {
                        this.sdR.mContext.startService(intent);
                    } catch (Exception e) {
                        x.e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                    }
                    this.sdR.cancelNotification(str);
                    this.sdR.sdL.remove(Long.valueOf(xH.field_downloadId));
                    return;
                case 5:
                    a.a(this.sdR, str, i, 0, false);
                    this.sdR.sdL.remove(Long.valueOf(xH.field_downloadId));
                    xH.field_errCode = i2;
                    xH.field_status = 4;
                    e.c(xH);
                    a.a(4, xH.field_downloadId, "", i2, z);
                    if (i2 == 601 || i2 == 602 || i2 == 603 || i2 == 605 || i2 == 606) {
                        x.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
                        this.sdR.nlz.J(240000, 240000);
                        return;
                    }
                    return;
                case 6:
                    this.sdR.cancelNotification(str);
                    this.sdR.sdL.remove(Long.valueOf(xH.field_downloadId));
                    e.j(xH.field_downloadId, 5);
                    a.a(5, xH.field_downloadId, "", 0, false);
                    return;
                default:
                    return;
            }
        }

        public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            Long l = (Long) this.sdR.sdJ.get(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (l == null || valueOf.longValue() - l.longValue() >= 500) {
                this.sdR.sdJ.put(str, valueOf);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
                a.a(this.sdR, str, 2, (int) ((100 * j) / j2), false);
                com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
                if (xH == null) {
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                    return;
                }
                long j3 = xH.field_downloadId;
                com.tencent.mm.plugin.downloader.e.b Fe = e.Fe();
                if (Fe != null) {
                    Fe.fx("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j + ",totalSize= " + j2 + " where downloadId = " + j3);
                }
                a.a(7, xH.field_downloadId, "", 0, false);
            }
        }
    };

    static /* synthetic */ TMAssistantDownloadSDKClient a(a aVar) {
        if (aVar.mClient == null) {
            aVar.mClient = TMAssistantDownloadSDKManager.getInstance(aVar.mContext).getDownloadSDKClient("WechatDownloadClient");
            aVar.mClient.registerDownloadTaskListener(aVar.sdN);
        }
        aVar.nlz.J(240000, 240000);
        return aVar.mClient;
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH == null) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
        } else if (xH.field_showNotification) {
            z.d dVar = new z.d(aVar.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.sdI.put(str, Long.valueOf(currentTimeMillis));
                dVar.c(currentTimeMillis);
            } else {
                Long l = (Long) aVar.sdI.get(str);
                if (l != null) {
                    dVar.c(l.longValue());
                }
            }
            dVar.a(xH.field_fileName);
            switch (i) {
                case 1:
                case 2:
                case 3:
                    dVar.U(17301633);
                    dVar.a(100, i2, i2 == 0);
                    dVar.b(aVar.mContext.getString(R.l.ehe));
                    dVar.c(2, true);
                    long j = xH.field_downloadId;
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.sa = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, SQLiteDatabase.CREATE_IF_NECESSARY);
                    break;
                case 4:
                case 6:
                    aVar.cancelNotification(str);
                    return;
                case 5:
                    dVar.U(17301634);
                    dVar.n(true);
                    dVar.sa = PendingIntent.getActivity(ac.getContext(), 0, new Intent(), 0);
                    dVar.b(aVar.mContext.getString(R.l.ehd));
                    break;
            }
            synchronized (aVar.gSF) {
                if (z) {
                    aVar.sdK.put(str, Integer.valueOf(ar.getNotification().b(dVar.build())));
                } else {
                    Integer num = (Integer) aVar.sdK.get(str);
                    if (num != null) {
                        ar.getNotification().notify(num.intValue(), dVar.build());
                    }
                }
            }
        }
    }

    public a() {
        super(null);
        Map hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        x.i("MicroMsg.FileDownloaderImplTMAssistant", property);
        if (bh.ov(property)) {
            property = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
        }
        property = property + " MicroMessenger";
        PackageInfo packageInfo = getPackageInfo(this.mContext, ac.getPackageName());
        if (packageInfo != null) {
            property = ((property + "/") + packageInfo.versionName) + "." + packageInfo.versionCode;
        }
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", new Object[]{property + " NetType/" + an.getNetTypeString(ac.getContext())});
        hashMap.put("User-Agent", property);
        this.sdM = hashMap;
    }

    public final long a(g gVar) {
        if (gVar == null || bh.ov(gVar.iFI)) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            return -1;
        }
        String str = gVar.iFI;
        String str2 = gVar.lsv;
        long j = gVar.lsw;
        boolean z = gVar.lsC;
        String str3 = gVar.mAppId;
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH != null) {
            FileDownloadTaskInfo bY = bY(xH.field_downloadId);
            if (bY.status == 1) {
                return bY.id;
            }
        }
        bFj();
        e.xF(str);
        e.xG(str3);
        com.tencent.mm.plugin.downloader.e.a b = h.b(gVar);
        b.field_downloadId = System.currentTimeMillis();
        b.field_status = 0;
        b.field_downloaderType = 2;
        b.field_startTime = System.currentTimeMillis();
        if (xH == null) {
            b.field_startState = 0;
        } else if (xH.field_status == 2) {
            b.field_startState = 2;
        } else if (xH.field_status == 4) {
            b.field_startState = 4;
        } else {
            b.field_startState = 0;
        }
        e.b(b);
        ar.Dm().F(new 1(this, gVar, b, str, str2, j, z));
        return b.field_downloadId;
    }

    public final int bX(long j) {
        ar.Dm().F(new 2(this, j));
        return 1;
    }

    public final FileDownloadTaskInfo bY(long j) {
        final FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        final com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || bh.ov(ce.field_downloadUrl)) {
            return fileDownloadTaskInfo;
        }
        fileDownloadTaskInfo.url = ce.field_downloadUrl;
        fileDownloadTaskInfo.status = ce.field_status;
        fileDownloadTaskInfo.path = ce.field_filePath;
        fileDownloadTaskInfo.fwf = ce.field_downloadedSize;
        fileDownloadTaskInfo.fwg = ce.field_totalSize;
        fileDownloadTaskInfo.fqR = ce.field_md5;
        return (FileDownloadTaskInfo) new bc<FileDownloadTaskInfo>(this, fileDownloadTaskInfo) {
            final /* synthetic */ a sdR;

            protected final /* synthetic */ Object run() {
                return bFk();
            }

            private FileDownloadTaskInfo bFk() {
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.sdR).getDownloadTaskState(fileDownloadTaskInfo.url);
                    if (downloadTaskState == null) {
                        if (fileDownloadTaskInfo.status == 1) {
                            fileDownloadTaskInfo.status = 0;
                        }
                        return fileDownloadTaskInfo;
                    }
                    switch (downloadTaskState.mState) {
                        case 1:
                        case 2:
                            fileDownloadTaskInfo.status = 1;
                            break;
                        case 3:
                            fileDownloadTaskInfo.status = 2;
                            break;
                        case 4:
                            fileDownloadTaskInfo.status = 3;
                            break;
                        case 5:
                            fileDownloadTaskInfo.status = 4;
                            break;
                        case 6:
                            fileDownloadTaskInfo.status = 5;
                            break;
                        default:
                            fileDownloadTaskInfo.status = 0;
                            break;
                    }
                    fileDownloadTaskInfo.path = downloadTaskState.mSavePath;
                    fileDownloadTaskInfo.fwf = downloadTaskState.mReceiveDataLen;
                    fileDownloadTaskInfo.fwg = downloadTaskState.mTotalDataLen;
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", new Object[]{ce.field_appId, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path});
                    return fileDownloadTaskInfo;
                } catch (Exception e) {
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e.toString());
                }
            }
        }.b(ar.Dm().cfF());
    }

    final boolean bFi() {
        if (this.sdL == null || this.sdL.size() == 0) {
            TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
            if (this.mClient != null) {
                this.mClient.unRegisterDownloadTaskListener(this.sdN);
            }
            this.mClient = null;
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
            try {
                this.mContext.stopService(new Intent(this.mContext, TMAssistantDownloadSDKService.class));
            } catch (Exception e) {
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e.toString());
            }
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            return true;
        }
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        return false;
    }

    final void cancelNotification(String str) {
        synchronized (this.gSF) {
            Integer num = (Integer) this.sdK.get(str);
            if (num == null) {
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                return;
            }
            ar.getNotification().cancel(num.intValue());
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = " + num);
            this.sdK.remove(str);
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    private static void bFj() {
        if (!new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").exists()) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", new Object[]{Boolean.valueOf(new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").mkdirs())});
        }
    }

    public final boolean bZ(long j) {
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || bh.ov(ce.field_downloadUrl)) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (ce.field_downloaderType != 2) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            com.tencent.mm.loader.stub.b.deleteFile(ce.field_filePath);
            e.cf(j);
            return false;
        } else {
            ar.Dm().F(new 6(this, ce, j));
            return true;
        }
    }

    public final boolean ca(long j) {
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || bh.ov(ce.field_downloadUrl)) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (ce.field_downloaderType != 2) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            com.tencent.mm.loader.stub.b.deleteFile(ce.field_filePath);
            e.cf(j);
            return false;
        } else {
            ce.field_startTime = System.currentTimeMillis();
            if (ce.field_status == 2) {
                ce.field_startState = d.lse;
            } else if (ce.field_status == 4) {
                ce.field_startState = d.lsg;
            } else {
                ce.field_startState = 0;
            }
            ce.field_startSize = ce.field_downloadedSize;
            ce.field_errCode = 0;
            bFj();
            ar.Dm().F(new 7(this, ce, j));
            return true;
        }
    }

    static void a(int i, long j, String str) {
        a(i, j, str, 0, false);
    }

    private static void a(int i, long j, String str, int i2, boolean z) {
        b fzVar = new fz();
        fzVar.fvY.fvZ = i;
        fzVar.fvY.id = j;
        fzVar.fvY.errCode = i2;
        fzVar.fvY.path = str;
        fzVar.fvY.fwa = z;
        com.tencent.mm.sdk.b.a.xef.m(fzVar);
    }
}
