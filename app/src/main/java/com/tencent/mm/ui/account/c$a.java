package com.tencent.mm.ui.account;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.List;

class c$a extends Filter {
    final /* synthetic */ c xNu;

    private c$a(c cVar) {
        this.xNu = cVar;
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        int i = 0;
        FilterResults filterResults = new FilterResults();
        if (c.a(this.xNu) == null) {
            synchronized (c.b(this.xNu)) {
                c.a(this.xNu, new ArrayList(c.c(this.xNu)));
            }
        }
        if (charSequence == null || charSequence.length() == 0) {
            synchronized (c.b(this.xNu)) {
                ArrayList arrayList = new ArrayList(c.a(this.xNu));
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
        } else {
            String str;
            ArrayList a;
            int size;
            ArrayList arrayList2;
            String toLowerCase = charSequence.toString().toLowerCase();
            String str2 = "";
            if (c.d(this.xNu) != null && c.d(this.xNu).length() > 0) {
                String[] split = toLowerCase.split(c.d(this.xNu));
                if (split != null && split.length > 1) {
                    str2 = split[0] + c.d(this.xNu);
                    toLowerCase = split[1];
                    str = str2;
                    str2 = toLowerCase;
                    a = c.a(this.xNu);
                    size = a.size();
                    arrayList2 = new ArrayList(size);
                    while (i < size) {
                        toLowerCase = (String) a.get(i);
                        if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                            arrayList2.add(str + toLowerCase);
                        }
                        i++;
                    }
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                }
            }
            str = str2;
            str2 = toLowerCase;
            a = c.a(this.xNu);
            size = a.size();
            arrayList2 = new ArrayList(size);
            while (i < size) {
                toLowerCase = (String) a.get(i);
                if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                    arrayList2.add(str + toLowerCase);
                }
                i++;
            }
            filterResults.values = arrayList2;
            filterResults.count = arrayList2.size();
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        c.a(this.xNu, (List) filterResults.values);
        if (filterResults.count > 0) {
            this.xNu.notifyDataSetChanged();
        } else {
            this.xNu.notifyDataSetInvalidated();
        }
    }
}
