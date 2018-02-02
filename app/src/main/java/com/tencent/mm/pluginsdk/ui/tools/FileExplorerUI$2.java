package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class FileExplorerUI$2 implements OnItemClickListener {
    final /* synthetic */ FileExplorerUI vwI;

    FileExplorerUI$2(FileExplorerUI fileExplorerUI) {
        this.vwI = fileExplorerUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        File file = (File) FileExplorerUI.a(this.vwI).getItem(i);
        if (1 == FileExplorerUI.b(this.vwI)) {
            if (file.isFile()) {
                ar.Hg();
                c.CU().set(131074, a.b(FileExplorerUI.a(this.vwI)).getAbsolutePath());
                ar.Hg();
                c.CU().set(131073, FileExplorerUI.e(this.vwI).getAbsolutePath());
            } else {
                FileExplorerUI.a(this.vwI, file);
            }
        } else if (FileExplorerUI.b(this.vwI) == 0) {
            if (file.isFile()) {
                ar.Hg();
                c.CU().set(131073, a.b(FileExplorerUI.a(this.vwI)).getAbsolutePath());
                ar.Hg();
                c.CU().set(131074, FileExplorerUI.d(this.vwI).getAbsolutePath());
            } else {
                FileExplorerUI.b(this.vwI, file);
            }
        }
        if (file == a.a(FileExplorerUI.a(this.vwI))) {
            FileExplorerUI.a(this.vwI).e(a.a(FileExplorerUI.a(this.vwI)).getParentFile(), a.a(FileExplorerUI.a(this.vwI)));
        } else if (file.isDirectory()) {
            FileExplorerUI.a(this.vwI).e(a.b(FileExplorerUI.a(this.vwI)), file);
        } else if (file.isFile()) {
            this.vwI.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
            this.vwI.finish();
        }
        FileExplorerUI.ccv();
        FileExplorerUI.a(this.vwI).notifyDataSetChanged();
        FileExplorerUI.c(this.vwI).setSelection(0);
    }
}
