package com.baizhiedu.basic;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;//通过工厂类解Service层的耦合

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.save(user);
    }
    public void login(String username,String password){
        userDAO.queryUserByNameAndPassword(username,password);
    }
}
