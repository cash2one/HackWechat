package com.tencent.mm.ui.chatting.h;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.h.b.a;

class b$3 implements OnClickListener {
    final /* synthetic */ b yIj;

    b$3(b bVar) {
        this.yIj = bVar;
    }

    public final void onClick(View view) {
        if (this.yIj.yIh != null) {
            a aVar = this.yIj.yIh;
            b bVar = this.yIj;
            long currentTimeMillis = System.currentTimeMillis();
            int value = bVar.yIc.getValue();
            int value2 = bVar.yId.getValue();
            currentTimeMillis = value == 0 ? b.ceK() ? currentTimeMillis + 360000 : currentTimeMillis + (((long) (value2 + 1)) * 3600000) : ((Long) bVar.yIi.get(value)).longValue() + (((long) (value2 + 1)) * 3600000);
            String ag = n.ag(bVar.mContext.getString(R.l.eiL) + "HH:mm", currentTimeMillis / 1000);
            x.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[]{ag});
            aVar.fX(currentTimeMillis);
        }
    }
}
