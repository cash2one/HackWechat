package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.z.a;

final class u$a implements a {
    float jFy;
    float jFz;
    View view;
    float x;
    float y;

    private u$a() {
    }

    public final void bL(int i, int i2) {
        this.jFy = (float) i;
        this.jFz = (float) i2;
        this.view.setX(this.x + ((float) i));
        this.view.setY(this.y + ((float) i2));
    }
}
