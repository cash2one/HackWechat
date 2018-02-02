package com.tencent.mm.plugin.luckymoney.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.f;
import com.tencent.mm.ad.h;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c$a;
import com.tencent.mm.z.ba;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONObject;

public final class n {
    private static f<String, Bitmap> mrw = new f(10);
    public static int ocH = Integer.MAX_VALUE;

    public static String i(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
        }
        Time time = new Time();
        time.set(j);
        return m.a(context.getString(i.loA, new Object[]{" "}), time).toString();
    }

    public static void a(ImageView imageView, String str, boolean z) {
        a(imageView, str, null, true);
    }

    public static void a(ImageView imageView, String str, String str2, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bh.ov(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.aWP();
                aVar.hDD = com.tencent.mm.plugin.luckymoney.a.a.aWR();
                aVar.hDA = true;
                aVar.hDX = true;
                aVar.hDY = z;
                if (z) {
                    aVar.hDZ = 0.0f;
                }
                if (bh.ov(str2)) {
                    aVar.hDI = false;
                } else {
                    aVar.fqR = str2;
                    aVar.hDI = true;
                }
                o.PA().a(str, imageView, aVar.PK());
            }
        }
    }

    public static void h(ImageView imageView, String str) {
        a(imageView, str, null, false);
    }

    public static void d(ImageView imageView, String str, int i) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bh.ov(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.aWP();
                aVar.hDD = com.tencent.mm.plugin.luckymoney.a.a.aWR();
                aVar.hDA = true;
                aVar.hDX = true;
                aVar.hDY = false;
                if (i != 0) {
                    aVar.hDP = i;
                }
                o.PA().a(str, imageView, aVar.PK());
            }
        }
    }

    public static void a(ImageView imageView, String str, String str2) {
        if (imageView != null) {
            if (bh.ov(str2)) {
                str2 = com.tencent.mm.ad.n.JS().jb(str);
            }
            b.a(imageView, str2, 0.1f, false);
        }
    }

    public static void e(ImageView imageView, String str, int i) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bh.ov(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.aWP();
                aVar.hDD = com.tencent.mm.plugin.luckymoney.a.a.aWR();
                aVar.hDA = true;
                aVar.hDX = true;
                aVar.hDY = true;
                aVar.hDF = 1;
                if (i != 0) {
                    aVar.hDP = i;
                }
                o.PA().a(str, imageView, aVar.PK());
            }
        }
    }

    public static void a(Context context, TextView textView, String str) {
        if (textView != null) {
            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(context, str, textView.getTextSize()));
        }
    }

    public static void a(MMActivity mMActivity, int i, int i2, boolean z) {
        if (i != 0 || i2 <= 1) {
            a(mMActivity, 2, z);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i2);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        mMActivity.startActivityForResult(intent, 2);
    }

    public static void a(MMActivity mMActivity, int i, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        d.a((Context) mMActivity, ".ui.transmit.SelectConversationUI", intent, i);
    }

    public static String aXg() {
        g.Dk();
        return (String) g.Dj().CU().get(w.a.xnL, null);
    }

    public static String DV(String str) {
        h jm = com.tencent.mm.ad.n.JQ().jm(str);
        if (jm != null) {
            return jm.JH();
        }
        g.Dk();
        af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str);
        if (WO == null || !WO.field_username.equals(str) || WO.fWe == 4) {
            return null;
        }
        g.Dk();
        byte[] WS = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WS(str);
        if (bh.bw(WS)) {
            return null;
        }
        String str2;
        try {
            str2 = ((arp) new arp().aF(WS)).vUV;
        } catch (Throwable e) {
            x.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[]{bh.i(e)});
            str2 = null;
        }
        return str2;
    }

    public static String gt(String str) {
        g.Dk();
        af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str);
        if (WO == null || !WO.field_username.equals(str)) {
            return null;
        }
        return WO.field_nickname;
    }

    public static int cZ(Context context) {
        if (ocH == Integer.MAX_VALUE) {
            ocH = context.getResources().getColor(a$c.uaM);
        }
        return ocH;
    }

    public static void a(View view, AnimationListener animationListener) {
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new 1(view, scaleAnimation2));
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    public static void a(Button button) {
        b(button);
    }

    public static void b(Button button) {
        if (button != null) {
            button.setBackgroundResource(a$e.ucF);
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    public static void c(Button button) {
        if (button != null && (button.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public static boolean z(String str, String str2, int i) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.LuckyMoneyUtil", bh.ou(str) + ", " + bh.ou(str2));
            return false;
        }
        au auVar = new au();
        auVar.setContent(str);
        auVar.eQ(2);
        auVar.dS(str2);
        auVar.aq(ba.hR(str2));
        auVar.eR(1);
        if (i == 3) {
            auVar.setType(469762097);
        } else {
            auVar.setType(436207665);
        }
        long Q = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(auVar);
        if (Q < 0) {
            x.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.g.zh() + "insert msg failed :" + Q);
            return false;
        }
        if (auVar.aNc()) {
            com.tencent.mm.modelstat.b.hPA.a(auVar, com.tencent.mm.y.h.g(auVar));
        } else {
            com.tencent.mm.modelstat.b.hPA.f(auVar);
        }
        auVar.ao(Q);
        c gVar = new com.tencent.mm.y.g();
        gVar.field_xml = auVar.field_content;
        String VH = bh.VH(str);
        com.tencent.mm.y.g.a aVar = null;
        if (VH != null) {
            aVar = com.tencent.mm.y.g.a.I(VH, auVar.field_reserved);
            if (aVar != null) {
                gVar.field_title = aVar.title;
                gVar.field_description = aVar.description;
            }
        }
        gVar.field_type = 2001;
        gVar.field_msgId = Q;
        if (aVar != null && aVar.type == 2001 && aVar.showType == 1) {
            if (TextUtils.isEmpty(aVar.hcK) || TextUtils.isEmpty(aVar.hcL) || aVar.hcM <= 0) {
                x.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                x.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                com.tencent.mm.sdk.b.b aiVar = new ai();
                aiVar.foq = new ai.a();
                aiVar.foq.fos = aVar.hcL;
                aiVar.foq.for = aVar.hcK;
                aiVar.foq.fot = aVar.hcM;
                com.tencent.mm.sdk.b.a.xef.m(aiVar);
            }
        }
        com.tencent.mm.y.g fp = com.tencent.mm.plugin.y.a.bio().fp(Q);
        if (fp != null && fp.field_msgId == Q) {
            com.tencent.mm.plugin.y.a.bio().c(gVar, new String[0]);
        } else if (!com.tencent.mm.plugin.y.a.bio().b(gVar)) {
            x.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:" + Q);
        }
        return true;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, c$a com_tencent_mm_wallet_core_c_a, int i2) {
        x.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i == 416) {
            return a(activity, kVar, bundle, z, onClickListener, i2);
        }
        x.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
        return false;
    }

    private static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i) {
        JSONObject jSONObject;
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (kVar != null && (kVar instanceof p)) {
            com.tencent.mm.ae.b bVar = ((p) kVar).gJQ;
            if (bVar != null) {
                akg com_tencent_mm_protocal_c_akg = (akg) bVar.hmh.hmo;
                if (com_tencent_mm_protocal_c_akg.wrx != null) {
                    try {
                        jSONObject = new JSONObject(com.tencent.mm.platformtools.n.b(com_tencent_mm_protocal_c_akg.wrx));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.LuckyMoneyUtil", e, "", new Object[0]);
                    }
                    if (jSONObject == null) {
                        x.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
                        if (jSONObject.has("real_name_info")) {
                            jSONObject = jSONObject.optJSONObject("real_name_info");
                        }
                        str2 = jSONObject.optString("guide_flag", "");
                        str3 = jSONObject.optString("guide_wording");
                        str4 = jSONObject.optString("left_button_wording", activity.getString(i.dEn));
                        str5 = jSONObject.optString("right_button_wording", activity.getString(i.dFU));
                        str6 = jSONObject.optString("upload_credit_url", "");
                        str = str2;
                    } else {
                        str = str2;
                    }
                    if ("1".equals(str)) {
                        x.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, i);
                    } else if ("2".equals(str) || bh.ov(str6)) {
                        x.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bh.ov(str6));
                        return false;
                    } else {
                        x.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str6, str4, str5, z, null);
                    }
                }
            }
        }
        jSONObject = null;
        if (jSONObject == null) {
            str = str2;
        } else {
            x.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
            if (jSONObject.has("real_name_info")) {
                jSONObject = jSONObject.optJSONObject("real_name_info");
            }
            str2 = jSONObject.optString("guide_flag", "");
            str3 = jSONObject.optString("guide_wording");
            str4 = jSONObject.optString("left_button_wording", activity.getString(i.dEn));
            str5 = jSONObject.optString("right_button_wording", activity.getString(i.dFU));
            str6 = jSONObject.optString("upload_credit_url", "");
            str = str2;
        }
        if ("1".equals(str)) {
            x.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, i);
        }
        if ("2".equals(str)) {
        }
        x.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bh.ov(str6));
        return false;
    }

    public static String DW(String str) {
        if (bh.ov(str) || !g.Dh().Cy()) {
            return "";
        }
        r2 = new Object[2];
        g.Dk();
        r2[0] = g.Dj().gQi;
        r2[1] = "LuckyMoney";
        File file = new File(String.format("%s/%s/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    public static Bitmap aq(String str, boolean z) {
        Bitmap bitmap;
        int i = 960;
        boolean z2 = true;
        if (z) {
            bitmap = (Bitmap) mrw.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        if (com.tencent.mm.compatible.util.f.ze()) {
            int i2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                bitmap.recycle();
            }
            boolean z3 = com.tencent.mm.sdk.platformtools.d.bt(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!com.tencent.mm.sdk.platformtools.d.bs(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || r4) {
                i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                x.w("MicroMsg.LuckyMoneyUtil", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2)});
            } else {
                i2 = 960;
            }
            int UJ = ExifHelper.UJ(str);
            if (UJ == 90 || UJ == 270) {
                int i3 = i;
                i = i2;
                i2 = i3;
            }
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.LuckyMoneyUtil";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                x.i(str2, str3, objArr);
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.d.d(str, i2, i, false);
            }
            if (bitmap == null) {
                x.e("MicroMsg.LuckyMoneyUtil", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = com.tencent.mm.sdk.platformtools.d.b(bitmap, (float) UJ);
            if (!z) {
                return bitmap;
            }
            mrw.put(str, bitmap);
            return bitmap;
        }
        x.e("MicroMsg.LuckyMoneyUtil", "sdcard is not avail!");
        return BitmapFactory.decodeResource(ac.getContext().getResources(), a$e.bEi);
    }

    public static String bc(List<ah> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ah ahVar = (ah) list.get(i);
            if (ahVar != null) {
                if (i != 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(ahVar.type);
                stringBuilder.append("|");
                stringBuilder.append(ahVar.name);
            }
        }
        return stringBuilder.toString();
    }

    public static void dg(String str, String str2) {
        if (!bh.ov(str) && !bh.ov(str2)) {
            au auVar = new au();
            auVar.eR(0);
            auVar.dS(str2);
            auVar.eQ(3);
            auVar.setContent(str);
            auVar.aq(ba.n(str2, System.currentTimeMillis() / 1000));
            auVar.setType(10000);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(auVar);
        }
    }
}
