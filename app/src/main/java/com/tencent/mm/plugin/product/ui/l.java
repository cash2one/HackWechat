package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class l extends BaseAdapter {
    private Context mContext;
    List<a> pgD;

    public final /* synthetic */ Object getItem(int i) {
        return uI(i);
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.pgD != null ? this.pgD.size() : 0;
    }

    private a uI(int i) {
        return (a) this.pgD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        j.a aVar;
        a uI = uI(i);
        if (view == null || view.getTag() == null) {
            m mVar = new m();
            view = View.inflate(this.mContext, g.uDF, null);
            mVar.ihS = (TextView) view.findViewById(f.uqV);
            mVar.jNs = (ImageView) view.findViewById(f.uqU);
            view.setTag(mVar);
            aVar = mVar;
        } else {
            m mVar2 = (m) view.getTag();
        }
        aVar.pgE = uI;
        aVar.ihS.setText(uI.title);
        aVar.jNs.setImageBitmap(j.a(new c(uI.iconUrl)));
        j.a(aVar);
        return view;
    }
}
