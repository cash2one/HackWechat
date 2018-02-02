package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;

public class g$b {
    public Point osL;
    public Point osM;
    public Point osN;
    public Point osO;
    public Point osP;
    public Point osQ;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.osL != null) {
            stringBuffer.append(this.osL.toString() + ",");
        }
        if (this.osM != null) {
            stringBuffer.append(this.osM.toString() + ",");
        }
        if (this.osN != null) {
            stringBuffer.append(this.osN.toString() + ",");
        }
        if (this.osO != null) {
            stringBuffer.append(this.osO.toString() + ",");
        }
        if (this.osP != null) {
            stringBuffer.append(this.osP.toString() + ",");
        }
        if (this.osQ != null) {
            stringBuffer.append(this.osQ.toString() + ",");
        }
        return stringBuffer.toString();
    }
}
