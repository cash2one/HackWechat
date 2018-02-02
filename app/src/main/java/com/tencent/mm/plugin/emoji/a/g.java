package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.f.a;

public final class g extends f {
    private int lua = 0;
    private int lub = 0;
    private int luc = 0;

    public final /* synthetic */ Object getItem(int i) {
        return super.oG(i);
    }

    public g(Context context) {
        super(context);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        if (this.lua > 0) {
            if (i == 0) {
                aVar.lty.setVisibility(0);
                aVar.lty.setText(this.mContext.getString(R.l.eaw));
            } else if (this.lub > 0 && i == this.lua) {
                aVar.lty.setVisibility(0);
                aVar.lty.setText(this.mContext.getString(R.l.eaH));
            } else if (i == this.lua + this.lub) {
                aVar.lty.setVisibility(0);
                aVar.lty.setText(this.mContext.getString(R.l.eal));
            } else {
                aVar.lty.setVisibility(8);
            }
        } else if (this.lub > 0) {
            if (i == 0) {
                aVar.lty.setVisibility(0);
                aVar.lty.setText(this.mContext.getString(R.l.eaH));
            } else if (i == this.lua + this.lub) {
                aVar.lty.setVisibility(0);
                aVar.lty.setText(this.mContext.getString(R.l.eal));
            } else {
                aVar.lty.setVisibility(8);
            }
        }
        if (aVar.ltA != null) {
            aVar.ltA.postDelayed(new 1(this, aVar), 100);
        }
        return super.b(i, view, viewGroup);
    }

    public final f oG(int i) {
        return super.oG(i);
    }

    public final int aAE() {
        return this.lua;
    }

    public final void oD(int i) {
        this.lua = i;
    }

    public final int aAF() {
        return this.lub;
    }

    public final void oE(int i) {
        this.lub = i;
    }

    public final int aAG() {
        return this.luc;
    }

    public final void oF(int i) {
        this.luc = i;
    }
}
