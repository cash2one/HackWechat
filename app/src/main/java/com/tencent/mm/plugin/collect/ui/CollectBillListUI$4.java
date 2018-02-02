package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;

class CollectBillListUI$4 implements OnClickListener {
    final /* synthetic */ CollectBillListUI llF;
    final /* synthetic */ DatePickerDialogView llG;

    CollectBillListUI$4(CollectBillListUI collectBillListUI, DatePickerDialogView datePickerDialogView) {
        this.llF = collectBillListUI;
        this.llG = datePickerDialogView;
    }

    public final void onClick(View view) {
        long timeInMillis;
        if (CollectBillListUI.b(this.llF) == null) {
            CollectBillListUI.a(this.llF, Calendar.getInstance());
        }
        CollectBillListUI.b(this.llF).clear();
        int year = this.llG.lnA.getYear();
        int month = this.llG.lnA.getMonth();
        int dayOfMonth = this.llG.lnA.getDayOfMonth();
        CollectBillListUI.a(this.llF, this.llG.lnA.zuR);
        if (CollectBillListUI.c(this.llF) == 2) {
            CollectBillListUI.b(this.llF).set(1, year);
            timeInMillis = CollectBillListUI.b(this.llF).getTimeInMillis() / 1000;
        } else if (CollectBillListUI.c(this.llF) == 1) {
            CollectBillListUI.b(this.llF).set(1, year);
            CollectBillListUI.b(this.llF).set(2, month);
            timeInMillis = CollectBillListUI.b(this.llF).getTimeInMillis() / 1000;
        } else {
            CollectBillListUI.b(this.llF).set(year, month, dayOfMonth);
            timeInMillis = CollectBillListUI.b(this.llF).getTimeInMillis() / 1000;
        }
        x.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(CollectBillListUI.c(this.llF)), Long.valueOf(timeInMillis)});
        CollectBillListUI.a(this.llF, timeInMillis);
        CollectBillListUI.d(this.llF).dismiss();
    }
}
