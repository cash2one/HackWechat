package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;

public class l$a extends i {
    private final a hFf;
    private final b hFg;
    private final boolean hFh;

    public l$a() {
        this.hFf = new a();
        this.hFg = new b();
        this.hFh = false;
    }

    public l$a(b bVar) {
        this.hFf = new a();
        this.hFg = bVar;
        this.hFh = true;
    }

    public final d Ho() {
        return this.hFf;
    }

    public final e Hp() {
        return this.hFg;
    }

    public final int getType() {
        return 138;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newsync";
    }
}
