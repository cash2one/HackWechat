package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        int i2 = 0;
        final MMActivity a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", new Object[]{jVar.mAppId});
            jVar.E(i, e("fail", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new 2(this, jVar, jSONObject, i));
        Activity a2 = a(jVar);
        if (a2 == null) {
            jVar.E(i, e("fail", null));
        } else {
            i2 = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.READ_CONTACTS", 48, "", "");
            if (i2 != 0) {
                com.tencent.mm.plugin.appbrand.a.oR(jVar.mAppId);
            }
        }
        if (i2 == 0) {
            x.i("MicroMsg.JsApiChooseContact", "check permission");
            return;
        }
        a.jwN = new MMActivity.a(this) {
            final /* synthetic */ b jiH;

            public final void b(int i, int i2, Intent intent) {
                if (100 != i) {
                    x.e("MicroMsg.JsApiChooseContact", "requestcode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    jVar.E(i, this.jiH.e("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    jVar.E(i, this.jiH.e("cancel", null));
                } else if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        x.e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
                        jVar.E(i, this.jiH.e("fail", null));
                    } else if (com.tencent.mm.pluginsdk.g.a.aZ(a, "android.permission.READ_CONTACTS")) {
                        try {
                            Object obj;
                            String str;
                            Map hashMap;
                            Cursor query = a.getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    String string = query.getString(query.getColumnIndex("_id"));
                                    Cursor query2 = a.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                    x.i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", new Object[]{query});
                                    if (query2 == null) {
                                        jVar.E(i, this.jiH.e("fail", null));
                                        return;
                                    }
                                    if (query2.moveToFirst()) {
                                        obj = null;
                                        str = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string2 = query2.getString(columnIndex);
                                            string = query2.getString(columnIndex2);
                                            x.d("MicroMsg.JsApiChooseContact", "onActivityResult, username : " + string);
                                            if (string2 != null) {
                                                x.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (string2 == null) {
                                                    string2 = null;
                                                } else {
                                                    string2 = string2.replaceAll("\\D", "");
                                                    if (string2.startsWith("86")) {
                                                        string2 = string2.substring(2);
                                                    }
                                                }
                                                x.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (!(PhoneNumberUtils.isGlobalPhoneNumber(string2) && string2.length() == 11)) {
                                                    string2 = str;
                                                }
                                                x.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : " + string2);
                                            } else {
                                                string2 = str;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                            string2 = string;
                                        }
                                    } else {
                                        obj = null;
                                        str = null;
                                    }
                                    try {
                                        query2.close();
                                    } catch (Exception e) {
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (bh.ov(str)) {
                                        hashMap = new HashMap(1);
                                        hashMap.put("phoneNumber", str);
                                        str = "displayName";
                                        if (obj == null) {
                                            obj = "";
                                        }
                                        hashMap.put(str, obj);
                                        jVar.E(i, this.jiH.e("ok", hashMap));
                                    }
                                    jVar.E(i, this.jiH.e("fail", null));
                                    Toast.makeText(a, q.j.iAR, 0).show();
                                    return;
                                }
                            }
                            obj = null;
                            str = null;
                            query.close();
                            if (bh.ov(str)) {
                                jVar.E(i, this.jiH.e("fail", null));
                                Toast.makeText(a, q.j.iAR, 0).show();
                                return;
                            }
                            hashMap = new HashMap(1);
                            hashMap.put("phoneNumber", str);
                            str = "displayName";
                            if (obj == null) {
                                obj = "";
                            }
                            hashMap.put(str, obj);
                            jVar.E(i, this.jiH.e("ok", hashMap));
                        } catch (SecurityException e2) {
                            x.e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", new Object[]{e2.toString()});
                            h.b(a, ac.getResources().getString(q.j.iBd), "", true);
                            jVar.E(i, this.jiH.e("fail:system permission denied", null));
                        }
                    } else {
                        x.e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
                        jVar.E(i, this.jiH.e("fail:system permission denied", null));
                    }
                }
            }
        };
        a.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 100);
    }
}
