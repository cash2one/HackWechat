package com.tencent.mm.pluginsdk.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mm.ui.snackbar.b$c;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.y.g;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private static Map<String, Integer> tRc;
    public static boolean vdg = true;
    private static z<String, Bitmap> vdh = new z(20);

    static {
        tRc = new HashMap();
        Map hashMap = new HashMap();
        tRc = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.dvA));
        tRc.put("m4v", Integer.valueOf(R.k.dvA));
        tRc.put("vob", Integer.valueOf(R.k.dvA));
        tRc.put("mpeg", Integer.valueOf(R.k.dvA));
        tRc.put("mpe", Integer.valueOf(R.k.dvA));
        tRc.put("asx", Integer.valueOf(R.k.dvA));
        tRc.put("asf", Integer.valueOf(R.k.dvA));
        tRc.put("f4v", Integer.valueOf(R.k.dvA));
        tRc.put("flv", Integer.valueOf(R.k.dvA));
        tRc.put("mkv", Integer.valueOf(R.k.dvA));
        tRc.put("wmv", Integer.valueOf(R.k.dvA));
        tRc.put("wm", Integer.valueOf(R.k.dvA));
        tRc.put("3gp", Integer.valueOf(R.k.dvA));
        tRc.put("mp4", Integer.valueOf(R.k.dvA));
        tRc.put("rmvb", Integer.valueOf(R.k.dvA));
        tRc.put("rm", Integer.valueOf(R.k.dvA));
        tRc.put("ra", Integer.valueOf(R.k.dvA));
        tRc.put("ram", Integer.valueOf(R.k.dvA));
        tRc.put("mp3pro", Integer.valueOf(R.k.dvn));
        tRc.put("vqf", Integer.valueOf(R.k.dvn));
        tRc.put("cd", Integer.valueOf(R.k.dvn));
        tRc.put("md", Integer.valueOf(R.k.dvn));
        tRc.put("mod", Integer.valueOf(R.k.dvn));
        tRc.put("vorbis", Integer.valueOf(R.k.dvn));
        tRc.put("au", Integer.valueOf(R.k.dvn));
        tRc.put("amr", Integer.valueOf(R.k.dvn));
        tRc.put("silk", Integer.valueOf(R.k.dvn));
        tRc.put("wma", Integer.valueOf(R.k.dvn));
        tRc.put("mmf", Integer.valueOf(R.k.dvn));
        tRc.put("mid", Integer.valueOf(R.k.dvn));
        tRc.put("midi", Integer.valueOf(R.k.dvn));
        tRc.put("mp3", Integer.valueOf(R.k.dvn));
        tRc.put("aac", Integer.valueOf(R.k.dvn));
        tRc.put("ape", Integer.valueOf(R.k.dvn));
        tRc.put("aiff", Integer.valueOf(R.k.dvn));
        tRc.put("aif", Integer.valueOf(R.k.dvn));
        tRc.put("jfif", Integer.valueOf(R.k.byV));
        tRc.put("tiff", Integer.valueOf(R.k.byV));
        tRc.put("tif", Integer.valueOf(R.k.byV));
        tRc.put("jpe", Integer.valueOf(R.k.byV));
        tRc.put("dib", Integer.valueOf(R.k.byV));
        tRc.put("jpeg", Integer.valueOf(R.k.byV));
        tRc.put("jpg", Integer.valueOf(R.k.byV));
        tRc.put("png", Integer.valueOf(R.k.byV));
        tRc.put("bmp", Integer.valueOf(R.k.byV));
        tRc.put("gif", Integer.valueOf(R.k.byV));
        tRc.put("rar", Integer.valueOf(R.k.dvv));
        tRc.put("zip", Integer.valueOf(R.k.dvv));
        tRc.put("7z", Integer.valueOf(R.k.dvv));
        tRc.put("iso", Integer.valueOf(R.k.dvv));
        tRc.put("cab", Integer.valueOf(R.k.dvv));
        tRc.put("doc", Integer.valueOf(R.k.dvE));
        tRc.put("docx", Integer.valueOf(R.k.dvE));
        tRc.put("ppt", Integer.valueOf(R.k.dvt));
        tRc.put("pptx", Integer.valueOf(R.k.dvt));
        tRc.put("xls", Integer.valueOf(R.k.dvh));
        tRc.put("xlsx", Integer.valueOf(R.k.dvh));
        tRc.put("txt", Integer.valueOf(R.k.dvw));
        tRc.put("rtf", Integer.valueOf(R.k.dvw));
        tRc.put("pdf", Integer.valueOf(R.k.dvr));
        tRc.put("unknown", Integer.valueOf(R.k.dvx));
    }

    public static uv a(int i, ve veVar, vr vrVar) {
        if (veVar == null) {
            x.w("MicroMsg.FavExportLogic", "proto item is null");
            return null;
        }
        uv uvVar = new uv();
        vk vkVar = veVar.weS;
        if (vkVar != null) {
            uvVar.fzO = vkVar.fzO;
            uvVar.weE = vkVar.wet;
            uvVar.appId = vkVar.appId;
            uvVar.fnl = vkVar.fnl;
        }
        if (vrVar != null) {
            if (vrVar.wfi != null) {
                uvVar.weF.addAll(vrVar.wfi);
            }
            if (vrVar.wfj != null) {
                uvVar.weF.addAll(vrVar.wfj);
            }
        }
        uvVar.fEH = veVar;
        uvVar.type = i;
        switch (i) {
            case 1:
                uvVar.title = "";
                uvVar.desc = veVar.desc;
                return uvVar;
            case 2:
                if (veVar.weU != null && veVar.weU.size() > 0) {
                    uvVar.title = ((uq) veVar.weU.get(0)).title;
                }
                return uvVar;
            case 4:
                if (!(veVar.weU == null || veVar.weU.isEmpty())) {
                    uvVar.title = ((uq) veVar.weU.get(0)).title;
                }
                return uvVar;
            case 5:
                if (veVar.web != null) {
                    uvVar.title = veVar.web.title;
                    uvVar.desc = veVar.web.wfz;
                }
                if (!(!bh.ov(uvVar.title) || veVar.weU == null || veVar.weU.isEmpty())) {
                    uvVar.title = ((uq) veVar.weU.get(0)).title;
                }
                if (bh.ov(uvVar.desc) && vkVar != null) {
                    uvVar.desc = vkVar.hOf;
                }
                return uvVar;
            case 6:
                uvVar.title = veVar.iIj;
                if (bh.ov(uvVar.title)) {
                    if (veVar.wdZ != null) {
                        uvVar.title = veVar.wdZ.fDu;
                        uvVar.desc = veVar.wdZ.label;
                    }
                } else if (veVar.wdZ != null) {
                    uvVar.desc = veVar.wdZ.fDu;
                }
                return uvVar;
            case 7:
                if (!(veVar.weU == null || veVar.weU.isEmpty())) {
                    uvVar.title = ((uq) veVar.weU.get(0)).title;
                    uvVar.desc = ((uq) veVar.weU.get(0)).desc;
                }
                return uvVar;
            case 8:
                uvVar.title = veVar.title;
                if (!(!bh.ov(uvVar.title) || veVar.weU == null || veVar.weU.isEmpty())) {
                    uvVar.title = ((uq) veVar.weU.get(0)).title;
                }
                return uvVar;
            case 10:
            case 11:
                if (veVar.wed != null) {
                    uvVar.title = veVar.wed.title;
                    uvVar.desc = veVar.wed.desc;
                }
                return uvVar;
            case 12:
            case 15:
                if (veVar.wef != null) {
                    uvVar.title = veVar.wef.title;
                    uvVar.desc = veVar.wef.desc;
                }
                return uvVar;
            case 14:
            case 18:
                List<uq> list = veVar.weU;
                if (list == null) {
                    return null;
                }
                for (uq uqVar : list) {
                    if (1 == uqVar.bjS) {
                        uvVar.title = uqVar.desc;
                        return uvVar;
                    }
                }
                return uvVar;
            default:
                x.w("MicroMsg.FavExportLogic", "unknown type %d", new Object[]{Integer.valueOf(i)});
                return uvVar;
        }
    }

    public static void a(int i, int i2, Activity activity, b bVar) {
        a(-1, i, i2, activity, null, null, null, bVar);
    }

    public static void a(int i, int i2, int i3, Activity activity, Fragment fragment, b$c com_tencent_mm_ui_snackbar_b_c, OnClickListener onClickListener, b bVar) {
        if (activity == null && fragment == null) {
            x.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            return;
        }
        b 1;
        if (bVar == null) {
            1 = new 1();
        } else {
            1 = bVar;
        }
        if (i2 != 0) {
            Context activity2;
            if (activity == null) {
                activity2 = fragment.getActivity();
            } else {
                activity2 = activity;
            }
            switch (i2) {
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                    String string;
                    String str = "";
                    Context activity3 = fragment == null ? activity2 : fragment.getActivity();
                    if (i2 == -4) {
                        switch (i) {
                            case 2:
                                string = activity3.getString(R.l.efe);
                                break;
                            case 4:
                            case 16:
                                string = activity3.getString(R.l.eff);
                                break;
                            case 8:
                                string = activity3.getString(R.l.efd);
                                break;
                            case 14:
                                string = activity3.getString(R.l.efs);
                                break;
                            default:
                                string = str;
                                break;
                        }
                    } else if (i2 == -5) {
                        string = i != 14 ? activity3.getString(R.l.eeG) : activity3.getString(R.l.efr);
                    } else if (i2 == -6) {
                        string = activity3.getString(R.l.efs);
                    } else if (i2 == -7) {
                        string = activity3.getString(R.l.efr);
                    } else if (i2 == -8) {
                        string = activity3.getString(R.l.eft);
                    } else if (i2 != -9) {
                        string = activity3.getString(R.l.efh);
                    } else if (fragment != null) {
                        a.a(0, fragment, activity3.getString(R.l.efV), activity3.getString(R.l.eeF), 1, com_tencent_mm_ui_snackbar_b_c);
                        return;
                    } else {
                        a.a(0, activity2, activity3.getString(R.l.efV), activity3.getString(R.l.eeF), 1, com_tencent_mm_ui_snackbar_b_c);
                        return;
                    }
                    h.a(activity3, string, "", activity3.getString(R.l.eAd), activity3.getString(R.l.dUa), new 5(onClickListener, fragment, 1, com_tencent_mm_ui_snackbar_b_c, activity2), new 6(onClickListener), R.e.bui);
                    return;
                case -2:
                    h.a(activity2, activity2.getString(R.l.efj), activity2.getString(R.l.efk), activity2.getString(R.l.efm), activity2.getString(R.l.dUa), new 3(activity2, onClickListener), new 4(onClickListener), R.e.bui);
                    return;
                default:
                    h.a(activity2, i2, 0, new 2(onClickListener));
                    return;
            }
        } else if (fragment != null) {
            a.a(i3, fragment, fragment.getString(R.l.efV), fragment.getString(R.l.eeF), 1, com_tencent_mm_ui_snackbar_b_c);
        } else if (activity != null) {
            a.a(i3, activity, activity.getString(R.l.efV), activity.getString(R.l.eeF), 1, com_tencent_mm_ui_snackbar_b_c);
        }
    }

    public static int a(au auVar, cf cfVar, boolean z) {
        String str = "";
        x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[]{Integer.valueOf(auVar.getType())});
        if (z || cfVar.fqp.fqv <= 0) {
            boolean z2;
            if (cfVar.fqp.type == 4 || cfVar.fqp.type == 8 || cfVar.fqp.type == 16 || cfVar.fqp.type == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (cfVar.fqp.type == 14 && cfVar.fqp.fqr.weU.size() > 0) {
                uq uqVar = (uq) cfVar.fqp.fqr.weU.getLast();
                if (uqVar.bjS == 4 || uqVar.bjS == 8 || uqVar.bjS == 15 || uqVar.bjS == 2) {
                    z2 = false;
                }
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                return a(cfVar, 0);
            }
            if (cfVar.fqp.fqr == null) {
                return a(cfVar, -1);
            }
            if (cfVar.fqp.fqr.weU == null) {
                return a(cfVar, -1);
            }
            String str2;
            if (System.currentTimeMillis() - auVar.field_createTime > 259200000) {
                z2 = true;
            } else {
                z2 = false;
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[]{Boolean.valueOf(z2)});
            if (1 <= cfVar.fqp.fqr.weU.size()) {
                str2 = ((uq) cfVar.fqp.fqr.weU.getLast()).wdh;
            } else {
                str2 = str;
            }
            if (z2) {
                String str3;
                if (bh.ov(str2) || !e.bO(str2)) {
                    if (auVar != null && (auVar.getType() == 43 || auVar.getType() == 44 || auVar.getType() == 62)) {
                        r nF = t.nF(auVar.field_imgPath);
                        if (nF != null && nF.hVO == -1) {
                            str2 = nF.Uf();
                            if (e.bO(str2)) {
                                str3 = str2;
                                if (bh.ov(str3)) {
                                    return a(cfVar, -4);
                                }
                                ((uq) cfVar.fqp.fqr.weU.getLast()).TE(str3);
                            }
                        }
                    }
                    str3 = null;
                    if (bh.ov(str3)) {
                        return a(cfVar, -4);
                    }
                    ((uq) cfVar.fqp.fqr.weU.getLast()).TE(str3);
                } else {
                    str3 = str2;
                }
                if (a(auVar, cfVar, str3, true)) {
                    return a(cfVar, -5);
                }
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            } else if (a(auVar, cfVar, str2, false)) {
                return a(cfVar, -5);
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
            return a(cfVar, 0);
        }
        x.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
        return a(cfVar, cfVar.fqp.fqv);
    }

    private static int a(cf cfVar, int i) {
        int i2 = 1;
        int i3 = 0;
        if (cfVar.fqp.fqr.weU != null && cfVar.fqp.fqr.weU.size() > 0) {
            uq uqVar = (uq) cfVar.fqp.fqr.weU.getLast();
            if (i <= 0) {
                switch (i) {
                    case -5:
                        uqVar.CL(2);
                        uqVar.TE(null);
                        break;
                    case -4:
                        uqVar.CL(1);
                        uqVar.TE(null);
                        break;
                    default:
                        uqVar.CL(0);
                        break;
                }
            }
        }
        if (cfVar.fqp.fqr.weU == null || cfVar.fqp.fqr.weU.size() == 0) {
            cfVar.fqp.fqv = i;
        } else if (cfVar.fqp.fqv != -9) {
            if (i <= 0 && cfVar.fqp.fqv <= 0) {
                i2 = 0;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < cfVar.fqp.fqr.weU.size()) {
                int i7;
                switch (((uq) cfVar.fqp.fqr.weU.get(i3)).wdR) {
                    case 0:
                        i7 = i4;
                        i4 = i5;
                        i5 = i6 + 1;
                        break;
                    case 1:
                        i7 = i4 + 1;
                        i4 = i5;
                        i5 = i6;
                        break;
                    case 2:
                        i7 = i4;
                        i4 = i5 + 1;
                        i5 = i6;
                        break;
                    default:
                        i7 = i4;
                        i4 = i5;
                        i5 = i6;
                        break;
                }
                i3++;
                i6 = i5;
                i5 = i4;
                i4 = i7;
            }
            if (i2 > 0) {
                if (i5 > 0 || i4 > 0) {
                    cfVar.fqp.fqv = -9;
                } else {
                    cfVar.fqp.fqv = i;
                }
            } else if (i5 > 0) {
                if (i4 > 0) {
                    cfVar.fqp.fqv = -8;
                } else if (i6 == 0) {
                    cfVar.fqp.fqv = -5;
                } else if (i6 > 0) {
                    cfVar.fqp.fqv = -7;
                }
            } else if (i4 > 0) {
                if (i6 == 0) {
                    cfVar.fqp.fqv = -4;
                } else if (i6 > 0) {
                    cfVar.fqp.fqv = -6;
                }
            }
        }
        return i;
    }

    private static boolean a(au auVar, cf cfVar, String str, boolean z) {
        g.a I;
        if (!bh.ov(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.length() > ((long) com.tencent.mm.k.b.zG())) {
                    x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    return true;
                }
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                ((uq) cfVar.fqp.fqr.weU.getLast()).TE(null);
            }
        }
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null) {
            if (I.hbf != 0 || I.hbb > com.tencent.mm.k.b.zG()) {
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                return true;
            } else if (!(bh.ov(str) || !e.bO(str) || z)) {
                if (((long) I.hbb) > ((long) e.bN(str))) {
                    x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    ((uq) cfVar.fqp.fqr.weU.getLast()).TE(null);
                }
            }
        }
        if (str2 == null || I == null) {
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        return false;
    }

    public static Bitmap aY(String str, boolean z) {
        boolean z2 = true;
        if (bh.ov(str)) {
            return null;
        }
        Bitmap bitmap = (Bitmap) vdh.get(str);
        if (bitmap != null) {
            x.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[]{str});
            return bitmap;
        } else if (z) {
            return null;
        } else {
            if (!e.bO(str)) {
                return null;
            }
            int i;
            x.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                x.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[]{bitmap});
                bitmap.recycle();
            }
            boolean z3 = d.bt(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!d.bs(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || r4) {
                int i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                x.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2)});
            }
            i = ExifHelper.UJ(str);
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.FavExportLogic";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                x.i(str2, str3, objArr);
            } else {
                bitmap = d.cU(str, 0);
            }
            if (bitmap == null) {
                x.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = d.b(bitmap, (float) i);
            vdh.put(str, bitmap);
            return bitmap;
        }
    }

    public static int Rr(String str) {
        Integer num = (Integer) tRc.get(str);
        if (num == null) {
            return ((Integer) tRc.get("unknown")).intValue();
        }
        return num.intValue();
    }

    @TargetApi(8)
    public static Bitmap Rs(String str) {
        if (com.tencent.mm.compatible.util.d.fM(8)) {
            return ThumbnailUtils.createVideoThumbnail(str, 1);
        }
        return null;
    }

    public static void bYm() {
    }
}
