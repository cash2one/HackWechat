package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Timer;
import junit.framework.Assert;

public final class n implements a, b {
    Context context;
    private f ilB;
    private x jLe;

    public n(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_voiceinput_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_voiceinput_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ n pjM;

                {
                    this.pjM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    n.g(this.pjM.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gY(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbE);
        arR();
        return true;
    }

    private void arR() {
        int i;
        boolean z = true;
        boolean z2 = (q.Gd() & 33554432) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dXh));
        if (z2) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        this.ilB.bk("contact_info_voiceinput_install", z2);
        f fVar = this.ilB;
        String str = "contact_info_voiceinput_uninstall";
        if (z2) {
            z = false;
        }
        fVar.bk(str, z);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new Timer().schedule(new 3(h.a(context, string, true, null), new 2(z, null)), 1500);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.plugin.profile.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
