package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a;
import java.io.File;
import java.io.FileFilter;

class FileExplorerUI$a$1 implements FileFilter {
    final /* synthetic */ a vwO;

    FileExplorerUI$a$1(a aVar) {
        this.vwO = aVar;
    }

    public final boolean accept(File file) {
        if (file.isHidden()) {
            return false;
        }
        return true;
    }
}
