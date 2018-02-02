package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements ap {
    private static j lfK;
    public long leW;
    public long leX;
    public long leY;
    public HashMap<String, Long> lfJ;
    public HashSet<String> lfx;

    public static j ayv() {
        if (lfK == null) {
            lfK = new j();
        }
        return lfK;
    }

    private j() {
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
        d.ayp();
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", Boolean.valueOf(z));
        b.asG().onAccountInitialized(null);
    }

    public final void br(boolean z) {
        x.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", Boolean.valueOf(z));
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        this.leW = 0;
        this.leX = 0;
        this.leY = 0;
        if (this.lfJ != null) {
            this.lfJ.clear();
        }
        if (this.lfx != null) {
            this.lfx.clear();
        }
        d.ayp();
        b.asG().onAccountRelease();
    }

    public static long ayc() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long ayd() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }
}
