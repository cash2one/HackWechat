package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public abstract class b<T> extends BaseAdapter {
    private static int nkY = 500;
    protected Context mContext;
    protected LinkedList<T> ndF;
    a nkV;
    protected boolean nkW = false;
    private f<String, Bitmap> nkX;
    private ak nkZ = new ak(new 2(this), false);
    private final com.tencent.mm.sdk.e.j.a nla = new 3(this);

    public interface a {
        void qN(int i);
    }

    public b(Context context) {
        this.mContext = context;
        this.ndF = new LinkedList();
        this.nkX = new f(20);
        an.bin().c(this.nla);
    }

    public void O(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.ndF.addAll(linkedList);
            if (this.nkV != null) {
                this.nkV.qN(this.ndF.size());
            }
            super.notifyDataSetChanged();
        } else if (this.nkV != null) {
            this.nkV.qN(this.ndF.size());
        }
    }

    public void P(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.ndF = linkedList;
            if (this.nkV != null) {
                this.nkV.qN(this.ndF.size());
            }
            super.notifyDataSetChanged();
        } else if (this.nkV != null) {
            this.nkV.qN(this.ndF.size());
        }
    }

    protected final void remove(int i) {
        if (this.ndF != null && i >= 0 && i <= this.ndF.size() - 1) {
            this.ndF.remove(i);
            if (this.nkV != null) {
                this.nkV.qN(this.ndF.size());
            }
            super.notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.ndF != null) {
            this.ndF.clear();
        }
        if (this.nkX != null) {
            this.nkX.a(new 1(this));
        }
        this.nkX = null;
        an.bin().j(this.nla);
    }

    protected final Bitmap Cd(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.nkX.bt(str)) {
            bitmap = (Bitmap) this.nkX.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = g.b(str, 1, com.tencent.mm.bv.a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.nkX.l(str, bitmap);
        return bitmap;
    }

    public int getCount() {
        return this.ndF.size();
    }

    public Object getItem(int i) {
        return this.ndF.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
