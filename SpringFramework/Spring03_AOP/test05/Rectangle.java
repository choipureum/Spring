package test05.com.edu.entity;


public class Rectangle implements Figure{
	private String title;
	private int width;
	private int height;
	
	public Rectangle() {}

	public Rectangle(String title, int width, int height) {
		super();
		this.title = title;
		this.width = width;
		this.height = height;
	}
	@Override
	public void viewSize() {
		System.out.println(getTitle()+"의 넓이 : "+(getWidth()*getHeight()));
	}
	
	//getter setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [title=" + title + ", width=" + width + ", height=" + height + "]";
	}
	
	
}
