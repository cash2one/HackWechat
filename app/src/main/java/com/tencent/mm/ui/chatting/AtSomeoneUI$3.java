package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.x;

class AtSomeoneUI$3 implements OnItemClickListener {
    final /* synthetic */ AtSomeoneUI yqk;

    AtSomeoneUI$3(AtSomeoneUI atSomeoneUI) {
        this.yqk = atSomeoneUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        Intent intent = new Intent();
        if (i == 0 && AtSomeoneUI.access$100()) {
            intent.putExtra("Select_Conv_User", this.yqk.getString(R.l.dHk, new Object[]{""}));
            intent.putExtra("select_raw_user_name", "notify@all");
        } else {
            AtSomeoneUI$a a = AtSomeoneUI.a(this.yqk);
            if (!AtSomeoneUI.access$100()) {
                i2 = 0;
            }
            x xVar = (x) a.getItem(i - i2);
            String a2 = AtSomeoneUI.a(AtSomeoneUI.b(this.yqk), xVar.field_username);
            if (t.ov(a2)) {
                a2 = xVar.AP();
            }
            intent.putExtra("select_raw_user_name", xVar.field_username);
            intent.putExtra("Select_Conv_User", a2);
        }
        this.yqk.setResult(-1, intent);
        this.yqk.finish();
    }
}
