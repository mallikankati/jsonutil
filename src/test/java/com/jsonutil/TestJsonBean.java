package com.jsonutil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * NOTE: THIS IS A TEST BEAN TO TEST JSON UTILITY. SHOULD NOT USE THIS BEAN ANY
 * WHERE EXCEPT TESTING JSON UTILITY
 * 
 * @author mallik
 * 
 */
public class TestJsonBean {
	private int testint;
	private long testlong;
	private byte testbyte;
	private short testshort;
	private boolean testboolean;
	private float testfloat;
	private double testdouble;
	private Integer testInteger;
	private Long testLong;
	private Byte testByte;
	private Short testShort;
	private Boolean testBoolean;
	private Float testFloat;
	private BigDecimal testBigDecimal;
	
	
	// To test List
	private List<String> testList;
	// To test map
	private Map<String, String> testMap;
	private List<TestChildBean> testGenericList;
	private Map<String, TestChildBean> testGenericMap;

	private int[] testArray;

	private TestChildBean testChildBean;

	public double getTestdouble() {
		return testdouble;
	}

	public void setTestdouble(double testdouble) {
		this.testdouble = testdouble;
	}

	public int getTestint() {
		return testint;
	}

	public void setTestint(int testint) {
		this.testint = testint;
	}

	public long getTestlong() {
		return testlong;
	}

	public void setTestlong(long testlong) {
		this.testlong = testlong;
	}

	public byte getTestbyte() {
		return testbyte;
	}

	public void setTestbyte(byte testbyte) {
		this.testbyte = testbyte;
	}

	public short getTestshort() {
		return testshort;
	}

	public void setTestshort(short testshort) {
		this.testshort = testshort;
	}

	public boolean isTestboolean() {
		return testboolean;
	}

	public void setTestboolean(boolean testboolean) {
		this.testboolean = testboolean;
	}

	public float getTestfloat() {
		return testfloat;
	}

	public void setTestfloat(float testfloat) {
		this.testfloat = testfloat;
	}

	public Integer getTestInteger() {
		return testInteger;
	}

	public void setTestInteger(Integer testInteger) {
		this.testInteger = testInteger;
	}

	public Long getTestLong() {
		return testLong;
	}

	public void setTestLong(Long testLong) {
		this.testLong = testLong;
	}

	public Byte getTestByte() {
		return testByte;
	}

	public void setTestByte(Byte testByte) {
		this.testByte = testByte;
	}

	public Short getTestShort() {
		return testShort;
	}

	public void setTestShort(Short testShort) {
		this.testShort = testShort;
	}

	public Boolean getTestBoolean() {
		return testBoolean;
	}

	public void setTestBoolean(Boolean testBoolean) {
		this.testBoolean = testBoolean;
	}

	public Float getTestFloat() {
		return testFloat;
	}

	public void setTestFloat(Float testFloat) {
		this.testFloat = testFloat;
	}

	public TestChildBean getTestChildBean() {
		return testChildBean;
	}

	public void setTestChildBean(TestChildBean testChildBean) {
		this.testChildBean = testChildBean;
	}

	public List<String> getTestList() {
		return testList;
	}

	public void setTestList(List<String> testList) {
		this.testList = testList;
	}

	public Map<String, String> getTestMap() {
		return testMap;
	}

	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	public Map<String, TestChildBean> getTestGenericMap() {
		return testGenericMap;
	}

	public void setTestGenericMap(Map<String, TestChildBean> testGenericMap) {
		this.testGenericMap = testGenericMap;
	}

	public int[] getTestArray() {
		return testArray;
	}

	public void setTestArray(int[] testArray) {
		this.testArray = testArray;
	}

	public List<TestChildBean> getTestGenericList() {
		return testGenericList;
	}

	public void setTestGenericList(List<TestChildBean> testGenericList) {
		this.testGenericList = testGenericList;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestJsonBean [testint=");
        builder.append(testint);
        builder.append(", testlong=");
        builder.append(testlong);
        builder.append(", testbyte=");
        builder.append(testbyte);
        builder.append(", testshort=");
        builder.append(testshort);
        builder.append(", testboolean=");
        builder.append(testboolean);
        builder.append(", testfloat=");
        builder.append(testfloat);
        builder.append(", testdouble=");
        builder.append(testdouble);
        builder.append(", testInteger=");
        builder.append(testInteger);
        builder.append(", testLong=");
        builder.append(testLong);
        builder.append(", testByte=");
        builder.append(testByte);
        builder.append(", testShort=");
        builder.append(testShort);
        builder.append(", testBoolean=");
        builder.append(testBoolean);
        builder.append(", testFloat=");
        builder.append(testFloat);
        builder.append(", testBigDecimal=");
        builder.append(testBigDecimal);
        builder.append(", testList=");
        builder.append(testList);
        builder.append(", testMap=");
        builder.append(testMap);
        builder.append(", testGenericList=");
        builder.append(testGenericList);
        builder.append(", testGenericMap=");
        builder.append(testGenericMap);
        builder.append(", testArray=");
        builder.append(Arrays.toString(testArray));
        builder.append(", testChildBean=");
        builder.append(testChildBean);
        builder.append("]");
        return builder.toString();
    }

    public void setTestBigDecimal(BigDecimal testBigDecimal) {
        this.testBigDecimal = testBigDecimal;
    }

    public BigDecimal getTestBigDecimal() {
        return testBigDecimal;
    }
}
