package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class f implements a, b {
    Context context;
    private com.tencent.mm.ui.base.preference.f ilB;
    private x jLe;
    private Map<String, Preference> kCt = new HashMap();
    private HelperHeaderPreference.a pjf;

    public f(Context context) {
        this.context = context;
        this.pjf = new p(context);
        ar.Hg();
        c.Fd().Xa("facebookapp");
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_facebookapp_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            d.b(this.context, "", "com.tencent.mm.ui.account.FacebookFriendUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gN(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbo);
        Preference YN = fVar.YN("contact_info_header_helper");
        if (YN != null) {
            this.kCt.put("contact_info_header_helper", YN);
        }
        YN = fVar.YN("contact_info_facebookapp_listfriend");
        if (YN != null) {
            this.kCt.put("contact_info_facebookapp_listfriend", YN);
        }
        YN = fVar.YN("contact_info_facebookapp_connect");
        if (YN != null) {
            this.kCt.put("contact_info_facebookapp_connect", YN);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.YN("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.kCt.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        YN = fVar.YN("contact_info_facebookapp_addr");
        if (YN != null) {
            this.kCt.put("contact_info_facebookapp_addr", YN);
        }
        preferenceCategory = (PreferenceCategory) fVar.YN("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.kCt.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        YN = fVar.YN("contact_info_facebookapp_install");
        if (YN != null) {
            this.kCt.put("contact_info_facebookapp_install", YN);
        }
        YN = fVar.YN("contact_info_facebookapp_uninstall");
        if (YN != null) {
            this.kCt.put("contact_info_facebookapp_uninstall", YN);
        }
        arR();
        return true;
    }

    private void arR() {
        this.ilB.removeAll();
        if (this.kCt.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.kCt.get("contact_info_header_helper");
            helperHeaderPreference.a(this.jLe, this.pjf);
            this.ilB.a(helperHeaderPreference);
        }
        if (this.kCt.containsKey("contact_info_facebookapp_cat")) {
            this.ilB.a((Preference) this.kCt.get("contact_info_facebookapp_cat"));
        }
        if (((q.Gd() & 8192) == 0 ? 1 : null) != null) {
            if (q.Gt()) {
                if (this.kCt.containsKey("contact_info_facebookapp_addr")) {
                    this.ilB.a((Preference) this.kCt.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.kCt.get("contact_info_facebookapp_addr");
                    ar.Hg();
                    preference.setSummary((String) c.CU().get(65826, null));
                }
            } else if (this.kCt.containsKey("contact_info_facebookapp_connect")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_facebookapp_connect"));
            }
            if (this.kCt.containsKey("contact_info_facebookapp_cat2")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_facebookapp_cat2"));
            }
            if (this.kCt.containsKey("contact_info_facebookapp_uninstall")) {
                this.ilB.a((Preference) this.kCt.get("contact_info_facebookapp_uninstall"));
            }
        } else if (this.kCt.containsKey("contact_info_facebookapp_install")) {
            this.ilB.a((Preference) this.kCt.get("contact_info_facebookapp_install"));
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new Timer().schedule(new 3(h.a(context, string, true, null), new 2(z, null)), 1500);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        this.kCt.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 65825) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
