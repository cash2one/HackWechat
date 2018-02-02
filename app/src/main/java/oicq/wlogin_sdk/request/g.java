package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.Awh = 2064;
        this.Awi = 2;
        this.Awk = iVar;
    }

    public final byte[] bW(byte[] bArr) {
        int length;
        int i;
        int i2 = this.Awk.Awu;
        byte[] cJP = this.Awk.Awp.cJP();
        oicq.wlogin_sdk.a.g gVar = this.Awk.Awq;
        Object obj = new byte[gVar.Axc];
        if (gVar.Axc > 0) {
            System.arraycopy(gVar.Awb, gVar.Axe, obj, 0, gVar.Axc);
        }
        f fVar = new f();
        ao aoVar = new ao();
        Object bX = fVar.bX(cJP);
        Object n = aoVar.n(bArr, obj);
        Object obj2 = new byte[(bX.length + n.length)];
        if (cJP.length > 0) {
            System.arraycopy(bX, 0, obj2, 0, bX.length);
            length = bX.length + 0;
            i = 1;
        } else {
            length = 0;
            i = 0;
        }
        System.arraycopy(n, 0, obj2, length, n.length);
        a(this.Awc, this.Awh, Awd, this.Awk._uin, this.Awe, this.Awf, i2, this.Awg, super.u(obj2, this.Awi, i + 1));
        return super.cJM();
    }
}
