package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.setting.modelsimple.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.modelsimple.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.base.r;
import java.util.List;

public class SettingsModifyUserAuthUI extends MMPreference implements e {
    private String appId;
    private r ilH;
    private h qke;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qke = this.yjd;
        List<UserAuthItemParcelable> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("app_auth_items");
        this.appId = getIntent().getStringExtra("app_id");
        this.scene = getIntent().getIntExtra("modify_scene", 1);
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            for (UserAuthItemParcelable userAuthItemParcelable : parcelableArrayListExtra) {
                boolean z;
                Preference checkBoxPreference = new CheckBoxPreference(this);
                checkBoxPreference.setTitle(userAuthItemParcelable.qgh);
                if (userAuthItemParcelable.scope.equals("snsapi_friend")) {
                    checkBoxPreference.setSummary(R.l.eKU);
                }
                checkBoxPreference.setKey(userAuthItemParcelable.scope);
                if (userAuthItemParcelable.state == 1) {
                    z = true;
                } else {
                    z = false;
                }
                checkBoxPreference.tSw = z;
                checkBoxPreference.yjI = false;
                this.qke.a(checkBoxPreference, -1);
            }
        }
        setMMTitle(getIntent().getStringExtra("app_name"));
        setBackBtn(new 1(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        x.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", new Object[]{Integer.valueOf(i2), str});
        if (this.ilH != null) {
            this.ilH.dismiss();
        }
        if (i == 0 && i2 == 0) {
            String str2 = ((g) kVar).qgb;
            int i3 = ((g) kVar).qgc;
            if (!bh.ov(str2)) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.qke.YN(str2);
                if (i3 != 1) {
                    z = false;
                }
                checkBoxPreference.tSw = z;
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.h.bu(this, str);
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.CG().a(1144, this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.CG().b(1144, this);
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        int i;
        if (((CheckBoxPreference) preference).isChecked()) {
            i = 1;
        } else {
            i = 2;
        }
        k gVar = new g(this.appId, preference.ibD, i, this.scene);
        com.tencent.mm.kernel.g.CG().a(gVar, 0);
        this.ilH = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dGB), true, new 2(this, gVar));
        return true;
    }
}
