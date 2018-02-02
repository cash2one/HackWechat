package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.bi;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.z.ar;

public final class v implements OnClickListener, e {
    private Context mContext;
    private d nbT = null;
    int ndn;
    DialogInterface.OnClickListener nvZ = null;

    public static class b {
        public String content;
        public Boolean nwd;
        public a nwe;
        public String title;
    }

    public v(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.nbT = (d) view.getTag();
            x.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.nbT.field_appId);
            ar.CG().a(1219, this);
            ar.CG().a(new bi(this.nbT.field_appId, w.cfi(), this.nbT.fop, this.nbT.nbc), 0);
            return;
        }
        x.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && kVar.getType() == 1219) {
            ar.CG().b(1219, this);
            an anVar = new an(((bi) kVar).lMW.hmh.hmo);
            b bVar = new b();
            bVar.nwd = Boolean.valueOf(anVar.ndZ.nfv);
            bVar.title = anVar.ndZ.fon;
            bVar.content = anVar.ndZ.nfU;
            if (anVar.ndZ.nkm != null) {
                bVar.nwe = new a();
                bVar.nwe.message = anVar.ndZ.nkm.nfU;
                bVar.nwe.nwb = anVar.ndZ.nkm.nfV;
                bVar.nwe.nwc = anVar.ndZ.nkm.nfW;
                bVar.nwe.url = anVar.ndZ.nkm.nfX;
            }
            this.nbT.naU = bVar.nwd.booleanValue();
            if (!bh.ov(bVar.title)) {
                if (bVar.nwe != null) {
                    String str2 = bVar.nwe.url;
                    i$a com_tencent_mm_ui_base_i_a = new i$a(this.mContext);
                    com_tencent_mm_ui_base_i_a.YF(bVar.title);
                    com_tencent_mm_ui_base_i_a.YG(bVar.nwe.message);
                    com_tencent_mm_ui_base_i_a.mi(false);
                    com_tencent_mm_ui_base_i_a.YI(bVar.nwe.nwb).a(true, new 1(this, str2));
                    com_tencent_mm_ui_base_i_a.YJ(bVar.nwe.nwc).b(this.nvZ);
                    com_tencent_mm_ui_base_i_a.akx().show();
                    return;
                } else if (!bh.ov(bVar.content)) {
                    i$a com_tencent_mm_ui_base_i_a2 = new i$a(this.mContext);
                    com_tencent_mm_ui_base_i_a2.YF(bVar.title);
                    com_tencent_mm_ui_base_i_a2.YG(bVar.content);
                    com_tencent_mm_ui_base_i_a2.mi(false);
                    com_tencent_mm_ui_base_i_a2.EC(R.l.enf).a(this.nvZ);
                    com_tencent_mm_ui_base_i_a2.akx().show();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        i$a com_tencent_mm_ui_base_i_a3 = new i$a(this.mContext);
        com_tencent_mm_ui_base_i_a3.EA(R.l.eng);
        com_tencent_mm_ui_base_i_a3.EC(R.l.enf);
        com_tencent_mm_ui_base_i_a3.akx().show();
    }
}
