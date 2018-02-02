package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements Runnable {
    private String fzi;
    private Account hMw;
    private a hMx;
    private Looper hMy;
    private Context mContext;
    private String username;

    public b(Context context, Account account) {
        this(context, account, null, null);
    }

    public b(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public b(Context context, Account account, String str, String str2) {
        this.mContext = context;
        this.hMw = account;
        this.username = str;
        this.fzi = str2;
        x.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
    }

    public final void run() {
        Looper.prepare();
        this.hMy = Looper.myLooper();
        x.i("MicroMsg.ContactsOperations", "start time:" + System.currentTimeMillis());
        if (bh.ov(this.username) && bh.ov(this.fzi)) {
            Rz();
        } else if (bh.ov(this.fzi)) {
            r0 = af.OD().kR(this.username);
            if (!(r0 == null || bh.ov(r0.hvs))) {
                ms(r0.hvs);
            }
            quit();
        } else {
            r0 = af.OD().kR(this.username);
            com.tencent.mm.modelfriend.b kR = (r0 == null || bh.ov(r0.hvs)) ? af.OD().kR(this.fzi) : r0;
            if (kR == null || bh.ov(kR.hvs)) {
                x.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
            } else {
                try {
                    if (a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
                        Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hMw.name).appendQueryParameter("account_type", this.hMw.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + kR.hvs + "\"", null, null);
                        if (query == null || query.getCount() == 0) {
                            String Nw = bh.ov(kR.Nt()) ? kR.Nw() : kR.Nt();
                            this.hMx = new a(this, this.mContext.getContentResolver());
                            d(Nw, kR.Nz(), kR.hvs, this.username);
                            this.hMx.execute();
                        }
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        x.e("MicroMsg.ContactsOperations", "no contact permission");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", new Object[]{""});
                }
            }
            quit();
        }
        x.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
        Looper.loop();
    }

    private void quit() {
        if (this.hMy != null) {
            this.hMy.quit();
        }
    }

    private synchronized void Rz() {
        Throwable e;
        Object obj;
        if (ar.Hj()) {
            List<com.tencent.mm.modelfriend.b> kT = af.OD().kT("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bh.ot("") + "\" )");
            if (kT.size() == 0) {
                x.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
            } else {
                Map hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hMw.name).appendQueryParameter("account_type", this.hMw.type).build();
                if (a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    String username;
                    com.tencent.mm.g.b.af WO;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                x.e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", new Object[]{""});
                                if (query != null) {
                                    query.close();
                                }
                                if (!mt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.hMx = new a(this, this.mContext.getContentResolver());
                                for (com.tencent.mm.modelfriend.b bVar : kT) {
                                    username = bVar.getUsername();
                                    ar.Hg();
                                    WO = c.EY().WO(username);
                                    if (WO == null) {
                                    }
                                    ms(bVar.hvs);
                                }
                                this.hMx.execute();
                                quit();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (mt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || mt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.hMx = new a(this, this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar2 : kT) {
                                username = bVar2.getUsername();
                                ar.Hg();
                                WO = c.EY().WO(username);
                                if (WO == null && com.tencent.mm.l.a.fZ(WO.field_type)) {
                                    String Nw = bh.ov(bVar2.Nt()) ? bVar2.Nw() : bVar2.Nt();
                                    String Nz = bVar2.Nz();
                                    String str = bVar2.hvs;
                                    String str2 = WO.signature;
                                    if (hashMap.get(str) == null || r2 != null) {
                                        if (hashMap.get(str) != null) {
                                            ms(str);
                                        }
                                        d(Nw, Nz, str, username);
                                    }
                                    this.hMx.execute();
                                } else {
                                    ms(bVar2.hvs);
                                }
                            }
                            this.hMx.execute();
                            quit();
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (mt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.hMx = new a(this, this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar22 : kT) {
                                username = bVar22.getUsername();
                                ar.Hg();
                                WO = c.EY().WO(username);
                                if (WO == null) {
                                }
                                ms(bVar22.hvs);
                            }
                            this.hMx.execute();
                            quit();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                        x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", new Object[]{""});
                        if (query != null) {
                            query.close();
                        }
                        if (mt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                        }
                        obj = null;
                        this.hMx = new a(this, this.mContext.getContentResolver());
                        for (com.tencent.mm.modelfriend.b bVar222 : kT) {
                            username = bVar222.getUsername();
                            ar.Hg();
                            WO = c.EY().WO(username);
                            if (WO == null) {
                            }
                            ms(bVar222.hvs);
                        }
                        this.hMx.execute();
                        quit();
                    }
                }
                x.e("MicroMsg.ContactsOperations", "no contact permission");
            }
        } else {
            x.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
        }
    }

    private void d(String str, String str2, String str3, String str4) {
        x.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue("account_name", this.hMw.name);
        newInsert.withValue("account_type", this.hMw.type);
        newInsert.withValue("sync1", str3);
        this.hMx.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.hMx.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
        newInsert.withValue("data3", this.mContext.getString(R.l.dXp));
        newInsert.withValue("data4", str3);
        this.hMx.a(newInsert.build());
        if ("1".equals(g.zY().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
            newInsert.withValue("data3", this.mContext.getString(R.l.dXr));
            newInsert.withValue("data4", str3);
            this.hMx.a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
            newInsert.withValue("data3", this.mContext.getString(R.l.dXq));
            newInsert.withValue("data4", str3);
            this.hMx.a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
        newInsert.withValue("data3", this.mContext.getString(R.l.dXs));
        newInsert.withValue("data4", str3);
        this.hMx.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
        newInsert.withValue("data3", "");
        newInsert.withValue("data4", str3);
        this.hMx.a(newInsert.build());
    }

    private void ms(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
        } else if (a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Throwable e) {
                x.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", new Object[]{e.getMessage(), bh.i(e)});
                query = null;
            }
            if (query == null) {
                x.e("MicroMsg.ContactsOperations", "get null cursor");
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        if (!(bh.ov(string) || bh.ov(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
        } else {
            x.e("MicroMsg.ContactsOperations", "no contact permission");
        }
    }

    private boolean mt(String str) {
        Exception e;
        boolean z = false;
        if (a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            x.d("MicroMsg.ContactsOperations", "has minetype:" + str);
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                }
                z2 = false;
                z = z2;
            } catch (Exception e3) {
                e = e3;
                query = null;
                x.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                z = true;
                if (query != null) {
                    query.close();
                }
                return z;
            }
            if (query != null) {
                query.close();
            }
        } else {
            x.e("MicroMsg.ContactsOperations", "no contact permission");
        }
        return z;
    }
}
