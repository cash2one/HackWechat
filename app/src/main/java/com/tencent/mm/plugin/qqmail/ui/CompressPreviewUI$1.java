package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.b;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;

class CompressPreviewUI$1 implements OnItemClickListener {
    final /* synthetic */ CompressPreviewUI prM;

    CompressPreviewUI$1(CompressPreviewUI compressPreviewUI) {
        this.prM = compressPreviewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CompressPreviewUI$a vc = CompressPreviewUI.a(this.prM).vc(i);
        String str = vc.id;
        b a = CompressPreviewUI.a(this.prM);
        if (str.equals(a.prR == null ? null : a.prR.id)) {
            CompressPreviewUI.a(this.prM, CompressPreviewUI.a(this.prM).bkM());
        } else if (vc.bkL()) {
            CompressPreviewUI.a(this.prM, vc.id);
        } else if (vc.prQ) {
            String[] strArr = new String[]{"mailid=" + CompressPreviewUI.b(this.prM), "attachid=" + vc.id, "compressfilepath=" + CompressPreviewUI.c(this.prM), "texttype=html"};
            Intent intent = new Intent(this.prM, MailWebViewUI.class);
            intent.putExtra("uri", "/cgi-bin/viewdocument");
            intent.putExtra("params", strArr);
            intent.putExtra("baseurl", p.bkn());
            intent.putExtra("method", "get");
            intent.putExtra("singleColumn", FileExplorerUI.SN(vc.name));
            intent.putExtra("title", this.prM.getString(R.l.eCe));
            this.prM.startActivity(intent);
        }
    }
}
