package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class ad {
    int fDt = -1;
    public String fpL = "";
    String hls = "";
    String hlt = "";
    public int hlu = 0;
    public int hlv = 0;
    public long hwR = 0;
    public int hwS = 0;
    int hwT = 0;
    String hwU = "";
    String hwV = "";
    String hwW = "";
    String hwX = "";
    String hwY = "";
    public String hwZ = "";
    String hxa = "";
    String hxb = "";
    public String username = "";

    public final void b(Cursor cursor) {
        this.hwR = cursor.getLong(0);
        int i = cursor.getInt(1);
        if (i == 65536) {
            this.hwS = 0;
        } else {
            this.hwS = i;
        }
        this.hwT = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.fpL = cursor.getString(4);
        this.hwU = cursor.getString(5);
        this.hwV = cursor.getString(6);
        this.hwW = cursor.getString(7);
        this.hwX = cursor.getString(8);
        this.hwY = cursor.getString(9);
        this.hwZ = cursor.getString(10);
        this.hxa = cursor.getString(11);
        this.hxb = cursor.getString(12);
        this.hls = cursor.getString(13);
        this.hlt = cursor.getString(14);
        this.hlu = cursor.getInt(15);
        this.hlv = cursor.getInt(16);
    }

    public final ContentValues Ou() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.hwR));
        }
        if ((this.fDt & 2) != 0) {
            int i = this.hwS;
            if (i == 0) {
                contentValues.put("wexinstatus", Integer.valueOf(65536));
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i));
            }
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.hwT));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("nickname", vP());
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("pyinitial", this.hwU == null ? "" : this.hwU);
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("quanpin", this.hwV == null ? "" : this.hwV);
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("qqnickname", Ov());
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("qqpyinitial", Ow());
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("qqquanpin", Ox());
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("qqremark", Oy());
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", Oz());
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("qqremarkquanpin", OA());
        }
        if ((this.fDt & 16384) != 0) {
            contentValues.put("reserved2", this.hlt == null ? "" : this.hlt);
        }
        if ((this.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hlu));
        }
        if ((this.fDt & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlv));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String vP() {
        return this.fpL == null ? "" : this.fpL;
    }

    public final String Ov() {
        return this.hwW == null ? "" : this.hwW;
    }

    public final String Ow() {
        return this.hwX == null ? "" : this.hwX;
    }

    public final String Ox() {
        return this.hwY == null ? "" : this.hwY;
    }

    public final String Oy() {
        return this.hwZ == null ? "" : this.hwZ;
    }

    public final String Oz() {
        return this.hxa == null ? "" : this.hxa;
    }

    public final String OA() {
        return this.hxb == null ? "" : this.hxb;
    }

    public final String getDisplayName() {
        if (Oy() == null || Oy().length() <= 0) {
            return Ov();
        }
        return Oy();
    }

    public final void OB() {
        this.hlu |= 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("groupID\t:").append(this.hwT).append("\n");
        stringBuilder.append("qq\t:").append(this.hwR).append("\n");
        stringBuilder.append("username\t:").append(this.username).append("\n");
        stringBuilder.append("nickname\t:").append(this.fpL).append("\n");
        stringBuilder.append("wexinStatus\t:").append(this.hwS).append("\n");
        stringBuilder.append("reserved3\t:").append(this.hlu).append("\n");
        stringBuilder.append("reserved4\t:").append(this.hlv).append("\n");
        return stringBuilder.toString();
    }
}
