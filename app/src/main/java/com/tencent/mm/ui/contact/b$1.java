package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.b.3;

class b$1 implements OnClickListener {
    final /* synthetic */ b$a yQG;
    final /* synthetic */ b yQH;

    b$1(b bVar, b$a com_tencent_mm_ui_contact_b_a) {
        this.yQH = bVar;
        this.yQG = com_tencent_mm_ui_contact_b_a;
    }

    public final void onClick(View view) {
        switch (3.yQI[this.yQG.ordinal()]) {
            case 1:
                Intent intent = new Intent();
                intent.setClassName(b.a(this.yQH), "com.tencent.mm.ui.contact.ChatroomContactUI");
                b.a(this.yQH).startActivity(intent);
                return;
            case 2:
                d.b(b.a(this.yQH), "label", ".ui.ContactLabelManagerUI", new Intent());
                return;
            case 3:
                d.b(b.a(this.yQH), "ipcall", ".ui.IPCallAddressUI", new Intent());
                return;
            default:
                x.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[]{this.yQG});
                return;
        }
    }
}
