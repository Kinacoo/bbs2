package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentInsert{

    public static int insert(String name,String comment){
        int count = 0; //処理した行数を入れるための変数
        try{
            if(name==null||name.length()==0){
                name="名無しさん";
            }
            //Driverインターフェイスを実装するクラスをロードする
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Connectionインターフェイスを実装するクラスの
            //インスタンスを返す
            Connection cn=
                DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","bbs","bbs");//ユーザーーーーーーーーーーーーーーーーーー

            //自動コミットをOFFにする
            cn.setAutoCommit(false);

            System.out.println("接続完了");

            //SQL文を変数に格納する
            String sql="INSERT INTO comment_table(comment_id,com,name)VALUES(comment_seq.NEXTVAL,'"+comment+"','"+name+"')";

            System.out.println("sql"+sql);

            //Statementインターフェイスを実装するクラスの
            //インスタンスを取得する
            Statement st=cn.createStatement();

            //SQLを実行しトランザクションが開始される。処理件数が返される
            count=st.executeUpdate(sql);

            System.out.println(count+"件処理完了");
            

            //トランザクションをコミットする
            cn.commit();

            //ステートメントをクローズする
            st.close();

            //RDBMSから切断する
            cn.close();

            System.out.println("切断完了");
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
}


