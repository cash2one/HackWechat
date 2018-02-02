package com.tencent.mm.modelmulti;

import android.os.StatFs;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;

class p$5 implements Runnable {
    final /* synthetic */ p hGP;

    p$5(p pVar) {
        this.hGP = pVar;
    }

    public final void run() {
        try {
            int round;
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            int i;
            int i2;
            File file = new File(w.gZK + "SdcardInfo.cfg");
            g.pQN.a(340, file.exists() ? 10 : 11, 1, true);
            boolean cge = aw.cge();
            String path = h.getDataDirectory().getPath();
            String path2 = h.getExternalStorageDirectory().getPath();
            StatFs statFs = new StatFs(path);
            long blockSize = (long) statFs.getBlockSize();
            long blockCount = (long) statFs.getBlockCount();
            long availableBlocks = (long) statFs.getAvailableBlocks();
            long j6 = blockSize * blockCount;
            long j7 = blockSize * availableBlocks;
            if (blockCount > 0) {
                round = Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount));
            } else {
                round = -1;
            }
            statFs = new StatFs(path2);
            long blockSize2 = (long) statFs.getBlockSize();
            long blockCount2 = (long) statFs.getBlockCount();
            long availableBlocks2 = (long) statFs.getAvailableBlocks();
            long j8 = blockSize2 * blockCount2;
            long j9 = blockSize2 * availableBlocks2;
            int i3 = -1;
            if (blockCount2 > 0) {
                i3 = Math.round((((float) availableBlocks2) * 100.0f) / ((float) blockCount2));
            }
            boolean equals = e.bnD.equals(path2);
            if (equals) {
                j = j9;
                j2 = j8;
                j3 = availableBlocks2;
                j4 = blockCount2;
                j5 = blockSize2;
                i = i3;
            } else {
                statFs = new StatFs(e.bnD);
                long blockSize3 = (long) statFs.getBlockSize();
                long blockCount3 = (long) statFs.getBlockCount();
                long availableBlocks3 = (long) statFs.getAvailableBlocks();
                long j10 = blockSize3 * blockCount3;
                long j11 = blockSize3 * availableBlocks3;
                if (blockCount3 > 0) {
                    j2 = j10;
                    j3 = availableBlocks3;
                    j4 = blockCount3;
                    j5 = blockSize3;
                    i = Math.round((((float) availableBlocks3) * 100.0f) / ((float) blockCount3));
                    j = j11;
                } else {
                    j = j11;
                    j2 = j10;
                    j3 = availableBlocks3;
                    j4 = blockCount3;
                    j5 = blockSize3;
                    i = i3;
                }
            }
            String Vn = aw.Vn(e.bnD);
            String Vn2 = aw.Vn(path);
            String str = "MicroMsg.SubCoreBaseMonitor";
            String str2 = "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]";
            Object[] objArr = new Object[26];
            objArr[0] = path;
            objArr[1] = path2;
            objArr[2] = e.bnD;
            objArr[3] = Vn;
            objArr[4] = Boolean.valueOf(cge);
            objArr[5] = Long.valueOf(blockSize);
            objArr[6] = Long.valueOf(blockCount);
            objArr[7] = Long.valueOf(availableBlocks);
            objArr[8] = Long.valueOf(j6);
            objArr[9] = Long.valueOf(j7);
            objArr[10] = Integer.valueOf(round);
            objArr[11] = Long.valueOf(blockSize2);
            objArr[12] = Long.valueOf(blockCount2);
            objArr[13] = Long.valueOf(availableBlocks2);
            objArr[14] = Long.valueOf(j8);
            objArr[15] = Long.valueOf(j9);
            objArr[16] = Integer.valueOf(i3);
            objArr[17] = Boolean.valueOf(equals);
            objArr[18] = Long.valueOf(j5);
            objArr[19] = Long.valueOf(j4);
            objArr[20] = Long.valueOf(j3);
            objArr[21] = Long.valueOf(j2);
            objArr[22] = Long.valueOf(j);
            objArr[23] = Integer.valueOf(i);
            if (file.exists()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[24] = Integer.valueOf(i2);
            objArr[25] = Vn2;
            x.i(str, str2, objArr);
            g.pQN.a(340, 0, 1, true);
            g.pQN.a(340, cge ? 1 : 2, 1, true);
            g.pQN.a(340, equals ? 3 : 4, 1, true);
            g gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(5000);
            String str3 = "%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s";
            Object[] objArr2 = new Object[26];
            objArr2[0] = path;
            objArr2[1] = path2;
            objArr2[2] = e.bnD;
            objArr2[3] = Vn;
            objArr2[4] = Integer.valueOf(cge ? 1 : 0);
            objArr2[5] = Long.valueOf(blockSize);
            objArr2[6] = Long.valueOf(blockCount);
            objArr2[7] = Long.valueOf(availableBlocks);
            objArr2[8] = Long.valueOf(j6);
            objArr2[9] = Long.valueOf(j7);
            objArr2[10] = Integer.valueOf(round);
            objArr2[11] = Long.valueOf(blockSize2);
            objArr2[12] = Long.valueOf(blockCount2);
            objArr2[13] = Long.valueOf(availableBlocks2);
            objArr2[14] = Long.valueOf(j8);
            objArr2[15] = Long.valueOf(j9);
            objArr2[16] = Integer.valueOf(i3);
            objArr2[17] = Integer.valueOf(equals ? 1 : 0);
            objArr2[18] = Long.valueOf(j5);
            objArr2[19] = Long.valueOf(j4);
            objArr2[20] = Long.valueOf(j3);
            objArr2[21] = Long.valueOf(j2);
            objArr2[22] = Long.valueOf(j);
            objArr2[23] = Integer.valueOf(i);
            if (file.exists()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr2[24] = Integer.valueOf(i2);
            objArr2[25] = Vn2;
            objArr[1] = String.format(str3, objArr2);
            gVar.h(11098, objArr);
            g.pQN.h(11098, new Object[]{Integer.valueOf(5001), path + ";" + Vn2});
            g.pQN.h(11098, new Object[]{Integer.valueOf(5002), e.bnD + ";" + Vn});
            gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(5003);
            objArr[1] = Integer.valueOf(file.exists() ? 1 : 0);
            gVar.h(11098, objArr);
            gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(5004);
            objArr[1] = Integer.valueOf(cge ? 1 : 0);
            gVar.h(11098, objArr);
            g.pQN.a(340, 7, 1, true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportSDStatus err!", new Object[0]);
            g.pQN.a(340, 8, 1, true);
        }
    }
}
