package sec01_exam;

public class MemberDto {
	
	// 각 DB에 있는 내용을 클래스로 한번에 보기 좋게 가져오는 객체
	private String id;
	private String pw;
	private String name;
	private String eMail;
	private String rDate;
	private String address;
	
	public MemberDto() {
		
	}
	
	// 매개변수가 있는 생성자
	public MemberDto(String id, String pw, String name, String eMail, String rDate, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.eMail = eMail;
		this.rDate = rDate;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
