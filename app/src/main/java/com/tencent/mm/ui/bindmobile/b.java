package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindmobile.a.a;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public final class b extends a {
    private int[] hvS;
    private String ilx;
    private a ymo;
    private com.tencent.mm.ui.bindmobile.a.b ymp = new 1(this);

    public final void a(a aVar) {
        this.ymo = aVar;
    }

    public b(Context context, o$a com_tencent_mm_ui_o_a) {
        super(context, new com.tencent.mm.modelfriend.b());
        this.xIi = com_tencent_mm_ui_o_a;
        this.context = context;
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
        c OD = af.OD();
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
        Cursor a = (str == null || str.equals("")) ? OD.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0) : OD.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
        setCursor(a);
        this.hvS = new int[getCount()];
        if (!(this.ymo == null || this.ilx == null)) {
            this.ymo.Ef(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.dol, null);
            a aVar2 = new a(this, view);
            aVar2.hvZ = (TextView) view.findViewById(R.h.cwD);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.wXW = i;
        aVar.fqR = bVar.Nr();
        aVar.status = bVar.status;
        aVar.hvZ.setText(bVar.Nt());
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
                x.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[]{bVar.getUsername()});
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
                aVar.ymu.setVisibility(4);
                break;
            case 1:
                aVar.ihV.setVisibility(4);
                aVar.ymu.setVisibility(0);
                break;
        }
        return view;
    }

    private static com.tencent.mm.modelfriend.b a(com.tencent.mm.modelfriend.b bVar, Cursor cursor) {
        if (bVar == null) {
            bVar = new com.tencent.mm.modelfriend.b();
        }
        bVar.b(cursor);
        return bVar;
    }
}
