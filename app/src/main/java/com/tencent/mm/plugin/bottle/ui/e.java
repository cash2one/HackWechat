package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class e implements a, b {
    final Context context;
    private boolean fqP;
    private f ilB;
    private x jLe;
    private final Map<String, Preference> kCt = new HashMap();
    private int status;

    public e(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFloatBottle", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_goto_floatbottle")) {
            bi HQ = bi.HQ();
            if (bh.a(Integer.valueOf(HQ.fWf), 0) <= 0 || bh.ov(HQ.getProvince())) {
                this.context.startActivity(new Intent(this.context, BottleWizardStep1.class));
            } else {
                this.context.startActivity(new Intent(this.context, BottleBeachUI.class));
            }
            return true;
        } else if (str.equals("contact_info_floatbottle_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_floatbottle_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_floatbottle_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 2(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFloatBottle", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gL(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbq);
        Preference YN = fVar.YN("contact_info_header_helper");
        if (YN != null) {
            this.kCt.put("contact_info_header_helper", YN);
        }
        YN = fVar.YN("contact_info_goto_floatbottle");
        if (YN != null) {
            this.kCt.put("contact_info_goto_floatbottle", YN);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.YN("contact_info_floatbottle_hide_cat");
        if (preferenceCategory != null) {
            this.kCt.put("contact_info_floatbottle_hide_cat", preferenceCategory);
        }
        YN = fVar.YN("contact_info_floatbottle_clear_data");
        if (YN != null) {
            this.kCt.put("contact_info_floatbottle_clear_data", YN);
        }
        preferenceCategory = (PreferenceCategory) fVar.YN("contact_info_floatbottle_hide_cat2");
        if (preferenceCategory != null) {
            this.kCt.put("contact_info_floatbottle_hide_cat2", preferenceCategory);
        }
        preferenceCategory = (PreferenceCategory) fVar.YN("contact_info_floatbottle_hide_cat3");
        if (preferenceCategory != null) {
            this.kCt.put("contact_info_floatbottle_hide_cat3", preferenceCategory);
        }
        YN = fVar.YN("contact_info_floatbottle_install");
        if (YN != null) {
            this.kCt.put("contact_info_floatbottle_install", YN);
        }
        YN = fVar.YN("contact_info_floatbottle_uninstall");
        if (YN != null) {
            this.kCt.put("contact_info_floatbottle_uninstall", YN);
        }
        arR();
        return true;
    }

    private void arR() {
        int i = 1;
        this.status = q.FW();
        this.fqP = (q.Gd() & 64) == 0;
        this.ilB.removeAll();
        if (this.kCt.containsKey("contact_info_header_helper")) {
            this.ilB.a((HelperHeaderPreference) this.kCt.get("contact_info_header_helper"));
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
            helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVe));
            if (!this.fqP) {
                i = 0;
            }
            helperHeaderPreference.nx(i);
        }
        if (this.kCt.containsKey("contact_info_floatbottle_hide_cat")) {
            this.ilB.a((Preference) this.kCt.get("contact_info_floatbottle_hide_cat"));
        }
        if (this.fqP) {
            if (this.kCt.containsKey("contact_info_goto_floatbottle")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_goto_floatbottle"));
            }
            if (this.kCt.containsKey("contact_info_floatbottle_clear_data")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_floatbottle_clear_data"));
            }
            if (this.kCt.containsKey("contact_info_floatbottle_hide_cat2")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_floatbottle_hide_cat2"));
            }
            if (this.kCt.containsKey("contact_info_floatbottle_uninstall")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_floatbottle_uninstall"));
            }
        } else if (this.kCt.containsKey("contact_info_floatbottle_install")) {
            this.ilB.a((Preference) this.kCt.get("contact_info_floatbottle_install"));
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new Timer().schedule(new 4(h.a(context, string, true, null), new 3(z, null)), 1500);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.plugin.bottle.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
