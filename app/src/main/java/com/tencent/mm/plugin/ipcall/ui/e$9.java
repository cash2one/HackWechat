package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class e$9 implements d {
    final /* synthetic */ e nIr;
    final /* synthetic */ k nIs;
    final /* synthetic */ int nIt;

    e$9(e eVar, k kVar, int i) {
        this.nIr = eVar;
        this.nIs = kVar;
        this.nIt = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            e eVar = this.nIr;
            k kVar = this.nIs;
            int i2 = this.nIt;
            l aTE;
            if (kVar.field_addressId > 0) {
                aTE = i.aTE();
                if (kVar.field_addressId > 0 && aTE.gJP.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)}) < 0) {
                    x.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[]{Integer.valueOf(aTE.gJP.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)})), Long.valueOf(r4)});
                }
            } else {
                aTE = i.aTE();
                if (!bh.ov(kVar.field_phonenumber) && aTE.gJP.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber}) < 0) {
                    x.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[]{Integer.valueOf(aTE.gJP.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber})), r1});
                }
            }
            h hVar = eVar.nIi;
            hVar.nLq.remove(i2);
            hVar.notifyDataSetChanged();
            if (eVar.nIi.getCount() > 0) {
                eVar.nIj.setVisibility(8);
            } else {
                eVar.nIj.setVisibility(0);
            }
        }
    }
}
