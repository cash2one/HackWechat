package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

class EnterpriseBizContactListView$3 implements a {
    final /* synthetic */ EnterpriseBizContactListView kGr;

    EnterpriseBizContactListView$3(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.kGr = enterpriseBizContactListView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        c cVar;
        long Wq = bh.Wq();
        Context context = this.kGr.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.i.dgn, null);
            cVar = new c();
            cVar.kEY = (TextView) view.findViewById(R.h.bSw);
            cVar.contentView = view.findViewById(R.h.bYL);
            cVar.iip = (ImageView) view.findViewById(R.h.bKq);
            cVar.kGy = (ImageView) view.findViewById(R.h.czY);
            cVar.kBH = (TextView) view.findViewById(R.h.bOW);
            cVar.kGz = view.findViewById(R.h.cLl);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        b bVar = (b) dVar.data;
        if (bVar == null) {
            x.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
        } else {
            Object obj = null;
            if (bVar.kEC.Lg()) {
                obj = 1;
            }
            if (this.kGr.ykc && z) {
                if (dVar.ykk.equals("!2")) {
                    cVar.kEY.setText(this.kGr.getContext().getString(R.l.eca));
                    cVar.kEY.setVisibility(0);
                } else if (!dVar.ykk.equals("!1")) {
                    cVar.kEY.setText(dVar.ykk);
                    cVar.kEY.setVisibility(0);
                }
                if (obj == null) {
                    cVar.username = bVar.userName;
                    cVar.iip.setImageResource(R.k.dyx);
                    EnterpriseBizContactListView.a(cVar.kBH, context, this.kGr.getResources().getString(R.l.ebI), (int) cVar.kBH.getTextSize());
                } else {
                    cVar.username = bVar.userName;
                    cVar.iconUrl = bVar.kEC.field_brandIconURL;
                    cVar.iip.setTag(bVar.userName);
                    com.tencent.mm.pluginsdk.ui.a.b.a(cVar.iip, cVar.username);
                    EnterpriseBizContactListView.a(cVar.kBH, context, bVar.jLe.AQ(), (int) cVar.kBH.getTextSize());
                }
                x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar.kEC.field_status)});
                cVar.kGy.setVisibility(bVar.kEC.field_status != 1 ? 0 : 8);
                if (this.kGr.mMode == 0 || !z2) {
                    cVar.kGz.setBackgroundResource(R.g.bDp);
                } else {
                    cVar.kGz.setBackgroundResource(R.g.bBy);
                }
                if (this.kGr.ykd) {
                    cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.kGr.getContext().getResources().getDimension(R.f.bvJ), cVar.contentView.getPaddingBottom());
                } else {
                    cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.kGr.getContext().getResources().getDimension(R.f.bun), cVar.contentView.getPaddingBottom());
                }
                x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
            }
            cVar.kEY.setVisibility(8);
            if (obj == null) {
                cVar.username = bVar.userName;
                cVar.iconUrl = bVar.kEC.field_brandIconURL;
                cVar.iip.setTag(bVar.userName);
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.iip, cVar.username);
                EnterpriseBizContactListView.a(cVar.kBH, context, bVar.jLe.AQ(), (int) cVar.kBH.getTextSize());
            } else {
                cVar.username = bVar.userName;
                cVar.iip.setImageResource(R.k.dyx);
                EnterpriseBizContactListView.a(cVar.kBH, context, this.kGr.getResources().getString(R.l.ebI), (int) cVar.kBH.getTextSize());
            }
            x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar.kEC.field_status)});
            if (bVar.kEC.field_status != 1) {
            }
            cVar.kGy.setVisibility(bVar.kEC.field_status != 1 ? 0 : 8);
            if (this.kGr.mMode == 0) {
            }
            cVar.kGz.setBackgroundResource(R.g.bDp);
            if (this.kGr.ykd) {
                cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.kGr.getContext().getResources().getDimension(R.f.bvJ), cVar.contentView.getPaddingBottom());
            } else {
                cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.kGr.getContext().getResources().getDimension(R.f.bun), cVar.contentView.getPaddingBottom());
            }
            x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
        }
        return view;
    }
}
