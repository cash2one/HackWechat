package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private final Object mLock = new Object();
    private List<String> ptf;
    private ArrayList<String> pth;
    private a xNs;
    private String xNt;

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public c(Context context, String[] strArr, String str) {
        this.mContext = context;
        this.ptf = Arrays.asList(strArr);
        this.xNt = str;
    }

    public final int getCount() {
        return this.ptf.size();
    }

    private String kC(int i) {
        return (String) this.ptf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.daJ, null);
            b bVar2 = new b();
            bVar2.imw = (TextView) view.findViewById(R.h.cQF);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.imw.setText(kC(i));
        view.setBackgroundResource(R.g.bBx);
        return view;
    }

    public final Filter getFilter() {
        if (this.xNs == null) {
            this.xNs = new a(this, (byte) 0);
        }
        return this.xNs;
    }
}
