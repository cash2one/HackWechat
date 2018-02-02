package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(p pVar, ImageView imageView, JSONObject jSONObject) {
        Bitmap bitmap = null;
        if (imageView != null && jSONObject != null) {
            try {
                String string = jSONObject.getString("iconPath");
                if (!TextUtils.isEmpty(string)) {
                    if (string.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, string);
                        if (!(itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hhZ))) {
                            String str = itemByLocalId.hhZ;
                            if (!str.startsWith("file://")) {
                                str = "file://" + str;
                            }
                            bitmap = b.Jj().a(str, null);
                        }
                    } else if (string.startsWith("https://") || string.startsWith("http://")) {
                        bitmap = b.Jj().a(string, null);
                        if (bitmap == null) {
                            b.Jj().a(imageView, string, null, null);
                        }
                    } else {
                        bitmap = o.j(pVar.irP, string);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        imageView.setImageBitmap(null);
                    } else {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            } catch (JSONException e) {
            }
        }
    }

    public static void a(TextView textView, JSONObject jSONObject) {
        if (textView != null && jSONObject != null) {
            String string;
            try {
                string = jSONObject.getString("color");
                if (!bh.ov(string)) {
                    textView.setTextColor(f.uA(string));
                }
            } catch (JSONException e) {
            }
            try {
                textView.setTextSize(0, f.ac((float) jSONObject.getDouble("fontSize")));
            } catch (JSONException e2) {
            }
            try {
                string = jSONObject.getString("textAlign");
                if ("left".equals(string)) {
                    textView.setGravity(3);
                } else if ("center".equals(string)) {
                    textView.setGravity(1);
                } else if ("right".equals(string)) {
                    textView.setGravity(5);
                }
            } catch (JSONException e3) {
            }
            try {
                string = jSONObject.getString("fontWeight");
                if ("bold".equals(string)) {
                    textView.getPaint().setFakeBoldText(true);
                } else if ("normal".equals(string)) {
                    textView.getPaint().setFakeBoldText(false);
                }
            } catch (JSONException e4) {
            }
            int a = f.a(jSONObject, "lineHeight", Math.round(textView.getTextSize() * 1.2f));
            if (textView instanceof com.tencent.mm.plugin.appbrand.widget.f) {
                com.tencent.mm.plugin.appbrand.widget.f fVar = (com.tencent.mm.plugin.appbrand.widget.f) textView;
                if (fVar.jUP == null) {
                    fVar.jUP = new com.tencent.mm.plugin.appbrand.widget.g.a((float) a);
                }
                if (fVar.jUP.ad((float) a)) {
                    fVar.invalidate();
                }
            }
            try {
                string = jSONObject.getString("lineBreak");
                if ("ellipsis".equals(string)) {
                    textView.setEllipsize(TruncateAt.END);
                    textView.setSingleLine(true);
                } else if ("clip".equals(string)) {
                    textView.setSingleLine(true);
                } else if ("break-word".equals(string)) {
                    textView.setSingleLine(false);
                } else if ("break-all".equals(string)) {
                    textView.setSingleLine(false);
                }
            } catch (JSONException e5) {
            }
            try {
                textView.setText(jSONObject.getString("content"));
            } catch (JSONException e6) {
            }
        }
    }
}
