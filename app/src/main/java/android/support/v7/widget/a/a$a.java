package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.a.c.a;
import android.support.v7.widget.a.c.b;
import android.support.v7.widget.a.c.c;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class a$a {
    private static final b abd;
    private static final Interpolator abe = new 1();
    private static final Interpolator abf = new 2();
    private int abg = -1;

    public abstract boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2);

    public abstract int hg();

    public abstract void hn();

    static /* synthetic */ void a(a$a android_support_v7_widget_a_a_a, Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, List list, int i, float f, float f2) {
        int i2;
        int size = list.size();
        for (i2 = 0; i2 < size; i2++) {
            a$c android_support_v7_widget_a_a_c = (a$c) list.get(i2);
            int save = canvas.save();
            a(canvas, recyclerView, android_support_v7_widget_a_a_c.Vh, android_support_v7_widget_a_a_c.abo, android_support_v7_widget_a_a_c.abp, android_support_v7_widget_a_a_c.aaN);
            canvas.restoreToCount(save);
        }
        if (recyclerView$t != null) {
            i2 = canvas.save();
            a(canvas, recyclerView, recyclerView$t, f, f2, i);
            canvas.restoreToCount(i2);
        }
        Object obj = null;
        int i3 = size - 1;
        while (i3 >= 0) {
            Object obj2;
            android_support_v7_widget_a_a_c = (a$c) list.get(i3);
            if (!android_support_v7_widget_a_a_c.oP || android_support_v7_widget_a_a_c.abn) {
                obj2 = !android_support_v7_widget_a_a_c.oP ? 1 : obj;
            } else {
                list.remove(i3);
                obj2 = obj;
            }
            i3--;
            obj = obj2;
        }
        if (obj != null) {
            recyclerView.invalidate();
        }
    }

    static /* synthetic */ boolean a(a$a android_support_v7_widget_a_a_a, RecyclerView recyclerView, RecyclerView$t recyclerView$t) {
        return (android_support_v7_widget_a_a_a.B(recyclerView) & 16711680) != 0;
    }

    static /* synthetic */ void b(a$a android_support_v7_widget_a_a_a, Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, List list, int i, float f, float f2) {
        int i2;
        int size = list.size();
        for (i2 = 0; i2 < size; i2++) {
            a$c android_support_v7_widget_a_a_c = (a$c) list.get(i2);
            if (android_support_v7_widget_a_a_c.abh == android_support_v7_widget_a_a_c.abj) {
                android_support_v7_widget_a_a_c.abo = z.Q(android_support_v7_widget_a_a_c.Vh.VU);
            } else {
                android_support_v7_widget_a_a_c.abo = android_support_v7_widget_a_a_c.abh + (android_support_v7_widget_a_a_c.oN * (android_support_v7_widget_a_a_c.abj - android_support_v7_widget_a_a_c.abh));
            }
            if (android_support_v7_widget_a_a_c.abi == android_support_v7_widget_a_a_c.abk) {
                android_support_v7_widget_a_a_c.abp = z.R(android_support_v7_widget_a_a_c.Vh.VU);
            } else {
                android_support_v7_widget_a_a_c.abp = android_support_v7_widget_a_a_c.abi + (android_support_v7_widget_a_a_c.oN * (android_support_v7_widget_a_a_c.abk - android_support_v7_widget_a_a_c.abi));
            }
            int save = canvas.save();
            android_support_v7_widget_a_a_a.a(canvas, recyclerView, android_support_v7_widget_a_a_c.Vh, android_support_v7_widget_a_a_c.abo, android_support_v7_widget_a_a_c.abp, android_support_v7_widget_a_a_c.aaN, false);
            canvas.restoreToCount(save);
        }
        if (recyclerView$t != null) {
            i2 = canvas.save();
            android_support_v7_widget_a_a_a.a(canvas, recyclerView, recyclerView$t, f, f2, i, true);
            canvas.restoreToCount(i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            abd = new c();
        } else if (VERSION.SDK_INT >= 11) {
            abd = new b();
        } else {
            abd = new a();
        }
    }

    public static int al(int i, int i2) {
        int i3 = i & 789516;
        if (i3 == 0) {
            return i;
        }
        int i4 = (i3 ^ -1) & i;
        if (i2 == 0) {
            return i4 | (i3 << 2);
        }
        return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
    }

    public static int am(int i, int i2) {
        int i3 = i & 3158064;
        if (i3 == 0) {
            return i;
        }
        int i4 = (i3 ^ -1) & i;
        if (i2 == 0) {
            return i4 | (i3 >> 2);
        }
        return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
    }

    final int B(RecyclerView recyclerView) {
        return am(3342387, z.I(recyclerView));
    }

    public static boolean hh() {
        return true;
    }

    public boolean hi() {
        return true;
    }

    public boolean hj() {
        return true;
    }

    public static int hk() {
        return 0;
    }

    public static float hl() {
        return 0.5f;
    }

    public float hm() {
        return 0.5f;
    }

    public static float I(float f) {
        return f;
    }

    public static float J(float f) {
        return f;
    }

    public static RecyclerView$t a(RecyclerView$t recyclerView$t, List<RecyclerView$t> list, int i, int i2) {
        int width = i + recyclerView$t.VU.getWidth();
        int height = i2 + recyclerView$t.VU.getHeight();
        RecyclerView$t recyclerView$t2 = null;
        int i3 = -1;
        int left = i - recyclerView$t.VU.getLeft();
        int top = i2 - recyclerView$t.VU.getTop();
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            int i5;
            RecyclerView$t recyclerView$t3;
            int i6;
            RecyclerView$t recyclerView$t4;
            int i7;
            RecyclerView$t recyclerView$t5 = (RecyclerView$t) list.get(i4);
            if (left > 0) {
                int right = recyclerView$t5.VU.getRight() - width;
                if (right < 0 && recyclerView$t5.VU.getRight() > recyclerView$t.VU.getRight()) {
                    right = Math.abs(right);
                    if (right > i3) {
                        i5 = right;
                        recyclerView$t3 = recyclerView$t5;
                        if (left < 0) {
                            i3 = recyclerView$t5.VU.getLeft() - i;
                            if (i3 > 0 && recyclerView$t5.VU.getLeft() < recyclerView$t.VU.getLeft()) {
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    recyclerView$t3 = recyclerView$t5;
                                    if (top < 0) {
                                        i5 = recyclerView$t5.VU.getTop() - i2;
                                        if (i5 > 0 && recyclerView$t5.VU.getTop() < recyclerView$t.VU.getTop()) {
                                            i5 = Math.abs(i5);
                                            if (i5 > i3) {
                                                recyclerView$t3 = recyclerView$t5;
                                                if (top > 0) {
                                                    i3 = recyclerView$t5.VU.getBottom() - height;
                                                    if (i3 < 0 && recyclerView$t5.VU.getBottom() > recyclerView$t.VU.getBottom()) {
                                                        i3 = Math.abs(i3);
                                                        if (i3 > i5) {
                                                            i6 = i3;
                                                            recyclerView$t4 = recyclerView$t5;
                                                            i7 = i6;
                                                            i4++;
                                                            recyclerView$t2 = recyclerView$t4;
                                                            i3 = i7;
                                                        }
                                                    }
                                                }
                                                i7 = i5;
                                                recyclerView$t4 = recyclerView$t3;
                                                i4++;
                                                recyclerView$t2 = recyclerView$t4;
                                                i3 = i7;
                                            }
                                        }
                                    }
                                    i5 = i3;
                                    if (top > 0) {
                                        i3 = recyclerView$t5.VU.getBottom() - height;
                                        i3 = Math.abs(i3);
                                        if (i3 > i5) {
                                            i6 = i3;
                                            recyclerView$t4 = recyclerView$t5;
                                            i7 = i6;
                                            i4++;
                                            recyclerView$t2 = recyclerView$t4;
                                            i3 = i7;
                                        }
                                    }
                                    i7 = i5;
                                    recyclerView$t4 = recyclerView$t3;
                                    i4++;
                                    recyclerView$t2 = recyclerView$t4;
                                    i3 = i7;
                                }
                            }
                        }
                        i3 = i5;
                        if (top < 0) {
                            i5 = recyclerView$t5.VU.getTop() - i2;
                            i5 = Math.abs(i5);
                            if (i5 > i3) {
                                recyclerView$t3 = recyclerView$t5;
                                if (top > 0) {
                                    i3 = recyclerView$t5.VU.getBottom() - height;
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        i6 = i3;
                                        recyclerView$t4 = recyclerView$t5;
                                        i7 = i6;
                                        i4++;
                                        recyclerView$t2 = recyclerView$t4;
                                        i3 = i7;
                                    }
                                }
                                i7 = i5;
                                recyclerView$t4 = recyclerView$t3;
                                i4++;
                                recyclerView$t2 = recyclerView$t4;
                                i3 = i7;
                            }
                        }
                        i5 = i3;
                        if (top > 0) {
                            i3 = recyclerView$t5.VU.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                recyclerView$t4 = recyclerView$t5;
                                i7 = i6;
                                i4++;
                                recyclerView$t2 = recyclerView$t4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        recyclerView$t4 = recyclerView$t3;
                        i4++;
                        recyclerView$t2 = recyclerView$t4;
                        i3 = i7;
                    }
                }
            }
            recyclerView$t3 = recyclerView$t2;
            i5 = i3;
            if (left < 0) {
                i3 = recyclerView$t5.VU.getLeft() - i;
                i3 = Math.abs(i3);
                if (i3 > i5) {
                    recyclerView$t3 = recyclerView$t5;
                    if (top < 0) {
                        i5 = recyclerView$t5.VU.getTop() - i2;
                        i5 = Math.abs(i5);
                        if (i5 > i3) {
                            recyclerView$t3 = recyclerView$t5;
                            if (top > 0) {
                                i3 = recyclerView$t5.VU.getBottom() - height;
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    i6 = i3;
                                    recyclerView$t4 = recyclerView$t5;
                                    i7 = i6;
                                    i4++;
                                    recyclerView$t2 = recyclerView$t4;
                                    i3 = i7;
                                }
                            }
                            i7 = i5;
                            recyclerView$t4 = recyclerView$t3;
                            i4++;
                            recyclerView$t2 = recyclerView$t4;
                            i3 = i7;
                        }
                    }
                    i5 = i3;
                    if (top > 0) {
                        i3 = recyclerView$t5.VU.getBottom() - height;
                        i3 = Math.abs(i3);
                        if (i3 > i5) {
                            i6 = i3;
                            recyclerView$t4 = recyclerView$t5;
                            i7 = i6;
                            i4++;
                            recyclerView$t2 = recyclerView$t4;
                            i3 = i7;
                        }
                    }
                    i7 = i5;
                    recyclerView$t4 = recyclerView$t3;
                    i4++;
                    recyclerView$t2 = recyclerView$t4;
                    i3 = i7;
                }
            }
            i3 = i5;
            if (top < 0) {
                i5 = recyclerView$t5.VU.getTop() - i2;
                i5 = Math.abs(i5);
                if (i5 > i3) {
                    recyclerView$t3 = recyclerView$t5;
                    if (top > 0) {
                        i3 = recyclerView$t5.VU.getBottom() - height;
                        i3 = Math.abs(i3);
                        if (i3 > i5) {
                            i6 = i3;
                            recyclerView$t4 = recyclerView$t5;
                            i7 = i6;
                            i4++;
                            recyclerView$t2 = recyclerView$t4;
                            i3 = i7;
                        }
                    }
                    i7 = i5;
                    recyclerView$t4 = recyclerView$t3;
                    i4++;
                    recyclerView$t2 = recyclerView$t4;
                    i3 = i7;
                }
            }
            i5 = i3;
            if (top > 0) {
                i3 = recyclerView$t5.VU.getBottom() - height;
                i3 = Math.abs(i3);
                if (i3 > i5) {
                    i6 = i3;
                    recyclerView$t4 = recyclerView$t5;
                    i7 = i6;
                    i4++;
                    recyclerView$t2 = recyclerView$t4;
                    i3 = i7;
                }
            }
            i7 = i5;
            recyclerView$t4 = recyclerView$t3;
            i4++;
            recyclerView$t2 = recyclerView$t4;
            i3 = i7;
        }
        return recyclerView$t2;
    }

    public void e(RecyclerView$t recyclerView$t, int i) {
        if (recyclerView$t != null) {
            abd.bz(recyclerView$t.VU);
        }
    }

    public void c(RecyclerView recyclerView, RecyclerView$t recyclerView$t) {
        abd.by(recyclerView$t.VU);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, float f, float f2, int i, boolean z) {
        abd.a(canvas, recyclerView, recyclerView$t.VU, f, f2, i, z);
    }

    private static void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, float f, float f2, int i) {
        abd.a(canvas, recyclerView, recyclerView$t.VU, f, f2, i);
    }

    public static long f(RecyclerView recyclerView, int i) {
        e eVar = recyclerView.Ur;
        return eVar == null ? i == 8 ? 200 : 250 : i == 8 ? eVar.UX : eVar.UW;
    }

    public final int a(RecyclerView recyclerView, int i, int i2, long j) {
        float f = 1.0f;
        if (this.abg == -1) {
            this.abg = recyclerView.getResources().getDimensionPixelSize(android.support.v7.d.a.a.Jo);
        }
        int signum = (int) (((float) (this.abg * ((int) Math.signum((float) i2)))) * abf.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
        if (j <= 2000) {
            f = ((float) j) / 2000.0f;
        }
        int interpolation = (int) (abe.getInterpolation(f) * ((float) signum));
        if (interpolation != 0) {
            return interpolation;
        }
        if (i2 > 0) {
            return 1;
        }
        return -1;
    }
}
