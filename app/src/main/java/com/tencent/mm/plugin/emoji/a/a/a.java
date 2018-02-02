package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String gHl = "lock";
    public AbsListView luA;
    public c luB;
    public com.tencent.mm.plugin.emoji.model.h.a luC;
    protected volatile boolean luD = false;
    private int luE = 0;
    private int luF = 0;
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> lum;
    public Context mContext;

    public abstract int aAE();

    public abstract int aAF();

    public abstract int aAG();

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract com.tencent.mm.plugin.emoji.a.a c(Context context, View view);

    public abstract void oD(int i);

    public abstract void oE(int i);

    public abstract void oF(int i);

    public /* synthetic */ Object getItem(int i) {
        return oG(i);
    }

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.lum = new HashMap();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.luB != cVar) {
            this.luB = cVar.aAJ();
            notifyDataSetChanged();
        }
    }

    public void aAD() {
        if (this.lum != null) {
            this.lum.clear();
        }
        super.notifyDataSetChanged();
        this.luD = true;
    }

    public void notifyDataSetChanged() {
        Object[] objArr;
        int i;
        this.luD = false;
        if (this.luB != null) {
            this.luB.notifyDataSetChanged();
            objArr = new Object[1];
            i = this.luE;
            this.luE = i + 1;
            objArr[0] = Integer.valueOf(i);
            x.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.luF;
        this.luF = i + 1;
        objArr[0] = Integer.valueOf(i);
        x.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        aAD();
    }

    public final void b(f fVar) {
        ag.y(new 1(this, fVar));
    }

    public c a(f fVar) {
        return new c(fVar);
    }

    public int getCount() {
        return this.luB == null ? 0 : this.luB.size();
    }

    public f oG(int i) {
        return this.luB == null ? null : this.luB.oJ(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f oG = oG(i);
        if (aVar == null) {
            aVar = c(this.mContext, view);
            view = aVar.aAA();
            this.lum.put(a(oG), aVar);
        } else if (!bh.ov(a(oG))) {
            if (this.lum.containsValue(aVar)) {
                this.lum.remove(aVar.aAt());
            }
            this.lum.put(a(oG), aVar);
        }
        aVar.mPosition = i;
        aVar.ltl = oG;
        View b = b(i, view, viewGroup);
        aVar.aAz();
        return b;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.luM == com.tencent.mm.plugin.emoji.a.a.f.a.luV) {
            return fVar.luO.fgt + "_cell";
        }
        return fVar.luN.vIR;
    }

    public void clear() {
        if (this.lum != null) {
            this.lum.clear();
            this.lum = null;
        }
        if (this.luB != null) {
            this.luB.clear();
            this.luB = null;
        }
        this.luD = false;
    }

    public void bc(String str, int i) {
        if (this.lum != null && this.luB != null && str != null) {
            f xU = this.luB.xU(str);
            if (xU != null) {
                a(xU, str, i);
            }
            if (!(xU == null || this.luB == null || xU.mStatus != -1)) {
                x.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                xU.a(this.luB.luK, this.luB.xY(str), this.luB.xW(str));
            }
            com.tencent.mm.plugin.emoji.a.a xT = xT(str);
            if (xT != null) {
                String aAt = xT.aAt() == null ? null : xT.aAt();
                if (aAt != null && aAt.equals(str)) {
                    xT.aAz();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a xT(String str) {
        if (this.lum == null) {
            return null;
        }
        return (com.tencent.mm.plugin.emoji.a.a) this.lum.get(str);
    }

    public final void bd(String str, int i) {
        if (this.lum != null && this.luB != null && str != null) {
            f xU = this.luB.xU(str);
            if (xU != null) {
                if (i >= 0 && i < 100) {
                    a(xU, str, 6);
                    xU.sm = i;
                }
                if (i >= 100) {
                    a(xU, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a xT = xT(str);
            if (xT != null) {
                String aAt = xT.aAt() == null ? null : xT.aAt();
                if (aAt != null && aAt.equals(str)) {
                    xT.aAz();
                }
            }
        }
    }

    public final void a(f fVar, String str, int i) {
        if (fVar != null && str != null) {
            fVar.eQ(i);
            ak akVar = (ak) this.luB.luI.get(str);
            if (akVar != null) {
                akVar.Do(i);
            }
        }
    }

    public final void amg() {
        if (this.luD) {
            super.notifyDataSetChanged();
        }
    }
}
