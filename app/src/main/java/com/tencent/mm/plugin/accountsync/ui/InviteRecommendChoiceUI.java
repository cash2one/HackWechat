package com.tencent.mm.plugin.accountsync.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.friend.RecommendFriendUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class InviteRecommendChoiceUI extends MMPreference {
    private f ilB;

    protected final boolean XA() {
        return false;
    }

    public final int XB() {
        return R.o.fbO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        Intent intent;
        if (str.equals("settings_invite_qq_friends")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mail")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(2));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mb")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(1));
            startActivity(intent);
        } else if (str.equals("settings_invite_mobile_friends")) {
            intent = new Intent("android.intent.action.VIEW");
            int i = R.l.epT;
            Object[] objArr = new Object[1];
            ar.Hg();
            objArr[0] = c.CU().get(2, null);
            intent.putExtra("sms_body", getString(i, objArr));
            intent.setType("vnd.android-dir/mms-sms");
            if (bh.k(this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, R.l.eJv, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        return false;
    }

    protected final void initView() {
        setMMTitle(R.l.eJM);
        this.ilB = this.yjd;
        this.ilB.c((IconPreference) this.ilB.YN("settings_invite_facebook_friends"));
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_invite_qq_friends");
        if (q.FR() == 0) {
            this.ilB.c(iconPreference);
        }
        iconPreference = (IconPreference) this.ilB.YN("settings_recommend_by_mail");
        if (q.FR() == 0) {
            this.ilB.c(iconPreference);
        }
        iconPreference = (IconPreference) this.ilB.YN("settings_recommend_by_mb");
        ar.Hg();
        if (c.Fg().EY("@t.qq.com") == null) {
            this.ilB.c(iconPreference);
        }
        setBackBtn(new 1(this));
    }
}
