package com.wudouli.scopes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class HelloBeanForViewScoped {

	public int commitTimes = 0;
    private String name;
 
    public String doSomething(){
        commitTimes++;
        return "welcomeForViewScoped";
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
