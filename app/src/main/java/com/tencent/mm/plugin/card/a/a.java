package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.oz$b;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a extends c<oz> implements e {
    private oz kIr;

    public a() {
        this.xen = oz.class.getName().hashCode();
    }

    private boolean a(oz ozVar) {
        if (!ar.Hj()) {
            x.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            return false;
        } else if (!(ozVar instanceof oz)) {
            return false;
        } else {
            this.kIr = ozVar;
            Object obj = this.kIr.fGS.fGU;
            String str = this.kIr.fGS.fGV;
            int i = this.kIr.fGS.fGW;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                atN();
                return false;
            }
            ar.CG().a(651, this);
            x.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene " + i);
            ar.CG().a(new o(obj, i, "", str, "", "", 0, 0, null), 0);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            oz$b com_tencent_mm_g_a_oz_b = new oz$b();
            x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                o oVar = (o) kVar;
                int i3 = oVar.kLO;
                String str2 = oVar.kLN;
                String str3 = oVar.kLP;
                if (i3 == 0) {
                    x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    com_tencent_mm_g_a_oz_b.fsH = true;
                    CardInfo cardInfo = new CardInfo();
                    f.a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        com_tencent_mm_g_a_oz_b.fGU = "";
                    } else {
                        com_tencent_mm_g_a_oz_b.fGU = cardInfo.field_card_id;
                    }
                    am.auF().putValue("key_accept_card_info", cardInfo);
                } else {
                    x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    com_tencent_mm_g_a_oz_b.fsH = false;
                }
            } else {
                x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                com_tencent_mm_g_a_oz_b.fsH = false;
            }
            ar.CG().b(651, this);
            this.kIr.fGT = com_tencent_mm_g_a_oz_b;
            atN();
        }
    }

    private void atN() {
        if (this.kIr.fqI != null) {
            this.kIr.fqI.run();
        }
        this.kIr = null;
    }
}
