package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.Awh = 2064;
        this.Awi = 3;
        this.Awk = iVar;
    }

    public final int w(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        int T = super.T(bArr, i + 2);
        super.cJN();
        int i3 = i + 5;
        switch (T) {
            case 2:
                int y = fVar.y(bArr, i3, this.AvW - i3);
                if (y >= 0) {
                    this.Awk.Awp = fVar;
                    y = gVar.y(bArr, i3, this.AvW - i3);
                    if (y >= 0) {
                        this.Awk.Awq = gVar;
                        return T;
                    }
                }
                return y;
            case 5:
                super.v(bArr, i3, (this.AvW - i3) - 1);
                return T;
            default:
                v(bArr, i3, (this.AvW - i3) - 1);
                return T;
        }
    }
}
