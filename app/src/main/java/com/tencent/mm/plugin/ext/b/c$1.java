package com.tencent.mm.plugin.ext.b;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.ext.a;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class c$1 implements e {
    final /* synthetic */ c lZM;

    c$1(c cVar) {
        this.lZM = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(106, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
            bem So = ((ac) kVar).So();
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[]{Integer.valueOf(So.wkk)});
            if (So.wkk > 0) {
                if (So.wkl.isEmpty()) {
                    x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                    c.a(this.lZM, So);
                }
                if (So.wkl.size() > 1) {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("add_more_friend_search_scene", 3);
                        intent.putExtra("result", So.toByteArray());
                        x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                        a.ifs.w(intent, c.a(this.lZM));
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", e, "", new Object[0]);
                        return;
                    }
                }
                c.a(this.lZM, (bek) So.wkl.getFirst());
                return;
            }
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
            c.b(this.lZM, So);
            return;
        }
        x.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        c.a(this.lZM, null);
    }
}
