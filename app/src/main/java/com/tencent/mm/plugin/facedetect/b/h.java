package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.i;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.plugin.facedetect.b.i.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class h extends i {
    a mfa = new a();
    b mfb = new b();

    h() {
    }

    public final int getType() {
        return 733;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    public final e Hp() {
        return this.mfb;
    }

    protected final d Ho() {
        return this.mfa;
    }

    public final int JY() {
        return 1;
    }
}
