package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class m implements a, b {
    Context context;
    private boolean fqP;
    private f ilB;
    private x jLe;

    public m(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if ("contact_info_go_to_sync".equals(str)) {
            if (p.m(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.context.startActivity(launchIntentForPackage);
            } else {
                h.a(this.context, R.l.dVW, R.l.dGO, R.l.dEz, R.l.dEn, new 2(this), null);
            }
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_remind_me_syncing");
            ar.Hg();
            c.CU().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            bo.r(6, checkBoxPreference.isChecked() ? "1" : "2");
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            j(this.context, true);
            return true;
        } else if (!str.equals("contact_info_qqsync_uninstall")) {
            return false;
        } else {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        }
    }

    final void j(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        ar.Dm().F(new 3(this, z, h.a(context, string, true, null)));
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        ar.Hg();
        c.CU().a(this);
        this.ilB = fVar;
        this.jLe = xVar;
        fVar.addPreferencesFromResource(R.o.fbA);
        arR();
        return true;
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (this.fqP != q.Gn()) {
            arR();
        }
    }

    private void arR() {
        boolean z;
        boolean z2 = true;
        this.fqP = q.Gn();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVX));
        helperHeaderPreference.nx(this.fqP ? 1 : 0);
        f fVar = this.ilB;
        String str = "contact_info_go_to_sync";
        if (this.fqP) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        fVar = this.ilB;
        str = "contact_info_remind_me_syncing_tip";
        if (this.fqP) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        this.ilB.bk("contact_info_qqsync_install", this.fqP);
        f fVar2 = this.ilB;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.fqP) {
            z2 = false;
        }
        fVar2.bk(str2, z2);
    }
}
