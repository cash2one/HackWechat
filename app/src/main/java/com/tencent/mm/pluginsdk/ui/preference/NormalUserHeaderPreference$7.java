package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;

class NormalUserHeaderPreference$7 implements Runnable {
    final /* synthetic */ bf phM;
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$7(NormalUserHeaderPreference normalUserHeaderPreference, bf bfVar) {
        this.vtY = normalUserHeaderPreference;
        this.phM = bfVar;
    }

    public final void run() {
        if (NormalUserHeaderPreference.b(this.vtY) != null && this.phM != null && NormalUserHeaderPreference.b(this.vtY).field_username.equals(this.phM.field_encryptUsername)) {
            NormalUserHeaderPreference.b(this.vtY).da(this.phM.field_conRemark);
            if (NormalUserHeaderPreference.j(this.vtY)) {
                NormalUserHeaderPreference.f(this.vtY);
            } else {
                x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(this.vtY) + "contact = " + NormalUserHeaderPreference.b(this.vtY).field_username);
            }
        }
    }
}
