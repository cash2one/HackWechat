package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;

class CardNewMsgUI$a$1 implements OnClickListener {
    final /* synthetic */ a kUI;
    final /* synthetic */ g kUJ;
    final /* synthetic */ CardNewMsgUI.a kUK;

    CardNewMsgUI$a$1(CardNewMsgUI.a aVar, a aVar2, g gVar) {
        this.kUK = aVar;
        this.kUI = aVar2;
        this.kUJ = gVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        if (this.kUI.kLy == 0) {
            intent.setClass(this.kUK.kUG.mController.xIM, CardDetailUI.class);
            intent.putExtra("key_card_id", this.kUI.cardId);
            intent.putExtra("key_card_ext", this.kUI.kLw);
            intent.putExtra("key_from_scene", 17);
            this.kUK.kUG.startActivity(intent);
        } else if (this.kUI.kLy == 1) {
            intent.setClass(this.kUK.kUG.mController.xIM, CardConsumeSuccessUI.class);
            intent.putExtra("key_card_id", this.kUJ.field_card_id);
            intent.putExtra("key_from_scene", 2);
            this.kUK.kUG.startActivity(intent);
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(8), this.kUJ.field_card_id, this.kUJ.field_card_tp_id, this.kUJ.field_msg_id, this.kUI.cardId});
    }
}
