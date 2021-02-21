package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import com.exam.controller.admin.notice.AdminNoticeBoardController;
import com.exam.controller.admin.notice.AdminNoticeContentController;
import com.exam.controller.admin.notice.AdminNoticeDeleteController;
import com.exam.controller.admin.notice.AdminNoticeModifyFormController;
import com.exam.controller.admin.notice.AdminNoticeModifyProController;
import com.exam.controller.admin.notice.AdminNoticeWriteFormController;
import com.exam.controller.admin.notice.AdminNoticeWriteProController;
import com.exam.controller.admin.user.AdminJoinController;
import com.exam.controller.admin.user.AdminJoinProController;
import com.exam.controller.admin.user.AdminUserBoardController;
import com.exam.controller.admin.user.AdminUserDeleteController;
import com.exam.controller.cart.*;
import com.exam.controller.comment.*;
import com.exam.controller.file.*;
import com.exam.controller.menu.*;
import com.exam.controller.service.ServiceBoardController;
import com.exam.controller.service.ServiceContentController;
import com.exam.controller.service.ServiceDeleteController;
import com.exam.controller.service.ServiceModifyFormController;
import com.exam.controller.service.ServiceModifyProController;
import com.exam.controller.service.ServiceReplyFormController;
import com.exam.controller.service.ServiceReplyProController;
import com.exam.controller.service.ServiceWriteFormController;
import com.exam.controller.service.ServiceWriteProController;
import com.exam.controller.user.*;

//��Ʈ�ѷ����� �����ڸ� �����̺����� ���߰� ���Ͱ����ϱ� �� ���ٴϱ� �̱������� ������
public class ControllerFactory {
	/* �̱���, ���������� �ֳ����̼� �Ѱ��� �ذᰡ�� */
	private static ControllerFactory instance = new ControllerFactory();

	public static ControllerFactory getInstance() {
		return instance;
	}
	////////////////////////////////////////////////////////////
	private Map<String, Controller> map = new HashMap<>();

	private ControllerFactory() {
		// Ű���� .do�� ������ ��û URL�ּ��� �Ϻ� - ��ɾ�

		// ��ɾ�� ��ɾ ó���ϴ� ��Ʈ�ѷ� ��ü�� ������ ���
		// ����ڷκ��� "" �̷��� ��û�̿��� new ~ �� ����ȴ�!
		map.put("/index", new IndexController());

		// user
		map.put("/userJoin", new UserJoinController());
		map.put("/joinIdDupCheck", new JoinIdDupCheckController());
		map.put("/userJoinPro", new UserJoinProController());
		map.put("/userLogin", new UserLoginController());
		map.put("/userLoginPro", new UserLoginProController());
		map.put("/userLogout", new UserLogoutController());
		map.put("/MyPage", new MyPageController());
		map.put("/UserUpdate", new UserUpdateController());
		map.put("/UserUpdatePro", new UserUpdateProController());
		map.put("/UserDelete", new UserDeleteController());
		// admin/user
		map.put("/adminJoin", new AdminJoinController());
		map.put("/adminJoinPro", new AdminJoinProController());
		map.put("/adminUserBoard", new AdminUserBoardController());
		map.put("/adminUserDelete", new AdminUserDeleteController());
		// admin/notice
		map.put("/adminNoticeBoard", new AdminNoticeBoardController());
		map.put("/adminNoticeWriteForm", new AdminNoticeWriteFormController());
		map.put("/adminNoticeWritePro", new AdminNoticeWriteProController());
		map.put("/adminNoticeContent", new AdminNoticeContentController());
		map.put("/adminNoticeDelete", new AdminNoticeDeleteController());
		map.put("/adminNoticeModifyForm", new AdminNoticeModifyFormController());
		map.put("/adminNoticeModifyPro", new AdminNoticeModifyProController());


		// fileBoard �ڷ�� �Խ���
		map.put("/fileWriteForm", new FileWriteFormController());
		map.put("/fileWritePro", new FileWriteProController());
		map.put("/fileContent", new FileContentController());
		map.put("/fileboard", new FileBoardController());
		map.put("/fileDelete", new FileDeleteController());
		map.put("/fileModifyForm", new FileModifyFormController());
		map.put("/fileModifyPro", new FileModifyProController());
		map.put("/fileBoard", new FileBoardController());
		// fileBoard �ڷ�� �Խ����� ��۳��
		map.put("/jsonCommentInsert", new CommentInsertController());
		map.put("/jsonCommentGet", new CommentGetController());


		// serviceNotice �ڷ�� �Խ���
		map.put("/serviceBoard", new ServiceBoardController());
		map.put("/serviceWriteForm", new ServiceWriteFormController());
		map.put("/serviceWritePro", new ServiceWriteProController());
		map.put("/serviceContent", new ServiceContentController());
		map.put("/serviceDelete", new ServiceDeleteController());
		map.put("/serviceModifyForm", new ServiceModifyFormController());
		map.put("/serviceModifyPro", new ServiceModifyProController());

		map.put("/serviceReplyForm", new ServiceReplyFormController());
		map.put("/serviceReplyPro", new ServiceReplyProController());

		// bueno
		map.put("/menuCategory", new MenuCategoryController());
		map.put("/menuCategoryPost", new MenuCategoryPostController());
		map.put("/menuSinglePost", new MenuSinglePostController());
		map.put("/menuReceipe", new MenuReceipeController());
		map.put("/menuContact", new MenuContactController());

		// cart
		map.put("/cartView", new CartController());
		map.put("/wishView", new WishController());
		map.put("/shopMain", new shopMainController());
		map.put("/CartProcess", new CartProController());
		map.put("/WishProcess", new WishProController());
		map.put("/UserCartProcess", new UserCartProController());
		map.put("/UserWishProcess", new UserWishProController());
		map.put("/CartClear", new CartClearController());
		map.put("/WishClear", new WishClearController());
		map.put("/westernFood", new westernFoodController());
		map.put("/japaneseFood", new japaneseFoodController());
		map.put("/chineseFood", new chineseFoodController());
		map.put("/payment", new PaymentController());
		map.put("/payment2", new PaymentController2());
		map.put("/kakao", new KakaoController());
		map.put("/orderListPro", new OrderListProController());
		map.put("/orderList", new OrderListController());
		map.put("/orderPage", new OrderpageController());
		map.put("/nonUserOrderPage", new NonUserOrderPageController());
		map.put("/detailProcess", new detailProController());

	} // ������

	public Controller getController(String command) {
		// Map �÷���: Ű������, ���������ʴ� ���� ������ null�� ������
		Controller controller = map.get(command);
		return controller;
	}
}