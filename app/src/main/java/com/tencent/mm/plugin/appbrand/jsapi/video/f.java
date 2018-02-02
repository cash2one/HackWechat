package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

public final class f {
    float jek = 0.0f;
    int jtA = -1;
    int jtB = 0;
    Runnable jtC = new 1(this);
    View jtu;
    int jtv = a.jtE;
    GestureDetector jtw;
    b jtx;
    int jty = 0;
    float jtz = 0.0f;
    Context mContext;

    public f(Context context, View view, b bVar) {
        this.mContext = context;
        this.jtx = bVar;
        this.jtu = view;
        this.jtw = new GestureDetector(this.mContext, new SimpleOnGestureListener(this) {
            final /* synthetic */ f jtD;

            {
                this.jtD = r1;
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                this.jtD.jtu.postDelayed(this.jtD.jtC, 200);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                this.jtD.jtu.removeCallbacks(this.jtD.jtC);
                this.jtD.jtx.agT();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (!(motionEvent == null || motionEvent2 == null)) {
                    if (this.jtD.jtv == a.jtE) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            this.jtD.jtv = a.jtH;
                        } else if (motionEvent.getX() < ((float) (this.jtD.jtu.getMeasuredWidth() / 2))) {
                            this.jtD.jtv = a.jtG;
                        } else {
                            this.jtD.jtv = a.jtF;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    f fVar = this.jtD;
                    if (fVar.jtv == a.jtH) {
                        if (fVar.jtA == -1) {
                            fVar.jtx.agU();
                            fVar.jtA = fVar.jtx.getCurrentPosition();
                        }
                        fVar.jtB = fVar.jtx.e(fVar.jtA, x);
                    } else if (fVar.jtv == a.jtG) {
                        x = (((y * -1.0f) / ((float) fVar.jtu.getMeasuredHeight())) * 1.2f) + fVar.jek;
                        if (x >= 0.0f) {
                            f4 = x > 1.0f ? 1.0f : x;
                        }
                        Context context = fVar.mContext;
                        if (context instanceof Activity) {
                            if (f4 < 0.01f) {
                                f3 = 0.01f;
                            } else if (f4 <= 1.0f) {
                                f3 = f4;
                            }
                            Activity activity = (Activity) context;
                            LayoutParams attributes = activity.getWindow().getAttributes();
                            attributes.screenBrightness = f3;
                            activity.getWindow().setAttributes(attributes);
                        }
                        fVar.jtx.Z(f4);
                    } else if (fVar.jtv == a.jtF) {
                        int i;
                        y *= -1.0f;
                        f3 = y / ((float) fVar.jtu.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f5 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f5;
                        if (i2 == 0 && Math.abs(f5) > 0.2f) {
                            if (y > 0.0f) {
                                i = 1;
                            } else if (y < 0.0f) {
                                i = -1;
                            }
                            i += fVar.jty;
                            if (i < 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            audioManager.setStreamVolume(3, i, 0);
                            fVar.jtx.Y(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += fVar.jty;
                        if (i < 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        audioManager.setStreamVolume(3, i, 0);
                        fVar.jtx.Y(((float) i) / ((float) streamMaxVolume));
                    }
                }
                return true;
            }
        });
        this.jek = g.bW(context);
    }
}
