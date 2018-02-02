package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Date;
import java.util.List;

public final class a extends android.support.v7.widget.RecyclerView.a {
    public List<c> jNq = null;
    private String jRw;
    private c lcT = null;
    Context mContext;
    boolean vnK = false;
    private boolean vzn = true;
    long yyg;
    public boolean yyh;
    public b yyi;
    public boolean yyj = false;

    public a(Context context, List<c> list, String str) {
        this.jNq = list;
        this.jRw = str;
        ar.Hg();
        this.vzn = com.tencent.mm.z.c.isSDCardAvailable();
        this.mContext = context;
        ak(context, 4);
    }

    public a(Context context, List<c> list, String str, long j) {
        this.jNq = list;
        this.yyg = j;
        this.jRw = str;
        ar.Hg();
        this.vzn = com.tencent.mm.z.c.isSDCardAvailable();
        this.vnK = true;
        this.mContext = context;
        ak(context, 4);
    }

    private void ak(Context context, int i) {
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDF = 1;
        aVar.hEa = true;
        aVar.hDH = com.tencent.mm.bv.a.eA(context) / 4;
        aVar.hDG = com.tencent.mm.bv.a.eA(context) / 4;
        aVar.hDT = R.e.btx;
        this.lcT = aVar.PK();
    }

    public final int getItemViewType(int i) {
        return FC(i).type;
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.djp, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dlD, viewGroup, false));
    }

    public final void a(t tVar, int i, List list) {
        if (list == null || list.size() <= 0 || !(tVar instanceof d)) {
            super.a(tVar, i, list);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((d) tVar).mSc.setChecked(false);
            ((d) tVar).mSc.setVisibility(0);
            ((d) tVar).mSd.setVisibility(0);
        } else {
            ((d) tVar).mSc.setChecked(false);
            ((d) tVar).mSc.setVisibility(8);
            ((d) tVar).mSd.setVisibility(8);
        }
    }

    public final void a(t tVar, int i) {
        if (this.vzn) {
            c FC = FC(i);
            if (tVar.VX != Integer.MAX_VALUE) {
                ((d) tVar).qqc.setTag(Integer.valueOf(i));
                ((d) tVar).mSd.setTag(Integer.valueOf(i));
                o.PA().a(FC.imagePath, ((d) tVar).qqc, this.lcT);
                if (FC.oqy) {
                    ((d) tVar).yyo.setVisibility(0);
                    ((d) tVar).yyp.setVisibility(0);
                    ((d) tVar).yyp.setText(bh.az(FC.yyl.yym, ""));
                } else {
                    ((d) tVar).yyp.setVisibility(8);
                    ((d) tVar).yyo.setVisibility(8);
                }
                if (this.yyj) {
                    ((d) tVar).mSd.setVisibility(0);
                    ((d) tVar).mSc.setVisibility(0);
                    if (com.tencent.mm.ui.chatting.gallery.g.a.cuF().bo(FC.fEJ)) {
                        ((d) tVar).yyq.setVisibility(0);
                        ((d) tVar).mSc.setChecked(true);
                        return;
                    }
                    ((d) tVar).yyq.setVisibility(8);
                    ((d) tVar).mSc.setChecked(false);
                    return;
                }
                ((d) tVar).mSd.setVisibility(8);
                ((d) tVar).mSc.setVisibility(8);
                return;
            } else if (i == getItemCount() - 1 || gc(FC(i + 1).hOG) != gc(FC.hOG)) {
                ((a) tVar).ihT.setVisibility(8);
                return;
            } else {
                ((a) tVar).ihT.setVisibility(0);
                ((a) tVar).ihT.setText(gb(FC.hOG));
                if (this.yyh) {
                    ((a) tVar).lAk.setVisibility(0);
                    return;
                } else {
                    ((a) tVar).lAk.setVisibility(8);
                    return;
                }
            }
        }
        x.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[]{Boolean.valueOf(this.vzn)});
    }

    public final String gb(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.cxk().a(new Date(j), this.mContext);
    }

    private static long gc(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.cxk().b(new Date(j));
    }

    public final int getItemCount() {
        return this.jNq.size();
    }

    public final c FC(int i) {
        return (c) this.jNq.get(i);
    }
}
