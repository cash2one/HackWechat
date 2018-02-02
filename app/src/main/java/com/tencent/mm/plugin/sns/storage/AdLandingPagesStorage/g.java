package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public String extra = "";
    public String fzW;
    public int gyO;
    public long gzo;
    public int hKM;
    public int mod;
    public int moe;
    public String qZM;
    public String qZP;
    public int rgY;
    public int rol;
    public int rom;
    public int ron;
    public int roo;
    public int rop;
    public int roq;
    public int ror;
    public int ros;
    public String rot;
    public String rou;
    public String rov;

    public final String bxP() {
        long j = 0;
        try {
            j = i.lS(this.fzW);
        } catch (Exception e) {
            x.e("AdLandingPagesReportInfo", "", e);
        }
        return i.eq(j) + "," + this.qZM + "," + this.rol + "," + this.gyO + "," + this.rom + "," + this.ron + "," + this.roo + "," + this.rop + "," + this.roq + "," + this.ror + "," + this.ros + "," + this.moe + "," + this.mod + "," + this.hKM + "," + this.rot + "," + this.gzo + "," + this.rou + "," + (this.qZP == null ? "" : this.qZP) + "," + this.extra + "," + this.rgY + "," + this.rov;
    }
}
