package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.n;

class SnsTagContactListUI$1 implements OnItemClickListener {
    final /* synthetic */ SnsTagContactListUI yUU;

    SnsTagContactListUI$1(SnsTagContactListUI snsTagContactListUI) {
        this.yUU = snsTagContactListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        a aVar = (a) SnsTagContactListUI.a(this.yUU).getItem(i);
        h hVar = n.qQD;
        if (hVar == null) {
            this.yUU.finish();
            return;
        }
        Intent e = hVar.e(intent, aVar.field_username);
        if (e == null) {
            this.yUU.finish();
        } else {
            d.b(this.yUU.mController.xIM, "sns", ".ui.SnsUserUI", e);
        }
    }
}
