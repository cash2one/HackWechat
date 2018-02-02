package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends BaseAdapter {
    private final Context mContext;
    private String nQA = null;
    public b rqj = null;

    public d(Context context, b bVar) {
        this.mContext = context;
        this.rqj = bVar;
        this.nQA = w.eL(ac.getContext());
    }

    public final int getCount() {
        return this.rqj.qQI.rMn.ref.bws().size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CharSequence charSequence;
        if (view == null) {
            view = View.inflate(this.mContext, g.qGr, null);
        }
        view.setTag(this.rqj);
        a aVar = (a) getItem(i);
        if ("zh_CN".equals(this.nQA)) {
            charSequence = aVar.rep;
        } else if ("zh_TW".equals(this.nQA) || "zh_HK".equals(this.nQA)) {
            r1 = aVar.req;
        } else {
            r1 = aVar.rer;
        }
        ((TextView) view.findViewById(f.qAr)).setText(charSequence);
        view.findViewById(f.qAq).setVisibility(i == getCount() + -1 ? 8 : 0);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        return this.rqj.qQI.rMn.ref.bws().get(i);
    }
}
