package com.tencent.mm.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI.a;
import com.tencent.mm.ui.LauncherUI.b;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.z.ar;
import java.util.List;

public final class z implements a {
    boolean isAnimating = false;
    boolean mChattingClosed = true;
    Animation mChattingInAnim;
    Animation mChattingOutAnim;
    boolean mNeedChattingAnim;
    Bitmap mPrepareBitmap;
    OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new 7(this);
    MMFragmentActivity qwI;
    TestTimeForChatting xLA;
    private int xLB;
    View xLC;
    View xLD;
    IdleHandler xLE;
    OnLayoutChangedLinearLayout xLF;
    String xLG;
    String xLH;
    Bundle xLI;
    a xLJ = new a(this, (byte) 0);
    Runnable xLK = new 6(this);
    ChattingUI.a xLx;
    b xLy;
    long xLz = 0;

    static /* synthetic */ void a(z zVar) {
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimStart]");
        zVar.isAnimating = true;
        if (zVar.xLA != null) {
            zVar.xLA.setTranslationX(0.0f);
            zVar.xLA.gTs = 0;
        }
    }

    static /* synthetic */ void a(z zVar, Intent intent, boolean z) {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        if (zVar.xLx == null) {
            zVar.xLx = ChattingUI.a.csE();
            zVar.xLx.d(zVar.xLC, zVar.xLD);
            zVar.xLC = null;
            zVar.xLD = null;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr;
        View cnw;
        ViewGroup viewGroup;
        if (zVar.xLA == null) {
            if (zVar.xLx.isSupportNavigationSwipeBack()) {
                iArr = new int[2];
                zVar.qwI.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(zVar.qwI);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(R.h.bTO);
                zVar.xLB = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                View homeUI$FitSystemWindowLayoutView = new HomeUI$FitSystemWindowLayoutView(zVar.qwI);
                homeUI$FitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                cnw = zVar.cnw();
                if (cnw == null) {
                    cnw = ((ViewGroup) zVar.qwI.getWindow().getDecorView()).getChildAt(0);
                }
                View imageView = new ImageView(zVar.qwI);
                imageView.setId(R.h.cDn);
                imageView.setLayoutParams(testTimeForChatting.getLayoutParams());
                imageView.setVisibility(8);
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView GONE");
                viewGroup = (ViewGroup) cnw;
                ((ViewGroup) zVar.qwI.getWindow().getDecorView()).removeView(cnw);
                cnw.setId(R.h.csz);
                homeUI$FitSystemWindowLayoutView.addView(cnw);
                homeUI$FitSystemWindowLayoutView.addView(imageView);
                homeUI$FitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) zVar.qwI.getWindow().getDecorView()).addView(homeUI$FitSystemWindowLayoutView);
                zVar.qwI.getWindow().getDecorView().requestFitSystemWindows();
                int i = iArr[1];
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::fitSystemWindows. statusBarHeight:%d", new Object[]{Integer.valueOf(i)});
                if (i > 0) {
                    zVar.xLy.a(homeUI$FitSystemWindowLayoutView, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    zVar.qwI.getSupportActionBar().getCustomView().post(new 4(zVar, iArr, homeUI$FitSystemWindowLayoutView, viewGroup));
                }
                zVar.xLA = (TestTimeForChatting) zVar.qwI.findViewById(zVar.xLB);
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[]{Integer.valueOf(iArr[1])});
            } else {
                zVar.xLA = (TestTimeForChatting) zVar.qwI.findViewById(R.h.bTs);
                zVar.xLB = zVar.xLA.getId();
            }
        } else if (zVar.xLx.isSupportNavigationSwipeBack()) {
            iArr = new int[2];
            zVar.xLA.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                viewGroup = (ViewGroup) zVar.qwI.getWindow().getDecorView();
                int i2 = 0;
                while (i2 < viewGroup.getChildCount()) {
                    cnw = ((ViewGroup) zVar.qwI.getWindow().getDecorView()).getChildAt(i2);
                    if (cnw instanceof HomeUI$FitSystemWindowLayoutView) {
                        zVar.qwI.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        HomeUI$FitSystemWindowLayoutView homeUI$FitSystemWindowLayoutView2 = (HomeUI$FitSystemWindowLayoutView) cnw;
                        ViewGroup viewGroup2 = (ViewGroup) zVar.qwI.findViewById(R.h.csz);
                        i2 = viewGroup2.getPaddingTop();
                        int ai = u.ai(zVar.qwI, -1);
                        Rect rect = new Rect();
                        Window window = zVar.qwI.getWindow();
                        window.getDecorView().getWindowVisibleDisplayFrame(rect);
                        int height = window.getDecorView().getHeight();
                        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i2), Integer.valueOf(e.eb(zVar.qwI)), Integer.valueOf(ai), Integer.valueOf(rect.top), Integer.valueOf(rect.height()), Integer.valueOf(height), Integer.valueOf(homeUI$FitSystemWindowLayoutView2.xGG)});
                        homeUI$FitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, homeUI$FitSystemWindowLayoutView2.xGG, 0, 0));
                        ImageView imageView2 = (ImageView) homeUI$FitSystemWindowLayoutView2.findViewById(R.h.cDn);
                        imageView2.setTag(viewGroup2);
                        imageView2.setLayoutParams(viewGroup2.getLayoutParams());
                        Bitmap magicDrawingCache = zVar.getMagicDrawingCache(viewGroup2);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup2.setVisibility(8);
                            imageView2.setVisibility(0);
                            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            viewGroup2.setVisibility(0);
                            imageView2.setVisibility(8);
                            imageView2.setImageDrawable(null);
                            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView GONE");
                        }
                    } else {
                        x.e("MicroMsg.LauncherUI.NewChattingTabUI", "on position %d, rootLayout not found!", new Object[]{Integer.valueOf(i2)});
                        i2++;
                    }
                }
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[]{Integer.valueOf(iArr[1])});
        }
        if (z2) {
            zVar.xLx.hHG = true;
            zVar.xLx.nWQ = false;
            zVar.xLx.setArguments(t.ah(intent));
            if (zVar.cnx()) {
                zVar.qwI.getSupportFragmentManager().aS().a(zVar.xLB, zVar.xLx).commitAllowingStateLoss();
                zVar.qwI.getSupportFragmentManager().executePendingTransactions();
            } else {
                zVar.qwI.getSupportFragmentManager().aS().b(zVar.xLB, zVar.xLx).commitAllowingStateLoss();
            }
            zVar.xLF = (OnLayoutChangedLinearLayout) zVar.xLx.getView().findViewById(R.h.bTA);
            zVar.xLx.mL(true);
        } else {
            if (!z) {
                zVar.xLx.ywb.yBP = HardCoderJNI.startPerformance(HardCoderJNI.hcEnterChattingEnable, HardCoderJNI.hcEnterChattingDelay, HardCoderJNI.hcEnterChattingCPU, HardCoderJNI.hcEnterChattingIO, HardCoderJNI.hcEnterChattingThr ? g.Dm().cfD() : 0, HardCoderJNI.hcEnterChattingTimeout, 301, HardCoderJNI.hcEnterChattingAction, "MicroMsg.ChattingUI.TextImp");
                x.i("MicroMsg.ChattingUI.TextImp", "hardCoderEnterChattingStart %s", new Object[]{Integer.valueOf(r0.yBP)});
            }
            zVar.xLx.hHG = true;
            zVar.xLx.nWQ = false;
            zVar.xLx.getArguments().putAll(t.ah(intent));
            zVar.xLx.cqW();
            zVar.xLx.onResume();
            zVar.xLx.mL(true);
        }
        if (zVar.xLx.isSupportNavigationSwipeBack()) {
            zVar.xLx.getSwipeBackLayout().nE(false);
        }
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent});
    }

    static /* synthetic */ void b(z zVar) {
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimEnd]");
        zVar.isAnimating = false;
        if (zVar.xLA != null) {
            zVar.xLA.postDelayed(new 9(zVar), 60);
        }
    }

    public z(b bVar) {
        this.xLy = bVar;
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        String str2 = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.xLA == null ? false : this.xLA.isShown());
        x.i(str2, str3, objArr);
        if (!(this.xLx == null || this.xLx.getView() == null)) {
            this.xLx.getView().setImportantForAccessibility(1);
        }
        ar.getNotification().aU(false);
        this.xLI = bundle;
        this.xLH = str;
        this.mNeedChattingAnim = z;
        ar.Dm().cfC();
        ag.Df(-8);
        ag.y(this.xLK);
    }

    private ViewGroup cnw() {
        ViewParent parent = this.qwI.getSupportActionBar().getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent decorView = this.qwI.getWindow().getDecorView();
        while (parent != decorView && parent != null) {
            ViewParent viewParent2 = parent;
            parent = parent.getParent();
            viewParent = viewParent2;
        }
        return (ViewGroup) viewParent;
    }

    private boolean cnx() {
        List<Fragment> aT = this.qwI.getSupportFragmentManager().aT();
        if (aT == null) {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "fragments is null");
            return true;
        }
        if (aT.size() >= 5) {
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "fragments more than 5! %s", new Object[]{Integer.valueOf(aT.size())});
            for (Fragment fragment : aT) {
                if (fragment instanceof ChattingUI.a) {
                    x.e("MicroMsg.LauncherUI.NewChattingTabUI", "fragments more than 5 and find a ChattingUIFragmet!!");
                    return false;
                }
            }
        }
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "fragments size %s", new Object[]{Integer.valueOf(aT.size())});
        return true;
    }

    public final String getString(int i) {
        return this.qwI.getString(i);
    }

    public final boolean cmM() {
        return this.xLx == null ? false : this.xLx.hHG;
    }

    final boolean cny() {
        if (d.fM(19) && com.tencent.mm.compatible.h.a.zc() && !com.tencent.mm.compatible.e.b.aK(this.qwI)) {
            return true;
        }
        return false;
    }

    final void pY(int i) {
        com.tencent.mm.sdk.f.e.post(new 5(this, i), "directReport_onResume");
    }

    public final Bitmap getMagicDrawingCache(View view) {
        int measuredWidth;
        int measuredHeight;
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            measuredWidth = view.getMeasuredWidth();
        } else {
            measuredWidth = width;
        }
        if (height <= 0) {
            measuredHeight = view.getMeasuredHeight();
        } else {
            measuredHeight = height;
        }
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            return null;
        } else if (this.xLx.getView() == null) {
            return null;
        } else {
            if (this.xLx != null) {
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[]{Integer.valueOf(this.xLx.getView().getBottom()), Integer.valueOf(this.xLx.keyboardState())});
            }
            if (this.xLx == null || this.xLx.keyboardState() != 1 || this.xLx.getView().getBottom() >= (this.qwI.getResources().getDisplayMetrics().heightPixels * 2) / 3) {
                if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != measuredWidth || this.mPrepareBitmap.getHeight() != measuredHeight) {
                    if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                        this.mPrepareBitmap.recycle();
                    }
                    try {
                        this.mPrepareBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_4444);
                    } catch (OutOfMemoryError e) {
                        x.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", new Object[]{e});
                        return null;
                    }
                }
                this.mPrepareBitmap.eraseColor(0);
                Canvas canvas = new Canvas(this.mPrepareBitmap);
                width = (int) this.qwI.getResources().getDimension(R.f.bys);
                int dimension = (int) this.qwI.getResources().getDimension(R.f.buH);
                Paint paint = new Paint();
                paint.setColor(-1);
                canvas.drawRect(0.0f, (float) width, (float) measuredWidth, (float) (measuredHeight - dimension), paint);
                view.draw(canvas);
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return this.mPrepareBitmap;
            }
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[]{Integer.valueOf(this.xLx.keyboardState())});
            return null;
        }
    }

    final void tryResetChattingSwipeStatus() {
        boolean z = true;
        if (cny()) {
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.xLx != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.xLx != null) {
                this.xLx.getSwipeBackLayout().zsB = false;
            }
        }
    }

    public final boolean w(boolean z, int i) {
        long j = 120;
        x.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(this.xLy.cmA())});
        if (!cny()) {
            return true;
        }
        if (!this.xLy.cmA()) {
            return false;
        }
        View findViewById = this.qwI.findViewById(R.h.csz);
        if (findViewById == null) {
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
            return true;
        }
        ImageView imageView = (ImageView) this.qwI.findViewById(R.h.cDn);
        if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
            imageView.setVisibility(0);
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
            findViewById.setVisibility(8);
        }
        if (imageView == null || imageView.getVisibility() != 0) {
            if (z) {
                if (i <= 0) {
                    j = 240;
                }
                j.a(findViewById, j, 0.0f, 0.125f);
            } else {
                if (i <= 0) {
                    j = 240;
                }
                j.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
            }
        } else if (z) {
            if (i <= 0) {
                j = 240;
            }
            j.a(imageView, j, 0.0f, 0.125f);
        } else {
            if (i <= 0) {
                j = 240;
            }
            j.a(imageView, j, (float) ((imageView.getWidth() * -1) / 4), 0.75f);
        }
        return true;
    }
}
