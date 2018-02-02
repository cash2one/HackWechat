package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ScannerHistoryUI$2 implements OnItemClickListener {
    final /* synthetic */ ScannerHistoryUI pSn;

    ScannerHistoryUI$2(ScannerHistoryUI scannerHistoryUI) {
        this.pSn = scannerHistoryUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
            return;
        }
        if (i > 0) {
            i--;
        }
        ScannerHistoryUI.a(this.pSn, i);
    }
}
