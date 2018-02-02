package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static k smN;
    v2protocal smF = new v2protocal(new af(Looper.getMainLooper()));
    boolean smG = false;
    public a smH;
    int smI = -1;
    boolean smJ = false;
    int smK = 0;
    public int smL;
    public int smM;
    ak smO = new ak(Looper.getMainLooper(), new 1(this), true);

    public interface a {
        void aSW();

        void aSX();
    }

    public static k bHh() {
        if (smN == null) {
            smN = new k();
        }
        return smN;
    }

    private k() {
    }

    public final void bHi() {
        x.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.smI = -1;
        this.smJ = true;
        this.smM = 0;
        this.smL = 0;
        ag.h(new 2(this), 3000);
    }

    public final void bHj() {
        x.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.smI = -1;
        this.smG = false;
        this.smJ = false;
        this.smM = 0;
        this.smL = 0;
        ag.y(new 3(this));
    }
}
