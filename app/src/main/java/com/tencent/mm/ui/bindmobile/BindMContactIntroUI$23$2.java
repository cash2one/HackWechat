package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI.23;

class BindMContactIntroUI$23$2 implements p$d {
    final /* synthetic */ 23 ylM;

    BindMContactIntroUI$23$2(23 23) {
        this.ylM = 23;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                BindMContactIntroUI.d(this.ylM.ylI);
                return;
            case 1:
                Intent intent = new Intent();
                intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                d.b(this.ylM.ylI, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                return;
            default:
                return;
        }
    }
}
