package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

final class ag$c extends ContextWrapper {
    private Resources mResources;

    public ag$c(Context context) {
        super(context);
    }

    public final Resources getResources() {
        if (this.mResources != null && (this.mResources instanceof ag$d)) {
            return this.mResources;
        }
        Resources resources = super.getResources();
        this.mResources = new ag$d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        return this.mResources;
    }
}
