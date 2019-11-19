package com.wuduoli.management;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userNav", eager = true)
public class UserNav {

	public String submit() {
		return "success";
	}

}