package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class a$21 implements OnClickListener {
    final /* synthetic */ CheckBox AsD;
    final /* synthetic */ a Asx;

    a$21(a aVar, CheckBox checkBox) {
        this.Asx = aVar;
        this.AsD = checkBox;
    }

    public final void onClick(View view) {
        this.AsD.setChecked(!this.AsD.isChecked());
    }
}
