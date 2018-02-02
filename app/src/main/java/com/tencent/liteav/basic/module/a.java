package com.tencent.liteav.basic.module;

public class a {
    private String mID = "";

    public void finalize() {
        clearID();
        super.finalize();
    }

    public void setID(String str) {
        clearID();
        synchronized (this) {
            if (str.length() != 0) {
                this.mID = str;
                TXCStatus.a(this.mID);
            }
        }
    }

    public void clearID() {
        synchronized (this) {
            if (this.mID.length() != 0) {
                TXCStatus.b(this.mID);
                this.mID = "";
            }
        }
    }

    public String getID() {
        return this.mID;
    }

    public boolean setStatusValue(int i, Object obj) {
        return TXCStatus.a(this.mID, i, obj);
    }

    public Object getStatusValue(int i) {
        return TXCStatus.a(this.mID, i);
    }
}
