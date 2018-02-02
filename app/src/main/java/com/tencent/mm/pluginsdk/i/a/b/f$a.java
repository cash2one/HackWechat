package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.b.f.b;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class f$a {
    static void a(q qVar, g gVar) {
        if (qVar == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[]{qVar.field_urlKey, qVar.field_url, Long.valueOf(qVar.field_contentLength), Boolean.valueOf(qVar.field_deleted), qVar.field_eccSignature, Long.valueOf(qVar.field_expireTime), Boolean.valueOf(qVar.field_fileCompress), Boolean.valueOf(qVar.field_fileEncrypt), qVar.field_filePath, Boolean.valueOf(qVar.field_fileUpdated), qVar.field_fileVersion, qVar.field_groupId2, Integer.valueOf(qVar.field_keyVersion), Boolean.valueOf(bh.ov(qVar.field_encryptKey)), Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes), qVar.field_sampleId, Integer.valueOf(qVar.field_status)});
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[]{qVar.field_encryptKey});
        }
        if (qVar != null && qVar.field_deleted && gVar.RQ(qVar.field_fileVersion) <= 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[]{qVar.field_fileVersion, gVar.vhw});
        } else if (qVar == null) {
            r0 = gVar.bZo();
            r0.field_fileUpdated = true;
            if (bh.ov(r0.field_encryptKey)) {
                r0.field_keyVersion = -1;
            }
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + r0);
            a.vhX.e(r0);
            c.bZm().f(gVar.fpm, gVar.fpn, 0, gVar.fpt);
            a(true, true, r0, gVar);
        } else {
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
            qVar.field_networkType = gVar.networkType;
            if (bh.ov(qVar.field_originalMd5)) {
                qVar.field_originalMd5 = gVar.vgj;
            }
            if (gVar.RQ(qVar.field_fileVersion) > 0) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                r0 = gVar.bZo();
                if (qVar.field_keyVersion >= gVar.vgh) {
                    r0.field_keyVersion = qVar.field_keyVersion;
                    r0.field_encryptKey = qVar.field_encryptKey;
                }
                r0.field_fileUpdated = true;
                r0.field_deleted = false;
                a.vhX.e(r0);
                c.bZm().f(gVar.fpm, gVar.fpn, 0, gVar.fpt);
                a.vhX.RY(gVar.vgd);
                a(false, true, r0, gVar);
            } else if (gVar.RQ(qVar.field_fileVersion) != 0 || qVar.field_needRetry) {
                if (qVar.field_status == 2 || qVar.field_status == 1 || qVar.field_status == 0) {
                    long Gr = a.Gr(qVar.field_filePath);
                    if (qVar.field_contentLength > Gr) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[]{Long.valueOf(qVar.field_contentLength), Long.valueOf(Gr)});
                        if (0 == Gr) {
                            c.bZm().f(gVar.fpm, gVar.fpn, 0, gVar.fpt);
                            a(false, true, qVar, gVar);
                            return;
                        }
                        a(true, false, qVar, gVar);
                        return;
                    } else if (bh.ou(g.bV(i.RR(gVar.vgd))).equals(qVar.field_md5)) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt");
                        qVar.field_status = 2;
                        qVar.field_contentLength = a.Gr(qVar.field_filePath);
                        qVar.field_fileUpdated = false;
                        a.vhX.e(qVar);
                        j.I(qVar.field_reportId, 13);
                        j.I(qVar.field_reportId, 44);
                        j.a(qVar.field_resType, qVar.field_subType, qVar.field_url, bh.getInt(qVar.field_fileVersion, 0), j$a.vhh, true, "NewXml".equalsIgnoreCase(qVar.field_groupId2), true, qVar.field_sampleId);
                        if (gVar.vgM || gVar.vgN) {
                            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request");
                            b.a(qVar, false);
                            return;
                        }
                        c.bZm().b(gVar.fpm, gVar.fpn, i.RR(gVar.vgd), bh.getInt(gVar.vhw, 0));
                        return;
                    }
                } else if (!(qVar.field_status == 4 || qVar.field_status == 3)) {
                    return;
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                a(false, true, qVar, gVar);
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[]{Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion});
            }
        }
    }

    private static void a(boolean z, boolean z2, q qVar, g gVar) {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (qVar.field_maxRetryTimes <= 0 || qVar.field_retryTimes > 0 || z2) {
            qVar.field_status = 0;
            if (z2) {
                qVar.field_maxRetryTimes = gVar.vgn;
                qVar.field_retryTimes = gVar.vgn;
                qVar.field_fileUpdated = true;
                qVar.field_priority = gVar.priority;
                if (gVar.fileSize > 0) {
                    qVar.field_fileSize = gVar.fileSize;
                }
                a.vhX.e(qVar);
            } else {
                qVar.field_retryTimes--;
                qVar.field_priority = gVar.priority;
                a.vhX.e(qVar);
                j.I(qVar.field_reportId, 12);
            }
            if (a.vhX.RX(gVar.vgd)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[]{gVar.vgd});
                if (gVar.fpt) {
                    j.I(gVar.vgl, 9);
                    j.I(gVar.vgl, 44);
                    return;
                }
                return;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[]{gVar.vgd});
            if (z2 && !z) {
                c.bZm().f(qVar.field_resType, qVar.field_subType, 0, bh.ou(qVar.field_groupId2).equals("NewXml"));
            }
            k b = c.b(qVar);
            b.tmA = z;
            b.vgL = gVar.vgL;
            if (!z) {
                a.Sa(i.RR(b.vgd));
                a.Sa(i.RR(b.vgd) + ".decompressed");
                a.Sa(i.RR(b.vgd) + ".decrypted");
            }
            a.vhX.d(b);
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[]{Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes)});
    }
}
