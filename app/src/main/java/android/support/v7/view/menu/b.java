package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.z;
import android.support.v7.view.menu.l.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements l {
    protected LayoutInflater DF;
    public Context KH;
    protected LayoutInflater KI;
    private int KJ;
    private int KK;
    public m KL;
    public a ef;
    public f eg;
    public Context mContext;
    public int mId;

    public abstract void a(h hVar, m.a aVar);

    public b(Context context, int i, int i2) {
        this.KH = context;
        this.KI = LayoutInflater.from(context);
        this.KJ = i;
        this.KK = i2;
    }

    public void a(Context context, f fVar) {
        this.mContext = context;
        this.DF = LayoutInflater.from(this.mContext);
        this.eg = fVar;
    }

    public m c(ViewGroup viewGroup) {
        if (this.KL == null) {
            this.KL = (m) this.KI.inflate(this.KJ, viewGroup, false);
            this.KL.a(this.eg);
            f(true);
        }
        return this.KL;
    }

    public void f(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.KL;
        if (viewGroup != null) {
            int i;
            if (this.eg != null) {
                this.eg.dB();
                ArrayList dA = this.eg.dA();
                int size = dA.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    h hVar = (h) dA.get(i2);
                    if (e(hVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        h B = childAt instanceof m.a ? ((m.a) childAt).B() : null;
                        View a = a(hVar, childAt, viewGroup);
                        if (hVar != B) {
                            a.setPressed(false);
                            z.aa(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.KL).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!c(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean c(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        m.a aVar;
        if (view instanceof m.a) {
            aVar = (m.a) view;
        } else {
            aVar = (m.a) this.KI.inflate(this.KK, viewGroup, false);
        }
        a(hVar, aVar);
        return (View) aVar;
    }

    public boolean e(h hVar) {
        return true;
    }

    public void a(f fVar, boolean z) {
        if (this.ef != null) {
            this.ef.a(fVar, z);
        }
    }

    public boolean a(p pVar) {
        if (this.ef != null) {
            return this.ef.d(pVar);
        }
        return false;
    }

    public boolean D() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }
}
