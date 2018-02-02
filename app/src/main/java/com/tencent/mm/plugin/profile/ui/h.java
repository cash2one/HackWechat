package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import java.util.List;
import junit.framework.Assert;

public final class h implements a {
    Context context;
    private String iQs;
    private f ilB;
    private x jLe;
    q kZS;
    private boolean phD;
    private boolean phE;
    private int phF;
    private int pji;
    ContactListExpandPreference pjj;

    public h(Context context) {
        this.context = context;
        this.pjj = new ContactListExpandPreference(context, 0);
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetGroupCard", "handleEvent " + str);
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO != null && ((int) WO.gJd) > 0) {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", WO.field_username);
            this.context.startActivity(intent);
        }
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bh.ou(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.ilB = fVar;
        this.jLe = xVar;
        this.phD = z;
        this.phF = i;
        this.phE = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.pji = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.iQs = xVar.field_username;
        ar.Hg();
        this.kZS = c.Fh().hE(this.iQs);
        this.ilB.removeAll();
        this.ilB.a(new PreferenceSmallCategory(this.context));
        this.pjj.setKey("roominfo_contact_anchor");
        this.ilB.a(this.pjj);
        this.ilB.a(new PreferenceCategory(this.context));
        Preference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(R.i.deL);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.jLe, "", this.phD, this.phE, false, this.phF, this.pji, false, false, 0, "")) {
            this.ilB.a(normalUserFooterPreference);
        }
        this.pjj.a(this.ilB, this.pjj.ibD);
        List gj = m.gj(this.iQs);
        this.pjj.la(false).lb(false);
        this.pjj.n(this.iQs, gj);
        this.pjj.a(new 1(this));
        return true;
    }

    public final boolean arS() {
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.arS();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
