package com.tencent.mm.plugin.game.model;

import android.os.Build.VERSION;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.be;
import com.tencent.mm.plugin.game.c.bf;
import com.tencent.mm.plugin.game.c.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ay extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final b lMW;

    public ay() {
        a aVar = new a();
        aVar.hmj = new be();
        aVar.hmk = new bf();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        aVar.hmi = 1311;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        be beVar = (be) this.lMW.hmg.hmo;
        beVar.nhF = w.cfi();
        String cO = g.cO(ac.getContext());
        if (bh.ov(cO)) {
            cO = bh.cgv();
        }
        beVar.hvC = cO;
        beVar.nhG = f.fdS;
        beVar.nhH = new d();
        beVar.nhH.nfm = VERSION.SDK_INT;
        beVar.nhH.mAL = com.b.a.a.b.t(ac.getContext());
        x.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", new Object[]{beVar.nhF, beVar.hvC, Integer.valueOf(beVar.nhG), Integer.valueOf(beVar.nhH.nfm), Integer.valueOf(beVar.nhH.mAL)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bf bfVar = (bf) ((b) qVar).hmh.hmo;
            if (bfVar == null) {
                this.gJT.a(i2, i3, str, this);
                return;
            }
            SubCoreGameCenter.aRh().a("pb_game_global_config", bfVar);
            i.aQb().XH();
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1311;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }
}
