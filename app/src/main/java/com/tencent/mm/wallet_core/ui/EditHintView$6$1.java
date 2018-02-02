package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.EditHintView.6;
import com.tencent.mm.z.q;
import java.text.DecimalFormat;

class EditHintView$6$1 implements OnDateSetListener {
    final /* synthetic */ 6 zIR;

    EditHintView$6$1(6 6) {
        this.zIR = 6;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        if (i >= this.zIR.zIQ.zIM || i2 >= this.zIR.zIQ.zIN) {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            if (q.Gf()) {
                this.zIR.zIQ.zIK = decimalFormat.format((long) (i2 + 1)) + i;
            } else {
                this.zIR.zIQ.zIK = decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1));
            }
            this.zIR.zIQ.zIF.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
        } else {
            h.b(this.zIR.zIQ.getContext(), this.zIR.zIQ.getContext().getString(i.uRw), null, true);
        }
        this.zIR.zIQ.imY = this.zIR.zIQ.XO();
        if (this.zIR.zIQ.zID != null) {
            x.d("MicroMsg.EditHintView", "View:" + this.zIR.zIQ.imT + ", editType:" + this.zIR.zIQ.imU + " inputValid change to " + this.zIR.zIQ.imY);
        }
    }
}
