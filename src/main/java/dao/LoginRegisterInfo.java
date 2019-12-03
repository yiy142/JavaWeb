package dao;
import entity.Users;
import util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.swing.*;
import java.util.List;

public class LoginRegisterInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    private HibernateSessionFactory getSession;

    public LoginRegisterInfo() {

    }

    public String saveInfo(Users user) {
        String mess = "error";
        getSession = new HibernateSessionFactory();
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            mess = "success";
            return mess;
        } catch (Exception e) {
            message("RegisterInfo error:" + e);
            e.printStackTrace();
            return null;
        }
    }

    public List<Users> queryInfo(String type, Object value) {
        getSession = new HibernateSessionFactory();
        session = HibernateSessionFactory.getSession();
        try {
            String sql = "from entity.Users as u where u.userName=?";
            query = session.createQuery(sql);
            query.setParameter(0, value);
            List<Users> list = query.list();
            transaction = session.beginTransaction();
            transaction.commit();
            return list;
        } catch (Exception e) {
            message("LoginRegisterInfo error:" + e);
            e.printStackTrace();
            return null;
        }
    }

    private void message(String mess) {
        int type = JOptionPane.YES_NO_OPTION;
        String title = "提示信息";
        JOptionPane.showMessageDialog(null, mess, title, type);
    }
}
