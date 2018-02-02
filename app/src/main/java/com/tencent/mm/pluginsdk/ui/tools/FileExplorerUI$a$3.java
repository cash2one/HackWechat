package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.b;
import java.util.Comparator;

class FileExplorerUI$a$3 implements Comparator<b> {
    final /* synthetic */ a vwO;

    FileExplorerUI$a$3(a aVar) {
        this.vwO = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) obj).vwP.compareTo(((b) obj2).vwP);
    }
}
