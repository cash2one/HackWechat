package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

class FileExplorerUI$3 implements OnClickListener {
    final /* synthetic */ FileExplorerUI vwI;
    final /* synthetic */ File vwJ;

    FileExplorerUI$3(FileExplorerUI fileExplorerUI, File file) {
        this.vwI = fileExplorerUI;
        this.vwJ = file;
    }

    public final void onClick(View view) {
        FileExplorerUI.a(this.vwI, 0);
        FileExplorerUI.a(this.vwI).hTs = this.vwJ.getPath();
        FileExplorerUI.a(this.vwI).e(FileExplorerUI.e(this.vwI).getParentFile(), FileExplorerUI.e(this.vwI));
        FileExplorerUI.a(this.vwI).notifyDataSetInvalidated();
        FileExplorerUI.a(this.vwI).notifyDataSetChanged();
        FileExplorerUI.c(this.vwI).setSelection(0);
    }
}
