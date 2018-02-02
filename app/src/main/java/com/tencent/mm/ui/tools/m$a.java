package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

class m$a extends BaseAdapter {
    final /* synthetic */ m zlz;

    private m$a(m mVar) {
        this.zlz = mVar;
    }

    public final int getCount() {
        return m.a(this.zlz) ? m.b(this.zlz).size() + 1 : m.b(this.zlz).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        return (m.a(this.zlz) && i == 0) ? 0 : 1;
    }

    public final int getViewTypeCount() {
        return m.a(this.zlz) ? 2 : 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2;
        if (m.a(this.zlz) && i == 0) {
            if (view == null) {
                view = m.c(this.zlz).inflate(h.gXX, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.jpW = (TextView) view.findViewById(g.title);
                aVar.jMv = (ImageView) view.findViewById(g.icon);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            aVar2.jpW.setText(m.f(this.zlz));
        } else {
            if (m.a(this.zlz)) {
                i--;
            }
            if (view == null) {
                view = m.c(this.zlz).inflate(h.doh, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.jpW = (TextView) view.findViewById(g.title);
                aVar.jMv = (ImageView) view.findViewById(g.icon);
                aVar.rno = view.findViewById(g.cIu);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            MenuItem item = m.b(this.zlz).getItem(i);
            aVar2.jpW.setText(item.getTitle());
            if (item.getIcon() != null) {
                aVar2.jMv.setVisibility(0);
                aVar2.jMv.setImageDrawable(item.getIcon());
            } else if (m.d(this.zlz) != null) {
                aVar2.jMv.setVisibility(0);
                m.d(this.zlz).a(aVar2.jMv, item);
            } else {
                aVar2.jMv.setVisibility(8);
            }
            if (m.e(this.zlz) != null) {
                m.e(this.zlz).a(aVar2.jpW, item);
            }
            if (i == m.b(this.zlz).size() - 1) {
                aVar2.rno.setBackgroundResource(f.bGA);
            } else {
                aVar2.rno.setBackgroundResource(f.bGz);
            }
        }
        return view;
    }
}
