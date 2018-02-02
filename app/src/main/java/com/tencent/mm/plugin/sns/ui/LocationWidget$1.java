package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LocationWidget$1 implements OnClickListener {
    final /* synthetic */ int hHw;
    final /* synthetic */ LocationWidget rum;

    LocationWidget$1(LocationWidget locationWidget, int i) {
        this.rum = locationWidget;
        this.hHw = i;
    }

    public final void onClick(View view) {
        if (LocationWidget.a(this.rum) == this.hHw + 1) {
            LocationWidget.b(this.rum);
        } else {
            LocationWidget.a(this.rum, this.hHw + 1);
        }
        LocationWidget.c(this.rum);
    }
}
