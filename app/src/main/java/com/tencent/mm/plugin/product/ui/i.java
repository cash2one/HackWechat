package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends BaseAdapter {
    private Context mContext;
    private c pfH = a.biN();
    LinkedList<m> pgs;
    OnItemClickListener pgt;

    public final /* synthetic */ Object getItem(int i) {
        return uF(i);
    }

    public i(Context context) {
        this.mContext = context;
        a.biM();
    }

    public final int getCount() {
        return this.pgs != null ? this.pgs.size() : 0;
    }

    private m uF(int i) {
        return (m) this.pgs.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        Pair pair;
        m uF = uF(i);
        if (view == null || view.getTag() == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, g.uDD, null);
            aVar.pgu = (TextView) view.findViewById(f.uqT);
            aVar.pgv = (MaxGridView) view.findViewById(f.uqR);
            aVar.pgw = new j(this.mContext);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pgu.setText(uF.peW);
        aVar.pgv.setOnItemClickListener(this.pgt);
        j jVar = aVar.pgw;
        c cVar = this.pfH;
        String str2 = uF.peV;
        if (cVar.pdW.containsKey(str2)) {
            str = (String) cVar.pdW.get(str2);
        } else {
            str = null;
        }
        jVar.pgy = uF;
        jVar.pgz = str;
        Context context = this.mContext;
        LinkedList linkedList = uF.peX;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (com.tencent.mm.bv.a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(g.uDC, null)).getPaint();
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(((h) it.next()).name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix2 = ((int) f) + (com.tencent.mm.bv.a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = com.tencent.mm.bv.a.fromDPToPix(context, 12);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = (fromDPToPix - (fromDPToPix3 * i2)) / (i2 + 1);
        }
        for (fromDPToPix3 = 4; fromDPToPix3 > 0; fromDPToPix3--) {
            if (fromDPToPix2 < iArr[fromDPToPix3 - 1]) {
                pair = new Pair(Integer.valueOf(fromDPToPix3), Integer.valueOf(iArr[fromDPToPix3 - 1]));
                break;
            }
        }
        pair = new Pair(Integer.valueOf(1), Integer.valueOf(fromDPToPix));
        x.d("MicroMsg.MallProductImageAdapter", uF.peW + " numColumns = " + pair);
        aVar.pgv.setColumnWidth(((Integer) pair.second).intValue());
        aVar.pgw.notifyDataSetChanged();
        aVar.pgv.setAdapter(aVar.pgw);
        return view;
    }
}
