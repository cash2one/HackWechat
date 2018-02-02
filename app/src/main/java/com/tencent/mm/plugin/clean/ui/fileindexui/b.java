package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int lgn = 0;
    private boolean anv;
    boolean isStop = false;
    ArrayList<i> jMd;
    OnItemClickListener kGC = new 4(this);
    HashSet<Integer> kmb;
    private CleanChattingDetailUI lgm;
    c lgo = new 3(this);
    private af lgp = new af(this) {
        final /* synthetic */ b lgr;

        {
            this.lgr = r1;
        }

        public final void handleMessage(Message message) {
            if (!this.lgr.anv) {
                this.lgr.notifyDataSetChanged();
            }
        }
    };
    OnScrollListener lgq = new OnScrollListener(this) {
        final /* synthetic */ b lgr;

        {
            this.lgr = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            o.PA().bp(i);
            if (i != 2) {
                this.lgr.anv = false;
                this.lgr.lgp.removeCallbacksAndMessages(null);
                this.lgr.lgp.sendEmptyMessageDelayed(0, 200);
                return;
            }
            this.lgr.anv = true;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private String username;

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
            if (((i) bVar.jMd.get(i)).axZ() == r4) {
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

    static /* synthetic */ void c(b bVar) {
        if (!bVar.isStop) {
            ag.y(new 1(bVar));
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ol(i);
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, String str) {
        this.lgm = cleanChattingDetailUI;
        this.kmb = new HashSet();
        this.jMd = new ArrayList();
        this.username = str;
    }

    public final int getCount() {
        return this.jMd.size();
    }

    public final i ol(int i) {
        return (i) this.jMd.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        c cVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.lgm.getLayoutInflater().inflate(R.i.det, viewGroup, false);
            c cVar2 = new c(this);
            cVar2.lgv = (MMImageView) view.findViewById(R.h.bYN);
            cVar2.iis = (CheckBox) view.findViewById(R.h.cKI);
            cVar2.lgx = view.findViewById(R.h.cKK);
            cVar2.lgy = view.findViewById(R.h.cLj);
            cVar2.lgw = (ImageView) view.findViewById(R.h.cCG);
            cVar2.lgz = (TextView) view.findViewById(R.h.cyB);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        i ol = ol(i);
        cVar.lgv.setTag(ol.filePath);
        cVar.lgx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b lgr;

            public final void onClick(View view) {
                b.a(this.lgr, i);
                this.lgr.notifyDataSetChanged();
            }
        });
        if (this.kmb.contains(Integer.valueOf(i))) {
            cVar.iis.setChecked(true);
            cVar.lgy.setVisibility(0);
        } else {
            cVar.iis.setChecked(false);
            cVar.lgy.setVisibility(8);
        }
        if (ol.type == 3) {
            cVar.lgw.setVisibility(0);
        } else {
            cVar.lgw.setVisibility(8);
        }
        if (ol.type == 4) {
            cVar.lgv.setImageResource(r.Ry(com.tencent.mm.a.e.bQ(ol.filePath)));
            cVar.lgz.setText(new File(ol.filePath).getName());
            cVar.lgz.setVisibility(0);
        } else {
            if (lgn == 0) {
                lgn = view.getMeasuredWidth();
            }
            a aVar = new a();
            aVar.hDF = 1;
            aVar.hDB = false;
            aVar.hDH = lgn;
            aVar.hDG = lgn;
            int i2 = ol.type;
            aVar.hDC = ol.fvC;
            o.PA().a(ol.fvC, cVar.lgv, aVar.PK());
            cVar.lgz.setVisibility(8);
        }
        x.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return view;
    }

    public final long om(int i) {
        return ((i) this.jMd.get(i)).axZ();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.lgm.getLayoutInflater().inflate(R.i.deu, viewGroup, false);
            aVar = new a(this);
            aVar.lgs = (TextView) view.findViewById(R.h.cox);
            aVar.lgt = (TextView) view.findViewById(R.h.cov);
            aVar.lgu = (CheckBox) view.findViewById(R.h.cou);
            view.setTag(aVar);
        } else {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        i ol = ol(i);
        aVar.position = i;
        aVar.lgs.setText(n.ag(this.lgm.getString(R.l.eju), ol.hVF / 1000));
        long axZ = ol.axZ();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.jMd.size(); i2++) {
            if (((i) this.jMd.get(i2)).axZ() == axZ) {
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
        this.lgm.on(this.kmb.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.lgm;
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
            j = ((i) this.jMd.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.lgm;
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
