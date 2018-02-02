package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SelectMemberUI$3 implements OnItemClickListener {
    final /* synthetic */ SelectMemberUI ldP;

    SelectMemberUI$3(SelectMemberUI selectMemberUI) {
        this.ldP = selectMemberUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (SelectMemberUI.d(this.ldP)) {
            case 1:
                SelectMemberUI.a(this.ldP, SelectMemberUI.b(this.ldP).oi(i).jLe.field_username);
                return;
            case 2:
                SelectMemberUI.a(this.ldP, i);
                return;
            default:
                x.w("MicroMsg.SelectMemberUI", "mFromScene is default");
                return;
        }
    }
}
