package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LoadMoreRecyclerView extends MRecyclerView {
    private View kgd;
    public a kge;
    boolean kgf;

    public LoadMoreRecyclerView(Context context) {
        super(context);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LinearLayoutManager alq() {
        getContext();
        return new LinearLayoutManager();
    }

    private void init() {
        h alq = alq();
        super.a(alq);
        a(new 1(this, alq));
        this.kgj.a(new 2(this, alq));
    }

    public final void addFooterView(View view) {
        int anZ = this.kgj.anZ() - 1;
        if (this.kgd == null || anZ < 0) {
            super.addFooterView(view);
        } else {
            super.c(anZ, view);
        }
    }

    public final void a(h hVar) {
    }

    public final void cg(View view) {
        if (this.kgd != view) {
            if (!(this.kgd == null || this.kgd.equals(view))) {
                cf(this.kgd);
            }
            this.kgd = view;
            if (this.kgd != null) {
                addFooterView(this.kgd);
                this.kgd.setVisibility(this.kgf ? 0 : 8);
            }
        }
    }

    public final void mu(int i) {
        cg(LayoutInflater.from(getContext()).inflate(i, this, false));
    }

    public final void dB(boolean z) {
        if (this.kgf != z) {
            this.kgf = z;
            if (this.kgd != null) {
                this.kgd.setVisibility(this.kgf ? 0 : 8);
            }
        }
    }

    protected final boolean aoa() {
        if (this.kgd == null) {
            return super.aoa();
        }
        if (this.kgj.getItemCount() == 1 && this.kgj.anZ() == 1) {
            return true;
        }
        return false;
    }
}
