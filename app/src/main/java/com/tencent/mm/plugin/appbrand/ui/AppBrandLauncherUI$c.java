package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.q.j.a;
import java.util.List;

public abstract class AppBrandLauncherUI$c<T> extends a {
    public final List<T> jKY;
    public final List<T> jKZ;

    public AppBrandLauncherUI$c(List<T> list, List<T> list2) {
        this.jKY = list;
        this.jKZ = list2;
    }

    public final int akF() {
        return this.jKY == null ? 0 : this.jKY.size();
    }

    public final int akG() {
        return this.jKZ == null ? 0 : this.jKZ.size();
    }
}
