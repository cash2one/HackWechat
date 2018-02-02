package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.v;

class NotInterestMenu$a extends BaseAdapter {
    final /* synthetic */ NotInterestMenu qNB;

    NotInterestMenu$a(NotInterestMenu notInterestMenu) {
        this.qNB = notInterestMenu;
    }

    public final int getCount() {
        return NotInterestMenu.btR().length;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(NotInterestMenu.btR()[i]);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fv(NotInterestMenu.d(this.qNB)).inflate(g.qGD, viewGroup, false);
            a aVar = new a(this);
            aVar.qNC = (TextView) view.findViewById(f.qCW);
            view.setTag(aVar);
        }
        ((a) view.getTag()).qNC.setText(NotInterestMenu.btR()[i]);
        return view;
    }
}
