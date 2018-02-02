package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.f.b;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";
    private f jiE;

    static /* synthetic */ void a(a aVar, Intent intent, MMActivity mMActivity, String str) {
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ArrayList arrayList = new ArrayList();
        b bVar = aVar.jiE.iIa;
        StringBuilder stringBuilder = new StringBuilder();
        if (bh.Vq(bVar.iIq) || bh.Vq(bVar.iIr) || bh.Vq(bVar.iIs)) {
            if (bVar.iIs.trim().length() > 0) {
                stringBuilder.append(bVar.iIs);
            }
            if (bVar.iIr.trim().length() > 0) {
                stringBuilder.append(bVar.iIr);
            }
            if (bVar.iIq.trim().length() > 0) {
                stringBuilder.append(bVar.iIq);
            }
        } else {
            if (bVar.iIq.trim().length() > 0) {
                stringBuilder.append(bVar.iIq);
            }
            if (bVar.iIr.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar.iIr);
            }
            if (bVar.iIs.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar.iIs);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (bh.ov(stringBuilder2)) {
            x.e("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        } else {
            intent.putExtra("name", stringBuilder2);
        }
        if (!bh.ov(aVar.jiE.bgo)) {
            stringBuilder2 = aVar.jiE.bgo;
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bh.ov(aVar.jiE.iIj)) {
            stringBuilder2 = aVar.jiE.iIj;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", stringBuilder2);
            arrayList.add(contentValues);
        }
        if (!(bh.ov(aVar.jiE.iIk) && bh.ov(aVar.jiE.title))) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
            if (!bh.ov(aVar.jiE.iIk)) {
                contentValues2.put("data1", aVar.jiE.iIk);
            }
            if (!bh.ov(aVar.jiE.title)) {
                contentValues2.put("data4", aVar.jiE.title);
            }
            contentValues2.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues2);
        }
        if (!bh.ov(aVar.jiE.url)) {
            stringBuilder2 = aVar.jiE.url;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bh.ov(aVar.jiE.fWi)) {
            intent.putExtra("email", aVar.jiE.fWi);
        }
        if (!bh.ov(aVar.jiE.iIf)) {
            a(arrayList, aVar.jiE.iIf, 2);
        }
        if (!bh.ov(aVar.jiE.iIg)) {
            a(arrayList, aVar.jiE.iIg, 1);
        }
        if (!bh.ov(aVar.jiE.iIi)) {
            a(arrayList, aVar.jiE.iIi, 3);
        }
        if (!bh.ov(aVar.jiE.iIh)) {
            a(arrayList, aVar.jiE.iIh, 10);
        }
        if (!bh.ov(aVar.jiE.iIm)) {
            a(arrayList, aVar.jiE.iIm, 5);
        }
        if (!bh.ov(aVar.jiE.iIl)) {
            a(arrayList, aVar.jiE.iIl, 4);
        }
        a(arrayList, aVar.jiE.iIe, 3);
        a(arrayList, aVar.jiE.iId, 2);
        a(arrayList, aVar.jiE.iIc, 1);
        if (!bh.ov(aVar.jiE.iIn)) {
            stringBuilder2 = aVar.jiE.iIn;
            String string = mMActivity.getString(j.app_name);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/im");
            contentValues3.put("data1", stringBuilder2);
            contentValues3.put("data5", Integer.valueOf(-1));
            contentValues3.put("data6", string);
            arrayList.add(contentValues3);
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, aVar.jiE.iIb);
        if (!(itemByLocalId == null || bh.ov(itemByLocalId.hhZ))) {
            stringBuilder2 = itemByLocalId.hhZ;
            if (!stringBuilder2.startsWith("file://")) {
                stringBuilder2 = "file://" + stringBuilder2;
            }
            Bitmap a = com.tencent.mm.modelappbrand.a.b.Jj().a(stringBuilder2, null);
            if (a != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("mimetype", "vnd.android.cursor.item/photo");
                contentValues4.put("data15", toByteArray);
                arrayList.add(contentValues4);
                a.recycle();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiAddPhoneContact", e, "", new Object[0]);
                }
            }
        }
        intent.putParcelableArrayListExtra(SlookAirButtonFrequentContactAdapter.DATA, arrayList);
    }

    public final void a(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiAddPhoneContact", "data is null");
        } else if (bh.ov(jSONObject.optString("firstName"))) {
            jVar.E(i, e("fail:firstName is null", null));
            x.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
        } else {
            Context a = a(jVar);
            if (a == null) {
                jVar.E(i, e("fail", null));
                x.e("MicroMsg.JsApiAddPhoneContact", "mmActivity is null, invoke fail!");
                return;
            }
            this.jiE = new f();
            this.jiE.iIb = jSONObject.optString("photoFilePath");
            this.jiE.bgo = jSONObject.optString("nickName");
            this.jiE.iIa = new b(jSONObject.optString("firstName"), jSONObject.optString("middleName"), jSONObject.optString("lastName"));
            this.jiE.iIj = jSONObject.optString("remark");
            this.jiE.iIf = jSONObject.optString("mobilePhoneNumber");
            this.jiE.iIn = jSONObject.optString("weChatNumber");
            this.jiE.iIe = a(jSONObject, "address");
            this.jiE.iIk = jSONObject.optString("organization");
            this.jiE.title = jSONObject.optString("title");
            this.jiE.iIl = jSONObject.optString("workFaxNumber");
            this.jiE.iIi = jSONObject.optString("workPhoneNumber");
            this.jiE.iIh = jSONObject.optString("hostNumber");
            this.jiE.fWi = jSONObject.optString("email");
            this.jiE.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.jiE.iId = a(jSONObject, "workAddress");
            this.jiE.iIm = jSONObject.optString("homeFaxNumber");
            this.jiE.iIg = jSONObject.optString("homePhoneNumber");
            this.jiE.iIc = a(jSONObject, "homeAddress");
            a.jwN = new 2(this, jVar, i);
            String[] strArr = new String[]{a.getString(j.iAQ), a.getString(j.iAP)};
            h.a(a, "", strArr, "", new 1(this, a, jVar.mAppId));
        }
    }

    private static com.tencent.mm.plugin.appbrand.appstorage.f.a a(JSONObject jSONObject, String str) {
        return new com.tencent.mm.plugin.appbrand.appstorage.f.a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
    }

    private static void a(ArrayList<ContentValues> arrayList, com.tencent.mm.plugin.appbrand.appstorage.f.a aVar, int i) {
        if (aVar != null && aVar.Rf().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data1", aVar.Rf());
            contentValues.put("data9", aVar.iIp);
            contentValues.put("data2", Integer.valueOf(i));
            arrayList.add(contentValues);
        }
    }

    private static void a(ArrayList<ContentValues> arrayList, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data1", str);
        contentValues.put("data2", Integer.valueOf(i));
        arrayList.add(contentValues);
    }
}
