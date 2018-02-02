package com.tencent.mm.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.FilterImageView.a;

class FilterImageView$1 implements OnItemClickListener {
    final /* synthetic */ FilterImageView zim;

    FilterImageView$1(FilterImageView filterImageView) {
        this.zim = filterImageView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a a = FilterImageView.a(this.zim);
        a.nXs = i;
        a.notifyDataSetChanged();
        try {
            FilterImageView.a(this.zim, FilterImageView.zil[i].ziw);
            FilterImageView.a(this.zim, FilterImageView.zil[i].zit, FilterImageView.zil[i].ziu, FilterImageView.zil[i].ziv);
        } catch (Throwable e) {
            x.e("MicroMsg.FilterView", e.toString());
            x.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
        } catch (Throwable e2) {
            x.e("MicroMsg.FilterView", e2.toString());
            x.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
        }
    }
}
