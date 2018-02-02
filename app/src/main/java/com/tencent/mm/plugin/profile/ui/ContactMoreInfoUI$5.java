package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fts.a.e;

class ContactMoreInfoUI$5 implements OnClickListener {
    final /* synthetic */ int gIR;
    final /* synthetic */ ContactMoreInfoUI pis;

    ContactMoreInfoUI$5(ContactMoreInfoUI contactMoreInfoUI, int i) {
        this.pis = contactMoreInfoUI;
        this.gIR = i;
    }

    public final void onClick(View view) {
        e.qc(this.gIR);
        if (this.gIR > 0) {
            Intent intent = new Intent(this.pis, CommonChatroomInfoUI.class);
            intent.putExtra("Select_Talker_Name", ContactMoreInfoUI.b(this.pis).field_username);
            this.pis.startActivity(intent);
        }
    }
}
