package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class ReportSet {
	private String id;
	private List<String> reports;
	private String inherited;
	// configuration element per XSD <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>
	// this may be a free form area to map
}
