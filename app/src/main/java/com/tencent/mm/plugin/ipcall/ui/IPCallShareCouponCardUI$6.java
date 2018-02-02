package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;

class IPCallShareCouponCardUI$6 extends ClickableSpan {
    final /* synthetic */ IPCallShareCouponCardUI nMs;
    final /* synthetic */ String nMx;

    IPCallShareCouponCardUI$6(IPCallShareCouponCardUI iPCallShareCouponCardUI, String str) {
        this.nMs = iPCallShareCouponCardUI;
        this.nMx = str;
    }

    public final void onClick(View view) {
        ((TextView) view).setHighlightColor(this.nMs.getResources().getColor(R.e.transparent));
        g.pQN.h(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1)});
        h.b(this.nMs.mController.xIM, this.nMx, this.nMs.getString(R.l.esh), true).a(R.l.eqy, new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI$6 nMy;

            {
                this.nMy = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.nMs.getResources().getColor(R.e.btd));
        textPaint.setUnderlineText(false);
    }
}
