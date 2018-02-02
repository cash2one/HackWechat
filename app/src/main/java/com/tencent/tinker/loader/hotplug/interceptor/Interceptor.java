package com.tencent.tinker.loader.hotplug.interceptor;

public abstract class Interceptor<T_TARGET> {
    private T_TARGET Akl = null;
    private volatile boolean mInstalled = false;

    protected interface ITinkerHotplugProxy {
    }

    protected abstract T_TARGET cHd();

    protected abstract void cz(T_TARGET t_target);

    protected T_TARGET cA(T_TARGET t_target) {
        return t_target;
    }

    public final synchronized void cHe() {
        try {
            Object cHd = cHd();
            this.Akl = cHd;
            Object cA = cA(cHd);
            if (cA != cHd) {
                cz(cA);
            } else {
                new StringBuilder("target: ").append(cHd).append(" was already hooked.");
            }
            this.mInstalled = true;
        } catch (Throwable th) {
            this.Akl = null;
            InterceptFailedException interceptFailedException = new InterceptFailedException(th);
        }
    }

    public final synchronized void cHc() {
        if (this.mInstalled) {
            try {
                cz(this.Akl);
                this.Akl = null;
                this.mInstalled = false;
            } catch (Throwable th) {
                InterceptFailedException interceptFailedException = new InterceptFailedException(th);
            }
        }
    }
}
