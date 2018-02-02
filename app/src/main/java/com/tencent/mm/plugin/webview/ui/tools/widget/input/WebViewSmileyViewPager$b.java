package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.SoftReference;

class WebViewSmileyViewPager$b extends u {
    SparseArray<SoftReference<View>> kbl = new SparseArray();
    private boolean kbm = false;
    c tLf;

    WebViewSmileyViewPager$b() {
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
        return this.tLf.bUW().getPageCount();
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
            Object mj = this.tLf.bUW().mj(i);
            if (mj != null) {
                viewGroup.addView(mj, 0);
                this.kbl.put(i, new SoftReference(mj));
                return mj;
            }
            x.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
            return mj;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view, 0);
        return view;
    }
}
