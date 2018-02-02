package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ar.b;
import com.tencent.mm.ay.g;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class e implements a {
    Context context;
    private f ilB;
    boolean isDeleteCancel = false;
    private x jLe;
    private boolean phD;
    private HelperHeaderPreference.a pjd;
    private int status;
    r tipDialog = null;

    public e(Context context) {
        this.context = context;
        this.pjd = new o(context);
        this.status = -1;
    }

    public final boolean vQ(String str) {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            boolean z2;
            if (((CheckBoxPreference) this.ilB.YN("contact_info_recommend_qqfriends_to_me")).isChecked()) {
                z2 = false;
            } else {
                z2 = true;
            }
            a(z2, FileUtils.S_IWUSR, 6);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.ilB.YN("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            }
            a(z, 256, 7);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            z = ((CheckBoxPreference) this.ilB.YN("contact_info_recommend_fbfriends_to_me")).isChecked();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = 4 functionId = 18");
            int FY = q.FY();
            FY = z ? FY | 4 : FY & -5;
            ar.Hg();
            c.CU().set(40, Integer.valueOf(FY));
            FY = z ? 1 : 2;
            ar.Hg();
            c.EX().b(new g(18, FY));
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.phD) {
                intent.putExtra("Chat_User", this.jLe.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
                return true;
            }
            intent.putExtra("Chat_User", this.jLe.field_username);
            intent.putExtra("Chat_Mode", 1);
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.ifs.e(intent, this.context);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            com.tencent.mm.plugin.profile.a.ifs.g(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            com.tencent.mm.plugin.profile.a.ifs.h(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    private void a(boolean z, int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        int i3 = z ? 1 : 2;
        ar.Hg();
        c.EX().b(new g(i2, i3));
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gJ(xVar.field_username));
        this.ilB = fVar;
        this.phD = z;
        this.jLe = xVar;
        if (this.status == -1) {
            this.status = q.FW();
        }
        fVar.addPreferencesFromResource(R.o.fbr);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.YN("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) fVar.YN("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) fVar.YN("contact_info_recommend_fbfriends_to_me");
        checkBoxPreference2.tSw = !uR(256);
        if (uR(FileUtils.S_IWUSR)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference.tSw = z3;
        if ((q.FY() & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference3.tSw = z3;
        ((HelperHeaderPreference) fVar.YN("contact_info_header_helper")).a(xVar, this.pjd);
        ar.Hg();
        if (bh.e((Integer) c.CU().get(9, null)) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            fVar.c(fVar.YN("contact_info_bind_qq_entry"));
            fVar.c(fVar.YN("contact_info_bind_qq_entry_tip"));
        } else {
            fVar.c(checkBoxPreference);
            if (!b.PR()) {
                fVar.c(fVar.YN("contact_info_bind_qq_entry"));
                fVar.c(fVar.YN("contact_info_bind_qq_entry_tip"));
            }
        }
        if (m.NN() == m.a.hwi) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            fVar.c(fVar.YN("contact_info_bind_mobile_entry"));
            fVar.c(fVar.YN("contact_info_bind_mobile_entry_tip"));
        } else {
            fVar.c(checkBoxPreference2);
            fVar.YN("contact_info_bind_mobile_entry").setSummary(R.l.eKY);
        }
        if ((q.Gd() & 8192) == 0) {
            z4 = true;
        }
        if (z4) {
            z2 = q.Gt();
            fVar.c(checkBoxPreference3);
            if (z2) {
                fVar.YN("contact_info_bind_fb_entry").setSummary(R.l.dUT);
            } else {
                fVar.YN("contact_info_bind_fb_entry").setSummary(R.l.eKY);
            }
        } else {
            fVar.c(fVar.YN("contact_info_bind_fb_entry"));
            fVar.c(fVar.YN("contact_info_bind_fb_entry_tip"));
            fVar.c(checkBoxPreference3);
        }
        return true;
    }

    private boolean uR(int i) {
        return (this.status & i) != 0;
    }

    public final boolean arS() {
        com.tencent.mm.plugin.profile.a.ift.um();
        this.ilB.YN("contact_info_header_helper");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
