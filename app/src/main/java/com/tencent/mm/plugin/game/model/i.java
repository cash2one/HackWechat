package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.bf;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public class i {
    private static i nbE;
    public bf nbF;

    public static i aQb() {
        if (nbE == null) {
            synchronized (i.class) {
                if (nbE == null) {
                    nbE = new i();
                }
            }
        }
        return nbE;
    }

    public final void XH() {
        c.Dm().F(new Runnable(this) {
            final /* synthetic */ i nbG;

            {
                this.nbG = r1;
            }

            public final void run() {
                this.nbG.aw(SubCoreGameCenter.aRh().BX("pb_game_global_config"));
            }
        });
    }

    private synchronized void aw(byte[] bArr) {
        if (!bh.bw(bArr)) {
            try {
                this.nbF = new bf();
                this.nbF.aF(bArr);
            } catch (IOException e) {
                this.nbF = null;
                x.e("MicroMsg.GameConfigManager", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final af aQc() {
        af afVar = null;
        if (this.nbF != null) {
            afVar = this.nbF.nhM;
            if (afVar != null) {
                x.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[]{Integer.valueOf(afVar.ngD), afVar.nfg});
            }
        } else {
            XH();
        }
        return afVar;
    }

    public final dw aQd() {
        if (this.nbF != null) {
            return this.nbF.nhO;
        }
        XH();
        return null;
    }
}
