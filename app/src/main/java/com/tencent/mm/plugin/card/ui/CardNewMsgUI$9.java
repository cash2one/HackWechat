package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.platformtools.x;

class CardNewMsgUI$9 implements OnClickListener {
    final /* synthetic */ CardNewMsgUI kUG;

    CardNewMsgUI$9(CardNewMsgUI cardNewMsgUI) {
        this.kUG = cardNewMsgUI;
    }

    public final void onClick(View view) {
        g gVar;
        if (view.getId() == R.h.cfL) {
            gVar = (g) view.getTag();
            if (gVar != null && gVar.auq() != null) {
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
                if (gVar.auq().kLy == 0) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                    if (TextUtils.isEmpty(gVar.auq().url)) {
                        x.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                    } else {
                        b.a(this.kUG, gVar.auq().url, 2);
                    }
                } else if (gVar.auq().kLy == 1) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                    Intent intent = new Intent();
                    intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                    intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                    intent.setClass(this.kUG, CardShopUI.class);
                    this.kUG.startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11324, new Object[]{"UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                }
            }
        } else if (view.getId() == R.h.cBK) {
            gVar = (g) view.getTag();
            if (gVar != null && gVar.aur() != null) {
                if (gVar.aur().type == 0) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                    if (TextUtils.isEmpty(gVar.aur().url)) {
                        x.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                    } else {
                        b.a(this.kUG, gVar.aur().url, 2);
                    }
                } else if (gVar.aur().type == 1) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                }
            }
        }
    }
}
