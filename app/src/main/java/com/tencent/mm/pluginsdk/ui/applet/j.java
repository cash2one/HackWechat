package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class j extends BaseAdapter {
    private List<String> iiE;
    private Context mContext;
    private List<String> vor;

    public j(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.iiE = list2;
        this.vor = list;
    }

    public final int getCount() {
        return this.iiE.size();
    }

    public final Object getItem(int i) {
        return this.iiE.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a dc;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dcP, null);
            dc = dc(view);
        } else {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                dc = dc(view);
            } else {
                dc = aVar;
            }
        }
        int size = this.iiE.size() % 4;
        if (i >= 0 && i < this.iiE.size() && i < this.vor.size()) {
            dc.iip.setVisibility(0);
            dc.lgz.setVisibility(0);
            b.a(dc.iip, (String) this.vor.get(i));
            dc.lgz.setText((CharSequence) this.iiE.get(i));
            dc.lgz.setText(((a) g.h(a.class)).a(this.mContext, (CharSequence) this.iiE.get(i), dc.lgz.getTextSize()));
            if (this.iiE.size() <= 12 || i < this.iiE.size() - size) {
                dc.lgz.setPadding(0, 0, 0, 0);
            } else {
                dc.lgz.setPadding(0, 0, 0, com.tencent.mm.bv.a.aa(this.mContext, R.f.buI));
            }
        }
        return view;
    }

    private static a dc(View view) {
        a aVar = new a((byte) 0);
        aVar.iip = (ImageView) view.findViewById(R.h.bSI);
        aVar.lgz = (TextView) view.findViewById(R.h.bSL);
        view.setTag(aVar);
        return aVar;
    }
}
