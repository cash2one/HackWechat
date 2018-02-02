package com.tencent.magicbrush.handler.a;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.handler.a.j.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class g {
    h bnO;
    HashMap<String, k> bnP;
    a bnQ;
    private FloatBuffer bnR;
    private List<k> bnS;
    private j bnT;
    private a bnU;
    private StringBuilder bnV = new StringBuilder();

    g(e eVar, a aVar) {
        this.bnU = aVar;
        this.bnO = new h(eVar, this);
        this.bnP = new HashMap();
        this.bnQ = new a();
        this.bnS = new ArrayList();
    }

    final FloatBuffer bB(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        List bC = bC(str);
        if (bC == null || bC.size() == 0) {
            return null;
        }
        int max = (Math.max(str.length(), 10) * 36) + 16;
        if (this.bnR == null || this.bnR.capacity() * 4 < max) {
            this.bnR = ByteBuffer.allocateDirect(max).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.bnR.clear();
        FloatBuffer floatBuffer = this.bnR;
        float v = h.v(bC);
        FontMetrics fontMetrics = this.bnO.boe;
        floatBuffer.put(v).put(fontMetrics.ascent).put(fontMetrics.descent).put(fontMetrics.descent - fontMetrics.ascent);
        k.a(floatBuffer, bC);
        floatBuffer.flip();
        this.bnS.clear();
        return floatBuffer;
    }

    private List<k> bC(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.bnS.clear();
        int i = 0;
        while (i < str.length()) {
            int i2;
            int n = this.bnU == null ? 0 : this.bnU.n(str, i);
            k kVar;
            int ceil;
            k kVar2;
            if (n <= 0) {
                char charAt = str.charAt(i);
                if (this.bnT == null) {
                    kVar = null;
                } else {
                    Object obj;
                    if (this.bnT == null) {
                        obj = null;
                    } else {
                        this.bnV.setLength(0);
                        StringBuilder append = this.bnV.append(charAt).append("|").append(this.bnT.azb).append("|").append(this.bnT.boj == null ? "null" : Integer.valueOf(this.bnT.boj.hashCode()));
                        if (this.bnT.bok) {
                            append.append("|").append(this.bnT.strokeWidth);
                        }
                        if (this.bnT.bol != null) {
                            append.append("|").append(this.bnT.bol.boq);
                        }
                        String stringBuilder = append.toString();
                    }
                    kVar = (k) this.bnP.get(obj);
                    if (kVar == null) {
                        h hVar = this.bnO;
                        k sE = hVar.bnX.bnQ.sE();
                        sE.boz = false;
                        n = (int) Math.ceil((double) (hVar.boe.descent - hVar.boe.ascent));
                        hVar.bob[0] = charAt;
                        hVar.boa.getTextBounds(hVar.bob, 0, 1, hVar.boc);
                        ceil = (int) Math.ceil((double) (Math.max((float) hVar.boc.width(), hVar.boa.measureText(hVar.bob, 0, 1)) + 1.0f));
                        if (sE != null) {
                            sE.bot = (float) ceil;
                            Paint paint = hVar.boa;
                            Object obj2 = (paint == null || !(paint.getStyle() == Style.STROKE || paint.getStyle() == Style.FILL_AND_STROKE)) ? null : 1;
                            if (obj2 != null) {
                                sE.bou = (-hVar.boa.getStrokeWidth()) / 2.0f;
                                sE.k(((float) ceil) + hVar.boa.getStrokeWidth(), (float) n);
                            } else {
                                sE.bou = 0.0f;
                                sE.k((float) ceil, (float) n);
                            }
                        }
                        if (hVar.bnY.b((int) Math.ceil((double) sE.width), (int) Math.ceil((double) sE.height), hVar.boc)) {
                            Rect rect = hVar.boc;
                            sE.b(((float) rect.left) / ((float) hVar.bnY.width()), ((float) rect.top) / ((float) hVar.bnY.height()), ((float) rect.right) / ((float) hVar.bnY.width()), ((float) rect.bottom) / ((float) hVar.bnY.height()));
                            Rect rect2 = hVar.boc;
                            Paint paint2 = hVar.boa;
                            if (!(paint2 == null || sE == null || rect2 == null)) {
                                hVar.bob[0] = charAt;
                                hVar.bnZ.save();
                                hVar.bnZ.clipRect(rect2);
                                hVar.bnZ.drawText(hVar.bob, 0, 1, ((float) rect2.left) - sE.bou, ((((float) rect2.top) + sE.height) - hVar.boe.descent) - 1.0f, paint2);
                                hVar.bnZ.restore();
                            }
                            kVar = sE;
                        } else {
                            kVar = null;
                        }
                        if (kVar == null) {
                            new StringBuilder("Load glyph failed. glyph == null [").append(charAt).append("]");
                            kVar = null;
                        } else {
                            this.bnP.put(obj, kVar);
                        }
                    }
                }
                kVar2 = kVar;
                i2 = i + 1;
                k kVar3 = kVar2;
            } else if (n <= 0) {
                throw new IllegalStateException("There is no font drawable");
            } else {
                this.bnV.setLength(0);
                ceil = i;
                for (i2 = n; i2 > 0; i2--) {
                    this.bnV.append(str.charAt(ceil));
                    ceil++;
                }
                this.bnV.append("|").append(this.bnT.azb);
                String stringBuilder2 = this.bnV.toString();
                kVar = (k) this.bnP.get(stringBuilder2);
                if (kVar == null) {
                    if (this.bnU == null) {
                        throw new IllegalStateException("FontDrawableProvider must support");
                    }
                    Drawable o = this.bnU.o(str, i);
                    if (o == null) {
                        kVar = k.bos;
                    } else {
                        int i3 = (int) this.bnT.azb;
                        int i4 = (int) this.bnT.azb;
                        if (i3 <= 0 || i4 <= 0) {
                            kVar = k.bos;
                        } else {
                            h hVar2 = this.bnO;
                            if (i3 <= 0 || i4 <= 0) {
                                throw new IllegalArgumentException("width or height unexpected");
                            }
                            kVar = hVar2.bnX.bnQ.sE();
                            kVar.bot = (float) i3;
                            kVar.bou = 0.0f;
                            hVar2.bnY.b(i3, i4, hVar2.boc);
                            Rect rect3 = hVar2.boc;
                            if (rect3.left < 0 || rect3.right < 0 || rect3.width() <= 0 || rect3.height() <= 0) {
                                kVar = null;
                            } else {
                                kVar.k((float) i3, (float) i4);
                                kVar.b(((float) rect3.left) / ((float) hVar2.bnY.width()), ((float) rect3.top) / ((float) hVar2.bnY.height()), ((float) rect3.right) / ((float) hVar2.bnY.width()), ((float) rect3.bottom) / ((float) hVar2.bnY.height()));
                                kVar.boz = true;
                                hVar2.bnZ.save();
                                hVar2.bnZ.clipRect(rect3);
                                o.setBounds(rect3);
                                o.draw(hVar2.bnZ);
                                hVar2.bnZ.restore();
                            }
                            if (kVar == null) {
                                kVar = null;
                            } else {
                                this.bnP.put(stringBuilder2, kVar);
                            }
                        }
                    }
                }
                kVar2 = kVar;
                i2 = n + i;
                Object obj3 = kVar2;
            }
            if (obj3 == null) {
                this.bnS.clear();
                return null;
            }
            this.bnS.add(obj3);
            i = i2;
        }
        return this.bnS;
    }

    final void a(j jVar) {
        boolean z = false;
        this.bnT = jVar;
        h hVar = this.bnO;
        hVar.boa.setTypeface(jVar.boj);
        hVar.boa.setTextSize(jVar.azb);
        if (jVar.bok) {
            hVar.boa.setStyle(Style.STROKE);
            hVar.boa.setStrokeWidth(jVar.strokeWidth);
        } else {
            hVar.boa.setStyle(Style.FILL);
        }
        hVar.boa.setTextSkewX(0.0f);
        hVar.boa.setFakeBoldText(false);
        if (jVar.bol != null) {
            if (jVar.boj == null || jVar.boj.getStyle() != jVar.bol.boq) {
                if (jVar.bol == a.boo || jVar.bol == a.bop) {
                    hVar.boa.setTextSkewX(-0.25f);
                }
                if (jVar.bol == a.bon || jVar.bol == a.bop) {
                    hVar.boa.setFakeBoldText(true);
                }
            }
            a aVar = jVar.bol;
            if (aVar == a.bon || aVar == a.bop) {
                z = true;
            }
            if (z) {
                hVar.boa.setFakeBoldText(true);
            }
        }
        hVar.boa.getFontMetrics(hVar.boe);
    }

    final float bD(String str) {
        if (str == null || str.length() == 0) {
            return 0.0f;
        }
        List bC = bC(str);
        if (bC == null || bC.size() == 0) {
            return -1.0f;
        }
        return h.v(bC);
    }
}
