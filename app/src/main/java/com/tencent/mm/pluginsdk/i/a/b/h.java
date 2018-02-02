package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.b.b.b;
import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.o;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class h implements com.tencent.mm.pluginsdk.i.a.d.h {
    h() {
    }

    public final void a(q qVar, int i) {
        if (qVar.field_expireTime != 0 && qVar.field_expireTime <= bh.Wo()) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[]{qVar.field_urlKey, Long.valueOf(qVar.field_expireTime)});
            o bZC = a.bZC();
            String str = qVar.field_urlKey;
            if (bZC.iYd) {
                bZC.vhU.iF(str);
            }
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath);
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath + ".decompressed");
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath + ".decrypted");
            a.bZC().RY(qVar.field_urlKey);
        } else if (i == 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
        } else if (2 == i && 1 == qVar.field_networkType) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
        } else if (qVar.field_deleted) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[]{qVar.field_urlKey});
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath);
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath + ".decompressed");
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath + ".decrypted");
        } else if (qVar.field_status == 2) {
            long Gr = com.tencent.mm.pluginsdk.i.a.e.a.Gr(qVar.field_filePath);
            if (qVar.field_contentLength > Gr) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == Gr) {
                    if (!qVar.field_needRetry) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[]{Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion});
                        return;
                    } else if (1 != i) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        return;
                    } else {
                        for (b bVar : c.bZm().bZk()) {
                            int i2 = qVar.field_resType;
                            i2 = qVar.field_subType;
                            bh.getInt(qVar.field_fileVersion, 0);
                            if (bVar.bZl()) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[]{bVar.getClass().getName(), Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion});
                                return;
                            }
                        }
                        qVar.field_fileUpdated = true;
                        c.bZm().f(qVar.field_resType, qVar.field_subType, 0, bh.ou(qVar.field_groupId2).equals("NewXml"));
                        a.bZC().e(qVar);
                    }
                }
                a.bZC().d(c.b(qVar));
            } else if (c(qVar)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                d(qVar);
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                b(qVar, 1 == i);
            }
        } else if (qVar.field_status == 1 || qVar.field_status == 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[]{Long.valueOf(qVar.field_contentLength)});
            if (a.bZC().RX(qVar.field_urlKey)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                return;
            }
            x.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (c(qVar)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                qVar.field_status = 2;
                qVar.field_contentLength = com.tencent.mm.pluginsdk.i.a.e.a.Gr(qVar.field_filePath);
                a.bZC().e(qVar);
                d(qVar);
                return;
            }
            if (0 == com.tencent.mm.pluginsdk.i.a.e.a.Gr(qVar.field_filePath)) {
                qVar.field_fileUpdated = true;
                a.bZC().e(qVar);
                c.bZm().f(qVar.field_resType, qVar.field_subType, 0, bh.ou(qVar.field_groupId2).equals("NewXml"));
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            a.bZC().d(c.b(qVar));
        } else if (qVar.field_status == 4 || qVar.field_status == 3) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
            qVar.field_status = 0;
            b(qVar, true);
        }
    }

    private static boolean c(q qVar) {
        return bh.ou(g.bV(qVar.field_filePath)).equals(qVar.field_md5);
    }

    private static void b(q qVar, boolean z) {
        a.bZC().RY(qVar.field_urlKey);
        com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath);
        com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath + ".decompressed");
        com.tencent.mm.pluginsdk.i.a.e.a.Sa(qVar.field_filePath + ".decrypted");
        if (2 == qVar.field_status && !z) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
        } else if (qVar.field_maxRetryTimes <= 0 || qVar.field_retryTimes > 0) {
            qVar.field_retryTimes--;
            qVar.field_fileUpdated = true;
            a.bZC().e(qVar);
            j.I(qVar.field_reportId, 12);
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            k b = c.b(qVar);
            b.tmA = false;
            a.bZC().d(b);
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[]{Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes)});
        }
    }

    private static void d(q qVar) {
        if (qVar.field_fileUpdated) {
            j.I(qVar.field_reportId, 13);
            j.I(qVar.field_reportId, 44);
        }
        if (qVar.field_fileCompress || qVar.field_fileEncrypt) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            c.bZm().a(qVar);
            return;
        }
        c.bZm().b(qVar.field_resType, qVar.field_subType, qVar.field_filePath, bh.getInt(qVar.field_fileVersion, 0));
    }
}
