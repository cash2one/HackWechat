package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c;
import android.support.v4.content.c.b;
import android.support.v4.e.k;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public final class u extends t {
    public static boolean DEBUG = false;
    l mHost;
    boolean mRetaining;
    final String mWho;
    boolean oO;
    final k<a> rD = new k();
    final k<a> rE = new k();
    boolean rF;

    final class a implements android.support.v4.content.c.a<Object>, b<Object> {
        Object mData;
        final int mId;
        boolean mRetaining;
        boolean oO;
        boolean qG;
        final Bundle rG;
        android.support.v4.app.t.a<Object> rH;
        c<Object> rI;
        boolean rJ;
        boolean rK;
        boolean rL;
        boolean rM;
        boolean rN;
        a rO;
        final /* synthetic */ u rP;

        public a(u uVar, int i, Bundle bundle, android.support.v4.app.t.a<Object> aVar) {
            this.rP = uVar;
            this.mId = i;
            this.rG = bundle;
            this.rH = aVar;
        }

        final void start() {
            if (this.mRetaining && this.rL) {
                this.oO = true;
            } else if (!this.oO) {
                this.oO = true;
                if (u.DEBUG) {
                    new StringBuilder("  Starting: ").append(this);
                }
                if (this.rI == null && this.rH != null) {
                    this.rI = this.rH.T(this.mId);
                }
                if (this.rI == null) {
                    return;
                }
                if (!this.rI.getClass().isMemberClass() || Modifier.isStatic(this.rI.getClass().getModifiers())) {
                    c cVar;
                    if (!this.rN) {
                        cVar = this.rI;
                        int i = this.mId;
                        if (cVar.tC != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.tC = this;
                        cVar.mId = i;
                        cVar = this.rI;
                        if (cVar.tD != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.tD = this;
                        this.rN = true;
                    }
                    cVar = this.rI;
                    cVar.oO = true;
                    cVar.tF = false;
                    cVar.tE = false;
                    cVar.onStartLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.rI);
            }
        }

        final void stop() {
            if (u.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.oO = false;
            if (!this.mRetaining && this.rI != null && this.rN) {
                this.rN = false;
                this.rI.a((b) this);
                this.rI.a((android.support.v4.content.c.a) this);
                c cVar = this.rI;
                cVar.oO = false;
                cVar.onStopLoading();
            }
        }

        final void destroy() {
            while (true) {
                android.support.v4.content.c.a aVar;
                if (u.DEBUG) {
                    new StringBuilder("  Destroying: ").append(aVar);
                }
                aVar.qG = true;
                boolean z = aVar.rK;
                aVar.rK = false;
                if (aVar.rH != null && aVar.rI != null && aVar.rJ && z) {
                    String str;
                    if (u.DEBUG) {
                        new StringBuilder("  Reseting: ").append(aVar);
                    }
                    if (aVar.rP.mHost != null) {
                        str = aVar.rP.mHost.mFragmentManager.qH;
                        aVar.rP.mHost.mFragmentManager.qH = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    if (aVar.rP.mHost != null) {
                        aVar.rP.mHost.mFragmentManager.qH = str;
                    }
                }
                aVar.rH = null;
                aVar.mData = null;
                aVar.rJ = false;
                if (aVar.rI != null) {
                    if (aVar.rN) {
                        aVar.rN = false;
                        aVar.rI.a((b) aVar);
                        aVar.rI.a(aVar);
                    }
                    c cVar = aVar.rI;
                    cVar.onReset();
                    cVar.tF = true;
                    cVar.oO = false;
                    cVar.tE = false;
                    cVar.tG = false;
                    cVar.tH = false;
                }
                if (aVar.rO != null) {
                    aVar = aVar.rO;
                } else {
                    return;
                }
            }
        }

        public final void b(c<Object> cVar, Object obj) {
            if (u.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (!this.qG && this.rP.rD.get(this.mId) == this) {
                a aVar = this.rO;
                if (aVar != null) {
                    if (u.DEBUG) {
                        new StringBuilder("  Switching to pending loader: ").append(aVar);
                    }
                    this.rO = null;
                    this.rP.rD.put(this.mId, null);
                    destroy();
                    this.rP.a(aVar);
                    return;
                }
                if (!(this.mData == obj && this.rJ)) {
                    this.mData = obj;
                    this.rJ = true;
                    if (this.oO) {
                        c(cVar, obj);
                    }
                }
                aVar = (a) this.rP.rE.get(this.mId);
                if (!(aVar == null || aVar == this)) {
                    aVar.rK = false;
                    aVar.destroy();
                    this.rP.rE.remove(this.mId);
                }
                if (this.rP.mHost != null && !this.rP.aZ()) {
                    this.rP.mHost.mFragmentManager.aU();
                }
            }
        }

        final void c(c<Object> cVar, Object obj) {
            String str;
            if (this.rH != null) {
                if (this.rP.mHost != null) {
                    String str2 = this.rP.mHost.mFragmentManager.qH;
                    this.rP.mHost.mFragmentManager.qH = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (u.DEBUG) {
                        StringBuilder append = new StringBuilder("  onLoadFinished in ").append(cVar).append(": ");
                        StringBuilder stringBuilder = new StringBuilder(64);
                        android.support.v4.e.c.a(obj, stringBuilder);
                        stringBuilder.append("}");
                        append.append(stringBuilder.toString());
                    }
                    this.rH.a(cVar, obj);
                    this.rK = true;
                } finally {
                    if (this.rP.mHost != null) {
                        this.rP.mHost.mFragmentManager.qH = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            android.support.v4.e.c.a(this.rI, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.mId);
                printWriter.print(" mArgs=");
                printWriter.println(this.rG);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.rH);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.rI);
                if (this.rI != null) {
                    this.rI.dump(str + "  ", fileDescriptor, printWriter, strArr);
                }
                if (this.rJ || this.rK) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.rJ);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.rK);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.mData);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.oO);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.rM);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.qG);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.mRetaining);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.rL);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.rN);
                if (this.rO != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.rO);
                    printWriter.println(":");
                    this = this.rO;
                    str = str + "  ";
                } else {
                    return;
                }
            }
        }
    }

    u(String str, l lVar, boolean z) {
        this.mWho = str;
        this.mHost = lVar;
        this.oO = z;
    }

    private a a(int i, Bundle bundle, android.support.v4.app.t.a<Object> aVar) {
        a aVar2 = new a(this, i, bundle, aVar);
        aVar2.rI = aVar.T(i);
        return aVar2;
    }

    private a b(int i, Bundle bundle, android.support.v4.app.t.a<Object> aVar) {
        try {
            this.rF = true;
            a a = a(i, null, aVar);
            a(a);
            return a;
        } finally {
            this.rF = false;
        }
    }

    final void a(a aVar) {
        this.rD.put(aVar.mId, aVar);
        if (this.oO) {
            aVar.start();
        }
    }

    public final <D> c<D> a(int i, android.support.v4.app.t.a<D> aVar) {
        if (this.rF) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.rD.get(i);
        if (DEBUG) {
            new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 == null) {
            aVar2 = b(i, null, aVar);
            if (DEBUG) {
                new StringBuilder("  Created new loader ").append(aVar2);
            }
        } else {
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(aVar2);
            }
            aVar2.rH = aVar;
        }
        if (aVar2.rJ && this.oO) {
            aVar2.c(aVar2.rI, aVar2.mData);
        }
        return aVar2.rI;
    }

    public final <D> c<D> b(int i, android.support.v4.app.t.a<D> aVar) {
        if (this.rF) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.rD.get(i);
        if (DEBUG) {
            new StringBuilder("restartLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 != null) {
            a aVar3 = (a) this.rE.get(i);
            if (aVar3 != null) {
                if (aVar2.rJ) {
                    if (DEBUG) {
                        new StringBuilder("  Removing last inactive loader: ").append(aVar2);
                    }
                    aVar3.rK = false;
                    aVar3.destroy();
                } else if (aVar2.oO) {
                    if (DEBUG) {
                        new StringBuilder("  Canceling: ").append(aVar2);
                    }
                    if (aVar2.oO && aVar2.rI != null && aVar2.rN) {
                        if (DEBUG) {
                            new StringBuilder("onLoadCanceled: ").append(aVar2);
                        }
                        if (!aVar2.qG && aVar2.rP.rD.get(aVar2.mId) == aVar2) {
                            aVar3 = aVar2.rO;
                            if (aVar3 != null) {
                                if (DEBUG) {
                                    new StringBuilder("  Switching to pending loader: ").append(aVar3);
                                }
                                aVar2.rO = null;
                                aVar2.rP.rD.put(aVar2.mId, null);
                                aVar2.destroy();
                                aVar2.rP.a(aVar3);
                            }
                        }
                    }
                    if (aVar2.rO != null) {
                        if (DEBUG) {
                            new StringBuilder("  Removing pending loader: ").append(aVar2.rO);
                        }
                        aVar2.rO.destroy();
                        aVar2.rO = null;
                    }
                    aVar2.rO = a(i, null, aVar);
                    return aVar2.rO.rI;
                } else {
                    this.rD.put(i, null);
                    aVar2.destroy();
                }
            } else if (DEBUG) {
                new StringBuilder("  Making last loader inactive: ").append(aVar2);
            }
            aVar2.rI.tE = true;
            this.rE.put(i, aVar2);
        }
        return b(i, null, aVar).rI;
    }

    public final void destroyLoader(int i) {
        if (this.rF) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            new StringBuilder("destroyLoader in ").append(this).append(" of ").append(i);
        }
        int indexOfKey = this.rD.indexOfKey(i);
        if (indexOfKey >= 0) {
            a aVar = (a) this.rD.valueAt(indexOfKey);
            this.rD.removeAt(indexOfKey);
            aVar.destroy();
        }
        indexOfKey = this.rE.indexOfKey(i);
        if (indexOfKey >= 0) {
            aVar = (a) this.rE.valueAt(indexOfKey);
            this.rE.removeAt(indexOfKey);
            aVar.destroy();
        }
        if (this.mHost != null && !aZ()) {
            this.mHost.mFragmentManager.aU();
        }
    }

    public final <D> c<D> S(int i) {
        if (this.rF) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar = (a) this.rD.get(i);
        if (aVar == null) {
            return null;
        }
        if (aVar.rO != null) {
            return aVar.rO.rI;
        }
        return aVar.rI;
    }

    final void ba() {
        if (DEBUG) {
            new StringBuilder("Starting in ").append(this);
        }
        if (this.oO) {
            new RuntimeException("here").fillInStackTrace();
            new StringBuilder("Called doStart when already started: ").append(this);
            return;
        }
        this.oO = true;
        for (int size = this.rD.size() - 1; size >= 0; size--) {
            ((a) this.rD.valueAt(size)).start();
        }
    }

    final void bb() {
        if (DEBUG) {
            new StringBuilder("Stopping in ").append(this);
        }
        if (this.oO) {
            for (int size = this.rD.size() - 1; size >= 0; size--) {
                ((a) this.rD.valueAt(size)).stop();
            }
            this.oO = false;
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doStop when not started: ").append(this);
    }

    final void bc() {
        if (DEBUG) {
            new StringBuilder("Retaining in ").append(this);
        }
        if (this.oO) {
            this.mRetaining = true;
            this.oO = false;
            for (int size = this.rD.size() - 1; size >= 0; size--) {
                a aVar = (a) this.rD.valueAt(size);
                if (DEBUG) {
                    new StringBuilder("  Retaining: ").append(aVar);
                }
                aVar.mRetaining = true;
                aVar.rL = aVar.oO;
                aVar.oO = false;
                aVar.rH = null;
            }
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doRetain when not started: ").append(this);
    }

    final void bd() {
        for (int size = this.rD.size() - 1; size >= 0; size--) {
            ((a) this.rD.valueAt(size)).rM = true;
        }
    }

    final void be() {
        for (int size = this.rD.size() - 1; size >= 0; size--) {
            a aVar = (a) this.rD.valueAt(size);
            if (aVar.oO && aVar.rM) {
                aVar.rM = false;
                if (aVar.rJ) {
                    aVar.c(aVar.rI, aVar.mData);
                }
            }
        }
    }

    final void bf() {
        int size;
        if (!this.mRetaining) {
            if (DEBUG) {
                new StringBuilder("Destroying Active in ").append(this);
            }
            for (size = this.rD.size() - 1; size >= 0; size--) {
                ((a) this.rD.valueAt(size)).destroy();
            }
            this.rD.clear();
        }
        if (DEBUG) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (size = this.rE.size() - 1; size >= 0; size--) {
            ((a) this.rE.valueAt(size)).destroy();
        }
        this.rE.clear();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        android.support.v4.e.c.a(this.mHost, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.rD.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.rD.size(); i2++) {
                a aVar = (a) this.rD.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.rD.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.rE.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.rE.size()) {
                aVar = (a) this.rE.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.rE.keyAt(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean aZ() {
        int size = this.rD.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            int i2;
            a aVar = (a) this.rD.valueAt(i);
            if (!aVar.oO || aVar.rK) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
