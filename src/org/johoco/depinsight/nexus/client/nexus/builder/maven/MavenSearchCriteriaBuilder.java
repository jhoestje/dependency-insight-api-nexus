package org.johoco.depinsight.nexus.client.nexus.builder.maven;

import org.apache.commons.lang3.StringUtils;
import org.johoco.depinsight.nexus.client.nexus.MavenSearchCriteria;
import org.johoco.depinsight.nexus.client.nexus.builder.SearchCritieriaBuilder;

/**
 * Search values related to Nexus Maven asset searches.
 * 
 * Have a parent class that has common values for all searches and subclass by
 * type? nuget, docker, ...
 * 
 * Is there parameter precedence?
 * 
 * @author John Hoestje
 *
 */
public class MavenSearchCriteriaBuilder extends SearchCritieriaBuilder {

	public String searchBuilder(final MavenSearchCriteria values, final String separator) {
//		super.builder(values, separator);

		StringBuilder sbUrl = new StringBuilder();

		if (StringUtils.isNotBlank(values.getQ())) {
			sbUrl.append(values.getExtension()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getGroupId())) {
			sbUrl.append(values.getGroupId()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getArtifactId())) {
			sbUrl.append(values.getArtifactId()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getBaseVersion())) {
			sbUrl.append(values.getBaseVersion()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getExtension())) {
			sbUrl.append(values.getExtension()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getClassifier())) {
			sbUrl.append(values.getClassifier()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getRepository())) {
			sbUrl.append(values.getRepository()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getFormat())) {
			sbUrl.append(values.getFormat()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getGroup())) {
			sbUrl.append(values.getGroup()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getName())) {
			sbUrl.append(values.getName()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getVersion())) {
			sbUrl.append(values.getVersion()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getMd5())) {
			sbUrl.append(values.getMd5()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getSha1())) {
			sbUrl.append(values.getSha1()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getSha256())) {
			sbUrl.append(values.getSha256()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getSha512())) {
			sbUrl.append(values.getSha512()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getPrerelease())) {
			sbUrl.append(values.getPrerelease()).append(separator);
		}

		String url = sbUrl.toString();

		if (StringUtils.isNotBlank(url)) {
			url = StringUtils.removeEnd(url, separator);
		}

		return url;
	}

}
