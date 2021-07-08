package org.johoco.depinsight.nexus.client.nexus;

public enum SearchParams {

	CONTINUATION_TOKEN("continuationToken"),
	SORT("sort"),
	DIRECTION("direction"),
	TIMEOUT("timeout"),
	Q("q"),
	REPOSITORY("repository"),
	FORMAT("format"),
	GROUP("group"),
	NAME("name"),
	VERSION("version"),
	MD5("md5"),
	SHA1("sha1"),
	SHA256("sha256"),
	SHA512("sha512"),
	PRERELEASE("prerelease"),
	CONAN_BASEVERSION("conan.baseVersion"),
	CONAN_CHANNEL("conan.channel"),
	DOCKER_IMAGENAME("docker.imageName"),
	DOCKER_IMAGETAG("docker.imageTag"),
	DOCKER_LAYERID("docker.layerId"),
	DOCKER_CONTENTDIGEST("docker.contentDigest"),
	MAVEN_GROUPID("maven.groupId"),
	MAVEN_ARTIFACTID("maven.artifactId"),
	MAVEN_BASEVERSION("maven.baseVersion"),
	MAVEN_EXTENSION("maven.extension"),
	MAVEN_CLASSIFIER("maven.classifier"),
	NPM_SCOPE("npm.scope"),
	NUGET_ID("nuget.id"),
	NUGET_TAGS("nuget.tags"),
	P2_PLUGINNAME("p2.pluginName"),
	PYPI_CLASSIFIERS("pypi.classifiers"),
	PYPI_DESCRIPTION("pypi.description"),
	PYPI_KEYWORDS("pypi.keywords"),
	PYPI_SUMMARY("pypi.summary"),
	RUBYGEMS_DESCRIPTION("rubygems.description"),
	RUBYGEMS_PLATFORM("rubygems.platform"),
	RUBYGEMS_SUMMARY("rubygems.summary"),
	RUBYGEMS_ARCHITECTURE("yum.architecture");

	private final String param;

	SearchParams(final String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}

}
