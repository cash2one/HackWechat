package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class o<T> extends BaseAdapter implements a, b {
    public Context context;
    public int count;
    private af pFW = new af(Looper.getMainLooper());
    private Cursor xBw = null;
    public T xIg;
    public Map<Integer, T> xIh = null;
    public a xIi;
    private int xIj = 0;
    private int xIk = 0;
    private int xIl = 0;
    private Runnable xIm = new 1(this);

    public abstract void Xy();

    public abstract void Xz();

    public abstract T a(T t, Cursor cursor);

    static /* synthetic */ int b(o oVar) {
        int i = oVar.xIl + 1;
        oVar.xIl = i;
        return i;
    }

    public o(Context context, T t) {
        this.xIg = t;
        this.context = context;
        this.count = -1;
    }

    public final Cursor getCursor() {
        if (this.xBw == null || this.xBw.isClosed()) {
            Xz();
            Assert.assertNotNull(this.xBw);
        }
        return this.xBw;
    }

    public final void setCursor(Cursor cursor) {
        this.xBw = cursor;
        this.count = -1;
    }

    public final void lU(boolean z) {
        if (z) {
            if (this.xIh == null) {
                this.xIh = new HashMap();
            }
        } else if (this.xIh != null) {
            this.xIh.clear();
            this.xIh = null;
        }
    }

    public void aUn() {
        if (this.xIh != null) {
            this.xIh.clear();
        }
        if (this.xBw != null) {
            this.xBw.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + aRF();
    }

    public final int aCQ() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i) {
        return 0;
    }

    public void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public void a(String str, l lVar) {
        cmO();
    }

    private void cmO() {
        x.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        if (this.xIi != null) {
            this.xIi.Xw();
        }
        aUn();
        Xy();
        if (this.xIi != null) {
            this.xIi.Xv();
        }
    }

    public T getItem(int i) {
        if (qY(i)) {
            return aRG();
        }
        T t;
        if (this.xIh != null) {
            t = this.xIh.get(Integer.valueOf(i));
            if (t != null) {
                return t;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.xIh == null) {
            return a(this.xIg, getCursor());
        }
        t = a(null, getCursor());
        this.xIh.put(Integer.valueOf(i), t);
        return t;
    }

    public boolean qY(int i) {
        return i >= this.count && i < this.count + aRF();
    }

    public int aRF() {
        return 0;
    }

    public T aRG() {
        return this.xIg;
    }
}
