package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mm.plugin.appbrand.compat.a.b.d;

abstract class m<T extends IOverlay> implements d {
    final T iMt;

    m(T t) {
        this.iMt = t;
    }

    public final void remove() {
        if (this.iMt != null) {
            this.iMt.remove();
        }
    }

    public final String getId() {
        return this.iMt == null ? "" : this.iMt.getId();
    }
}
