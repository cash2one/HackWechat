package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class e$1 implements OnItemClickListener {
    final /* synthetic */ e kRr;

    e$1(e eVar) {
        this.kRr = eVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = (b) this.kRr.kIO.get(i);
        if (bVar != null && !TextUtils.isEmpty(bVar.url)) {
            Intent intent = new Intent();
            if (this.kRr.kIK instanceof CardInfo) {
                intent.putExtra("key_card_info_data", (CardInfo) this.kRr.kIK);
            } else if (this.kRr.kIK instanceof ShareCardInfo) {
                intent.putExtra("key_card_info_data", (ShareCardInfo) this.kRr.kIK);
            }
            g gVar;
            Object[] objArr;
            if (bVar.url.equals("card://jump_detail")) {
                int i2;
                if (this.kRr.kIK.atB().vSa == null || TextUtils.isEmpty(this.kRr.kIK.atB().vSa.url)) {
                    intent.setClass(this.kRr.kQM, CardDetailPreference.class);
                    this.kRr.kQM.startActivity(intent);
                } else {
                    com.tencent.mm.plugin.card.b.b.a(this.kRr.kQM, this.kRr.kIK.atB().vSa.url, 1);
                }
                gVar = g.pQN;
                objArr = new Object[9];
                objArr[0] = "CardLeftRightIntroduceView";
                objArr[1] = Integer.valueOf(this.kRr.kIK.atB().kJO);
                objArr[2] = this.kRr.kIK.atG();
                objArr[3] = this.kRr.kIK.atF();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kRr.kRo.kNT);
                objArr[6] = this.kRr.kRo.kQw;
                if (this.kRr.kIK.atz()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[7] = Integer.valueOf(i2);
                objArr[8] = "";
                gVar.h(11324, objArr);
            } else if (bVar.url.equals("card://jump_shop_list") && this.kRr.kIK.atB().vRM > 0) {
                e.a(this.kRr);
            } else if (!bVar.url.equals("card://jump_shop") || this.kRr.kIK.atB().vRM <= 0) {
                if (bVar.url.equals("card://jump_service")) {
                    if (!TextUtils.isEmpty(this.kRr.kIK.atB().vRF)) {
                        com.tencent.mm.plugin.card.b.b.T(this.kRr.kQM, this.kRr.kIK.atB().vRF);
                        am.auG().m(this.kRr.kIK.atF(), this.kRr.kIK.atG(), 1);
                    }
                    g.pQN.h(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.kRr.kIK.atB().kJO), this.kRr.kIK.atG(), this.kRr.kIK.atF(), this.kRr.kRo.kQw});
                } else if (bVar.url.equals("card://jump_gift")) {
                    e.b(this.kRr);
                    e eVar = this.kRr;
                    if (eVar.kIK.atC().vRq == null) {
                        x.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                    } else if (eVar.kIK.atC().vRq.vXw == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                    } else {
                        g.pQN.h(13866, new Object[]{Integer.valueOf(6), eVar.kIK.atC().vRq.vXw.vEN, o.getString(eVar.kIK.atC().vRq.vXw.vEM)});
                    }
                } else if (bVar.url.equals("card://jump_card_gift")) {
                    if (this.kRr.kIK.atC().vRq == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                    } else if (this.kRr.kIK.atC().vRq.vXw == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                    } else {
                        e eVar2 = this.kRr;
                        x.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", new Object[]{this.kRr.kIK.atC().vRq.vXw.vEN, Integer.valueOf(this.kRr.kIK.atC().vRq.vXw.vEM)});
                        Intent intent2 = new Intent(eVar2.kQM, CardGiftReceiveUI.class);
                        intent2.putExtra("key_biz_uin", r2);
                        intent2.putExtra("key_order_id", r0);
                        intent2.putExtra("key_gift_into", (CardGiftInfo) eVar2.kQM.getIntent().getParcelableExtra("key_card_git_info"));
                        eVar2.kQM.startActivity(intent2);
                        g.pQN.h(13866, new Object[]{Integer.valueOf(5), this.kRr.kIK.atC().vRq.vXw.vEN, o.getString(this.kRr.kIK.atC().vRq.vXw.vEM)});
                    }
                } else if ((bVar.vSM & 32) > 0) {
                    a aVar = this.kRr;
                    com.tencent.mm.plugin.card.b.b.a(aVar.kQM, 4, aVar);
                    aVar.kQM.jwN = aVar;
                } else if (com.tencent.mm.plugin.card.b.b.d(this.kRr.kIK.atF(), bVar.vRx, bVar.vRy, this.kRr.kRo.kNT, this.kRr.kRo.kRu)) {
                    g.pQN.h(11941, new Object[]{Integer.valueOf(21), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", bVar.title});
                } else {
                    String atF;
                    com.tencent.mm.plugin.card.b.b.a(this.kRr.kQM, l.v(bVar.url, bVar.vSM), 1);
                    g.pQN.h(11492, new Object[]{Integer.valueOf(this.kRr.kRo.kNT), this.kRr.kRo.kQx, this.kRr.kIK.atF(), this.kRr.kIK.atG(), Integer.valueOf(this.kRr.kIK.atC().status), atF, Integer.valueOf(this.kRr.kIK.atB().kJO), this.kRr.kIK.atB().vRF});
                    g.pQN.h(11941, new Object[]{Integer.valueOf(6), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", bVar.title});
                    if (l.a(bVar, this.kRr.kIK.atF())) {
                        atF = this.kRr.kIK.atF();
                        r0 = bVar.title;
                        l.wU(atF);
                        com.tencent.mm.plugin.card.b.b.a(this.kRr.kQM, this.kRr.kIK.atB().kLa);
                    }
                }
            } else if (this.kRr.kIQ == null || this.kRr.kIQ.size() == 0) {
                x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
            } else {
                kj kjVar = (kj) this.kRr.kIQ.get(0);
                if (!(kjVar == null || TextUtils.isEmpty(kjVar.kLB))) {
                    com.tencent.mm.plugin.card.b.b.a(this.kRr.kQM, kjVar.kLB, 1);
                    g.pQN.h(11941, new Object[]{Integer.valueOf(4), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", kjVar.name});
                }
                gVar = g.pQN;
                objArr = new Object[9];
                objArr[0] = "UsedStoresView";
                objArr[1] = Integer.valueOf(this.kRr.kIK.atB().kJO);
                objArr[2] = this.kRr.kIK.atG();
                objArr[3] = this.kRr.kIK.atF();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kRr.kRo.kNT);
                objArr[6] = this.kRr.kRo.kQw;
                objArr[7] = Integer.valueOf(this.kRr.kIK.atz() ? 1 : 0);
                objArr[8] = "";
                gVar.h(11324, objArr);
            }
        }
    }
}
