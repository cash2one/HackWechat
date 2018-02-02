package com.tencent.mm.wallet_core.ui.formview;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.formview.b.1;
import com.tencent.mm.z.q;
import java.text.DecimalFormat;

class b$1$1 implements OnDateSetListener {
    final /* synthetic */ 1 zJF;

    b$1$1(1 1) {
        this.zJF = 1;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        if (i >= b.zIM || i2 >= b.zIN) {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            if (q.Gf()) {
                this.zJF.zJs.setTag(decimalFormat.format((long) (i2 + 1)) + i);
            } else {
                this.zJF.zJs.setTag(decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1)));
            }
            this.zJF.zJs.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
        } else {
            h.b(this.zJF.lOS, this.zJF.lOS.getString(i.uRw), null, true);
        }
        if (this.zJF.zJs.zJH != null) {
            this.zJF.zJs.zJH.hx(this.zJF.zJs.XO());
        }
    }
}
