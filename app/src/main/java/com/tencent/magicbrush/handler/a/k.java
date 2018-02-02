package com.tencent.magicbrush.handler.a;

import java.nio.FloatBuffer;
import java.util.List;

final class k {
    static final k bos;
    float bot;
    float bou;
    float bov;
    float bow;
    float box;
    float boy;
    boolean boz;
    float height;
    float width;

    k() {
    }

    static {
        k kVar = new k();
        bos = kVar;
        kVar.height = 0.0f;
        kVar.width = 0.0f;
        kVar.bou = 0.0f;
        kVar.bot = 0.0f;
        kVar.boy = 0.0f;
        kVar.box = 0.0f;
        kVar.bow = 0.0f;
        kVar.bov = 0.0f;
    }

    public final void k(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public final void b(float f, float f2, float f3, float f4) {
        this.bov = f;
        this.bow = f2;
        this.box = f3;
        this.boy = f4;
    }

    static void a(FloatBuffer floatBuffer, List<k> list) {
        if (list != null && !list.isEmpty()) {
            for (k kVar : list) {
                if (kVar != null) {
                    floatBuffer.put(kVar.bot).put(kVar.bou).put(kVar.width).put(kVar.height).put(kVar.bov).put(kVar.bow).put(kVar.box).put(kVar.boy).put(kVar.boz ? 1.0f : 0.0f);
                }
            }
        }
    }

    public final String toString() {
        return "glyph(" + this.bot + ", " + this.bou + ", [" + this.width + ", " + this.height + "], [" + this.bov + ", " + this.bow + ", " + this.box + ", " + this.boy + ", " + this.boz + "])";
    }
}
