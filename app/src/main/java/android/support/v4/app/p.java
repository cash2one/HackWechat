package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class p extends u {
    private final m ra;
    private q rb = null;
    private Fragment rc = null;
    private ArrayList<SavedState> rf = new ArrayList();
    private ArrayList<Fragment> rg = new ArrayList();

    public abstract Fragment R(int i);

    public p(m mVar) {
        this.ra = mVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.rg.size() > i) {
            Fragment fragment = (Fragment) this.rg.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.rb == null) {
            this.rb = this.ra.aS();
        }
        Fragment R = R(i);
        if (this.rf.size() > i) {
            SavedState savedState = (SavedState) this.rf.get(i);
            if (savedState != null) {
                R.setInitialSavedState(savedState);
            }
        }
        while (this.rg.size() <= i) {
            this.rg.add(null);
        }
        R.setMenuVisibility(false);
        R.setUserVisibleHint(false);
        this.rg.set(i, R);
        this.rb.a(viewGroup.getId(), R);
        return R;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.rb == null) {
            this.rb = this.ra.aS();
        }
        while (this.rf.size() <= i) {
            this.rf.add(null);
        }
        this.rf.set(i, fragment.isAdded() ? this.ra.e(fragment) : null);
        this.rg.set(i, null);
        this.rb.a(fragment);
    }

    public final void e(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.rc) {
            if (this.rc != null) {
                this.rc.setMenuVisibility(false);
                this.rc.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.rc = fragment;
        }
    }

    public final void aX() {
        if (this.rb != null) {
            this.rb.commitAllowingStateLoss();
            this.rb = null;
            this.ra.executePendingTransactions();
        }
    }

    public final boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public final Parcelable aY() {
        Bundle bundle = null;
        if (this.rf.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.rf.size()];
            this.rf.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.rg.size(); i++) {
            Fragment fragment = (Fragment) this.rg.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.ra.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.rf.clear();
            this.rg.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.rf.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment c = this.ra.c(bundle, str);
                    if (c != null) {
                        while (this.rg.size() <= parseInt) {
                            this.rg.add(null);
                        }
                        c.setMenuVisibility(false);
                        this.rg.set(parseInt, c);
                    }
                }
            }
        }
    }
}
