package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.10;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class NormalUserFooterPreference$a$1$1 implements d {
    final /* synthetic */ 1 pkD;

    NormalUserFooterPreference$a$1$1(1 1) {
        this.pkD = 1;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        b bVar = null;
        NormalUserFooterPreference normalUserFooterPreference;
        Intent intent;
        a aVar;
        View inflate;
        TextView textView;
        CheckBox checkBox;
        switch (menuItem.getItemId()) {
            case 1:
                this.pkD.pkC.pkA.hkZ.ca("hide_btn");
                this.pkD.pkC.pkA.hkZ.doNotify();
                a aVar2 = this.pkD.pkC;
                normalUserFooterPreference = aVar2.pkA;
                ar.Hg();
                NormalUserFooterPreference.a(normalUserFooterPreference, c.EY().WO(NormalUserFooterPreference.a(aVar2.pkA).field_username));
                if (com.tencent.mm.l.a.fZ(NormalUserFooterPreference.a(aVar2.pkA).field_type)) {
                    intent = new Intent();
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(aVar2.pkA));
                    intent.putExtra("Contact_User", NormalUserFooterPreference.a(aVar2.pkA).field_username);
                    intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(aVar2.pkA).getIntent().getStringExtra("Contact_RoomNickname"));
                    intent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(aVar2.pkA).fWE);
                    String str = "";
                    if (!NormalUserFooterPreference.a(aVar2.pkA).AM()) {
                        String stringExtra = NormalUserFooterPreference.b(aVar2.pkA).getIntent().getStringExtra("Contact_Mobile_MD5");
                        String stringExtra2 = NormalUserFooterPreference.b(aVar2.pkA).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                        if (bh.ov(stringExtra) && bh.ov(stringExtra2)) {
                            if (!bh.ov(NormalUserFooterPreference.a(aVar2.pkA).field_username)) {
                                bVar = af.OD().kR(NormalUserFooterPreference.a(aVar2.pkA).field_username);
                            }
                        } else if (!(bh.ov(stringExtra) && bh.ov(stringExtra2))) {
                            bVar = af.OD().kS(stringExtra);
                            if (bVar == null || bh.ov(bVar.Nr())) {
                                bVar = af.OD().kS(stringExtra2);
                            }
                        }
                        if (!(bVar == null || bh.ov(bVar.Nr()))) {
                            str = bh.ou(bVar.Nz()).replace(" ", "");
                        }
                    }
                    intent.putExtra("contact_phone_number_by_md5", str);
                    com.tencent.mm.plugin.profile.a.ifs.p(intent, aVar2.pkA.mContext);
                    return;
                }
                aVar2.HB(NormalUserFooterPreference.a(aVar2.pkA).field_username);
                return;
            case 2:
                if (NormalUserFooterPreference.a(this.pkD.pkC.pkA).AH()) {
                    s.m(NormalUserFooterPreference.a(this.pkD.pkC.pkA));
                    h.bu(NormalUserFooterPreference.b(this.pkD.pkC.pkA), NormalUserFooterPreference.b(this.pkD.pkC.pkA).getString(R.l.dXe));
                } else {
                    s.l(NormalUserFooterPreference.a(this.pkD.pkC.pkA));
                    h.bu(NormalUserFooterPreference.b(this.pkD.pkC.pkA), NormalUserFooterPreference.b(this.pkD.pkC.pkA).getString(R.l.dUY));
                }
                normalUserFooterPreference = this.pkD.pkC.pkA;
                ar.Hg();
                NormalUserFooterPreference.a(normalUserFooterPreference, c.EY().WO(NormalUserFooterPreference.a(this.pkD.pkC.pkA).field_username));
                return;
            case 3:
                Intent intent2 = new Intent();
                intent2.putExtra("sns_permission_userName", NormalUserFooterPreference.a(this.pkD.pkC.pkA).field_username);
                intent2.putExtra("sns_permission_anim", true);
                intent2.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.bm.d.b(NormalUserFooterPreference.b(this.pkD.pkC.pkA), "sns", ".ui.SnsPermissionUI", intent2);
                return;
            case 4:
                aVar = this.pkD.pkC;
                intent = new Intent();
                intent.putExtra("Select_Talker_Name", NormalUserFooterPreference.a(aVar.pkA).field_username);
                intent.putExtra("Select_block_List", NormalUserFooterPreference.a(aVar.pkA).field_username);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("mutil_select_is_ret", true);
                com.tencent.mm.plugin.profile.a.ifs.a(intent, NormalUserFooterPreference.b(aVar.pkA));
                return;
            case 5:
                if (NormalUserFooterPreference.a(this.pkD.pkC.pkA).AF()) {
                    a.a(this.pkD.pkC);
                    return;
                }
                inflate = View.inflate(this.pkD.pkC.pkA.mContext, R.i.dnm, null);
                inflate.setPadding(0, 0, 0, 0);
                textView = (TextView) inflate.findViewById(R.h.cwe);
                textView.setPadding(0, 0, 0, 0);
                textView.setText(R.l.dVI);
                checkBox = (CheckBox) inflate.findViewById(R.h.cwc);
                checkBox.setChecked(false);
                textView = (TextView) inflate.findViewById(R.h.cwd);
                textView.setText(R.l.dVJ);
                if (NormalUserFooterPreference.a(this.pkD.pkC.pkA).getSource() == 18) {
                    checkBox.setVisibility(0);
                    textView.setVisibility(0);
                } else {
                    checkBox.setVisibility(8);
                    textView.setVisibility(8);
                }
                h.a(this.pkD.pkC.pkA.mContext, true, this.pkD.pkC.pkA.mContext.getString(R.l.dVH), inflate, this.pkD.pkC.pkA.mContext.getString(R.l.dFU), this.pkD.pkC.pkA.mContext.getString(R.l.dEn), new 1(this, checkBox), null);
                return;
            case 6:
                CharSequence string;
                inflate = View.inflate(this.pkD.pkC.pkA.mContext, R.i.dnm, null);
                inflate.setPadding(0, 0, 0, 0);
                textView = (TextView) inflate.findViewById(R.h.cwe);
                textView.setPadding(0, 0, 0, 0);
                if (s.gC(NormalUserFooterPreference.a(this.pkD.pkC.pkA).field_username)) {
                    string = this.pkD.pkC.pkA.mContext.getString(R.l.dYl, new Object[]{NormalUserFooterPreference.a(this.pkD.pkC.pkA).AQ()});
                } else {
                    string = this.pkD.pkC.pkA.mContext.getString(R.l.dYj, new Object[]{NormalUserFooterPreference.a(this.pkD.pkC.pkA).AQ()});
                }
                textView.setText(string);
                checkBox = (CheckBox) inflate.findViewById(R.h.cwc);
                checkBox.setChecked(false);
                textView = (TextView) inflate.findViewById(R.h.cwd);
                textView.setText(R.l.dVJ);
                if (NormalUserFooterPreference.a(this.pkD.pkC.pkA).getSource() == 18) {
                    checkBox.setVisibility(0);
                    textView.setVisibility(0);
                } else {
                    checkBox.setVisibility(8);
                    textView.setVisibility(8);
                }
                h.a(this.pkD.pkC.pkA.mContext, true, this.pkD.pkC.pkA.mContext.getString(R.l.bXr), inflate, this.pkD.pkC.pkA.mContext.getString(R.l.dEw), this.pkD.pkC.pkA.mContext.getString(R.l.dEn), new 2(this, checkBox), null, R.e.brm);
                return;
            case 7:
                aVar = this.pkD.pkC;
                x.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(aVar.pkA).field_username);
                com.tencent.mm.plugin.base.model.b.M(NormalUserFooterPreference.b(aVar.pkA), NormalUserFooterPreference.a(aVar.pkA).field_username);
                ag.h(new 10(aVar), 1000);
                return;
            case 9:
                a.c(this.pkD.pkC);
                return;
            default:
                return;
        }
    }
}
