package com.tencent.mm.plugin.card.ui;

import android.database.Cursor;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class CardHomePageUI$9 implements IdleHandler {
    final /* synthetic */ CardHomePageUI kTC;

    CardHomePageUI$9(CardHomePageUI cardHomePageUI) {
        this.kTC = cardHomePageUI;
    }

    public final boolean queueIdle() {
        if (CardHomePageUI.h(this.kTC) != null) {
            boolean z;
            CardHomePageUI.h(this.kTC);
            ar.Hg();
            Integer num = (Integer) c.CU().get(a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                ar.Hg();
                c.CU().a(a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(1));
                Cursor nH = am.auA().nH(n.a.kLG);
                if (nH == null || nH.getCount() <= 0) {
                    x.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                    z = false;
                } else {
                    nH.moveToFirst();
                    while (!nH.isAfterLast()) {
                        com.tencent.mm.sdk.e.c cardInfo = new CardInfo();
                        cardInfo.b(nH);
                        if (cardInfo.field_card_type == -1) {
                            if (cardInfo.atB() == null) {
                                x.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                            } else {
                                cardInfo.field_card_type = cardInfo.atB().kJO;
                                if (!am.auA().c(cardInfo, new String[0])) {
                                    x.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", cardInfo.field_card_id);
                                }
                            }
                        }
                        nH.moveToNext();
                    }
                    nH.close();
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                x.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                CardHomePageUI.i(this.kTC);
            }
        }
        return false;
    }
}
