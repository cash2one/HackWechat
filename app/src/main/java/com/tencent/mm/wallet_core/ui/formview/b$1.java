package com.tencent.mm.wallet_core.ui.formview;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.h;
import java.util.Calendar;

class b$1 implements OnClickListener {
    final /* synthetic */ MMActivity lOS;
    final /* synthetic */ WalletFormView zJs;

    b$1(WalletFormView walletFormView, MMActivity mMActivity) {
        this.zJs = walletFormView;
        this.lOS = mMActivity;
    }

    public final void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.add(2, 1);
        b.access$002(instance.get(1));
        b.wq(instance.get(2));
        DatePickerDialog datePickerDialog = (DatePickerDialog) this.zJs.getTag(b.ts());
        if (datePickerDialog == null) {
            datePickerDialog = new h(this.lOS, new 1(this), b.bl(), b.JM(), instance.get(5), instance.getTimeInMillis(), 2);
            this.zJs.setTag(b.ts(), datePickerDialog);
            this.lOS.addDialog(datePickerDialog);
        }
        datePickerDialog.show();
    }
}
