package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView extends FrameLayout {
    private EmojiInfo lBr;
    private int mStatus = -1;
    private TextView shG;
    private int vsI;
    private int vsJ;
    private int vsK;
    private int vsL;
    private int vsM;
    public ChattingEmojiView vsN;
    private ProgressBar vsO;
    private LayoutParams vsP;
    LayoutParams vsQ;

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        this.vsI = getContext().getResources().getDimensionPixelSize(c.lnJ);
        this.vsJ = getContext().getResources().getDimensionPixelSize(c.lIW);
        this.vsL = getContext().getResources().getDimensionPixelSize(c.lIZ);
        this.vsM = getContext().getResources().getDimensionPixelSize(c.lIY);
        this.vsN = new ChattingEmojiView(getContext());
        this.vsO = new ProgressBar(getContext());
        this.vsO.setIndeterminateDrawable(getResources().getDrawable(d.bEO));
        this.shG = new TextView(getContext());
        this.shG.setText(h.lJN);
        this.shG.setTextColor(getResources().getColor(b.lIS));
        this.vsP = new LayoutParams(-2, -2);
        this.vsQ = new LayoutParams(-2, -2);
        this.vsP.gravity = 17;
        addView(this.vsO, this.vsP);
        addView(this.shG, this.vsP);
    }

    public final void a(EmojiInfo emojiInfo, long j) {
        a(emojiInfo, j, new aj(""));
    }

    public final void a(EmojiInfo emojiInfo, long j, aj ajVar) {
        x.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
        this.lBr = emojiInfo;
        if (this.lBr.Yz()) {
            Cu(2);
            MMAnimateView mMAnimateView = this.vsN;
            boolean z = !ajVar.hVA;
            int e = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().e(emojiInfo);
            int[] f = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().f(emojiInfo);
            String name = emojiInfo.getName();
            String valueOf = String.valueOf(j + emojiInfo.getName());
            Drawable dVar;
            if (bh.ov(valueOf)) {
                dVar = new com.tencent.mm.plugin.gif.d(mMAnimateView.getContext(), false, z, e, f, name);
                dVar.start();
                mMAnimateView.setImageDrawable(dVar);
                return;
            }
            mMAnimateView.ltJ = valueOf;
            com.tencent.mm.plugin.gif.b aSk = com.tencent.mm.plugin.gif.b.aSk();
            Context context = mMAnimateView.getContext();
            if (TextUtils.isEmpty(name)) {
                dVar = null;
            } else {
                if (aSk.nyz.get(valueOf) == null || ((WeakReference) aSk.nyz.get(valueOf)).get() == null) {
                    dVar = null;
                } else {
                    dVar = (com.tencent.mm.plugin.gif.d) ((WeakReference) aSk.nyz.get(valueOf)).get();
                }
                if (dVar == null) {
                    dVar = new com.tencent.mm.plugin.gif.d(context, false, z, e, f, name);
                    aSk.nyz.put(valueOf, new WeakReference(dVar));
                }
            }
            if (z == dVar.mIsPlaying) {
                dVar.start();
            } else {
                dVar.lHX = 0;
                dVar.nzo = 0;
                dVar.mIsPlaying = true;
                dVar.start();
            }
            mMAnimateView.setImageDrawable(dVar);
        } else if (this.lBr.ckv()) {
            Cu(2);
            this.vsN.a(EmojiInfo.bk(getContext(), emojiInfo.getName()), String.valueOf(j));
        } else {
            String ckB = this.lBr.ckB();
            if (e.bN(ckB) > 0) {
                Cu(2);
                byte[] d = e.d(ckB, 0, 10);
                if (d == null || p.bp(d)) {
                    this.vsN.cQ(ckB, String.valueOf(j));
                    return;
                } else {
                    this.vsN.a(this.lBr, ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().a(this.lBr), String.valueOf(j));
                    return;
                }
            }
            if (emojiInfo.field_state == EmojiInfo.xAu) {
                Cu(0);
                cch();
            } else {
                Cu(3);
                cch();
            }
            this.vsN.setImageBitmap(null);
        }
    }

    public final void setImageBitmap(Bitmap bitmap) {
        Cu(2);
        if (this.vsN != null && bitmap != null && !bitmap.isRecycled()) {
            bitmap.setDensity(320);
            this.vsN.setImageBitmap(bitmap);
        }
    }

    public boolean performClick() {
        if (this.mStatus == 3) {
            Cu(1);
            cch();
            return true;
        } else if (this.mStatus == 2) {
            return super.performClick();
        } else {
            x.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            return true;
        }
    }

    private void cch() {
        com.tencent.mm.sdk.b.b cnVar = new cn();
        cnVar.fqL.fqM = this.lBr;
        cnVar.fqL.scene = 0;
        a.xef.m(cnVar);
    }

    private void Cu(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                this.vsO.setVisibility(0);
                this.shG.setVisibility(4);
                this.vsN.setVisibility(4);
                setBackgroundResource(d.bHb);
                return;
            case 1:
                this.vsO.setVisibility(0);
                this.shG.setVisibility(4);
                this.vsN.setVisibility(4);
                setBackgroundResource(d.lJd);
                return;
            case 2:
                this.vsN.setVisibility(0);
                this.vsO.setVisibility(4);
                this.shG.setVisibility(4);
                setBackgroundResource(d.bHb);
                return;
            case 3:
                Drawable drawable = getResources().getDrawable(d.lJg);
                drawable.setBounds(0, 0, this.vsK, this.vsK);
                x.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[]{Integer.valueOf(this.vsK), Integer.valueOf(hashCode())});
                this.shG.setCompoundDrawables(null, drawable, null, null);
                this.shG.setText(h.lJN);
                this.shG.setVisibility(0);
                this.vsO.setVisibility(4);
                this.vsN.setVisibility(4);
                setBackgroundResource(d.lJd);
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            int i3;
            if (this.lBr == null || this.lBr.field_height == 0) {
                i3 = this.vsJ;
            } else {
                i3 = (int) (((float) this.lBr.field_height) * this.vsN.aSl());
                if (i3 < this.vsJ) {
                    i3 = this.vsJ;
                }
            }
            if (i3 > this.vsI) {
                i3 = this.vsI;
            }
            this.vsK = this.vsL;
            if (i3 >= this.vsJ && i3 < this.vsJ + (this.vsL - this.vsM)) {
                this.vsK = this.vsM + (i3 - this.vsJ);
            }
            int i4 = this.vsI;
            setMeasuredDimension(i4, i3);
            super.onMeasure(MeasureSpec.makeMeasureSpec(i4, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
            Cu(this.mStatus);
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
