package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.bx.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid.b;
import com.tencent.mm.ui.v;

class WebViewSmileyGrid$a extends BaseAdapter {
    final /* synthetic */ WebViewSmileyGrid tLh;

    private WebViewSmileyGrid$a(WebViewSmileyGrid webViewSmileyGrid) {
        this.tLh = webViewSmileyGrid;
    }

    public final int getCount() {
        return WebViewSmileyGrid.d(this.tLh);
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = v.fv(this.tLh.getContext()).inflate(R.i.duf, null);
            view.setLayoutParams(new LayoutParams(-1, ((WebViewSmileyGrid.b(this.tLh).kbf - a.aa(this.tLh.getContext(), R.f.bvz)) - a.aa(this.tLh.getContext(), R.f.bxh)) / WebViewSmileyGrid.f(this.tLh)));
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (i == getCount() - 1) {
            bVar.jCP.setImageResource(R.g.bBE);
            bVar.jCP.setContentDescription(this.tLh.getContext().getString(R.l.dYq));
        } else {
            int d = ((WebViewSmileyGrid.d(this.tLh) - 1) * WebViewSmileyGrid.c(this.tLh)) + i;
            if (d > WebViewSmileyGrid.e(this.tLh) - 1) {
                bVar.jCP.setImageDrawable(null);
            } else {
                bVar.jCP.setImageDrawable(e.chc().mf(d));
            }
        }
        return view;
    }
}
