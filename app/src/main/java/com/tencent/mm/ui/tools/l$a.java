package com.tencent.mm.ui.tools;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

class l$a extends BaseAdapter {
    final /* synthetic */ l zlw;

    private l$a(l lVar) {
        this.zlw = lVar;
    }

    public final int getCount() {
        return l.a(this.zlw).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = l.b(this.zlw).inflate(h.gXC, viewGroup, false);
            a aVar2 = new a(this, (byte) 0);
            aVar2.jpW = (TextView) view.findViewById(g.title);
            aVar2.jMv = (ImageView) view.findViewById(g.icon);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        MenuItem item = l.a(this.zlw).getItem(i);
        aVar.jpW.setText(item.getTitle());
        Drawable icon = l.a(this.zlw).getItem(i).getIcon();
        if (icon != null) {
            aVar.jMv.setVisibility(0);
            aVar.jMv.setImageDrawable(icon);
        } else if (l.c(this.zlw) != null) {
            aVar.jMv.setVisibility(0);
            l.c(this.zlw).a(aVar.jMv, item);
        } else {
            aVar.jMv.setVisibility(8);
        }
        if (l.d(this.zlw) != null) {
            l.d(this.zlw).a(aVar.jpW, item);
        }
        return view;
    }
}
