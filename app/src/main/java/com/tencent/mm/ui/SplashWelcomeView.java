package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.bq;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SplashWelcomeView extends FrameLayout implements ak {
    private Bitmap bitmap;
    private boolean hasDrawed;
    private volatile boolean xMM;
    private volatile boolean xMN;
    private ImageView xMO;
    private int xMP;

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fw(context);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        fw(context);
    }

    private void fw(Context context) {
        SharedPreferences sharedPreferences;
        String H;
        if (ac.cfw()) {
            sharedPreferences = ac.getContext().getSharedPreferences("switch_account_preferences", 0);
            try {
                x.i("SplashWelcomeView", "transit to switch account %s", Boolean.valueOf(sharedPreferences.getBoolean("transit_to_switch_account", false)));
                if (sharedPreferences.getBoolean("transit_to_switch_account", false)) {
                    sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
                    View inflate = ((Activity) context).getLayoutInflater().inflate(R.i.dsj, null);
                    SwitchAccountGridView switchAccountGridView = (SwitchAccountGridView) inflate.findViewById(R.h.cPM);
                    switchAccountGridView.setRowCount(1);
                    switchAccountGridView.setClickable(false);
                    inflate.findViewById(R.h.cPL).setVisibility(8);
                    inflate.findViewById(R.h.cPJ).setVisibility(8);
                    TextView textView = (TextView) inflate.findViewById(R.h.cPO);
                    x.i("SplashWelcomeView", "activity resources %s, application resources %s", context.getResources(), ac.getResources());
                    textView.setText(context.getResources().getString(R.l.eNp));
                    Set<String> HV = bq.hhK.HV();
                    H = aq.hfP.H("login_weixin_username", "");
                    Map hashMap = new HashMap();
                    if (bh.ov(H) || HV.contains(H)) {
                        for (String str : HV) {
                            hashMap.put(str, new SwitchAccountModel(str, bq.hhK.getString(str, "login_user_name"), bq.hhK.getString(str, "last_avatar_path"), bq.hhK.getString(str, "last_logout_no_pwd_ticket"), bh.VI(bq.hhK.getString(str, "last_login_use_voice"))));
                        }
                    } else {
                        hashMap.put(H, new SwitchAccountModel(H, aq.hfP.H("login_user_name", ""), aq.hfP.GY(), aq.hfP.H("last_logout_no_pwd_ticket", ""), bh.VI(aq.hfP.H("last_login_use_voice", ""))));
                    }
                    switchAccountGridView.qmZ = true;
                    switchAccountGridView.O(hashMap);
                    switchAccountGridView.qgX = H;
                    switchAccountGridView.qmY = true;
                    switchAccountGridView.brm();
                    addView(inflate, new LayoutParams(-1, -1));
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("SplashWelcomeView", e, "show switch account view with exception!", new Object[0]);
            }
        }
        this.xMO = new SplashImageView(context);
        this.xMO.setScaleType(ScaleType.CENTER_CROP);
        ((SplashImageView) this.xMO).xML = this;
        addView(this.xMO, new LayoutParams(-1, -1));
        try {
            if (ac.cfw()) {
                sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 0);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                x.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(sharedPreferences.getLong("new_launch_image_begin_time", 0)), Long.valueOf(sharedPreferences.getLong("new_launch_image_end_time", 0)), Long.valueOf(currentTimeMillis));
                H = a.gZK + "splashWelcomeImg";
                if (currentTimeMillis <= sharedPreferences.getLong("new_launch_image_begin_time", 0) || currentTimeMillis >= r6) {
                    x.i("SplashWelcomeView", "change launch image activity is finished!");
                    b.deleteFile(H);
                    return;
                }
                Object obj;
                this.xMP = sharedPreferences.getInt("launch_fail_times", 0);
                int i = sharedPreferences.getInt("launch_last_status", 0);
                if (i == 1) {
                    x.i("SplashWelcomeView", "last launch status is 'start'.");
                    this.xMP++;
                    sharedPreferences.edit().putInt("launch_fail_times", this.xMP).commit();
                } else if (i == 2) {
                    x.i("SplashWelcomeView", "last launch status is 'end'.");
                }
                sharedPreferences.edit().putInt("launch_last_status", 1).apply();
                if (this.xMP >= 3) {
                    x.i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.xMP));
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    e.post(new Runnable(this) {
                        final /* synthetic */ SplashWelcomeView xMR;

                        public final void run() {
                            /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                            /*
                            r6 = this;
                            r2 = 1;
                            r4 = 0;
                            r0 = r3;
                            r0 = com.tencent.mm.a.e.bO(r0);
                            if (r0 == 0) goto L_0x0084;
                        L_0x000a:
                            r0 = r3;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r1 = 0;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2 = r3;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2 = com.tencent.mm.a.e.bN(r2);	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r0 = com.tencent.mm.a.e.d(r0, r1, r2);	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            if (r0 == 0) goto L_0x0045;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                        L_0x0019:
                            r1 = r0.length;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            if (r1 <= 0) goto L_0x0045;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                        L_0x001c:
                            r1 = r6.xMR;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2 = 0;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r3 = r0.length;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r3);	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r1.bitmap = r0;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r0 = "SplashWelcomeView";	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r1 = "ready to play animation, hasDrawed %s";	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2 = 1;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r3 = 0;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r4 = r6.xMR;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r4 = r4.hasDrawed;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2[r3] = r4;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r0 = r6.xMR;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r0.xMN = true;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                        L_0x0045:
                            r0 = r6.xMR;
                            r0 = r0.hasDrawed;
                            if (r0 == 0) goto L_0x0052;
                        L_0x004d:
                            r0 = r6.xMR;
                            r0.cnE();
                        L_0x0052:
                            return;
                        L_0x0053:
                            r0 = move-exception;
                            r1 = "SplashWelcomeView";	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r2 = "decode new welcome image error: %s";	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r3 = 1;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r4 = 0;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r5 = r0.getMessage();	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r3[r4] = r5;	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ Exception -> 0x0053, all -> 0x0075 }
                            r0 = r6.xMR;
                            r0 = r0.hasDrawed;
                            if (r0 == 0) goto L_0x0052;
                        L_0x006f:
                            r0 = r6.xMR;
                            r0.cnE();
                            goto L_0x0052;
                        L_0x0075:
                            r0 = move-exception;
                            r1 = r6.xMR;
                            r1 = r1.hasDrawed;
                            if (r1 == 0) goto L_0x0083;
                        L_0x007e:
                            r1 = r6.xMR;
                            r1.cnE();
                        L_0x0083:
                            throw r0;
                        L_0x0084:
                            r0 = "SplashWelcomeView";
                            r1 = "cannot find %s";
                            r2 = new java.lang.Object[r2];
                            r3 = r3;
                            r2[r4] = r3;
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
                            goto L_0x0052;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.SplashWelcomeView.1.run():void");
                        }
                    }, "readWelcomeBg");
                    return;
                }
                return;
            }
            x.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
        } catch (Throwable e2) {
            x.printErrStackTrace("SplashWelcomeView", e2, "%s", e2.getMessage());
        }
    }

    private synchronized void cnE() {
        if (!this.xMM) {
            this.xMM = true;
            if (this.bitmap != null) {
                try {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ SplashWelcomeView xMR;

                        {
                            this.xMR = r1;
                        }

                        public final void run() {
                            x.d("SplashWelcomeView", "set top imageView");
                            final View imageView = new ImageView(this.xMR.getContext());
                            imageView.setScaleType(ScaleType.CENTER_CROP);
                            imageView.setImageBitmap(this.xMR.bitmap);
                            imageView.setAlpha(0.0f);
                            this.xMR.addView(imageView, new LayoutParams(-1, -1));
                            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1000);
                            duration.addUpdateListener(new AnimatorUpdateListener(this) {
                                final /* synthetic */ AnonymousClass2 xMT;

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            });
                            duration.start();
                            x.i("SplashWelcomeView", "start play animation");
                        }
                    });
                } catch (Throwable e) {
                    x.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
                }
            }
        }
    }

    public final void aOk() {
        x.i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.xMN && !this.xMM) {
                cnE();
            }
        }
    }
}
