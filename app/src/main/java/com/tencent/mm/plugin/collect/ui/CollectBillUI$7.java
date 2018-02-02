package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.widget.AdapterView.AdapterContextMenuInfo;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.ui.base.p.d;

class CollectBillUI$7 implements d {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$7(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 0) {
            a aVar = (a) CollectBillUI.b(this.llV).getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
            if (aVar != null) {
                CollectBillUI.a(this.llV, aVar.lid, aVar.timestamp);
            }
        }
    }
}
