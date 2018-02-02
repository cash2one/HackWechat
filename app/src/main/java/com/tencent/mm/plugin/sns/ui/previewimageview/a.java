package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;

public abstract class a extends BaseAdapter implements d {
    private int rQh = 0;
    HashMap<Object, Integer> rQi = new HashMap();

    public final boolean hasStableIds() {
        return true;
    }

    protected final void bM(Object obj) {
        HashMap hashMap = this.rQi;
        int i = this.rQh;
        this.rQh = i + 1;
        hashMap.put(obj, Integer.valueOf(i));
    }

    protected final void bY(List<?> list) {
        for (Object bM : list) {
            bM(bM);
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.rQi.size()) {
            return -1;
        }
        return (long) ((Integer) this.rQi.get(getItem(i))).intValue();
    }
}
