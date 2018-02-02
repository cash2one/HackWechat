package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.i.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.nio.ByteBuffer;

public abstract class b extends g<h, i, f> implements e {
    private final String name;

    public abstract d a(byte[] bArr, int i, boolean z);

    protected final /* synthetic */ e jl() {
        return new h();
    }

    protected final /* synthetic */ f jm() {
        return new c(this);
    }

    public b(String str) {
        int i = 0;
        super(new h[2], new i[2]);
        this.name = str;
        a.an(this.ain == this.ail.length);
        e[] eVarArr = this.ail;
        int length = eVarArr.length;
        while (i < length) {
            eVarArr[i].cc(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            i++;
        }
    }

    public final void K(long j) {
    }

    protected final void a(i iVar) {
        super.a(iVar);
    }

    private f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.aif;
            d a = a(byteBuffer.array(), byteBuffer.limit(), z);
            iVar.a(hVar.aig, a, hVar.aej);
            iVar.flags &= Integer.MAX_VALUE;
            return null;
        } catch (f e) {
            return e;
        }
    }
}
