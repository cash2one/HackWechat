package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import java.util.ArrayList;
import java.util.List;

public class MailAddrsViewControl$b extends BaseAdapter implements Filterable {
    private Context mContext;
    private final Object mLock = new Object();
    private List<i> ptf;
    private boolean ptg = true;
    private ArrayList<i> pth;
    private a pti;

    public final /* synthetic */ Object getItem(int i) {
        return vd(i);
    }

    public MailAddrsViewControl$b(Context context, List<i> list) {
        this.mContext = context;
        this.ptf = list;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.ptg = true;
    }

    public final int getCount() {
        return this.ptf.size();
    }

    public final i vd(int i) {
        return (i) this.ptf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dpU, null);
            b bVar = new b(this, (byte) 0);
            bVar.lgz = (TextView) view.findViewById(R.h.cEB);
            bVar.psQ = (TextView) view.findViewById(R.h.cEz);
            bVar.ptk = (CheckBox) view.findViewById(R.h.cEC);
            view.setTag(bVar);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view;
        }
        i vd = vd(i);
        b bVar2 = (b) view.getTag();
        bVar2.lgz.setText(vd.name);
        bVar2.psQ.setText(vd.nQt);
        bVar2.ptk.setVisibility(8);
        view.setBackgroundColor(-789517);
        return view;
    }

    public final Filter getFilter() {
        if (this.pti == null) {
            this.pti = new a(this, (byte) 0);
        }
        return this.pti;
    }
}
