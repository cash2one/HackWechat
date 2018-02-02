package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.input.b.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

final class a extends ArrayAdapter<b> implements g {
    private final LayoutInflater DF;
    private b jZS;
    h jZT;
    private boolean jZU = false;

    a(Context context, List<b> list) {
        super(context, h.iwX, list);
        this.DF = LayoutInflater.from(context);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void a(b bVar) {
        this.jZS = bVar;
        this.jZS.setOnDismissListener(new 1(this));
    }

    public final void ann() {
        this.jZS.setOnDismissListener(null);
        this.jZS = null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int i3 = 8;
        if (view == null) {
            view = this.DF.inflate(h.iwX, viewGroup, false);
        }
        a aVar2 = (a) view.getTag();
        if (aVar2 == null) {
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = aVar2;
        }
        b bVar = (b) getItem(i);
        aVar.jZZ = bVar;
        aVar.jZW.setText(bVar.title);
        aVar.jZX.setText(bVar.content);
        TextView textView = aVar.jZX;
        if (bh.ov(bVar.content)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        textView.setVisibility(i2);
        View view2 = aVar.iiS;
        if (i != getCount() - 1) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        return view;
    }

    public final Filter getFilter() {
        return super.getFilter();
    }
}
