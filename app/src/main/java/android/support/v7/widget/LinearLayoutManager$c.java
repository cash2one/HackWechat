package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import java.util.List;

class LinearLayoutManager$c {
    boolean RH = true;
    int RI;
    int RJ;
    int RK;
    int RL;
    boolean RP;
    int Sv;
    int Sw = 0;
    boolean Sx = false;
    int Sy;
    List<t> Sz = null;
    int wn;

    LinearLayoutManager$c() {
    }

    final boolean k(q qVar) {
        return this.RJ >= 0 && this.RJ < qVar.getItemCount();
    }

    final View a(m mVar) {
        if (this.Sz != null) {
            int size = this.Sz.size();
            int i = 0;
            while (i < size) {
                View view = ((t) this.Sz.get(i)).VU;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.Vh.isRemoved() || this.RJ != layoutParams.Vh.gd()) {
                    i++;
                } else {
                    aT(view);
                    return view;
                }
            }
            return null;
        }
        View br = mVar.br(this.RJ);
        this.RJ += this.RK;
        return br;
    }

    public final void aT(View view) {
        View view2;
        int size = this.Sz.size();
        View view3 = null;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            int gd;
            View view4;
            view2 = ((t) this.Sz.get(i2)).VU;
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (!(view2 == view || layoutParams.Vh.isRemoved())) {
                gd = (layoutParams.Vh.gd() - this.RJ) * this.RK;
                if (gd >= 0 && gd < i) {
                    if (gd == 0) {
                        break;
                    }
                    view4 = view2;
                    i2++;
                    view3 = view4;
                    i = gd;
                }
            }
            gd = i;
            view4 = view3;
            i2++;
            view3 = view4;
            i = gd;
        }
        view2 = view3;
        if (view2 == null) {
            this.RJ = -1;
        } else {
            this.RJ = ((LayoutParams) view2.getLayoutParams()).Vh.gd();
        }
    }
}
