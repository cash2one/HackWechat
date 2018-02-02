package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FileExplorerUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FileExplorerUI vwI;

    FileExplorerUI$1(FileExplorerUI fileExplorerUI) {
        this.vwI = fileExplorerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (FileExplorerUI.a(this.vwI).vwL != null) {
            if (1 == FileExplorerUI.b(this.vwI)) {
                FileExplorerUI.a(this.vwI, FileExplorerUI.a(this.vwI).vwL);
            } else if (FileExplorerUI.b(this.vwI) == 0) {
                FileExplorerUI.b(this.vwI, FileExplorerUI.a(this.vwI).vwL);
            }
            FileExplorerUI.a(this.vwI).e(FileExplorerUI.a(this.vwI).vwL.getParentFile(), FileExplorerUI.a(this.vwI).vwL);
            FileExplorerUI.a(this.vwI).notifyDataSetChanged();
            FileExplorerUI.c(this.vwI).setSelection(0);
            FileExplorerUI.ccv();
        } else {
            ar.Hg();
            c.CU().set(131074, FileExplorerUI.d(this.vwI).getAbsolutePath());
            ar.Hg();
            c.CU().set(131073, FileExplorerUI.e(this.vwI).getAbsolutePath());
            this.vwI.finish();
        }
        return true;
    }
}
