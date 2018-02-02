package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.ac.b;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.e;

final class aa implements ac$a {
    aa() {
    }

    public final void b(a aVar, int i, ChattingUI.a aVar2, au auVar) {
        b bVar = (b) aVar;
        com.tencent.mm.ax.a.b bVar2 = aVar2.ywb;
        int color = bVar.yMh.getContext().getResources().getColor(R.e.btd);
        int color2 = bVar.yMh.getContext().getResources().getColor(R.e.bte);
        com.tencent.mm.ax.a cjF = auVar.cjF();
        if (cjF == null) {
            bVar.mUL.setVisibility(8);
        } else {
            int i2;
            CharSequence charSequence;
            bVar.mUL.setVisibility(0);
            bVar.yMh.setText(i.b(bVar.yMh.getContext(), bh.ou(cjF.hIt), bVar.yMh.getTextSize()));
            bVar.yMh.setMovementMethod(new av());
            Object newSpannable;
            if (cjF.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || cjF.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = bVar.yMh.getContext().getResources().getColor(R.e.bsE);
                color2 = bVar.yMh.getContext().getResources().getColor(R.e.brC);
                if (auVar.cjz()) {
                    color = bVar.yMh.getContext().getResources().getColor(R.e.bsE);
                    color2 = bVar.yMh.getContext().getResources().getColor(R.e.brC);
                    i2 = 0;
                    newSpannable = Factory.getInstance().newSpannable(bVar.yMh.getText());
                } else {
                    Spannable newSpannable2 = Factory.getInstance().newSpannable("    " + bVar.yMh.getText());
                    Drawable drawable = bVar.yMh.getContext().getResources().getDrawable(R.k.dyQ);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    e eVar = new e(drawable, 1);
                    eVar.zsZ = (int) (((((float) drawable.getIntrinsicHeight()) - bVar.yMh.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(bVar.yMh.getContext(), 2))) / 2.0f);
                    newSpannable2.setSpan(eVar, 0, 3, 33);
                    i2 = 4;
                    charSequence = newSpannable2;
                }
            } else {
                i2 = 0;
                newSpannable = Factory.getInstance().newSpannable(bVar.yMh.getText());
            }
            for (int i3 = 0; i3 < cjF.hIv.size(); i3++) {
                a aVar3 = new a();
                aVar3.yMQ = new 1(this, color, color2, cjF, bVar2, bVar, auVar, i, i3);
                aVar3.start = ((Integer) cjF.hIw.get(i3)).intValue();
                aVar3.end = ((Integer) cjF.hIx.get(i3)).intValue();
                charSequence.setSpan(aVar3.yMQ, aVar3.start + i2, aVar3.end + i2, 33);
            }
            bVar.yMh.setText(charSequence);
            bVar.yMh.setOnClickListener(new 2(this));
        }
        bVar.yMh.invalidate();
    }
}
