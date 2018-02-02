package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.protocal.c.ea;
import java.util.List;

public class a$a extends a<a> {
    private List<ea> jNH;

    public final /* synthetic */ RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(h.iwU, viewGroup, false));
    }

    public final /* synthetic */ void a(RecyclerView$t recyclerView$t, int i) {
        a aVar = (a) recyclerView$t;
        ea eaVar = (ea) this.jNH.get(i);
        if (eaVar != null) {
            aVar.inw.setText(eaVar.aAM);
            aVar.jNI.setText(eaVar.hhA);
        }
    }

    public a$a(List<ea> list) {
        this.jNH = list;
    }

    public final int getItemCount() {
        return this.jNH == null ? 0 : this.jNH.size();
    }
}
