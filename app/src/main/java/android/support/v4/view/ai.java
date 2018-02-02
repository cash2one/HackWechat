package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.support.v4.view.aj.AnonymousClass1;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ai {
    public static final g zL;
    public WeakReference<View> zH;
    private Runnable zI = null;
    private Runnable zJ = null;
    private int zK = -1;

    interface g {
        void a(ai aiVar, View view);

        void a(ai aiVar, View view, float f);

        void a(ai aiVar, View view, am amVar);

        void a(View view, long j);

        void a(View view, ao aoVar);

        void a(View view, Interpolator interpolator);

        long aq(View view);

        void b(ai aiVar, View view);

        void b(ai aiVar, View view, float f);

        void b(View view, long j);

        void c(ai aiVar, View view, float f);

        void d(ai aiVar, View view, float f);

        void e(ai aiVar, View view, float f);
    }

    static class a implements g {
        WeakHashMap<View, Runnable> zM = null;

        class a implements Runnable {
            WeakReference<View> fq;
            ai zN;
            final /* synthetic */ a zO;

            private a(a aVar, ai aiVar, View view) {
                this.zO = aVar;
                this.fq = new WeakReference(view);
                this.zN = aiVar;
            }

            public final void run() {
                View view = (View) this.fq.get();
                if (view != null) {
                    this.zO.c(this.zN, view);
                }
            }
        }

        a() {
        }

        public void a(View view, long j) {
        }

        public void a(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void b(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void c(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public long aq(View view) {
            return 0;
        }

        public void a(View view, Interpolator interpolator) {
        }

        public void b(View view, long j) {
        }

        public void d(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void e(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void a(ai aiVar, View view) {
            d(aiVar, view);
        }

        public void b(ai aiVar, View view) {
            if (this.zM != null) {
                Runnable runnable = (Runnable) this.zM.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
            c(aiVar, view);
        }

        public void a(ai aiVar, View view, am amVar) {
            view.setTag(2113929216, amVar);
        }

        public void a(View view, ao aoVar) {
        }

        final void c(ai aiVar, View view) {
            am amVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof am) {
                amVar = (am) tag;
            } else {
                amVar = null;
            }
            Runnable c = aiVar.zI;
            Runnable d = aiVar.zJ;
            aiVar.zI = null;
            aiVar.zJ = null;
            if (c != null) {
                c.run();
            }
            if (amVar != null) {
                amVar.p(view);
                amVar.q(view);
            }
            if (d != null) {
                d.run();
            }
            if (this.zM != null) {
                this.zM.remove(view);
            }
        }

        private void d(ai aiVar, View view) {
            Runnable runnable = null;
            if (this.zM != null) {
                runnable = (Runnable) this.zM.get(view);
            }
            if (runnable == null) {
                runnable = new a(aiVar, view);
                if (this.zM == null) {
                    this.zM = new WeakHashMap();
                }
                this.zM.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class b extends a {
        WeakHashMap<View, Integer> zP = null;

        static class a implements am {
            ai zN;
            boolean zQ;

            a(ai aiVar) {
                this.zN = aiVar;
            }

            public final void p(View view) {
                am amVar;
                this.zQ = false;
                if (this.zN.zK >= 0) {
                    z.a(view, 2, null);
                }
                if (this.zN.zI != null) {
                    Runnable c = this.zN.zI;
                    this.zN.zI = null;
                    c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof am) {
                    amVar = (am) tag;
                } else {
                    amVar = null;
                }
                if (amVar != null) {
                    amVar.p(view);
                }
            }

            public final void q(View view) {
                if (this.zN.zK >= 0) {
                    z.a(view, this.zN.zK, null);
                    this.zN.zK = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.zQ) {
                    am amVar;
                    if (this.zN.zJ != null) {
                        Runnable d = this.zN.zJ;
                        this.zN.zJ = null;
                        d.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof am) {
                        amVar = (am) tag;
                    } else {
                        amVar = null;
                    }
                    if (amVar != null) {
                        amVar.q(view);
                    }
                    this.zQ = true;
                }
            }

            public final void ar(View view) {
                am amVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof am) {
                    amVar = (am) tag;
                } else {
                    amVar = null;
                }
                if (amVar != null) {
                    amVar.ar(view);
                }
            }
        }

        b() {
        }

        public final void a(View view, long j) {
            view.animate().setDuration(j);
        }

        public final void a(ai aiVar, View view, float f) {
            view.animate().alpha(f);
        }

        public final void b(ai aiVar, View view, float f) {
            view.animate().translationX(f);
        }

        public final void c(ai aiVar, View view, float f) {
            view.animate().translationY(f);
        }

        public final long aq(View view) {
            return view.animate().getDuration();
        }

        public final void a(View view, Interpolator interpolator) {
            view.animate().setInterpolator(interpolator);
        }

        public final void b(View view, long j) {
            view.animate().setStartDelay(j);
        }

        public final void d(ai aiVar, View view, float f) {
            view.animate().scaleX(f);
        }

        public final void e(ai aiVar, View view, float f) {
            view.animate().scaleY(f);
        }

        public final void a(ai aiVar, View view) {
            view.animate().cancel();
        }

        public final void b(ai aiVar, View view) {
            view.animate().start();
        }

        public void a(ai aiVar, View view, am amVar) {
            view.setTag(2113929216, amVar);
            view.animate().setListener(new AnonymousClass1(new a(aiVar), view));
        }
    }

    static class d extends b {
        d() {
        }

        public final void a(ai aiVar, View view, am amVar) {
            if (amVar != null) {
                view.animate().setListener(new ak.AnonymousClass1(amVar, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class e extends c {
        e() {
        }

        public final void a(View view, ao aoVar) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (aoVar != null) {
                animatorUpdateListener = new al.AnonymousClass1(aoVar, view);
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
    }

    static class f extends e {
        f() {
        }
    }

    ai(View view) {
        this.zH = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            zL = new f();
        } else if (i >= 19) {
            zL = new e();
        } else if (i >= 18) {
            zL = new c();
        } else if (i >= 16) {
            zL = new d();
        } else if (i >= 14) {
            zL = new b();
        } else {
            zL = new a();
        }
    }

    public final ai d(long j) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.a(view, j);
        }
        return this;
    }

    public final ai q(float f) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.a(this, view, f);
        }
        return this;
    }

    public final ai r(float f) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.b(this, view, f);
        }
        return this;
    }

    public final ai s(float f) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.c(this, view, f);
        }
        return this;
    }

    public final ai b(Interpolator interpolator) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.a(view, interpolator);
        }
        return this;
    }

    public final ai e(long j) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.b(view, j);
        }
        return this;
    }

    public final ai t(float f) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.d(this, view, f);
        }
        return this;
    }

    public final ai u(float f) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.e(this, view, f);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.a(this, view);
        }
    }

    public final void start() {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.b(this, view);
        }
    }

    public final ai a(am amVar) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.a(this, view, amVar);
        }
        return this;
    }

    public final ai a(ao aoVar) {
        View view = (View) this.zH.get();
        if (view != null) {
            zL.a(view, aoVar);
        }
        return this;
    }
}
