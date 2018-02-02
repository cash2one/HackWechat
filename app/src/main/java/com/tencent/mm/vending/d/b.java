package com.tencent.mm.vending.d;

import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> zBT;

    public static final class a<T> {
        private ArrayList<T> zBU = new ArrayList();

        private void bZB() {
            if (this.zBU == null) {
                throw new IllegalAccessError();
            }
        }

        public final a<T> s(T... tArr) {
            bZB();
            for (int i = 0; i <= 0; i++) {
                this.zBU.add(tArr[0]);
            }
            return this;
        }

        public final b<T> czO() {
            bZB();
            List list = this.zBU;
            this.zBU = null;
            return new b(list);
        }
    }

    private b(List list) {
        this.zBT = list;
    }

    public final int size() {
        return this.zBT.size();
    }

    public final T get(int i) {
        return this.zBT.get(i);
    }
}
