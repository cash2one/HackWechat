package com.tencent.mm.plugin.downloader.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class CDNDownloadService extends Service implements a {
    private b lro;
    private final com.tencent.mm.plugin.downloader.a.a.a lrv = new com.tencent.mm.plugin.downloader.a.a.a(this) {
        final /* synthetic */ CDNDownloadService lrx;

        {
            this.lrx = r1;
        }

        public final int a(CDNTaskInfo cDNTaskInfo) {
            x.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[]{cDNTaskInfo.downloadUrl, cDNTaskInfo.filePath});
            i iVar = new i();
            iVar.htz = cDNTaskInfo.htz;
            iVar.field_mediaId = cDNTaskInfo.mediaId;
            iVar.field_fullpath = cDNTaskInfo.filePath;
            iVar.htu = cDNTaskInfo.downloadUrl;
            iVar.htA = cDNTaskInfo.lry;
            iVar.htt = this.lrx.lrw;
            iVar.htv = cDNTaskInfo.lrA;
            iVar.htw = cDNTaskInfo.lrB;
            iVar.allow_mobile_net_download = cDNTaskInfo.lrC;
            CDNDownloadService.a(iVar, cDNTaskInfo.lrz);
            int d = com.tencent.mm.plugin.downloader.c.a.azT().d(iVar);
            x.i("MicroMsg.CDNDownloadService", "addDownloadTask: " + d);
            return d;
        }

        public final int b(CDNTaskInfo cDNTaskInfo) {
            int resumeHttpMultiSocketDownloadTask;
            x.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[]{cDNTaskInfo.downloadUrl});
            i iVar = new i();
            iVar.htz = cDNTaskInfo.htz;
            iVar.field_mediaId = cDNTaskInfo.mediaId;
            iVar.field_fullpath = cDNTaskInfo.filePath;
            iVar.htu = cDNTaskInfo.downloadUrl;
            iVar.htA = cDNTaskInfo.lry;
            iVar.htt = this.lrx.lrw;
            iVar.htv = cDNTaskInfo.lrA;
            iVar.htw = cDNTaskInfo.lrB;
            iVar.allow_mobile_net_download = cDNTaskInfo.lrC;
            CDNDownloadService.a(iVar, cDNTaskInfo.lrz);
            com.tencent.mm.plugin.downloader.c.a azT = com.tencent.mm.plugin.downloader.c.a.azT();
            if (azT.hsu.containsKey(iVar.field_mediaId)) {
                resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(iVar.field_mediaId);
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[]{iVar.field_mediaId, Integer.valueOf(resumeHttpMultiSocketDownloadTask)});
            } else {
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[]{iVar.field_mediaId});
                resumeHttpMultiSocketDownloadTask = azT.d(iVar);
            }
            x.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: " + resumeHttpMultiSocketDownloadTask);
            return resumeHttpMultiSocketDownloadTask;
        }

        public final boolean xA(String str) {
            com.tencent.mm.plugin.downloader.c.a.azT();
            boolean xD = com.tencent.mm.plugin.downloader.c.a.xD(str);
            x.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: " + xD);
            return xD;
        }

        public final boolean xB(String str) {
            com.tencent.mm.plugin.downloader.c.a azT = com.tencent.mm.plugin.downloader.c.a.azT();
            i iVar = (i) azT.hsu.remove(str);
            if (iVar != null) {
                if (iVar.field_fileType == com.tencent.mm.modelcdntran.b.hrV || iVar.field_fileType == com.tencent.mm.modelcdntran.b.hrX) {
                    com.tencent.mm.modelcdntran.b.kE(str);
                } else if (iVar.htz) {
                    com.tencent.mm.modelcdntran.b.kF(str);
                } else {
                    com.tencent.mm.modelcdntran.b.kA(str);
                }
                g.pQN.h(10769, new Object[]{Integer.valueOf(d.hsO), Integer.valueOf(iVar.field_fileType), Long.valueOf(bh.Wp() - iVar.field_startTime)});
            }
            azT.hst.remove(str);
            azT.hsv.remove(str);
            x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[]{str, iVar, Integer.valueOf(0)});
            x.i("MicroMsg.CDNDownloadService", new StringBuilder("removeDownloadTask: true").toString());
            return true;
        }

        public final CDNTaskState xC(String str) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(str);
            if (httpMultiSocketDownloadTaskState == null) {
                return null;
            }
            CDNTaskState cDNTaskState = new CDNTaskState();
            cDNTaskState.taskState = httpMultiSocketDownloadTaskState.taskState;
            cDNTaskState.fileTotalSize = httpMultiSocketDownloadTaskState.fileTotalSize;
            cDNTaskState.completeSize = httpMultiSocketDownloadTaskState.completeSize;
            return cDNTaskState;
        }

        public final void a(b bVar) {
            x.i("MicroMsg.CDNDownloadService", "registerCallback");
            this.lrx.lro = bVar;
        }

        public final void b(b bVar) {
            this.lrx.lro = null;
        }

        public final void ow(int i) {
            x.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: " + i);
            BaseEvent.onNetworkChange();
        }

        public final void azQ() {
            if (!com.tencent.mm.ipcinvoker.wx_extension.b.b.a.BF().c(this.lrx)) {
                x.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
                com.tencent.mm.ipcinvoker.wx_extension.b.b.a.BF().a(this.lrx);
            }
        }

        public final void azR() {
            x.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
            com.tencent.mm.ipcinvoker.wx_extension.b.b.a.BF().b(this.lrx);
        }

        public final void azS() {
        }
    };
    private i.a lrw = new 2(this);

    static /* synthetic */ void a(i iVar, String str) {
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                iVar.htB = new HashMap();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    iVar.htB.put(str2, jSONObject.optString(str2));
                }
            } catch (JSONException e) {
                x.e("MicroMsg.CDNDownloadService", "addVerifyHeaders: " + e.getMessage());
            }
        }
    }

    static /* synthetic */ void a(CDNDownloadService cDNDownloadService, String str, int i, int i2) {
        x.i("MicroMsg.CDNDownloadService", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), null});
        try {
            cDNDownloadService.lro.d(str, i, i2, null);
        } catch (RemoteException e) {
            x.e("MicroMsg.CDNDownloadService", "updateDownloadState: " + e);
        }
    }

    static /* synthetic */ void a(CDNDownloadService cDNDownloadService, String str, long j, long j2) {
        try {
            cDNDownloadService.lro.i(str, j, j2);
        } catch (RemoteException e) {
            x.e("MicroMsg.CDNDownloadService", "updateProgressChange: " + e);
        }
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.CDNDownloadService", "onBind");
        return this.lrv;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.CDNDownloadService", "onUnbind");
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.CDNDownloadService", "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.CDNDownloadService", "onDestroy");
        com.tencent.mm.ipcinvoker.wx_extension.b.b.a.BF().b(this);
        com.tencent.mm.plugin.downloader.c.a azT = com.tencent.mm.plugin.downloader.c.a.azT();
        Iterator it = azT.hst.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = (String) entry.getKey();
            if (((i) entry.getValue()).htz) {
                azT.hst.remove(str);
                azT.hsv.remove(str);
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra mapWaitTask cancelAllGamePacketDownloadTask mediaid:%s", new Object[]{str});
                it.remove();
            }
        }
        Iterator it2 = azT.hsu.entrySet().iterator();
        while (it2.hasNext()) {
            entry = (Entry) it2.next();
            str = (String) entry.getKey();
            if (((i) entry.getValue()).htz) {
                com.tencent.mm.modelcdntran.b.kF(str);
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra mapTaskInJni cancelAllGamePacketDownloadTask mediaid:%s  ret:%d", new Object[]{str, Integer.valueOf(0)});
                it2.remove();
            }
        }
        g.pQN.a(710, 1, 1, false);
    }
}
