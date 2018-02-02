package com.tencent.mm.plugin.appbrand.widget.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.protocal.c.bec;
import java.util.LinkedList;

final class c$b extends BaseAdapter {
    private LinkedList<bec> iVH;

    public final /* synthetic */ Object getItem(int i) {
        return ka(i);
    }

    c$b(LinkedList<bec> linkedList) {
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
        bec ka = ka(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), h.daG, null);
            aVar2.iVL = (ImageView) view.findViewById(g.bKp);
            aVar2.iVM = (TextView) view.findViewById(g.bKo);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (ka.wJQ == 1) {
            aVar.iVL.setImageResource(i.dyV);
        } else if (ka.wJQ == 3) {
            aVar.iVL.setImageResource(i.dyU);
        } else {
            aVar.iVL.setImageResource(i.dyT);
        }
        aVar.iVM.setText(ka.nfe);
        aVar.iVL.setOnClickListener(new 1(this, ka, aVar.iVL));
        return view;
    }
}
