package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.h;
import java.util.Calendar;

class EditHintView$6 implements OnClickListener {
    final /* synthetic */ EditHintView zIQ;

    EditHintView$6(EditHintView editHintView) {
        this.zIQ = editHintView;
    }

    public final void onClick(View view) {
        if (EditHintView.h(this.zIQ) == null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            instance.add(2, 1);
            EditHintView.a(this.zIQ, instance.get(1));
            EditHintView.b(this.zIQ, instance.get(2));
            EditHintView.a(this.zIQ, new h(this.zIQ.getContext(), new 1(this), EditHintView.i(this.zIQ), EditHintView.j(this.zIQ), instance.get(5), instance.getTimeInMillis()));
        }
        EditHintView.h(this.zIQ).show();
    }
}
