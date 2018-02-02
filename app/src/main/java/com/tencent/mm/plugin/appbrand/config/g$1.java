package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.by.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.af;
import java.util.Locale;

class g$1 extends af {
    final /* synthetic */ g iOf;

    public g$1(g gVar) {
        this.iOf = gVar;
    }

    public final void transfer(int i) {
        if (gN(i)) {
            try {
                x.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                f Zd = f.Zd();
                if (Zd != null) {
                    h Ze = Zd.Ze();
                    f.Zh();
                    Ze.fx("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[]{"WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"}));
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", new Object[]{e});
            }
        }
    }

    public final boolean gN(int i) {
        return i >= 637863936 && i <= 637863988;
    }

    public final String getTag() {
        return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
    }
}
