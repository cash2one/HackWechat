package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.SoftReference;

class AppBrandSmileyViewPager$a extends u {
    c kaL;
    SparseArray<SoftReference<View>> kbl = new SparseArray();
    private boolean kbm = false;

    AppBrandSmileyViewPager$a() {
    }

    public final int k(Object obj) {
        if (this.kbm) {
            return -2;
        }
        return super.k(obj);
    }

    public final void notifyDataSetChanged() {
        this.kbm = true;
        super.notifyDataSetChanged();
        this.kbm = false;
    }

    public final int getCount() {
        return this.kaL.anz().getPageCount();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View view = null;
        if (this.kbl.get(i) != null) {
            view = (View) ((SoftReference) this.kbl.get(i)).get();
        }
        if (view == null) {
            Object mj = this.kaL.anz().mj(i);
            if (mj != null) {
                viewGroup.addView(mj, 0);
                this.kbl.put(i, new SoftReference(mj));
                return mj;
            }
            x.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
            return mj;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view, 0);
        return view;
    }
}
