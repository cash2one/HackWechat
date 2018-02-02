package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;

class WidgetConsoleUI$2 implements Runnable {
    final /* synthetic */ WidgetConsoleUI iUY;
    final /* synthetic */ String iUZ;

    WidgetConsoleUI$2(WidgetConsoleUI widgetConsoleUI, String str) {
        this.iUY = widgetConsoleUI;
        this.iUZ = str;
    }

    public final void run() {
        this.iUY.setMMTitle(String.format("%s%s", new Object[]{this.iUY.getString(e.khj), this.iUZ}));
        Toast.makeText(this.iUY.mController.xIM, String.format("%s%s", new Object[]{this.iUY.id, this.iUZ}), 1).show();
    }
}
