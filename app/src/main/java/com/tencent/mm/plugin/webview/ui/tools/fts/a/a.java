package com.tencent.mm.plugin.webview.ui.tools.fts.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public final class a extends android.support.v7.widget.RecyclerView.a<t> {
    public List<c> hiv;
    List<View> tEQ;
    List<View> tER;
    public c tES;
    private c tlo;

    public class b extends t {
        private TextView ihS;
        private ImageView jNs;
        private TextView pXZ;
        private View rno;
        final /* synthetic */ a tEU;
        private TextView tEW;
        private View tEX;

        public b(a aVar, View view) {
            this.tEU = aVar;
            super(view);
            this.rno = view.findViewById(R.h.cIu);
            this.jNs = (ImageView) view.findViewById(R.h.coO);
            this.ihS = (TextView) view.findViewById(R.h.cSu);
            this.pXZ = (TextView) view.findViewById(R.h.cPc);
            this.tEW = (TextView) view.findViewById(R.h.cRK);
            this.tEX = view.findViewById(R.h.divider);
        }
    }

    public a() {
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDA = true;
        aVar.hDz = true;
        this.tlo = aVar.PK();
        this.hiv = new ArrayList();
        this.tEQ = new ArrayList();
        this.tER = new ArrayList();
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == 333) {
            return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.diM, viewGroup, false));
        }
        View frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new LayoutParams(-1, -2));
        return new a(frameLayout);
    }

    public final void a(t tVar, int i) {
        if (i < this.tEQ.size()) {
            a((a) tVar, (View) this.tEQ.get(i));
        } else if (i >= this.tEQ.size() + this.hiv.size()) {
            a((a) tVar, (View) this.tER.get((i - this.hiv.size()) - this.tEQ.size()));
        } else {
            CharSequence charSequence;
            b bVar = (b) tVar;
            int size = i - this.tEQ.size();
            c cVar = (c) this.hiv.get(size);
            x.v("FtsBrowseHistoryAdapter", "item %s", new Object[]{cVar.toString()});
            bVar.ihS.setText(cVar.title);
            bVar.pXZ.setText(cVar.bhd);
            TextView c = bVar.tEW;
            Context context = bVar.ihS.getContext();
            long j = cVar.timestamp;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                int i2;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i2 = (int) ((timeInMillis - j) / 60000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(R.j.duu, i2, new Object[]{Integer.valueOf(i2)});
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                    long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                        if (timeInMillis <= 0 || timeInMillis > 86400000) {
                            i2 = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                            if (i2 <= 0) {
                                i2 = 1;
                            }
                            charSequence = context.getResources().getQuantityString(R.j.duv, i2, new Object[]{Integer.valueOf(i2)});
                        } else {
                            charSequence = context.getString(R.l.eiV);
                        }
                    } else {
                        i2 = (int) ((timeInMillis - j) / 3600000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(R.j.dut, i2, new Object[]{Integer.valueOf(i2)});
                    }
                }
            }
            c.setText(charSequence);
            if (!TextUtils.isEmpty(cVar.iconUrl)) {
                com.tencent.mm.aq.a.a.PH().a(cVar.iconUrl, bVar.jNs, this.tlo);
            }
            if (size == getItemCount() - 1) {
                bVar.tEX.setVisibility(8);
            } else {
                bVar.tEX.setVisibility(0);
            }
            bVar.rno.setOnClickListener(new 1(this, cVar));
            bVar.rno.setOnLongClickListener(new 2(this, cVar));
        }
    }

    public final int getItemCount() {
        return (this.tEQ.size() + this.hiv.size()) + this.tER.size();
    }

    private static void a(a aVar, View view) {
        aVar.tEV.removeAllViews();
        aVar.tEV.addView(view);
    }

    public final int bUa() {
        return this.hiv.size();
    }

    public final void ahw() {
        this.hiv.clear();
        this.UR.notifyChanged();
    }

    public final int getItemViewType(int i) {
        if (i < this.tEQ.size()) {
            return 111;
        }
        if (i >= this.tEQ.size() + this.hiv.size()) {
            return 222;
        }
        return 333;
    }
}
