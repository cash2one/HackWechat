package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.report.service.g;

class IPCallContactUI$6 implements OnItemClickListener {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$6(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!IPCallContactUI.d(this.nIW).qY(i)) {
            c rw = IPCallContactUI.d(this.nIW).rw(i);
            if (rw != null) {
                if (!IPCallContactUI.e(this.nIW)) {
                    g.pQN.h(12767, new Object[]{Integer.valueOf(2)});
                }
                Intent intent = new Intent(this.nIW.mController.xIM, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", rw.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", rw.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", rw.field_wechatUsername);
                this.nIW.mController.xIM.startActivity(intent);
            }
        }
    }
}
