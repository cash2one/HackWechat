package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$c;
import com.tencent.mm.ui.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int lgn = 0;
    private boolean anv;
    ArrayList<a> jMd;
    OnItemClickListener kGC = new 3(this);
    HashSet<Integer> kmb;
    GridHeadersGridView$c lgo = new 2(this);
    private af lgp = new 4(this);
    OnScrollListener lgq = new 5(this);
    private CleanChattingDetailUI lhI;

    static /* synthetic */ void a(b bVar, int i) {
        x.i("MicroMsg.CleanChattingDetailAdapter", "select position=%d", new Object[]{Integer.valueOf(i)});
        if (!bVar.kmb.remove(Integer.valueOf(i))) {
            bVar.kmb.add(Integer.valueOf(i));
        }
        bVar.ayz();
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        int i;
        x.i("MicroMsg.CleanChattingDetailAdapter", "select header position=%d | headerId=%d", new Object[]{Integer.valueOf(aVar.position), Long.valueOf(bVar.om(aVar.position))});
        Collection hashSet = new HashSet();
        for (i = 0; i < bVar.jMd.size(); i++) {
            if (((a) bVar.jMd.get(i)).axZ() == r4) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        Iterator it = hashSet.iterator();
        i = 1;
        while (it.hasNext()) {
            i = !bVar.kmb.remove(Integer.valueOf(((Integer) it.next()).intValue())) ? 0 : i;
        }
        if (i == 0) {
            bVar.kmb.addAll(hashSet);
        }
        bVar.ayz();
    }

    public final /* synthetic */ Object getItem(int i) {
        return op(i);
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<a> arrayList) {
        this.lhI = cleanChattingDetailUI;
        this.jMd = arrayList;
        this.kmb = new HashSet();
    }

    public final int getCount() {
        return this.jMd.size();
    }

    public final a op(int i) {
        return (a) this.jMd.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.lhI.getLayoutInflater().inflate(R.i.det, viewGroup, false);
            b bVar2 = new b(this);
            bVar2.lgv = (MMImageView) view.findViewById(R.h.bYN);
            bVar2.iis = (CheckBox) view.findViewById(R.h.cKI);
            bVar2.lgx = view.findViewById(R.h.cKK);
            bVar2.lgy = view.findViewById(R.h.cLj);
            bVar2.lgw = (ImageView) view.findViewById(R.h.cCG);
            bVar2.lgz = (TextView) view.findViewById(R.h.cyB);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        a op = op(i);
        bVar.lgv.setTag(op.filePath);
        bVar.lgx.setOnClickListener(new 1(this, i));
        if (this.kmb.contains(Integer.valueOf(i))) {
            bVar.iis.setChecked(true);
            bVar.lgy.setVisibility(0);
        } else {
            bVar.iis.setChecked(false);
            bVar.lgy.setVisibility(8);
        }
        if (op.type == 3) {
            bVar.lgw.setVisibility(0);
        } else {
            bVar.lgw.setVisibility(8);
        }
        if (op.type == 4) {
            bVar.lgv.setImageResource(r.Ry(com.tencent.mm.a.e.bQ(op.filePath)));
            bVar.lgz.setText(new File(op.filePath).getName());
            bVar.lgz.setVisibility(0);
        } else {
            if (lgn == 0) {
                lgn = view.getMeasuredWidth();
            }
            c$a com_tencent_mm_aq_a_a_c_a = new c$a();
            com_tencent_mm_aq_a_a_c_a.hDF = 1;
            com_tencent_mm_aq_a_a_c_a.hDB = false;
            com_tencent_mm_aq_a_a_c_a.hDH = lgn;
            com_tencent_mm_aq_a_a_c_a.hDG = lgn;
            if (op.type == 1) {
                com_tencent_mm_aq_a_a_c_a.hDC = op.filePath;
                o.PA().a(op.filePath, bVar.lgv, com_tencent_mm_aq_a_a_c_a.PK());
            } else {
                com_tencent_mm_aq_a_a_c_a.hDC = op.fvC;
                o.PA().a(op.fvC, bVar.lgv, com_tencent_mm_aq_a_a_c_a.PK());
            }
            bVar.lgz.setVisibility(8);
        }
        x.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return view;
    }

    public final long om(int i) {
        return ((a) this.jMd.get(i)).axZ();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.lhI.getLayoutInflater().inflate(R.i.deu, viewGroup, false);
            aVar = new a(this);
            aVar.lgs = (TextView) view.findViewById(R.h.cox);
            aVar.lgt = (TextView) view.findViewById(R.h.cov);
            aVar.lgu = (CheckBox) view.findViewById(R.h.cou);
            view.setTag(aVar);
        } else {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        a op = op(i);
        aVar.position = i;
        aVar.lgs.setText(n.ag(this.lhI.getString(R.l.eju), op.hVF / 1000));
        long axZ = op.axZ();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.jMd.size(); i2++) {
            if (((a) this.jMd.get(i2)).axZ() == axZ) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.kmb.contains(Integer.valueOf(((Integer) it.next()).intValue()))) {
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            aVar.lgu.setChecked(true);
        } else {
            aVar.lgu.setChecked(false);
        }
        return view;
    }

    final void ayz() {
        boolean z;
        this.lhI.on(this.kmb.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.lhI;
        if (this.kmb.size() == this.jMd.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.kmj.setChecked(true);
        } else {
            cleanChattingDetailUI.kmj.setChecked(false);
        }
        Iterator it = this.kmb.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((a) this.jMd.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.lhI;
        if (j > 0) {
            cleanChattingDetailUI2.lgC.setText(cleanChattingDetailUI2.getString(R.l.dYs, new Object[]{bh.bx(j)}));
            return;
        }
        cleanChattingDetailUI2.lgC.setText("");
    }

    public final void ayy() {
        this.kmb.clear();
        ayz();
    }
}
