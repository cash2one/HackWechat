package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.by.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements a<String> {
    public String field_alias;
    public String field_conRemark;
    public int field_deleteFlag;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_remarkDesc;
    public int field_showHead;
    public String field_signature;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public long gJd;
    public CharSequence xmu;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public final void b(Cursor cursor) {
        this.field_username = cursor.getString(0);
        this.field_nickname = cursor.getString(1);
        this.field_alias = cursor.getString(2);
        this.field_conRemark = cursor.getString(3);
        this.field_verifyFlag = cursor.getInt(4);
        this.field_showHead = cursor.getInt(5);
        this.field_weiboFlag = cursor.getInt(6);
        this.gJd = cursor.getLong(7);
        this.field_deleteFlag = cursor.getInt(8);
        this.field_lvbuff = cursor.getBlob(9);
        chJ();
    }

    private void chJ() {
        if (this.field_lvbuff != null) {
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    u uVar = new u();
                    if (uVar.br(this.field_lvbuff) == 0) {
                        uVar.Db(4);
                        uVar.Db(4);
                        uVar.ceV();
                        uVar.Db(8);
                        uVar.Db(4);
                        uVar.ceV();
                        uVar.ceV();
                        uVar.Db(4);
                        uVar.Db(4);
                        uVar.ceV();
                        uVar.ceV();
                        uVar.Db(4);
                        uVar.Db(4);
                        this.field_signature = uVar.getString();
                        uVar.ceV();
                        uVar.ceV();
                        uVar.ceV();
                        uVar.Db(4);
                        uVar.Db(4);
                        uVar.ceV();
                        uVar.Db(4);
                        uVar.ceV();
                        uVar.ceV();
                        uVar.Db(4);
                        uVar.Db(4);
                        if (!uVar.ceW()) {
                            this.field_remarkDesc = uVar.getString();
                        }
                        this.field_lvbuff = null;
                    }
                }
            } catch (Throwable e) {
                x.e("MicroMsg.AddressUIContact", "exception:%s", new Object[]{bh.i(e)});
            }
        }
    }

    public final void o(int i, byte[] bArr) {
        if (i == 9) {
            this.field_lvbuff = bArr;
        }
    }

    public final void Q(int i, long j) {
        switch (i) {
            case 4:
                this.field_verifyFlag = (int) j;
                return;
            case 5:
                this.field_showHead = (int) j;
                return;
            case 6:
                this.field_weiboFlag = (int) j;
                return;
            case 7:
                this.gJd = j;
                return;
            case 8:
                this.field_deleteFlag = (int) j;
                return;
            default:
                return;
        }
    }

    public final void aR(int i, String str) {
        switch (i) {
            case 0:
                this.field_username = str;
                return;
            case 1:
                this.field_nickname = str;
                return;
            case 2:
                this.field_alias = str;
                return;
            case 3:
                this.field_conRemark = str;
                return;
            default:
                return;
        }
    }

    public final void chK() {
        chJ();
    }
}
