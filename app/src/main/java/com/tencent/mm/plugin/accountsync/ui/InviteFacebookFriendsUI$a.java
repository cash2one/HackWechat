package com.tencent.mm.plugin.accountsync.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.o.a;

public class InviteFacebookFriendsUI$a extends o<h> {
    private int[] hvS;
    String ilx;
    private boolean[] ily;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (h) obj;
        if (obj == null) {
            obj = new h();
        }
        obj.b(cursor);
        return obj;
    }

    public InviteFacebookFriendsUI$a(Context context, a aVar) {
        super(context, new h());
        this.xIi = aVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = (h) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, R.i.dhn, null);
            aVar2.ihQ = (ImageView) view.findViewById(R.h.bYy);
            aVar2.hvZ = (TextView) view.findViewById(R.h.cEt);
            aVar2.ilz = (TextView) view.findViewById(R.h.cqg);
            aVar2.ilA = (CheckBox) view.findViewById(R.h.cqr);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hvZ.setText(i.b(this.context, hVar.NF(), aVar.hvZ.getTextSize()));
        Bitmap iR = b.iR(hVar.fWh);
        if (iR == null) {
            aVar.ihQ.setImageDrawable(com.tencent.mm.bv.a.b(this.context, R.k.bBB));
        } else {
            aVar.ihQ.setImageBitmap(iR);
        }
        aVar.ilA.setChecked(this.ily[i]);
        if (af.OH().la(Long.toString(hVar.fWh))) {
            aVar.ilz.setVisibility(0);
        } else {
            aVar.ilz.setVisibility(8);
        }
        return view;
    }

    public final long[] Xx() {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (boolean z : this.ily) {
            if (z) {
                i3++;
            }
        }
        long[] jArr = new long[i3];
        int i4 = 0;
        while (i4 < getCount()) {
            if (this.ily[i4]) {
                i = i2 + 1;
                jArr[i2] = ((h) getItem(i4)).fWh;
                i3 = i;
            } else {
                i3 = i2;
            }
            i4++;
            i2 = i3;
        }
        return jArr;
    }

    public final void jf(int i) {
        if (i >= 0 && i < this.ily.length) {
            this.ily[i] = !this.ily[i];
            super.notifyDataSetChanged();
        }
    }

    public final void Xy() {
        com.tencent.mm.modelfriend.i OE = af.OE();
        String str = this.ilx;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where facebookfriend.status = 102 ");
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(OE.hhp.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
        this.hvS = new int[getCount()];
        this.ily = new boolean[getCount()];
        super.notifyDataSetChanged();
    }

    protected final void Xz() {
        Xy();
    }
}
