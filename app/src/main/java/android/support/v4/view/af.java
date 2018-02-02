package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class af {
    static final c yy;

    interface c {
        void b(ViewGroup viewGroup, boolean z);
    }

    static class f implements c {
        f() {
        }

        public void b(ViewGroup viewGroup, boolean z) {
        }
    }

    static class a extends f {
        a() {
        }

        public final void b(ViewGroup viewGroup, boolean z) {
            viewGroup.setMotionEventSplittingEnabled(false);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class d extends b {
        d() {
        }
    }

    static class e extends d {
        e() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            yy = new e();
        } else if (i >= 18) {
            yy = new d();
        } else if (i >= 14) {
            yy = new b();
        } else if (i >= 11) {
            yy = new a();
        } else {
            yy = new f();
        }
    }

    public static void b(ViewGroup viewGroup) {
        yy.b(viewGroup, false);
    }
}
