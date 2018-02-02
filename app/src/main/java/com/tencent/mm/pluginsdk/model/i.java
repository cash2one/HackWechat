package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;

public final class i {
    static /* synthetic */ ArrayList j(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(new q(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("product_id")), cursor.getString(cursor.getColumnIndex("full_price")), cursor.getString(cursor.getColumnIndex("price_currency")), cursor.getString(cursor.getColumnIndex("price_amount")), cursor.getInt(cursor.getColumnIndex("product_state"))));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public static void a(Context context, String[] strArr, a aVar) {
        if (aVar == null || strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException();
        }
        new 1(context, strArr, aVar).execute(new Void[0]);
    }
}
