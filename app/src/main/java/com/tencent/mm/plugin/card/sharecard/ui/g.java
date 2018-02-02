package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    c kOB;
    List<b> kOM;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return nD(i);
    }

    public final int getCount() {
        return this.kOM.size();
    }

    public final b nD(int i) {
        return (b) this.kOM.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kOB.a(i, view, nD(i));
    }
}
