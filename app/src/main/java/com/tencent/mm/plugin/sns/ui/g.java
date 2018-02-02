package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g extends BaseAdapter {
    private final Activity fAF;
    private final af handler = new af();
    final List<aqr> list = new ArrayList();
    private String nQA = "";
    final Map<Integer, Integer> rqp = new HashMap();
    final Map<Integer, Integer> rqq = new HashMap();
    int rqr = 0;
    int rqs = 0;
    private final b rqt;
    private final h rqu;
    final a rqv;

    static abstract class b {
        public a rqA = new a();
        OnClickListener rqx = new 1(this);
        OnClickListener rqy = new 2(this);
        OnClickListener rqz = new OnClickListener(this) {
            final /* synthetic */ b rqB;

            {
                this.rqB = r1;
            }

            public final void onClick(View view) {
                this.rqB.rqA = (a) view.getTag();
                this.rqB.xq(this.rqB.rqA.position);
            }
        };

        public abstract void xq(int i);
    }

    public g(Activity activity, String str, b bVar, a aVar) {
        this.fAF = activity;
        this.nQA = str;
        this.rqt = bVar;
        this.rqv = aVar;
        this.rqu = new h(new 1(this));
        Xy();
    }

    public final void Xy() {
        if (this.rqu != null) {
            r.QH();
            String QE = n.QE();
            x.d("MicroMsg.ArtistAdapter", "packgePath: " + QE);
            this.rqu.eo(this.nQA, QE);
        }
    }

    public final int getCount() {
        return this.rqr;
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c(this);
            view = View.inflate(this.fAF, com.tencent.mm.plugin.sns.i.g.qHc, null);
            cVar.jpW = (TextView) view.findViewById(f.qFz);
            cVar.rqC = (TextView) view.findViewById(f.qFA);
            cVar.rqD = (ImageView) view.findViewById(f.qCs);
            cVar.rqE = (ImageView) view.findViewById(f.qCt);
            cVar.rqF = (ImageView) view.findViewById(f.qCu);
            cVar.rqG = (LinearLayout) view.findViewById(f.qCK);
            cVar.rqH = view.findViewById(f.qCH);
            cVar.rqD.setOnClickListener(this.rqt.rqx);
            cVar.rqE.setOnClickListener(this.rqt.rqy);
            cVar.rqF.setOnClickListener(this.rqt.rqz);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        int intValue = this.rqp.get(Integer.valueOf(i)) != null ? ((Integer) this.rqp.get(Integer.valueOf(i))).intValue() : -1;
        cVar.rqD.setVisibility(8);
        cVar.rqE.setVisibility(8);
        cVar.rqF.setVisibility(8);
        cVar.rqH.setVisibility(8);
        if (cVar.rqw.nQA.equals("en")) {
            cVar.jpW.setVisibility(8);
            cVar.rqC.setVisibility(4);
        } else {
            cVar.jpW.setVisibility(4);
            cVar.rqC.setVisibility(8);
        }
        if (intValue >= this.rqs || intValue == -1) {
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            String str = "";
            if (intValue - 1 >= 0) {
                Object obj = ((aqr) getItem(intValue - 1)).nfe;
            } else {
                String str2 = str;
            }
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setVisibility(0);
            int intValue2 = this.rqq.get(Integer.valueOf(i)) != null ? ((Integer) this.rqq.get(Integer.valueOf(i))).intValue() : 1;
            aqr com_tencent_mm_protocal_c_aqr = (aqr) getItem(intValue);
            if (com_tencent_mm_protocal_c_aqr.nfe.equals("") || !com_tencent_mm_protocal_c_aqr.nfe.equals(r4)) {
                if (this.nQA.equals("en")) {
                    cVar.rqC.setVisibility(0);
                    cVar.rqC.setText(com_tencent_mm_protocal_c_aqr.nfe);
                    cVar.rqH.setVisibility(0);
                } else {
                    cVar.jpW.setVisibility(0);
                    cVar.jpW.setText(com_tencent_mm_protocal_c_aqr.nfe);
                    cVar.rqH.setVisibility(0);
                }
            }
            if (intValue2 > 0) {
                a(intValue, cVar.rqD);
            }
            if (intValue2 >= 2) {
                a(intValue + 1, cVar.rqE);
            }
            if (intValue2 >= 3) {
                a(intValue + 2, cVar.rqF);
            }
        }
        return view;
    }

    private void a(int i, ImageView imageView) {
        aqr com_tencent_mm_protocal_c_aqr = (aqr) getItem(i);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.fzW = "";
        aVar.position = i;
        imageView.setTag(aVar);
        ae.bvs().b(com_tencent_mm_protocal_c_aqr, imageView, this.fAF.hashCode(), an.xyY);
    }
}
