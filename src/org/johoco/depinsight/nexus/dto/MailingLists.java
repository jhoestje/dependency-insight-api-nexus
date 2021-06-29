package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class MailingLists {
	private String name;
	private String subscribe;
	private String unsubscribe;
	private String post;
	private String archive;
	private String otherArchives;
}
