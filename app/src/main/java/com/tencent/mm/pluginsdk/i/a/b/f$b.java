package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class f$b {
    static void a(q qVar, boolean z) {
        if (qVar == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
            return;
        }
        String str = qVar.field_urlKey;
        String str2 = qVar.field_filePath;
        String str3 = qVar.field_md5;
        boolean z2 = qVar.field_fileCompress;
        boolean z3 = qVar.field_fileEncrypt;
        Object obj = qVar.field_eccSignature;
        int i = bh.getInt(qVar.field_fileVersion, 0);
        int i2 = qVar.field_keyVersion;
        String str4 = qVar.field_encryptKey;
        boolean z4 = qVar.field_deleted;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z4 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + qVar.field_originalMd5 + ", fileCompress = " + z2 + ", fileEncrypt = " + z3 + ", eccSignature = " + obj + ", fileVersion = " + i + ", (encrypt key == empty) = " + bh.ov(str4));
        x.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", new Object[]{str4});
        if (!z3) {
            if (z) {
                j.I(qVar.field_reportId, 53);
                j.I(qVar.field_reportId, 45);
            }
            if (!z2) {
                x.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                return;
            }
        }
        if (i2 != i && z3) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i2 >= 0) {
                j.I(qVar.field_reportId, 52);
                j.I(qVar.field_reportId, 45);
            }
        } else if (z4) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
            j.I(qVar.field_reportId, 51);
            j.I(qVar.field_reportId, 45);
        } else if (bh.ov(str4) && z3) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
            j.I(qVar.field_reportId, 54);
            j.I(qVar.field_reportId, 45);
        } else if (bh.ov(str3) || bh.ov(str2)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", new Object[]{str3, str2});
        } else if (a.bZC().RX(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", new Object[]{str});
        } else if (!bh.ou(g.bV(str2)).equals(str3)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
            qVar.field_status = 3;
            a.bZC().e(qVar);
            j.I(qVar.field_reportId, 56);
            j.I(qVar.field_reportId, 45);
        } else if (!a.bZC().RX(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request");
            c.bZm().f(qVar.field_resType, qVar.field_subType, 1, bh.ou(qVar.field_groupId2).equals("NewXml"));
            c.bZm().a(qVar);
        }
    }
}
