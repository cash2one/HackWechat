package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandStickyBannerLogic$b {
    static final Set<f> gCl = new HashSet();

    public static void y(Intent intent) {
        if (intent != null && g.Dh().Cy()) {
            g.Dm().F(new 1(intent));
        }
    }

    static void b(OperateTask operateTask) {
        if (b.a(operateTask)) {
            alk();
        }
    }

    static void ald() {
        AppBrandStickyBannerLogic.access$200();
    }

    private static void alk() {
        BannerModel all = BannerModel.all();
        String str = all == null ? null : all.appId;
        int i = all == null ? -1 : all.iKd;
        synchronized (gCl) {
            for (f ak : gCl) {
                ak.ak(str, i);
            }
        }
    }

    public static void d(f fVar) {
        if (fVar != null) {
            synchronized (gCl) {
                gCl.add(fVar);
            }
        }
    }

    public static void c(f fVar) {
        if (fVar != null) {
            synchronized (gCl) {
                gCl.remove(fVar);
            }
        }
    }

    public static boolean aM(String str, int i) {
        AppBrandStickyBannerLogic.access$200();
        return false;
    }

    public static void aN(String str, int i) {
        AppBrandStickyBannerLogic.access$200();
    }
}
