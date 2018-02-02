package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import junit.framework.Assert;

abstract class l implements a, b {
    protected Context context;
    protected f ilB;
    protected x jLe;
    protected HelperHeaderPreference.a pjI;

    protected abstract int XB();

    protected abstract boolean bjz();

    protected abstract void clear();

    protected abstract void hi(boolean z);

    public l(Context context, HelperHeaderPreference.a aVar) {
        this.context = context;
        this.pjI = aVar;
    }

    public void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(xVar != null);
        if (bh.ou(xVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        arR();
        return true;
    }

    public boolean arS() {
        ar.Hg();
        c.CU().b(this);
        this.ilB.YN("contact_info_header_helper");
        return true;
    }

    public boolean vQ(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ l pjJ;

                {
                    this.pjJ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pjJ.clear();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            hi(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 2(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = " + str);
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void arR() {
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(XB());
        boolean bjz = bjz();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.jLe, this.pjI);
        }
        if (bjz) {
            this.ilB.YO("contact_info_plugin_install");
            return;
        }
        this.ilB.YO("contact_info_plugin_view");
        this.ilB.YO("contact_info_plugin_clear_data");
        this.ilB.YO("contact_info_plugin_uninstall");
    }
}
