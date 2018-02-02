package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

final class n extends a {
    private LayoutInflater DF;
    final SparseArray<o> jRs = new SparseArray();
    private final ArrayList<?> jRt;

    n(ArrayList<?> arrayList) {
        this.jRt = arrayList;
    }

    final boolean isEmpty() {
        return this.jRt == null || bh.cA(this.jRt);
    }

    final Object lF(int i) {
        return (i < 0 || i > getItemCount()) ? null : this.jRt.get(i);
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        o oVar = (o) this.jRs.get(i);
        if (oVar == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.DF == null) {
            this.DF = LayoutInflater.from(context);
        }
        return oVar.a(this.DF, viewGroup);
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        o oVar = (o) this.jRs.get(getItemViewType(i));
        if (oVar != null) {
            oVar.a(recyclerView$t, lF(i));
        }
    }

    public final void a(RecyclerView$t recyclerView$t, int i, List list) {
        o oVar = (o) this.jRs.get(getItemViewType(i));
        if (oVar == null) {
            super.a(recyclerView$t, i, list);
        } else if (list.size() <= 0 || !oVar.a(recyclerView$t, lF(i), list.get(0))) {
            oVar.a(recyclerView$t, lF(i));
        }
    }

    public final int getItemViewType(int i) {
        Object lF = lF(i);
        return lF == null ? 0 : lF.getClass().hashCode();
    }

    public final long getItemId(int i) {
        Object lF = lF(i);
        o oVar = (o) this.jRs.get(getItemViewType(i));
        return (lF == null || oVar == null) ? 0 : oVar.bf(lF);
    }

    public final int getItemCount() {
        return this.jRt == null ? 0 : this.jRt.size();
    }
}
