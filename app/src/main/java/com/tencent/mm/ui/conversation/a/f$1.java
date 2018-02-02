package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.ar;

class f$1 implements OnClickListener {
    final /* synthetic */ f zaK;

    f$1(f fVar) {
        this.zaK = fVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent((Context) this.zaK.voC.get(), SelectContactUI.class);
        intent.putExtra("list_attr", s.fb(s.yTD, 256));
        intent.putExtra("list_type", 10);
        intent.putExtra("received_card_name", this.zaK.zaI);
        intent.putExtra("recommend_friends", true);
        intent.putExtra("titile", ((Context) this.zaK.voC.get()).getString(R.l.dDo));
        ((Context) this.zaK.voC.get()).startActivity(intent);
        ar.Hg().FF().il(this.zaK.zaI);
        ar.Hg().FF().il(this.zaK.zaJ);
        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, new Object[]{this.zaK.zaI, Integer.valueOf(2), Integer.valueOf(0)});
    }
}
