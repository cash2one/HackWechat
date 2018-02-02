package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.d;
import com.tencent.mm.protocal.c.bec;
import java.util.LinkedList;

class b$b extends BaseAdapter {
    final /* synthetic */ b iVG;
    private LinkedList<bec> iVH;

    public final /* synthetic */ Object getItem(int i) {
        return ka(i);
    }

    public b$b(b bVar, LinkedList<bec> linkedList) {
        this.iVG = bVar;
        this.iVH = linkedList;
    }

    public final int getCount() {
        return this.iVH == null ? 0 : this.iVH.size();
    }

    private bec ka(int i) {
        return (bec) this.iVH.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.iVH == null || this.iVH.size() <= 0) {
            return null;
        }
        a aVar;
        final bec ka = ka(i);
        if (view == null) {
            a aVar2 = new a(this, (byte) 0);
            view = View.inflate(viewGroup.getContext(), c.daG, null);
            aVar2.iVL = (ImageView) view.findViewById(b.bKp);
            aVar2.iVM = (TextView) view.findViewById(b.bKo);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (ka.wJQ == 1) {
            aVar.iVL.setImageResource(d.dyV);
        } else if (ka.wJQ == 3) {
            aVar.iVL.setImageResource(d.dyU);
        } else {
            aVar.iVL.setImageResource(d.dyT);
        }
        aVar.iVM.setText(ka.nfe);
        final ImageView imageView = aVar.iVL;
        aVar.iVL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b$b iVK;

            public final void onClick(View view) {
                if (ka.wJQ == 2) {
                    imageView.setImageResource(d.dyV);
                    ka.wJQ = 1;
                } else if (ka.wJQ == 1) {
                    imageView.setImageResource(d.dyT);
                    ka.wJQ = 2;
                }
            }
        });
        return view;
    }
}
