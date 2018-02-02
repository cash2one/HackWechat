package com.tencent.mm.ui.widget;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.cb.a.f;

class i$a extends BaseAdapter {
    final /* synthetic */ i zuq;

    private i$a(i iVar) {
        this.zuq = iVar;
    }

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public final int getCount() {
        return i.a(this.zuq).size();
    }

    private String kC(int i) {
        return (String) ((MenuItem) i.a(this.zuq).ycc.get(i)).getTitle();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        if (view == null) {
            view2 = (TextView) i.f(this.zuq).inflate(f.dpq, viewGroup, false);
        } else {
            view2 = (TextView) view;
        }
        CharSequence kC = kC(i);
        view2.setTag(kC);
        view2.setText(kC);
        return view2;
    }
}
