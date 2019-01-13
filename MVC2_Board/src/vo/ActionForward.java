package vo;

// 이동경로를 확인하고 지정해주는 클래스
public class ActionForward {

	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean b) {
		isRedirect = b;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String string) {
		path = string;
	}
	
	
}
