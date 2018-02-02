package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class f {
    public static final c AC;
    public final Object AD;

    interface c {
        Object ck();

        void d(Object obj, int i);

        void e(Object obj, int i);

        void f(Object obj, int i);

        void f(Object obj, boolean z);

        void g(Object obj, int i);

        void h(Object obj, int i);

        void i(Object obj, int i);

        void j(Object obj, int i);
    }

    static class e implements c {
        e() {
        }

        public Object ck() {
            return null;
        }

        public void d(Object obj, int i) {
        }

        public void e(Object obj, int i) {
        }

        public void i(Object obj, int i) {
        }

        public void j(Object obj, int i) {
        }

        public void f(Object obj, int i) {
        }

        public void g(Object obj, int i) {
        }

        public void f(Object obj, boolean z) {
        }

        public void h(Object obj, int i) {
        }
    }

    static class a extends e {
        a() {
        }

        public final Object ck() {
            return AccessibilityRecord.obtain();
        }

        public final void d(Object obj, int i) {
            ((AccessibilityRecord) obj).setFromIndex(i);
        }

        public final void e(Object obj, int i) {
            ((AccessibilityRecord) obj).setItemCount(i);
        }

        public final void f(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollX(i);
        }

        public final void g(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollY(i);
        }

        public final void f(Object obj, boolean z) {
            ((AccessibilityRecord) obj).setScrollable(z);
        }

        public final void h(Object obj, int i) {
            ((AccessibilityRecord) obj).setToIndex(i);
        }
    }

    static class b extends a {
        b() {
        }

        public final void i(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollX(i);
        }

        public final void j(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollY(i);
        }
    }

    static class d extends b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            AC = new d();
        } else if (VERSION.SDK_INT >= 15) {
            AC = new b();
        } else if (VERSION.SDK_INT >= 14) {
            AC = new a();
        } else {
            AC = new e();
        }
    }

    public f(Object obj) {
        this.AD = obj;
    }

    public static f cj() {
        return new f(AC.ck());
    }

    public final void setScrollable(boolean z) {
        AC.f(this.AD, z);
    }

    public final void setItemCount(int i) {
        AC.e(this.AD, i);
    }

    public final void setFromIndex(int i) {
        AC.d(this.AD, i);
    }

    public final void setToIndex(int i) {
        AC.h(this.AD, i);
    }

    public final int hashCode() {
        return this.AD == null ? 0 : this.AD.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.AD == null) {
            if (fVar.AD != null) {
                return false;
            }
            return true;
        } else if (this.AD.equals(fVar.AD)) {
            return true;
        } else {
            return false;
        }
    }
}
