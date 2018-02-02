package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.z.bf;
import java.util.ArrayList;
import java.util.List;

class ReaderAppUI$a extends a<Long> {
    private Context context;
    private int hKb;
    private int kUH;
    final /* synthetic */ ReaderAppUI pAY;
    private ImageGetter pBb = new 1(this);
    private int pBc = 0;
    private int pBd = 0;
    private int pBe = 0;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public final /* synthetic */ Object getItem(int i) {
        return vj(i);
    }

    public ReaderAppUI$a(ReaderAppUI readerAppUI, Context context, Long l) {
        this.pAY = readerAppUI;
        super(context, l);
        this.context = context;
        this.kUH = 3;
        this.hKb = g.bmp().gV(ReaderAppUI.a(readerAppUI));
        this.pBd = context.getResources().getDimensionPixelSize(R.f.bvS);
        this.pBe = context.getResources().getDimensionPixelSize(R.f.buM);
        this.pBc = context.getResources().getDimensionPixelSize(R.f.buo);
    }

    protected final void Xz() {
        Xy();
    }

    public final boolean awe() {
        return this.kUH >= this.hKb;
    }

    public final int bmq() {
        return this.kUH;
    }

    public final int awf() {
        if (awe()) {
            return 0;
        }
        this.kUH += 3;
        if (this.kUH <= this.hKb) {
            return 3;
        }
        this.kUH = this.hKb;
        return this.hKb % 3;
    }

    public final void Xy() {
        this.hKb = g.bmp().gV(20);
        setCursor(g.bmp().aY(this.kUH, 20));
        super.notifyDataSetChanged();
    }

