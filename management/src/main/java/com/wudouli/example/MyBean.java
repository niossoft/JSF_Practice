package com.wudouli.example;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.sun.faces.application.ApplicationAssociate;
import com.sun.faces.mgbean.BeanBuilder;
import com.sun.faces.mgbean.BeanManager;


@ManagedBean(name = "myBean", eager = true)
public class MyBean {
	
    // Init ----------------------------------------------------------------------------------------

    private HtmlInputText inputComponent;
    private String inputValue;
    private HtmlOutputText outputComponent;
    private String outputValue;

    // Constructors --------------------------------------------------------------------------------
    public MyBean() {
    	testBeanManager();
        log("constructed");
    }

    // Actions -------------------------------------------------------------------------------------
    public void inputChanged(ValueChangeEvent event) {
        log(event.getOldValue() + " to " + event.getNewValue());
    }

    public void action() {
        outputValue = inputValue;
        log(" Success");
    }
    
	public void testBeanManager() {
		ApplicationAssociate application = ApplicationAssociate
				.getInstance(FacesContext.getCurrentInstance().getExternalContext());
		BeanManager beanManager = application.getBeanManager();
		Map<String, BeanBuilder> beanMap = beanManager.getRegisteredBeans();
		Set<Entry<String, BeanBuilder>> beanEntries = beanMap.entrySet();

		for (Entry<String, BeanBuilder> bean : beanEntries) {
			String beanName = bean.getKey();
			if (beanManager.isManaged(beanName)) {
				BeanBuilder builder = bean.getValue();
				System.out.println("----- Bean name: " + beanName);
				System.out.println("----- Bean class: " + builder.getBeanClass());
				System.out.println("----- Bean scope: " + builder.getScope());
			}
		}
	}

    // Getters/setters ----------------------------------------------------------------------------
    public HtmlInputText getInputComponent() {
        log(inputComponent);
        return inputComponent;
    }

    public void setInputComponent(HtmlInputText inputComponent) {
        log(inputComponent);
        this.inputComponent = inputComponent;
    }

    public String getInputValue() {
        log(inputValue);
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        log(inputValue);
        this.inputValue = inputValue;
    }

    public HtmlOutputText getOutputComponent() {
        log(outputComponent);
        return outputComponent;
    }

    public void setOutputComponent(HtmlOutputText outputComponent) {
        log(outputComponent);
        this.outputComponent = outputComponent;
    }

    public String getOutputValue() {
        log(outputValue);
        return outputValue;
    }

    // Helpers ------------------------------------------------------------------------------------
    private void log(Object object) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("MyBean " + methodName + ": " + object);
    }
}
