package com.tencent.mm.ae;

import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.as;

public abstract class l extends k implements k {
    protected int hmS = 3;
    private boolean hmT = false;

    public abstract void Kj();

    public abstract e Kk();

    public abstract void a(int i, int i2, String str, q qVar);

    public abstract il c(q qVar);

    public abstract asx d(q qVar);

    public abstract aki e(q qVar);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 4 && i3 == -301) {
            x.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", Integer.valueOf(this.hmS));
            if (qVar != null) {
                x.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                as.a(true, c(qVar), d(qVar), e(qVar));
            }
            this.hmS--;
            if (this.hmS <= 0) {
                Kj();
                this.hmT = false;
                return;
            }
            x.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            a(this.hmA, Kk());
            return;
        }
        a(i2, i3, str, qVar);
    }
}
