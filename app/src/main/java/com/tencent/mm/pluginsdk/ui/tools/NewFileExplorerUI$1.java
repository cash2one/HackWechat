package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class NewFileExplorerUI$1 implements OnClickListener {
    final /* synthetic */ NewFileExplorerUI vxQ;

    NewFileExplorerUI$1(NewFileExplorerUI newFileExplorerUI) {
        this.vxQ = newFileExplorerUI;
    }

    public final void onClick(View view) {
        if (NewFileExplorerUI.a(this.vxQ) != null) {
            FileSelectorFolderView a = NewFileExplorerUI.a(this.vxQ);
            a.fr(!a.Od);
        }
    }
}
