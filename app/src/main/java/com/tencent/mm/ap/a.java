package com.tencent.mm.ap;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public static int hyR = 0;
    public static int hyS = 1;
    public static int hyT = -85;
    private final b gJQ;
    private e gJT;
    private int hyU = -1;
    private String hyV;
    private int hyW = 0;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] hyX = new int[a.OZ().length];

        static {
            try {
                hyX[a.hyY - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hyX[a.hyZ - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] OZ() {
            return (int[]) hza.clone();
        }

        static {
            hyY = 1;
            hyZ = 2;
            hza = new int[]{hyY, hyZ};
        }
    }

    public a(int i, String str, int i2) {
        switch (AnonymousClass1.hyX[i - 1]) {
            case 1:
                this.hyU = 1;
                break;
            case 2:
                this.hyU = 2;
                break;
        }
        this.hyV = str;
        this.hyW = i2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new gr();
        aVar.hmk = new gs();
        aVar.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar.hmi = 487;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.gJT = eVar2;
        gr grVar = (gr) this.gJQ.hmg.hmo;
        grVar.vJL = this.hyU;
        grVar.vLO = this.hyV;
        grVar.vLP = this.hyW;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 487;
    }
}
