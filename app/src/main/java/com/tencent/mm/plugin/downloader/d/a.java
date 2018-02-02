package com.tencent.mm.plugin.downloader.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.plugin.downloader.ipc.CDNDownloadService;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
    private static a lrg;
    private long lrh = 0;
    long lri = 0;
    com.tencent.mm.plugin.downloader.a.a lrj;
    Set<CDNTaskInfo> lrk = new com.tencent.mm.plugin.downloader.model.a(new 1(this));
    public b lrl;
    private ServiceConnection lrm = new ServiceConnection(this) {
        final /* synthetic */ a lrq;

        {
            this.lrq = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
            this.lrq.lrj = com.tencent.mm.plugin.downloader.a.a.a.H(iBinder);
            a aVar = this.lrq;
            try {
                x.i("MicroMsg.CDNDownloadClient", "registerCallback");
                aVar.lrj.a(aVar.lro);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "registerCallback: " + e.getMessage());
            }
            a.c(this.lrq);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
            if (this.lrq.lrk.size() != 0) {
                for (CDNTaskInfo cDNTaskInfo : this.lrq.lrk) {
                    cDNTaskInfo.lrD = true;
                }
            }
        }
    };
    ak lrn = new ak(com.tencent.mm.bz.a.cll().getLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ a lrq;

        {
            this.lrq = r1;
        }

        public final boolean uF() {
            boolean z;
            x.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
            if (this.lrq.lrk.size() == 0) {
                return false;
            }
            if (this.lrq.lrj != null) {
                try {
                    x.d("MicroMsg.CDNDownloadClient", "checkActive");
                    this.lrq.lrj.azS();
                } catch (RemoteException e) {
                    x.e("MicroMsg.CDNDownloadClient", "check process active false");
                    g.pQN.a(710, 3, 1, false);
                    if (System.currentTimeMillis() - this.lrq.lri > 120000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.lrq.lri = System.currentTimeMillis();
                        for (CDNTaskInfo cDNTaskInfo : this.lrq.lrk) {
                            cDNTaskInfo.lrD = true;
                        }
                        this.lrq.azV();
                        return true;
                    }
                    x.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
                    g.pQN.a(710, 4, 1, false);
                    for (CDNTaskInfo cDNTaskInfo2 : this.lrq.lrk) {
                        this.lrq.lrl.e(cDNTaskInfo2.downloadUrl, 4, d.lrW, null);
                    }
                    this.lrq.lrk.clear();
                    return false;
                }
            }
            return true;
        }
    }, true);
    b lro = new 4(this);
    private com.tencent.mm.network.n.a lrp = new 5(this);
    private Context mContext = ac.getContext();

    static /* synthetic */ void a(a aVar) {
        if (aVar.lrj != null) {
            try {
                aVar.lrj.azR();
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "removeIPCTaskMarker: " + e);
            }
        }
    }

    static /* synthetic */ void b(a aVar) {
        x.i("MicroMsg.CDNDownloadClient", "stopCheckProcessActiveTimer");
        aVar.lrn.TG();
    }

    static /* synthetic */ void c(a aVar) {
        x.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected");
        if (aVar.lrk.size() > 0) {
            aVar.azQ();
        }
        for (CDNTaskInfo cDNTaskInfo : aVar.lrk) {
            x.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected, url: %s, resume: %b", new Object[]{cDNTaskInfo.downloadUrl, Boolean.valueOf(cDNTaskInfo.lrD)});
            try {
                if (cDNTaskInfo.lrD) {
                    aVar.lrj.b(cDNTaskInfo);
                } else {
                    aVar.lrj.a(cDNTaskInfo);
                }
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected: " + e);
                g.pQN.a(710, 0, 1, false);
            }
        }
    }

    public static synchronized a azU() {
        a aVar;
        synchronized (a.class) {
            if (lrg == null) {
                lrg = new a();
            }
            aVar = lrg;
        }
        return aVar;
    }

    public a() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().a(this.lrp);
        azV();
    }

    final synchronized void azV() {
        try {
            x.i("MicroMsg.CDNDownloadClient", "bindService: " + this.mContext.bindService(new Intent(this.mContext, CDNDownloadService.class), this.lrm, 1));
        } catch (Exception e) {
            x.e("MicroMsg.CDNDownloadClient", "bindService: " + e.getMessage());
        }
    }

    public final int a(CDNTaskInfo cDNTaskInfo) {
        if (cDNTaskInfo == null || bh.ov(cDNTaskInfo.downloadUrl)) {
            x.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
            return -1;
        }
        x.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[]{cDNTaskInfo.filePath, cDNTaskInfo.downloadUrl});
        if (this.lrk.contains(cDNTaskInfo)) {
            x.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
            return -2;
        }
        if (this.lrj != null) {
            try {
                int a = this.lrj.a(cDNTaskInfo);
                if (a == 0 || a == -2) {
                    this.lrk.add(cDNTaskInfo);
                }
                return a;
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + e.getMessage());
            }
        }
        this.lrk.add(cDNTaskInfo);
        azV();
        return 0;
    }

    public final boolean xA(String str) {
        boolean z = false;
        x.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: " + str);
        if (bh.ov(str)) {
            x.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
        } else {
            if (this.lrj != null) {
                try {
                    this.lrk.remove(new CDNTaskInfo(str));
                    z = this.lrj.xA(str);
                } catch (RemoteException e) {
                    x.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + e.getMessage());
                }
            }
            x.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
        }
        return z;
    }

    public final int b(CDNTaskInfo cDNTaskInfo) {
        if (cDNTaskInfo == null || bh.ov(cDNTaskInfo.downloadUrl)) {
            x.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
            return -1;
        }
        x.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + cDNTaskInfo.downloadUrl);
        cDNTaskInfo.lrD = true;
        if (this.lrj != null) {
            try {
                int b = this.lrj.b(cDNTaskInfo);
                if (b != 0 && b != -2) {
                    return b;
                }
                this.lrk.add(cDNTaskInfo);
                return b;
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + e.getMessage());
            }
        }
        this.lrk.add(cDNTaskInfo);
        azV();
        return 0;
    }

    public final boolean xB(String str) {
        boolean z = false;
        x.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: " + str);
        if (bh.ov(str)) {
            x.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
        } else {
            if (this.lrj != null) {
                try {
                    this.lrk.remove(new CDNTaskInfo(str));
                    z = this.lrj.xB(str);
                } catch (RemoteException e) {
                    x.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + e.getMessage());
                }
            }
            x.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
        }
        return z;
    }

    public final CDNTaskState xC(String str) {
        CDNTaskState cDNTaskState = null;
        if (bh.ov(str)) {
            x.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
        } else if (this.lrj != null) {
            try {
                cDNTaskState = this.lrj.xC(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + e.getMessage());
            }
        }
        return cDNTaskState;
    }

    final void azQ() {
        if (this.lrj != null) {
            try {
                this.lrj.azQ();
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: " + e);
            }
        }
    }
}
