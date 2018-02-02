package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b;
import java.util.ArrayList;
import java.util.List;

class MailAddrsViewControl$b$a extends Filter {
    final /* synthetic */ b ptj;

    private MailAddrsViewControl$b$a(b bVar) {
        this.ptj = bVar;
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (b.b(this.ptj) == null) {
            synchronized (b.c(this.ptj)) {
                b.a(this.ptj, new ArrayList(b.d(this.ptj)));
            }
        }
        if (charSequence == null || charSequence.length() == 0) {
            synchronized (b.c(this.ptj)) {
                ArrayList arrayList = new ArrayList(b.b(this.ptj));
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
        } else {
            CharSequence toLowerCase = charSequence.toString().toLowerCase();
            ArrayList b = b.b(this.ptj);
            int size = b.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                i iVar = (i) b.get(i);
                if (iVar.name.toLowerCase().contains(toLowerCase) || iVar.nQt.toLowerCase().contains(toLowerCase)) {
                    arrayList2.add(iVar);
                }
            }
            filterResults.values = arrayList2;
            filterResults.count = arrayList2.size();
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        b.a(this.ptj, (List) filterResults.values);
        if (filterResults.count > 0) {
            this.ptj.notifyDataSetChanged();
            return;
        }
        b.a(this.ptj, new ArrayList(b.b(this.ptj)));
        this.ptj.notifyDataSetInvalidated();
    }
}
