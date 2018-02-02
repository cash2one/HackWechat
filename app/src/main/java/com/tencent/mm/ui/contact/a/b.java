package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.pluginsdk.ui.d.i;

public final class b extends e {
    public String bgo;
    public int mPo = 0;
    private boolean yVe;

    public b(int i) {
        super(i);
    }

    public final void bH(Context context) {
        if (this.mPo == 0 || this.bgo == null) {
            af afVar = this.jLe;
            if (!this.yVe) {
                g.Dk();
                afVar = ((h) g.h(h.class)).EY().WO(this.username);
                this.jLe = afVar;
                this.yVe = true;
            }
            af afVar2 = afVar;
            if (afVar2 == null) {
                this.iil = "";
                return;
            }
            this.iil = i.c(context, ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).c(afVar2), a.aa(context, c.bvK));
            this.username = afVar2.field_username;
            return;
        }
        this.yVo = this.mPo;
        this.yVn = this.bgo;
    }
}
