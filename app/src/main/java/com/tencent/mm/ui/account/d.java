package com.tencent.mm.ui.account;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

@Deprecated
final class d extends o<h> {
    private int[] hvS;
    private String ilx;
    a xNT;

    public interface a {
        void Ef(int i);
    }

    static class b {
        TextView hvZ;
        TextView hwa;
        ImageView ihQ;
        TextView xNU;
        TextView xNV;
        ImageView xNW;

        b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (h) obj;
        if (obj == null) {
            obj = new h();
        }
        obj.b(cursor);
        return obj;
    }

    public d(Context context, o$a com_tencent_mm_ui_o_a) {
        super(context, new h());
        this.xIi = com_tencent_mm_ui_o_a;
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        i OE = af.OE();
        String str = this.ilx;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(OE.hhp.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
        this.hvS = new int[getCount()];
        if (!(this.xNT == null || this.ilx == null)) {
            this.xNT.Ef(getCursor().getCount());
        }
        super.notifyDataSetChanged();
    }

    public final void CN(String str) {
        this.ilx = bh.ot(str.trim());
        aUn();
        Xy();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        h hVar = (h) getItem(i);
        if (view == null) {
            b bVar2 = new b();
            view = View.inflate(this.context, R.i.dhm, null);
            bVar2.ihQ = (ImageView) view.findViewById(R.h.bYy);
            bVar2.hvZ = (TextView) view.findViewById(R.h.cEt);
            bVar2.hwa = (TextView) view.findViewById(R.h.cEo);
            bVar2.xNU = (TextView) view.findViewById(R.h.cEp);
            bVar2.xNV = (TextView) view.findViewById(R.h.cEr);
            bVar2.xNW = (ImageView) view.findViewById(R.h.cEw);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.hvZ.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.context, hVar.NF(), bVar.hvZ.getTextSize()));
        bVar.xNV.setVisibility(8);
        bVar.xNW.setVisibility(0);
        switch (this.hvS[i]) {
            case 0:
                if (hVar.status != 102) {
                    ar.Hg();
                    if (!c.EY().WK(hVar.getUsername())) {
                        bVar.hwa.setVisibility(8);
                        bVar.xNU.setVisibility(0);
                        break;
                    }
                }
                if (hVar.status != 102) {
                    bVar.hwa.setVisibility(0);
                    bVar.hwa.setText(R.l.ekg);
                    bVar.hwa.setTextColor(this.context.getResources().getColor(R.e.bri));
                    bVar.xNU.setVisibility(8);
                    break;
                }
                bVar.hwa.setVisibility(8);
                bVar.xNU.setVisibility(8);
                bVar.xNW.setVisibility(8);
                break;
            case 2:
                bVar.xNU.setVisibility(8);
                bVar.hwa.setVisibility(0);
                bVar.hwa.setText(R.l.ekj);
                bVar.hwa.setTextColor(this.context.getResources().getColor(R.e.brj));
                break;
        }
        Bitmap iR = com.tencent.mm.ad.b.iR(hVar.fWh);
        if (iR == null) {
            bVar.ihQ.setImageDrawable(com.tencent.mm.bv.a.b(this.context, R.k.bBB));
        } else {
            bVar.ihQ.setImageBitmap(iR);
        }
        return view;
    }
}
