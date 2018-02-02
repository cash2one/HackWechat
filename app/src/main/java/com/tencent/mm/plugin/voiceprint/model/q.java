package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class q implements e {
    private String sgD;
    private int sgJ;
    public String sgZ;
    public int sha;
    public a shp;

    public q() {
        this.shp = null;
        this.sha = -1;
        this.sgZ = null;
        this.sgD = null;
        this.sgJ = 0;
        ar.CG().a(611, this);
        ar.CG().a(613, this);
    }

    public q(a aVar) {
        this();
        this.shp = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.sha = dVar.sgC;
                this.sgZ = dVar.sgB;
                this.sgD = dVar.sgD;
                x.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[]{Integer.valueOf(this.sha), this.sgD, Boolean.valueOf(bh.ov(this.sgZ))});
                if (this.shp != null) {
                    this.shp.MA(this.sgZ);
                }
            }
            if (kVar.getType() != 613) {
                return;
            }
            if (((j) kVar).sgM == 0) {
                x.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                if (this.shp != null) {
                    this.shp.jc(true);
                    return;
                }
                return;
            }
            x.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
            if (this.shp != null) {
                this.shp.jc(false);
            }
        } else if (this.shp != null) {
            this.shp.bFF();
        }
    }
}
