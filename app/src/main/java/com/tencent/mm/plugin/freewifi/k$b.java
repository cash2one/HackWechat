package com.tencent.mm.plugin.freewifi;

public enum k$b {
    GetFrontPage(10, "getFrontPage", "a"),
    GetFrontPageReturn(11, "getFrontpageReturn", "ar"),
    GetFrontPageReturnDataCheck(12, "getFrontPageReturnDataCheck", "ard"),
    AddNetwork(20, "addNetwork", "n"),
    GetBackPage(30, "getBackPage", "b"),
    GetBackPageReturn(31, "getBackPageReturn", "br"),
    GetBackPage33(32, "getBackPage33", "b33"),
    GetBackPage33Return(33, "getBackPage33Return", "b33r"),
    BackpageFinished(40, "backpageFinished", "bf"),
    QinghuaiBackpageFinished(50, "qinghuaiBackpageFinished", "qbf"),
    ScanNearFieldWifiAndReport(110, "scanNearFieldWifiAndReport", "sc"),
    GetThreeOneLock(290, "getThreeOneLock", "31lk"),
    GetPortalApInfo(300, "getPortalApInfo", "o"),
    GetPortalApInfoReturn(301, "getPortalApInfoReturn", "or"),
    GetPortalApInfoReturnDataCheck(302, "getPortalApInfoReturnDataCheck", "ord"),
    FrontPageUIClosed(303, "frontPageUIClosed", "af"),
    FrontPageUIClosedByGoBack(311, "frontPageUIClosedByGoBack", "afg"),
    FrontPageUIClosedByGoSuc(312, "frontPageUIClosedByGoSuc", "afs"),
    FrontPageUIClosedByGoContactInfoUI(313, "frontPageUIClosedByGoContactInfoUI", "afc"),
    ThreeOneAuth(305, "threeOneAuth", "31a"),
    ThreeTwoAuth(306, "threeTwoAuth", "32a"),
    ThreeTwoBlack(307, "threeTwoAuthBlack", "32ab"),
    ThreeThreeAuth(308, "threeThreeAuth", "33a"),
    GetPcFrontPage(210, "getPcFrontPage", "pca"),
    GetPcFrontPageReturn(211, "getPcFrontPageReturn", "pcar"),
    SetPcLoginUserInfo(212, "setPcLoginUserInfo", "pcset"),
    SetPcLoginUserInfoReturn(212, "setPcLoginUserInfoReturn", "pcsetr"),
    ManufacturerConnectLoading(500, "manufacturerConnectLoading", "mld"),
    CopyPwdPageUIClosedByGoBack(600, "CopyPwdPageUIClosedByGoBack", "cpg");
    
    public long mDi;
    String mDj;
    public String name;

    private k$b(long j, String str, String str2) {
        if (j > 999 || j < 0) {
            throw new IllegalArgumentException("code must be between 0 and 999");
        }
        this.mDi = j;
        this.name = str;
        this.mDj = str2;
    }
}
