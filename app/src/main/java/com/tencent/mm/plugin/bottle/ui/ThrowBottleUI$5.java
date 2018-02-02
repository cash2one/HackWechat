package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class ThrowBottleUI$5 implements a {
    final /* synthetic */ ThrowBottleUI kEz;

    ThrowBottleUI$5(ThrowBottleUI throwBottleUI) {
        this.kEz = throwBottleUI;
    }

    public final boolean uF() {
        int i = 0;
        if (ThrowBottleUI.r(this.kEz) == null) {
            x.w("MM.Bottle.ThrowBottleUI", "bottle recder is null");
            return false;
        }
        int maxAmplitude = ThrowBottleUI.r(this.kEz).getMaxAmplitude();
        while (i < ThrowBottleUI.asg().length) {
            if (maxAmplitude >= ThrowBottleUI.ash()[i] && maxAmplitude < ThrowBottleUI.ash()[i + 1]) {
                ThrowBottleUI.s(this.kEz).setBackgroundDrawable(com.tencent.mm.bv.a.b(ThrowBottleUI.h(this.kEz), ThrowBottleUI.asg()[i]));
                break;
            }
            i++;
        }
        return true;
    }
}
