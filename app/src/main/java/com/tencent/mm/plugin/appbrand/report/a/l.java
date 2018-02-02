package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    public final String appId;
    private int fts;
    public final int iEZ;
    private long jIH;
    public final boolean jII;
    public boolean jIJ;
    public boolean jIK;
    public int jIL;
    public int jIM;
    public long jIN;
    public final int jxW;

    public l(String str, int i, int i2) {
        if ("@LibraryAppId".equals(str)) {
            this.appId = "publiclib";
            this.jII = h.ZH();
        } else {
            this.appId = str;
            this.jII = h.ZG();
        }
        this.iEZ = i;
        this.jxW = i2;
    }

    public final void akc() {
        this.jIH = bh.Wp() - this.jIN;
    }

    public final void lu(int i) {
        if (this.jII) {
            this.fts = i;
        }
    }

    public final String toString() {
        return "kv_14609{appId='" + this.appId + '\'' + ", oldVersion=" + this.iEZ + ", targetVersion=" + this.jxW + ", spendTime=" + this.jIH + ", canUsePatchUpdate=" + this.jII + ", isUpdateComplete=" + this.jIJ + ", isUpdateCompleteWithPatch=" + this.jIK + ", fullPkgSize=" + this.jIL + ", patchSize=" + this.jIM + ", errcode=" + this.fts + '}';
    }

    public final void wW() {
        int i;
        int i2 = 1;
        x.i("MicroMsg.AppBrand.Report.kv_14609", "report %s", new Object[]{toString()});
        d dVar = d.pPH;
        Object[] objArr = new Object[12];
        objArr[0] = this.appId;
        objArr[1] = Integer.valueOf(1);
        objArr[2] = a.ce(ac.getContext());
        objArr[3] = Integer.valueOf(this.iEZ);
        objArr[4] = Integer.valueOf(this.jxW);
        objArr[5] = Long.valueOf(this.jIH);
        objArr[6] = Integer.valueOf(this.jII ? 1 : 0);
        if (this.jIJ) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        if (!this.jIK) {
            i2 = 0;
        }
        objArr[8] = Integer.valueOf(i2);
        objArr[9] = Integer.valueOf(this.jIL);
        objArr[10] = Integer.valueOf(this.jIM);
        objArr[11] = Integer.valueOf(this.fts);
        dVar.h(14609, objArr);
    }
}
