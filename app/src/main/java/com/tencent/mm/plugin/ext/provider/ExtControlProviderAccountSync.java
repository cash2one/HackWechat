package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher mal;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mal = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        a(uri, getContext(), mal);
        if (uri == null) {
            pp(3);
            return null;
        } else if (bh.ov(this.maf) || bh.ov(aFM())) {
            pp(3);
            return null;
        } else if (!aqY()) {
            pp(1);
            return this.kuZ;
        } else if (cz(getContext())) {
            switch (mal.match(uri)) {
                case 1:
                    x.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (a.xef.m(new fb())) {
                        pp(0);
                        return null;
                    }
                    x.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                    pp(4);
                    return null;
                default:
                    pp(3);
                    return null;
            }
        } else {
            x.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            pp(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
