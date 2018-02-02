package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n extends s {
    public LinkedList<m> rgv = new LinkedList();
    public int rgx = 0;
    public boolean rgy = true;

    protected final List<s> bwM() {
        List<s> arrayList = new ArrayList(super.bwM());
        if (this.rgv != null) {
            Iterator it = this.rgv.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar.rgv != null) {
                    arrayList.addAll(mVar.rgv);
                }
            }
        }
        return arrayList;
    }
}
