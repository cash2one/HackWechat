package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class AddMoreFriendsByOtherWayUI extends MMPreference {
    private f ilB;

    public final int XB() {
        return R.o.fbe;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        if (((IconPreference) this.ilB.YN("find_friends_by_google_account")) != null) {
            if (((q.Gd() & 8388608) == 0 ? 1 : null) == null || !bh.PT()) {
                this.ilB.YO("find_friends_by_google_account");
            }
        }
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 0;
        x.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", new Object[]{preference.ibD});
        Intent intent;
        if ("find_friends_by_mobile".equals(preference.ibD)) {
            if (m.NN() != a.hwi) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.A(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if (!"find_friends_by_google_account".equals(preference.ibD)) {
            return false;
        } else {
            ar.Hg();
            if (!TextUtils.isEmpty((String) c.CU().get(208903, null))) {
                i = 1;
            }
            if (i == 0) {
                intent = new Intent(this, BindGoogleContactUI.class);
                intent.putExtra("enter_scene", 1);
                MMWizardActivity.A(this, intent);
                return true;
            }
            intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", 1);
            startActivity(intent);
            return true;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dCv);
        this.ilB = this.yjd;
        setBackBtn(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
