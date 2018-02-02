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
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class f extends d {
    private final int JI;
    private final MMActivity fmM;
    private String ilx;
    private com.tencent.mm.ui.friend.d.a zcX;
    boolean zdf = false;
    private a zdg = new 1(this);

    interface a {
        void i(int i, String str, int i2);
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ad) obj;
        if (obj == null) {
            obj = new ad();
        }
        obj.b(cursor);
        return obj;
    }

    public f(MMActivity mMActivity, int i) {
        super(mMActivity, new ad());
        this.fmM = mMActivity;
        this.JI = i;
        this.zdf = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        lU(true);
    }

    public final void a(com.tencent.mm.ui.friend.d.a aVar) {
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
            setCursor(af.OI().r(this.JI, this.zdf));
        } else {
            setCursor(af.OI().c(this.JI, this.ilx, this.zdf));
        }
        if (!(this.zcX == null || this.ilx == null)) {
            this.zcX.Ef(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        ad adVar = (ad) getItem(i);
        if (view == null) {
            view = View.inflate(this.fmM, R.i.diJ, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.wXW = i;
        bVar.hNv = adVar.hwR;
        bVar.status = adVar.hwS;
        bVar.jLc.setText(i.b(this.fmM, adVar.getDisplayName(), bVar.jLc.getTextSize()));
        bVar.ymA.setText(i.b(this.fmM, adVar.vP(), bVar.ymA.getTextSize()));
        if (this.zdf) {
            Bitmap aO;
            if (o.bY(bVar.hNv) != 0) {
                aO = b.aO(adVar.hwR);
            } else {
                aO = null;
            }
            if (aO == null) {
                bVar.ihQ.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.bBB));
            } else {
                bVar.ihQ.setImageBitmap(aO);
            }
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ihQ, adVar.getUsername());
        }
        if (!this.zdf) {
            switch (adVar.hwS) {
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
                    bVar.ptW.setVisibility(4);
                    break;
                case 1:
                    bVar.ihV.setVisibility(4);
                    bVar.ptW.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        bVar.ymt.setVisibility(8);
        ad adVar2 = (ad) getItem(i - 1);
        int i2 = adVar2 == null ? -1 : adVar2.hlu;
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = adVar2 != null ? adVar2.toString() : "";
        x.d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = adVar != null ? adVar.toString() : "";
        x.d(str, str2, objArr);
        if (i == 0) {
            CharSequence b = b(adVar);
            if (bh.ov(b)) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{adVar.getUsername(), Integer.valueOf(i)});
                bVar.ymz.setVisibility(8);
            } else {
                bVar.ymz.setVisibility(0);
                bVar.ymz.setText(b);
                bVar.ymz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (adVar.hlu != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence b2 = b(adVar);
            if (bh.ov(b2) || !r1) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{adVar.getUsername(), Integer.valueOf(i)});
                bVar.ymz.setVisibility(8);
            } else {
                bVar.ymz.setVisibility(0);
                bVar.ymz.setText(b2);
                bVar.ymz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static String b(ad adVar) {
        if (adVar.hlu == 123) {
            return "#";
        }
        return String.valueOf((char) adVar.hlu);
    }

    public final void jh(String str) {
    }
}
