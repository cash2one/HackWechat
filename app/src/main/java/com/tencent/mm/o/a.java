package com.tencent.mm.o;

import android.content.Context;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class a {
    public static int gJh = -1;
    public static final long[] gJi = new long[]{17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L};
    public static final long[] gJj = new long[]{DownloadHelper.SAVE_LENGTH, 314572800, 524288000, 1073741824, 1073741824};

    public static int AV() {
        long blockCount;
        long freeBlocks;
        long j;
        double d;
        int i;
        long j2 = 0;
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            j2 = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            freeBlocks = ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
            j = j2;
            d = ((double) j2) / ((double) blockCount);
        } catch (Exception e) {
            blockCount = 0;
            x.e("MicroMsg.DbChecker", "get db spare space error");
            freeBlocks = 0;
            j = j2;
            d = 0.0d;
        }
        if (blockCount > 0) {
            if (j < 52428800) {
                i = 2;
            } else {
                if (gJh < 0) {
                    gJh = gJi.length - 1;
                    for (i = 0; i < gJi.length; i++) {
                        if (blockCount < gJi[i]) {
                            gJh = i;
                            break;
                        }
                    }
                }
                if (j < gJj[gJh]) {
                    i = 1;
                }
            }
            x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(gJh)});
            return i;
        }
        i = 0;
        x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(gJh)});
        return i;
    }

    public static void b(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("db_check_tip_time", j).commit();
    }
}
