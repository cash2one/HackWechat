package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class h extends a {
    public int lua = 0;
    private int luf;
    private int lug;
    private int luh;
    private int lui;
    private int luj;
    private boolean luk;
    public a lul;
    private HashMap<String, b> lum;
    private Context mContext;
    private int mNumColumns = 3;

    public h(Context context) {
        super(context);
        this.mContext = context;
        this.luk = false;
        this.luf = this.mContext.getResources().getDimensionPixelSize(R.f.bvJ);
        this.lug = this.mContext.getResources().getDimensionPixelSize(R.f.bur);
        this.luh = this.mContext.getResources().getDimensionPixelSize(R.f.bxa);
        this.lui = com.tencent.mm.bv.a.eA(this.mContext);
        this.luj = (int) (((float) (this.lui - (this.mNumColumns * this.luh))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final int aAI() {
        if (!this.luk) {
            return super.getCount();
        }
        if (this.lua == 0) {
            return 0;
        }
        if (this.lua <= 0 || super.getCount() <= this.lua) {
            return super.getCount();
        }
        return this.lua;
    }

    public final int getCount() {
        if (!this.luk) {
            int aAI = aAI();
            if (aAI > this.lua) {
                return (int) Math.ceil((double) (((float) (aAI - this.lua)) / ((float) this.mNumColumns)));
            }
            return 0;
        } else if (this.lua == 0) {
            return 0;
        } else {
            if (this.lua <= 0 || aAI() <= this.lua) {
                return (int) Math.ceil((double) (((float) aAI()) / ((float) this.mNumColumns)));
            }
            return (int) Math.ceil((double) (((float) this.lua) / ((float) this.mNumColumns)));
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setBackgroundResource(R.g.bHb);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.lug);
            b bVar2 = new b(this);
            bVar2.lup = view;
            view.setTag(bVar2);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.luj;
                bVar2.lup.addView(new b(this.mContext, R.i.dfV).ltB, i2, layoutParams2);
            }
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4;
            if (this.luk) {
                i4 = this.mNumColumns * i;
            } else {
                i4 = (this.mNumColumns * i) + this.lua;
            }
            i4 += i3;
            final b bVar3 = new b(this.mContext, bVar.lup.getChildAt(i3));
            bVar3.ltB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h luo;

                public final void onClick(View view) {
                    if (this.luo.lul != null) {
                        this.luo.lul.mv(i4);
                    }
                }
            });
            f oG = oG(i4);
            if (i4 > aAI() - 1 || oG == null) {
                bVar3.ltB.setClickable(false);
                bVar3.ltB.setVisibility(8);
                bVar3.ltL.setBackgroundDrawable(null);
            } else {
                if (this.lum == null) {
                    this.lum = new HashMap();
                }
                if (this.lum.containsValue(bVar3)) {
                    this.lum.remove(bVar3.ltJ);
                }
                bVar3.ltJ = a(oG);
                this.lum.put(a(oG), bVar3);
                bVar3.ltB.setVisibility(0);
                bVar3.kTq.setText(oG.luN.war);
                o.PA().a(oG.luN.nfT, bVar3.ltK, com.tencent.mm.plugin.emoji.e.f.cg(oG.luN.vIR, oG.luN.nfT));
                bVar3.ltL.setBackgroundResource(R.g.bBS);
                bVar3.ltB.setClickable(true);
                a(bVar3, oG.mStatus);
            }
        }
        return view;
    }

    private void a(b bVar, int i) {
        switch (i) {
            case 7:
                bVar.kTq.setTextColor(this.mContext.getResources().getColor(R.e.bsK));
                Drawable drawable = this.mContext.getResources().getDrawable(R.k.dyw);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bVar.kTq.setCompoundDrawables(null, null, drawable, null);
                return;
            default:
                bVar.kTq.setTextColor(this.mContext.getResources().getColor(R.e.btv));
                bVar.kTq.setCompoundDrawables(null, null, null, null);
                x.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    protected final a c(Context context, View view) {
        return null;
    }

    public final int aAE() {
        return this.lua;
    }

    public final void oD(int i) {
        this.lua = i;
    }

    public final int aAF() {
        return 0;
    }

    public final void oE(int i) {
    }

    public final int aAG() {
        return 0;
    }

    public final void oF(int i) {
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public final void bc(String str, int i) {
        if (this.lum == null) {
            x.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            return;
        }
        b bVar = (b) this.lum.get(str);
        f xU = this.luB.xU(str);
        if (xU != null) {
            a(xU, str, i);
        }
        if (!(xU == null || this.luB == null || xU.mStatus != -1)) {
            x.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            xU.a(this.luB.luK, this.luB.xY(str), this.luB.xW(str));
        }
        if (bVar == null) {
            x.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
        } else {
            a(bVar, i);
        }
    }
}
