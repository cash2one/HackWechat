package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class SelectScanModeGrid extends GridView {

    public static class a extends BaseAdapter {
        private Context context;
        private List<b> pYN;
        int pYO = -1;

        public a(Context context, List<b> list) {
            this.context = context;
            this.pYN = list;
            x.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.pYN.size());
        }

        public final int getCount() {
            return this.pYN.size();
        }

        public final Object getItem(int i) {
            if (i >= 0 && i < this.pYN.size()) {
                return this.pYN.get(i);
            }
            x.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = " + i);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.drK, null);
                aVar = new a();
                aVar.pYP = (TextView) view.findViewById(R.h.cLd);
                aVar.pfA = (TextView) view.findViewById(R.h.cLh);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i);
                if (bVar == null) {
                    x.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                } else {
                    if (bVar.pYQ == R.l.eHw) {
                        aVar.pfA.setText(p.dV(p.qbi, this.context.getString(R.l.eHw)));
                    } else {
                        aVar.pfA.setText(bVar.pYQ);
                    }
                    if (i == this.pYO) {
                        aVar.pYP.setBackgroundResource(bVar.pYS);
                    } else {
                        aVar.pYP.setBackgroundResource(bVar.pYR);
                    }
                    bVar.pYU = aVar.pYP;
                }
            }
            return view;
        }
    }

    public static class b {
        public int pYQ;
        public int pYR;
        public int pYS;
        public int pYT;
        public TextView pYU;

        public b(int i, int i2, int i3, int i4) {
            this.pYQ = i;
            this.pYR = i2;
            this.pYS = i3;
            this.pYT = i4;
        }
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
