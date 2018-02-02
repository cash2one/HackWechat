package com.tencent.mm.plugin.remittance.bankcard.model;

import android.util.Pair;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class c$a extends Filter {
    List<TransferRecordParcel> pHF;
    final /* synthetic */ c pHG;

    private c$a(c cVar) {
        this.pHG = cVar;
        this.pHF = new ArrayList();
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        this.pHF.clear();
        c.a(this.pHG).clear();
        x.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", new Object[]{charSequence});
        for (TransferRecordParcel transferRecordParcel : c.b(this.pHG)) {
            if (!bh.M(charSequence) && transferRecordParcel.pHM.contains(charSequence)) {
                int indexOf = transferRecordParcel.pHM.indexOf((String) charSequence);
                x.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", new Object[]{transferRecordParcel.pHM, Integer.valueOf(indexOf), Integer.valueOf(charSequence.length() + indexOf)});
                c.a(this.pHG).add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(r3)));
                this.pHF.add(transferRecordParcel);
            }
        }
        FilterResults filterResults = new FilterResults();
        filterResults.count = this.pHF.size();
        filterResults.values = this.pHF;
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        c.a(this.pHG, (List) filterResults.values);
        x.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", new Object[]{Integer.valueOf(c.c(this.pHG).size())});
        this.pHG.notifyDataSetChanged();
    }
}
