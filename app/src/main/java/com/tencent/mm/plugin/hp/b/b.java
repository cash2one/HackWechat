package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.PayuSecureEncrypt$EncrptType;

public final class b {
    private static long nAD = 0;

    public static void aSv() {
        g.pQN.a(338, 9, 1, false);
    }

    public static void rh(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        switch (i) {
            case 0:
                g.pQN.a(338, 0, 1, false);
                break;
            case 1:
                g.pQN.a(338, 20, 1, false);
                break;
            case 2:
                g.pQN.a(614, 0, 1, false);
                break;
        }
        nAD = bh.Wq();
    }

    public static void ri(int i) {
        long bA = bh.bA(nAD);
        x.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[]{Long.valueOf(bA)});
        switch (i) {
            case 1:
                g.pQN.a(338, 40, 1, false);
                break;
        }
        if (bA < 0) {
            x.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
        } else if (bA <= 5000) {
            g.pQN.V(338, 1, 43);
        } else if (bA <= 60000) {
            g.pQN.V(338, 1, 44);
        } else if (bA <= 180000) {
            g.pQN.V(338, 1, 45);
        } else {
            g.pQN.V(338, 1, 46);
        }
    }

    public static void rj(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report download failed");
        switch (i) {
            case 0:
                g.pQN.a(338, 41, 1, false);
                return;
            case 1:
                g.pQN.a(338, 42, 1, false);
                return;
            case 2:
                g.pQN.a(614, 3, 1, false);
                return;
            default:
                return;
        }
    }

    public static void fM(boolean z) {
        x.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        g.pQN.V(338, 2, 71);
        if (z) {
            g.pQN.a(338, 7, 1, true);
        }
    }

    public static void rk(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i) {
            case DownloadResult.CODE_SOCKET_EXCEPTION /*-26*/:
                g.pQN.a(338, 83, 1, false);
                return;
            case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                g.pQN.a(338, 82, 1, false);
                return;
            case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                g.pQN.a(338, 81, 1, false);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                g.pQN.a(338, 79, 1, false);
                return;
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                g.pQN.a(338, 80, 1, false);
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                g.pQN.a(338, 77, 1, false);
                return;
            case PayuSecureEncrypt$EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                g.pQN.a(338, 76, 1, false);
                return;
            case -7:
                g.pQN.a(338, 84, 1, false);
                return;
            case -6:
                g.pQN.a(338, 78, 1, false);
                return;
            case -5:
                g.pQN.a(338, 85, 1, false);
                return;
            case -4:
                g.pQN.a(338, 74, 1, false);
                return;
            case -3:
                g.pQN.a(338, 73, 1, false);
                return;
            case -2:
                g.pQN.a(338, 75, 1, false);
                return;
            case -1:
                g.pQN.a(338, 72, 1, false);
                return;
            default:
                return;
        }
    }

    public static void L(Intent intent) {
        KVCommCrossProcessReceiver.bod();
        x.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            g.pQN.V(338, 6, 127);
        } else if (ShareIntentUtil.j(intent, "patch_path_extra") == null) {
            g.pQN.V(338, 6, FileUtils.S_IWUSR);
        } else {
            g.pQN.a(338, 6, 1, true);
        }
    }

    public static void j(long j, boolean z) {
        if (z) {
            g.pQN.a(338, 3, 1, true);
        }
        if (z) {
            g.pQN.a(338, 101, 1, false);
        } else {
            g.pQN.a(338, 103, 1, false);
        }
        x.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            x.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
        } else if (j <= 5000) {
            if (z) {
                g.pQN.a(338, 117, 1, false);
            } else {
                g.pQN.a(338, 122, 1, false);
            }
        } else if (j <= 10000) {
            if (z) {
                g.pQN.a(338, 118, 1, false);
            } else {
                g.pQN.a(338, 123, 1, false);
            }
        } else if (j <= 30000) {
            if (z) {
                g.pQN.a(338, 119, 1, false);
            } else {
                g.pQN.a(338, 124, 1, false);
            }
        } else if (j > 60000) {
            if (j >= 3600000) {
                g.pQN.a(338, 133, 1, false);
            }
            if (z) {
                g.pQN.a(338, 121, 1, false);
            } else {
                g.pQN.a(338, 126, 1, false);
            }
        } else if (z) {
            g.pQN.a(338, 120, 1, false);
        } else {
            g.pQN.a(338, 125, 1, false);
        }
    }

    public static void rl(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -8:
                g.pQN.V(338, 107, 131);
                return;
            case -7:
                g.pQN.V(338, 107, 113);
                return;
            case -6:
                g.pQN.V(338, 107, MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
                return;
            case -5:
                g.pQN.V(338, 107, 111);
                return;
            case -4:
                g.pQN.V(338, 107, 110);
                return;
            case -3:
                g.pQN.V(338, 107, 109);
                return;
            case -2:
                g.pQN.V(338, 107, 129);
                return;
            case -1:
                g.pQN.V(338, 107, 108);
                return;
            default:
                return;
        }
    }

    public static void d(Throwable th) {
        g.pQN.a(338, 104, 1, false);
        g.pQN.c("Tinker", "Tinker Exception:apply tinker occur unknown exception " + aj.j(th), null);
    }

    public static void e(Throwable th) {
        if (th.getMessage().contains("checkDexOptExist failed")) {
            g.pQN.a(338, 134, 1, false);
        } else if (th.getMessage().contains("checkDexOptFormat failed")) {
            g.pQN.a(338, 135, 1, false);
            g.pQN.c("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + aj.j(th), null);
        } else {
            g.pQN.a(338, 105, 1, false);
            g.pQN.c("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + aj.j(th), null);
        }
    }

    public static void aSw() {
        g.pQN.a(338, 106, 1, false);
    }

    public static void aSx() {
        g.pQN.a(338, 116, 1, false);
    }

    public static void rm(int i) {
        switch (i) {
            case 1:
                g.pQN.a(338, 130, 1, false);
                return;
            case 3:
                g.pQN.a(338, 114, 1, false);
                return;
            case 5:
                g.pQN.a(338, 115, 1, false);
                return;
            case 6:
                g.pQN.a(338, 132, 1, false);
                return;
            case 7:
                g.pQN.a(338, 136, 1, false);
                return;
            default:
                return;
        }
    }

    public static void k(long j, boolean z) {
        g.pQN.a(338, 4, 1, false);
        if (z) {
            x.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[]{Long.valueOf(j)});
            if (j < 0) {
                x.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
                return;
            } else if (j <= 500) {
                g.pQN.a(338, 177, 1, false);
                return;
            } else if (j <= 1000) {
                g.pQN.a(338, 178, 1, false);
                return;
            } else if (j <= 3000) {
                g.pQN.a(338, 179, 1, false);
                return;
            } else if (j <= 5000) {
                g.pQN.a(338, 180, 1, false);
                return;
            } else {
                g.pQN.a(338, 181, 1, false);
                return;
            }
        }
        g.pQN.a(338, 159, 1, false);
    }

    public static void a(Throwable th, int i) {
        boolean z = false;
        switch (i) {
            case -4:
                g.pQN.a(338, 188, 1, false);
                break;
            case -3:
                if (!th.getMessage().contains("checkResInstall failed")) {
                    g.pQN.a(338, 184, 1, false);
                    break;
                }
                g.pQN.a(338, 190, 1, false);
                z = true;
                break;
            case -2:
                if (!th.getMessage().contains("checkDexInstall failed")) {
                    g.pQN.a(338, 161, 1, false);
                    x.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                }
                g.pQN.a(338, 189, 1, false);
                x.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                z = true;
                break;
            case -1:
                g.pQN.a(338, 160, 1, false);
                break;
        }
        if (!z) {
            String j = aj.j(th);
            if (i == -4) {
                Context context = ac.getContext();
                String iB = SharePatchFileUtil.iB(context);
                if (!ShareTinkerInternals.ov(iB)) {
                    j = "tinker checkSafeModeCount fail:\n" + iB;
                    SharePatchFileUtil.ag(SharePatchFileUtil.iA(context));
                }
            }
            g.pQN.c("Tinker", "Tinker Exception:load tinker occur exception " + j, null);
        }
    }

    public static void k(boolean z, int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        if (z) {
            g.pQN.a(338, 170, 1, false);
        }
        switch (i) {
            case -8:
                g.pQN.V(338, y.CTRL_INDEX, 186);
                return;
            case -7:
                g.pQN.V(338, y.CTRL_INDEX, 176);
                return;
            case -6:
                g.pQN.V(338, y.CTRL_INDEX, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE);
                return;
            case -5:
                g.pQN.V(338, y.CTRL_INDEX, GameJsApiOperateGameCenterMsg.CTRL_BYTE);
                return;
            case -4:
                g.pQN.V(338, y.CTRL_INDEX, af.CTRL_BYTE);
                return;
            case -3:
                g.pQN.V(338, y.CTRL_INDEX, 172);
                return;
            case -2:
                g.pQN.V(338, 107, au.CTRL_BYTE);
                return;
            case -1:
                g.pQN.V(338, y.CTRL_INDEX, 171);
                return;
            default:
                return;
        }
    }

    public static void rn(int i) {
        switch (i) {
            case 1:
                g.pQN.a(338, 166, 1, false);
                return;
            case 2:
                g.pQN.a(338, 167, 1, false);
                return;
            case 3:
                g.pQN.a(338, 164, 1, false);
                return;
            case 4:
                g.pQN.a(338, 183, 1, false);
                return;
            case 5:
                g.pQN.a(338, 165, 1, false);
                return;
            case 6:
                g.pQN.a(338, 187, 1, false);
                return;
            default:
                return;
        }
    }

    public static void ro(int i) {
        switch (i) {
            case 3:
                g.pQN.a(338, 162, 1, false);
                return;
            case 5:
                g.pQN.a(338, 163, 1, false);
                return;
            case 6:
                g.pQN.a(338, 185, 1, false);
                return;
            default:
                return;
        }
    }

    public static void aSy() {
        g.pQN.a(338, 168, 1, false);
    }

    public static void aSz() {
        g.pQN.a(338, 5, 1, false);
    }

    public static void a(int i, Throwable th) {
        switch (i) {
            case 0:
                g.pQN.a(338, 193, 1, false);
                return;
            case 1:
                g.pQN.a(338, 191, 1, false);
                g.pQN.c("Tinker", "Tinker Exception:interpret occur instruction exception " + aj.j(th), null);
                return;
            case 2:
                g.pQN.a(338, 192, 1, false);
                g.pQN.c("Tinker", "Tinker Exception:interpret occur command exception " + aj.j(th), null);
                return;
            default:
                return;
        }
    }
}
