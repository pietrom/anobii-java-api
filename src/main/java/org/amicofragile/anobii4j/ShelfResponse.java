package org.amicofragile.anobii4j;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shelf")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShelfResponse {
	@XmlAttribute(name = "user_id")
	private String username;
	
	@XmlAttribute(name = "type")
	private String type;
	
	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	private List<ShelfItem> items;
	
	public String getUsername() {
		return username;
	}
	
	public String getType() {
		return type;
	}
	
	public List<ShelfItem> getItems() {
		return items;
	}
	
	public void setItems(List<ShelfItem> items) {
		this.items = items;
	}
}
