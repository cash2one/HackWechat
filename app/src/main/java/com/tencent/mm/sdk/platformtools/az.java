package com.tencent.mm.sdk.platformtools;

public class az<T> {
    public Object[] ws;
    public int wt;

    public az(int i) {
        if (i <= 0) {
            x.e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
        } else {
            this.ws = new Object[i];
        }
    }

    public T bG() {
        if (this.ws == null || this.wt <= 0) {
            return null;
        }
        int i = this.wt - 1;
        T t = this.ws[i];
        this.ws[i] = null;
        this.wt--;
        return t;
    }

    public boolean j(T t) {
        if (this.ws == null) {
            return false;
        }
        int i;
        if (this.ws != null) {
            for (i = 0; i < this.wt; i++) {
                if (this.ws[i] == t) {
                    i = 1;
                    break;
                }
            }
        }
        boolean z = false;
        if (i != 0) {
            return false;
        }
        if (this.wt >= this.ws.length || this.wt < 0) {
            x.e("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[]{Integer.valueOf(this.wt), Integer.valueOf(this.ws.length)});
            return false;
        }
        this.ws[this.wt] = t;
        this.wt++;
        return true;
    }
}
