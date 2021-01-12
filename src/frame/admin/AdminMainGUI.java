package frame.admin;

import bean.Admin;
import util.BaseJFrame;
import activity.LoginActivity;
import handle.HandleSQL;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 管理员主界面
 */
public class AdminMainGUI extends BaseJFrame implements TreeSelectionListener {

    private Admin admin;
    private JPanel contentPane;
    private DefaultMutableTreeNode menu; //菜单
    private DefaultMutableTreeNode myInformationNode;  //我的信息
    private DefaultMutableTreeNode informationNode; //查询信息
    private DefaultMutableTreeNode changeInfoNode;  //修改信息
    private DefaultMutableTreeNode changePassNode;  //修改密码

    private DefaultMutableTreeNode gradeManageNode; //成绩管理
    private DefaultMutableTreeNode gradeArrangeNode;  //管理学生成绩

    private DefaultMutableTreeNode stuTeaManageNode;  //师生管理
    private DefaultMutableTreeNode stuArrNode;  //学生管理
    private DefaultMutableTreeNode stuAddNode;  //学生管理
    private DefaultMutableTreeNode teaArrNode;  //老师管理
    private DefaultMutableTreeNode teaAddNode;  //老师管理

    private JTree tree; //左侧树结构
    private JPanel panel; //右侧面板
    private SimpleDateFormat sdf;
    private Timer timer;
    private JToolBar statusbar; //状态栏
    private JLabel lbl_userInfo; //用户信息
    private JLabel lbl_operator; //当前操作
    private JLabel lbl_time; //时间显示
    private JButton btn_exit; //退出按钮

    public AdminMainGUI(Admin admin) {
        super("管理员界面","./src/pictures/admin.png");
        this.admin = admin;
        initView();
        btn_exit.addActionListener(e -> handle_exit());
    }

    public void initView(){
        menu = new DefaultMutableTreeNode("菜单");
        myInformationNode = new DefaultMutableTreeNode("我的信息");  //我的信息
        informationNode = new DefaultMutableTreeNode("查询信息");//查询信息
        changeInfoNode = new DefaultMutableTreeNode("修改信息");//修改信息
        changePassNode = new DefaultMutableTreeNode("修改密码");  //修改密码

        gradeManageNode = new DefaultMutableTreeNode("成绩管理"); //成绩管理
        gradeArrangeNode = new DefaultMutableTreeNode("管理学生成绩");  //管理学生成绩

        stuTeaManageNode = new DefaultMutableTreeNode("师生管理");  //师生管理
        stuArrNode = new DefaultMutableTreeNode("学生管理");  // 学生管理
        stuAddNode = new DefaultMutableTreeNode("添加学生");  // 添加学生
        teaArrNode = new DefaultMutableTreeNode("老师管理");  // 老师管理
        teaAddNode = new DefaultMutableTreeNode("添加老师");  // 添加老师

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        myInformationNode.add(informationNode);
        myInformationNode.add(changeInfoNode);
        myInformationNode.add(changePassNode);
        menu.add(myInformationNode);

        gradeManageNode.add(gradeArrangeNode);
        menu.add(gradeManageNode);

        stuTeaManageNode.add(stuAddNode);
        stuTeaManageNode.add(stuArrNode);
        stuTeaManageNode.add(teaAddNode);
        stuTeaManageNode.add(teaArrNode);
        menu.add(stuTeaManageNode);

        tree = new JTree(menu);
        tree.setFont(new Font("楷体", Font.PLAIN, 20));
        tree.setBounds(0, 0, 230, 535);
        tree.addTreeSelectionListener(this);
        contentPane.add(tree);

        statusbar = new JToolBar();
        statusbar.setFont(new Font("宋体", Font.PLAIN, 20));
        statusbar.setSize(1290, 25);
        statusbar.setLocation(0, 660);
        statusbar.setLayout(new BorderLayout());

        btn_exit = new JButton("退出");
        btn_exit.setBackground(new Color(5, 46, 248));
        btn_exit.setForeground(Color.WHITE);
        btn_exit.setFont(new Font("黑体", Font.PLAIN, 20));
        btn_exit.setBounds(20, 600, 97, 33);
        contentPane.add(btn_exit);

        lbl_userInfo = new JLabel();
        lbl_userInfo.setText("(用户名:)" + admin.getMno() + "   (用户姓名:)" + HandleSQL.getAdnName(admin.getMno()));
        lbl_userInfo.setFont(new Font("宋体", Font.PLAIN, 20));
        statusbar.add(lbl_userInfo, BorderLayout.WEST);

        lbl_operator = new JLabel();
        lbl_operator.setHorizontalAlignment(JLabel.CENTER);
        lbl_operator.setText("(当前操作:)");
        lbl_operator.setFont(new Font("宋体", Font.PLAIN, 20));
        statusbar.add(lbl_operator, BorderLayout.CENTER);

        sdf = new SimpleDateFormat("(时间:) yyyy/MM/dd HH:mm:ss");
        lbl_time = new JLabel();
        lbl_time.setText(sdf.format(new Date()));
        lbl_time.setFont(new Font("宋体", Font.PLAIN, 20));
        statusbar.add(lbl_time, BorderLayout.EAST);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                lbl_time.setText(sdf.format(new Date()));
            }

        }, 0, 1000);
        contentPane.add(statusbar, BorderLayout.SOUTH);

        panel = new JPanel();
        panel.setBounds(230, 0, 1200, 550);
        contentPane.add(panel);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();
        contentPane.remove(panel);
        lbl_operator.setText("(当前操作:)" + node.toString());
        if (node == informationNode) {  //查询信息
            EventQueue.invokeLater(() -> {
                AdminInfoJPanel panel = new AdminInfoJPanel(admin.getMno());
                replaceJPanel(panel);
            });
        }else if(node == changeInfoNode){  //修改信息
            EventQueue.invokeLater(() -> {
                AdminChangeInfoJPanel panel = new AdminChangeInfoJPanel(admin.getMno(),this);
                replaceJPanel(panel);
            });
        }else if(node == changePassNode){  //修改密码
            EventQueue.invokeLater(() -> {
                ChangePasswordJPanel panel = new ChangePasswordJPanel(admin.getMno(),this);
                replaceJPanel(panel);
            });
        }else if(node == gradeArrangeNode){  //成绩管理课程
            EventQueue.invokeLater(() ->{
                GradeSearchJPanel panel = new GradeSearchJPanel(this);
                replaceJPanel(panel);
            });
        }else if(node == stuArrNode){  //学生管理
            StuManageJPanel panel = new StuManageJPanel();
            replaceJPanel(panel);
        }else if(node == stuAddNode){   //添加学生
            StuAddJPanel panel = new StuAddJPanel(this);
            replaceJPanel(panel);
        }else if(node == teaArrNode){  //管理老师
            TeaManageJPanel panel = new TeaManageJPanel();
            replaceJPanel(panel);
        }else if(node == teaAddNode){  //添加老师
            TeaAddJPanel panel = new TeaAddJPanel(this);
            replaceJPanel(panel);
        }
    }

    public void replaceJPanel(JPanel newPanel) {
        panel = newPanel;
        newPanel.setBounds(230, 0, 1200, 650);
        contentPane.add(newPanel);
        contentPane.revalidate();
        repaint();
    }

    private void handle_exit() {
        int n = JOptionPane.showConfirmDialog(this,
                "您确认要退出系统吗?", "确认对话框", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginActivity logingui = new LoginActivity();//返回登录界面
            logingui.setVisible(true);
        }
    }


}
