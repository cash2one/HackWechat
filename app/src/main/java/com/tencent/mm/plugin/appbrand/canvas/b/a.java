package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.mm.plugin.appbrand.p.j;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    public int iLb = a.iLf;
    private float iLc = (((float) getAlpha()) / 255.0f);
    private String iLd;
    private int iLe;
    private int su = getColor();

    public enum a {
        ;

        static {
            iLf = 1;
            iLg = 2;
            iLh = 3;
            iLi = 4;
            iLj = new int[]{iLf, iLg, iLh, iLi};
        }
    }

    protected final Object clone() {
        return super.clone();
    }

    public final a abo() {
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Object a = j.a(Shader.class, "copy", shader, new Class[0], new Object[0], null);
            if (a != null && (a instanceof Shader)) {
                shader = (Shader) a;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.iLb = this.iLb;
        return aVar;
    }

    public final void S(float f) {
        this.iLc = f;
        setColor(this.su);
    }

    public final void setColor(int i) {
        this.su = i;
        super.setColor(((((int) (((float) Color.alpha(i)) * this.iLc)) & 255) << 24) | (16777215 & i));
    }

    public final void reset() {
        this.iLb = a.iLf;
        super.reset();
    }

    public final void qg(String str) {
        this.iLd = str;
        setTypeface(Typeface.create(str, this.iLe));
    }

    public final void jH(int i) {
        this.iLe = i;
        setTypeface(Typeface.create(this.iLd, i));
    }
}
