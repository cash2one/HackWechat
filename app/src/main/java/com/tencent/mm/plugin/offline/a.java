package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> oVi = new ArrayList();

    public final void bF(T t) {
        if (this.oVi != null) {
            this.oVi = new ArrayList();
        }
        if (t != null) {
            this.oVi.add(new WeakReference(t));
        }
    }

    public final void bG(T t) {
        if (this.oVi != null && t != null) {
            for (int i = 0; i < this.oVi.size(); i++) {
                WeakReference weakReference = (WeakReference) this.oVi.get(i);
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && obj.equals(t)) {
                        weakReference.clear();
                        this.oVi.remove(weakReference);
                    }
                }
            }
        }
    }
}
