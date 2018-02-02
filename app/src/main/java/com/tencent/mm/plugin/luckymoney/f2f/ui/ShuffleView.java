package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView extends FrameLayout {
    public static DisplayMetrics icn;
    GestureDetector lVX = new GestureDetector(new 13(this));
    List<View> oaK = new ArrayList();
    c oaL = new c();
    ValueAnimator oaM;
    private ValueAnimator oaN;
    ValueAnimator oaO;
    ValueAnimator oaP;
    a oaQ;
    b oaR;
    View oaS;
    private View oaT;
    View oaU;
    int oaV;
    View oaW;
    int oaX;
    int oaY;
    private float oaZ;
    private float oba;
    private final float obb = 0.23f;
    private final float obc = 0.28f;
    private final float obd = 0.33f;
    private ArrayList<Float> obe = new ArrayList();
    private ArrayList<Float> obf = new ArrayList();
    private boolean obg;
    private int obh = getResources().getDimensionPixelSize(d.ubZ);
    private int obi = 2500;

    static /* synthetic */ void b(ShuffleView shuffleView, int i) {
        if (i >= 0 && i < shuffleView.oaY) {
            x.i("ShuffleView", "touch card " + i);
            if (shuffleView.oaP.isStarted()) {
                shuffleView.oaP.cancel();
            }
            shuffleView.oaP.removeAllUpdateListeners();
            shuffleView.oaP.removeAllListeners();
            shuffleView.oaW = (View) shuffleView.oaK.get(i);
            shuffleView.oaX = i;
            switch (shuffleView.oaL.obp) {
                case 4:
                    if (i > 0) {
                        shuffleView.oaP.addUpdateListener(new 11(shuffleView, i - 1, (shuffleView.oaY - 1) - i));
                    } else {
                        shuffleView.oaP.addUpdateListener(new 12(shuffleView));
                    }
                    if (shuffleView.oaR != null) {
                        shuffleView.oaR.cJ(shuffleView.oaX, shuffleView.oaY);
                        break;
                    }
                    break;
            }
            shuffleView.oaP.start();
        }
    }

    static /* synthetic */ float g(ShuffleView shuffleView) {
        if (shuffleView.oaU != null) {
            float width = (0.33f * ((float) shuffleView.oaU.getWidth())) - shuffleView.oaZ;
            int i = shuffleView.oaV - 1;
            int i2 = (shuffleView.oaY - 1) - shuffleView.oaV;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    static /* synthetic */ float j(ShuffleView shuffleView) {
        if (shuffleView.oaW != null) {
            float width = (0.28f * ((float) shuffleView.oaW.getWidth())) - shuffleView.oaZ;
            int i = shuffleView.oaX - 1;
            int i2 = (shuffleView.oaY - 1) - shuffleView.oaX;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void aWX() {
        if (this.oaY > 1) {
            x.d("ShuffleView", "card width: %d,height: %d", new Object[]{Integer.valueOf(((View) this.oaK.get(0)).getWidth()), Integer.valueOf(((View) this.oaK.get(0)).getHeight())});
            if (this.oaL.obo == 2) {
                this.oaZ = (((float) ((View) this.oaK.get(0)).getWidth()) * DownloadHelper.SAVE_FATOR) / ((float) this.oaY);
                if (this.oaZ > ((float) ((View) this.oaK.get(0)).getWidth()) * 0.23f) {
                    this.oaZ = ((float) ((View) this.oaK.get(0)).getWidth()) * 0.23f;
                    return;
                }
                return;
            } else if (this.oaL.obo == 1) {
                this.oba = (((float) ((View) this.oaK.get(0)).getHeight()) * 1.0f) / ((float) this.oaY);
                return;
            } else {
                return;
            }
        }
        this.oaZ = 0.0f;
        this.oba = 0.0f;
    }

    final void y(View view, int i) {
        if (this.oaL.obo == 1) {
            view.setScaleX(1.0f - (this.oaL.obr * ((float) i)));
            view.setTranslationY(rW(i));
        } else if (this.oaL.obo == 2) {
            view.setScaleY(1.0f - (this.oaL.obs * ((float) i)));
            view.setTranslationX(rV(i));
        }
    }

    public final float rV(int i) {
        if (this.oaL.obo == 2 && this.oaY > 0) {
            if (this.oaL.obp == 3) {
                return ((((float) (this.oaY - 1)) * 0.5f) * this.oaZ) - (this.oaZ * ((float) i));
            }
            if (this.oaL.obp == 4) {
                return (this.oaZ * ((float) i)) - ((((float) (this.oaY - 1)) * 0.5f) * this.oaZ);
            }
        }
        return 0.0f;
    }

    public final float rW(int i) {
        if (this.oaL.obo == 1) {
            if (this.oaL.obp == 1) {
                return ((((float) (this.oaY - 1)) * 0.5f) * this.oba) - (this.oba * ((float) i));
            }
            if (this.oaL.obp == 2) {
                return (this.oba * ((float) i)) - ((((float) (this.oaY - 1)) * 0.5f) * this.oba);
            }
        }
        return 0.0f;
    }

    final int aWY() {
        return (int) (Math.random() * ((double) this.oaY));
    }

    private void aWZ() {
        if (this.oaU != null) {
            x.i("ShuffleView", "selectView != null, cancel select");
            if (this.oaP.isStarted()) {
                this.oaP.cancel();
            }
            this.oaP.removeAllUpdateListeners();
            this.oaP.removeAllListeners();
            switch (this.oaL.obp) {
                case 4:
                    if (this.oaV >= 0) {
                        this.oaP.addUpdateListener(new 7(this));
                        break;
                    }
                    break;
            }
            this.oaU = null;
            this.oaV = 0;
            this.oaP.start();
        }
    }

    final void rX(int i) {
        if (i >= 0 && i < this.oaY) {
            x.i("ShuffleView", "select card " + i);
            if (this.oaP.isStarted()) {
                this.oaP.cancel();
            }
            this.oaP.removeAllUpdateListeners();
            this.oaP.removeAllListeners();
            this.oaU = (View) this.oaK.get(i);
            this.oaV = i;
            this.oaW = null;
            this.oaX = -1;
            switch (this.oaL.obp) {
                case 4:
                    if (i <= 0) {
                        this.oaP.addUpdateListener(new 9(this));
                        break;
                    }
                    this.oaP.addUpdateListener(new 8(this, i - 1, (this.oaY - 1) - i));
                    break;
            }
            this.oaP.start();
        }
    }

    private void aXa() {
        if (this.oaW != null) {
            x.i("ShuffleView", "touchView != null,cancel touch");
            if (this.oaP.isStarted()) {
                this.oaP.cancel();
            }
            this.oaP.removeAllUpdateListeners();
            this.oaP.removeAllListeners();
            switch (this.oaL.obp) {
                case 4:
                    if (this.oaX >= 0) {
                        this.oaP.addUpdateListener(new 10(this));
                        break;
                    }
                    break;
            }
            this.oaW = null;
            this.oaX = -1;
            this.oaP.start();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.obg) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.oaY <= 0) {
            return false;
        }
        x.d("ShuffleView", "y:%d,packet largest:%d", new Object[]{Integer.valueOf(y), Integer.valueOf((getHeight() - ((View) this.oaK.get(0)).getHeight()) - (((View) this.oaK.get(0)).getHeight() / 7))});
        if (y >= (getHeight() - ((View) this.oaK.get(0)).getHeight()) - (((View) this.oaK.get(0)).getHeight() / 7)) {
            int i;
            for (i = 0; i < this.oaY; i++) {
                Rect rY = rY(i);
                if (rY != null && rY.contains(x, y)) {
                    i = 1;
                    break;
                }
            }
            boolean z = false;
            if (i == 0) {
                x.d("ShuffleView", "event %d out of cards,%d,%d", new Object[]{Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y)});
                if (this.oaU != null && motionEvent.getActionMasked() == 0) {
                    if (this.oaR != null) {
                        this.oaR.cK(this.oaV, this.oaY);
                    }
                    aWZ();
                } else if (this.oaW != null && this.oaW.getTranslationY() == ((float) ((-this.oaW.getHeight()) / 7))) {
                    if (this.oaR != null) {
                        this.oaR.rT(this.oaY);
                    }
                    rX(this.oaX);
                } else if (this.oaW != null) {
                    aXa();
                }
            }
            if (this.oaY <= 1) {
                return false;
            }
            x.i("ShuffleView", "ret:%s,action:%s", new Object[]{Boolean.valueOf(this.lVX.onTouchEvent(motionEvent)), Integer.valueOf(motionEvent.getActionMasked())});
            if (!this.lVX.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1) {
                if (this.oaW != null && this.oaW.getTranslationY() == ((float) ((-this.oaW.getHeight()) / 7))) {
                    if (this.oaR != null) {
                        this.oaR.rT(this.oaY);
                    }
                    rX(this.oaX);
                } else if (this.oaW != null) {
                    aXa();
                }
            }
            return true;
        } else if (this.oaU != null && motionEvent.getActionMasked() == 0) {
            if (this.oaR != null) {
                this.oaR.cK(this.oaV, this.oaY);
            }
            aWZ();
            return false;
        } else if (this.oaW != null && this.oaW.getTranslationY() == ((float) ((-this.oaW.getHeight()) / 7))) {
            if (this.oaR != null) {
                this.oaR.rT(this.oaY);
            }
            rX(this.oaX);
            return false;
        } else if (this.oaW == null) {
            return false;
        } else {
            aXa();
            return false;
        }
    }

    private Rect rY(int i) {
        if (i >= 0 && i < this.oaY) {
            View view = (View) this.oaK.get(i);
            switch (this.oaL.obp) {
                case 4:
                    if (i == 0) {
                        return new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    }
                    View view2 = (View) this.oaK.get(i - 1);
                    return new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
            }
        }
        return null;
    }

    final void rZ(int i) {
        this.oaO.removeAllUpdateListeners();
        this.oaO.removeAllListeners();
        if (this.oaK.size() < this.oaY) {
            this.oaY--;
            if (this.oaY == 1) {
                ((View) this.oaK.get(0)).findViewById(f.unQ).setVisibility(0);
            }
            aWX();
            this.oaO.addUpdateListener(new 14(this));
            this.oaO.addListener(new 2(this));
        } else {
            this.oaT = (View) this.oaK.get(this.oaY - 1);
            y(this.oaT, this.oaY - 1);
            addView(this.oaT, 0);
            if (this.oaN != null) {
                switch (this.oaL.obq) {
                    case 1:
                        this.oaT.setTranslationY((float) (-icn.heightPixels));
                        break;
                    case 2:
                        this.oaT.setTranslationY((float) icn.heightPixels);
                        break;
                    case 3:
                        this.oaT.setTranslationX((float) (-icn.widthPixels));
                        break;
                    case 4:
                        this.oaT.setTranslationX((float) icn.widthPixels);
                        break;
                }
            }
            this.oaT.setVisibility(4);
            this.oaO.addUpdateListener(new 3(this, i));
            this.oaO.addListener(new 4(this));
        }
        this.oaO.start();
    }
}
