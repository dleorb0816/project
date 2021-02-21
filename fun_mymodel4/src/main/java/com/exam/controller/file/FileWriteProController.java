package com.exam.controller.file;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.controller.Controller;
import com.exam.dao.AttachMyBatisDao;
import com.exam.dao.JdbcUtils;
import com.exam.dao.FileMyBatisDao;
import com.exam.vo.AttachVo;
import com.exam.vo.FileVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileWriteProController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileWriteProController......");

		// ���� ���ε� ���ؼ� cos.jar ���̺귯���� ������Ʈ �����н��� �߰�.

		//���ε� ��ü �����Ҷ� �ʿ��� ���ڰ�
		//1. request
		//2. ���ε� �� ������ ������ ���
		//3. ���ε� �ִ� ũ�� ����
		//4. ���ϸ� �ѱ�ó�� utf-8
		//5. ���ϸ� �ߺ��ɶ� �̸������Ģ ���� ��ü�� ����

		//���ε� �� ���� ������ ��� ���ϱ�
		ServletContext application = request.getServletContext(); // application ��ü ���� ���ϱ�
		String realPath = application.getRealPath("/upload1");
		System.out.println("realPath : " + realPath);

		// ���ó�¥ ����� ������ �����ϴ��� Ȯ���ؼ� ������ �����ϱ�
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = sdf.format(date); // "2020/11/11"

		File dir = new File(realPath, strDate);
		System.out.println("dir : " + dir.getPath());

		if (!dir.exists()) {
			dir.mkdirs();
		}


		//���� ���ε� �ϱ�
		MultipartRequest multi = new MultipartRequest(
				request,
				dir.getPath(),
				1024 * 1024 * 100, // �ִ� ���ε� 100MB�� ����
				"utf-8",
				new DefaultFileRenamePolicy());

		//enctype="multipart/form-data" �� ���۹�����
		//�⺻���尴ü�� request���� �Ķ���Ͱ��� �ٷ� ã���� ����!
		//MultipartRequest ��ü�κ��� �Ķ���Ͱ��� ã�ƾ� ��! ������� ������.

		//post �Ķ���Ͱ� �ѱ�ó���� ���� �����ڿ��� ó���ϱ� ������ ���ʿ� ����!
		//request.setCharacterEncoding("utf-8");

		//pageNum �Ķ���Ͱ� ��������
		String pageNum = multi.getParameter("pageNum");


		//DAO ��ü �غ�
		FileMyBatisDao fileDao = FileMyBatisDao.getInstance();
		AttachMyBatisDao attachDao = AttachMyBatisDao.getInstance();

		int nextNum = JdbcUtils.getNextNum("bnotice");

		//Enumeration�� �ݺ��� ��ü. file�� name�Ӽ����� ������ ����
		Enumeration<String> enu = multi.getFileNames();

		while (enu.hasMoreElements()) {
			// AttachVo ��ü �غ�
			AttachVo attachVo = new AttachVo();

			String fname = enu.nextElement();
			// ���� ���ε�� ���ϸ� ��������
			String filename = multi.getFilesystemName(fname);
			System.out.println("�������ϸ� : " + filename);

			attachVo.setFilename(filename); // �������ϸ��� VO�� ����
			attachVo.setUploadpath(strDate); // "��/��/��" ��θ� ����
			attachVo.setNoNum(nextNum);  // insert�� �Խ��� �۹�ȣ�� ����
			if(filename != null) {
				attachVo.setImage( isImage(filename) ? "I" : "O" );
			}


			// attachVo�� attach ���̺� insert�ϱ�
			attachDao.insertAttach(attachVo);
		} // while



		//VO ��ü �غ�
		FileVo fileVo = new FileVo();

		//�Ķ���Ͱ� �����ͼ� VO�� ����. MultipartRequest �κ��� ã��.
		fileVo.setId(multi.getParameter("id"));
		fileVo.setSubject(multi.getParameter("subject"));
		fileVo.setContent(multi.getParameter("content"));

		//�۹�ȣ �����ͼ� VO�� ����
		fileVo.setNum(nextNum);

		//ip  regDate  readcount  �� ����
		fileVo.setIp(request.getRemoteAddr());
		fileVo.setRegDate(new Timestamp(System.currentTimeMillis()));
		fileVo.setReadcount(0);  // ��ȸ��

		//re_ref  re_lev  re_seq
		fileVo.setReRef(nextNum); // �ֱ��϶��� �۹�ȣ�� �׷��ȣ�� ��
		fileVo.setReLev(0); // �ֱ��϶��� �鿩���� ������ 0 (�鿩���� ����)
		fileVo.setReSeq(0); // �ֱ��϶��� �۱׷� ������ ������ 0 (ù��°)


		//�ֱ� noticeVo ����ϱ�
		fileDao.addNotice(fileVo);


		//�۳��� �󼼺��� ȭ�� fileContent.jsp�� �̵�
		//response.sendRedirect("fileContent.jsp?num=" + noticeVo.getNum() + "&pageNum=" + pageNum);
		return "redirect:/fileBoard.do";
	}




	private boolean isImage(String filename) {
		boolean result = false;
		// ���� Ȯ���� ���ڿ� �����ϱ�
		// aaaa.bbb.ccc.ddd
		int index = filename.lastIndexOf(".");
		String ext = filename.substring(index + 1); // ���� Ȯ���� ���ڿ�

		if (ext.equalsIgnoreCase("jpg")
				|| ext.equalsIgnoreCase("jpeg")
				|| ext.equalsIgnoreCase("gif")
				|| ext.equalsIgnoreCase("png")) {
			result = true;
		}
		return result;
	}

}
