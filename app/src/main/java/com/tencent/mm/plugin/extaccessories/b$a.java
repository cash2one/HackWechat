package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class b$a extends c<mz> {
    public b$a() {
        this.xen = mz.class.getName().hashCode();
    }

    private boolean a(mz mzVar) {
        if (mzVar instanceof mz) {
            x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
            if (!(mzVar.fEV == null || mzVar.fEV.fEX == null || mzVar.fEV.fEW == null)) {
                try {
                    new SlookWritingBuddy(mzVar.fEV.fEX).setImageWritingListener(new 1(this, mzVar));
                } catch (Exception e) {
                    x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[]{e.getMessage()});
                }
            }
            return true;
        }
        x.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        return false;
    }
}