    private Long vj(int i) {
        return (Long) super.getItem(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        x.w("MicroMsg.ReaderAppUI", "ashutest get view position %d", new Object[]{Integer.valueOf(i)});
        if (view == null) {
            bVar = new b(this);
            view = View.inflate(this.context, R.i.dqc, null);
            bVar.nou = (TextView) view.findViewById(R.h.cFx);
            bVar.pBp = (ViewGroup) view.findViewById(R.h.cFt);
            bVar.jpW = (TextView) view.findViewById(R.h.cFy);
            bVar.pBl = (TextView) view.findViewById(R.h.cFv);
            bVar.pBm = (ImageView) view.findViewById(R.h.cFw);
            bVar.onx = (TextView) view.findViewById(R.h.cFu);
            bVar.pBn = view.findViewById(R.h.cSz);
            bVar.pBo = (ViewGroup) view.findViewById(R.h.cSq);
            bVar.pBq = (CustomFitTextView) view.findViewById(R.h.cSt);
            bVar.pBr = (LinearLayout) view.findViewById(R.h.cbk);
            bVar.mvE = (ProgressBar) view.findViewById(R.h.crE);
            bVar.pBk = view.findViewById(R.h.ccD);
            bVar.pBs = new ArrayList();
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        for (a aVar : bVar.pBs) {
            bVar.pBp.removeView(aVar.pBg);
        }
        bVar.pBs.clear();
        List b = g.bmp().b(vj(i).longValue(), 20);
        if (b.size() > 0) {
            int size = b.size();
            bf bfVar = (bf) b.get(0);
            bVar.jpW.setText(bfVar.getTitle());
            bVar.onx.setText(bfVar.HM());
            bVar.nou.setText(n.c(this.context, bfVar.time, false));
            bVar.pBl.setText(n.ag(this.context.getString(R.l.eiw), bfVar.hhh));
            if (ReaderAppUI.h(this.pAY) != null) {
                bVar.nou.setTextColor(ReaderAppUI.h(this.pAY).vjt);
                if (ReaderAppUI.h(this.pAY).vju) {
                    bVar.nou.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.h(this.pAY).vjv);
                } else {
                    bVar.nou.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (ReaderAppUI.h(this.pAY).vjw) {
                    bVar.nou.setBackgroundResource(R.g.bAO);
                    bVar.nou.setPadding(this.pBd, this.pBc, this.pBd, this.pBc);
                } else {
                    bVar.nou.setBackgroundColor(0);
                }
            }
            boolean z = true;
            bVar.mvE.setVisibility(8);
            bVar.pBk.setVisibility(8);
            if (bfVar.HG()) {
                bVar.pBq.b(bfVar.getTitle(), 4, true, R.g.bFc);
            } else {
                bVar.pBq.b(bfVar.getTitle(), 4, false, -1);
            }
            if (bh.ov(bfVar.HL())) {
                bVar.pBm.setVisibility(8);
                z = false;
            } else {
                bVar.pBm.setVisibility(0);
                bVar.pBm.setImageBitmap(j.a(new t(bfVar.HL(), bfVar.type, "@T", this.maM)));
            }
            bVar.pBn.setOnClickListener(this.pAY.a(bfVar, ReaderAppUI.a(this.pAY), 0));
            if (size > 1) {
                a(bVar, false, z);
                for (i2 = 1; i2 < size - 1; i2++) {
                    a(bVar, b, R.i.dqj, i2);
                }
                a(bVar, b, R.i.dqi, size - 1);
            } else {
                a(bVar, true, !z);
            }
        }
        bVar.pBn.setTag(Integer.valueOf(i));
        bVar.pBn.setTag(R.h.cFJ, Integer.valueOf(0));
        ReaderAppUI.i(this.pAY).c(bVar.pBn, ReaderAppUI.a(this.pAY, b.size() == 1), ReaderAppUI.g(this.pAY));
        int i3 = 1;
        for (a aVar2 : bVar.pBs) {
            aVar2.pBg.setTag(Integer.valueOf(i));
            ReaderAppUI.i(this.pAY).c(aVar2.pBg, ReaderAppUI.a(this.pAY, b.size() == 1), ReaderAppUI.g(this.pAY));
            i2 = i3 + 1;
            aVar2.pBg.setTag(R.h.cFJ, Integer.valueOf(i3));
            i3 = i2;
        }
        return view;
    }

    private void a(b bVar, List<bf> list, int i, int i2) {
        a aVar = new a(this);
        aVar.pBg = View.inflate(this.context, i, null);
        aVar.jpW = (TextView) aVar.pBg.findViewById(R.h.title);
        aVar.pBi = (ImageView) aVar.pBg.findViewById(R.h.bZl);
        aVar.pBj = (ImageView) aVar.pBg.findViewById(R.h.cUx);
        aVar.pBh = aVar.pBg.findViewById(R.h.bZm);
        aVar.mvE = (ProgressBar) aVar.pBg.findViewById(R.h.ctB);
        aVar.pBk = aVar.pBg.findViewById(R.h.ctr);
        if (bVar != null) {
            bVar.pBp.addView(aVar.pBg);
            bVar.pBs.add(aVar);
        }
        bf bfVar = (bf) list.get(i2);
        aVar.jpW.setText(bfVar.getTitle());
        aVar.mvE.setVisibility(8);
        aVar.pBk.setVisibility(8);
        if (bfVar.HG()) {
            aVar.jpW.setText(Html.fromHtml(bfVar.getTitle() + "<img src='" + R.g.bFd + "'/>", this.pBb, null));
        } else {
            aVar.jpW.setText(bfVar.getTitle());
        }
        if (bh.ov(bfVar.HL())) {
            aVar.pBh.setVisibility(8);
            aVar.pBj.setVisibility(8);
        } else {
            aVar.pBi.setVisibility(0);
            aVar.pBi.setImageBitmap(j.a(new t(bfVar.HL(), bfVar.type, "@S", this.maM)));
        }
        aVar.pBg.setOnClickListener(this.pAY.a(bfVar, ReaderAppUI.a(this.pAY), i2));
    }

    private void a(b bVar, boolean z, boolean z2) {
        int i;
        int i2 = 0;
        bVar.pBr.setVisibility(z ? 0 : 8);
        if (z) {
            bVar.pBn.setBackgroundResource(R.g.bBm);
            bVar.pBn.setPadding(this.pBe, this.pBe, this.pBe, this.pBe);
        } else {
            bVar.pBn.setBackgroundResource(R.g.bBl);
            bVar.pBn.setPadding(this.pBe, this.pBe, this.pBe, this.pBd);
        }
        TextView textView = bVar.jpW;
        if (z || !(z || z2)) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        textView = bVar.pBl;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        textView = bVar.onx;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        ViewGroup viewGroup = bVar.pBo;
        if (z || !z2) {
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }
}
