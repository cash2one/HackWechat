package android.support.design.widget;

import android.view.animation.Interpolator;

final class u {
    final e ls;

    class AnonymousClass2 implements a {
        final /* synthetic */ u lu;
        final /* synthetic */ a lv;

        AnonymousClass2(u uVar, a aVar) {
            this.lu = uVar;
            this.lv = aVar;
        }

        public final void onAnimationEnd() {
            this.lv.at();
        }
    }

    interface a {
        void at();
    }

    u(e eVar) {
        this.ls = eVar;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.ls.setInterpolator(interpolator);
    }

    public final void a(final c cVar) {
        this.ls.a(new b(this) {
            final /* synthetic */ u lu;

            public final void ax() {
                cVar.a(this.lu);
            }
        });
    }

    public final void g(int i, int i2) {
        this.ls.g(i, i2);
    }

    public final void e(float f, float f2) {
        this.ls.e(f, f2);
    }

    public final void setDuration(int i) {
        this.ls.setDuration(i);
    }
}
