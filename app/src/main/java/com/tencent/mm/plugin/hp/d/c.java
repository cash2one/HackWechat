package com.tencent.mm.plugin.hp.d;

import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    @Deprecated
    public static boolean dx(long j) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e) {
                blockSize = 0;
                if (blockSize != 0) {
                }
                return false;
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            blockSize = 0;
            if (blockSize != 0) {
            }
            return false;
        }
        if (blockSize != 0 || r0 <= 83886080) {
            return false;
        }
        return true;
    }

    public static void a(a aVar) {
        String string = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
        if (!bh.ov(string)) {
            try {
                no noVar = new no();
                noVar.aF(Base64.decode(string.getBytes(), 0));
                if (noVar.vWv != null) {
                    string = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
                    String str = "tinker_id_" + BaseBuildInfo.baseRevision();
                    String string2 = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
                    b bVar = new b(noVar.vWv);
                    x.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[]{bVar.nBq, string, string2, str});
                    if (!(bh.ov(bVar.nBq) || bVar.nBq.equalsIgnoreCase(string) || bh.ov(str) || !str.equalsIgnoreCase(string2))) {
                        aVar.a(true, bVar);
                        return;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("Tinker.TinkerUtils", e, "parse tinker update Response failed.", new Object[0]);
                g.pQN.a(614, 73, 1, false);
            }
        }
        aVar.a(false, null);
    }
}
