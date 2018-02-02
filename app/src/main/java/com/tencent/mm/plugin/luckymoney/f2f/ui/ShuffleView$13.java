package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.graphics.Rect;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class ShuffleView$13 implements OnGestureListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$13(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        x.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(this.obk).obp) {
            case 4:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int i = 0;
                while (i < ShuffleView.d(this.obk)) {
                    Rect a = ShuffleView.a(this.obk, i);
                    if (a == null || !a.contains(x, y)) {
                        i++;
                    } else {
                        View view = (View) ShuffleView.e(this.obk).get(i);
                        if (ShuffleView.h(this.obk) != view && ShuffleView.h(this.obk) != null) {
                            ShuffleView.m(this.obk);
                        } else if (ShuffleView.h(this.obk) == view) {
                            x.i("ShuffleView", "down on the select card");
                            return true;
                        }
                        ShuffleView.b(this.obk, i);
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        switch (ShuffleView.l(this.obk).obp) {
            case 4:
                if (ShuffleView.h(this.obk) != null) {
                    x.d("ShuffleView", "click the select card");
                    if (ShuffleView.n(this.obk) != null) {
                        ShuffleView.n(this.obk).cK(ShuffleView.f(this.obk), ShuffleView.d(this.obk));
                    }
                    ShuffleView.m(this.obk);
                }
                if (ShuffleView.k(this.obk) != null) {
                    if (ShuffleView.n(this.obk) != null) {
                        ShuffleView.n(this.obk).rT(ShuffleView.d(this.obk));
                    }
                    ShuffleView.c(this.obk, ShuffleView.i(this.obk));
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent2.getActionMasked() == 2) {
            int x = (int) motionEvent2.getX();
            int y = (int) motionEvent2.getY();
            switch (ShuffleView.l(this.obk).obp) {
                case 4:
                    View view;
                    if (Math.abs(f2) < ((float) ShuffleView.o(this.obk))) {
                        for (int i = 0; i < ShuffleView.d(this.obk); i++) {
                            Rect a = ShuffleView.a(this.obk, i);
                            if (a != null && a.contains(x, y)) {
                                view = (View) ShuffleView.e(this.obk).get(i);
                                if (ShuffleView.h(this.obk) != view && ShuffleView.h(this.obk) != null) {
                                    ShuffleView.m(this.obk);
                                } else if (ShuffleView.h(this.obk) == view) {
                                    x.i("ShuffleView", "scroll on the select card");
                                }
                                if (ShuffleView.k(this.obk) != view) {
                                    ShuffleView.p(this.obk);
                                    ShuffleView.b(this.obk, i);
                                }
                            }
                        }
                    }
                    if (Math.abs(f) < ((float) ShuffleView.o(this.obk))) {
                        x.d("ShuffleView", "scroll distanceY:" + f2);
                        if (ShuffleView.k(this.obk) != null) {
                            view = ShuffleView.k(this.obk);
                        } else if (ShuffleView.h(this.obk) != null) {
                            view = ShuffleView.h(this.obk);
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            x.i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                            if (((int) view.getTranslationY()) > (-view.getHeight()) / 7) {
                                if (view.getTranslationY() != 0.0f) {
                                    if (f2 >= 0.0f) {
                                        if (((int) (view.getTranslationY() - f2)) > (-view.getHeight()) / 7) {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                            break;
                                        }
                                        view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        break;
                                    } else if (view.getTranslationY() - f2 < 0.0f) {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                        break;
                                    } else {
                                        view.setTranslationY(0.0f);
                                        break;
                                    }
                                } else if (f2 > 0.0f && Math.abs(f2) > ((float) ShuffleView.o(this.obk))) {
                                    if (((int) f2) < view.getHeight() / 7) {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                        break;
                                    }
                                    view.setTranslationY((float) ((-view.getHeight()) / 7));
                                    break;
                                }
                            } else if (f2 < 0.0f && Math.abs(f2) > ((float) ShuffleView.o(this.obk))) {
                                if (((int) f2) <= (-view.getHeight()) / 7) {
                                    view.setTranslationY(0.0f);
                                } else {
                                    view.setTranslationY(view.getTranslationY() - f2);
                                }
                                if (view == ShuffleView.h(this.obk)) {
                                    ShuffleView.a(this.obk, ShuffleView.h(this.obk));
                                    ShuffleView.d(this.obk, ShuffleView.f(this.obk));
                                    if (ShuffleView.q(this.obk).isStarted()) {
                                        x.i("ShuffleView", "scroll when select view is animation");
                                        ShuffleView.q(this.obk).cancel();
                                    }
                                    ShuffleView.b(this.obk, null);
                                    ShuffleView.e(this.obk, 0);
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.i("ShuffleView", "fling up " + f2);
        if (f2 >= ((float) (-ShuffleView.r(this.obk)))) {
            return false;
        }
        switch (ShuffleView.l(this.obk).obp) {
            case 4:
                if (ShuffleView.h(this.obk) != null) {
                    ShuffleView.m(this.obk);
                }
                if (ShuffleView.k(this.obk) != null) {
                    if (ShuffleView.n(this.obk) != null) {
                        ShuffleView.n(this.obk).rT(ShuffleView.d(this.obk));
                    }
                    ShuffleView.c(this.obk, ShuffleView.i(this.obk));
                    break;
                }
                break;
        }
        return true;
    }
}
