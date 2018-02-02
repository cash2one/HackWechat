package com.tencent.mm.ui.base;

import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class v extends u {
    public Queue<View> yeP = new LinkedList();
    public HashMap<Object, Integer> yeQ = new HashMap();
    public SparseArray<Object> yeR = new SparseArray();

    public abstract Object e(int i, View view);

    public abstract MultiTouchImageView qx(int i);

    public Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = null;
        if (this.yeP.size() > 0) {
            view = (View) this.yeP.poll();
        }
        Object e = e(i, view);
        x.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s position:%s", new Object[]{Integer.valueOf(e.hashCode()), ((View) e).getParent(), Integer.valueOf(i)});
        this.yeQ.put(e, Integer.valueOf(i));
        this.yeR.put(i, e);
        if (((View) e).getParent() == null) {
            viewGroup.addView((View) e);
        }
        x.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return e;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        x.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[]{Integer.valueOf(i)});
        x.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[]{Integer.valueOf(obj.hashCode())});
        this.yeP.add((View) obj);
        this.yeQ.remove(obj);
        this.yeR.remove(i);
    }

    public final int k(Object obj) {
        if (this.yeQ.containsKey(obj)) {
            return ((Integer) this.yeQ.get(obj)).intValue();
        }
        return -2;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final View EQ(int i) {
        Object obj = this.yeR.get(i);
        if (obj != null) {
            return (View) obj;
        }
        return null;
    }

    public final void reset() {
        this.yeP.clear();
        this.yeQ.clear();
        this.yeR.clear();
    }

    public int cpM() {
        return -1;
    }

    public int cpN() {
        return -1;
    }

    public void detach() {
        reset();
    }
}
