package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class e$1 implements OnClickListener {
    final /* synthetic */ e nIr;

    e$1(e eVar) {
        this.nIr = eVar;
    }

    public final void onClick(View view) {
        Object obj;
        boolean z;
        ar.Hg();
        boolean booleanValue = ((Boolean) c.CU().get(a.xph, Boolean.valueOf(false))).booleanValue();
        if (booleanValue) {
            ar.Hg();
            i.N(2, ((Integer) c.CU().get(a.xpi, Integer.valueOf(-1))).intValue(), -1);
            ar.Hg();
            c.CU().a(a.xpi, Integer.valueOf(-1));
            x.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", new Object[]{Integer.valueOf(r0)});
        }
        if (booleanValue) {
            obj = "true";
        } else {
            String str = "false";
        }
        ar.Hg();
        String str2 = (String) c.CU().get(a.xpj, "");
        x.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", new Object[]{obj, str2});
        ar.Hg();
        c.CU().a(a.xph, Boolean.valueOf(false));
        ar.Hg();
        c.CU().a(a.xpj, "");
        ar.Hg();
        if (((Integer) c.CU().get(a.xpl, Integer.valueOf(0))).intValue() == 1) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ar.Hg();
            x.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", new Object[]{(String) c.CU().get(a.xpk, "")});
            ar.Hg();
            c.CU().a(a.xpk, "");
        }
        g.pQN.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        this.nIr.aUo();
        Intent intent = new Intent();
        intent.setClass(this.nIr.nIk, IPCallShareCouponUI.class);
        this.nIr.nIk.startActivity(intent);
    }
}
