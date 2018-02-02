package android.support.v4.app;

public final class k {
    final l<?> mHost;

    k(l<?> lVar) {
        this.mHost = lVar;
    }

    final Fragment findFragmentByWho(String str) {
        return this.mHost.mFragmentManager.findFragmentByWho(str);
    }

    public final void noteStateNotSaved() {
        this.mHost.mFragmentManager.qF = false;
    }

    public final boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions();
    }
}
