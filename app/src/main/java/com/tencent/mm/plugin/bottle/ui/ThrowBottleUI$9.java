package com.tencent.mm.plugin.bottle.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

class ThrowBottleUI$9 implements a {
    final /* synthetic */ ThrowBottleUI kEz;

    ThrowBottleUI$9(ThrowBottleUI throwBottleUI) {
        this.kEz = throwBottleUI;
    }

    public final void onError() {
        ThrowBottleUI.r(this.kEz).reset();
        ThrowBottleUI.z(this.kEz).TG();
        ThrowBottleUI.A(this.kEz).TG();
        ae.Vd("keep_app_silent");
        ThrowBottleUI.x(this.kEz);
        x.v("MM.Bottle.ThrowBottleUI", "bottle record stop on error");
        Toast.makeText(ThrowBottleUI.h(this.kEz), ThrowBottleUI.h(this.kEz).getString(R.l.dSD), 0).show();
    }
}
