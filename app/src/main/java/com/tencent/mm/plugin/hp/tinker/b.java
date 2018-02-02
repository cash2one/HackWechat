package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.app.n;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class b extends a {
    private final int nBg;

    public b(Context context) {
        super(context);
        this.nBg = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.nBg, new Object[0]);
    }

    public final int cU(String str, String str2) {
        boolean z = false;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[]{str, Long.valueOf(SharePatchFileUtil.af(new File(str)))});
        int cU = super.cU(str, str2);
        if (cU == 0) {
            cU = this.nBg < 45 ? -23 : !c.dx(83886080) ? -21 : 0;
        }
        if (cU == 0) {
            com.tencent.tinker.lib.e.a.ip(this.context);
            if (cU == 0) {
                Properties al = ShareTinkerInternals.al(r3);
                if (al == null) {
                    cU = -24;
                } else {
                    String property = al.getProperty("patch.basepack.client.ver");
                    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:" + property, new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(BaseBuildInfo.CLIENT_VERSION)) {
                        cU = -25;
                    }
                }
            }
        }
        if (cU == 0 && ShareTinkerInternals.cHg() && n.a(new Throwable().getStackTrace())) {
            cU = -26;
        }
        if (cU == 0) {
            z = true;
        }
        com.tencent.mm.plugin.hp.b.b.fM(z);
        return cU;
    }
}
