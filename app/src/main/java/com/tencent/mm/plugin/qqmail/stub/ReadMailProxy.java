package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy extends a {
    private p.a ppq;
    private p.a pqd;
    private b pqe;
    private c pqf;
    private o pqg = new 1(this);
    private i.a pqh = new 2(this);

    public ReadMailProxy(d dVar, p.a aVar) {
        super(dVar);
        this.ppq = aVar;
        this.pqd = new 3(this);
    }

    public ReadMailProxy(d dVar, p.a aVar, b bVar, c cVar) {
        super(dVar);
        this.ppq = aVar;
        this.pqe = bVar;
        this.pqf = cVar;
        this.pqd = new 4(this);
    }

    @e
    public boolean onReady() {
        if (this.ppq == null) {
            return true;
        }
        return this.ppq.onReady();
    }

    @e
    public void onSuccess(String str, Map<String, String> map) {
        if (this.ppq != null) {
            this.ppq.onSuccess(str, map);
        }
    }

    @e
    public void onError(int i, String str) {
        if (this.ppq != null) {
            this.ppq.onError(i, str);
        }
    }

    @e
    public void onComplete() {
        if (this.ppq != null) {
            this.ppq.onComplete();
        }
    }

    @e
    public void onTaskStarted(long j, String str) {
        if (this.pqe != null) {
            b bVar = this.pqe;
            x.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[]{Long.valueOf(j), str});
            bVar.puG.gZO = ac.getContext().getSharedPreferences("QQMAIL", 4);
            if (bVar.puG.gZO != null) {
                bVar.puG.gZO.edit().putString("qqmail_downloadpath", str).commit();
            }
        }
    }

    @e
    public void onTaskRemoved(long j) {
        if (this.pqe != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskPaused(long j) {
        if (this.pqe != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFinished(long j) {
        if (this.pqe != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFailed(long j) {
        if (this.pqe != null) {
            x.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @f
    public long get(String str, Map map, Bundle bundle) {
        p.c cVar = new p.c();
        cVar.fromBundle(bundle);
        return w.bks().b(str, map, cVar, this.pqd);
    }

    @f
    public long post(String str, Map map, Bundle bundle) {
        p.c cVar = new p.c();
        cVar.fromBundle(bundle);
        return w.bks().a(str, map, cVar, this.pqd);
    }

    @f
    public void cancel(final long j) {
        new af().post(new Runnable(this) {
            final /* synthetic */ ReadMailProxy pqi;

            public final void run() {
                w.bks().cancel(j);
            }
        });
    }

    @f
    public boolean isSDCardAvailable() {
        ar.Hg();
        return com.tencent.mm.z.c.isSDCardAvailable();
    }

    @f
    public String getMsgContent(long j) {
        ar.Hg();
        return com.tencent.mm.z.c.Fa().dH(j).field_content;
    }

    @f
    public void replaceMsgContent(long j, String str) {
        new af().post(new 6(this, j, str));
    }

    @f
    public Map getCookie() {
        return w.bks().getCookie();
    }

    @f
    public void deleteMsgById(long j) {
        ar.Hg();
        com.tencent.mm.z.c.Fa().dI(j);
    }

    @f
    public String getUserBindEmail() {
        return q.getUserBindEmail();
    }

    @f
    public void addDownloadCallback() {
        com.tencent.mm.plugin.downloader.model.f.aAd();
        com.tencent.mm.plugin.downloader.model.c.c(this.pqg);
    }

    @f
    public void removeDownloadCallback() {
        com.tencent.mm.plugin.downloader.model.f.aAd();
        com.tencent.mm.plugin.downloader.model.c.aAa();
    }

    @f
    public long downloadQQMailApp(String str, String str2) {
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            g.a aVar = new g.a();
            aVar.xL(toURL.toString());
            aVar.xN("qqmail.apk");
            aVar.xO(str2);
            aVar.ep(true);
            aVar.ox(1);
            return com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar.lsE);
        } catch (Throwable e) {
            x.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.ReadMailProxy", e, "", new Object[0]);
            return -1;
        }
    }

    @f
    public int removeDownloadQQMailAppTask(long j) {
        return com.tencent.mm.plugin.downloader.model.f.aAd().bX(j);
    }

    @f
    public String getBindUin() {
        ar.Hg();
        return new com.tencent.mm.a.o(bh.e((Integer) com.tencent.mm.z.c.CU().get(9, null))).toString();
    }

    @f
    public Integer showMailAppRecommend() {
        if (com.tencent.mm.sdk.platformtools.f.fdS == 1) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zZ().F("MailApp", "ShowMailAppRecommend"), 0));
    }

    @f
    public String getMailAppEnterUlAndroid() {
        return com.tencent.mm.k.g.zZ().getMailAppEnterUlAndroid();
    }

    @f
    public String getMailAppRedirectUrlAndroid() {
        return com.tencent.mm.k.g.zZ().zO();
    }

    @f
    public Integer getMailAppDownloadStatus(long j) {
        return Integer.valueOf(com.tencent.mm.plugin.downloader.model.f.aAd().bY(j).status);
    }

    @f
    public double getMailAppDownloadProgress(long j) {
        FileDownloadTaskInfo bY = com.tencent.mm.plugin.downloader.model.f.aAd().bY(j);
        if (bY.fwg <= 0) {
            return 0.0d;
        }
        return (1.0d * ((double) bY.fwf)) / ((double) bY.fwg);
    }

    @f
    public void reportKvState(int i, int i2) {
        com.tencent.mm.plugin.report.service.g.pQN.h(i, new Object[]{Integer.valueOf(i2)});
    }

    @f
    public void reportKvStates(int i, int i2, int i3) {
        com.tencent.mm.plugin.report.service.g.pQN.h(i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    @f
    public void getUnreadMailCount() {
        i.a(this.pqh);
    }

    @f
    public Object getUneradMailCountFromConfig() {
        ar.Hg();
        return com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xnV, Integer.valueOf(-1));
    }
}
