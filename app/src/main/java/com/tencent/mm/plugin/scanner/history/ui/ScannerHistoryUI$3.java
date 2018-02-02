package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ScannerHistoryUI$3 implements OnItemLongClickListener {
    final /* synthetic */ ScannerHistoryUI pSn;

    ScannerHistoryUI$3(ScannerHistoryUI scannerHistoryUI) {
        this.pSn = scannerHistoryUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
        } else {
            if (i > 0) {
                i--;
            }
            if (i < ScannerHistoryUI.a(this.pSn).getCount()) {
                ScannerHistoryUI.b(this.pSn, i);
            }
        }
        return true;
    }
}
