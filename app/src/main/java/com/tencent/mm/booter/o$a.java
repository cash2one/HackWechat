package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$a {
    int gyN;
    int gyO = 1;
    int gyP;
    int gyQ;
    int gyR;

    o$a() {
    }

    public final boolean ek(String str) {
        String[] split = str.split(",");
        if (split == null || split.length != 5) {
            x.e("MicroMsg.ProcessReport", "error format");
            return false;
        }
        try {
            this.gyN = bh.getInt(split[0], 0);
            this.gyO = bh.getInt(split[1], 0);
            this.gyP = bh.getInt(split[2], 0);
            this.gyQ = bh.getInt(split[3], 0);
            this.gyR = bh.getInt(split[4], 0);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
            x.printErrStackTrace("MicroMsg.ProcessReport", e, "", new Object[0]);
            return false;
        }
    }

    public final String toString() {
        return String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.gyN), Integer.valueOf(this.gyO), Integer.valueOf(this.gyP), Integer.valueOf(this.gyQ), Integer.valueOf(this.gyR)});
    }
}
