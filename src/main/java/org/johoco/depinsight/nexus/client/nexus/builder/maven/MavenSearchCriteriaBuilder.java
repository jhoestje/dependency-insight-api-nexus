package org.johoco.depinsight.nexus.client.nexus.builder.maven;

import org.apache.commons.lang3.StringUtils;
import org.johoco.depinsight.nexus.client.nexus.MavenSearchCriteria;
import org.johoco.depinsight.nexus.client.nexus.SearchParams;
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
			sbUrl.append(SearchParams.Q.getParam()).append("=").append(values.getQ()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getGroupId())) {
			sbUrl.append(SearchParams.MAVEN_GROUPID.getParam()).append("=").append(values.getGroupId()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getArtifactId())) {
			sbUrl.append(SearchParams.MAVEN_ARTIFACTID.getParam()).append("=").append(values.getArtifactId()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getBaseVersion())) {
			sbUrl.append(SearchParams.MAVEN_BASEVERSION.getParam()).append("=").append(values.getBaseVersion()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getExtension())) {
			sbUrl.append(SearchParams.MAVEN_EXTENSION.getParam()).append("=").append(values.getExtension()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getClassifier())) {
			sbUrl.append(SearchParams.MAVEN_CLASSIFIER.getParam()).append("=").append(values.getClassifier()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getRepository())) {
			sbUrl.append(SearchParams.REPOSITORY.getParam()).append("=").append(values.getRepository()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getFormat())) {
			sbUrl.append(SearchParams.FORMAT.getParam()).append("=").append(values.getFormat()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getGroup())) {
			sbUrl.append(SearchParams.GROUP.getParam()).append("=").append(values.getGroup()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getName())) {
			sbUrl.append(SearchParams.NAME.getParam()).append("=").append(values.getName()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getVersion())) {
			sbUrl.append(SearchParams.VERSION.getParam()).append("=").append(values.getVersion()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getMd5())) {
			sbUrl.append(SearchParams.MD5.getParam()).append("=").append(values.getMd5()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getSha1())) {
			sbUrl.append(SearchParams.SHA1.getParam()).append("=").append(values.getSha1()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getSha256())) {
			sbUrl.append(SearchParams.SHA256.getParam()).append("=").append(values.getSha256()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getSha512())) {
			sbUrl.append(SearchParams.SHA512.getParam()).append("=").append(values.getSha512()).append(separator);
		}
		if (StringUtils.isNotBlank(values.getPrerelease())) {
			sbUrl.append(SearchParams.PRERELEASE.getParam()).append("=").append(values.getPrerelease()).append(separator);
		}

		String url = sbUrl.toString();

		if (StringUtils.isNotBlank(url)) {
			url = StringUtils.removeEnd(url, separator);
		}

		return url;
	}

}
