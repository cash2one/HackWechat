package com.tencent.mm.z;

import com.tencent.mm.kernel.api.b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class c$3 implements b {
    final /* synthetic */ c heJ;

    c$3(c cVar) {
        this.heJ = cVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/"});
        return linkedList;
    }
}
