package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.sdk.platformtools.x;

public abstract class v extends AppBrandInputInvokeHandler {
    boolean addInputImpl(w wVar, e eVar) {
        if (wVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
            return false;
        }
        int i = eVar.jWO;
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u aeF = pVar.aeF();
                if (aeF == null) {
                    x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[]{Integer.valueOf(i)});
                    return false;
                }
                boolean z;
                int i2 = (eVar.kbZ == null || !eVar.kbZ.booleanValue()) ? 0 : 4;
                int i3 = eVar.kbB;
                float[] fArr = new float[]{(float) eVar.kbL.intValue(), (float) eVar.kbK.intValue(), (float) eVar.kbI.intValue(), (float) eVar.kbJ.intValue(), 0.0f};
                if (eVar.kcd == null || !eVar.kcd.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                x.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[]{Integer.valueOf(i), Boolean.valueOf(aeF.a(wVar, i, i3, fArr, i2, z))});
                return aeF.a(wVar, i, i3, fArr, i2, z);
            }
        }
        x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[]{Integer.valueOf(i)});
        return false;
    }

    boolean updateInputPosition(w wVar, e eVar) {
        if (wVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
            return false;
        }
        int i = wVar.mInputId;
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u aeF = pVar.aeF();
                if (aeF == null) {
                    x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[]{Integer.valueOf(i)});
                    return false;
                }
                int i2 = (eVar.kbZ == null || !eVar.kbZ.booleanValue()) ? 0 : 4;
                x.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(aeF.a(i, new float[]{(float) eVar.kbL.intValue(), (float) eVar.kbK.intValue(), (float) eVar.kbI.intValue(), (float) eVar.kbJ.intValue(), 0.0f}, i2, eVar.kcd))});
                return aeF.a(i, new float[]{(float) eVar.kbL.intValue(), (float) eVar.kbK.intValue(), (float) eVar.kbI.intValue(), (float) eVar.kbJ.intValue(), 0.0f}, i2, eVar.kcd);
            }
        }
        x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[]{Integer.valueOf(i)});
        return false;
    }

    void removeInputImpl(w wVar) {
        if (wVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
            return;
        }
        int i = wVar.mInputId;
        wVar.b(this.mInputFocusChangeListenerImpl);
        p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
        if (pVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[]{Integer.valueOf(i)});
            return;
        }
        u aeF = pVar.aeF();
        if (aeF == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[]{Integer.valueOf(i)});
            return;
        }
        boolean lk = aeF.lk(i);
        x.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(lk)});
    }
}
