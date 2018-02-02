package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.e.b;
import junit.framework.Assert;

public final class e<T> {
    private volatile T gMY;
    private Class<T> targetClass;

    public e(Class<T> cls) {
        Assert.assertNotNull(cls);
        this.targetClass = cls;
    }

    public final T get() {
        if (this.gMY == null) {
            synchronized (this) {
                if (this.gMY == null) {
                    this.gMY = b.e(this.targetClass);
                }
            }
        }
        return this.gMY;
    }
}
