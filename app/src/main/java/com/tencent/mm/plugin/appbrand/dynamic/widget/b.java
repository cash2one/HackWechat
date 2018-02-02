package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.d;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b {
    private Context context;
    AuthorizeItemListView iVA;
    private b iVB;
    private LinearLayout iVC;
    public String iVz;
    public String mAppName = "";

    public b(Context context) {
        this.context = context;
    }

    public final boolean a(String str, final LinkedList<bec> linkedList, final a aVar) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            return false;
        }
        final k kVar = new k(this.context);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(c.daF, null);
        TextView textView = (TextView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.cZi);
        if (!bh.ov(null)) {
            textView.setText(null);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.bKz);
        Drawable a = android.support.v4.b.a.k.a(ac.getResources(), a.decodeResource(ac.getResources(), d.bBB));
        a.br();
        if (imageView != null) {
            com.tencent.mm.modelappbrand.a.b.Jj().a(imageView, this.iVz, a, f.hkr);
        }
        textView = (TextView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.bKE);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView.setText(this.context.getString(e.etq, new Object[]{this.mAppName}));
        this.iVA = (AuthorizeItemListView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.bLt);
        this.iVB = new b(this, linkedList);
        this.iVA.setAdapter(this.iVB);
        if (linkedList.size() > 5) {
            this.iVA.Pb = linkedList.size();
            this.iVC = (LinearLayout) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.bLw);
            LayoutParams layoutParams = (LayoutParams) this.iVC.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.appbrand.wxawidget.b.a.bxJ);
            this.iVC.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.cug)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b iVG;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((bec) linkedList.get(i)).wJQ == 2 || ((bec) linkedList.get(i)).wJQ == 3) {
                        arrayList.add(((bec) linkedList.get(i)).vOl);
                    }
                    i++;
                }
                x.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.d(1, bundle);
                kVar.dismiss();
            }
        });
        ((Button) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.cus)).setOnClickListener(new 2(this, linkedList, aVar, kVar));
        kVar.setCanceledOnTouchOutside(false);
        kVar.setOnDismissListener(new 3(this));
        kVar.setOnCancelListener(new 4(this, aVar));
        kVar.setContentView(linearLayout);
        try {
            kVar.show();
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
