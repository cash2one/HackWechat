package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.product.a.a;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<String> pec = null;
    private List<String> pfU = null;
    Filter pfV = new 1(this);

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public h(Context context) {
        this.mContext = context;
        this.pfU = a.biM().biO().pec;
    }

    public final int getCount() {
        return this.pec != null ? this.pec.size() : 0;
    }

    private String kC(int i) {
        return (String) this.pec.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            aVar2.pfA = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pfA.setText(kC(i));
        return view;
    }

    public final Filter getFilter() {
        return this.pfV;
    }
}
