package com.wudouli.scopes;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class HelloBeanForApplicationScoped implements Serializable {
 
    public int commitTimes = 0;
    private String name;
 
    public String doSomething(){
        commitTimes++;
        return "welcomeForApplicationScoped";
    }
 
    public int getCommitTimes() {
        return commitTimes;
    }
 
    public void setCommitTimes(int commitTimes) {
        this.commitTimes = commitTimes;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}
