package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
import com.baizhi.utils.Md5SaltTool;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/*
 *用来创建Service层的组件对象
 * */
@Service
@Transactional
/*作用：用来控制事务的
 * 修饰范围：既可以写在类上，也可以加载方法上
 * */
public class UserServiceImpl implements UserService {
    /*注入MenuDao*/
    @Autowired
    private UserDao userDao;
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.insert(user);
    }
    @Override
    public void remove(String id) {
        userDao.delete(id);
    }

    @Override
    public void removeAll(String[] ids) {
        userDao.deleteAll(ids);
    }

    @Override
    public void motify(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findBypage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return userDao.findBypage(start,rows);
    }

    @Override
    public User login(String phone,String password) {
        User user = userDao.queryByPhone(phone,password);
        return user;

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return userDao.findTotals();
    }
}
