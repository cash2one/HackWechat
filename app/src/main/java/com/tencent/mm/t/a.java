package com.tencent.mm.t;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mm.bj.a$c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.smtt.sdk.WebView;

public final class a implements Cloneable {
    private static int gNo = ((int) ac.getResources().getDimension(a$c.vaX));
    private static int gNp = ((int) ac.getResources().getDimension(a$c.vaW));
    public static float gNq = ac.getResources().getDimension(a$c.vbb);
    public static float gNr = ac.getResources().getDimension(a$c.vba);
    public static Path gNs = new Path();
    public static Path gNt = new Path();
    public static Paint gNu = new Paint();
    public static Paint gNv = new Paint();
    public static Paint gNw = new Paint();
    public static Paint gNx = new Paint();
    public static Paint gNy = new Paint();
    public static Rect gO = new Rect();
    public Rect fcT;
    public Rect gNA = new Rect();
    public Rect gNz = new Rect();
    public Matrix mMatrix = new Matrix();

    static {
        gNw.setColor(WebView.NIGHT_MODE_COLOR);
        gNu.setColor(-1);
        gNu.setStrokeWidth((float) gNo);
        gNu.setStyle(Style.STROKE);
        gNu.setAntiAlias(true);
        gNx.set(gNu);
        gNx.setStrokeWidth((float) gNp);
        gNy.set(gNu);
        gNy.setStrokeWidth(gNq);
        gNv.set(gNu);
        gNv.setStrokeWidth((float) (gNo * 7));
        gNv.setColor(549174203);
    }

    public a(Rect rect) {
        this.fcT = rect;
    }

    public static void gl(int i) {
        gNy.setAlpha(i);
        gNu.setAlpha(i);
        gNx.setAlpha((int) (0.7058824f * ((float) i)));
    }

    public static void gm(int i) {
        gNw.setAlpha((int) (0.9019608f * ((float) i)));
    }

    public final Object clone() {
        return super.clone();
    }
}
