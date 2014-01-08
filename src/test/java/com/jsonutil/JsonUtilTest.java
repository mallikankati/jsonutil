package com.jsonutil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for JsonUtil.
 */
public class JsonUtilTest extends TestCase {
    private static final Logger logger = Logger.getLogger(JsonUtilTest.class
            .getName());

    /**
     * Create the test case
     * 
     * @param testName
     *            name of the test case
     */
    public JsonUtilTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(JsonUtilTest.class);
    }

    public void testSimpleMap() {
        Map<String, String> test = new HashMap<String, String>();
        test.put("key1", "value1");
        test.put("key2", "value2");
        test.put("key3", "value3");
        String json = JsonUtil.toJson(test);
        logger.info(json);
        Map<String, String> temp = JsonUtil.fromJson(json, HashMap.class,
                String.class, String.class);
        logger.info(temp + "");

        validateMap(test, temp);
    }

    public void testComplexMap() {
        Map<String, TestJsonBean> complexMap = new HashMap<String, TestJsonBean>();
        complexMap.put("key2", getBean());

        String json = JsonUtil.toJson(complexMap);
        logger.info(json);

        Map<String, TestJsonBean> temp = JsonUtil.fromJson(json, HashMap.class,
                String.class, TestJsonBean.class);
        logger.info(temp + "");

        validateMap(complexMap, temp);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", 20);
        map.put("value", getBean());
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("count", 21);
        map.put("value", getBean());
        list.add(map);

        json = JsonUtil.toJson(list);
        logger.info(json);

        list = JsonUtil.fromJson(json, ArrayList.class, HashMap.class);
        logger.info(list + "");
    }

    public void testSimpleList() {

    }

    public void testComplexBean() {
        TestJsonBean bean = getBean();
        String json = JsonUtil.toJson(bean);
        logger.info(json);
        TestJsonBean outputBean = JsonUtil.fromJson(json, TestJsonBean.class);
        validateTestJsonBean(bean, outputBean);
        logger.info(outputBean + "");
    }

    /**
     * This is a test bean to test Json.
     * 
     * @return
     */
    private TestJsonBean getBean() {
        TestJsonBean bean = new TestJsonBean();
        bean.setTestboolean(true);
        bean.setTestBoolean(false);
        bean.setTestbyte((byte) 12);
        bean.setTestByte(((byte) 13));
        bean.setTestfloat(2.2f);
        bean.setTestFloat(2.5f);
        bean.setTestdouble(1234.3445);
        bean.setTestint(10);
        bean.setTestInteger(24);
        bean.setTestlong(30L);
        bean.setTestLong(35L);
        bean.setTestshort((short) 3);
        bean.setTestShort((short) 4);
        bean.setTestBigDecimal(new BigDecimal(100.87, new MathContext(8)));

        TestChildBean testChildBean = new TestChildBean();
        testChildBean.setFirstName("Mallik");
        testChildBean.setLastName("Ankati");
        bean.setTestChildBean(testChildBean);

        List<String> list = new ArrayList<String>();
        list.add("list1");
        list.add("list2");
        list.add("list3");
        bean.setTestList(list);

        List<TestChildBean> genericList = new ArrayList<TestChildBean>();
        genericList.add(testChildBean);
        bean.setTestGenericList(genericList);

        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("key1", "MapValue1");
        stringMap.put("key2", "MapValue2");
        stringMap.put("key3", "MapValue3");
        bean.setTestMap(stringMap);

        Map<String, TestChildBean> genericMap = new HashMap<String, TestChildBean>();
        genericMap.put("key5", testChildBean);
        bean.setTestGenericMap(genericMap);

        int[] testArray = { 1, 2, 3 };
        bean.setTestArray(testArray);

        return bean;
    }

    private void validateTestJsonBean(TestJsonBean sourceBean,
            TestJsonBean convertedBean) {
        assertNotNull(sourceBean);
        assertNotNull(convertedBean);
        assertEquals(sourceBean.getTestBoolean(),
                convertedBean.getTestBoolean());
        assertEquals(sourceBean.getTestbyte(), convertedBean.getTestbyte());
        assertEquals(sourceBean.getTestByte(), convertedBean.getTestByte());
        assertEquals(sourceBean.getTestInteger(),
                convertedBean.getTestInteger());
        assertEquals(sourceBean.getTestint(), convertedBean.getTestint());
        assertEquals(sourceBean.getTestlong(), convertedBean.getTestlong());
        assertEquals(sourceBean.getTestLong(), convertedBean.getTestLong());
        assertEquals(sourceBean.getTestshort(), convertedBean.getTestshort());
        assertEquals(sourceBean.getTestShort(), convertedBean.getTestShort());
        assertEquals(sourceBean.isTestboolean(), convertedBean.isTestboolean());
        assertEquals(sourceBean.getTestdouble(), convertedBean.getTestdouble());
        assertEquals(sourceBean.getTestFloat(), convertedBean.getTestFloat());

        validateTestChildBean(sourceBean.getTestChildBean(),
                convertedBean.getTestChildBean());

        List<String> sourceStrList = sourceBean.getTestList();
        List<String> convStrList = convertedBean.getTestList();
        assertNotNull(sourceStrList);
        assertNotNull(convStrList);

        assertEquals(sourceStrList.size(), convStrList.size());
        int count = sourceStrList.size();
        for (int i = 0; i < count; i++) {
            assertEquals(sourceStrList.get(i), convStrList.get(i));
        }

        List<TestChildBean> srcSourceBeans = sourceBean.getTestGenericList();
        List<TestChildBean> convBeans = convertedBean.getTestGenericList();
        assertNotNull(srcSourceBeans);
        assertNotNull(convBeans);
        assertEquals(srcSourceBeans.size(), convBeans.size());
        count = srcSourceBeans.size();
        for (int i = 0; i < count; i++) {
            validateTestChildBean(srcSourceBeans.get(i), convBeans.get(i));
        }

        Map<String, String> srcSourceMap = sourceBean.getTestMap();
        Map<String, String> convSourceMap = convertedBean.getTestMap();
        validateMap(srcSourceMap, convSourceMap);

        Map<String, TestChildBean> srcMap = sourceBean.getTestGenericMap();
        Map<String, TestChildBean> convMap = convertedBean.getTestGenericMap();
        validateMap(srcMap, convMap);
        assertNotNull(srcMap);
        assertNotNull(convMap);
        assertEquals(srcMap.size(), convMap.size());

        for (String key : srcMap.keySet()) {
            validateTestChildBean(srcMap.get(key), convMap.get(key));
        }
    }

    private void validateMap(Map<String, ? extends Object> srcMap,
            Map<String, ? extends Object> convMap) {
        assertNotNull(srcMap);
        assertNotNull(convMap);
        assertEquals(srcMap.size(), convMap.size());
        for (String key : srcMap.keySet()) {
            Object obj = srcMap.get(key);
            if (obj instanceof TestChildBean) {
                validateTestChildBean((TestChildBean) srcMap.get(key),
                        (TestChildBean) convMap.get(key));
            } else if (obj instanceof TestJsonBean) {
                validateTestJsonBean((TestJsonBean) srcMap.get(key),
                        (TestJsonBean) convMap.get(key));
            } else {
                assertEquals(srcMap.get(key), convMap.get(key));
            }
        }
    }

    private void validateTestChildBean(TestChildBean sourceBean,
            TestChildBean convBean) {
        assertNotNull(sourceBean);
        assertNotNull(convBean);
        assertEquals(sourceBean.getFirstName(), convBean.getFirstName());
        assertEquals(sourceBean.getLastName(), convBean.getLastName());
    }
}
