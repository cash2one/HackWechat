package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.q;

public final class g {
    public static q a(Context context, View view, String[] strArr, OnItemClickListener onItemClickListener) {
        View inflate = View.inflate(context, R.i.dpp, null);
        HorizontalListView horizontalListView = (HorizontalListView) inflate.findViewById(R.h.cPG);
        a aVar = new a(context, strArr);
        horizontalListView.setAdapter(aVar);
        horizontalListView.setOnItemClickListener(onItemClickListener);
        horizontalListView.setBackgroundResource(R.g.bGn);
        q qVar = new q(inflate);
        qVar.setHeight(a.fromDPToPix(context, 120));
        int i = 0;
        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
            View view2 = aVar.getView(i2, null, horizontalListView);
            view2.measure(0, 0);
            i += view2.getMeasuredWidth();
        }
        qVar.setWidth(a.fromDPToPix(context, 20) + i);
        qVar.showAsDropDown(view, (view.getWidth() - (a.fromDPToPix(context, 20) + i)) / 2, 0);
        return qVar;
    }
}
