package com.playground.database_1;

public class StudentPOJO {
    private String id, name, age, group;

    public  StudentPOJO(String name, String age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getId() { return id; }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
