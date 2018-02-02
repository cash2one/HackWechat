package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import android.view.View;
import android.view.ViewParent;

abstract class ad$a<Source extends View, Target extends View> {
    private Target oM;

    abstract boolean ca(View view);

    abstract Target cb(View view);

    private ad$a() {
    }

    public final Target cc(Source source) {
        if (this.oM != null && z.ak(this.oM)) {
            return this.oM;
        }
        if (source == null || !z.ak(source)) {
            return null;
        }
        for (ViewParent parent = source.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ca((View) parent)) {
                Target cb = cb((View) parent);
                this.oM = cb;
                return cb;
            }
        }
        return null;
    }
}
