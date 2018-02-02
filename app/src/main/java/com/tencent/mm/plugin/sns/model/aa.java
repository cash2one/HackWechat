package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class aa {
    public static boolean nSI = false;
    public static char[] qUX = new char[36];
    private af handler = new 1(this, Looper.getMainLooper());
    public boolean qUU = false;
    public long qUV = 0;
    private int qUW = 0;

    static /* synthetic */ boolean S(String str, String str2, String str3) {
        for (FileEntry fileEntry : FileOp.F(str, true)) {
            if (!nSI) {
                x.d("MicroMsg.RemoveSnsTask", "broken here by ??");
                return false;
            } else if (fileEntry.name != null && !bh.ov(str2) && str3 != null && (fileEntry.name.contains(str2) || fileEntry.name.contains(str3))) {
                x.d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", new Object[]{str2});
            } else if (bh.bz(fileEntry.timestamp) > 604800000) {
                FileOp.deleteFile(fileEntry.name);
            }
        }
        return true;
    }

    static {
        int i = 0;
        int i2 = 48;
        while (i2 <= 57) {
            qUX[i] = (char) i2;
            i2++;
            i++;
        }
        i2 = 97;
        while (i2 <= 122) {
            qUX[i] = (char) i2;
            i2++;
            i++;
        }
    }

    public static void b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }
}
