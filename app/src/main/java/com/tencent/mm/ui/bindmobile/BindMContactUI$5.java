package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class BindMContactUI$5 implements OnClickListener {
    final /* synthetic */ BindMContactUI ylT;

    BindMContactUI$5(BindMContactUI bindMContactUI) {
        this.ylT = bindMContactUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("country_name", BindMContactUI.g(this.ylT));
        intent.putExtra("couttry_code", BindMContactUI.c(this.ylT));
        a.ifs.b(intent, this.ylT);
    }
}
