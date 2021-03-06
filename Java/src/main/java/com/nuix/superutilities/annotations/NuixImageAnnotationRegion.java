package com.nuix.superutilities.annotations;

import org.apache.log4j.Logger;

import nuix.Item;
import nuix.MarkupSet;
import nuix.MutablePrintedImage;
import nuix.MutablePrintedPage;

public class NuixImageAnnotationRegion {
	private static Logger logger = Logger.getLogger(NuixImageAnnotationRegion.class);
	
	private double x = 0.0;
	private double y = 0.0;
	private double width = 0.0;
	private double height = 0.0;
	private String text = "";
	private int pageNumber = 0;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double heigh) {
		this.height = heigh;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	/***
	 * Applies a redaction based on the region defined by this instance.
	 * @param markupSet The markup set to which the redaction markup will be added.
	 * @param item The item to which the redaction will be applied.
	 * @throws Exception If something goes wrong
	 */
	public void applyRedaction(MarkupSet markupSet, Item item) throws Exception {
		logger.info(String.format("Applying redaction based on %s", this));
		MutablePrintedImage printedImage = item.getPrintedImage();
		MutablePrintedPage page = (MutablePrintedPage)printedImage.getPages().get(pageNumber-1);
		page.createRedaction(markupSet, x, y, width, height);
	}
	
	/***
	 * Applies a highlight based on the region defined by this instance.
	 * @param markupSet The markup set to which the highlight markup will be added.
	 * @param item The item to which the highlight will be applied.
	 * @throws Exception If something goes wrong
	 */
	public void applyHighlight(MarkupSet markupSet, Item item) throws Exception {
		logger.info(String.format("Applying highlight based on %s", this));
		MutablePrintedImage printedImage = item.getPrintedImage();
		MutablePrintedPage page = (MutablePrintedPage)printedImage.getPages().get(pageNumber-1);
		page.createHighlight(markupSet, x, y, width, height);
	}

	@Override
	public String toString() {
		return "NuixImageAnnotationRegion [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", text="
				+ text + ", pageNumber=" + pageNumber + "]";
	}
}
