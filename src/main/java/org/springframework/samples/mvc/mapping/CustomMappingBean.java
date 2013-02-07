package org.springframework.samples.mvc.mapping;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * CustomMappingBean.
 *
 * @author Rene Gielen
 */
@XmlRootElement(name = "customBean")
public class CustomMappingBean {

	private String name = "Jack";

	private int age = 10;

	private Date date = new Date();

	private JavaBean bean = new JavaBean();

	@XmlElement(name = "howOldAmI")
	public int getAge() {
		return age;
	}

	public void setAge( int age ) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public JavaBean getBean() {
		return bean;
	}

	public void setBean( JavaBean bean ) {
		this.bean = bean;
	}
}
