package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class Notifier {
	private String type;
	private String sendOnError; // boolean
	private String sendOnFailure; // boolean
	private String sendOnSuccess; // boolean
	private String sendOnWarning; // boolean
	private String address;
// configuration element <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>
}
