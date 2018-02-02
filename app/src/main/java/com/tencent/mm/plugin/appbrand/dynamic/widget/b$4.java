package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements OnCancelListener {
    final /* synthetic */ b$a iVE;
    final /* synthetic */ b iVG;

    b$4(b bVar, b$a com_tencent_mm_plugin_appbrand_dynamic_widget_b_a) {
        this.iVG = bVar;
        this.iVE = com_tencent_mm_plugin_appbrand_dynamic_widget_b_a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        this.iVE.d(3, null);
    }
}
