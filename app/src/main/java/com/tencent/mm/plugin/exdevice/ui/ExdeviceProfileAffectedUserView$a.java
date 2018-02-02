package com.tencent.mm.plugin.exdevice.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ak.a;

class ExdeviceProfileAffectedUserView$a extends BaseAdapter {
    final /* synthetic */ ExdeviceProfileAffectedUserView lVr;
    private Runnable lVs;

    private ExdeviceProfileAffectedUserView$a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView) {
        this.lVr = exdeviceProfileAffectedUserView;
        this.lVs = new Runnable(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView$a lVt;

            {
                this.lVt = r1;
            }

            public final void run() {
                this.lVt.notifyDataSetChanged();
            }
        };
    }

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public final int getCount() {
        return ExdeviceProfileAffectedUserView.d(this.lVr) == null ? 0 : ExdeviceProfileAffectedUserView.d(this.lVr).size();
    }

    private String kC(int i) {
        return (String) ExdeviceProfileAffectedUserView.d(this.lVr).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String kC = kC(i);
        if (view == null) {
            view = LayoutInflater.from(this.lVr.getContext()).inflate(R.i.dgX, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.hvY = (ImageView) view.findViewById(R.h.bLC);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Runnable runnable = this.lVs;
        i JQ = n.JQ();
        if (JQ != null) {
            h jm = JQ.jm(kC);
            if (jm == null || bh.ov(jm.JH())) {
                a.hfL.a(kC, "", new com.tencent.mm.plugin.exdevice.model.f.AnonymousClass1(bh.Wp(), runnable));
            }
        }
        b.p(aVar.hvY, kC);
        return view;
    }
}
