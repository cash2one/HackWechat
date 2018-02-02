package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

class BrandServiceSortView$2 implements a {
    final /* synthetic */ BrandServiceSortView kHq;

    BrandServiceSortView$2(BrandServiceSortView brandServiceSortView) {
        this.kHq = brandServiceSortView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        b bVar;
        long Wq = bh.Wq();
        Context context = this.kHq.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.i.dbD, null);
            bVar = new b();
            bVar.kEY = (TextView) view.findViewById(R.h.bSw);
            bVar.contentView = view.findViewById(R.h.bYL);
            bVar.iip = (ImageView) view.findViewById(R.h.bKq);
            bVar.kGy = (ImageView) view.findViewById(R.h.czY);
            bVar.kBH = (TextView) view.findViewById(R.h.bOW);
            bVar.kGz = view.findViewById(R.h.cLl);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) dVar.data;
        if (bVar2 == null) {
            x.e("MicroMsg.BrandServiceSortView", "should not be empty");
        } else {
            if (this.kHq.ykc && z) {
                bVar.kEY.setText(dVar.ykk);
                bVar.kEY.setVisibility(0);
            } else {
                bVar.kEY.setVisibility(8);
            }
            bVar.username = bVar2.userName;
            bVar.iconUrl = bVar2.kEC.field_brandIconURL;
            bVar.iip.setTag(bVar2.userName);
            bVar.asF();
            BrandServiceSortView.a(this.kHq, bVar.kBH, context, bVar2.jLe.AQ(), (int) bVar.kBH.getTextSize());
            x.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar2.kEC.field_status)});
            ImageView imageView = bVar.kGy;
            int i2 = (BrandServiceSortView.c(this.kHq) && bVar2.kEC.field_status == 1) ? 0 : 8;
            imageView.setVisibility(i2);
            if (this.kHq.mMode == 0 && z2) {
                bVar.kGz.setBackgroundResource(R.g.bBy);
            } else {
                bVar.kGz.setBackgroundResource(R.g.bDp);
            }
            if (this.kHq.ykd) {
                bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) this.kHq.getContext().getResources().getDimension(R.f.bun), bVar.contentView.getPaddingBottom());
            } else {
                bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) this.kHq.getContext().getResources().getDimension(R.f.bvJ), bVar.contentView.getPaddingBottom());
            }
            x.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
        }
        return view;
    }
}
