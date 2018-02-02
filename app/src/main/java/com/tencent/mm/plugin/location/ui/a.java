package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends l {
    private int nSl = 8;
    private ArrayList<String> nSm = new ArrayList();

    class a {
        ImageView hvY;
        TextView nSn;
        final /* synthetic */ a nSo;

        a(a aVar) {
            this.nSo = aVar;
        }
    }

    public final void D(ArrayList<String> arrayList) {
        boolean z;
        this.nSm.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.nSm.add((String) it.next());
        }
        String str = "MicroMsg.MMGridPaperAdapter";
        String str2 = "notifyDataSetChange, notifier is null ? %B";
        Object[] objArr = new Object[1];
        if (this.ybk == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.ybk != null) {
            this.ybk.cpl();
        }
    }

    public final int getCount() {
        return this.nSm.size();
    }

    public final View d(int i, View view) {
        a aVar = new a(this);
        if (view == null) {
            view = View.inflate(ac.getContext(), R.i.daK, null);
            aVar.hvY = (ImageView) view.findViewById(R.h.bLK);
            aVar.nSn = (TextView) view.findViewById(R.h.cUp);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) this.nSm.get(i);
        b.a(aVar.hvY, str);
        CharSequence gu = r.gu(str);
        if (gu.length() > this.nSl) {
            gu = gu.subSequence(0, this.nSl + 1) + "...";
        }
        aVar.nSn.setText(gu);
        return view;
    }

    public final Object getItem(int i) {
        return this.nSm.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
