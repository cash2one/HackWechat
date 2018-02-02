package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ah$b {
    final /* synthetic */ ah rvK;
    ArrayList<String> rvO = new ArrayList();
    Map<String, Boolean> rvP = new HashMap();
    Map<String, Integer> rvQ = new HashMap();

    ah$b(ah ahVar) {
        this.rvK = ahVar;
    }

    public final ah$b m(String str, int i, boolean z) {
        this.rvO.add(str);
        this.rvQ.put(str, Integer.valueOf(i));
        this.rvP.put(str, Boolean.valueOf(z));
        return this;
    }

    public final void P(ArrayList<String> arrayList) {
        this.rvP.clear();
        if (arrayList == null) {
            this.rvO = new ArrayList();
            return;
        }
        this.rvO = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.rvP.put((String) it.next(), Boolean.valueOf(false));
        }
    }

    public final String toString() {
        Iterator it = this.rvO.iterator();
        String str = "";
        while (it.hasNext()) {
            String str2 = (String) it.next();
            int i = 0;
            if (this.rvQ != null) {
                i = ((Integer) this.rvQ.get(str2)).intValue();
            }
            str = str + str2 + "," + i + ";";
        }
        return str;
    }

    public final ah$b LV(String str) {
        try {
            for (String split : str.split(";")) {
                String[] split2 = split.split(",");
                this.rvO.add(split2[0]);
                this.rvQ.put(split2[0], Integer.valueOf(bh.getInt(split2[1], 0)));
            }
        } catch (Exception e) {
        }
        return this;
    }
}
