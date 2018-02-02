package com.tencent.mm.ui.bindgooglecontact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.o;

public final class a extends o<com.tencent.mm.modelfriend.o> {
    private Context mContext;
    private String mFilter;
    private LayoutInflater mLayoutInflater = LayoutInflater.from(this.mContext);
    a ykK;
    private String ykr;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.modelfriend.o) obj;
        if (obj == null) {
            obj = new com.tencent.mm.modelfriend.o();
        }
        obj.b(cursor);
        return obj;
    }

    public a(Context context, String str) {
        super(context, new com.tencent.mm.modelfriend.o());
        this.ykr = str;
        this.mContext = context;
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        p OL = af.OL();
        String str = this.mFilter;
        String str2 = this.ykr;
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        } else {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            stringBuilder.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        }
        stringBuilder.append(" GROUP BY googleid,contecttype");
        stringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        setCursor(OL.gJP.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    public final void CN(String str) {
        this.mFilter = bh.ot(str);
        aUn();
        Xy();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = this.mLayoutInflater.inflate(R.i.dlt, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.modelfriend.o oVar = (com.tencent.mm.modelfriend.o) getItem(i);
        if (oVar != null) {
            bVar.position = i;
            bVar.pjU = oVar.field_googlegmail;
            Bitmap a;
            switch (oVar.field_status) {
                case 0:
                case 2:
                    if (oVar.field_small_url != null) {
                        a = b.a(oVar.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        bVar.ihQ.setImageBitmap(a);
                        break;
                    }
                    bVar.ihQ.setImageDrawable(com.tencent.mm.bv.a.b(this.mContext, R.k.bBB));
                    break;
                case 1:
                    a = b.iO(oVar.field_googleid);
                    if (a != null) {
                        bVar.ihQ.setImageBitmap(a);
                        break;
                    }
                    bVar.ihQ.setImageDrawable(com.tencent.mm.bv.a.b(this.mContext, R.k.bBB));
                    break;
            }
            if (TextUtils.isEmpty(oVar.field_googlename)) {
                bVar.inw.setText(bh.VS(oVar.field_googlegmail));
            } else {
                bVar.inw.setText(oVar.field_googlename);
            }
            switch (oVar.field_status) {
                case 0:
                    bVar.ykM.setClickable(true);
                    bVar.ykM.setBackgroundResource(R.g.bAb);
                    bVar.ihV.setText(R.l.eni);
                    bVar.ihV.setTextColor(this.mContext.getResources().getColor(R.e.white));
                    break;
                case 1:
                    bVar.ykM.setClickable(true);
                    bVar.ykM.setBackgroundResource(R.g.bAc);
                    bVar.ihV.setText(R.l.enq);
                    bVar.ihV.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                    break;
                case 2:
                    bVar.ykM.setClickable(false);
                    bVar.ykM.setBackgroundDrawable(null);
                    bVar.ihV.setText(R.l.enk);
                    bVar.ihV.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                    break;
            }
            switch (oVar.field_googlecgistatus) {
                case 0:
                    bVar.ihV.setVisibility(4);
                    bVar.ykN.setVisibility(0);
                    break;
                case 1:
                    bVar.ykM.setClickable(false);
                    bVar.ykM.setBackgroundDrawable(null);
                    bVar.ihV.setVisibility(0);
                    bVar.ykN.setVisibility(8);
                    bVar.ihV.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                    switch (oVar.field_status) {
                        case 0:
                            bVar.ihV.setText(R.l.enj);
                            break;
                        case 1:
                            bVar.ihV.setText(R.l.enr);
                            break;
                        default:
                            break;
                    }
                case 2:
                    bVar.ihV.setVisibility(0);
                    bVar.ykN.setVisibility(8);
                    switch (oVar.field_status) {
                        case 0:
                            bVar.ihV.setText(R.l.eni);
                            bVar.ihV.setTextColor(this.mContext.getResources().getColor(R.e.white));
                            break;
                        case 1:
                            bVar.ihV.setText(R.l.enq);
                            bVar.ihV.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                            break;
                        default:
                            break;
                    }
            }
            bVar.ykL.setText(oVar.field_googlegmail);
        }
        return view;
    }
}
