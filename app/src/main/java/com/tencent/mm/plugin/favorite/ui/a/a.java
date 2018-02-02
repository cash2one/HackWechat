package com.tencent.mm.plugin.favorite.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.n;
import java.util.Set;

public abstract class a extends BaseAdapter implements OnItemClickListener {
    protected long lastUpdateTime;
    protected Set<Integer> muh;
    protected n mui;
    protected a muj;
    protected int type;

    public abstract void aJt();

    public abstract void aJu();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long aJr() {
        return this.lastUpdateTime;
    }

    public final void a(a aVar) {
        this.muj = aVar;
    }

    public final void aJs() {
        if (this.muj != null) {
            this.muj.aJq();
        }
    }

    public final void e(Set<Integer> set) {
        this.muh = set;
    }

    public final void a(n nVar) {
        this.mui = nVar;
    }
}
