package com.soft.model.modelImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.soft.beans.LoginBean;
import com.soft.beans.OperatorBean;
import com.soft.beans.RecordBean;
import com.soft.beans.UserBean;
import com.soft.dao.OperatorBeanMapper;
import com.soft.dao.PriceBeanMapper;
import com.soft.dao.RecordBeanMapper;
import com.soft.dao.UserBeanMapper;
import com.soft.model.IService;
import com.soft.utils.MyUtils;

//@Service
@Component
public class ServiceImpl implements IService {
	// 通过spring依赖注入注入dao层接口
	@Resource
	private UserBeanMapper userDao;
	@Resource
	private OperatorBeanMapper operatorDao;
	@Resource
	private RecordBeanMapper recordDao;
	@Resource
	private PriceBeanMapper priceDao;

	@Override
	public Object login(LoginBean user) {

		// 用户为1，操作员为2
		if (user.getLoginType() == 1) {
			UserBean loginUser = userDao.loginQuery(user);
			if (loginUser != null) {
				return loginUser;
			}
		} else {
			OperatorBean loginOperator = operatorDao.loginQuery(user);
			if (loginOperator != null) {
				return loginOperator;
			}
		}
		return null;
	}

	@Override
	public int operatorAdd(OperatorBean operator) {
		// 执行插入语句
		int i = operatorDao.insertSelective(operator);
		return i;
	}

	@Override
	public List<OperatorBean> operatorQuery(OperatorBean operator) {
		// 查询管理员集合
		List<OperatorBean> list = operatorDao.operatorQuery(operator);
		// 返回结果集
		return list;
	}

	@Override
	public int operatorDel(OperatorBean operator) {
		// 删除操作员
		int isDelete = operatorDao.deleteByPrimaryKey(operator.getOperatorId());
		// 1删除成功
		return isDelete;
	}

	@Override
	public int operatorEdit(OperatorBean operator) {
		// 修改操作员
		int isUpdate = operatorDao.updateByPrimaryKeySelective(operator);
		// 1修改成功
		return isUpdate;
	}

	// 用户修改密码
	@Override
	public int userModifyPsw(String userId, String userPsw) {
		// 将得到的用户名和密码封装到user中
		UserBean user = MyUtils.getNewInstance(UserBean.class);
		user.setUserId(userId);
		user.setUserPsw(userPsw);
		// 执行修改密码操作
		int i = userDao.updateByPrimaryKeySelective(user);
		// 1修改成功
		return i;
	}

	// 查询用户消费详情
	@Override
	public List<RecordBean> userQureyRecord(String userId) {
		// 按照用户的id进行数据库查询
		List<RecordBean> recordList = recordDao.queryRecord(userId);
		// 返回查询结果集
		return recordList;
	}

	// 查询单个用户信息
	@Override
	public UserBean userQuery(String userId) {
		// 通过主键查询用户
		UserBean userBean = userDao.selectByPrimaryKey(userId);
		// 返回查找到的用户
		return userBean;
	}

	// 用户充值的方法
	// 操作员进行充值
	@Override
	public int userRecharge(RecordBean recharge, String userName) {
		// 判断用户名和账户是否对应，避免充值出错
		// 通过主键查询用户
		UserBean userBean = userDao.selectByPrimaryKey(recharge.getUserId());
		if (userBean == null || !userBean.getUserId().equals(recharge.getUserId())
				|| !userBean.getUserName().equals(userName)) {
			return 0;
		}
		/// 按照用户id查询账单余额
		List<RecordBean> recordList = recordDao.queryRecord(recharge.getUserId());
		// 封装参数
		Double used = 0.0;
		BigDecimal remain = recharge.getRemain();
		if (recordList != null && recordList.size() > 0) {
			RecordBean record = recordList.get(0);
			remain = record.getRemain().add(recharge.getMoney());
		}
		// 对recharge进行设值
		recharge.setUsed(used);
		recharge.setRemain(remain);
		recharge.setRecordId(String.valueOf(new Date().getTime()));
		// 进行插入操作，1成功
		int i = recordDao.insertSelective(recharge);
		return i;
	}

	@Override
	public OperatorBean operatorQuery(String operatorId) {
		OperatorBean operator = operatorDao.selectByPrimaryKey(operatorId);
		return operator;
	}

	@Override
	public int operatorModifyPsw(String operatorId, String newPsw) {
		// 将得到的用户名和密码封装到user中
		OperatorBean operator = MyUtils.getNewInstance(OperatorBean.class);
		operator.setOperatorId(operatorId);
		operator.setOperatorPsw(newPsw);
		// 执行修改密码操作
		int i = operatorDao.updateByPrimaryKeySelective(operator);
		// 1修改成功
		return i;
	}

	/*
	 * 开户
	 */
	@Override
	public int operatorCreateUser(UserBean user) {
		int i = userDao.insertSelective(user);
		return i;
	}

	/*
	 * 查询所有用户
	 */
	@Override
	public List<UserBean> QueryUserList() {
		List<UserBean> userList = userDao.QueryUserList();
		return userList;
	}

	@Override
	public int userDelete(String userId) {
		int i = userDao.deleteByPrimaryKey(userId);
		return i;
	}

	@Override
	public int userModifyInfo(UserBean user) {
		int i = userDao.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	public int userUse(RecordBean userUse) {
		List<RecordBean> recordList = recordDao.queryRecord(userUse.getUserId());
		Double price = priceDao.price();

		BigDecimal money = new BigDecimal(userUse.getUsed() * price * -1);
		if (recordList != null && recordList.size() > 0) {
			RecordBean record = recordList.get(0);
			BigDecimal remain = record.getRemain().add(money);
			userUse.setRemain(remain);
		}
		// 对userUse进行设值
		userUse.setRecordId(String.valueOf(new Date().getTime()));
		userUse.setMoney(money);
		// 进行插入操作，1成功
		int i = recordDao.insertSelective(userUse);
		return i;
	}

	@Override
	public List<RecordBean> ZheXianTu(String userId) {
		List<RecordBean> list = recordDao.select4ZheXianTu(userId);
		return list;
	}

}
