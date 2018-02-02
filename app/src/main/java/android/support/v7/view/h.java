package android.support.v7.view;

import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    am Kh;
    boolean Ki;
    private final an Kj = new an(this) {
        private boolean Kk = false;
        private int Kl = 0;
        final /* synthetic */ h Km;

        {
            this.Km = r2;
        }

        public final void p(View view) {
            if (!this.Kk) {
                this.Kk = true;
                if (this.Km.Kh != null) {
                    this.Km.Kh.p(null);
                }
            }
        }

        public final void q(View view) {
            int i = this.Kl + 1;
            this.Kl = i;
            if (i == this.Km.mg.size()) {
                if (this.Km.Kh != null) {
                    this.Km.Kh.q(null);
                }
                this.Kl = 0;
                this.Kk = false;
                this.Km.Ki = false;
            }
        }
    };
    private long mDuration = -1;
    private Interpolator mInterpolator;
    final ArrayList<ai> mg = new ArrayList();

    public final h g(ai aiVar) {
        if (!this.Ki) {
            this.mg.add(aiVar);
        }
        return this;
    }

    public final h a(ai aiVar, ai aiVar2) {
        this.mg.add(aiVar);
        View view = (View) aiVar.zH.get();
        aiVar2.e(view != null ? ai.zL.aq(view) : 0);
        this.mg.add(aiVar2);
        return this;
    }

    public final void start() {
        if (!this.Ki) {
            Iterator it = this.mg.iterator();
            while (it.hasNext()) {
                ai aiVar = (ai) it.next();
                if (this.mDuration >= 0) {
                    aiVar.d(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    aiVar.b(this.mInterpolator);
                }
                if (this.Kh != null) {
                    aiVar.a(this.Kj);
                }
                aiVar.start();
            }
            this.Ki = true;
        }
    }

    public final void cancel() {
        if (this.Ki) {
            Iterator it = this.mg.iterator();
            while (it.hasNext()) {
                ((ai) it.next()).cancel();
            }
            this.Ki = false;
        }
    }

    public final h dl() {
        if (!this.Ki) {
            this.mDuration = 250;
        }
        return this;
    }

    public final h c(Interpolator interpolator) {
        if (!this.Ki) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public final h b(am amVar) {
        if (!this.Ki) {
            this.Kh = amVar;
        }
        return this;
    }
}
