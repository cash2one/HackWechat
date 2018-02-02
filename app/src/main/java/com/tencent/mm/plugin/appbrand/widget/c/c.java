package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

public final class c extends b {
    private AuthorizeItemListView iVA;
    private LinearLayout iVC;
    private final String iVz;
    private b jWp;
    private final String mAppName;
    private Context mContext;

    public c(Context context, LinkedList<bec> linkedList, String str, String str2, a aVar) {
        super(context, (byte) 0);
        this.mContext = context;
        this.mAppName = bh.ou(str);
        this.iVz = str2;
        if (linkedList == null || linkedList.size() <= 0) {
            throw new IllegalArgumentException("scopeInfoList is empty or null");
        }
        ViewGroup viewGroup = (ViewGroup) v.fv(this.mContext).inflate(h.iwI, null);
        setContentView(viewGroup);
        b.Jj().a((ImageView) viewGroup.findViewById(g.bKz), this.iVz, a.Ji(), f.hkr);
        ((TextView) viewGroup.findViewById(g.bKE)).setText(this.mContext.getString(j.etq, new Object[]{this.mAppName}));
        this.iVA = (AuthorizeItemListView) viewGroup.findViewById(g.bLt);
        this.jWp = new b(linkedList);
        this.iVA.setAdapter(this.jWp);
        if (linkedList.size() > 5) {
            this.iVA.Pb = linkedList.size();
            this.iVC = (LinearLayout) viewGroup.findViewById(g.bLw);
            LayoutParams layoutParams = (LayoutParams) this.iVC.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.bxJ);
            this.iVC.setLayoutParams(layoutParams);
        }
        ((Button) viewGroup.findViewById(g.cug)).setOnClickListener(new 1(this, linkedList, aVar, this));
        ((Button) viewGroup.findViewById(g.cus)).setOnClickListener(new 2(this, linkedList, aVar, this));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new 3(this, aVar));
    }
}
