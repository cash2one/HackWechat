package android.support.v7.widget;

import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$t {
    private static final List<Object> Wb = Collections.EMPTY_LIST;
    public final View VU;
    int VV = -1;
    public long VW = -1;
    public int VX = -1;
    int VY = -1;
    RecyclerView$t VZ = null;
    RecyclerView$t Wa = null;
    List<Object> Wc = null;
    List<Object> Wd = null;
    private int We = 0;
    private m Wf = null;
    private boolean Wg = false;
    private int Wh = 0;
    RecyclerView Wi;
    int mPosition = -1;
    private int ur;

    static /* synthetic */ void q(RecyclerView$t recyclerView$t) {
        recyclerView$t.Wh = z.F(recyclerView$t.VU);
        z.i(recyclerView$t.VU, 4);
    }

    static /* synthetic */ void r(RecyclerView$t recyclerView$t) {
        z.i(recyclerView$t.VU, recyclerView$t.Wh);
        recyclerView$t.Wh = 0;
    }

    static /* synthetic */ boolean s(RecyclerView$t recyclerView$t) {
        return (recyclerView$t.ur & 16) == 0 && z.D(recyclerView$t.VU);
    }

    static /* synthetic */ boolean w(RecyclerView$t recyclerView$t) {
        return (recyclerView$t.ur & 16) != 0;
    }

    public RecyclerView$t(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.VU = view;
    }

    final void i(int i, boolean z) {
        if (this.VV == -1) {
            this.VV = this.mPosition;
        }
        if (this.VY == -1) {
            this.VY = this.mPosition;
        }
        if (z) {
            this.VY += i;
        }
        this.mPosition += i;
        if (this.VU.getLayoutParams() != null) {
            ((LayoutParams) this.VU.getLayoutParams()).Vi = true;
        }
    }

    final void ga() {
        this.VV = -1;
        this.VY = -1;
    }

    final boolean gb() {
        return (this.ur & FileUtils.S_IWUSR) != 0;
    }

    @Deprecated
    public final int getPosition() {
        return this.VY == -1 ? this.mPosition : this.VY;
    }

    public final int gd() {
        return this.VY == -1 ? this.mPosition : this.VY;
    }

    public final int ge() {
        if (this.Wi == null) {
            return -1;
        }
        return RecyclerView.b(this.Wi, this);
    }

    final boolean gf() {
        return this.Wf != null;
    }

    final void gg() {
        this.Wf.p(this);
    }

    final boolean gh() {
        return (this.ur & 32) != 0;
    }

    final void gi() {
        this.ur &= -33;
    }

    final void gj() {
        this.ur &= -257;
    }

    final void a(m mVar, boolean z) {
        this.Wf = mVar;
        this.Wg = z;
    }

    final boolean gk() {
        return (this.ur & 4) != 0;
    }

    final boolean gl() {
        return (this.ur & 2) != 0;
    }

    final boolean isBound() {
        return (this.ur & 1) != 0;
    }

    final boolean isRemoved() {
        return (this.ur & 8) != 0;
    }

    final boolean bv(int i) {
        return (this.ur & i) != 0;
    }

    final boolean gm() {
        return (this.ur & 256) != 0;
    }

    final void setFlags(int i, int i2) {
        this.ur = (this.ur & (i2 ^ -1)) | (i & i2);
    }

    final void addFlags(int i) {
        this.ur |= i;
    }

    final void S(Object obj) {
        if (obj == null) {
            addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else if ((this.ur & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
            if (this.Wc == null) {
                this.Wc = new ArrayList();
                this.Wd = Collections.unmodifiableList(this.Wc);
            }
            this.Wc.add(obj);
        }
    }

    final void gn() {
        if (this.Wc != null) {
            this.Wc.clear();
        }
        this.ur &= -1025;
    }

    final List<Object> go() {
        if ((this.ur & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            return Wb;
        }
        if (this.Wc == null || this.Wc.size() == 0) {
            return Wb;
        }
        return this.Wd;
    }

    final void gp() {
        this.ur = 0;
        this.mPosition = -1;
        this.VV = -1;
        this.VW = -1;
        this.VY = -1;
        this.We = 0;
        this.VZ = null;
        this.Wa = null;
        gn();
        this.Wh = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.VW + ", oldPos=" + this.VV + ", pLpos:" + this.VY);
        if (gf()) {
            stringBuilder.append(" scrap ").append(this.Wg ? "[changeScrap]" : "[attachedScrap]");
        }
        if (gk()) {
            stringBuilder.append(" invalid");
        }
        if (!isBound()) {
            stringBuilder.append(" unbound");
        }
        if (gl()) {
            stringBuilder.append(" update");
        }
        if (isRemoved()) {
            stringBuilder.append(" removed");
        }
        if (gb()) {
            stringBuilder.append(" ignored");
        }
        if (gm()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!gq()) {
            stringBuilder.append(" not recyclable(" + this.We + ")");
        }
        Object obj = ((this.ur & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 || gk()) ? 1 : null;
        if (obj != null) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.VU.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void T(boolean z) {
        this.We = z ? this.We - 1 : this.We + 1;
        if (this.We < 0) {
            this.We = 0;
            new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
        } else if (!z && this.We == 1) {
            this.ur |= 16;
        } else if (z && this.We == 0) {
            this.ur &= -17;
        }
    }

    public final boolean gq() {
        return (this.ur & 16) == 0 && !z.D(this.VU);
    }

    final boolean gr() {
        return (this.ur & 2) != 0;
    }
}
