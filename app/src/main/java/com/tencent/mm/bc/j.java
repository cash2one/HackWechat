package com.tencent.mm.bc;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.z.q;

public final class j {
    private static final j hLb = new j();
    public long hLa;

    public j() {
        if (g.Dh().Cy()) {
            this.hLa = q.FX();
        } else {
            a.xef.a(new 1(this));
        }
    }

    public static j Rc() {
        return hLb;
    }

    public final boolean Rd() {
        return (this.hLa & HardCoderJNI.ACTION_NET_RX) == HardCoderJNI.ACTION_NET_RX;
    }
}
