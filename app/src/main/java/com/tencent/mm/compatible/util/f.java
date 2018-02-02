package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class f {
    public static boolean fM(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean fN(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean ze() {
        boolean z = false;
        String absolutePath = h.getExternalStorageDirectory().getAbsolutePath();
        if (e.bnD.equalsIgnoreCase(absolutePath)) {
            try {
                if (h.getExternalStorageState().equals("mounted") && new File(absolutePath).canWrite()) {
                    return true;
                }
                return z;
            } catch (Exception e) {
                x.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e.getMessage() + " SDCARD_ROOT: " + e.bnD);
                return z;
            }
        }
        try {
            return new File(e.bnD).canWrite();
        } catch (Exception e2) {
            x.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + e.bnD);
            return z;
        }
    }

    public static boolean zf() {
        StatFs statFs;
        StatFs statFs2;
        long blockSize;
        Exception e;
        long j;
        long j2;
        if (!ze()) {
            return false;
        }
        long j3 = 0;
        long j4 = 0;
        try {
            statFs = new StatFs(e.bnD);
            try {
                j3 = (long) statFs.getBlockCount();
                j4 = (long) statFs.getAvailableBlocks();
                statFs2 = statFs;
                blockSize = (long) statFs.getBlockSize();
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.CUtil", "checkSDCardFull", e);
                statFs2 = statFs;
                blockSize = 0;
                if (statFs2 != null) {
                    return false;
                }
                if (j3 > 0) {
                    return false;
                }
                if (j3 - j4 >= 0) {
                    return false;
                }
                j = blockSize * j4;
                j2 = blockSize * j3;
                x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
                if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                    return false;
                }
                if (j <= 314572800) {
                    return false;
                }
                x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            statFs = null;
            x.e("MicroMsg.CUtil", "checkSDCardFull", e);
            statFs2 = statFs;
            blockSize = 0;
            if (statFs2 != null) {
                return false;
            }
            if (j3 > 0) {
                return false;
            }
            if (j3 - j4 >= 0) {
                return false;
            }
            j = blockSize * j4;
            j2 = blockSize * j3;
            x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
            if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                return false;
            }
            if (j <= 314572800) {
                return false;
            }
            x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
            return true;
        }
        if (statFs2 != null) {
            return false;
        }
        if (j3 > 0) {
            return false;
        }
        if (j3 - j4 >= 0) {
            return false;
        }
        j = blockSize * j4;
        j2 = blockSize * j3;
        x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
        if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
            return false;
        }
        if (j <= 314572800) {
            return false;
        }
        x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
        return true;
    }

    public static boolean aC(long j) {
        long blockCount;
        long j2;
        Exception e;
        if (ze()) {
            StatFs statFs;
            try {
                statFs = new StatFs(e.bnD);
                try {
                    blockCount = (long) statFs.getBlockCount();
                    try {
                        j2 = blockCount;
                        blockCount = (long) statFs.getAvailableBlocks();
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                        j2 = blockCount;
                        blockCount = 0;
                        return statFs != null ? false : false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    blockCount = 0;
                    x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                    j2 = blockCount;
                    blockCount = 0;
                    if (statFs != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                statFs = null;
                blockCount = 0;
                x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                j2 = blockCount;
                blockCount = 0;
                if (statFs != null) {
                }
            }
            if (statFs != null || r8 <= 0 || r8 - r4 < 0) {
                return false;
            }
            if (((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize()) >= j) {
                return true;
            }
            x.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + j + " not enough and ret false");
            return false;
        }
        x.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
        return false;
    }
}
