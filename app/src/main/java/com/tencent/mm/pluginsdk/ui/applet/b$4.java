package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.h;

class b$4 implements e {
    final /* synthetic */ b vnd;

    b$4(b bVar) {
        this.vnd = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.vnd.ltM != null) {
            this.vnd.ltM.dismiss();
        }
        if (this.vnd.vnb != null) {
            g.Dk();
            g.Di().gPJ.b(106, this.vnd.vnb);
        }
        if (this.vnd.ltM == null) {
            x.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            this.vnd.fW(0);
        } else if (i != 0 || i2 != 0) {
            x.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            this.vnd.fW(-1);
        } else if (this.vnd.mContext == null) {
            x.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            this.vnd.fW(-1);
        } else if ((this.vnd.mContext instanceof Activity) && ((Activity) this.vnd.mContext).isFinishing()) {
            x.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            this.vnd.fW(-1);
        } else {
            bem So = ((ac) kVar).So();
            String a = n.a(So.vYI);
            if (bh.ov(a)) {
                x.e("MicroMsg.AddContactDialog", "searchContact, user is null");
                h.bu(this.vnd.mContext, this.vnd.mContext.getResources().getString(R.l.eYl));
                this.vnd.fW(-1);
                return;
            }
            if (this.vnd.jKk == null || !this.vnd.jKk.equals(a)) {
                x.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", this.vnd.jKk, a);
            }
            b bVar = this.vnd;
            g.Dk();
            bVar.lFr = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(a);
            if (this.vnd.lFr == null || ((int) this.vnd.lFr.gJd) == 0) {
                x.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a + ", try get by alias");
                bVar = this.vnd;
                g.Dk();
                bVar.lFr = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WL(a);
                if (this.vnd.lFr == null || ((int) this.vnd.lFr.gJd) == 0) {
                    x.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                    this.vnd.lFr = new com.tencent.mm.storage.x(a);
                    this.vnd.lFr.cZ(So.hvy);
                    this.vnd.lFr.dc(n.a(So.wsB));
                    this.vnd.lFr.dd(n.a(So.vYw));
                    this.vnd.lFr.de(n.a(So.vYx));
                    this.vnd.lFr.eD(So.hvt);
                    this.vnd.lFr.dv(RegionCodeDecoder.ah(So.hvC, So.hvu, So.hvv));
                    this.vnd.lFr.dp(So.hvw);
                    this.vnd.lFr.ez(So.wvf);
                    this.vnd.lFr.du(So.wvg);
                    this.vnd.lFr.ey(So.wvj);
                    this.vnd.lFr.df(So.wvi);
                    this.vnd.lFr.dt(So.wvh);
                }
            } else {
                x.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a);
            }
            this.vnd.M(this.vnd.lFr);
        }
    }
}
