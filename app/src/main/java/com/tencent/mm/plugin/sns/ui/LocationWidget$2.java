package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.x;

class LocationWidget$2 implements OnClickListener {
    final /* synthetic */ LocationWidget rum;

    LocationWidget$2(LocationWidget locationWidget) {
        this.rum = locationWidget;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a(LocationWidget.d(this.rum), "android.permission.ACCESS_COARSE_LOCATION", 64, "", ""))});
        if (a.a(LocationWidget.d(this.rum), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
            this.rum.bzw();
        }
    }
}
