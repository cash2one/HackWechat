package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public final Activity activity;
    public boolean jWE = false;
    public int jWF = 0;

    public a(Activity activity) {
        this.activity = activity;
    }

    public final void amu() {
        if (this.jWE && !this.activity.isFinishing() && VERSION.SDK_INT < 20) {
            l k = l.k(this.activity);
            if (k == null) {
                x.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
            } else {
                a(k);
            }
        }
    }

    public final void a(l lVar) {
        int i;
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int eb = e.eb(this.activity);
        int i2 = point.y;
        if (this.activity.getWindow() == null || (this.activity.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) <= 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            eb = 0;
        }
        x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[]{Integer.valueOf(i2 - eb)});
        lVar.jXD = eb;
    }
}
