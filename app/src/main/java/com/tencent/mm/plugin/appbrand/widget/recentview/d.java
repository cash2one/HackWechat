package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

public interface d extends com.tencent.mm.kernel.c.a {

    public interface a {
        LocalUsageInfo aje();
    }

    public enum b {
        ;

        static {
            kfH = 1;
            kfI = 2;
            kfJ = new int[]{kfH, kfI};
        }
    }

    AppBrandRecentView a(Context context, int i, a aVar);

    void ami();

    b amj();

    void cj(Context context);

    AppBrandRecentView y(Context context, int i);
}
