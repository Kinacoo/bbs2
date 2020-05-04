package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import bean.commentBean;


public class CommentQuery{
    public static List<commentBean> getQueryList(){

        List<commentBean> list = new ArrayList<commentBean>();


        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Oracle�ɐڑ�����
            Connection cn=
                DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","bbs","bbs");
            System.out.println("�ڑ�����");

            //select��
            String sql="SELECT comment_id,com,name FROM comment_table ORDER BY comment_id ASC";

            //Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
            Statement st=cn.createStatement();

            //select�������s��
            //ResultSet�C���^�[�t�F�C�X�����������N���X��
            //�C���X�^���X���Ԃ�
            ResultSet rs=st.executeQuery(sql);

            //�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
            while(rs.next()){
                commentBean cb = new commentBean();

                int comment_id = rs.getInt(1);	//1��ڂ̃f�[�^���擾
                String comment = rs.getString(2);	//2��ڂ̃f�[�^���擾
                String name = rs.getString(3);	//3��ڂ̃f�[�^���擾
                
                System.out.println("comment_id="+comment_id);
                cb.setComment_id(comment_id);
                cb.setName(name);
                cb.setComment(comment);
                
                list.add(cb);

            }


            //Oracle����ؒf����
            cn.close();

            System.out.println("�ؒf����");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("�N���X���Ȃ��݂����B");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("SQL�֘A�̗�O�݂����B");
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }
}











