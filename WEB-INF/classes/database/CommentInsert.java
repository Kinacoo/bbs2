package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentInsert{

    public static int insert(String name,String comment){
        int count = 0; //���������s�������邽�߂̕ϐ�
        try{
            if(name==null||name.length()==0){
                name="����������";
            }
            //Driver�C���^�[�t�F�C�X����������N���X�����[�h����
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Connection�C���^�[�t�F�C�X����������N���X��
            //�C���X�^���X��Ԃ�
            Connection cn=
                DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","bbs","bbs");//���[�U�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[

            //�����R�~�b�g��OFF�ɂ���
            cn.setAutoCommit(false);

            System.out.println("�ڑ�����");

            //SQL����ϐ��Ɋi�[����
            String sql="INSERT INTO comment_table(comment_id,com,name)VALUES(comment_seq.NEXTVAL,'"+comment+"','"+name+"')";

            System.out.println("sql"+sql);

            //Statement�C���^�[�t�F�C�X����������N���X��
            //�C���X�^���X���擾����
            Statement st=cn.createStatement();

            //SQL�����s���g�����U�N�V�������J�n�����B�����������Ԃ����
            count=st.executeUpdate(sql);

            System.out.println(count+"����������");
            

            //�g�����U�N�V�������R�~�b�g����
            cn.commit();

            //�X�e�[�g�����g���N���[�Y����
            st.close();

            //RDBMS����ؒf����
            cn.close();

            System.out.println("�ؒf����");
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
}


