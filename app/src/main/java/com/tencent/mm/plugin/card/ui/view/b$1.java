package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.card.a.f;

class b$1 implements OnClickListener {
    final /* synthetic */ f kWk;
    final /* synthetic */ b kWl;

    b$1(b bVar, f fVar) {
        this.kWl = bVar;
        this.kWk = fVar;
    }

    public final void onClick(View view) {
        if (((CheckBox) view).isChecked()) {
            this.kWk.aua().kKd = true;
        } else {
            this.kWk.aua().kKd = false;
        }
    }
}
