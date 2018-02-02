package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b {
    Context context;
    private f ilB;
    private x jLe;
    private Map<String, Preference> kCt = new HashMap();

    public a(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 2(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gO(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbu);
        arR();
        return true;
    }

    private void arR() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.Gd() & 65536) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_masssend_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVA));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        this.ilB.bk("contact_info_masssend_install", z3);
        f fVar = this.ilB;
        String str = "contact_info_masssend_view";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        fVar = this.ilB;
        str = "contact_info_masssend_clear_data";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        f fVar2 = this.ilB;
        String str2 = "contact_info_masssend_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bk(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        final r a = h.a(context, string, true, null);
        final af 3 = new 3(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    3.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public static void aaS() {
        com.tencent.mm.plugin.masssend.a.b aYD = com.tencent.mm.plugin.masssend.a.h.aYD();
        if (aYD.hhp.fx("massendinfo", "delete from massendinfo")) {
            aYD.doNotify();
        }
        ar.Hg();
        c.Fd().WX("masssendapp");
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.plugin.masssend.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
