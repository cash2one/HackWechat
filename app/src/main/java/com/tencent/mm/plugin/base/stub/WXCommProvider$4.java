package com.tencent.mm.plugin.base.stub;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$4 extends bc<Cursor> {
    final /* synthetic */ WXCommProvider kvd;
    final /* synthetic */ Uri kvf;
    final /* synthetic */ int kvg;
    final /* synthetic */ String[] kvh;
    final /* synthetic */ MatrixCursor kvi;

    WXCommProvider$4(WXCommProvider wXCommProvider, Uri uri, int i, String[] strArr, MatrixCursor matrixCursor) {
        this.kvd = wXCommProvider;
        this.kvf = uri;
        this.kvg = i;
        this.kvh = strArr;
        this.kvi = matrixCursor;
        super(2000, null);
    }

    protected final /* synthetic */ Object run() {
        x.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", new Object[]{this.kvf.toString(), Integer.valueOf(this.kvg)});
        if (this.kvg != 1) {
            x.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", new Object[]{Integer.valueOf(this.kvg)});
            return null;
        }
        for (String string : this.kvh) {
            String string2 = WXCommProvider.a(this.kvd).getString(string, "");
            this.kvi.addRow(new String[]{string, string2});
        }
        x.d("MicroMsg.WXCommProvider", "query size = %d", new Object[]{Integer.valueOf(this.kvi.getCount())});
        return this.kvi;
    }
}
