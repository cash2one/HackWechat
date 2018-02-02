package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> zRn = new ArrayList();

    public String toString() {
        return this.zRn.toString();
    }

    public final void dF(List<ExpressItem> list) {
        this.zRn.add(list);
    }
}
