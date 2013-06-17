package com.ruyicai.monitor.domainshow;

public class MonitorShow {
	private String hflid = "";// 1
	private String hflbatchcode;
	private String hfllotno;
	private String hflcreatetime = "";
	private String hflremainingtime = "";// <span>5</span>小时&nbsp;<span>20</span>分钟&nbsp;<span>30</span>秒

	private String dlid = "";// 2
	private String dlbatchcode;
	private String dllotno;
	private String dlcreatetime = "";
	private String dlremainingtime = "";

	private String kblid = "";// 3
	private String kblbatchcode;
	private String kbllotno;
	private String kblcreatetime = "";
	private String kblremainingtime = "";

	public String getHflid() {
		return hflid;
	}

	public void setHflid(String hflid) {
		this.hflid = hflid;
	}

	public String getHflbatchcode() {
		return hflbatchcode;
	}

	public void setHflbatchcode(String hflbatchcode) {
		this.hflbatchcode = hflbatchcode;
	}

	// //1
	// 时时彩 T01007
	// 多乐彩T01010
	// 十一运夺金 T01012
	// 广东十一选五T01014
	// 广东快乐十分T01015
	public String getHfllotno() {
		if ("T01007".equals(hfllotno))
			return "时时彩";
		if ("T01010".equals(hfllotno))
			return "多乐彩";
		if ("T01012".equals(hfllotno))
			return "十一运夺金";
		if ("T01014".equals(hfllotno))
			return "广东十一选五";
		if ("T01015".equals(hfllotno))
			return "广东快乐十分";
		return hfllotno;
	}

	public void setHfllotno(String hfllotno) {
		this.hfllotno = hfllotno;
	}

	public String getHflcreatetime() {
		return hflcreatetime;
	}

	public void setHflcreatetime(String hflcreatetime) {
		this.hflcreatetime = hflcreatetime;
	}

	public String getHflremainingtime() {
		return hflremainingtime;
	}

	public void setHflremainingtime(String hflremainingtime) {
		this.hflremainingtime = hflremainingtime;
	}

	public String getDlid() {
		return dlid;
	}

	public void setDlid(String dlid) {
		this.dlid = dlid;
	}

	public String getDlbatchcode() {
		return dlbatchcode;
	}

	public void setDlbatchcode(String dlbatchcode) {
		this.dlbatchcode = dlbatchcode;
	}

	// 2
	// 大盘：
	// 双色球F47104
	// 福彩3D F47103
	// 七乐彩F47102
	// 大乐透T01001
	// 排列三T01002
	// 排列五T01011
	// 七星彩T01009
	// 22选5 T01013
	// 足彩胜负彩T01003
	// 足彩任九场T01004
	// 足彩进球彩T01005
	// 足彩半全场T01006
	public String getDllotno() {
		if ("F47104".equals(dllotno))
			return "双色球";
		if ("F47103".equals(dllotno))
			return "福彩3D";
		if ("F47102".equals(dllotno))
			return "七乐彩";
		if ("T01001".equals(dllotno))
			return "大乐透";
		if ("T01002".equals(dllotno))
			return "排列三";
		if ("T01011".equals(dllotno))
			return "排列五";
		if ("T01009".equals(dllotno))
			return "七星彩";
		if ("T01013".equals(dllotno))
			return "22选5";
		if ("T01003".equals(dllotno))
			return "足彩胜负彩";
		if ("T01004".equals(dllotno))
			return "足彩任九场";
		if ("T01005".equals(dllotno))
			return "足彩进球彩";
		if ("T01006".equals(dllotno))
			return "足彩半全场";
		return dllotno;
	}

	public void setDllotno(String dllotno) {
		this.dllotno = dllotno;
	}

	public String getDlcreatetime() {
		return dlcreatetime;
	}

	public void setDlcreatetime(String dlcreatetime) {
		this.dlcreatetime = dlcreatetime;
	}

	public String getDlremainingtime() {
		return dlremainingtime;
	}

	public void setDlremainingtime(String dlremainingtime) {
		this.dlremainingtime = dlremainingtime;
	}

	public String getKblid() {
		return kblid;
	}

	public void setKblid(String kblid) {
		this.kblid = kblid;
	}

	public String getKblbatchcode() {
		return kblbatchcode;
	}

	public void setKblbatchcode(String kblbatchcode) {
		this.kblbatchcode = kblbatchcode;
	}

	public String getKbllotno() {
		// 3
		// 竞彩：
		// J00001 足球让球胜平负
		// J00002 足球比分
		// J00003 足球总进球
		// J00004 半全场
		//
		// J00005 篮球胜负
		// J00006 篮球让分胜负
		// J00007 胜分差
		// J00008 篮球大小分
		//
		// J00009 冠军（自己还没卖）
		// J00010 冠亚军（自己还没卖）
		//
		// J00011 足球混合投注
		// J00012 篮球混合投注
		if ("J00001".equals(kbllotno))
			return "足球让球胜平负";
		if ("J00002".equals(kbllotno))
			return "足球比分";
		if ("J00003".equals(kbllotno))
			return "足球总进球";
		if ("J00004".equals(kbllotno))
			return "半全场";
		if ("J00005".equals(kbllotno))
			return "篮球胜负";
		if ("J00006".equals(kbllotno))
			return "篮球让分胜负";
		if ("J00007".equals(kbllotno))
			return "胜分差";
		if ("J00008".equals(kbllotno))
			return "篮球大小分";
		if ("J00009".equals(kbllotno))
			return "冠军（自己还没卖）";
		if ("J00010".equals(kbllotno))
			return "冠亚军（自己还没卖）";
		if ("J00011".equals(kbllotno))
			return "足球混合投注";

		if ("J00012".equals(kbllotno))
			return "篮球混合投注";
		return kbllotno;
	}

	public void setKbllotno(String kbllotno) {
		this.kbllotno = kbllotno;
	}

	public String getKblcreatetime() {
		return kblcreatetime;
	}

	public void setKblcreatetime(String kblcreatetime) {
		this.kblcreatetime = kblcreatetime;
	}

	public String getKblremainingtime() {
		return kblremainingtime;
	}

	public void setKblremainingtime(String kblremainingtime) {
		this.kblremainingtime = kblremainingtime;
	}

	public MonitorShow clone() {
		MonitorShow ne = new MonitorShow();
		ne.setDlcreatetime(dlcreatetime);
		ne.setDlid(dlid);
		ne.setDllotno(dllotno);
		ne.setDlbatchcode(dlbatchcode);
		ne.setDlremainingtime(dlremainingtime);
		ne.setHflcreatetime(hflcreatetime);
		ne.setHflid(hflid);
		ne.setHfllotno(hfllotno);
		ne.setHflbatchcode(hflbatchcode);
		ne.setHflremainingtime(hflremainingtime);
		ne.setKblcreatetime(kblcreatetime);
		ne.setKblid(kblid);
		ne.setKblremainingtime(kblremainingtime);
		ne.setKbllotno(kbllotno);
		ne.setKblbatchcode(kblbatchcode);
		return ne;
	}
}
