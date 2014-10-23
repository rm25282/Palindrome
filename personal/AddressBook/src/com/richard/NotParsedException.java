package com.richard;

/**
 * The exception is used to indicate when a line has 
 * been read but not yet parsed NotParsedException.
 */
public class NotParsedException extends RuntimeException {

	/**
	 * Instantiates a new not parsed exception with description.
	 *
	 * @param string the string
	 */
	public NotParsedException(final String string) {
        super(string);
    }

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
