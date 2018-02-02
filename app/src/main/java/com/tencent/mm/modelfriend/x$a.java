package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;

public class x$a extends i {
    private final a hwA = new a();
    private final b hwB = new b();

    protected final d Ho() {
        return this.hwA;
    }

    public final e Hp() {
        return this.hwB;
    }

    public final int getType() {
        return 429;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getsuggestalias";
    }

    public final int JY() {
        return 1;
    }
}
