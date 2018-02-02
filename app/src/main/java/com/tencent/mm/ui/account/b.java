package com.tencent.mm.ui.account;

import com.tencent.mm.ae.k;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$b;
import com.tencent.mm.z.ar;

public abstract class b extends SecurityImage$b {
    SecurityImage xKa = null;
    k xNp = null;

    public abstract k a(k kVar, String str);

    public final void cnJ() {
        ar.CG().a(a(this.xNp, ""), 0);
    }
}
