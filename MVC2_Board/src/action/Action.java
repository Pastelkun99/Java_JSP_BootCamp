package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

// ���� ��û�� �����ϴ� ǥ���� �Ǵ� Action�������̽��� ����
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
