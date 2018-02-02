package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Timer;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b, ao {
    Context context;
    private f ilB;
    private x jLe;

    public a(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetShake", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gT(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        ar.Hg();
        c.a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbC);
        arR();
        return true;
    }

    private void arR() {
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.Gd() & 256) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            int i;
            helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dWv));
            if (z3) {
                i = 1;
            } else {
                i = 0;
            }
            helperHeaderPreference.nx(i);
        }
        this.ilB.bk("contact_info_shake_install", z3);
        f fVar = this.ilB;
        String str = "contact_info_shake_go_shake";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        f fVar2 = this.ilB;
        String str2 = "contact_info_shake_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bk(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new Timer().schedule(new 3(h.a(context, string, true, null), new 2(z, null)), 1500);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        ar.Hg();
        c.b(this);
        com.tencent.mm.plugin.shake.a.ift.um();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void GX() {
        arR();
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 7 || o == 34) {
            arR();
        }
    }
}
