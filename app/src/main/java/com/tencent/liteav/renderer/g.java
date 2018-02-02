package com.tencent.liteav.renderer;

import android.graphics.Matrix;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;

public class g {
    private TextureView a;
    private Handler b;
    private int c = 0;
    private int d = 0;
    private int e = 640;
    private int f = 480;
    private int g = 0;
    private int h = 0;
    private int i = 1;
    private int j = 0;
    private float k = 1.0f;
    private int l = 0;

    public g(TextureView textureView) {
        this.a = textureView;
        this.c = textureView.getWidth();
        this.d = textureView.getHeight();
        this.b = new Handler(textureView.getContext().getMainLooper());
    }

    public void a(int i) {
        try {
            this.b.post(new 1(this, i));
        } catch (Exception e) {
        }
    }

    public void b(int i) {
        float f = 1.0f;
        this.i = i;
        if (this.a != null) {
            float f2;
            if (i == 1) {
                if (!(this.j == 0 || this.j == 180 || (this.j != 270 && this.j != 90))) {
                    if (this.g != 0 && this.h != 0) {
                        f2 = ((float) this.d) / ((float) this.g);
                        f = ((float) this.c) / ((float) this.h);
                        if (f2 <= f) {
                            f = f2;
                        }
                    } else {
                        return;
                    }
                }
            } else if (i == 0) {
                if (this.g != 0 && this.h != 0) {
                    if (this.j == 0 || this.j == 180) {
                        f2 = ((float) this.d) / ((float) this.h);
                        f = ((float) this.c) / ((float) this.g);
                        if (f2 >= f) {
                            f = f2;
                        }
                    } else if (this.j == 270 || this.j == 90) {
                        f2 = ((float) this.d) / ((float) this.g);
                        f = ((float) this.c) / ((float) this.h);
                        if (f2 >= f) {
                            f = f2;
                        }
                    }
                } else {
                    return;
                }
            }
            if (this.k < 0.0f) {
                f = -f;
            }
            this.a.setScaleX(f);
            this.a.setScaleY(Math.abs(f));
            this.k = f;
        }
    }

    public void c(int i) {
        try {
            this.b.post(new 2(this, i));
        } catch (Exception e) {
        }
    }

    public void d(int i) {
        float f = 1.0f;
        int i2 = i % 360;
        this.j = i2;
        if (this.a != null) {
            float f2;
            float f3;
            if (i2 == 0 || i2 == 180) {
                this.a.setRotation((float) (360 - i2));
                if (this.i == 1) {
                    f2 = 1.0f;
                } else {
                    if (this.i == 0) {
                        if (this.g != 0 && this.h != 0) {
                            f3 = ((float) this.d) / ((float) this.h);
                            f2 = ((float) this.c) / ((float) this.g);
                            if (f3 >= f2) {
                                f2 = f3;
                            }
                            f = f2;
                        } else {
                            return;
                        }
                    }
                    if (this.k < 0.0f) {
                        f = -f;
                    }
                    this.a.setScaleX(f);
                    this.a.setScaleY(Math.abs(f));
                    this.k = f;
                }
            }
            if (i2 == 270 || i2 == 90) {
                if (this.g != 0 && this.h != 0) {
                    this.a.setRotation((float) (360 - i2));
                    f3 = ((float) this.d) / ((float) this.g);
                    f2 = ((float) this.c) / ((float) this.h);
                    if (this.i == 1) {
                        if (f3 <= f2) {
                            f2 = f3;
                        }
                        f = f2;
                    } else if (this.i == 0) {
                        if (f3 >= f2) {
                            f2 = f3;
                        }
                    }
                } else {
                    return;
                }
            }
            if (this.k < 0.0f) {
                f = -f;
            }
            this.a.setScaleX(f);
            this.a.setScaleY(Math.abs(f));
            this.k = f;
            f = f2;
            if (this.k < 0.0f) {
                f = -f;
            }
            this.a.setScaleX(f);
            this.a.setScaleY(Math.abs(f));
            this.k = f;
        }
    }

    private void a() {
        try {
            this.b.post(new 3(this));
        } catch (Exception e) {
        }
    }

    private void c(int i, int i2) {
        if (this.a != null && i != 0 && i2 != 0 && this.c != 0 && this.d != 0) {
            double d = ((double) i2) / ((double) i);
            if (this.d > ((int) (((double) this.c) * d))) {
                this.g = this.c;
                this.h = (int) (d * ((double) this.c));
            } else {
                this.g = (int) (((double) this.d) / d);
                this.h = this.d;
            }
            float f = ((float) (this.c - this.g)) / 2.0f;
            float f2 = ((float) (this.d - this.h)) / 2.0f;
            float f3 = ((float) this.g) / ((float) this.c);
            float f4 = ((float) this.h) / ((float) this.d);
            Matrix matrix = new Matrix();
            this.a.getTransform(matrix);
            matrix.setScale(f3, f4);
            matrix.postTranslate(f, f2);
            this.a.setTransform(matrix);
            this.a.requestLayout();
        }
    }

    public void a(int i, int i2) {
        TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + i + "," + i2);
        this.c = i;
        this.d = i2;
        a();
    }

    public void b(int i, int i2) {
        TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + i + "," + i2);
        this.e = i;
        this.f = i2;
        a();
    }
}
