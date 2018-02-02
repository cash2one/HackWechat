package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.ui.base.p.d;

class ReaderAppUI$b extends a<Long> {
    private Context context;
    private int hKb = this.kUH;
    private int kUH = 3;
    final /* synthetic */ ReaderAppUI pAY;
    private int pBc;
    private int pBd;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public ReaderAppUI$b(ReaderAppUI readerAppUI, Context context, Long l) {
        this.pAY = readerAppUI;
        super(context, l);
        this.context = context;
        this.pBc = context.getResources().getDimensionPixelSize(R.f.buo);
        this.pBd = context.getResources().getDimensionPixelSize(R.f.bvS);
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
        this.hKb = g.bmp().gV(ReaderAppUI.a(this.pAY));
        setCursor(g.bmp().aY(this.kUH, ReaderAppUI.a(this.pAY)));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, R.i.dqd, null);
            aVar.pBt = (ReaderItemListView) view.findViewById(R.h.cFL);
            aVar.nou = (TextView) view.findViewById(R.h.cFx);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nou.setText(n.c(this.context, ((Long) getItem(i)).longValue(), false));
        ReaderItemListView readerItemListView = aVar.pBt;
        long longValue = ((Long) getItem(i)).longValue();
        OnCreateContextMenuListener a = ReaderAppUI.a(this.pAY, false);
        d g = ReaderAppUI.g(this.pAY);
        readerItemListView.position = i;
        readerItemListView.pBx = a;
        readerItemListView.onK = g;
        readerItemListView.pBv = g.bmp().b(longValue, readerItemListView.type);
        readerItemListView.pBw.notifyDataSetChanged();
        if (ReaderAppUI.h(this.pAY) != null) {
            aVar.nou.setTextColor(ReaderAppUI.h(this.pAY).vjt);
            if (ReaderAppUI.h(this.pAY).vju) {
                aVar.nou.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.h(this.pAY).vjv);
            } else {
                aVar.nou.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (ReaderAppUI.h(this.pAY).vjw) {
                aVar.nou.setBackgroundResource(R.g.bAO);
                aVar.nou.setPadding(this.pBd, this.pBc, this.pBd, this.pBc);
            } else {
                aVar.nou.setBackgroundColor(0);
            }
        }
        return view;
    }
}
