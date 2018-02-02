package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.lj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SettingsModifyNameUI$1 extends c<lj> {
    final /* synthetic */ SettingsModifyNameUI qkd;

    SettingsModifyNameUI$1(SettingsModifyNameUI settingsModifyNameUI) {
        this.qkd = settingsModifyNameUI;
        super(0);
        this.xen = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lj ljVar = (lj) bVar;
        String str = ljVar.fCK.fCL;
        String str2 = ljVar.fCK.fCM;
        int i = ljVar.fCK.ret;
        if (i != 0 && str2 != null) {
            h.b(this.qkd, str2, str, true);
            if (SettingsModifyNameUI.a(this.qkd) != null) {
                ar.Hg();
                com.tencent.mm.z.c.EX().c(SettingsModifyNameUI.a(this.qkd));
            }
        } else if (i == 0 && SettingsModifyNameUI.b(this.qkd)) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(4, SettingsModifyNameUI.c(this.qkd).getText().toString());
            this.qkd.finish();
        }
        if (SettingsModifyNameUI.d(this.qkd) != null) {
            SettingsModifyNameUI.d(this.qkd).dismiss();
        }
        return true;
    }
}
