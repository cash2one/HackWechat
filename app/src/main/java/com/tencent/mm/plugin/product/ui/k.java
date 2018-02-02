package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class k extends BaseAdapter {
    private Context mContext;
    List<n> pgA;
    OnItemClickListener pgt;

    public final /* synthetic */ Object getItem(int i) {
        return uH(i);
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.pgA != null ? this.pgA.size() : 0;
    }

    private n uH(int i) {
        return (n) this.pgA.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        n uH = uH(i);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.mContext, g.uDG, null);
            aVar2.pgu = (TextView) view.findViewById(f.uqX);
            aVar2.pgv = (MaxGridView) view.findViewById(f.uqW);
            aVar2.pgB = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pgu.setText(uH.name);
        aVar.pgv.setOnItemClickListener(this.pgt);
        aVar.pgB.pgD = uH.pev;
        aVar.pgB.notifyDataSetChanged();
        aVar.pgv.setAdapter(aVar.pgB);
        return view;
    }
}
