package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;

class e$5 implements OnClickListener {
    final /* synthetic */ e kRr;

    e$5(e eVar) {
        this.kRr = eVar;
    }

    public final void onClick(View view) {
        if (this.kRr.kIK == null) {
            x.e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
            return;
        }
        g.pQN.h(11582, new Object[]{"CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(this.kRr.kIK.atB().kJO), this.kRr.kIK.atG(), this.kRr.kIK.atF(), this.kRr.kRo.kQw});
        h.a(this.kRr.kQM.mController.xIM, null, (String[]) this.kRr.kRm.toArray(new String[this.kRr.kRm.size()]), null, false, new c(this) {
            final /* synthetic */ e$5 kRs;

            {
                this.kRs = r1;
            }

            public final void jl(int i) {
                String str = (String) this.kRs.kRr.kRk.get(Integer.valueOf(i));
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals("menu_func_share_friend")) {
                        int i2;
                        a aVar = this.kRs.kRr;
                        b.a(aVar.kQM, 1, aVar);
                        aVar.kQM.jwN = aVar;
                        g gVar = g.pQN;
                        Object[] objArr = new Object[9];
                        objArr[0] = "BrandContactView";
                        objArr[1] = Integer.valueOf(this.kRs.kRr.kIK.atB().kJO);
                        objArr[2] = this.kRs.kRr.kIK.atG();
                        objArr[3] = this.kRs.kRr.kIK.atF();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(this.kRs.kRr.kRo.kNT);
                        objArr[6] = this.kRs.kRr.kRo.kQw;
                        if (this.kRs.kRr.kIK.atz()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr[7] = Integer.valueOf(i2);
                        objArr[8] = "";
                        gVar.h(11324, objArr);
                        g.pQN.h(11582, new Object[]{"OperShareFriend", Integer.valueOf(1), Integer.valueOf(this.kRs.kRr.kIK.atB().kJO), this.kRs.kRr.kIK.atG(), this.kRs.kRr.kIK.atF(), this.kRs.kRr.kRi});
                    } else if (str.equals("menu_func_gift")) {
                        e.b(this.kRs.kRr);
                    } else if (str.equals("menu_func_delete")) {
                        str = "";
                        if (this.kRs.kRr.kIK.ati()) {
                            str = this.kRs.kRr.kQM.getString(R.l.dNX);
                        }
                        d.a(this.kRs.kRr.kQM, this.kRs.kRr.kRo.kIw, str, new 1(this));
                        g.pQN.h(11582, new Object[]{"OperDelete", Integer.valueOf(1), Integer.valueOf(this.kRs.kRr.kIK.atB().kJO), this.kRs.kRr.kIK.atG(), this.kRs.kRr.kIK.atF(), ""});
                    } else if (str.equals("menu_func_service")) {
                        if (!TextUtils.isEmpty(this.kRs.kRr.kIK.atB().vRF)) {
                            b.T(this.kRs.kRr.kQM, this.kRs.kRr.kIK.atB().vRF);
                            am.auG().m(this.kRs.kRr.kIK.atF(), this.kRs.kRr.kIK.atG(), 1);
                        }
                        g.pQN.h(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.kRs.kRr.kIK.atB().kJO), this.kRs.kRr.kIK.atG(), this.kRs.kRr.kIK.atF(), this.kRs.kRr.kRo.kQw});
                    } else if (str.equals("menu_func_report")) {
                        if (!TextUtils.isEmpty(this.kRs.kRr.kIK.atC().vRi)) {
                            b.a(this.kRs.kRr.kQM, this.kRs.kRr.kIK.atC().vRi, this.kRs.kRr.getString(R.l.dOW));
                        }
                        g.pQN.h(11582, new Object[]{"OperReport", Integer.valueOf(1), Integer.valueOf(this.kRs.kRr.kIK.atB().kJO), this.kRs.kRr.kIK.atG(), this.kRs.kRr.kIK.atF(), ""});
                    } else if (str.equals("menu_func_share_timeline")) {
                        j.a(new m(this.kRs.kRr.kIK.atB().kJP));
                        Context context = this.kRs.kRr.kQM;
                        com.tencent.mm.plugin.card.base.b bVar = this.kRs.kRr.kIK;
                        String str2 = this.kRs.kRr.kRo.kIw;
                        Object obj = this.kRs.kRr.kRo.kQy;
                        Intent intent = new Intent();
                        intent.putExtra("Ksnsupload_link", bVar.atB().vRO);
                        intent.putExtra("KContentObjDesc", bVar.atB().kLa);
                        intent.putExtra("Ksnsupload_title", bVar.atB().title);
                        if (TextUtils.isEmpty(obj)) {
                            intent.putExtra("KUploadProduct_UserData", str2 + "#");
                        } else {
                            intent.putExtra("KUploadProduct_UserData", str2 + "#" + obj);
                        }
                        intent.putExtra("Ksnsupload_imgurl", bVar.atB().kJP);
                        if (!TextUtils.isEmpty(bVar.atB().kJP)) {
                            intent.putExtra("KsnsUpload_imgPath", new m(bVar.atB().kJP).Wf());
                        }
                        x.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent.getStringExtra("KsnsUpload_imgPath"));
                        intent.putExtra("src_username", q.FS());
                        intent.putExtra("src_displayname", q.FU());
                        intent.putExtra("Ksnsupload_appid", bVar.atB().fFm);
                        intent.putExtra("Ksnsupload_appname", bVar.atB().vRF);
                        intent.putExtra("Ksnsupload_type", 7);
                        String hz = u.hz("card_package");
                        u.GK().t(hz, true).o("prePublishId", "card_package");
                        intent.putExtra("reportSessionId", hz);
                        com.tencent.mm.bm.d.a(context, "sns", ".ui.SnsUploadUI", intent, false);
                        g.pQN.h(11582, new Object[]{"OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(this.kRs.kRr.kIK.atB().kJO), this.kRs.kRr.kIK.atG(), this.kRs.kRr.kIK.atF(), this.kRs.kRr.kRo.kQw});
                    } else if (str.equals("menu_func_delete_share_card")) {
                        d.a(this.kRs.kRr.kQM, this.kRs.kRr.kRo.kIw, "", new 2(this));
                    } else {
                        str = (String) this.kRs.kRr.kRl.get(str);
                        if (!bh.ov(str)) {
                            b.a(this.kRs.kRr.kQM, str, 0);
                        }
                    }
                }
            }
        });
    }
}
