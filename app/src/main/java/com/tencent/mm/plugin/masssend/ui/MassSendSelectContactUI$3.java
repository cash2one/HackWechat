package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;

class MassSendSelectContactUI$3 implements a {
    final /* synthetic */ MassSendSelectContactUI oob;

    MassSendSelectContactUI$3(MassSendSelectContactUI massSendSelectContactUI) {
        this.oob = massSendSelectContactUI;
    }

    public final void oE(String str) {
        if (str != null) {
            MassSendSelectContactUI.a(this.oob).remove(str);
            MassSendSelectContactUI.a(this.oob, MassSendSelectContactUI.a(this.oob).size());
        }
    }
}
