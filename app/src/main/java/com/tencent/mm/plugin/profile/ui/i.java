package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import junit.framework.Assert;

public final class i implements a, b {
    Context context;
    private f ilB;
    private x jLe;
    private HelperHeaderPreference.a pjl;

    public i(Context context) {
        this.context = context;
        this.pjl = new r(context);
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_linkedin_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ i pjm;

                {
                    this.pjm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.g(this.pjm.context, false);
                }
            }, null);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                d.c(this.context, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", 1);
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gZ(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        arR();
        return true;
    }

    private void arR() {
        boolean z = (q.Gd() & 16777216) == 0;
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbt);
        ((HelperHeaderPreference) this.ilB.YN("contact_info_header_helper")).a(this.jLe, this.pjl);
        if (z) {
            this.ilB.bk("contact_info_linkedin_account", false);
            this.ilB.YO("contact_info_linkedin_install");
            return;
        }
        this.ilB.bk("contact_info_linkedin_account", true);
        this.ilB.YO("contact_info_linkedin_uninstall");
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new ak(new 2(h.a(context, string, true, null), z, null), false).J(1500, 1500);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        this.ilB.YN("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.ift.um();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            arR();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 40 || intValue == 34) {
                arR();
            }
        }
    }
}
