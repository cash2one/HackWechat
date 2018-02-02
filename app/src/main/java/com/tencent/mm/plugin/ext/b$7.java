package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

class b$7 extends af {
    final /* synthetic */ b lZF;

    b$7(b bVar, Looper looper) {
        this.lZF = bVar;
        super(looper);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
    public final void handleMessage(Message message) {
        if (ac.getContext() == null || !ar.Hj()) {
            x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
            return;
        }
        Cursor cjO = b.aFB().cjO();
        if (cjO == null) {
            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
            return;
        }
        x.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[]{Integer.valueOf(cjO.getCount())});
        if (cjO.getCount() <= 0) {
            cjO.close();
            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
            return;
        }
        try {
            if (cjO.moveToFirst()) {
                HashMap hashMap = new HashMap();
                synchronized (this.lZF) {
                    hashMap.putAll(b.a(this.lZF));
                    b.a(this.lZF).clear();
                }
                do {
                    LinkedList linkedList = new LinkedList();
                    ArrayList arrayList = new ArrayList();
                    if (hashMap.entrySet() == null) {
                        x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                        return;
                    }
                    ba baVar = new ba();
                    baVar.b(cjO);
                    if (bh.ov(baVar.field_appId) || bh.ov(baVar.field_packageName)) {
                        x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[]{baVar.field_appId, baVar.field_packageName});
                    } else {
                        for (Entry entry : hashMap.entrySet()) {
                            String ou = bh.ou((String) entry.getKey());
                            Integer num = (Integer) entry.getValue();
                            ar.Hg();
                            aj WY = c.Fd().WY(ou);
                            if (WY != null && !bh.ov(WY.field_username) && WY.field_unReadCount <= 0) {
                                x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                            } else if (!(s.ho(ou) || s.eV(ou) || s.gF(ou))) {
                                bj bjVar;
                                bk aFC = b.aFC();
                                String str = baVar.field_appId;
                                if (str == null || str.length() <= 0 || ou == null || ou.length() <= 0) {
                                    bjVar = null;
                                } else {
                                    Cursor a = aFC.gJP.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{bh.ot(str), bh.ot(ou)}, null, null, null, 2);
                                    if (a.moveToFirst()) {
                                        bjVar = new bj();
                                        bjVar.b(a);
                                        a.close();
                                    } else {
                                        x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[]{str, ou});
                                        a.close();
                                        bjVar = null;
                                    }
                                }
                                if (bjVar == null || bh.ov(bjVar.field_openId) || bh.ov(bjVar.field_username)) {
                                    x.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                    Integer num2 = (Integer) b.a(this.lZF).get(ou);
                                    if (num2 == null) {
                                        b.a(this.lZF).put(ou, num);
                                    } else {
                                        b.a(this.lZF).put(ou, Integer.valueOf(num2.intValue() + num.intValue()));
                                    }
                                    linkedList.add(ou);
                                } else {
                                    x.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[]{bjVar.field_username, bjVar.field_appId, bjVar.field_openId});
                                    arrayList.add(String.format("%s,%s,%s", new Object[]{bjVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                }
                            }
                        }
                        if (linkedList.size() > 0) {
                            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                            b bVar = this.lZF;
                            String str2 = baVar.field_appId;
                            if (!bh.ov(str2) && linkedList.size() > 0) {
                                j bYn = j.bYn();
                                Context context = ac.getContext();
                                a aVar = bVar.lZw;
                                x.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                if (!j.vdo) {
                                    bYn.bYo();
                                }
                                if (ar.Hj() && context != null) {
                                    if (linkedList.size() == 0) {
                                        x.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                    } else {
                                        bYn.vdq = aVar;
                                        w mVar = new m(str2, linkedList);
                                        an.aRi();
                                        d.a(14, mVar);
                                    }
                                }
                            }
                        }
                        if (arrayList.size() <= 0) {
                            cjO.close();
                            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                            return;
                        }
                        if ((baVar.field_status == 1 ? 1 : null) == null) {
                            x.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[]{baVar.field_appId, baVar.field_packageName});
                        } else if (!(bh.ov(baVar.field_appId) || bh.ov(baVar.field_packageName))) {
                            x.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[]{baVar.field_appId, baVar.field_packageName});
                            Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                            intent.addCategory("com.tencent.mm.category." + baVar.field_packageName);
                            com.tencent.mm.compatible.a.a.a(12, new 1(this, intent));
                            intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                            intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                            ac.getContext().sendBroadcast(intent);
                        }
                    }
                } while (cjO.moveToNext());
            }
            cjO.close();
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[]{e.getMessage()});
            if (cjO != null) {
                cjO.close();
            }
        }
    }
}
