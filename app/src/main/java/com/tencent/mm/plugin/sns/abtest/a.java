package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;

public final class a {
    private static Context context = null;
    private static boolean qNm = false;
    private static String qNn = "0";
    private static OnClickListener qNo = null;
    private static int qNp = -1;
    private static int qNq = -1;
    private static long qNr = 0;
    private static View qNs = null;
    private static b qNt = null;
    private static c qNu = null;
    private static com.tencent.mm.sdk.b.c qNv = new 1();
    private static com.tencent.mm.sdk.b.c qNw = new 2();

    static /* synthetic */ void a(View view, Context context, m mVar) {
        if (context != null) {
            if (mVar != null) {
                qNr = mVar.field_snsId;
            }
            b bVar = qNt;
            if (view != null && !bVar.qNS) {
                com.tencent.mm.sdk.b.a.xef.m(new bp());
                if (bVar.qNQ) {
                    bVar.btT();
                    return;
                }
                if (bVar.jNd == 0) {
                    bVar.jNd = e.eb(context);
                }
                if (bVar.MP == 0) {
                    bVar.MP = e.ea(context);
                }
                if (bVar.qNL == 0) {
                    bVar.qNL = view.getMeasuredHeight();
                    if (bVar.qNL <= 0) {
                        bVar.qNL = com.tencent.mm.bv.a.fromDPToPix(context, 15);
                    }
                }
                if (bVar.qNM <= 0) {
                    bVar.qNM = com.tencent.mm.bv.a.fromDPToPix(context, 8);
                }
                if (bVar.qNN <= 0) {
                    bVar.qNN = com.tencent.mm.bv.a.fromDPToPix(context, 3);
                }
                if (bVar.mScreenHeight == 0) {
                    bVar.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                    bVar.mScreenHeight -= bVar.MP;
                    bVar.mScreenHeight -= bVar.jNd;
                }
                if (bVar.qNO == 0) {
                    bVar.qNO = com.tencent.mm.bv.a.fromDPToPix(context, 150);
                }
                if (bVar.qNP == 0) {
                    bVar.qNP = com.tencent.mm.bv.a.fromDPToPix(context, 13);
                }
                bVar.qNE = new NotInterestMenu(context);
                if (bVar.qNz != null) {
                    bVar.qNE.qNz = bVar.qNz;
                }
                bVar.qNE.qNA = bVar.qNG;
                bVar.qNE.qyg = mVar;
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                x.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", new Object[]{Arrays.toString(iArr)});
                int i = (((iArr[1] - bVar.jNd) - bVar.MP) + bVar.qNL) - bVar.qNM;
                x.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.jNd), Integer.valueOf(bVar.MP), Integer.valueOf(bVar.qNL), Integer.valueOf(bVar.qNM)});
                x.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bVar.qNO), Integer.valueOf(bVar.mScreenHeight)});
                if (bVar.qNO + i <= bVar.mScreenHeight) {
                    bVar.qNE.setBackgroundResource(i.e.qzr);
                    bVar.qNT = true;
                } else {
                    bVar.qNE.setBackgroundResource(i.e.qzs);
                    i = (((iArr[1] - bVar.jNd) - bVar.MP) - bVar.qNO) + bVar.qNN;
                    x.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.jNd), Integer.valueOf(bVar.MP), Integer.valueOf(bVar.qNL), Integer.valueOf(bVar.qNN), Integer.valueOf(bVar.qNO)});
                    bVar.qNT = false;
                }
                if (bVar.qNR == null) {
                    bVar.qNR = new AbsoluteLayout(context);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bVar.qNR.setBackgroundDrawable(context.getResources().getDrawable(i.e.qyW));
                    bVar.qNR.setPadding(bVar.qNP, 0, bVar.qNP, 0);
                    bVar.qNR.setLayoutParams(layoutParams);
                }
                if (bVar.qNF != null) {
                    bVar.qNF.addView(bVar.qNR);
                }
                bVar.qNR.addView(bVar.qNE, new AbsoluteLayout.LayoutParams(-1, -2, 0, i));
                bVar.qNE.setVisibility(4);
                if (bVar.qNT) {
                    bVar.qNE.startAnimation(bVar.qNH);
                } else {
                    bVar.qNE.startAnimation(bVar.qNI);
                }
            }
        }
    }

    static /* synthetic */ void akq() {
        if (qNm && qNr != 0) {
            String str = qNp + "|" + qNq + "|" + qNr;
            g.Ij().ie("7").hil = 4;
            g.Ij().ie("7").result = str;
            f.a(g.Ij().ie("7"));
            x.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", new Object[]{Integer.valueOf(4), str});
        }
        qNq = -1;
        qNp = -1;
        qNr = 0;
    }

    static /* synthetic */ void b(Context context, m mVar) {
        if (mVar != null && context != null) {
            a(mVar);
            String str = mVar.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", mVar.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void c(Context context, m mVar) {
        if (mVar != null && context != null) {
            a(mVar);
            Intent intent = new Intent();
            x.i("MicroMsg.NotInteresetABTestManager", "expose id " + mVar.bxW());
            intent.putExtra("showShare", false);
            intent.putExtra("k_expose_msg_id", mVar == null ? 0 : mVar.field_snsId);
            intent.putExtra("k_username", mVar == null ? "" : mVar.field_userName);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static void d(Context context, ViewGroup viewGroup) {
        if (g.Ij().ie("7") != null) {
            qNm = true;
            qNn = g.Ij().ie("7").value;
            x.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[]{qNn});
            qNs = viewGroup;
            qNt = new b(viewGroup);
            context = context;
            com.tencent.mm.sdk.b.a.xef.b(qNv);
            com.tencent.mm.sdk.b.a.xef.b(qNw);
            qNo = new 3();
            qNu = new 4();
            qNt.qNz = qNu;
        }
    }

    public static void btP() {
        if (qNt != null) {
            qNt.btT();
        }
    }

    private static void a(m mVar) {
        boolean equals = qNn.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (mVar.field_type == 1) {
            if (equals) {
                qNq = 5;
            } else {
                qNq = 0;
            }
        } else if (mVar.field_type == 2) {
            if (equals) {
                qNq = 4;
            } else {
                qNq = 1;
            }
        } else if (mVar.field_type == 15) {
            if (!equals) {
                qNq = 2;
            }
        } else if (!com.tencent.mm.plugin.sns.data.i.f(mVar)) {
        } else {
            if (equals) {
                qNq = 6;
            } else {
                qNq = 3;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Context context, m mVar) {
        int i = 2;
        if (qNm && mVar != null && context != null) {
            qNr = mVar.field_snsId;
            a(mVar);
            Intent intent = new Intent(context, SnsNotInterestUI.class);
            intent.putExtra("sns_info_svr_id", qNr);
            String str = "sns_info_not_interest_scene";
            if (qNm && !bh.ov(qNn)) {
                if (qNn.equals("1") || qNn.equals("2")) {
                    i = 1;
                    intent.putExtra(str, i);
                    context.startActivity(intent);
                } else if (qNn.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    if (com.tencent.mm.plugin.sns.data.i.f(mVar)) {
                        i = 4;
                    } else if (mVar.field_type == 1) {
                        i = 3;
                    }
                    intent.putExtra(str, i);
                    context.startActivity(intent);
                }
            }
            i = 0;
            intent.putExtra(str, i);
            context.startActivity(intent);
        }
    }

    public static void a(ContextMenu contextMenu, m mVar) {
        if (qNm && qNn.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && mVar != null && !mVar.xl(32) && !mVar.field_userName.equals(ae.bvb()) && mVar.field_type != 15) {
            contextMenu.add(0, 13, 0, j.qLb);
        }
    }

    public static void a(View view, a$c com_tencent_mm_plugin_sns_ui_a_a_c) {
        if (qNm && !bh.ov(qNn) && !qNn.equals("0")) {
            com_tencent_mm_plugin_sns_ui_a_a_c.rOB = (ImageView) view.findViewById(i.f.qEw);
            com_tencent_mm_plugin_sns_ui_a_a_c.rOB.setVisibility(8);
            com_tencent_mm_plugin_sns_ui_a_a_c.rOC = false;
            if (!qNn.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                com_tencent_mm_plugin_sns_ui_a_a_c.rOB.setOnClickListener(qNo);
            }
        }
    }

    public static void b(m mVar) {
        if (qNm) {
            qNr = mVar.field_snsId;
            a(mVar);
        }
    }

    public static void clean() {
        qNq = -1;
        qNp = -1;
        qNr = 0;
        qNo = null;
        qNu = null;
        qNs = null;
        context = null;
        qNm = false;
        qNn = "0";
        f.ij("7");
        com.tencent.mm.sdk.b.a.xef.c(qNv);
        com.tencent.mm.sdk.b.a.xef.c(qNw);
    }
}
