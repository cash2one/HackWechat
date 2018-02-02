package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xwalk.core.R$styleable;

@TargetApi(21)
public final class f extends e {
    static final Mode mo = Mode.SRC_IN;
    f mp;
    private PorterDuffColorFilter mq;
    private ColorFilter mr;
    private boolean ms;
    boolean mt;
    private ConstantState mu;
    private final float[] mv;
    private final Matrix mw;
    private final Rect mx;

    private static class c {
        final Matrix mL = new Matrix();
        final ArrayList<Object> mM = new ArrayList();
        float mN = 0.0f;
        float mO = 0.0f;
        float mP = 0.0f;
        float mQ = 1.0f;
        float mR = 1.0f;
        float mS = 0.0f;
        float mT = 0.0f;
        final Matrix mU = new Matrix();
        String mV = null;
        int me;
        int[] my;

        public c(c cVar, android.support.v4.e.a<String, Object> aVar) {
            this.mN = cVar.mN;
            this.mO = cVar.mO;
            this.mP = cVar.mP;
            this.mQ = cVar.mQ;
            this.mR = cVar.mR;
            this.mS = cVar.mS;
            this.mT = cVar.mT;
            this.my = cVar.my;
            this.mV = cVar.mV;
            this.me = cVar.me;
            if (this.mV != null) {
                aVar.put(this.mV, this);
            }
            this.mU.set(cVar.mU);
            ArrayList arrayList = cVar.mM;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.mM.add(new c((c) obj, aVar));
                } else {
                    d bVar;
                    if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        bVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mM.add(bVar);
                    if (bVar.mX != null) {
                        aVar.put(bVar.mX, bVar);
                    }
                }
            }
        }
    }

    private static class d {
        protected android.support.a.a.c.b[] mW = null;
        String mX;
        int me;

        public d(d dVar) {
            this.mX = dVar.mX;
            this.me = dVar.me;
            this.mW = c.a(dVar.mW);
        }

        public final void a(Path path) {
            path.reset();
            if (this.mW != null) {
                android.support.a.a.c.b[] bVarArr = this.mW;
                float[] fArr = new float[6];
                int i = 0;
                char c = 'm';
                while (i < bVarArr.length) {
                    int i2;
                    char c2 = bVarArr[i].ml;
                    float[] fArr2 = bVarArr[i].mm;
                    float f = fArr[0];
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    float f4 = fArr[3];
                    float f5 = fArr[4];
                    float f6 = fArr[5];
                    switch (c2) {
                        case 'A':
                        case 'a':
                            i2 = 7;
                            break;
                        case 'C':
                        case 'c':
                            i2 = 6;
                            break;
                        case 'H':
                        case 'V':
                        case 'h':
                        case 'v':
                            i2 = 1;
                            break;
                        case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                        case 'M':
                        case 'T':
                        case 'l':
                        case 'm':
                        case 't':
                            i2 = 2;
                            break;
                        case 'Q':
                        case 'S':
                        case 'q':
                        case 's':
                            i2 = 4;
                            break;
                        case 'Z':
                        case 'z':
                            path.close();
                            path.moveTo(f5, f6);
                            f4 = f6;
                            f3 = f5;
                            f2 = f6;
                            f = f5;
                            i2 = 2;
                            break;
                        default:
                            i2 = 2;
                            break;
                    }
                    int i3 = 0;
                    float f7 = f6;
                    float f8 = f5;
                    float f9 = f2;
                    float f10 = f;
                    while (i3 < fArr2.length) {
                        switch (c2) {
                            case 'A':
                                android.support.a.a.c.b.a(path, f10, f9, fArr2[i3 + 5], fArr2[i3 + 6], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                                f3 = fArr2[i3 + 5];
                                f4 = fArr2[i3 + 6];
                                f6 = f7;
                                f5 = f8;
                                f2 = f4;
                                f = f3;
                                break;
                            case 'C':
                                path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                                f5 = fArr2[i3 + 4];
                                f6 = fArr2[i3 + 5];
                                f3 = fArr2[i3 + 2];
                                f4 = fArr2[i3 + 3];
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'H':
                                path.lineTo(fArr2[i3 + 0], f9);
                                f6 = f7;
                                f2 = f9;
                                f = fArr2[i3 + 0];
                                f5 = f8;
                                break;
                            case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                                path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f5 = fArr2[i3 + 0];
                                f2 = fArr2[i3 + 1];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'M':
                                f5 = fArr2[i3 + 0];
                                f6 = fArr2[i3 + 1];
                                if (i3 <= 0) {
                                    path.moveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                    f2 = f6;
                                    f = f5;
                                    break;
                                }
                                path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'Q':
                                path.quadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = fArr2[i3 + 0];
                                f4 = fArr2[i3 + 1];
                                f5 = fArr2[i3 + 2];
                                f2 = fArr2[i3 + 3];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'S':
                                if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                    f6 = (2.0f * f9) - f4;
                                    f4 = (2.0f * f10) - f3;
                                } else {
                                    f6 = f9;
                                    f4 = f10;
                                }
                                path.cubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = fArr2[i3 + 0];
                                f4 = fArr2[i3 + 1];
                                f5 = fArr2[i3 + 2];
                                f2 = fArr2[i3 + 3];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'T':
                                if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                    f10 = (2.0f * f10) - f3;
                                    f9 = (2.0f * f9) - f4;
                                }
                                path.quadTo(f10, f9, fArr2[i3 + 0], fArr2[i3 + 1]);
                                f5 = fArr2[i3 + 0];
                                f4 = f9;
                                f3 = f10;
                                f2 = fArr2[i3 + 1];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'V':
                                path.lineTo(f10, fArr2[i3 + 0]);
                                f5 = f8;
                                f2 = fArr2[i3 + 0];
                                f = f10;
                                f6 = f7;
                                break;
                            case 'a':
                                android.support.a.a.c.b.a(path, f10, f9, fArr2[i3 + 5] + f10, fArr2[i3 + 6] + f9, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                                f3 = f10 + fArr2[i3 + 5];
                                f4 = f9 + fArr2[i3 + 6];
                                f6 = f7;
                                f5 = f8;
                                f2 = f4;
                                f = f3;
                                break;
                            case 'c':
                                path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                                f3 = f10 + fArr2[i3 + 2];
                                f4 = f9 + fArr2[i3 + 3];
                                f2 = f9 + fArr2[i3 + 5];
                                f = f10 + fArr2[i3 + 4];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'h':
                                path.rLineTo(fArr2[i3 + 0], 0.0f);
                                f6 = f7;
                                f2 = f9;
                                f = f10 + fArr2[i3 + 0];
                                f5 = f8;
                                break;
                            case 'l':
                                path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f9 + fArr2[i3 + 1];
                                f = f10 + fArr2[i3 + 0];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'm':
                                f5 = f10 + fArr2[i3 + 0];
                                f6 = f9 + fArr2[i3 + 1];
                                if (i3 <= 0) {
                                    path.rMoveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                    f2 = f6;
                                    f = f5;
                                    break;
                                }
                                path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'q':
                                path.rQuadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = f10 + fArr2[i3 + 0];
                                f4 = f9 + fArr2[i3 + 1];
                                f2 = f9 + fArr2[i3 + 3];
                                f = f10 + fArr2[i3 + 2];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 's':
                                f6 = 0.0f;
                                if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                    f6 = f9 - f4;
                                    f4 = f10 - f3;
                                } else {
                                    f4 = 0.0f;
                                }
                                path.rCubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = f10 + fArr2[i3 + 0];
                                f4 = f9 + fArr2[i3 + 1];
                                f2 = f9 + fArr2[i3 + 3];
                                f = f10 + fArr2[i3 + 2];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 't':
                                float f11;
                                if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                    f11 = f9 - f4;
                                    f4 = f10 - f3;
                                } else {
                                    f11 = 0.0f;
                                    f4 = 0.0f;
                                }
                                path.rQuadTo(f4, f11, fArr2[i3 + 0], fArr2[i3 + 1]);
                                f3 = f10 + f4;
                                f4 = f9 + f11;
                                f2 = f9 + fArr2[i3 + 1];
                                f = f10 + fArr2[i3 + 0];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'v':
                                path.rLineTo(0.0f, fArr2[i3 + 0]);
                                f5 = f8;
                                f2 = f9 + fArr2[i3 + 0];
                                f = f10;
                                f6 = f7;
                                break;
                            default:
                                f6 = f7;
                                f5 = f8;
                                f2 = f9;
                                f = f10;
                                break;
                        }
                        i3 += i2;
                        f7 = f6;
                        f8 = f5;
                        f9 = f2;
                        f10 = f;
                        c = c2;
                    }
                    fArr[0] = f10;
                    fArr[1] = f9;
                    fArr[2] = f3;
                    fArr[3] = f4;
                    fArr[4] = f8;
                    fArr[5] = f7;
                    char c3 = bVarArr[i].ml;
                    i++;
                    c = c3;
                }
            }
        }

        public boolean aD() {
            return false;
        }
    }

    private static class e {
        private static final Matrix na = new Matrix();
        private final Path mY;
        private final Path mZ;
        private int me;
        private final Matrix nb;
        private Paint nc;
        private Paint nd;
        private PathMeasure ne;
        private final c nf;
        float ng;
        float nh;
        float ni;
        float nj;
        int nk;
        String nl;
        final android.support.v4.e.a<String, Object> nm;

        public e() {
            this.nb = new Matrix();
            this.ng = 0.0f;
            this.nh = 0.0f;
            this.ni = 0.0f;
            this.nj = 0.0f;
            this.nk = 255;
            this.nl = null;
            this.nm = new android.support.v4.e.a();
            this.nf = new c();
            this.mY = new Path();
            this.mZ = new Path();
        }

        public e(e eVar) {
            this.nb = new Matrix();
            this.ng = 0.0f;
            this.nh = 0.0f;
            this.ni = 0.0f;
            this.nj = 0.0f;
            this.nk = 255;
            this.nl = null;
            this.nm = new android.support.v4.e.a();
            this.nf = new c(eVar.nf, this.nm);
            this.mY = new Path(eVar.mY);
            this.mZ = new Path(eVar.mZ);
            this.ng = eVar.ng;
            this.nh = eVar.nh;
            this.ni = eVar.ni;
            this.nj = eVar.nj;
            this.me = eVar.me;
            this.nk = eVar.nk;
            this.nl = eVar.nl;
            if (eVar.nl != null) {
                this.nm.put(eVar.nl, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.mL.set(matrix);
            cVar.mL.preConcat(cVar.mU);
            for (int i3 = 0; i3 < cVar.mM.size(); i3++) {
                Object obj = cVar.mM.get(i3);
                if (obj instanceof c) {
                    a((c) obj, cVar.mL, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    d dVar = (d) obj;
                    float f = ((float) i) / this.ni;
                    float f2 = ((float) i2) / this.nj;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = cVar.mL;
                    this.nb.set(matrix2);
                    this.nb.postScale(f, f2);
                    float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    f2 = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
                    float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                    float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                    f2 = Math.max(f2, hypot);
                    f = 0.0f;
                    if (f2 > 0.0f) {
                        f = Math.abs(f3) / f2;
                    }
                    if (f != 0.0f) {
                        dVar.a(this.mY);
                        Path path = this.mY;
                        this.mZ.reset();
                        if (dVar.aD()) {
                            this.mZ.addPath(path, this.nb);
                            canvas.clipPath(this.mZ, Op.REPLACE);
                        } else {
                            Paint paint;
                            b bVar = (b) dVar;
                            if (!(bVar.mF == 0.0f && bVar.mG == 1.0f)) {
                                hypot = (bVar.mF + bVar.mH) % 1.0f;
                                f3 = (bVar.mG + bVar.mH) % 1.0f;
                                if (this.ne == null) {
                                    this.ne = new PathMeasure();
                                }
                                this.ne.setPath(this.mY, false);
                                float length = this.ne.getLength();
                                hypot *= length;
                                f3 *= length;
                                path.reset();
                                if (hypot > f3) {
                                    this.ne.getSegment(hypot, length, path, true);
                                    this.ne.getSegment(0.0f, f3, path, true);
                                } else {
                                    this.ne.getSegment(hypot, f3, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            this.mZ.addPath(path, this.nb);
                            if (bVar.mB != 0) {
                                if (this.nd == null) {
                                    this.nd = new Paint();
                                    this.nd.setStyle(Style.FILL);
                                    this.nd.setAntiAlias(true);
                                }
                                paint = this.nd;
                                paint.setColor(((((int) (((float) Color.alpha(bVar.mB)) * bVar.mE)) << 24) | (16777215 & bVar.mB)));
                                paint.setColorFilter(colorFilter);
                                canvas.drawPath(this.mZ, paint);
                            }
                            if (bVar.mz != 0) {
                                if (this.nc == null) {
                                    this.nc = new Paint();
                                    this.nc.setStyle(Style.STROKE);
                                    this.nc.setAntiAlias(true);
                                }
                                paint = this.nc;
                                if (bVar.mJ != null) {
                                    paint.setStrokeJoin(bVar.mJ);
                                }
                                if (bVar.mI != null) {
                                    paint.setStrokeCap(bVar.mI);
                                }
                                paint.setStrokeMiter(bVar.mK);
                                paint.setColor(((((int) (((float) Color.alpha(bVar.mz)) * bVar.mC)) << 24) | (16777215 & bVar.mz)));
                                paint.setColorFilter(colorFilter);
                                paint.setStrokeWidth((f * min) * bVar.mA);
                                canvas.drawPath(this.mZ, paint);
                            }
                        }
                    }
                }
            }
        }

        public final void a(Canvas canvas, int i, int i2) {
            a(this.nf, na, canvas, i, i2, null);
        }
    }

    private static class f extends ConstantState {
        int me;
        e nn;
        ColorStateList no;
        Mode np;
        boolean nq;
        Bitmap nr;
        ColorStateList ns;
        Mode nt;
        int nu;
        boolean nv;
        boolean nw;
        Paint nx;

        public f(f fVar) {
            this.no = null;
            this.np = f.mo;
            if (fVar != null) {
                this.me = fVar.me;
                this.nn = new e(fVar.nn);
                if (fVar.nn.nd != null) {
                    this.nn.nd = new Paint(fVar.nn.nd);
                }
                if (fVar.nn.nc != null) {
                    this.nn.nc = new Paint(fVar.nn.nc);
                }
                this.no = fVar.no;
                this.np = fVar.np;
                this.nq = fVar.nq;
            }
        }

        public final void h(int i, int i2) {
            this.nr.eraseColor(0);
            this.nn.a(new Canvas(this.nr), i, i2);
        }

        public f() {
            this.no = null;
            this.np = f.mo;
            this.nn = new e();
        }

        public final Drawable newDrawable() {
            return new f();
        }

        public final Drawable newDrawable(Resources resources) {
            return new f();
        }

        public final int getChangingConfigurations() {
            return this.me;
        }
    }

    private static class g extends ConstantState {
        private final ConstantState mi;

        public g(ConstantState constantState) {
            this.mi = constantState;
        }

        public final Drawable newDrawable() {
            Drawable fVar = new f();
            fVar.mn = (VectorDrawable) this.mi.newDrawable();
            return fVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable fVar = new f();
            fVar.mn = (VectorDrawable) this.mi.newDrawable(resources);
            return fVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable fVar = new f();
            fVar.mn = (VectorDrawable) this.mi.newDrawable(resources, theme);
            return fVar;
        }

        public final boolean canApplyTheme() {
            return this.mi.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.mi.getChangingConfigurations();
        }
    }

    private static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mX = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.mW = c.h(string);
            }
        }

        public final boolean aD() {
            return true;
        }
    }

    private static class b extends d {
        float mA = 0.0f;
        int mB = 0;
        float mC = 1.0f;
        int mD;
        float mE = 1.0f;
        float mF = 0.0f;
        float mG = 1.0f;
        float mH = 0.0f;
        Cap mI = Cap.BUTT;
        Join mJ = Join.MITER;
        float mK = 4.0f;
        private int[] my;
        int mz = 0;

        public b(b bVar) {
            super(bVar);
            this.my = bVar.my;
            this.mz = bVar.mz;
            this.mA = bVar.mA;
            this.mC = bVar.mC;
            this.mB = bVar.mB;
            this.mD = bVar.mD;
            this.mE = bVar.mE;
            this.mF = bVar.mF;
            this.mG = bVar.mG;
            this.mH = bVar.mH;
            this.mI = bVar.mI;
            this.mJ = bVar.mJ;
            this.mK = bVar.mK;
        }

        final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.my = null;
            if (d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mX = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.mW = c.h(string);
                }
                this.mB = d.a(typedArray, xmlPullParser, "fillColor", 1, this.mB);
                this.mE = d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.mE);
                int a = d.a(typedArray, xmlPullParser, "strokeLineCap", 8);
                Cap cap = this.mI;
                switch (a) {
                    case 0:
                        cap = Cap.BUTT;
                        break;
                    case 1:
                        cap = Cap.ROUND;
                        break;
                    case 2:
                        cap = Cap.SQUARE;
                        break;
                }
                this.mI = cap;
                a = d.a(typedArray, xmlPullParser, "strokeLineJoin", 9);
                Join join = this.mJ;
                switch (a) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.ROUND;
                        break;
                    case 2:
                        join = Join.BEVEL;
                        break;
                }
                this.mJ = join;
                this.mK = d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mK);
                this.mz = d.a(typedArray, xmlPullParser, "strokeColor", 3, this.mz);
                this.mC = d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.mC);
                this.mA = d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mA);
                this.mG = d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.mG);
                this.mH = d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.mH);
                this.mF = d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.mF);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private f() {
        this.mt = true;
        this.mv = new float[9];
        this.mw = new Matrix();
        this.mx = new Rect();
        this.mp = new f();
    }

    private f(f fVar) {
        this.mt = true;
        this.mv = new float[9];
        this.mw = new Matrix();
        this.mx = new Rect();
        this.mp = fVar;
        this.mq = a(fVar.no, fVar.np);
    }

    public final Drawable mutate() {
        if (this.mn != null) {
            this.mn.mutate();
        } else if (!this.ms && super.mutate() == this) {
            this.mp = new f(this.mp);
            this.ms = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.mn != null) {
            return new g(this.mn.getConstantState());
        }
        this.mp.me = getChangingConfigurations();
        return this.mp;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(Canvas canvas) {
        float f = 1.0f;
        if (this.mn != null) {
            this.mn.draw(canvas);
            return;
        }
        copyBounds(this.mx);
        if (this.mx.width() > 0 && this.mx.height() > 0) {
            ColorFilter colorFilter = this.mr == null ? this.mq : this.mr;
            canvas.getMatrix(this.mw);
            this.mw.getValues(this.mv);
            float abs = Math.abs(this.mv[0]);
            float abs2 = Math.abs(this.mv[4]);
            float abs3 = Math.abs(this.mv[1]);
            float abs4 = Math.abs(this.mv[3]);
            if (abs3 == 0.0f && abs4 == 0.0f) {
                f = abs;
            } else {
                abs2 = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.mx.height()));
            int min = Math.min(2048, (int) (f * ((float) this.mx.width())));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                boolean z;
                Paint paint;
                int save = canvas.save();
                canvas.translate((float) this.mx.left, (float) this.mx.top);
                this.mx.offsetTo(0, 0);
                f fVar = this.mp;
                if (fVar.nr != null) {
                    z = min == fVar.nr.getWidth() && min2 == fVar.nr.getHeight();
                }
                fVar.nr = Bitmap.createBitmap(min, min2, Config.ARGB_8888);
                fVar.nw = true;
                if (this.mt) {
                    f fVar2 = this.mp;
                    if (!fVar2.nw && fVar2.ns == fVar2.no && fVar2.nt == fVar2.np && fVar2.nv == fVar2.nq && fVar2.nu == fVar2.nn.nk) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.mp.h(min, min2);
                        fVar2 = this.mp;
                        fVar2.ns = fVar2.no;
                        fVar2.nt = fVar2.np;
                        fVar2.nu = fVar2.nn.nk;
                        fVar2.nv = fVar2.nq;
                        fVar2.nw = false;
                    }
                } else {
                    this.mp.h(min, min2);
                }
                f fVar3 = this.mp;
                Rect rect = this.mx;
                if (fVar3.nn.nk < 255) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || colorFilter != null) {
                    if (fVar3.nx == null) {
                        fVar3.nx = new Paint();
                        fVar3.nx.setFilterBitmap(true);
                    }
                    fVar3.nx.setAlpha(fVar3.nn.nk);
                    fVar3.nx.setColorFilter(colorFilter);
                    paint = fVar3.nx;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(fVar3.nr, null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public final int getAlpha() {
        if (this.mn != null) {
            return android.support.v4.b.a.a.e(this.mn);
        }
        return this.mp.nn.nk;
    }

    public final void setAlpha(int i) {
        if (this.mn != null) {
            this.mn.setAlpha(i);
        } else if (this.mp.nn.nk != i) {
            this.mp.nn.nk = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.mn != null) {
            this.mn.setColorFilter(colorFilter);
            return;
        }
        this.mr = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, colorStateList);
            return;
        }
        f fVar = this.mp;
        if (fVar.no != colorStateList) {
            fVar.no = colorStateList;
            this.mq = a(colorStateList, fVar.np);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, mode);
            return;
        }
        f fVar = this.mp;
        if (fVar.np != mode) {
            fVar.np = mode;
            this.mq = a(fVar.no, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.mn != null) {
            return this.mn.isStateful();
        }
        return super.isStateful() || !(this.mp == null || this.mp.no == null || !this.mp.no.isStateful());
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.mn != null) {
            return this.mn.setState(iArr);
        }
        f fVar = this.mp;
        if (fVar.no == null || fVar.np == null) {
            return false;
        }
        this.mq = a(fVar.no, fVar.np);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.mn != null) {
            return this.mn.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.mn != null) {
            return this.mn.getIntrinsicWidth();
        }
        return (int) this.mp.nn.ng;
    }

    public final int getIntrinsicHeight() {
        if (this.mn != null) {
            return this.mn.getIntrinsicHeight();
        }
        return (int) this.mp.nn.nh;
    }

    public final boolean canApplyTheme() {
        if (this.mn != null) {
            android.support.v4.b.a.a.f(this.mn);
        }
        return false;
    }

    public static f a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            f fVar = new f();
            fVar.mn = VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
            fVar.mu = new g(fVar.mn.getConstantState());
            return fVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.mn != null) {
            this.mn.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.mp;
        fVar.nn = new e();
        TypedArray a = e.a(resources, theme, attributeSet, a.lU);
        f fVar2 = this.mp;
        e eVar = fVar2.nn;
        int a2 = d.a(a, xmlPullParser, "tintMode", 6);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        fVar2.np = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            fVar2.no = colorStateList;
        }
        boolean z = fVar2.nq;
        if (d.a(xmlPullParser, "autoMirrored")) {
            z = a.getBoolean(5, z);
        }
        fVar2.nq = z;
        eVar.ni = d.a(a, xmlPullParser, "viewportWidth", 7, eVar.ni);
        eVar.nj = d.a(a, xmlPullParser, "viewportHeight", 8, eVar.nj);
        if (eVar.ni <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.nj <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.ng = a.getDimension(3, eVar.ng);
            eVar.nh = a.getDimension(2, eVar.nh);
            if (eVar.ng <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.nh <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.nk = (int) (d.a(a, xmlPullParser, "alpha", 4, ((float) eVar.nk) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    eVar.nl = string;
                    eVar.nm.put(string, eVar);
                }
                a.recycle();
                fVar.me = getChangingConfigurations();
                fVar.nw = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.mq = a(fVar.no, fVar.np);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.mp;
        e eVar = fVar.nn;
        Object obj = 1;
        Stack stack = new Stack();
        stack.push(eVar.nf);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    d bVar = new b();
                    TypedArray a = e.a(resources, theme, attributeSet, a.lW);
                    bVar.a(a, xmlPullParser);
                    a.recycle();
                    cVar.mM.add(bVar);
                    if (bVar.mX != null) {
                        eVar.nm.put(bVar.mX, bVar);
                    }
                    obj2 = null;
                    fVar.me = bVar.me | fVar.me;
                } else if ("clip-path".equals(name)) {
                    d aVar = new a();
                    if (d.a(xmlPullParser, "pathData")) {
                        r8 = e.a(resources, theme, attributeSet, a.lX);
                        aVar.a(r8);
                        r8.recycle();
                    }
                    cVar.mM.add(aVar);
                    if (aVar.mX != null) {
                        eVar.nm.put(aVar.mX, aVar);
                    }
                    fVar.me |= aVar.me;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        r8 = e.a(resources, theme, attributeSet, a.lV);
                        cVar2.my = null;
                        cVar2.mN = d.a(r8, xmlPullParser, "rotation", 5, cVar2.mN);
                        cVar2.mO = r8.getFloat(1, cVar2.mO);
                        cVar2.mP = r8.getFloat(2, cVar2.mP);
                        cVar2.mQ = d.a(r8, xmlPullParser, "scaleX", 3, cVar2.mQ);
                        cVar2.mR = d.a(r8, xmlPullParser, "scaleY", 4, cVar2.mR);
                        cVar2.mS = d.a(r8, xmlPullParser, "translateX", 6, cVar2.mS);
                        cVar2.mT = d.a(r8, xmlPullParser, "translateY", 7, cVar2.mT);
                        String string = r8.getString(0);
                        if (string != null) {
                            cVar2.mV = string;
                        }
                        cVar2.mU.reset();
                        cVar2.mU.postTranslate(-cVar2.mO, -cVar2.mP);
                        cVar2.mU.postScale(cVar2.mQ, cVar2.mR);
                        cVar2.mU.postRotate(cVar2.mN, 0.0f, 0.0f);
                        cVar2.mU.postTranslate(cVar2.mS + cVar2.mO, cVar2.mT + cVar2.mP);
                        r8.recycle();
                        cVar.mM.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.mV != null) {
                            eVar.nm.put(cVar2.mV, cVar2);
                        }
                        fVar.me |= cVar2.me;
                    }
                    obj2 = obj;
                }
            } else {
                if (eventType == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                    }
                }
                obj2 = obj;
            }
            obj = obj2;
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.mn != null) {
            this.mn.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.mn != null) {
            return this.mn.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mp.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.mn != null) {
            this.mn.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.mn != null) {
            this.mn.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.mn != null) {
            return this.mn.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.mn != null) {
            this.mn.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
