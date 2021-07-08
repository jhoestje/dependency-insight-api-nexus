package org.johoco.depinsight.nexus.exception;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2688430529525836277L;

	NotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
