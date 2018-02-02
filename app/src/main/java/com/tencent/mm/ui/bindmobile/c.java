package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public final class c extends a {
    private int[] hvS;
    private String ilx;
    private a$a ymo;
    private a$b ymp = new 1(this);

    public final void a(a$a com_tencent_mm_ui_bindmobile_a_a) {
        this.ymo = com_tencent_mm_ui_bindmobile_a_a;
    }

    public c(Context context, a aVar) {
        super(context, new b());
        this.xIi = aVar;
        this.context = context;
        lU(true);
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
        com.tencent.mm.modelfriend.c OD = af.OD();
        String str = this.ilx;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        ar.Hg();
        str = (String) com.tencent.mm.z.c.CU().get(6, null);
        Cursor a = (str == null || str.equals("")) ? OD.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by showhead", null, 0) : OD.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by showhead", null, 0);
        setCursor(a);
        this.hvS = new int[getCount()];
        if (!(this.ymo == null || this.ilx == null)) {
            this.ymo.Ef(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = (b) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.diJ, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.wXW = i;
        aVar.hNv = bVar.Nr();
        aVar.status = bVar.status;
        aVar.jLc.setText(bVar.Nt());
        aVar.ymA.setText(this.context.getString(R.l.ekl) + bVar.Nw());
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ihQ, bVar.getUsername());
        switch (bVar.status) {
            case 0:
                if (bVar.hlv != 2) {
                    aVar.ymt.setClickable(true);
                    aVar.ymt.setBackgroundResource(R.g.bAb);
                    aVar.ihV.setText(R.l.ekh);
                    aVar.ihV.setTextColor(this.context.getResources().getColor(R.e.white));
                    break;
                }
                aVar.ymt.setClickable(false);
                aVar.ymt.setBackgroundDrawable(null);
                aVar.ihV.setText(R.l.eki);
                aVar.ihV.setTextColor(this.context.getResources().getColor(R.e.btc));
                break;
            case 1:
            case 2:
                ar.Hg();
                if (!com.tencent.mm.z.c.EY().WK(bVar.getUsername()) && !q.FS().equals(bVar.getUsername())) {
                    if (bVar.hlv != 2) {
                        aVar.ymt.setClickable(true);
                        aVar.ymt.setBackgroundResource(R.g.bAb);
                        aVar.ihV.setText(R.l.ekf);
                        aVar.ihV.setTextColor(this.context.getResources().getColor(R.e.white));
                        break;
                    }
                    aVar.ymt.setClickable(false);
                    aVar.ymt.setBackgroundDrawable(null);
                    aVar.ihV.setText(R.l.ekk);
                    aVar.ihV.setTextColor(this.context.getResources().getColor(R.e.btc));
                    break;
                }
                aVar.ymt.setClickable(false);
                aVar.ymt.setBackgroundDrawable(null);
                aVar.ihV.setText(R.l.ekg);
                aVar.ihV.setTextColor(this.context.getResources().getColor(R.e.btc));
                break;
                break;
        }
        switch (bVar.hlv) {
            case 0:
            case 2:
                aVar.ihV.setVisibility(0);
                aVar.ptW.setVisibility(4);
                break;
            case 1:
                aVar.ihV.setVisibility(4);
                aVar.ptW.setVisibility(0);
                break;
        }
        b bVar2 = (b) getItem(i - 1);
        int i2 = bVar2 == null ? -1 : bVar2.hvr;
        if (i == 0) {
            CharSequence a = a(bVar);
            if (bh.ov(a)) {
                x.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[]{bVar.getUsername(), Integer.valueOf(i)});
                aVar.ymz.setVisibility(8);
            } else {
                aVar.ymz.setVisibility(0);
                aVar.ymz.setText(a);
                aVar.ymz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (bVar.hvr != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence a2 = a(bVar);
            if (bh.ov(a2) || !r1) {
                x.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[]{bVar.getUsername(), Integer.valueOf(i)});
                aVar.ymz.setVisibility(8);
            } else {
                aVar.ymz.setVisibility(0);
                aVar.ymz.setText(a2);
                aVar.ymz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static b a(b bVar, Cursor cursor) {
        if (bVar == null) {
            bVar = new b();
        }
        bVar.b(cursor);
        return bVar;
    }

    private static String a(b bVar) {
        if (bVar.hvr == 123) {
            return "#";
        }
        return String.valueOf((char) bVar.hvr);
    }
}
