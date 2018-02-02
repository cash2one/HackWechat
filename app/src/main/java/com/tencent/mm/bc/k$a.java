package com.tencent.mm.bc;

import android.text.TextUtils;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class k$a {
    public int clear;
    public String fDI;
    public long hHE = System.currentTimeMillis();
    public int hKS;
    public int hLg;
    public int hLh;
    public long hLi;
    public int hLj;
    public int id;
    public String text;
    public long timestamp;
    public int type;

    public final boolean isValid() {
        if (this.clear == 1) {
            return false;
        }
        if (this.hLh > d.vAz) {
            x.i("SearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", Integer.valueOf(this.id), Integer.valueOf(this.hLh), Integer.valueOf(d.vAz));
            return false;
        }
        if (System.currentTimeMillis() > this.hHE + (this.hLi * 1000)) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            x.i("SearchRedPointMgr", "msgid %s expired", Integer.valueOf(this.id));
            return false;
        } else if (this.hLg == 1) {
            r3 = "SearchRedPointMgr";
            r4 = "h5 version valid ? %b, red.h5 %d, cur.h5 %s";
            r5 = new Object[3];
            if (g.zN(0) >= this.hKS) {
                z = true;
            } else {
                z = false;
            }
            r5[0] = Boolean.valueOf(z);
            r5[1] = Integer.valueOf(this.hKS);
            r5[2] = Integer.valueOf(g.zN(0));
            x.i(r3, r4, r5);
            if (g.zN(0) >= this.hKS) {
                return true;
            }
            return false;
        } else if (this.hLg != 2) {
            return false;
        } else {
            r3 = "SearchRedPointMgr";
            r4 = "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
            r5 = new Object[5];
            if (g.zN(1) >= this.hKS) {
                z = true;
            } else {
                z = false;
            }
            r5[0] = Boolean.valueOf(z);
            r5[1] = Integer.valueOf(this.hKS);
            r5[2] = Integer.valueOf(g.zN(1));
            r5[3] = Long.valueOf(this.timestamp);
            r5[4] = Long.valueOf(b.QT());
            x.i(r3, r4, r5);
            if (g.zN(1) < this.hKS || this.timestamp <= b.QT()) {
                return false;
            }
            return true;
        }
    }

    final String Rf() {
        return this.id + "_" + this.hLg + "_" + this.hLh + "_" + this.hLi + "_" + this.hKS + "_" + this.type + "_" + this.text + "_" + this.fDI + "_" + this.timestamp + "_" + this.hLj + "_" + this.hHE;
    }

    final void parse(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                this.id = bh.VI(split[0]);
                this.hLg = bh.VI(split[1]);
                this.hLh = bh.VI(split[2]);
                this.hLi = bh.VJ(split[3]);
                this.hKS = bh.VI(split[4]);
                this.type = bh.VI(split[5]);
                this.text = split[6];
                this.fDI = split[7];
                this.timestamp = bh.VJ(split[8]);
                this.hLj = bh.VI(split[9]);
                this.hHE = bh.VJ(split[10]);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("SearchRedPointMgr", e, "", new Object[0]);
        }
    }
}
