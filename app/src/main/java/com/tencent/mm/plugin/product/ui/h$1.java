package com.tencent.mm.plugin.product.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.List;

class h$1 extends Filter {
    final /* synthetic */ h pfW;

    h$1(h hVar) {
        this.pfW = hVar;
    }

    protected final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
        h.a(this.pfW, (List) filterResults.values);
        this.pfW.notifyDataSetChanged();
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        ArrayList arrayList = new ArrayList();
        for (String str : h.a(this.pfW)) {
            if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                arrayList.add(str);
            }
        }
        filterResults.values = arrayList;
        filterResults.count = arrayList.size();
        return filterResults;
    }
}
