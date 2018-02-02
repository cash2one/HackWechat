package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.wcdb.FileUtils;

public final class ab {
    int fDt = -1;
    int hwJ = 0;
    int hwK = 0;
    int hwL = 0;
    int hwM = 0;
    int hwN = 0;
    int hwO = 0;
    String hwP = "";
    String hwQ = "";

    public final void b(Cursor cursor) {
        this.hwJ = cursor.getInt(0);
        this.hwK = cursor.getInt(1);
        this.hwL = cursor.getInt(2);
        this.hwM = cursor.getInt(3);
        this.hwN = cursor.getInt(4);
        this.hwO = cursor.getInt(5);
        this.hwP = cursor.getString(6);
        this.hwQ = cursor.getString(7);
    }

    public final ContentValues Or() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.hwJ));
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.hwK));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.hwL));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.hwM));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.hwN));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.hwO));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("updatekey", Os());
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("groupname", Ot());
        }
        return contentValues;
    }

    public final String Os() {
        return this.hwP == null ? "" : this.hwP;
    }

    public final String Ot() {
        return this.hwQ == null ? "" : this.hwQ;
    }
}
