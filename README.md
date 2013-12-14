jsonutil
========

Simple and elegantly converts json to java bean and vice versa. It will just depends on json.jar from json.org. Code footprint is very small and very fast.


In order to use this util your java beans should follow java bean specification like getter should follow respected setter methods.

If your java beans contains any collections like list, set, map etc., they should follow java 1.5 generics. Otherwise collection conversion may go wrong.



Ex: 

    // converting json to java bean
    TestBean testBean = JsonUtil.fromJson(jsonString, TestBean.class);
    //converting Java bean to json
    String jsonString = JsonUtil.toJson(testBean);
    //converting json to java map
    Map<String, String> map = JsonUtil.fromJson(jsonString);
    //converting json to list of java beans
    List<testBean> testBeanList = JsonUtil.fromJson(jsonString, ArrayList.class, TestBean.class)
    
