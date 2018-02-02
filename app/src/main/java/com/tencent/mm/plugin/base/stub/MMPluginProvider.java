package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class MMPluginProvider extends ContentProvider {
    private static final UriMatcher kuL;
    private c kuK = new c();

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        kuL = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
    }

    public String getType(Uri uri) {
        switch (kuL.match(uri)) {
        }
        return null;
    }

    public boolean onCreate() {
        this.kuK.cm(getContext());
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        x.v("MicroMsg.MMPluginProvider", "plugin insert" + uri);
        switch (kuL.match(uri)) {
            case 2:
                return c.aqS();
            default:
                x.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        x.v("MicroMsg.MMPluginProvider", "plugin delete" + uri);
        switch (kuL.match(uri)) {
            case 2:
                return c.aqT();
            default:
                x.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return 0;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.MMPluginProvider", "plugin query" + uri);
        switch (kuL.match(uri)) {
            case 2:
                return c.a(strArr, strArr2);
            default:
                x.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        x.d("MicroMsg.MMPluginProvider", "plugin update" + uri);
        switch (kuL.match(uri)) {
            case 2:
                return c.aqU();
            default:
                x.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return 0;
        }
    }
}
