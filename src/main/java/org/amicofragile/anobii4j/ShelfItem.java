package org.amicofragile.anobii4j;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShelfItem {
	@XmlAttribute(name = "id")
	private String id;
	@XmlAttribute(name = "progress")
	private String progress;
	@XmlAttribute(name = "start_date")
	private String startDate;
	@XmlAttribute(name = "end_date")
	private String endDate;

	public String getId() {
		return id;
	}

	public String getProgress() {
		return progress;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "ShelfItem [id=" + id + ", progress=" + progress
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
