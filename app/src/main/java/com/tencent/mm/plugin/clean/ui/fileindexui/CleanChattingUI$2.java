package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;

class CleanChattingUI$2 implements OnItemClickListener {
    final /* synthetic */ CleanChattingUI lgN;

    CleanChattingUI$2(CleanChattingUI cleanChattingUI) {
        this.lgN = cleanChattingUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c ok = CleanChattingUI.a(this.lgN).ok(i);
        if (ok != null) {
            Intent intent = new Intent(this.lgN, CleanChattingDetailUI.class);
            intent.putExtra("key_username", ok.username);
            intent.putExtra("key_pos", i);
            this.lgN.startActivityForResult(intent, 0);
            g.pQN.a(714, 21, 1, false);
        }
    }
}
