package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;

class e$4 implements OnItemClickListener {
    final /* synthetic */ e nIr;

    e$4(e eVar) {
        this.nIr = eVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.nIr.nIi.qY(i) && (adapterView instanceof ListView)) {
            k rD = this.nIr.nIi.rD(i - ((ListView) adapterView).getHeaderViewsCount());
            if (rD != null) {
                c cVar = null;
                if (rD.field_addressId > 0) {
                    cVar = i.aTD().dy(rD.field_addressId);
                }
                Intent intent = new Intent(this.nIr.nIk, IPCallUserProfileUI.class);
                if (cVar != null) {
                    intent.putExtra("IPCallProfileUI_contactid", cVar.field_contactId);
                    intent.putExtra("IPCallProfileUI_systemUsername", cVar.field_systemAddressBookUsername);
                    intent.putExtra("IPCallProfileUI_wechatUsername", cVar.field_wechatUsername);
                } else {
                    intent.putExtra("IPCallProfileUI_phonenumber", rD.field_phonenumber);
                }
                intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                this.nIr.nIk.startActivity(intent);
            }
        }
    }
}
