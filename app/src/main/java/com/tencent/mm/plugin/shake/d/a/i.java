package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bht;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

public final class i {
    public static String bsg() {
        if (ar.Hj()) {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            File file = new File(stringBuilder.append(c.FC()).append("shakemusic/").toString());
            if (!(file.exists() && file.isDirectory())) {
                x.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[]{file.getAbsolutePath()});
                file.mkdir();
            }
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                x.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[]{file.getAbsolutePath()});
                try {
                    file2.createNewFile();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                return file.getAbsolutePath() + "/";
            }
            x.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            return null;
        }
        x.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        return null;
    }

    public static asv c(byte[] bArr, long j) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            bht com_tencent_mm_protocal_c_bht = (bht) new bht().aF(bArr);
            asv com_tencent_mm_protocal_c_asv = new asv();
            com_tencent_mm_protocal_c_asv.wAi = 4;
            com_tencent_mm_protocal_c_asv.vVZ = String.valueOf(com_tencent_mm_protocal_c_bht.wLo);
            com_tencent_mm_protocal_c_asv.wAj = com_tencent_mm_protocal_c_bht.wAj;
            com_tencent_mm_protocal_c_asv.wAm = n.b(com_tencent_mm_protocal_c_bht.wmW);
            com_tencent_mm_protocal_c_asv.wAn = n.b(com_tencent_mm_protocal_c_bht.wmX);
            com_tencent_mm_protocal_c_asv.wAs = a.Hu(com_tencent_mm_protocal_c_asv.wAn);
            com_tencent_mm_protocal_c_asv.vLj = com_tencent_mm_protocal_c_bht.vLj;
            com_tencent_mm_protocal_c_asv.wAr = n.b(com_tencent_mm_protocal_c_bht.wmV);
            com_tencent_mm_protocal_c_asv.wAk = n.b(com_tencent_mm_protocal_c_bht.wLp);
            com_tencent_mm_protocal_c_asv.wAl = n.b(com_tencent_mm_protocal_c_bht.wLq);
            com_tencent_mm_protocal_c_asv.wAq = n.b(com_tencent_mm_protocal_c_bht.wLt);
            com_tencent_mm_protocal_c_asv.wAo = n.b(com_tencent_mm_protocal_c_bht.wLr);
            com_tencent_mm_protocal_c_asv.wAp = n.b(com_tencent_mm_protocal_c_bht.wLs);
            com_tencent_mm_protocal_c_asv.qRn = j;
            return com_tencent_mm_protocal_c_asv;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            x.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            return null;
        }
    }
}
