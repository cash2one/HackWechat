package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a zDj;

    a$1(a aVar) {
        this.zDj = aVar;
    }

    public final void onClick(View view) {
        if (this.zDj.cAi().getVisibility() == 0) {
            this.zDj.cAl().a(a.b(this.zDj).getText(), a.b(this.zDj).getCurrentTextColor());
        } else {
            this.zDj.cAl().onFinish();
        }
    }
}
