package com.tencent.mm.ui.friend;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.b;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.friend.d.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class e extends d {
    private final int JI;
    private final MMActivity fmM;
    private String ilx;
    private final a zcV;
    private final c zcW;
    private a zcX;
    boolean zcY = false;
    private a zcZ = new 1(this);

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ad) obj;
        if (obj == null) {
            obj = new ad();
        }
        obj.b(cursor);
        return obj;
    }

    public e(MMActivity mMActivity, int i) {
        super(mMActivity, new ad());
        this.fmM = mMActivity;
        this.JI = i;
        this.zcY = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.zcV = new a(mMActivity, new 2(this));
        this.zcW = new c(mMActivity, new 3(this));
    }

    public final void a(a aVar) {
        this.zcX = aVar;
    }

    public final void CN(String str) {
        this.ilx = bh.ot(str.trim());
        aUn();
        Xy();
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        aUn();
        if (bh.ov(this.ilx)) {
            setCursor(af.OI().r(this.JI, this.zcY));
        } else {
            setCursor(af.OI().c(this.JI, this.ilx, this.zcY));
        }
        if (!(this.zcX == null || this.ilx == null)) {
            this.zcX.Ef(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap aO;
        ad adVar = (ad) getItem(i);
        if (view == null) {
            view = View.inflate(this.fmM, R.i.dpP, null);
            bVar = new b(this, view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.wXW = i;
        bVar.zdc = adVar.hwR;
        bVar.status = adVar.hwS;
        bVar.hvZ.setText(i.b(this.fmM, adVar.getDisplayName(), bVar.hvZ.getTextSize()));
        if (o.bY(adVar.hwR) != 0) {
            aO = b.aO(adVar.hwR);
        } else {
            aO = null;
        }
        if (aO == null) {
            bVar.ihQ.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.bBB));
        } else {
            bVar.ihQ.setImageBitmap(aO);
        }
        if (!this.zcY) {
            switch (adVar.hwS) {
                case 0:
                    if (adVar.hlv != 2) {
                        bVar.ymt.setClickable(true);
                        bVar.ymt.setBackgroundResource(R.g.bAb);
                        bVar.ihV.setText(R.l.ekh);
                        bVar.ihV.setTextColor(this.fmM.getResources().getColor(R.e.white));
                        break;
                    }
                    bVar.ymt.setClickable(false);
                    bVar.ymt.setBackgroundDrawable(null);
                    bVar.ihV.setText(R.l.eki);
                    bVar.ihV.setTextColor(this.fmM.getResources().getColor(R.e.btc));
                    break;
                case 1:
                case 2:
                    ar.Hg();
                    if (!c.EY().WK(adVar.getUsername()) && !q.FS().equals(adVar.getUsername())) {
                        if (adVar.hlv != 2) {
                            bVar.ymt.setClickable(true);
                            bVar.ymt.setBackgroundResource(R.g.bAb);
                            bVar.ihV.setText(R.l.ekf);
                            bVar.ihV.setTextColor(this.fmM.getResources().getColor(R.e.white));
                            break;
                        }
                        bVar.ymt.setClickable(false);
                        bVar.ymt.setBackgroundDrawable(null);
                        bVar.ihV.setText(R.l.ekk);
                        bVar.ihV.setTextColor(this.fmM.getResources().getColor(R.e.btc));
                        break;
                    }
                    bVar.ymt.setClickable(false);
                    bVar.ymt.setBackgroundDrawable(null);
                    bVar.ihV.setText(R.l.ekg);
                    bVar.ihV.setTextColor(this.fmM.getResources().getColor(R.e.btc));
                    break;
                    break;
            }
            switch (adVar.hlv) {
                case 0:
                case 2:
                    bVar.ihV.setVisibility(0);
                    bVar.ymu.setVisibility(4);
                    break;
                case 1:
                    bVar.ihV.setVisibility(4);
                    bVar.ymu.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        bVar.ymt.setVisibility(8);
        return view;
    }

    public final void jh(String str) {
        notifyDataSetChanged();
    }
}
