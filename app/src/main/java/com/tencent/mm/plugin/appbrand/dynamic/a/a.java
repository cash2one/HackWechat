package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.mm.modelappbrand.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class a implements c {
    private Map<Object, Set<View>> iSw = new HashMap();

    public final boolean g(Object obj, View view) {
        if (obj == null || view == null) {
            return false;
        }
        Set set = (Set) this.iSw.get(obj);
        if (set == null) {
            set = new HashSet();
            this.iSw.put(obj, set);
        }
        return set.add(view);
    }

    public final boolean h(Object obj, View view) {
        if (obj == null || view == null) {
            return false;
        }
        Set set = (Set) this.iSw.get(obj);
        return set != null ? set.remove(view) : false;
    }

    public final Set<View> aS(Object obj) {
        if (obj == null) {
            return null;
        }
        return (Set) this.iSw.get(obj);
    }

    public final Set<View> aT(Object obj) {
        if (obj == null) {
            return null;
        }
        return (Set) this.iSw.remove(obj);
    }

    public final Map<Object, Set<View>> IV() {
        return this.iSw;
    }
}
