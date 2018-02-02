package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class d implements a {
    private final Context context;
    private f ilB;

    public d(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bh.ou(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        arS();
        this.ilB = fVar;
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.o.fbn);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.YN("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.vtX = "ContactWidgetBottleContact";
            normalUserHeaderPreference.a(xVar, 0, null);
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) fVar.YN("contact_info_footer_normal");
        boolean booleanExtra = ((Activity) this.context).getIntent().getBooleanExtra("Contact_FMessageCard", false);
        if (normalUserFooterPreference != null) {
            if (!normalUserFooterPreference.a(xVar, "", z, false, true, 25, 0, booleanExtra, false, 0, "")) {
                fVar.c(normalUserFooterPreference);
            }
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.YN("contact_info_signature");
        if (xVar.signature == null || xVar.signature.trim().equals("")) {
            fVar.c(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.yiT = false;
            keyValuePreference.setTitle(this.context.getString(R.l.dWw));
            keyValuePreference.setSummary(i.a(this.context, xVar.signature));
            keyValuePreference.mx(false);
        }
        return true;
    }

    public final boolean arS() {
        if (this.ilB != null) {
            FriendPreference friendPreference = (FriendPreference) this.ilB.YN("contact_info_friend");
            if (friendPreference != null) {
                friendPreference.arS();
            }
            NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ilB.YN("contact_info_header_normal");
            if (normalUserHeaderPreference != null) {
                normalUserHeaderPreference.onDetach();
            }
            NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
            if (normalUserFooterPreference != null) {
                normalUserFooterPreference.arS();
            }
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
