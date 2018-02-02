package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

class p$1 extends Handler {
    p$1(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case 100:
                boolean z2 = message.arg1 == 1;
                z = p.cEA();
                if (message.obj != null && (message.obj instanceof p$a)) {
                    TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + z);
                    if (!z || z2) {
                        ((p$a) message.obj).g(z, o.gG(p.cEB()).zXm.getInt("tbs_download_version", 0));
                    }
                }
                if (x.hq(p.cEB()) && z) {
                    p.gI(p.cEB());
                    return;
                }
                return;
            case 101:
            case 108:
                FileLock fileLock = null;
                FileOutputStream c = f.c(p.cEB(), false, "tbs_download_lock_file" + o.gG(p.cEB()).zXm.getInt("tbs_download_version", 0) + ".txt");
                if (c != null) {
                    fileLock = f.a(c);
                    if (fileLock == null) {
                        TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                        o.gG(p.cEB()).HU(-203);
                        TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                        return;
                    }
                } else if (f.hR(p.cEB())) {
                    o.gG(p.cEB()).HU(-204);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                    return;
                }
                boolean z3 = message.arg1 == 1;
                o gG = o.gG(p.cEB());
                if (!p.Y(z3, 108 == message.what)) {
                    QbSdk.zWf.ly(110);
                } else if (z3 && t.cEF().ap(p.cEB(), o.gG(p.cEB()).zXm.getInt("tbs_download_version", 0))) {
                    QbSdk.zWf.ly(122);
                    gG.HU(-213);
                } else if (gG.zXm.getBoolean("tbs_needdownload", false)) {
                    o.gG(p.cEB()).HU(-215);
                    l cEC = p.cEC();
                    if (108 != message.what) {
                        z = false;
                    }
                    cEC.W(z3, z);
                } else {
                    QbSdk.zWf.ly(110);
                }
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                f.a(fileLock, c);
                return;
            case 102:
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                int cEW = x.hq(p.cEB()) ? x.cEW() : t.cEF().ha(p.cEB());
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + cEW);
                l cEC2 = p.cEC();
                try {
                    File file = new File(cEC2.zWI, "x5.tbs");
                    int c2 = a.c(cEC2.mContext, file);
                    if (-1 == c2 || (cEW > 0 && cEW == c2)) {
                        file.delete();
                    }
                } catch (Exception e) {
                }
                v.hn(p.cEB()).cEK();
                return;
            case 103:
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                if (message.arg1 == 0) {
                    t.cEF().w((Context) message.obj, true);
                    return;
                } else {
                    t.cEF().w((Context) message.obj, false);
                    return;
                }
            case 104:
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                v.hn(p.cEB()).cEM();
                return;
            default:
                return;
        }
    }
}
