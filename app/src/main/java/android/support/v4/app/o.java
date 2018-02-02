package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;

public abstract class o extends u {
    private final m ra;
    private q rb = null;
    private Fragment rc = null;

    public abstract Fragment R(int i);

    public o(m mVar) {
        this.ra = mVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.rb == null) {
            this.rb = this.ra.aS();
        }
        long j = (long) i;
        Fragment p = this.ra.p(b(viewGroup.getId(), j));
        if (p != null) {
            this.rb.d(p);
        } else {
            p = R(i);
            this.rb.a(viewGroup.getId(), p, b(viewGroup.getId(), j));
        }
        if (p != this.rc) {
            p.setMenuVisibility(false);
            p.setUserVisibleHint(false);
        }
        return p;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.rb == null) {
            this.rb = this.ra.aS();
        }
        this.rb.c((Fragment) obj);
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
        return null;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    private static String b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
