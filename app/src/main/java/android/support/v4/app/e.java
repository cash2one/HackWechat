package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.r.AnonymousClass4;
import android.support.v4.e.d;
import android.support.v4.e.g;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.wcdb.FileUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class e extends q implements Runnable {
    static final boolean pe = (VERSION.SDK_INT >= 21);
    int mIndex = -1;
    String mName;
    final n pf;
    a pg;
    a ph;
    int pi;
    int pj;
    int pk;
    int pl;
    int pm;
    int pn;
    int po;
    boolean pp;
    boolean pq = true;
    boolean pr;
    int ps;
    CharSequence pt;
    int pu;
    CharSequence pv;
    ArrayList<String> pw;
    ArrayList<String> px;

    static final class a {
        a pI;
        a pJ;
        int pK;
        Fragment pL;
        int pM;
        int pN;
        int pO;
        int pP;
        ArrayList<Fragment> pQ;

        a() {
        }
    }

    public class b {
        public android.support.v4.e.a<String, String> pR = new android.support.v4.e.a();
        public ArrayList<View> pS = new ArrayList();
        public android.support.v4.app.r.a pT = new android.support.v4.app.r.a();
        public View pU;
        final /* synthetic */ e pz;

        public b(e eVar) {
            this.pz = eVar;
        }
    }

    static /* synthetic */ android.support.v4.e.a a(e eVar, b bVar, boolean z, Fragment fragment) {
        android.support.v4.e.a a;
        Map aVar = new android.support.v4.e.a();
        View view = fragment.getView();
        if (!(view == null || eVar.pw == null)) {
            r.a(aVar, view);
            if (z) {
                a = a(eVar.pw, eVar.px, (android.support.v4.e.a) aVar);
            } else {
                g.a(aVar, eVar.px);
            }
        }
        al alVar;
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                alVar = fragment.mExitTransitionCallback;
            }
            eVar.a(bVar, a, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                alVar = fragment.mEnterTransitionCallback;
            }
            b(bVar, a, true);
        }
        return a;
    }

    static /* synthetic */ void a(Fragment fragment, Fragment fragment2, boolean z, android.support.v4.e.a aVar) {
        if ((z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback) != null) {
            ArrayList arrayList = new ArrayList(aVar.keySet());
            arrayList = new ArrayList(aVar.values());
        }
    }

    static /* synthetic */ void a(e eVar, android.support.v4.e.a aVar, b bVar) {
        if (eVar.px != null && !aVar.isEmpty()) {
            View view = (View) aVar.get(eVar.px.get(0));
            if (view != null) {
                bVar.pT.rC = view;
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.pr);
            if (this.pn != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.pn));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.po));
            }
            if (!(this.pj == 0 && this.pk == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.pj));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.pk));
            }
            if (!(this.pl == 0 && this.pm == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.pl));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.pm));
            }
            if (!(this.ps == 0 && this.pt == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.ps));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.pt);
            }
            if (!(this.pu == 0 && this.pv == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.pu));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.pv);
            }
        }
        if (this.pg != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            a aVar = this.pg;
            while (aVar != null) {
                String str3;
                switch (aVar.pK) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aVar.pK;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aVar.pL);
                if (z) {
                    if (!(aVar.pM == 0 && aVar.pN == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.pM));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.pN));
                    }
                    if (!(aVar.pO == 0 && aVar.pP == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.pO));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.pP));
                    }
                }
                if (aVar.pQ != null && aVar.pQ.size() > 0) {
                    for (int i2 = 0; i2 < aVar.pQ.size(); i2++) {
                        printWriter.print(str2);
                        if (aVar.pQ.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.pQ.get(i2));
                    }
                }
                aVar = aVar.pI;
                i++;
            }
        }
    }

    public e(n nVar) {
        this.pf = nVar;
    }

    final void a(a aVar) {
        if (this.pg == null) {
            this.ph = aVar;
            this.pg = aVar;
        } else {
            aVar.pJ = this.ph;
            this.ph.pI = aVar;
            this.ph = aVar;
        }
        aVar.pM = this.pj;
        aVar.pN = this.pk;
        aVar.pO = this.pl;
        aVar.pP = this.pm;
        this.pi++;
    }

    public final q a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final q a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public final q a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.pf;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        a aVar = new a();
        aVar.pK = i2;
        aVar.pL = fragment;
        a(aVar);
    }

    public final q b(int i, Fragment fragment) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, null, 2);
        return this;
    }

    public final q a(Fragment fragment) {
        a aVar = new a();
        aVar.pK = 3;
        aVar.pL = fragment;
        a(aVar);
        return this;
    }

    public final q b(Fragment fragment) {
        a aVar = new a();
        aVar.pK = 5;
        aVar.pL = fragment;
        a(aVar);
        return this;
    }

    public final q c(Fragment fragment) {
        a aVar = new a();
        aVar.pK = 6;
        aVar.pL = fragment;
        a(aVar);
        return this;
    }

    public final q d(Fragment fragment) {
        a aVar = new a();
        aVar.pK = 7;
        aVar.pL = fragment;
        a(aVar);
        return this;
    }

    public final q j(int i, int i2) {
        this.pj = i;
        this.pk = i2;
        this.pl = 0;
        this.pm = 0;
        return this;
    }

    public final q m(String str) {
        if (this.pq) {
            this.pp = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    final void M(int i) {
        if (this.pp) {
            if (n.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            for (a aVar = this.pg; aVar != null; aVar = aVar.pI) {
                Fragment fragment;
                if (aVar.pL != null) {
                    fragment = aVar.pL;
                    fragment.mBackStackNesting += i;
                    if (n.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(aVar.pL).append(" to ").append(aVar.pL.mBackStackNesting);
                    }
                }
                if (aVar.pQ != null) {
                    for (int size = aVar.pQ.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) aVar.pQ.get(size);
                        fragment.mBackStackNesting += i;
                        if (n.DEBUG) {
                            new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public final int commit() {
        return m(false);
    }

    public final int commitAllowingStateLoss() {
        return m(true);
    }

    private int m(boolean z) {
        if (this.pr) {
            throw new IllegalStateException("commit already called");
        }
        if (n.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            a("  ", new PrintWriter(new d("FragmentManager")));
        }
        this.pr = true;
        if (this.pp) {
            this.mIndex = this.pf.a(this);
        } else {
            this.mIndex = -1;
        }
        this.pf.a((Runnable) this, z);
        return this.mIndex;
    }

    public final void run() {
        if (n.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        if (!this.pp || this.mIndex >= 0) {
            b a;
            M(1);
            if (!pe || this.pf.qA <= 0) {
                Object obj = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                a(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            }
            int i = a != null ? 0 : this.po;
            int i2 = a != null ? 0 : this.pn;
            a aVar = this.pg;
            while (aVar != null) {
                int i3 = a != null ? 0 : aVar.pM;
                int i4 = a != null ? 0 : aVar.pN;
                Fragment fragment;
                switch (aVar.pK) {
                    case 1:
                        fragment = aVar.pL;
                        fragment.mNextAnim = i3;
                        this.pf.a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.pL;
                        int i5 = fragment2.mContainerId;
                        if (this.pf.qt != null) {
                            int size = this.pf.qt.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.pf.qt.get(size);
                                if (n.DEBUG) {
                                    new StringBuilder("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment);
                                }
                                if (fragment.mContainerId == i5) {
                                    if (fragment == fragment2) {
                                        aVar.pL = null;
                                        fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (aVar.pQ == null) {
                                            aVar.pQ = new ArrayList();
                                        }
                                        aVar.pQ.add(fragment);
                                        fragment.mNextAnim = i4;
                                        if (this.pp) {
                                            fragment.mBackStackNesting++;
                                            if (n.DEBUG) {
                                                new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.mBackStackNesting);
                                            }
                                        }
                                        this.pf.a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.mNextAnim = i3;
                        this.pf.a(fragment2, false);
                        break;
                    case 3:
                        fragment = aVar.pL;
                        fragment.mNextAnim = i4;
                        this.pf.a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = aVar.pL;
                        fragment.mNextAnim = i4;
                        this.pf.b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = aVar.pL;
                        fragment.mNextAnim = i3;
                        this.pf.c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = aVar.pL;
                        fragment.mNextAnim = i4;
                        this.pf.d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = aVar.pL;
                        fragment.mNextAnim = i3;
                        this.pf.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.pK);
                }
                aVar = aVar.pI;
            }
            this.pf.a(this.pf.qA, i2, i, true);
            if (this.pp) {
                n nVar = this.pf;
                if (nVar.qv == null) {
                    nVar.qv = new ArrayList();
                }
                nVar.qv.add(this);
                nVar.aW();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden()) {
                if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState <= 0 && this.pf.qA > 0) {
                this.pf.h(fragment);
                this.pf.a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.pf.qB.onHasView()) {
            for (a aVar = this.pg; aVar != null; aVar = aVar.pI) {
                switch (aVar.pK) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 2:
                        Fragment fragment = aVar.pL;
                        if (this.pf.qt != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.pf.qt.size(); i++) {
                                Fragment fragment3 = (Fragment) this.pf.qt.get(i);
                                if (fragment2 == null || fragment3.mContainerId == fragment2.mContainerId) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.mContainerId);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.pf.qB.onHasView()) {
            for (a aVar = this.ph; aVar != null; aVar = aVar.pJ) {
                switch (aVar.pK) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 2:
                        if (aVar.pQ != null) {
                            for (int size = aVar.pQ.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) aVar.pQ.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.pL);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (n.DEBUG) {
            new StringBuilder("popFromBackStack: ").append(this);
            a("  ", new PrintWriter(new d("FragmentManager")));
        }
        if (pe && this.pf.qA > 0) {
            if (bVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    bVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.px, this.pw);
            }
        }
        M(-1);
        int i = bVar != null ? 0 : this.po;
        int i2 = bVar != null ? 0 : this.pn;
        a aVar = this.ph;
        while (aVar != null) {
            int i3 = bVar != null ? 0 : aVar.pO;
            int i4 = bVar != null ? 0 : aVar.pP;
            Fragment fragment;
            Fragment fragment2;
            switch (aVar.pK) {
                case 1:
                    fragment = aVar.pL;
                    fragment.mNextAnim = i4;
                    this.pf.a(fragment, n.Q(i2), i);
                    break;
                case 2:
                    fragment = aVar.pL;
                    if (fragment != null) {
                        fragment.mNextAnim = i4;
                        this.pf.a(fragment, n.Q(i2), i);
                    }
                    if (aVar.pQ == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aVar.pQ.size(); i5++) {
                        fragment2 = (Fragment) aVar.pQ.get(i5);
                        fragment2.mNextAnim = i3;
                        this.pf.a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = aVar.pL;
                    fragment2.mNextAnim = i3;
                    this.pf.a(fragment2, false);
                    break;
                case 4:
                    fragment2 = aVar.pL;
                    fragment2.mNextAnim = i3;
                    this.pf.c(fragment2, n.Q(i2), i);
                    break;
                case 5:
                    fragment = aVar.pL;
                    fragment.mNextAnim = i4;
                    this.pf.b(fragment, n.Q(i2), i);
                    break;
                case 6:
                    fragment2 = aVar.pL;
                    fragment2.mNextAnim = i3;
                    this.pf.e(fragment2, n.Q(i2), i);
                    break;
                case 7:
                    fragment2 = aVar.pL;
                    fragment2.mNextAnim = i3;
                    this.pf.d(fragment2, n.Q(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.pK);
            }
            aVar = aVar.pJ;
        }
        if (z) {
            this.pf.a(this.pf.qA, n.Q(i2), i, true);
            bVar = null;
        }
        if (this.mIndex >= 0) {
            n nVar = this.pf;
            i4 = this.mIndex;
            synchronized (nVar) {
                nVar.qx.set(i4, null);
                if (nVar.qy == null) {
                    nVar.qy = new ArrayList();
                }
                if (n.DEBUG) {
                    nVar.qy.add(Integer.valueOf(i4));
                } else {
                    nVar.qy.add(Integer.valueOf(i4));
                }
            }
            this.mIndex = -1;
        }
        return bVar;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        b bVar = new b(this);
        bVar.pU = new View(this.pf.mHost.mContext);
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (a(sparseArray.keyAt(i2), bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && a(i4, bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return bVar;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, android.support.v4.e.a<String, View> aVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = fragment.getView();
        if (obj == null) {
            return obj;
        }
        r.a((ArrayList) arrayList, view2);
        if (aVar != null) {
            arrayList.removeAll(aVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        r.b((Transition) obj, arrayList);
        return obj;
    }

    private android.support.v4.e.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        android.support.v4.e.a aVar = new android.support.v4.e.a();
        if (this.pw != null) {
            r.a((Map) aVar, fragment.getView());
            if (z) {
                g.a((Map) aVar, this.px);
            } else {
                aVar = a(this.pw, this.px, aVar);
            }
        }
        al alVar;
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                alVar = fragment.mEnterTransitionCallback;
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                alVar = fragment.mExitTransitionCallback;
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        final View view = (ViewGroup) this.pf.qB.onFindViewById(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Transition transition;
        Object obj3;
        android.support.v4.e.a aVar;
        Object obj4;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        final Fragment fragment2 = (Fragment) sparseArray.get(i);
        if (fragment == null) {
            obj = null;
        } else {
            obj = r.f(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
        }
        if (fragment == null || fragment2 == null) {
            obj2 = null;
        } else {
            Object sharedElementReturnTransition = z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition();
            if (sharedElementReturnTransition == null) {
                obj2 = null;
            } else {
                transition = (Transition) sharedElementReturnTransition;
                if (transition == null) {
                    obj2 = null;
                } else {
                    obj2 = new TransitionSet();
                    obj2.addTransition(transition);
                }
            }
        }
        if (fragment2 == null) {
            obj3 = null;
        } else {
            obj3 = r.f(z ? fragment2.getReturnTransition() : fragment2.getExitTransition());
        }
        final ArrayList arrayList = new ArrayList();
        if (obj2 != null) {
            android.support.v4.e.a a = a(bVar, fragment2, z);
            if (a.isEmpty()) {
                aVar = null;
                obj4 = null;
            } else {
                if ((z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback) != null) {
                    ArrayList arrayList2 = new ArrayList(a.keySet());
                    arrayList2 = new ArrayList(a.values());
                }
                final b bVar2 = bVar;
                final boolean z2 = z;
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ e pz;

                    public final boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (obj2 != null) {
                            r.a(obj2, arrayList);
                            arrayList.clear();
                            android.support.v4.e.a a = e.a(this.pz, bVar2, z2, fragment);
                            r.a(obj2, bVar2.pU, a, arrayList);
                            e.a(this.pz, a, bVar2);
                            e.a(fragment, fragment2, z2, a);
                        }
                        return true;
                    }
                });
                aVar = a;
                obj4 = obj2;
            }
        } else {
            aVar = null;
            obj4 = obj2;
        }
        if (obj == null && obj4 == null && obj3 == null) {
            return false;
        }
        Object obj5;
        ArrayList arrayList3 = new ArrayList();
        obj2 = a(obj3, fragment2, arrayList3, aVar, bVar.pU);
        if (!(this.px == null || aVar == null)) {
            View view2 = (View) aVar.get(this.px.get(0));
            if (view2 != null) {
                if (obj2 != null) {
                    r.a(obj2, view2);
                }
                if (obj4 != null) {
                    r.a(obj4, view2);
                }
            }
        }
        android.support.v4.app.r.b anonymousClass1 = new android.support.v4.app.r.b(this) {
            final /* synthetic */ e pz;

            public final View getView() {
                return fragment.getView();
            }
        };
        ArrayList arrayList4 = new ArrayList();
        Map aVar2 = new android.support.v4.e.a();
        if (fragment != null) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        } else {
            z2 = true;
        }
        transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj4;
        if (transition == null || transition2 == null) {
            z2 = true;
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            obj5 = transitionSet;
        } else {
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                obj5 = new TransitionSet();
                if (transition != null) {
                    obj5.addTransition(transition);
                }
                obj5.addTransition(transition3);
            } else {
                transition2 = transition;
            }
        }
        if (obj5 != null) {
            View view3 = bVar.pU;
            android.support.v4.app.r.a aVar3 = bVar.pT;
            Map map = bVar.pR;
            if (!(obj == null && obj4 == null)) {
                Transition transition4 = (Transition) obj;
                if (transition4 != null) {
                    transition4.addTarget(view3);
                }
                if (obj4 != null) {
                    r.a(obj4, view3, aVar, arrayList);
                }
                view.getViewTreeObserver().addOnPreDrawListener(new android.support.v4.app.r.AnonymousClass2(view, transition4, view3, anonymousClass1, map, aVar2, arrayList4));
                if (transition4 != null) {
                    transition4.setEpicenterCallback(new android.support.v4.app.r.AnonymousClass3(aVar3));
                }
            }
            final View view4 = view;
            final b bVar3 = bVar;
            final int i2 = i;
            final Object obj6 = obj5;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ e pz;

                public final boolean onPreDraw() {
                    view4.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.pz.a(bVar3, i2, obj6);
                    return true;
                }
            });
            r.a(obj5, bVar.pU, true);
            a(bVar, i, obj5);
            TransitionManager.beginDelayedTransition(view, (Transition) obj5);
            View view5 = bVar.pU;
            ArrayList arrayList5 = bVar.pS;
            Transition transition5 = (Transition) obj;
            Transition transition6 = (Transition) obj2;
            Transition transition7 = (Transition) obj4;
            Transition transition8 = (Transition) obj5;
            if (transition8 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass4(view, transition5, arrayList4, transition6, arrayList3, transition7, arrayList, aVar2, arrayList5, transition8, view5));
            }
        }
        if (obj5 != null) {
            return true;
        }
        return false;
    }

    private static android.support.v4.e.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.e.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        android.support.v4.e.a<String, View> aVar2 = new android.support.v4.e.a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private void a(b bVar, int i, Object obj) {
        if (this.pf.qt != null) {
            for (int i2 = 0; i2 < this.pf.qt.size(); i2++) {
                Fragment fragment = (Fragment) this.pf.qt.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        r.a(obj, fragment.mView, false);
                        bVar.pS.remove(fragment.mView);
                    } else if (!bVar.pS.contains(fragment.mView)) {
                        r.a(obj, fragment.mView, true);
                        bVar.pS.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.e.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.valueAt(i))) {
                    aVar.setValueAt(i, str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(bVar.pR, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void a(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = this.px == null ? 0 : this.px.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.pw.get(i);
            View view = (View) aVar.get((String) this.px.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(bVar.pR, str, transitionName);
                } else {
                    a(bVar.pR, transitionName, str);
                }
            }
        }
    }

    private static void b(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.keyAt(i);
            String transitionName = ((View) aVar.valueAt(i)).getTransitionName();
            if (z) {
                a(bVar.pR, str, transitionName);
            } else {
                a(bVar.pR, transitionName, str);
            }
        }
    }
}
