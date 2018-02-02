package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.vending.b.c;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change> implements a {
    private static final int MESSAGE_DO_DESTROY = 2;
    private static final int MESSAGE_NOTIFY_DATA_LOADED = 1;
    private static final int MESSAGE_PREPARE_VENDING_DATA = 1;
    private static final int SYNC_MESSAGE_APPLY_CHANGE = 1;
    private static final int SYNC_MESSAGE_CLEAR_RESOLVED_ONLY = 3;
    private static final int SYNC_MESSAGE_PREPARE_DATA_DEGRADE = 2;
    private static final String TAG = "Vending";
    private g<_Index, i<_Struct, _Index>> mArray;
    private byte[] mArrayDataLock;
    private AtomicBoolean mCallDestroyed;
    private volatile c mDataChangedCallback;
    private volatile c mDataResolvedCallback;
    private c<_Index> mDeadlock;
    private boolean mFreezeDataChange;
    private boolean mHasPendingDataChange;
    private f mLoader;
    private byte[] mPendingDataChangeLock;
    private boolean mResolveFromVending;
    private Handler mSubscriberHandler;
    private Looper mSubscriberLooper;
    HashSet<h> mVendingDeferring;
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private c mVendingSync;

    private interface b {
        void czI();
    }

    static final class i<_Struct, _Index> {
        byte[] gOg = new byte[0];
        boolean gSr = false;
        boolean jl = false;
        _Index zBB;
        _Struct zBC;
        boolean zBD = false;
        boolean zBE = false;
        boolean zBb = false;

        i() {
        }
    }

    public abstract void applyChangeSynchronized(_Change _Change);

    public abstract void destroyAsynchronous();

    public abstract _Change prepareVendingDataAsynchronous();

    public abstract _Struct resolveAsynchronous(_Index _Index);

    f<_Index> getLoader() {
        return this.mLoader;
    }

    public void addVendingDataChangedCallback(d dVar) {
        this.mDataChangedCallback.aE(dVar);
    }

    public void addVendingDataResolvedCallback(e eVar) {
        this.mDataResolvedCallback.aE(eVar);
    }

    public Vending() {
        this(Looper.getMainLooper());
    }

    public Vending(Looper looper) {
        this.mCallDestroyed = new AtomicBoolean(false);
        this.mArrayDataLock = new byte[0];
        this.mPendingDataChangeLock = new byte[0];
        this.mHasPendingDataChange = false;
        this.mFreezeDataChange = false;
        this.mDeadlock = new c((byte) 0);
        this.mDataChangedCallback = new 1(this, d.zCO);
        this.mDataResolvedCallback = new c<e>(this, d.zCO) {
            final /* synthetic */ Vending zBp;

            public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                ((e) obj).cj(aVar.get(0));
            }
        };
        this.mArray = new g();
        this.mVendingDeferring = new HashSet();
        this.mResolveFromVending = false;
        this.mSubscriberLooper = looper;
        this.mVendingLooper = com.tencent.mm.vending.i.b.cAb().zCY.getLooper();
        this.mArray.zBA = new 3(this);
        this.mVendingSync = new c(this.mSubscriberLooper, this.mVendingLooper);
        this.mVendingSync.zBI = new c$a(this) {
            final /* synthetic */ Vending zBp;

            {
                this.zBp = r1;
            }

            public final void czJ() {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s beforeSynchronize", new Object[]{this.zBp});
                this.zBp.mLoader.czL();
            }

            public final void synchronizing(int i, Object obj) {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s synchronizing", new Object[]{this.zBp});
                this.zBp.mVendingDeferring.clear();
                this.zBp.mLoader.czL();
                this.zBp.mSubscriberHandler.removeCallbacksAndMessages(null);
                if (i == 2) {
                    obj = this.zBp.prepareVendingDataAsynchronous();
                }
                if (i == 2 || i == 1) {
                    this.zBp.applyChangeSynchronized(obj);
                }
                this.zBp.synchronizing(i, obj);
                this.zBp.mArray.clear();
            }

            public final void czK() {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s afterSynchronize", new Object[]{this.zBp});
                if (this.zBp.mDataChangedCallback != null) {
                    this.zBp.mDataChangedCallback.czN();
                }
            }
        };
        this.mSubscriberHandler = new 5(this, this.mSubscriberLooper);
        this.mVendingHandler = new 6(this, this.mVendingLooper);
        this.mLoader = new f(this.mVendingLooper, new 7(this));
    }

    private void notifyDataLoadedIfNeed(i<_Struct, _Index> iVar) {
        if (iVar.zBE) {
            iVar.zBE = false;
        } else {
            this.mSubscriberHandler.sendMessage(this.mSubscriberHandler.obtainMessage(1, iVar));
        }
    }

    protected void synchronizing(int i, Object obj) {
    }

    protected i<_Struct, _Index> getLock(_Index _Index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_Index);
            if (iVar == null) {
                iVar = new i();
                this.mArray.put(_Index, iVar);
            }
        }
        return iVar;
    }

    protected i<_Struct, _Index> peekLock(_Index _Index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_Index);
        }
        return iVar;
    }

    public h defer(_Index _Index) {
        looperCheckForVending();
        if (this.mResolveFromVending) {
            getLock(_Index).zBb = true;
            h hVar = new h(this, _Index);
            this.mVendingDeferring.add(hVar);
            return hVar;
        }
        com.tencent.mm.vending.f.a.w(TAG, "Please call defer in resolveAsynchronous()", new Object[0]);
        return null;
    }

    private void deferResolved(h hVar, _Index _Index, _Struct _Struct) {
        if (this.mVendingDeferring.contains(hVar)) {
            i lock = getLock(_Index);
            synchronized (lock.gOg) {
                lock.zBb = false;
                lockResolved(lock, _Index, _Struct);
            }
            notifyDataLoadedIfNeed(lock);
        }
    }

    public <T> T peek(_Index _Index) {
        if (this.mCallDestroyed.get() || invalidIndex(_Index)) {
            return null;
        }
        i peekLock = peekLock(_Index);
        if (peekLock == null || peekLock.jl) {
            return null;
        }
        return peekLock.zBC;
    }

    public <T> T get(_Index _Index) {
        return getSync(_Index);
    }

    private _Struct getSync(_Index _Index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.mCallDestroyed.get()) {
            return null;
        } else {
            i lock = getLock(_Index);
            if (invalidIndex(_Index)) {
                return lock.zBC;
            }
            if (myLooper == this.mSubscriberLooper) {
                return forSubscriberSync(lock, _Index).zBC;
            }
            loadFromVending(lock, _Index);
            return lock.zBC;
        }
    }

    private void lockResolved(i<_Struct, _Index> iVar, _Index _Index, _Struct _Struct) {
        iVar.zBC = _Struct;
        iVar.zBB = _Index;
        iVar.jl = false;
        iVar.zBD = false;
        iVar.gSr = true;
        if (this.mDeadlock.zBr == iVar) {
            iVar.zBE = true;
        }
        iVar.gOg.notify();
    }

    private boolean loadFromVending(i<_Struct, _Index> iVar, _Index _Index) {
        synchronized (iVar.gOg) {
            if (!iVar.gSr || iVar.jl || iVar.zBD) {
                this.mResolveFromVending = true;
                Object resolveAsynchronous = resolveAsynchronous(_Index);
                this.mResolveFromVending = false;
                if (iVar.zBb) {
                    return false;
                }
                lockResolved(iVar, _Index, resolveAsynchronous);
                return false;
            }
            return true;
        }
    }

    private i<_Struct, _Index> forSubscriberSync(i<_Struct, _Index> iVar, _Index _Index) {
        if (com.tencent.mm.vending.i.b.cAb().zCY.isAlive()) {
            synchronized (iVar.gOg) {
                boolean requestIndex = requestIndex(iVar, _Index);
                if (!iVar.gSr || iVar.jl) {
                    if (requestIndex) {
                        this.mDeadlock.zBq.object = _Index;
                        this.mDeadlock.zBr = iVar;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting %s", new Object[]{this, _Index});
                        long nanoTime = System.nanoTime();
                        try {
                            iVar.gOg.wait();
                        } catch (InterruptedException e) {
                        }
                        nanoTime = System.nanoTime() - nanoTime;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting duration %s", new Object[]{this, Long.valueOf(nanoTime)});
                        this.mDeadlock.reset();
                    }
                }
            }
        } else {
            com.tencent.mm.vending.f.a.e(TAG, "Vending thread is not running!", new Object[0]);
        }
        return iVar;
    }

    protected boolean invalidIndex(_Index _Index) {
        return false;
    }

    private _Struct getAsync(_Index _Index) {
        if (invalidIndex(_Index)) {
            return null;
        }
        i lock = getLock(_Index);
        if (!requestIndex(lock, _Index) || lock.jl) {
            return null;
        }
        return lock.zBC;
    }

    public void request(_Index _Index) {
        refillImpl(_Index, false);
    }

    public void requestConsistent(_Index _Index) {
        refillImpl(_Index, true);
    }

    private void refillImpl(_Index _Index, boolean z) {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            i lock = getLock(_Index);
            synchronized (lock.gOg) {
                if (lock.gSr) {
                    if (z) {
                        lock.jl = true;
                    } else {
                        lock.zBD = true;
                    }
                }
            }
            getAsync(_Index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            this.mVendingSync.k(3, null);
        }
    }

    public void notifyVendingDataChange() {
        notifyVendingDataChange(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        notifyVendingDataChange(true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyVendingDataChange(boolean z) {
        if (!this.mCallDestroyed.get()) {
            if (Looper.myLooper() != this.mSubscriberLooper && Looper.myLooper() != this.mVendingLooper) {
                throw new IllegalAccessError("Call from wrong thread");
            } else if (z) {
                this.mVendingSync.k(2, null);
            } else {
                synchronized (this.mPendingDataChangeLock) {
                    if (this.mFreezeDataChange) {
                        this.mHasPendingDataChange = true;
                    }
                }
            }
        }
    }

    public void freezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = false;
                if (this.mHasPendingDataChange) {
                    notifyVendingDataChange();
                    this.mHasPendingDataChange = false;
                }
            }
        }
    }

    protected void loaderClear() {
    }

    private void deadlock() {
        if (this.mDeadlock.zBq.object != null) {
            com.tencent.mm.vending.f.a.e(TAG, "Catch deadlock! Tell Carl! .. " + this.mDeadlock.zBq.object, new Object[0]);
            if (this.mDeadlock.zBr != null) {
                synchronized (this.mDeadlock.zBr.gOg) {
                    this.mDeadlock.zBr.gOg.notify();
                }
                this.mDeadlock.reset();
            }
        }
    }

    protected void requestIndexImpl(i<_Struct, _Index> iVar, _Index _Index) {
    }

    private boolean requestIndex(i<_Struct, _Index> iVar, _Index _Index) {
        if (invalidIndex(_Index)) {
            return false;
        }
        if (this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.e(TAG, "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        f fVar = this.mLoader;
        if (!fVar.iHf.get()) {
            synchronized (fVar.zBu) {
                fVar.zBs.put(_Index, b.zBx);
            }
            fVar.mVendingHandler.sendMessageAtFrontOfQueue(fVar.mVendingHandler.obtainMessage(0, _Index));
        }
        requestIndexImpl(iVar, _Index);
        return true;
    }

    private void callPrepareVendingData() {
        if (!this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.i(TAG, "Vending.callPrepareVendingData()", new Object[0]);
            this.mVendingSync.k(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.mVendingLooper;
    }

    public final void dead() {
        looperCheckBoth();
        com.tencent.mm.vending.f.a.i(TAG, "Vending.destroy()", new Object[0]);
        this.mCallDestroyed.set(true);
        this.mVendingHandler.removeCallbacksAndMessages(null);
        this.mSubscriberHandler.removeCallbacksAndMessages(null);
        this.mLoader.iHf.set(true);
        this.mLoader.czL();
        this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(2));
    }

    private void onDataResolved(_Index _Index, _Struct _Struct) {
        if (!this.mCallDestroyed.get() && this.mDataResolvedCallback != null) {
            this.mDataResolvedCallback.a(g.cq(_Index));
        }
    }

    public void looperCheckForVending() {
        if (Looper.myLooper() != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.mSubscriberLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }
}
