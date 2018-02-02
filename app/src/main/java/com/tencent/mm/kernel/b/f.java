package com.tencent.mm.kernel.b;

import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import java.util.HashSet;
import junit.framework.Assert;

public abstract class f implements d {
    private static final String TAG = "MMKernel.Plugin";
    private boolean mConfigured = false;
    private boolean mDependencyMade = false;
    private boolean mInstalled = false;
    private boolean mIsPendingPlugin = false;
    private boolean mMakingDependencies = false;
    private HashSet<c> mPins = new HashSet();

    public void invokeInstalled() {
        this.mInstalled = true;
        installed();
        detectAlias();
    }

    private final void detectAlias() {
        for (Class cls : getClass().getInterfaces()) {
            if (a.class.isAssignableFrom(cls)) {
                alias(cls);
            }
        }
    }

    public void markAsPendingPlugin() {
        this.mIsPendingPlugin = true;
    }

    public boolean isPendingPlugin() {
        return this.mIsPendingPlugin;
    }

    public void installed() {
    }

    public void dependency() {
    }

    public void configure(g gVar) {
    }

    public void uninstalled() {
        this.mConfigured = false;
        this.mInstalled = false;
    }

    public void invokeDependency() {
        this.mMakingDependencies = true;
        dependency();
        checkIfNeedDefaultDependency();
        this.mDependencyMade = true;
        this.mMakingDependencies = false;
    }

    private void checkIfNeedDefaultDependency() {
        a aVar = (a) h.Do().Df().gPX.gRQ.get(getClass());
        int i = (aVar == null || !(aVar.Dz() || aVar.DB())) ? 0 : 1;
        if (i == 0) {
            Class cls = h.Do().Df().gQa;
            if (cls != null) {
                dependsOn(cls);
                j.i(TAG, "plugin[%s] not specific any depOn, we using default one [%s]", this, cls);
            }
        }
    }

    public void invokeConfigure(g gVar) {
        configure(gVar);
        this.mConfigured = true;
    }

    public void alias(Class<? extends a> cls) {
        Assert.assertNotNull(cls);
        Assert.assertTrue(cls.isInstance(this));
        h.Do().Df().c(getClass(), cls);
    }

    public synchronized void pin(c cVar) {
        if (!this.mPins.contains(cVar)) {
            this.mPins.add(cVar);
            h.Do().Df().a(cVar.getClass(), new d(cVar));
        }
    }

    public synchronized void unpin(c cVar) {
        if (this.mPins.contains(cVar)) {
            this.mPins.remove(cVar);
            h.Do().Df().j(cVar.getClass());
        }
    }

    public void dependsOnRoot() {
        if (this.mMakingDependencies) {
            h.Do().Df().d(getClass(), getClass());
        } else {
            j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        }
    }

    public void dependsOn(Class<? extends a> cls) {
        if (this.mMakingDependencies) {
            h.Do().Df().d(getClass(), cls);
        } else {
            j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        }
    }

    public String identify() {
        return getClass().getSimpleName();
    }

    public boolean isConfigured() {
        return this.mConfigured;
    }

    public boolean isDependencyMade() {
        return this.mDependencyMade;
    }

    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public String[] ofProcesses() {
        return new String[0];
    }

    public int hashCode() {
        return name().hashCode();
    }
}
