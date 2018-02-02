package com.tencent.mm.storage;

import com.tencent.mm.m.a;

public final class ae extends a implements com.tencent.mm.by.a.a<String> {
    public au xye;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public ae(String str) {
        super(str);
    }

    public final void ac(au auVar) {
        ae aeVar;
        long j;
        ae aeVar2;
        eQ(auVar.field_status);
        eR(auVar.field_isSend);
        if (auVar.cji()) {
            aeVar = this;
        } else if (auVar.field_status == 1) {
            j = Long.MAX_VALUE;
            aeVar2 = this;
            aeVar2.aj(j);
            if (auVar.cjd()) {
                setContent(auVar.field_content);
            } else {
                setContent(auVar.cjE());
            }
        } else {
            aeVar = this;
        }
        aeVar2 = aeVar;
        j = auVar.field_createTime;
        aeVar2.aj(j);
        if (auVar.cjd()) {
            setContent(auVar.field_content);
        } else {
            setContent(auVar.cjE());
        }
    }

    public final void ciy() {
        eQ(0);
        eR(0);
        setContent("");
        dE("0");
        eO(0);
        eX(0);
        al(0);
        eW(0);
        eW(0);
        super.dF("");
        super.dG("");
    }

    public final void o(int i, byte[] bArr) {
    }

    public final void Q(int i, long j) {
        switch (i) {
            case 0:
                eO((int) j);
                return;
            case 1:
                eQ((int) j);
                return;
            case 2:
                eR((int) j);
                return;
            case 3:
                aj(j);
                return;
            case 7:
                ak(j);
                return;
            case 10:
                eT((int) j);
                return;
            case 12:
                eU((int) j);
                return;
            case 14:
                eX((int) j);
                return;
            default:
                return;
        }
    }

    public final void aR(int i, String str) {
        switch (i) {
            case 4:
                setUsername(str);
                return;
            case 5:
                setContent(str);
                return;
            case 6:
                dE(str);
                return;
            case 8:
                dF(str);
                return;
            case 9:
                dG(str);
                return;
            case 11:
                dI(str);
                return;
            default:
                return;
        }
    }

    public final void chK() {
    }
}
