package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mm.pluginsdk.model.i.a;
import java.util.ArrayList;

class i$1 extends AsyncTask<Void, Void, Cursor> {
    final /* synthetic */ Context val$context;
    final /* synthetic */ String[] vdm;
    final /* synthetic */ a vdn;

    i$1(Context context, String[] strArr, a aVar) {
        this.val$context = context;
        this.vdm = strArr;
        this.vdn = aVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.val$context.getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.gwallet.queryprovider"), null, null, this.vdm, null);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor == null || cursor.getCount() <= 0) {
            ArrayList arrayList = new ArrayList();
            for (String qVar : this.vdm) {
                arrayList.add(new q(-1, qVar, "", "", "", 10237));
            }
            this.vdn.u(arrayList);
        } else {
            cursor.moveToFirst();
            ArrayList j = i.j(cursor);
            cursor.close();
            this.vdn.u(j);
        }
        super.onPostExecute(cursor);
    }
}
