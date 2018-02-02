package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends g {
    public final boolean h(b bVar) {
        if (this.kIK == null) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else if (this.kIK.atC().vRt != bVar.atC().vRt) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            return true;
        } else {
            oq oqVar = this.kIK.atC().vRs;
            oq oqVar2 = bVar.atC().vRs;
            if ((oqVar == null && oqVar2 != null) || (oqVar != null && oqVar2 == null)) {
                x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                return true;
            } else if (oqVar == null || oqVar2 == null || oqVar.title == null || oqVar2.title == null || !oqVar.title.equals(oqVar2.title)) {
                oqVar = this.kIK.atB().vSm;
                oqVar2 = bVar.atB().vSm;
                if ((oqVar == null && oqVar2 != null) || (oqVar != null && oqVar2 == null)) {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (oqVar != null && oqVar2 != null && oqVar.title != null && oqVar2.title != null && !oqVar.title.equals(oqVar2.title)) {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (oqVar == null || oqVar2 == null || oqVar.kJR == null || oqVar2.kJR == null || oqVar.kJR.equals(oqVar2.kJR)) {
                    return false;
                } else {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                }
            } else {
                x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                return true;
            }
        }
    }

    public final String e(c cVar) {
        x.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        g auQ = am.auQ();
        b bVar = this.kIK;
        String str = "";
        if (bVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
            return str;
        }
        int i;
        auQ.atS();
        auQ.kIR = cVar;
        String atF = bVar.atF();
        Cursor rawQuery = am.auO().gJP.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{atF});
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } else {
            i = 0;
        }
        if (i == 0) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
            i = 0;
        } else {
            i wg = am.auP().wg(atF);
            if (wg != null) {
                if (g.a(wg)) {
                    auQ.kIR = c.kXq;
                    i = 0;
                } else if (i < wg.field_lower_bound && l.isNetworkAvailable(ac.getContext())) {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(wg.field_lower_bound)});
                    auQ.kIR = c.kXw;
                    i = 0;
                }
            }
            i = 1;
        }
        if (i == 0) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
            auQ.a(bVar, q.kXM);
            return "";
        }
        com.tencent.mm.sdk.e.c wi = am.auO().wi(bVar.atF());
        if (wi == null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[]{bVar.atF()});
            auQ.a(bVar, q.kXM);
            return "";
        }
        k wj = am.auO().wj(atF);
        if (wj != null && am.auO().bP(atF, wj.field_code_id)) {
            auQ.a(atF, wj.field_code_id, cVar);
        }
        auQ.kIS = 0;
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[]{atF, wi.field_code_id, Integer.valueOf(cVar.action)});
        atF = bVar.atF();
        if (wi == null) {
            str = "";
        } else {
            str = e.bV(atF, wi.field_code);
            i wg2 = am.auP().wg(atF);
            if (wg2 == null || com.tencent.pb.common.c.g.AA(str) || !wg2.field_need_insert_show_timestamp || com.tencent.pb.common.c.g.AA(wg2.field_show_timestamp_encrypt_key)) {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
            } else {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                str = e.bX(str, wg2.field_show_timestamp_encrypt_key);
            }
        }
        if (com.tencent.pb.common.c.g.AA(str)) {
            auQ.R(1, "");
            return "";
        }
        wi.field_status = 1;
        if (am.auO().c(wi, new String[]{"card_id", "code_id"})) {
            x.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[]{wi.field_card_id, wi.field_code_id, Integer.valueOf(wi.field_status)});
        } else {
            x.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[]{wi.field_card_id, wi.field_code_id, Integer.valueOf(wi.field_status)});
        }
        g auQ2 = am.auQ();
        i wg3 = am.auP().wg(bVar.atF());
        if (wg3 == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            return str;
        }
        long j = (long) (wg3.field_show_expire_interval * 1000);
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: " + j);
        auQ2.kIT.J(j, j);
        return str;
    }

    public final ab axb() {
        return new n(this, this.kaY);
    }

    public final ab axc() {
        return new f(this, this.kaY);
    }

    public final ab axd() {
        return new t(this, this.kaY);
    }
}
