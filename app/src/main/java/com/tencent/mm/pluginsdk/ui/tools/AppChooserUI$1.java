package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;

class AppChooserUI$1 implements OnItemClickListener {
    final /* synthetic */ AppChooserUI vwh;

    AppChooserUI$1(AppChooserUI appChooserUI) {
        this.vwh = appChooserUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (AppChooserUI.a(this.vwh) != null) {
            AppChooserUI.a(this.vwh, AppChooserUI.a(this.vwh).Cy(i));
            AppChooserUI.a(this.vwh).notifyDataSetChanged();
            if (AppChooserUI.b(this.vwh) != null && AppChooserUI.b(this.vwh).iol.isShowing()) {
                if (AppChooserUI.c(this.vwh) == null || !AppChooserUI.c(this.vwh).vwo || (AppChooserUI.c(this.vwh).nBi && (AppChooserUI.c(this.vwh).sgu || AppChooserUI.d(this.vwh) >= AppChooserUI.e(this.vwh)))) {
                    AppChooserUI.b(this.vwh).lp(true);
                } else {
                    AppChooserUI.b(this.vwh).lp(false);
                }
            }
            if ((AppChooserUI.f(this.vwh) == 6 || AppChooserUI.g(this.vwh) == 2) && AppChooserUI.c(this.vwh) != null && AppChooserUI.c(this.vwh).vwl != null) {
                AppChooserUI.a(this.vwh, AppChooserUI.c(this.vwh).vwl.activityInfo.packageName, false);
                g.pQN.h(12809, new Object[]{Integer.valueOf(4), AppChooserUI.c(this.vwh).vwl.activityInfo.packageName});
            }
        }
    }
}
