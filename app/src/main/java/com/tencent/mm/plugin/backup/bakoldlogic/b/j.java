package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public static int a(a aVar) {
        if (aVar.kne == null) {
            x.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[]{"backupItemInfo.backupitem"});
            return 0;
        }
        int bN = e.bN(aVar.filePath);
        if (bN <= 0) {
            x.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            return 0;
        } else if (aVar.kng) {
            return bN;
        } else {
            if (bN < 8192 && aVar.kne.vKf.wJB == 0) {
                byte[] e;
                if (aVar.ftE != 5) {
                    e = e.e(aVar.filePath, 0, -1);
                } else if (aVar.kqm == null) {
                    x.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
                    e = null;
                } else {
                    e = ((c) g.k(c.class)).getEmojiMgr().a(aVar.kqm);
                }
                bdn bj = new bdn().bj(e);
                aVar.kne.vKg = bN;
                aVar.kne.vKh = aVar.ftE;
                aVar.kne.vKf = bj;
                return bN;
            } else if (aVar.knf == null) {
                x.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
                return 0;
            } else {
                String str = aVar.kne.vGX.toString() + "_" + aVar.kne.vGY.toString() + "_" + aVar.kne.vHe + "_backup_" + (aVar.knh == null ? "" : aVar.knh);
                x.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[]{str, aVar.filePath});
                aVar.kne.vKd.add(new bdo().UA(str));
                aVar.kne.vKe.add(new bdp().CW(aVar.ftE));
                aVar.kne.vKc = aVar.kne.vKd.size();
                if (aVar.knb == null) {
                    aVar.knb = new u();
                }
                aVar.knb.ktK = aVar.kne.vHe;
                aVar.knb.mediaId = str;
                aVar.knb.path = aVar.filePath;
                aVar.knb.type = aVar.ftE;
                if (!aVar.kni) {
                    aVar.knf.add(aVar.knb);
                }
                return 0;
            }
        }
    }
}
