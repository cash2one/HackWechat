package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

class ShakeReportUI$7 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$7(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(View view) {
        if (ShakeReportUI.t(this.qsi)) {
            ShakeReportUI.b(this.qsi, false);
            ShakeReportUI.c(this.qsi, true);
            ShakeReportUI.d(this.qsi, false);
            h.a(this.qsi.mController.xIM, null, new String[]{this.qsi.getString(R.l.eOw)}, "", new c(this) {
                final /* synthetic */ ShakeReportUI$7 qsk;

                {
                    this.qsk = r1;
                }

                public final void jl(int i) {
                    ShakeReportUI.b(this.qsk.qsi, true);
                    switch (i) {
                        case 0:
                            k.a(this.qsk.qsi, 1, null);
                            return;
                        default:
                            return;
                    }
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ ShakeReportUI$7 qsk;

                {
                    this.qsk = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ShakeReportUI.b(this.qsk.qsi, true);
                }
            });
        }
    }
}
