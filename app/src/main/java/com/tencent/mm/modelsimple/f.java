package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.k.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l$a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class f extends k implements com.tencent.mm.network.k {
    private e gJT;
    private q hnp = new a();

    public static void bS(boolean z) {
        x.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(ar.Hj()), bh.cgy()});
        if (!ar.Hj()) {
            return;
        }
        if (ar.CG() == null || ar.CG().hmV == null || ar.CG().hmV.Kx() == null) {
            x.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
            return;
        }
        ar.CG().hmV.Kx().bD(z);
        if (z) {
            ar.CG().a(new f(true), 0);
            return;
        }
        ar.CG().a(new f(RB()), 0);
    }

    private static boolean RB() {
        int i;
        if (r.idZ != -1) {
            i = r.idZ;
        } else {
            try {
                i = bh.getInt(g.zY().getValue("MuteRoomDisable"), 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneBgFg", e, "", new Object[0]);
                i = 0;
            }
        }
        x.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[]{Integer.valueOf(1), Integer.valueOf(r.idZ), Integer.valueOf(i), Boolean.valueOf(b.foreground)});
        if ((i & 1) != 0) {
            return true;
        }
        return r3;
    }

    private f(boolean z) {
        l$a com_tencent_mm_protocal_l_a = (l$a) this.hnp.Kb();
        com_tencent_mm_protocal_l_a.netType = l.getNetType(ac.getContext());
        com_tencent_mm_protocal_l_a.vBs = z ? 1 : 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[]{Integer.valueOf(((l.b) qVar.Hp()).vBt.liH)});
        this.gJT.a(i2, i3, str, this);
    }
}
