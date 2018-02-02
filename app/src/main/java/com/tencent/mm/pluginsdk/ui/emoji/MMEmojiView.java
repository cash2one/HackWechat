package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView extends MMAnimateView {
    private EmojiInfo lBr;
    private int mScreenWidth;
    boolean vsA;
    public boolean vsB;
    int vsy;
    private int vsz;

    public MMEmojiView(Context context) {
        this(context, null);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vsA = false;
        this.vsB = false;
        init(context);
    }

    private void init(Context context) {
        this.vsy = context.getResources().getDimensionPixelSize(c.lnJ);
        this.vsz = context.getResources().getDimensionPixelSize(c.lIX);
        this.mScreenWidth = a.eA(context);
    }

    public final void a(EmojiInfo emojiInfo, String str) {
        this.lBr = emojiInfo;
        String ckB = emojiInfo.ckB();
        if ((emojiInfo.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
            cQ(ckB, str);
        } else if (b.aSk().Cp(str) != null) {
            setImageDrawable(b.aSk().Cp(str));
        } else {
            a(this.lBr, ((PluginEmoji) g.k(PluginEmoji.class)).getProvider().a(this.lBr), str);
        }
    }

    public final void a(EmojiInfo emojiInfo, byte[] bArr, String str) {
        this.lBr = emojiInfo;
        try {
            if (!bh.bw(bArr)) {
                Drawable fVar;
                if (bh.ov(str)) {
                    if (p.bq(bArr) && ((PluginEmoji) g.k(PluginEmoji.class)).getProvider().aBf()) {
                        fVar = new f(bArr);
                        this.vsB = true;
                    } else {
                        x.v("MicroMsg.emoji.MMEmojiView", "set with gif");
                        fVar = new com.tencent.mm.plugin.gif.c(bArr);
                    }
                    if (!fVar.isRunning()) {
                        fVar.reset();
                    }
                } else {
                    this.ltJ = str;
                    fVar = b.aSk().o(this.ltJ, bArr);
                }
                setImageDrawable(fVar);
                return;
            }
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                x.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bl = d.bl(bArr);
                if (bl != null) {
                    bl.setDensity(320);
                    setImageBitmap(bl);
                    return;
                }
                x.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                if (this.lBr != null) {
                    this.lBr.ckt();
                    x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
                init();
                return;
            }
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e.toString());
            if (this.lBr != null) {
                this.lBr.ckt();
                x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
        } catch (IOException e2) {
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
        } catch (NullPointerException e3) {
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e3.toString());
        }
        if (this.lBr != null) {
            this.lBr.ckt();
            x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        }
        init();
    }

    protected void onMeasure(int i, int i2) {
        float f;
        int i3 = 0;
        super.onMeasure(i, i2);
        int intrinsicWidth = getDrawable() == null ? 0 : getDrawable().getIntrinsicWidth();
        if (getDrawable() != null) {
            i3 = getDrawable().getIntrinsicHeight();
        }
        if (this.lBr != null && intrinsicWidth == 0 && r1 == 0) {
            intrinsicWidth = (int) (((float) this.lBr.field_width) * aSl());
            i3 = (int) (((float) this.lBr.field_height) * aSl());
        }
        if (i3 < this.vsz || intrinsicWidth < this.vsz) {
            if (intrinsicWidth < i3) {
                f = ((float) this.vsz) / ((float) intrinsicWidth);
                intrinsicWidth = this.vsz;
                i3 = (int) (((float) i3) * f);
            } else if (i3 < intrinsicWidth) {
                f = ((float) this.vsz) / ((float) i3);
                i3 = this.vsz;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                i3 = this.vsz;
                intrinsicWidth = this.vsz;
            }
        }
        if (this.vsA) {
            if (intrinsicWidth > this.vsy || i3 > this.vsy) {
                if (intrinsicWidth > i3) {
                    f = ((float) this.vsy) / ((float) intrinsicWidth);
                    intrinsicWidth = this.vsy;
                    i3 = (int) (((float) i3) * f);
                } else if (i3 > intrinsicWidth) {
                    f = ((float) this.vsy) / ((float) i3);
                    i3 = this.vsy;
                    intrinsicWidth = (int) (((float) intrinsicWidth) * f);
                } else {
                    intrinsicWidth = this.vsy;
                    i3 = this.vsy;
                }
            }
        } else if (intrinsicWidth > this.mScreenWidth || i3 > this.mScreenWidth) {
            if (intrinsicWidth > i3) {
                f = ((float) this.mScreenWidth) / ((float) intrinsicWidth);
                intrinsicWidth = this.mScreenWidth;
                i3 = (int) (((float) i3) * f);
            } else if (i3 > intrinsicWidth) {
                f = ((float) this.mScreenWidth) / ((float) i3);
                i3 = this.mScreenWidth;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicWidth = this.mScreenWidth;
                i3 = this.mScreenWidth;
            }
        }
        setMeasuredDimension(intrinsicWidth, i3);
    }
}
