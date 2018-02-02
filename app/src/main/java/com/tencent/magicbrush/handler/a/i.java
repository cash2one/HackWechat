package com.tencent.magicbrush.handler.a;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.c.f;
import com.tencent.magicbrush.handler.a.j.a;
import java.nio.FloatBuffer;

public final class i implements c {
    private b bnN;
    private g bnX;
    private e bnY;
    private f bof;
    private j bog;
    private a boh;
    private boolean boi = false;

    public i(b bVar, a aVar) {
        this.bnN = bVar;
        this.boh = aVar;
    }

    public final void init(int i, int i2) {
        f.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + i + "], m_atlasHeight = [" + i2 + "]", new Object[0]);
        this.bnY = new e(i, i2);
        this.bof = new f(this.bnN);
        this.bnX = new g(this.bnY, this.boh);
        this.bog = new j(a.bom);
    }

    public final String loadFont(String str) {
        f fVar = this.bof;
        if (str == null || str.length() == 0 || fVar.bnN == null) {
            return null;
        }
        Typeface bA = fVar.bnN.bA(str);
        if (bA == null) {
            return null;
        }
        String str2 = "font" + bA.hashCode();
        fVar.bnM.put(str2, bA);
        return str2;
    }

    public final void useFont(String str, float f, boolean z, boolean z2) {
        Typeface create;
        a f2 = a.f(z, z2);
        j jVar = this.bog;
        f fVar = this.bof;
        a aVar = f2 == null ? a.bom : f2;
        if (str == null || str.length() == 0) {
            create = Typeface.create(null, aVar.boq);
        } else {
            create = (Typeface) fVar.bnM.get(str);
            if (create == null) {
                create = Typeface.create(str, aVar.boq);
            } else if (create.getStyle() != aVar.boq) {
                create = Typeface.create(create, aVar.boq);
            }
        }
        jVar.boj = create;
        this.bog.azb = f;
        this.bog.bol = f2;
    }

    public final void enableStroke(boolean z) {
        this.bog.bok = z;
    }

    public final void setStrokeWidth(float f) {
        this.bog.strokeWidth = f;
    }

    public final FloatBuffer drawText(String str) {
        this.bnX.a(this.bog);
        FloatBuffer bB = this.bnX.bB(str);
        if (bB == null) {
            f.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bog});
            clear();
            bB = this.bnX.bB(str);
        }
        if (bB != null) {
            return bB;
        }
        f.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bog});
        return null;
    }

    public final Bitmap getBitmapAtlas() {
        if (this.bnY != null) {
            return this.bnY.bnI;
        }
        return null;
    }

    public final int[] checkAndFlushDirtySignal() {
        if (this.bnY == null) {
            return null;
        }
        int i;
        e eVar = this.bnY;
        if (eVar.bnK.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        eVar.bnL[0] = eVar.bnK.left;
        eVar.bnL[1] = eVar.bnK.top;
        eVar.bnL[2] = eVar.bnK.right;
        eVar.bnL[3] = eVar.bnK.bottom;
        eVar.bnK.setEmpty();
        return eVar.bnL;
    }

    public final boolean checkAndFlushClearSignal() {
        boolean z = this.boi;
        this.boi = false;
        return z;
    }

    private void clear() {
        f.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
        if (this.bnY != null) {
            e eVar = this.bnY;
            eVar.bnK.setEmpty();
            eVar.bnJ.reset();
            if (eVar.bnI != null) {
                eVar.bnI.eraseColor(0);
            }
        }
        if (this.bnX != null) {
            g gVar = this.bnX;
            if (gVar.bnP != null) {
                for (k offer : gVar.bnP.values()) {
                    gVar.bnQ.bnW.offer(offer);
                }
                gVar.bnP.clear();
            }
        }
        this.boi = true;
    }

    public final float measureText(String str) {
        this.bnX.a(this.bog);
        float bD = this.bnX.bD(str);
        if (bD == -1.0f) {
            f.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bog});
            clear();
            bD = this.bnX.bD(str);
        }
        if (bD != -1.0f) {
            return bD;
        }
        f.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bog});
        return 0.0f;
    }

    public final void release() {
        if (this.bnY != null) {
            e eVar = this.bnY;
            if (eVar.bnI != null) {
                eVar.bnI.recycle();
            }
            this.bnY = null;
        }
        if (this.bof != null) {
            f fVar = this.bof;
            if (fVar.bnM != null) {
                fVar.bnM.clear();
                fVar.bnM = null;
            }
            this.bof = null;
        }
        if (this.bnX != null) {
            g gVar = this.bnX;
            if (gVar.bnO != null) {
                gVar.bnO = null;
            }
            this.bnX = null;
        }
    }

    public final float getTextLineHeight(String str) {
        if (str == null || str.length() == 0 || this.bof == null || this.bnX == null) {
            return 0.0f;
        }
        this.bnX.a(this.bog);
        h hVar = this.bnX.bnO;
        if (hVar.boe != null) {
            return (hVar.boe.descent - hVar.boe.ascent) + 1.0f;
        }
        return 0.0f;
    }
}
