package com.zuehlke.cleancodeworkshop.flagparameter;

/**
 * Demonstration of Flag Parameters
 *
 * @author min
 */
public class FileWriter {

	private String content;
	private boolean isInAppendMode;
	private boolean isContentFlushed;

	public FileWriter(final String newContent, final boolean useAppendMode) {

		this.content = newContent;
		this.isInAppendMode = useAppendMode;
		this.isContentFlushed = false;
	}

	public void write(final String contentToWrite, final boolean isFlushContent) {

		if (isInAppendMode) {
			content += contentToWrite;
		} else {
			content = contentToWrite;
		}

		if (isFlushContent) {
			setFlushContent();
		}
	}

	public void setFlushContent() {
		isContentFlushed = true;
	}

	public String getContent() {
		return content;
	}

	public boolean isContentFlushed() {
		return isContentFlushed;
	}
}
