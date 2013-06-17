package com.ruyicai.monitor.jms;

import java.math.BigDecimal;

/**
 *	订单投注类型
 */
public enum BetType {
	zhuihao(0), taocan(1), touzhu(2), hemai(3), zengsong(4), zengsong_nosms(5);

	BigDecimal state;

	public int intValue() {

		return state.intValue();
	}

	public BigDecimal value() {
		return state;
	}

	BetType(int val) {
		this.state = new BigDecimal(val);
	}
}
