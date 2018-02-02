package com.tencent.mm.plugin.readerapp.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.bf;
import junit.framework.Assert;

class ReaderItemListView$a extends BaseAdapter {
    final /* synthetic */ ReaderItemListView pBz;

    ReaderItemListView$a(ReaderItemListView readerItemListView) {
        this.pBz = readerItemListView;
    }

    public final int getCount() {
        return ReaderItemListView.a(this.pBz).size();
    }

    public final Object getItem(int i) {
        return ReaderItemListView.a(this.pBz).get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        if (((bf) ReaderItemListView.a(this.pBz).get(i)).type == 20) {
            if (i != 0) {
                return 1;
            }
            String HL = ((bf) ReaderItemListView.a(this.pBz).get(i)).HL();
            String HM = ((bf) ReaderItemListView.a(this.pBz).get(i)).HM();
            if (bh.ov(HL)) {
                if (bh.ov(HM)) {
                    return 1;
                }
                return 2;
            } else if (bh.ov(HM)) {
                return 3;
            } else {
                return 0;
            }
        } else if (i == 0) {
            if (getCount() == 1) {
                return 8;
            }
            return 6;
        } else if (i == getCount() - 1) {
            return 7;
        } else {
            return 5;
        }
    }

    public final int getViewTypeCount() {
        return 9;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z;
        Bitmap a;
        boolean z2 = true;
        ViewGroup viewGroup2 = null;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            switch (itemViewType) {
                case 0:
                case 3:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dpY, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.pBi = (ImageView) view.findViewById(R.h.cFA);
                    aVar.lAk = (ProgressBar) view.findViewById(R.h.cFB);
                    view.setTag(aVar);
                    break;
                case 1:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dqb, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFI);
                    view.setTag(aVar);
                    break;
                case 2:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dpZ, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.pBC = (TextView) view.findViewById(R.h.cFC);
                    view.setTag(aVar);
                    break;
                case 4:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dqe, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.pBi = (ImageView) view.findViewById(R.h.cFA);
                    aVar.lAk = (ProgressBar) view.findViewById(R.h.cFB);
                    aVar.jMw = (TextView) view.findViewById(R.h.cFF);
                    aVar.jMv = (ImageView) view.findViewById(R.h.cFD);
                    aVar.pBD = (ProgressBar) view.findViewById(R.h.cFE);
                    aVar.pBn = view.findViewById(R.h.cFz);
                    aVar.pBn.setBackgroundResource(R.g.bBl);
                    view.setTag(aVar);
                    break;
                case 5:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dqf, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.jMw = (TextView) view.findViewById(R.h.cFF);
                    aVar.jMv = (ImageView) view.findViewById(R.h.cFD);
                    aVar.pBD = (ProgressBar) view.findViewById(R.h.cFE);
                    aVar.pBn = view.findViewById(R.h.cFz);
                    aVar.pBn.setBackgroundResource(R.g.bBk);
                    view.setTag(aVar);
                    break;
                case 6:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dqh, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.jMw = (TextView) view.findViewById(R.h.cFF);
                    aVar.jMv = (ImageView) view.findViewById(R.h.cFD);
                    aVar.pBD = (ProgressBar) view.findViewById(R.h.cFE);
                    aVar.pBn = view.findViewById(R.h.cFz);
                    aVar.pBn.setBackgroundResource(R.g.bBl);
                    view.setTag(aVar);
                    break;
                case 7:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dqg, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.jMw = (TextView) view.findViewById(R.h.cFF);
                    aVar.jMv = (ImageView) view.findViewById(R.h.cFD);
                    aVar.pBD = (ProgressBar) view.findViewById(R.h.cFE);
                    aVar.pBn = view.findViewById(R.h.cFz);
                    aVar.pBn.setBackgroundResource(R.g.bBj);
                    view.setTag(aVar);
                    Object obj = aVar;
                    break;
                case 8:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.pBz).inflate(R.i.dqf, null);
                    aVar.jpW = (TextView) view.findViewById(R.h.cFG);
                    aVar.jMw = (TextView) view.findViewById(R.h.cFF);
                    aVar.jMv = (ImageView) view.findViewById(R.h.cFD);
                    aVar.pBD = (ProgressBar) view.findViewById(R.h.cFE);
                    aVar.pBn = view.findViewById(R.h.cFz);
                    aVar.pBn.setBackgroundResource(R.g.bBm);
                    view.setTag(aVar);
                    break;
            }
            aVar = viewGroup2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (aVar.jpW == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        aVar.jpW.setText(((bf) ReaderItemListView.a(this.pBz).get(i)).getTitle().trim());
        if (aVar.pBC != null) {
            aVar.pBC.setText(((bf) ReaderItemListView.a(this.pBz).get(i)).HM().trim());
        }
        if (aVar.jMw != null) {
            aVar.jMw.setText(((bf) ReaderItemListView.a(this.pBz).get(i)).HJ().trim() + this.pBz.getContext().getString(R.l.eBX));
        }
        if (aVar.jMv != null) {
            a = j.a(new t(((bf) ReaderItemListView.a(this.pBz).get(i)).HK(), ((bf) ReaderItemListView.a(this.pBz).get(i)).type, "@S", false));
            if (a != null) {
                aVar.jMv.setImageBitmap(a);
                aVar.jMv.setVisibility(0);
                aVar.pBD.setVisibility(8);
            } else {
                aVar.pBD.setVisibility(0);
                aVar.jMv.setVisibility(8);
            }
        }
        if (aVar.pBi != null) {
            a = j.a(new t(((bf) ReaderItemListView.a(this.pBz).get(i)).HL(), ((bf) ReaderItemListView.a(this.pBz).get(i)).type, "@T", false));
            if (a != null) {
                aVar.pBi.setImageBitmap(a);
                aVar.pBi.setVisibility(0);
                aVar.lAk.setVisibility(8);
            } else {
                aVar.lAk.setVisibility(0);
                aVar.pBi.setVisibility(8);
            }
        }
        if (!(aVar.pBn == null || ReaderItemListView.c(this.pBz) == null)) {
            aVar.pBn.setTag(Integer.valueOf(ReaderItemListView.d(this.pBz)));
            aVar.pBn.setOnLongClickListener(new 1(this));
            aVar.pBn.setOnClickListener(new 2(this, i));
        }
        return view;
    }
}
